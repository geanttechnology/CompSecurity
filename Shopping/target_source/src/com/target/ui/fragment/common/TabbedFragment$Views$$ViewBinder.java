// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.astuetz.PagerSlidingTabStrip;

public class 
    implements butterknife.Views..ViewBinder
{

    public void bind(butterknife.Views..ViewBinder viewbinder,  , Object obj)
    {
        .TabStrip = (PagerSlidingTabStrip)viewbinder.pagerSlidingTabStrip((View)viewbinder.ew(obj, 0x7f100227, "field 'pagerSlidingTabStrip'"), 0x7f100227, "field 'pagerSlidingTabStrip'");
        .per = (View)viewbinder.ew(obj, 0x7f100226, "field 'tabStripWrapper'");
        .per = (ViewPager)viewbinder.viewPager((View)viewbinder.ew(obj, 0x7f100225, "field 'viewPager'"), 0x7f100225, "field 'viewPager'");
    }

    public volatile void bind(butterknife.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.TabStrip = null;
        bind1.per = null;
        bind1.per = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
