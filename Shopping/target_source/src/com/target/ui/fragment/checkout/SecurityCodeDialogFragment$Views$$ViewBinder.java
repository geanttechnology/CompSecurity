// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.t.Views..ViewBinder
{

    public void bind(butterknife.t.Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (ImageView)viewbinder.cardImage((View)viewbinder.cardImage(obj, 0x7f1003da, "field 'cardImage'"), 0x7f1003da, "field 'cardImage'");
        .ts = (TextView)viewbinder.lastFourDigits((View)viewbinder.lastFourDigits(obj, 0x7f1003db, "field 'lastFourDigits'"), 0x7f1003db, "field 'lastFourDigits'");
        .ts = (TextView)viewbinder.expiry((View)viewbinder.expiry(obj, 0x7f1003dc, "field 'expiry'"), 0x7f1003dc, "field 'expiry'");
        .ts = (EditText)viewbinder.inputField((View)viewbinder.inputField(obj, 0x7f1003dd, "field 'inputField'"), 0x7f1003dd, "field 'inputField'");
        . = (Button)viewbinder.submitButton((View)viewbinder.submitButton(obj, 0x7f100158, "field 'submitButton'"), 0x7f100158, "field 'submitButton'");
    }

    public volatile void bind(butterknife.t.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.ts = null;
        bind1.ts = null;
        bind1.ts = null;
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
