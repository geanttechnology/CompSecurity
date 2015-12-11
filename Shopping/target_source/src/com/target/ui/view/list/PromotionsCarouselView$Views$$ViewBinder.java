// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import com.target.ui.view.common.ViewPagerIndicator;

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        .Header = (TextView)viewbinder.relatedDealsHeader((View)viewbinder.relatedDealsHeader(obj, 0x7f100465, "field 'relatedDealsHeader'"), 0x7f100465, "field 'relatedDealsHeader'");
        .Header = (ViewPager)viewbinder.viewPages((View)viewbinder.viewPages(obj, 0x7f100466, "field 'viewPages'"), 0x7f100466, "field 'viewPages'");
        .Header = (ViewPagerIndicator)viewbinder.indicator((View)viewbinder.indicator(obj, 0x7f100467, "field 'indicator'"), 0x7f100467, "field 'indicator'");
        .Header = (View)viewbinder.progress(obj, 0x7f100171, "field 'progress'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.Header = null;
        bind1.Header = null;
        bind1.Header = null;
        bind1.Header = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
