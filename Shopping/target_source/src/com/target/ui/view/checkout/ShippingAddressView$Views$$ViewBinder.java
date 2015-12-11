// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .actView = (View)viewbinder.shippingCompactView(obj, 0x7f1003e4, "field 'shippingCompactView'");
        .essDetailsView = (LinearLayout)viewbinder.shippingAddressDetailsView((View)viewbinder.shippingAddressDetailsView(obj, 0x7f1003e6, "field 'shippingAddressDetailsView'"), 0x7f1003e6, "field 'shippingAddressDetailsView'");
        .ngText = (TextView)viewbinder.selectShippingText((View)viewbinder.selectShippingText(obj, 0x7f1003e8, "field 'selectShippingText'"), 0x7f1003e8, "field 'selectShippingText'");
        . = (TextView)viewbinder.shippingText((View)viewbinder.shippingText(obj, 0x7f1003e7, "field 'shippingText'"), 0x7f1003e7, "field 'shippingText'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.actView = null;
        bind1.essDetailsView = null;
        bind1.ngText = null;
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
