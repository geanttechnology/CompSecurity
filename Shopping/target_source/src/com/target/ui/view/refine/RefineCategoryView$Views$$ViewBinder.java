// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.view.View;
import com.target.ui.view.product.FixedHeightListView;

public class 
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder,  , Object obj)
    {
        . = (FixedHeightListView)viewbinder.listView((View)viewbinder.listView(obj, 0x7f100558, "field 'listView'"), 0x7f100558, "field 'listView'");
    }

    public volatile void bind(butterknife.s..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
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
