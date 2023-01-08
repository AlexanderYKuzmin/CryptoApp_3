package com.example.cryptoapp_3

import com.example.cryptoapp_3.data.network.ApiFactory
import com.example.cryptoapp_3.data.network.model.CoinNameContainerDto
import com.example.cryptoapp_3.data.network.model.CoinNameDto
import com.example.cryptoapp_3.data.network.model.CoinNamesListDto
import okhttp3.ResponseBody
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /*@Test
    suspend fun getTest() {

        val apiService = ApiFactory.apiService
        val coinNamesListDto: Call<ResponseBody>

        val testCoinNames = listOf<CoinNameContainerDto>(
            CoinNameContainerDto(CoinNameDto("BTC")),
            CoinNameContainerDto(CoinNameDto("ETH"))
        )

        try {
            coinNamesListDto = apiService.getTopCoinsInfo(limit = 2)
            assertEquals(coinNamesListDto.names?.size, testCoinNames.size)
        } catch (_: java.lang.Exception) {

        }*/
    //}
}