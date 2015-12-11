// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (EditText)viewbinder.firstName((View)viewbinder.(obj, 0x7f100580, "field 'firstName'"), 0x7f100580, "field 'firstName'");
        .pper = (CustomErrorViewWrapper)viewbinder.firstNameWrapper((View)viewbinder.(obj, 0x7f10057f, "field 'firstNameWrapper'"), 0x7f10057f, "field 'firstNameWrapper'");
        .pper = (EditText)viewbinder.lastName((View)viewbinder.(obj, 0x7f100581, "field 'lastName'"), 0x7f100581, "field 'lastName'");
        .per = (CustomErrorViewWrapper)viewbinder.lastNameWrapper((View)viewbinder.(obj, 0x7f100582, "field 'lastNameWrapper'"), 0x7f100582, "field 'lastNameWrapper'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.pper = null;
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
