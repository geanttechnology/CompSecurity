// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class 
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.storeName((View)viewbinder.storeName(obj, 0x7f10059b, "field 'storeName'"), 0x7f10059b, "field 'storeName'");
        .tn = (Button)viewbinder.changeStoreBtn((View)viewbinder.changeStoreBtn(obj, 0x7f10059c, "field 'changeStoreBtn'"), 0x7f10059c, "field 'changeStoreBtn'");
    }

    public volatile void bind(butterknife.s..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.tn = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
