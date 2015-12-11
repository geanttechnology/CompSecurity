// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import com.target.ui.view.account.AccountSessionDetailsView;

public class 
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (AccountSessionDetailsView)viewbinder.session((View)viewbinder.session(obj, 0x7f10011f, "field 'session'"), 0x7f10011f, "field 'session'");
        .n = (View)viewbinder.signOutButton(obj, 0x7f100121, "field 'signOutButton'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.n = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
