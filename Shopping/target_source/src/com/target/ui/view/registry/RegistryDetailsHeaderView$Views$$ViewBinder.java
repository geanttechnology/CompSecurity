// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f100577, "field 'title'"), 0x7f100577, "field 'title'");
        .e = (TextView)viewbinder.dateCityState((View)viewbinder.dateCityState(obj, 0x7f100578, "field 'dateCityState'"), 0x7f100578, "field 'dateCityState'");
        .e = (TextView)viewbinder.noOfItems((View)viewbinder.noOfItems(obj, 0x7f100579, "field 'noOfItems'"), 0x7f100579, "field 'noOfItems'");
        .e = (ImageView)viewbinder.barcode((View)viewbinder.barcode(obj, 0x7f10057b, "field 'barcode'"), 0x7f10057b, "field 'barcode'");
        .e = (TextView)viewbinder.registryId((View)viewbinder.registryId(obj, 0x7f10057c, "field 'registryId'"), 0x7f10057c, "field 'registryId'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.e = null;
        bind1.e = null;
        bind1.e = null;
        bind1.e = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
