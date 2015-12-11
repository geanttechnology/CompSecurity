// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity, PartageFinDePartieFragment

private class mListOfPartage extends FragmentPagerAdapter
{

    private HashSet mListOfPartage;
    final GameOverActivity this$0;

    public boolean closePartageIfVisible()
    {
        for (Iterator iterator = mListOfPartage.iterator(); iterator.hasNext();)
        {
            if (((PartageFinDePartieFragment)iterator.next()).checkPartageHasClosed())
            {
                return true;
            }
        }

        return false;
    }

    public int getCount()
    {
        return !AkGameFactory.sharedInstance().canShareAwardImage() ? 2 : 3;
    }

    public Fragment getItem(int i)
    {
        PartageFinDePartieFragment partagefindepartiefragment = new PartageFinDePartieFragment();
        partagefindepartiefragment.setIndex(i);
        mListOfPartage.add(partagefindepartiefragment);
        return partagefindepartiefragment;
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = GameOverActivity.this;
        super(fragmentmanager);
        mListOfPartage = new HashSet();
    }
}
