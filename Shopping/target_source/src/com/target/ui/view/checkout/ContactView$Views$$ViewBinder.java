// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (EditText)viewbinder.email((View)viewbinder.dView(obj, 0x7f100388, "field 'email'"), 0x7f100388, "field 'email'");
        .iner = (View)viewbinder.dView(obj, 0x7f100389, "field 'contactContainer'");
        .iner = (EditText)viewbinder.phone((View)viewbinder.dView(obj, 0x7f10038c, "field 'phone'"), 0x7f10038c, "field 'phone'");
        . = (CustomErrorViewWrapper)viewbinder.emailWrapper((View)viewbinder.dView(obj, 0x7f100387, "field 'emailWrapper'"), 0x7f100387, "field 'emailWrapper'");
        . = (CustomErrorViewWrapper)viewbinder.phoneWrapper((View)viewbinder.dView(obj, 0x7f10038b, "field 'phoneWrapper'"), 0x7f10038b, "field 'phoneWrapper'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.iner = null;
        bind1.iner = null;
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
