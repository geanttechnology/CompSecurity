// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .per = (CustomErrorViewWrapper)viewbinder.gcNumberWrapper((View)viewbinder.gcNumberWrapper(obj, 0x7f1003a7, "field 'gcNumberWrapper'"), 0x7f1003a7, "field 'gcNumberWrapper'");
        .per = (EditText)viewbinder.gcEditText((View)viewbinder.gcEditText(obj, 0x7f1003a9, "field 'gcEditText'"), 0x7f1003a9, "field 'gcEditText'");
        .er = (CustomErrorViewWrapper)viewbinder.gcInputWrapper((View)viewbinder.gcInputWrapper(obj, 0x7f1003aa, "field 'gcInputWrapper'"), 0x7f1003aa, "field 'gcInputWrapper'");
        . = (EditText)viewbinder.gcLastDigits((View)viewbinder.gcLastDigits(obj, 0x7f1003ac, "field 'gcLastDigits'"), 0x7f1003ac, "field 'gcLastDigits'");
        . = (BackSpaceDetectorEditText)viewbinder.gcAccessCode((View)viewbinder.gcAccessCode(obj, 0x7f1003ad, "field 'gcAccessCode'"), 0x7f1003ad, "field 'gcAccessCode'");
        . = (Button)viewbinder.redeemButton((View)viewbinder.redeemButton(obj, 0x7f1003af, "field 'redeemButton'"), 0x7f1003af, "field 'redeemButton'");
        . = (ImageView)viewbinder.scanButton((View)viewbinder.scanButton(obj, 0x7f1003ae, "field 'scanButton'"), 0x7f1003ae, "field 'scanButton'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.per = null;
        bind1.per = null;
        bind1.er = null;
        bind1. = null;
        bind1. = null;
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
