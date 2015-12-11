// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.view.TargetButton;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .etRowTitle = (TextView)viewbinder.tvCouponWalletRowTitle((View)viewbinder.tvCouponWalletRowTitle(obj, 0x7f100390, "field 'tvCouponWalletRowTitle'"), 0x7f100390, "field 'tvCouponWalletRowTitle'");
        .etRowSubTitle = (TextView)viewbinder.tvCouponWalletRowSubTitle((View)viewbinder.tvCouponWalletRowSubTitle(obj, 0x7f100391, "field 'tvCouponWalletRowSubTitle'"), 0x7f100391, "field 'tvCouponWalletRowSubTitle'");
        .Wallet = (ImageView)viewbinder.ivEditCouponWallet((View)viewbinder.ivEditCouponWallet(obj, 0x7f100392, "field 'ivEditCouponWallet'"), 0x7f100392, "field 'ivEditCouponWallet'");
        .Wallet = (TargetButton)viewbinder.buttonApply((View)viewbinder.buttonApply(obj, 0x7f10038f, "field 'buttonApply'"), 0x7f10038f, "field 'buttonApply'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.etRowTitle = null;
        bind1.etRowSubTitle = null;
        bind1.Wallet = null;
        bind1.Wallet = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
