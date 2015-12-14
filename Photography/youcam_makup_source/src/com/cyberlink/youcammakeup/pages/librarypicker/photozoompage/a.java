// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage;

import com.pf.common.utility.m;

public class a
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private final String a = "ZoomViewPageChangeListener";

    public a()
    {
    }

    public void onPageScrollStateChanged(int i)
    {
        m.b("ZoomViewPageChangeListener", (new StringBuilder()).append("onPageScrollStateChanged").append(i).toString());
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        m.b("ZoomViewPageChangeListener", (new StringBuilder()).append("onPageSelected").append(i).toString());
    }
}
