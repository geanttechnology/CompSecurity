// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.mcoupons.CouponsOverflowView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (BitmapImageView)viewbinder.imageView((View)viewbinder.imageView(obj, 0x7f1004de, "field 'imageView'"), 0x7f1004de, "field 'imageView'");
        .flowView = (CouponsOverflowView)viewbinder.mCouponsOverflowView((View)viewbinder.mCouponsOverflowView(obj, 0x7f1004e0, "field 'mCouponsOverflowView'"), 0x7f1004e0, "field 'mCouponsOverflowView'");
        .flowView = (TextView)viewbinder.eyebrow((View)viewbinder.eyebrow(obj, 0x7f1004df, "field 'eyebrow'"), 0x7f1004df, "field 'eyebrow'");
        .flowView = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f100080, "field 'title'"), 0x7f100080, "field 'title'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.flowView = null;
        bind1.flowView = null;
        bind1.flowView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
