// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import android.view.View;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.weekly_ad.WeeklyAdListLayout;

public class 
    implements butterknife.nt.Views..ViewBinder
{

    public void bind(butterknife.nt.Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (TargetErrorView)viewbinder.errorView((View)viewbinder.errorView(obj, 0x7f100172, "field 'errorView'"), 0x7f100172, "field 'errorView'");
        . = (View)viewbinder.loader(obj, 0x7f1001d6, "field 'loader'");
        . = (WeeklyAdListLayout)viewbinder.list((View)viewbinder.list(obj, 0x7f100235, "field 'list'"), 0x7f100235, "field 'list'");
    }

    public volatile void bind(butterknife.nt.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
