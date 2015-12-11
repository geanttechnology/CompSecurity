// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.orderNumber((View)viewbinder.(obj, 0x7f100485, "field 'orderNumber'"), 0x7f100485, "field 'orderNumber'");
        . = (TextView)viewbinder.orderDate((View)viewbinder.(obj, 0x7f100486, "field 'orderDate'"), 0x7f100486, "field 'orderDate'");
        . = (LinearLayout)viewbinder.orderList((View)viewbinder.(obj, 0x7f100484, "field 'orderList'"), 0x7f100484, "field 'orderList'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
