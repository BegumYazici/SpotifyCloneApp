package com.alcsoft.spotifycloneapp1.radios

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alcsoft.spotifycloneapp1.R
import com.alcsoft.spotifycloneapp1.radioModel.Radio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadiosFragment : Fragment() {

    private val radioServicesProvider = RadioServicesProvider()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadPopularRadios()
        loadLocationRadios()
    }

    private fun loadPopularRadios() {

        radioServicesProvider.getRadioService().getPopularRadios().enqueue(object :
            Callback<List<Radio>> {
            override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                Log.v("TEST", "${t.message}")
            }

            override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                Log.v("TEST", "Success getPopularRadios: ${response.body().toString()}")
            }
        })
    }

    private fun loadLocationRadios() {

        radioServicesProvider.getRadioService().getLocationRadios().enqueue(object :
            Callback<List<Radio>> {
            override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                Log.v("TEST", "${t.message}")
            }

            override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                Log.v("TEST", "Success getLocationRadios: ${response.body().toString()}")
            }
        })
    }

    companion object {
        fun newInstance(): Fragment {
            return RadiosFragment()
        }
    }
}