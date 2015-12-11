// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.ui.view.RevealImageView;
import com.target.ui.view.account.ForgotPasswordInputView;

public class 
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (RevealImageView)viewbinder.bullseye((View)viewbinder.bullseye(obj, 0x7f1000f8, "field 'bullseye'"), 0x7f1000f8, "field 'bullseye'");
        .r = (View)viewbinder.textContainer(obj, 0x7f1000f9, "field 'textContainer'");
        .ainer = (View)viewbinder.textSentContainer(obj, 0x7f1000fc, "field 'textSentContainer'");
        .ainer = (TextView)viewbinder.header((View)viewbinder.header(obj, 0x7f1000fa, "field 'header'"), 0x7f1000fa, "field 'header'");
        .ainer = (TextView)viewbinder.message((View)viewbinder.message(obj, 0x7f1000fb, "field 'message'"), 0x7f1000fb, "field 'message'");
        .ainer = (ForgotPasswordInputView)viewbinder.emailInput((View)viewbinder.emailInput(obj, 0x7f1000ff, "field 'emailInput'"), 0x7f1000ff, "field 'emailInput'");
        .iner = (ViewGroup)viewbinder.contentContainer((View)viewbinder.contentContainer(obj, 0x7f1000f7, "field 'contentContainer'"), 0x7f1000f7, "field 'contentContainer'");
        .ainer = (ViewGroup)viewbinder.progressContainer((View)viewbinder.progressContainer(obj, 0x7f1001fa, "field 'progressContainer'"), 0x7f1001fa, "field 'progressContainer'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.r = null;
        bind1.ainer = null;
        bind1.ainer = null;
        bind1.ainer = null;
        bind1.ainer = null;
        bind1.iner = null;
        bind1.ainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
