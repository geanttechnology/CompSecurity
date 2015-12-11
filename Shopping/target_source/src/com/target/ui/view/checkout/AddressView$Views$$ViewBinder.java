// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (EditText)viewbinder.addressLine((View)viewbinder.dView(obj, 0x7f10035d, "field 'addressLine'"), 0x7f10035d, "field 'addressLine'");
        .ber = (EditText)viewbinder.apartmentNumber((View)viewbinder.dView(obj, 0x7f10035e, "field 'apartmentNumber'"), 0x7f10035e, "field 'apartmentNumber'");
        .ber = (EditText)viewbinder.zipCode((View)viewbinder.dView(obj, 0x7f100360, "field 'zipCode'"), 0x7f100360, "field 'zipCode'");
        .ber = (EditText)viewbinder.city((View)viewbinder.dView(obj, 0x7f100362, "field 'city'"), 0x7f100362, "field 'city'");
        . = (Spinner)viewbinder.stateSpinner((View)viewbinder.dView(obj, 0x7f100366, "field 'stateSpinner'"), 0x7f100366, "field 'stateSpinner'");
        .rapper = (CustomErrorViewWrapper)viewbinder.addressLineWrapper((View)viewbinder.dView(obj, 0x7f10035c, "field 'addressLineWrapper'"), 0x7f10035c, "field 'addressLineWrapper'");
        .berWrapper = (CustomErrorViewWrapper)viewbinder.apartmentNumberWrapper((View)viewbinder.dView(obj, 0x7f10035f, "field 'apartmentNumberWrapper'"), 0x7f10035f, "field 'apartmentNumberWrapper'");
        .er = (CustomErrorViewWrapper)viewbinder.zipCodeWrapper((View)viewbinder.dView(obj, 0x7f100361, "field 'zipCodeWrapper'"), 0x7f100361, "field 'zipCodeWrapper'");
        .er = (CustomErrorViewWrapper)viewbinder.cityWrapper((View)viewbinder.dView(obj, 0x7f100363, "field 'cityWrapper'"), 0x7f100363, "field 'cityWrapper'");
        . = (CustomErrorViewWrapper)viewbinder.stateWrapper((View)viewbinder.dView(obj, 0x7f100364, "field 'stateWrapper'"), 0x7f100364, "field 'stateWrapper'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.ber = null;
        bind1.ber = null;
        bind1.ber = null;
        bind1. = null;
        bind1.rapper = null;
        bind1.berWrapper = null;
        bind1.er = null;
        bind1.er = null;
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
