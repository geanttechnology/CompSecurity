// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment;

import android.view.View;
import android.widget.Button;
import com.target.ui.view.checkout.BillingView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.a;

public class Q
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder, Q q, Object obj)
    {
        q.lsContainer = (View)viewbinder.paymentDetailsContainer(obj, 0x7f1001a6, "field 'paymentDetailsContainer'");
        q.er = (TargetErrorView)viewbinder.errorContainer((View)viewbinder.errorContainer(obj, 0x7f1001a5, "field 'errorContainer'"), 0x7f1001a5, "field 'errorContainer'");
        q.er = (BillingView)viewbinder.billingView((View)viewbinder.billingView(obj, 0x7f1001a7, "field 'billingView'"), 0x7f1001a7, "field 'billingView'");
        q. = (a)viewbinder.setAsDefault((View)viewbinder.setAsDefault(obj, 0x7f10040f, "field 'setAsDefault'"), 0x7f10040f, "field 'setAsDefault'");
        q. = (Button)viewbinder.button((View)viewbinder.button(obj, 0x7f1001a8, "field 'button'"), 0x7f1001a8, "field 'button'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.lsContainer = null;
        bind1.er = null;
        bind1.er = null;
        bind1. = null;
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public Q()
    {
    }
}
