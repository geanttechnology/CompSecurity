// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class I
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder, I i, Object obj)
    {
        i.ts = (TextView)viewbinder.lastFourDigits((View)viewbinder.lastFourDigits(obj, 0x7f100491, "field 'lastFourDigits'"), 0x7f100491, "field 'lastFourDigits'");
        i.ts = (ImageView)viewbinder.cardImage((View)viewbinder.cardImage(obj, 0x7f100490, "field 'cardImage'"), 0x7f100490, "field 'cardImage'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ts = null;
        bind1.ts = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
