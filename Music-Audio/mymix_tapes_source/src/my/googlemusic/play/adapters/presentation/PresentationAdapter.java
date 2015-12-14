// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import my.googlemusic.play.fragments.manager.PresentationFragment;

public class PresentationAdapter extends FragmentStatePagerAdapter
{

    public PresentationAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
    }

    public int getCount()
    {
        return 4;
    }

    public Fragment getItem(int i)
    {
        return PresentationFragment.newInstance(i);
    }
}
