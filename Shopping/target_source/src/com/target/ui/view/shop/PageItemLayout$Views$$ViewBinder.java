// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        . = (RecyclerView)viewbinder.recyclerView((View)viewbinder.ew(obj, 0x7f10016f, "field 'recyclerView'"), 0x7f10016f, "field 'recyclerView'");
        . = (TargetErrorView)viewbinder.errorView((View)viewbinder.ew(obj, 0x7f100172, "field 'errorView'"), 0x7f100172, "field 'errorView'");
        .ainer = (View)viewbinder.ew(obj, 0x7f100171, "field 'progressContainer'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1. = null;
        bind1.ainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
