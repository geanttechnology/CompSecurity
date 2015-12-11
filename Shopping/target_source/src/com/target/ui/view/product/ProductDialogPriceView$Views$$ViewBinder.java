// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class I
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, I i, Object obj)
    {
        i.mage = (ImageView)viewbinder.fulfillmentImage((View)viewbinder.fulfillmentImage(obj, 0x7f10050e, "field 'fulfillmentImage'"), 0x7f10050e, "field 'fulfillmentImage'");
        i.itle = (TextView)viewbinder.fulfillmentTitle((View)viewbinder.fulfillmentTitle(obj, 0x7f10050f, "field 'fulfillmentTitle'"), 0x7f10050f, "field 'fulfillmentTitle'");
        i.itle = (TextView)viewbinder.price((View)viewbinder.price(obj, 0x7f100510, "field 'price'"), 0x7f100510, "field 'price'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.mage = null;
        bind1.itle = null;
        bind1.itle = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
