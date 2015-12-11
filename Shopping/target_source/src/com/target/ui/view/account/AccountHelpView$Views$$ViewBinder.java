// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .owse = (View)viewbinder.w(obj, 0x7f1002c7, "field 'helpSearchBrowse'");
        .kUp = (View)viewbinder.w(obj, 0x7f1002c8, "field 'helpStorePickUp'");
        .kUp = (View)viewbinder.w(obj, 0x7f1002c9, "field 'helpRedCard'");
        . = (View)viewbinder.w(obj, 0x7f1002ca, "field 'helpPharmacy'");
        .s = (View)viewbinder.w(obj, 0x7f1002cb, "field 'helpGiftCards'");
        . = (View)viewbinder.w(obj, 0x7f1002cc, "field 'helpWarranty'");
        . = (View)viewbinder.w(obj, 0x7f1002cd, "field 'helpRecalls'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.owse = null;
        bind1.kUp = null;
        bind1.kUp = null;
        bind1. = null;
        bind1.s = null;
        bind1. = null;
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
