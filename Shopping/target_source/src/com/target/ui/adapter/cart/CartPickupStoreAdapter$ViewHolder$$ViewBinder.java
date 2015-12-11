// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class 
    implements butterknife.er..ViewBinder
{

    public void bind(butterknife.er..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.root(obj, 0x7f100304, "field 'root'");
        .hoice = (RadioButton)viewbinder.pickupStoreChoice((View)viewbinder.pickupStoreChoice(obj, 0x7f100322, "field 'pickupStoreChoice'"), 0x7f100322, "field 'pickupStoreChoice'");
        .hoice = (TextView)viewbinder.storeName((View)viewbinder.storeName(obj, 0x7f100323, "field 'storeName'"), 0x7f100323, "field 'storeName'");
        .hoice = (TextView)viewbinder.stockStatus((View)viewbinder.stockStatus(obj, 0x7f100326, "field 'stockStatus'"), 0x7f100326, "field 'stockStatus'");
        .hoice = (ImageButton)viewbinder.storeInfo((View)viewbinder.storeInfo(obj, 0x7f100327, "field 'storeInfo'"), 0x7f100327, "field 'storeInfo'");
    }

    public volatile void bind(butterknife.er..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.hoice = null;
        bind1.hoice = null;
        bind1.hoice = null;
        bind1.hoice = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
