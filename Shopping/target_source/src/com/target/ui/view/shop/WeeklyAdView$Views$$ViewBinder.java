// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        . = (RecyclerView)viewbinder.recyclerView((View)viewbinder.View(obj, 0x7f10048a, "field 'recyclerView'"), 0x7f10048a, "field 'recyclerView'");
        . = (TextView)viewbinder.text((View)viewbinder.View(obj, 0x7f1002a2, "field 'text'"), 0x7f1002a2, "field 'text'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
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
