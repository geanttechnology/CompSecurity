// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .iew = (View)viewbinder.productRootView(obj, 0x7f1002ea, "field 'productRootView'");
        . = (BitmapImageView)viewbinder.productImage((View)viewbinder.productImage(obj, 0x7f1002eb, "field 'productImage'"), 0x7f1002eb, "field 'productImage'");
        . = (TextView)viewbinder.productTitle((View)viewbinder.productTitle(obj, 0x7f1002ec, "field 'productTitle'"), 0x7f1002ec, "field 'productTitle'");
        .s = (TextView)viewbinder.productStatus((View)viewbinder.productStatus(obj, 0x7f1002ed, "field 'productStatus'"), 0x7f1002ed, "field 'productStatus'");
        . = (TextView)viewbinder.productPrice((View)viewbinder.productPrice(obj, 0x7f1002ee, "field 'productPrice'"), 0x7f1002ee, "field 'productPrice'");
        .ity = (TextView)viewbinder.productQuantity((View)viewbinder.productQuantity(obj, 0x7f1002ef, "field 'productQuantity'"), 0x7f1002ef, "field 'productQuantity'");
        .ator = (View)viewbinder.productSeparator(obj, 0x7f1002e9, "field 'productSeparator'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.iew = null;
        bind1. = null;
        bind1. = null;
        bind1.s = null;
        bind1. = null;
        bind1.ity = null;
        bind1.ator = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
