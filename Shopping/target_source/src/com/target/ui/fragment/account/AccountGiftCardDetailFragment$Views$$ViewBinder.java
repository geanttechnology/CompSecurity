// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder,  , Object obj)
    {
        .ice = (TextView)viewbinder.tvGiftCardPrice((View)viewbinder.tvGiftCardPrice(obj, 0x7f100101, "field 'tvGiftCardPrice'"), 0x7f100101, "field 'tvGiftCardPrice'");
        .cessNumber = (TextView)viewbinder.tvGiftCardAccessNumber((View)viewbinder.tvGiftCardAccessNumber(obj, 0x7f100107, "field 'tvGiftCardAccessNumber'"), 0x7f100107, "field 'tvGiftCardAccessNumber'");
        .cessNumber = (ImageView)viewbinder.ivBarcode((View)viewbinder.ivBarcode(obj, 0x7f100105, "field 'ivBarcode'"), 0x7f100105, "field 'ivBarcode'");
        .cessNumber = (WebView)viewbinder.wvBarcode((View)viewbinder.wvBarcode(obj, 0x7f100106, "field 'wvBarcode'"), 0x7f100106, "field 'wvBarcode'");
        .cessNumber = (Button)viewbinder.buttonDone((View)viewbinder.buttonDone(obj, 0x7f100103, "field 'buttonDone'"), 0x7f100103, "field 'buttonDone'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ice = null;
        bind1.cessNumber = null;
        bind1.cessNumber = null;
        bind1.cessNumber = null;
        bind1.cessNumber = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
