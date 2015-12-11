// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageView;
import com.target.ui.view.ExpandableImageViewPager;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (ImageView)viewbinder.imageView((View)viewbinder.(obj, 0x7f100548, "field 'imageView'"), 0x7f100548, "field 'imageView'");
        . = (ExpandableImageViewPager)viewbinder.viewPager((View)viewbinder.(obj, 0x7f100549, "field 'viewPager'"), 0x7f100549, "field 'viewPager'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
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
