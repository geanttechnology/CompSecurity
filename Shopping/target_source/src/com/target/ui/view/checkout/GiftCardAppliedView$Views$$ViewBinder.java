// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .umber = (TextView)viewbinder.appliedCardNumber((View)viewbinder.appliedCardNumber(obj, 0x7f100378, "field 'appliedCardNumber'"), 0x7f100378, "field 'appliedCardNumber'");
        .t = (TextView)viewbinder.appliedAmount((View)viewbinder.appliedAmount(obj, 0x7f100379, "field 'appliedAmount'"), 0x7f100379, "field 'appliedAmount'");
        .t = (ImageView)viewbinder.removeBtn((View)viewbinder.removeBtn(obj, 0x7f100377, "field 'removeBtn'"), 0x7f100377, "field 'removeBtn'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.umber = null;
        bind1.t = null;
        bind1.t = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
