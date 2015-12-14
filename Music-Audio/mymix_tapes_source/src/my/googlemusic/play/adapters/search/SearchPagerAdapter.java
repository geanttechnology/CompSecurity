// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.search;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import my.googlemusic.play.fragments.manager.NoneFragment;
import my.googlemusic.play.fragments.search.SearchAlbumFragment_v2;
import my.googlemusic.play.fragments.search.SearchUserFragment;

public class SearchPagerAdapter extends FragmentPagerAdapter
{

    private static final String TITLES[] = {
        "Album", "User"
    };
    private SparseArray mRegisteredFragments;

    public SearchPagerAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        mRegisteredFragments = new SparseArray();
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        mRegisteredFragments.remove(i);
        super.destroyItem(viewgroup, i, obj);
    }

    public int getCount()
    {
        return TITLES.length;
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            return NoneFragment.newInstance();

        case 0: // '\0'
            return SearchAlbumFragment_v2.newInstance();

        case 1: // '\001'
            return SearchUserFragment.newInstance();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return TITLES[i];
    }

    public Fragment getRegisteredFragment(int i)
    {
        return (Fragment)mRegisteredFragments.get(i);
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = (Fragment)super.instantiateItem(viewgroup, i);
        mRegisteredFragments.put(i, viewgroup);
        return viewgroup;
    }

}
