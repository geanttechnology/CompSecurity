// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.target.ui.view.common.TargetErrorView;

public class A
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder, A a, Object obj)
    {
        a. = (RecyclerView)viewbinder.recyclerView((View)viewbinder.iew(obj, 0x7f10016f, "field 'recyclerView'"), 0x7f10016f, "field 'recyclerView'");
        a. = (TargetErrorView)viewbinder.errorView((View)viewbinder.iew(obj, 0x7f100172, "field 'errorView'"), 0x7f100172, "field 'errorView'");
        a.ainer = (View)viewbinder.iew(obj, 0x7f100171, "field 'progressContainer'");
        a. = (View)viewbinder.iew(obj, 0x7f100170, "field 'refineButton'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1. = null;
        bind1.ainer = null;
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public A()
    {
    }
}
