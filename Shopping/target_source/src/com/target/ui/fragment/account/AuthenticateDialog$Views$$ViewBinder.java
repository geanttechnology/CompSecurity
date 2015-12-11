// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.view.account.AccountCredentialsInputView;

public class I
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (AccountCredentialsInputView)viewbinder.tView((View)viewbinder.tView(obj, 0x7f1000ef, "field 'credentials'"), 0x7f1000ef, "field 'credentials'");
        i. = (Button)viewbinder.signInButton((View)viewbinder.signInButton(obj, 0x7f1000a4, "field 'signInButton'"), 0x7f1000a4, "field 'signInButton'");
        i.rd = (View)viewbinder.forgotPassword(obj, 0x7f1000a3, "field 'forgotPassword'");
        i.r = (View)viewbinder.formContainer(obj, 0x7f1000eb, "field 'formContainer'");
        i.ainer = (View)viewbinder.progressContainer(obj, 0x7f1001fa, "field 'progressContainer'");
        i.er = (View)viewbinder.errorContainer(obj, 0x7f1000ed, "field 'errorContainer'");
        i.er = (TextView)viewbinder.errorText((View)viewbinder.errorText(obj, 0x7f1000ee, "field 'errorText'"), 0x7f1000ee, "field 'errorText'");
        i.er = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f1000ec, "field 'title'"), 0x7f1000ec, "field 'title'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1. = null;
        bind1.rd = null;
        bind1.r = null;
        bind1.ainer = null;
        bind1.er = null;
        bind1.er = null;
        bind1.er = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
