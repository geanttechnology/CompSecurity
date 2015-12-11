// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .e = (ImageView)viewbinder.mProductImage((View)viewbinder.mProductImage(obj, 0x7f100487, "field 'mProductImage'"), 0x7f100487, "field 'mProductImage'");
        .e = (TextView)viewbinder.mProductTitle((View)viewbinder.mProductTitle(obj, 0x7f100488, "field 'mProductTitle'"), 0x7f100488, "field 'mProductTitle'");
        .tus = (TextView)viewbinder.mDeliveryStatus((View)viewbinder.mDeliveryStatus(obj, 0x7f100489, "field 'mDeliveryStatus'"), 0x7f100489, "field 'mDeliveryStatus'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.e = null;
        bind1.e = null;
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
