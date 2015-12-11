// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class 
    implements butterknife.Holder..ViewBinder
{

    public void bind(butterknife.Holder..ViewBinder viewbinder,  , Object obj)
    {
        .oice = (RadioButton)viewbinder.walletItemChoice((View)viewbinder.walletItemChoice(obj, 0x7f100305, "field 'walletItemChoice'"), 0x7f100305, "field 'walletItemChoice'");
        .oice = (TextView)viewbinder.walletTitle((View)viewbinder.walletTitle(obj, 0x7f100307, "field 'walletTitle'"), 0x7f100307, "field 'walletTitle'");
        .le = (TextView)viewbinder.walletSubTitle((View)viewbinder.walletSubTitle(obj, 0x7f100308, "field 'walletSubTitle'"), 0x7f100308, "field 'walletSubTitle'");
        .le = (ImageButton)viewbinder.walletInfo((View)viewbinder.walletInfo(obj, 0x7f100306, "field 'walletInfo'"), 0x7f100306, "field 'walletInfo'");
    }

    public volatile void bind(butterknife.Holder..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.oice = null;
        bind1.oice = null;
        bind1.le = null;
        bind1.le = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
