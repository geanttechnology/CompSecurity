// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.Views..ViewBinder
{

    public void bind(butterknife.Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.message((View)viewbinder.message(obj, 0x7f100181, "field 'message'"), 0x7f100181, "field 'message'");
        .n = (View)viewbinder.dismissButton(obj, 0x7f100183, "field 'dismissButton'");
        .n = (View)viewbinder.retryButton(obj, 0x7f100182, "field 'retryButton'");
    }

    public volatile void bind(butterknife.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.n = null;
        bind1.n = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
