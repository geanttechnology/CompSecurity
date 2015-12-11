// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Q
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, Q q, Object obj)
    {
        q.ontainer = (LinearLayout)viewbinder.paymentCardContainer((View)viewbinder.paymentCardContainer(obj, 0x7f1002e2, "field 'paymentCardContainer'"), 0x7f1002e2, "field 'paymentCardContainer'");
        q.ator = (View)viewbinder.summarySeparator(obj, 0x7f1002e3, "field 'summarySeparator'");
        q.ator = (TextView)viewbinder.orderTotal((View)viewbinder.orderTotal(obj, 0x7f1002e4, "field 'orderTotal'"), 0x7f1002e4, "field 'orderTotal'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ontainer = null;
        bind1.ator = null;
        bind1.ator = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public Q()
    {
    }
}
