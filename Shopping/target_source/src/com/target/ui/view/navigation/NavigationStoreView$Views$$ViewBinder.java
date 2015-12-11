// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.navigation;

import android.view.View;
import android.widget.TextView;

public class I
    implements butterknife.Views..ViewBinder
{

    public void bind(butterknife.Views..ViewBinder viewbinder, I i, Object obj)
    {
        i.tion = (TextView)viewbinder.storeDescription((View)viewbinder.storeDescription(obj, 0x7f10047f, "field 'storeDescription'"), 0x7f10047f, "field 'storeDescription'");
        i.n = (TextView)viewbinder.storeLocation((View)viewbinder.storeLocation(obj, 0x7f100480, "field 'storeLocation'"), 0x7f100480, "field 'storeLocation'");
    }

    public volatile void bind(butterknife.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.tion = null;
        bind1.n = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
