// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.review;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.target.ui.view.common.ViewPagerIndicator;

public class I
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (ViewPager)viewbinder.viewPages((View)viewbinder.viewPages(obj, 0x7f10051a, "field 'viewPages'"), 0x7f10051a, "field 'viewPages'");
        i.I = (ViewPagerIndicator)viewbinder.indicator((View)viewbinder.indicator(obj, 0x7f10051b, "field 'indicator'"), 0x7f10051b, "field 'indicator'");
    }

    public volatile void bind(butterknife.s..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
