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
        .on = (TextView)viewbinder.helpAppVersion((View)viewbinder.helpAppVersion(obj, 0x7f1002cf, "field 'helpAppVersion'"), 0x7f1002cf, "field 'helpAppVersion'");
        .getBrand = (TextView)viewbinder.copyrightTargetBrand((View)viewbinder.copyrightTargetBrand(obj, 0x7f1002d1, "field 'copyrightTargetBrand'"), 0x7f1002d1, "field 'copyrightTargetBrand'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.on = null;
        bind1.getBrand = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
