// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.poshmark.utils.FragmentPagerAdapter;

// Referenced classes of package com.poshmark.ui.fragments:
//            FeedMotherFragment, MyLikesFragment, PMFragment, FeedFragment, 
//            FindPeopleFragment

private class this._cls0 extends FragmentPagerAdapter
{

    private static final int NUM_PAGES = 3;
    final FeedMotherFragment this$0;

    public int getCount()
    {
        return 3;
    }

    public Fragment getCurrentVisibleFragment()
    {
        return super.getCurrentVisibleFragment();
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            myLikesFragment = (PMFragment)Fragment.instantiate(getActivity(), com/poshmark/ui/fragments/MyLikesFragment.getName());
            myLikesFragment.setUserVisibleHint(false);
            return myLikesFragment;

        case 1: // '\001'
            feedFragment = (PMFragment)Fragment.instantiate(getActivity(), com/poshmark/ui/fragments/FeedFragment.getName());
            feedFragment.setUserVisibleHint(false);
            return feedFragment;

        case 2: // '\002'
            peopleFragment = (PMFragment)Fragment.instantiate(getActivity(), com/poshmark/ui/fragments/FindPeopleFragment.getName());
            break;
        }
        peopleFragment.setUserVisibleHint(false);
        return peopleFragment;
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = FeedMotherFragment.this;
        super(fragmentmanager);
    }
}
