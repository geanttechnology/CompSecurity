// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.view.cart.CartProductListView;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (TargetErrorView)viewbinder.errorView((View)viewbinder.(obj, 0x7f100134, "field 'errorView'"), 0x7f100134, "field 'errorView'");
        .tainer = (LinearLayout)viewbinder.emptyCartContainer((View)viewbinder.(obj, 0x7f100135, "field 'emptyCartContainer'"), 0x7f100135, "field 'emptyCartContainer'");
        .sage = (TextView)viewbinder.emptyCartMessage((View)viewbinder.(obj, 0x7f10030a, "field 'emptyCartMessage'"), 0x7f10030a, "field 'emptyCartMessage'");
        .mendationsView = (GridView)viewbinder.productRecommendationsView((View)viewbinder.(obj, 0x7f10030b, "field 'productRecommendationsView'"), 0x7f10030b, "field 'productRecommendationsView'");
        .uthView = (LinearLayout)viewbinder.emptyCartReauthView((View)viewbinder.(obj, 0x7f10030c, "field 'emptyCartReauthView'"), 0x7f10030c, "field 'emptyCartReauthView'");
        .uthView = (View)viewbinder.(obj, 0x7f10030d, "field 'reauthView'");
        .uthView = (CartProductListView)viewbinder.listView((View)viewbinder.(obj, 0x7f100136, "field 'listView'"), 0x7f100136, "field 'listView'");
        .on = (Button)viewbinder.checkoutButton((View)viewbinder.(obj, 0x7f100137, "field 'checkoutButton'"), 0x7f100137, "field 'checkoutButton'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.tainer = null;
        bind1.sage = null;
        bind1.mendationsView = null;
        bind1.uthView = null;
        bind1.uthView = null;
        bind1.uthView = null;
        bind1.on = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
