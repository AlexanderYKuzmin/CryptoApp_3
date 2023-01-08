package com.example.cryptoapp_3.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp_3.data.database.AppDatabase
import com.example.cryptoapp_3.data.mapper.CoinMapper
import com.example.cryptoapp_3.data.network.ApiFactory
import com.example.cryptoapp_3.data.workers.RefreshDataWorker
import com.example.cryptoapp_3.domain.CoinInfo
import com.example.cryptoapp_3.domain.CoinRepository
import kotlinx.coroutines.delay
import java.util.jar.Attributes.Name

class CoinRepositoryImpl(
    private val application: Application
) : CoinRepository{

    private val coinInfoDao = AppDatabase.getInstance(application).coinPriceInfoDao()
    private val apiService = ApiFactory.apiService

    private val mapper = CoinMapper()

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return Transformations.map(coinInfoDao.getPriceList()) { list ->
            list.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return Transformations.map(coinInfoDao.getPriceInfoAboutCoin(fromSymbol)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    /*override suspend fun loadData() {
        Log.d("Repository impl", "Start data loading")
        while (true) {
            Log.d("Repository impl", "Cycling...")

            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                print("***********************${topCoins.names?.get(0).toString()}*********************")
                val fSyms = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fSyms)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
                Log.d("Repository impl", "Exception not loading")
            }
            delay(10000)
        }
    }*/

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
                RefreshDataWorker.NAME,
                ExistingWorkPolicy.REPLACE,
                RefreshDataWorker.makeRequest()
            )
    }
}