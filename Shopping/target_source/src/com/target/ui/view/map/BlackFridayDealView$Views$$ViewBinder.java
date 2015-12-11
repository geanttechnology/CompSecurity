// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.ViewBinder
{

    public void bind(butterknife.ViewBinder viewbinder,  , Object obj)
    {
        . = (ImageView)viewbinder.mageView((View)viewbinder.mageView(obj, 0x7f100468, "field 'imageView'"), 0x7f100468, "field 'imageView'");
        . = (TextView)viewbinder.ealLocation((View)viewbinder.ealLocation(obj, 0x7f100469, "field 'dealLocation'"), 0x7f100469, "field 'dealLocation'");
        . = (TextView)viewbinder.ealTitle((View)viewbinder.ealTitle(obj, 0x7f10046a, "field 'dealTitle'"), 0x7f10046a, "field 'dealTitle'");
    }

    public volatile void bind(butterknife.ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1. = null;
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
