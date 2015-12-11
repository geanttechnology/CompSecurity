// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f100512, "field 'title'"), 0x7f100512, "field 'title'");
        . = (TextView)viewbinder.subTitle((View)viewbinder.subTitle(obj, 0x7f100513, "field 'subTitle'"), 0x7f100513, "field 'subTitle'");
        . = (ImageView)viewbinder.warningIcon((View)viewbinder.warningIcon(obj, 0x7f100511, "field 'warningIcon'"), 0x7f100511, "field 'warningIcon'");
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
