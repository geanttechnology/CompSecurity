// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.account.AccountOrderDetailsDeliveryView;
import com.target.ui.view.account.AccountOrderDetailsPaymentView;
import com.target.ui.view.account.AccountOrderDetailsProductListView;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (TargetErrorView)viewbinder.errorView((View)viewbinder.errorView(obj, 0x7f100122, "field 'errorView'"), 0x7f100122, "field 'errorView'");
        .ScrollContent = (View)viewbinder.orderDetailsScrollContent(obj, 0x7f100123, "field 'orderDetailsScrollContent'");
        .ProductListView = (AccountOrderDetailsProductListView)viewbinder.iew((View)viewbinder.iew(obj, 0x7f100124, "field 'orderDetailsProductListView'"), 0x7f100124, "field 'orderDetailsProductListView'");
        .DeliveryView = (AccountOrderDetailsDeliveryView)viewbinder.((View)viewbinder.(obj, 0x7f100126, "field 'orderDetailsDeliveryView'"), 0x7f100126, "field 'orderDetailsDeliveryView'");
        .PaymentView = (AccountOrderDetailsPaymentView)viewbinder.orderDetailsPaymentView((View)viewbinder.orderDetailsPaymentView(obj, 0x7f100127, "field 'orderDetailsPaymentView'"), 0x7f100127, "field 'orderDetailsPaymentView'");
        .ate = (TextView)viewbinder.orderPlacedDate((View)viewbinder.orderPlacedDate(obj, 0x7f100128, "field 'orderPlacedDate'"), 0x7f100128, "field 'orderPlacedDate'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.ScrollContent = null;
        bind1.ProductListView = null;
        bind1.DeliveryView = null;
        bind1.PaymentView = null;
        bind1.ate = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
