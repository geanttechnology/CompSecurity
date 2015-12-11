// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class 
    implements butterknife.older..ViewBinder
{

    public void bind(butterknife.older..ViewBinder viewbinder,  , Object obj)
    {
        . = (RadioButton)viewbinder.radioButton((View)viewbinder.radioButton(obj, 0x7f1005da, "field 'radioButton'"), 0x7f1005da, "field 'radioButton'");
        . = (TextView)viewbinder.storeName((View)viewbinder.storeName(obj, 0x7f1005dc, "field 'storeName'"), 0x7f1005dc, "field 'storeName'");
        . = (TextView)viewbinder.storeAddress((View)viewbinder.storeAddress(obj, 0x7f1005dd, "field 'storeAddress'"), 0x7f1005dd, "field 'storeAddress'");
        . = (TextView)viewbinder.storeLabel((View)viewbinder.storeLabel(obj, 0x7f1005de, "field 'storeLabel'"), 0x7f1005de, "field 'storeLabel'");
        .tus = (TextView)viewbinder.inventoryStatus((View)viewbinder.inventoryStatus(obj, 0x7f1005df, "field 'inventoryStatus'"), 0x7f1005df, "field 'inventoryStatus'");
        .tus = (ImageButton)viewbinder.storeInfo((View)viewbinder.storeInfo(obj, 0x7f1005db, "field 'storeInfo'"), 0x7f1005db, "field 'storeInfo'");
    }

    public volatile void bind(butterknife.older..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1. = null;
        bind1. = null;
        bind1.tus = null;
        bind1.tus = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
