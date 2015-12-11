// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.UrlImageView;

public class 
    implements butterknife.older..ViewBinder
{

    public void bind(butterknife.older..ViewBinder viewbinder,  , Object obj)
    {
        . = (UrlImageView)viewbinder.imageView((View)viewbinder.imageView(obj, 0x7f100076, "field 'imageView'"), 0x7f100076, "field 'imageView'");
        . = (TextView)viewbinder.titleView((View)viewbinder.titleView(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        .w = (TextView)viewbinder.priceTextView((View)viewbinder.priceTextView(obj, 0x7f100192, "field 'priceTextView'"), 0x7f100192, "field 'priceTextView'");
        .ceTextView = (TextView)viewbinder.referencePriceTextView((View)viewbinder.referencePriceTextView(obj, 0x7f1002d6, "field 'referencePriceTextView'"), 0x7f1002d6, "field 'referencePriceTextView'");
        .View = (TextView)viewbinder.locationTextView((View)viewbinder.locationTextView(obj, 0x7f1002d4, "field 'locationTextView'"), 0x7f1002d4, "field 'locationTextView'");
    }

    public volatile void bind(butterknife.older..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.w = null;
        bind1.ceTextView = null;
        bind1.View = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
