// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageView;
import com.target.ui.view.AisleBadgeView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .eBtn = (ImageView)viewbinder.pickUpAtStoreBtn((View)viewbinder.pickUpAtStoreBtn(obj, 0x7f1004e6, "field 'pickUpAtStoreBtn'"), 0x7f1004e6, "field 'pickUpAtStoreBtn'");
        .eBtn = (ImageView)viewbinder.shipMeBtn((View)viewbinder.shipMeBtn(obj, 0x7f1004e7, "field 'shipMeBtn'"), 0x7f1004e7, "field 'shipMeBtn'");
        . = (ImageView)viewbinder.addToListBtn((View)viewbinder.addToListBtn(obj, 0x7f1004e8, "field 'addToListBtn'"), 0x7f1004e8, "field 'addToListBtn'");
        . = (AisleBadgeView)viewbinder.aisleView((View)viewbinder.aisleView(obj, 0x7f1004e9, "field 'aisleView'"), 0x7f1004e9, "field 'aisleView'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.eBtn = null;
        bind1.eBtn = null;
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
