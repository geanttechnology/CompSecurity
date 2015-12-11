// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.iredView(obj, 0x7f100413, "field 'root'");
        . = (EditText)viewbinder.((View)viewbinder.iredView(obj, 0x7f100415, "field 'firstName'"), 0x7f100415, "field 'firstName'");
        . = (EditText)viewbinder.((View)viewbinder.iredView(obj, 0x7f100417, "field 'lastName'"), 0x7f100417, "field 'lastName'");
        .pper = (CustomErrorViewWrapper)viewbinder.((View)viewbinder.iredView(obj, 0x7f100414, "field 'firstNameWrapper'"), 0x7f100414, "field 'firstNameWrapper'");
        .per = (CustomErrorViewWrapper)viewbinder.((View)viewbinder.iredView(obj, 0x7f100416, "field 'lastNameWrapper'"), 0x7f100416, "field 'lastNameWrapper'");
    }

    public volatile void bind(butterknife.s..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.pper = null;
        bind1.per = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
