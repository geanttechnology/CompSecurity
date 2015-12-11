// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.map;

import android.view.View;
import com.target.ui.view.map.BlackFridayDealProductView;

public class 
    implements butterknife.r..ViewBinder
{

    public void bind(butterknife.r..ViewBinder viewbinder,  , Object obj)
    {
        . = (BlackFridayDealProductView)viewbinder.productView((View)viewbinder.productView(obj, 0x7f100470, "field 'productView'"), 0x7f100470, "field 'productView'");
    }

    public volatile void bind(butterknife.r..ViewBinder viewbinder, Object obj, Object obj1)
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
