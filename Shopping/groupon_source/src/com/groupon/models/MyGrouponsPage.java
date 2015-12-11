// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import android.app.Fragment;
import com.groupon.MyGrouponsTabs;

public class MyGrouponsPage
{

    private final MyGrouponsTabs myGrouponsTabs;
    private final Fragment pageFragment;
    private final String title;

    public MyGrouponsPage(MyGrouponsTabs mygrouponstabs, Fragment fragment, String s)
    {
        myGrouponsTabs = mygrouponstabs;
        pageFragment = fragment;
        title = s;
    }

    public MyGrouponsTabs getMyGrouponsTabs()
    {
        return myGrouponsTabs;
    }

    public Fragment getPageFragment()
    {
        return pageFragment;
    }

    public String getTitle()
    {
        return title;
    }
}
