// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            TutorialFragment

public class aa extends FragmentStatePagerAdapter
{

    private ArrayList a;
    private ViewPager b;

    public aa(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        a = new ArrayList();
    }

    public void a(ViewPager viewpager)
    {
        b = viewpager;
    }

    public void a(TutorialFragment.Tutorial tutorial)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable(com/cyberlink/beautycircle/controller/fragment/TutorialFragment$Tutorial.toString(), tutorial);
        tutorial = new TutorialFragment();
        tutorial.setArguments(bundle);
        a(((TutorialFragment) (tutorial)));
    }

    public void a(TutorialFragment tutorialfragment)
    {
        a.add(tutorialfragment);
        notifyDataSetChanged();
        b.setCurrentItem(getCount() - 1, true);
    }

    public int getCount()
    {
        return a.size();
    }

    public Fragment getItem(int i)
    {
        return (Fragment)a.get(i);
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }
}
