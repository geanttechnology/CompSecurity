// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.subtotalText((View)viewbinder.dView(obj, 0x7f1003ef, "field 'subtotalText'"), 0x7f1003ef, "field 'subtotalText'");
        .ext = (TextView)viewbinder.handlingFeeText((View)viewbinder.dView(obj, 0x7f1003fe, "field 'handlingFeeText'"), 0x7f1003fe, "field 'handlingFeeText'");
        .t = (TextView)viewbinder.stateFeesText((View)viewbinder.dView(obj, 0x7f100402, "field 'stateFeesText'"), 0x7f100402, "field 'stateFeesText'");
        .t = (TextView)viewbinder.savingsText((View)viewbinder.dView(obj, 0x7f1003f3, "field 'savingsText'"), 0x7f1003f3, "field 'savingsText'");
        .er = (View)viewbinder.dView(obj, 0x7f1003f0, "field 'savingsDivider'");
        .er = (TextView)viewbinder.taxText((View)viewbinder.dView(obj, 0x7f1003f6, "field 'taxText'"), 0x7f1003f6, "field 'taxText'");
        .der = (View)viewbinder.dView(obj, 0x7f1003f7, "field 'shippingDivider'");
        . = (View)viewbinder.dView(obj, 0x7f1003f8, "field 'shippingView'");
        .geText = (TextView)viewbinder.shippingChargeText((View)viewbinder.dView(obj, 0x7f1003fa, "field 'shippingChargeText'"), 0x7f1003fa, "field 'shippingChargeText'");
        .geText = (TextView)viewbinder.totalText((View)viewbinder.dView(obj, 0x7f100405, "field 'totalText'"), 0x7f100405, "field 'totalText'");
        .t = (FrameLayout)viewbinder.savingsLayout((View)viewbinder.dView(obj, 0x7f1003f1, "field 'savingsLayout'"), 0x7f1003f1, "field 'savingsLayout'");
        .Layout = (FrameLayout)viewbinder.handlingFeesLayout((View)viewbinder.dView(obj, 0x7f1003fc, "field 'handlingFeesLayout'"), 0x7f1003fc, "field 'handlingFeesLayout'");
        .Divider = (View)viewbinder.dView(obj, 0x7f1003fb, "field 'handlingFeesDivider'");
        .out = (FrameLayout)viewbinder.stateFeesLayout((View)viewbinder.dView(obj, 0x7f100400, "field 'stateFeesLayout'"), 0x7f100400, "field 'stateFeesLayout'");
        .ider = (View)viewbinder.dView(obj, 0x7f1003ff, "field 'stateFeesDivider'");
        . = (View)viewbinder.dView(obj, 0x7f100406, "field 'taxErrorView'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1.ext = null;
        bind1.t = null;
        bind1.t = null;
        bind1.er = null;
        bind1.er = null;
        bind1.der = null;
        bind1. = null;
        bind1.geText = null;
        bind1.geText = null;
        bind1.t = null;
        bind1.Layout = null;
        bind1.Divider = null;
        bind1.out = null;
        bind1.ider = null;
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
