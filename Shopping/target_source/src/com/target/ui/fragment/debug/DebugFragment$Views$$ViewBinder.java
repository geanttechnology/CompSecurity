// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.debug;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class 
    implements butterknife.iews..ViewBinder
{

    public void bind(butterknife.iews..ViewBinder viewbinder,  , Object obj)
    {
        .tch = (CheckBox)viewbinder.taplyticsSwitch((View)viewbinder.iew(obj, 0x7f100177, "field 'taplyticsSwitch'"), 0x7f100177, "field 'taplyticsSwitch'");
        .pinner = (Spinner)viewbinder.environmentSpinner((View)viewbinder.iew(obj, 0x7f100173, "field 'environmentSpinner'"), 0x7f100173, "field 'environmentSpinner'");
        .pinner = (TextView)viewbinder.deviceSpecs((View)viewbinder.iew(obj, 0x7f100174, "field 'deviceSpecs'"), 0x7f100174, "field 'deviceSpecs'");
        .ry = (Button)viewbinder.launchRegistry((View)viewbinder.iew(obj, 0x7f100179, "field 'launchRegistry'"), 0x7f100179, "field 'launchRegistry'");
        .ater = (Button)viewbinder.getSavedForLater((View)viewbinder.iew(obj, 0x7f10017a, "field 'getSavedForLater'"), 0x7f10017a, "field 'getSavedForLater'");
        .ext = (EditText)viewbinder.storeIdEditText((View)viewbinder.iew(obj, 0x7f100175, "field 'storeIdEditText'"), 0x7f100175, "field 'storeIdEditText'");
        .ext = (Button)viewbinder.vlcButton((View)viewbinder.iew(obj, 0x7f100176, "field 'vlcButton'"), 0x7f100176, "field 'vlcButton'");
        .pinner = (Spinner)viewbinder.inStoreModeSpinner((View)viewbinder.iew(obj, 0x7f100178, "field 'inStoreModeSpinner'"), 0x7f100178, "field 'inStoreModeSpinner'");
    }

    public volatile void bind(butterknife.iews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.tch = null;
        bind1.pinner = null;
        bind1.pinner = null;
        bind1.ry = null;
        bind1.ater = null;
        bind1.ext = null;
        bind1.ext = null;
        bind1.pinner = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
