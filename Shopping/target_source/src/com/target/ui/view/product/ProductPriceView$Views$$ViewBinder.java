// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.price((View)viewbinder.(obj, 0x7f100517, "field 'price'"), 0x7f100517, "field 'price'");
        .hPrice = (TextView)viewbinder.strikeThroughPrice((View)viewbinder.(obj, 0x7f100518, "field 'strikeThroughPrice'"), 0x7f100518, "field 'strikeThroughPrice'");
        .hPrice = (TextView)viewbinder.storeInfo((View)viewbinder.(obj, 0x7f100519, "field 'storeInfo'"), 0x7f100519, "field 'storeInfo'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.hPrice = null;
        bind1.hPrice = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
