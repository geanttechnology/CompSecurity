// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.frames;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class FixFramesScrollPageView extends FrameLayout
{

    ViewPager pager;

    public FixFramesScrollPageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a5, this, true);
        pager = (ViewPager)findViewById(0x7f0c0077);
    }

    public ViewPager getPager()
    {
        return pager;
    }

    public void setDataAdapter(PagerAdapter pageradapter)
    {
        pager.setAdapter(pageradapter);
        pager.setCurrentItem(0);
    }

    public void setSelectedPageIndex(int i)
    {
        pager.setCurrentItem(i);
    }
}
