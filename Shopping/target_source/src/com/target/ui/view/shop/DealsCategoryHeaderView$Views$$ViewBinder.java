// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.primaryText((View)viewbinder.primaryText(obj, 0x7f10042f, "field 'primaryText'"), 0x7f10042f, "field 'primaryText'");
        .t = (TextView)viewbinder.secondaryText((View)viewbinder.secondaryText(obj, 0x7f1003e3, "field 'secondaryText'"), 0x7f1003e3, "field 'secondaryText'");
        .r = (View)viewbinder.bottomDivider(obj, 0x7f100430, "field 'bottomDivider'");
        .r = (View)viewbinder.topDivider(obj, 0x7f10042e, "field 'topDivider'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.t = null;
        bind1.r = null;
        bind1.r = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
