package com.example.cryptoapp_3

import retrofit2.Call
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cryptoapp_3.data.network.ApiFactory
import com.example.cryptoapp_3.data.network.model.CoinNameContainerDto
import com.example.cryptoapp_3.data.network.model.CoinNameDto
import okhttp3.ResponseBody

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.cryptoapp_3", appContext.packageName)
    }

    /*suspend fun getTest() {

        val apiService = ApiFactory.apiService

        val call: Call<ResponseBody> = apiService.getTopCoinsInfo(limit = 2)

        val testCoinNames = listOf<CoinNameContainerDto>(
            CoinNameContainerDto(CoinNameDto("BTC")),
            CoinNameContainerDto(CoinNameDto("ETH"))
        )

        //excpectThat()

    }*/
}