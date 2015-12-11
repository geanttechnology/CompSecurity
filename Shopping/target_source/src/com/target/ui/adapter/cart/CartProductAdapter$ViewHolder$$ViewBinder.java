// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.cart.CartItemOverflowView;
import com.target.ui.view.cart.CartProductFulfillmentView;

public class 
    implements butterknife.er..ViewBinder
{

    public void bind(butterknife.er..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f100337, "field 'title'"), 0x7f100337, "field 'title'");
        . = (TextView)viewbinder.registryName((View)viewbinder.registryName(obj, 0x7f100330, "field 'registryName'"), 0x7f100330, "field 'registryName'");
        . = (BitmapImageView)viewbinder.imageView((View)viewbinder.imageView(obj, 0x7f100336, "field 'imageView'"), 0x7f100336, "field 'imageView'");
        . = (TextView)viewbinder.price((View)viewbinder.price(obj, 0x7f100332, "field 'price'"), 0x7f100332, "field 'price'");
        .ner = (Spinner)viewbinder.quantitySpinner((View)viewbinder.quantitySpinner(obj, 0x7f100334, "field 'quantitySpinner'"), 0x7f100334, "field 'quantitySpinner'");
        . = (CartItemOverflowView)viewbinder.overflowMenu((View)viewbinder.overflowMenu(obj, 0x7f100335, "field 'overflowMenu'"), 0x7f100335, "field 'overflowMenu'");
        .ontainer = (CartProductFulfillmentView)viewbinder.fulfillmentContainer((View)viewbinder.fulfillmentContainer(obj, 0x7f10031a, "field 'fulfillmentContainer'"), 0x7f10031a, "field 'fulfillmentContainer'");
        .ainer = (LinearLayout)viewbinder.freeItemContainer((View)viewbinder.freeItemContainer(obj, 0x7f100318, "field 'freeItemContainer'"), 0x7f100318, "field 'freeItemContainer'");
        .iner = (LinearLayout)viewbinder.rewardsContainer((View)viewbinder.rewardsContainer(obj, 0x7f100319, "field 'rewardsContainer'"), 0x7f100319, "field 'rewardsContainer'");
    }

    public volatile void bind(butterknife.er..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1. = null;
        bind1. = null;
        bind1. = null;
        bind1.ner = null;
        bind1. = null;
        bind1.ontainer = null;
        bind1.ainer = null;
        bind1.iner = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
