// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.w(obj, 0x7f10037e, "field 'giftCardView'");
        .e = (TextView)viewbinder.giftCardValue((View)viewbinder.w(obj, 0x7f100380, "field 'giftCardValue'"), 0x7f100380, "field 'giftCardValue'");
        .e = (View)viewbinder.w(obj, 0x7f100381, "field 'spacer'");
        .iew = (View)viewbinder.w(obj, 0x7f100382, "field 'paymentCardView'");
        .mage = (ImageView)viewbinder.paymentCardImage((View)viewbinder.w(obj, 0x7f100383, "field 'paymentCardImage'"), 0x7f100383, "field 'paymentCardImage'");
        .ext = (TextView)viewbinder.paymentCardText((View)viewbinder.w(obj, 0x7f100384, "field 'paymentCardText'"), 0x7f100384, "field 'paymentCardText'");
        .alue = (TextView)viewbinder.paymentCardValue((View)viewbinder.w(obj, 0x7f100385, "field 'paymentCardValue'"), 0x7f100385, "field 'paymentCardValue'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1.e = null;
        bind1.e = null;
        bind1.iew = null;
        bind1.mage = null;
        bind1.ext = null;
        bind1.alue = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
