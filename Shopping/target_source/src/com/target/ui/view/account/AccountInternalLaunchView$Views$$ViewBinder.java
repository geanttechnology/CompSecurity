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
        . = (View)viewbinder.privacy(obj, 0x7f1002d2, "field 'privacy'");
        . = (View)viewbinder.caPrivacy(obj, 0x7f1002d3, "field 'caPrivacy'");
        .nAct = (View)viewbinder.caSupplyChainAct(obj, 0x7f1002d4, "field 'caSupplyChainAct'");
        .nAct = (View)viewbinder.terms(obj, 0x7f1002d5, "field 'terms'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.nAct = null;
        bind1.nAct = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
