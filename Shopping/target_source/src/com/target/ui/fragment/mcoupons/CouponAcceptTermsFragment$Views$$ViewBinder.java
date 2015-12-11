// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Q
    implements butterknife.t.Views..ViewBinder
{

    public void bind(butterknife.t.Views..ViewBinder viewbinder, Q q, Object obj)
    {
        q. = (Button)viewbinder.mAgreeButton((View)viewbinder.mAgreeButton(obj, 0x7f100162, "field 'mAgreeButton'"), 0x7f100162, "field 'mAgreeButton'");
        q.xt = (TextView)viewbinder.mAgreementText((View)viewbinder.mAgreementText(obj, 0x7f100161, "field 'mAgreementText'"), 0x7f100161, "field 'mAgreementText'");
    }

    public volatile void bind(butterknife.t.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1.xt = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public Q()
    {
    }
}
