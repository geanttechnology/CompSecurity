// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.navigation;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.Views..ViewBinder
{

    public void bind(butterknife.Views..ViewBinder viewbinder,  , Object obj)
    {
        .ext = (TextView)viewbinder.accountNameText((View)viewbinder.accountNameText(obj, 0x7f10047e, "field 'accountNameText'"), 0x7f10047e, "field 'accountNameText'");
        .e = (View)viewbinder.bullseyeLarge(obj, 0x7f10047d, "field 'bullseyeLarge'");
        .l = (View)viewbinder.bullseyeSmall(obj, 0x7f10047c, "field 'bullseyeSmall'");
    }

    public volatile void bind(butterknife.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ext = null;
        bind1.e = null;
        bind1.l = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
