// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.banner(obj, 0x7f1000a8, "field 'banner'");
        .er = (View)viewbinder.errorContainer(obj, 0x7f1000a6, "field 'errorContainer'");
        .er = (TextView)viewbinder.errorText((View)viewbinder.errorText(obj, 0x7f1000a7, "field 'errorText'"), 0x7f1000a7, "field 'errorText'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.er = null;
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
