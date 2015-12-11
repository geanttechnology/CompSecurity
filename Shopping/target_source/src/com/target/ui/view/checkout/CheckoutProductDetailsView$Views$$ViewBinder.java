// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .iew = (View)viewbinder.productRootView(obj, 0x7f1003ca, "field 'productRootView'");
        . = (BitmapImageView)viewbinder.productImage((View)viewbinder.productImage(obj, 0x7f1003cb, "field 'productImage'"), 0x7f1003cb, "field 'productImage'");
        . = (TextView)viewbinder.productTitle((View)viewbinder.productTitle(obj, 0x7f1003cc, "field 'productTitle'"), 0x7f1003cc, "field 'productTitle'");
        . = (TextView)viewbinder.productPrice((View)viewbinder.productPrice(obj, 0x7f1003cd, "field 'productPrice'"), 0x7f1003cd, "field 'productPrice'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.iew = null;
        bind1. = null;
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
