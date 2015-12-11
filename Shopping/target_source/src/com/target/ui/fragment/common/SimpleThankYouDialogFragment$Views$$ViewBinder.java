// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class 
    implements butterknife.Views..ViewBinder
{

    public void bind(butterknife.Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (Button)viewbinder.button((View)viewbinder.button(obj, 0x7f100069, "field 'button'"), 0x7f100069, "field 'button'");
        . = (TextView)viewbinder.message((View)viewbinder.message(obj, 0x7f100181, "field 'message'"), 0x7f100181, "field 'message'");
    }

    public volatile void bind(butterknife.Views..ViewBinder viewbinder, Object obj, Object obj1)
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
