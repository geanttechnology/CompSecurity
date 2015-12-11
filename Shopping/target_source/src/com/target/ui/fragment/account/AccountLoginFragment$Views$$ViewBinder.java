// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import com.target.ui.view.account.AccountCredentialsInputView;
import com.target.ui.view.account.AccountExternalLaunchView;
import com.target.ui.view.account.AccountInternalLaunchView;
import com.target.ui.view.account.AccountLoginHeaderView;
import com.target.ui.view.account.SettingsView;

public class 
    implements butterknife..Views..ViewBinder
{

    public void bind(butterknife..Views..ViewBinder viewbinder,  , Object obj)
    {
        .ner = (ScrollView)viewbinder.scrollContainer((View)viewbinder.scrollContainer(obj, 0x7f10010f, "field 'scrollContainer'"), 0x7f10010f, "field 'scrollContainer'");
        .ner = (AccountLoginHeaderView)viewbinder.header((View)viewbinder.header(obj, 0x7f100110, "field 'header'"), 0x7f100110, "field 'header'");
        .View = (AccountCredentialsInputView)viewbinder.iew((View)viewbinder.iew(obj, 0x7f100111, "field 'accountInputView'"), 0x7f100111, "field 'accountInputView'");
        .View = (Button)viewbinder.loginButton((View)viewbinder.loginButton(obj, 0x7f1000a4, "field 'loginButton'"), 0x7f1000a4, "field 'loginButton'");
        .rdButton = (View)viewbinder.forgotPasswordButton(obj, 0x7f1000a3, "field 'forgotPasswordButton'");
        .chView = (AccountExternalLaunchView)viewbinder.w((View)viewbinder.w(obj, 0x7f100112, "field 'externalLaunchView'"), 0x7f100112, "field 'externalLaunchView'");
        . = (SettingsView)viewbinder.settingsView((View)viewbinder.settingsView(obj, 0x7f100113, "field 'settingsView'"), 0x7f100113, "field 'settingsView'");
        .chView = (AccountInternalLaunchView)viewbinder.w((View)viewbinder.w(obj, 0x7f100114, "field 'internalLaunchView'"), 0x7f100114, "field 'internalLaunchView'");
    }

    public volatile void bind(butterknife..Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ner = null;
        bind1.ner = null;
        bind1.View = null;
        bind1.View = null;
        bind1.rdButton = null;
        bind1.chView = null;
        bind1. = null;
        bind1.chView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
