// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (EditText)viewbinder.password((View)viewbinder.password(obj, 0x7f1000ad, "field 'password'"), 0x7f1000ad, "field 'password'");
        . = (EditText)viewbinder.account((View)viewbinder.account(obj, 0x7f1000aa, "field 'account'"), 0x7f1000aa, "field 'account'");
        .per = (CustomErrorViewWrapper)viewbinder.passwordWrapper((View)viewbinder.passwordWrapper(obj, 0x7f1000ac, "field 'passwordWrapper'"), 0x7f1000ac, "field 'passwordWrapper'");
        .er = (CustomErrorViewWrapper)viewbinder.accountWrapper((View)viewbinder.accountWrapper(obj, 0x7f1000a9, "field 'accountWrapper'"), 0x7f1000a9, "field 'accountWrapper'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.per = null;
        bind1.er = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
