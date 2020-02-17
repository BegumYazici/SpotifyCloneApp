package com.alcsoft.spotifycloneapp1.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alcsoft.spotifycloneapp1.R
import com.alcsoft.spotifycloneapp1.favorites.FavoritesFragment
import com.alcsoft.spotifycloneapp1.radios.RadiosFragment

class MainPageAdapter(context: Context,fragmentManager: FragmentManager, behavior: Int):
    FragmentStatePagerAdapter(fragmentManager,behavior) {

    private val tabs = context.applicationContext.resources.getStringArray(R.array.tabs)

    override fun getItem(position: Int): Fragment {
        return when(position){
            TAB_INDEX_RADIOS -> RadiosFragment.newInstance()
            TAB_INDEX_FAVORITES -> FavoritesFragment.newInstance()
            else -> throw IllegalStateException("Can not find this fragment. Position $position")
        }
    }

    override fun getCount(): Int {       //Radio and Fragment(2)
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position]
    }

    companion object{
        private const val TAB_INDEX_RADIOS = 0
        private const val TAB_INDEX_FAVORITES = 1
    }
}