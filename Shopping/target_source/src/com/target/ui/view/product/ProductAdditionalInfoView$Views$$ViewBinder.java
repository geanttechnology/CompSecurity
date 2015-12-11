// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f1004cc, "field 'title'"), 0x7f1004cc, "field 'title'");
        . = (TextView)viewbinder.tcin((View)viewbinder.tcin(obj, 0x7f1004cd, "field 'tcin'"), 0x7f1004cd, "field 'tcin'");
        . = (TextView)viewbinder.upc((View)viewbinder.upc(obj, 0x7f1004ce, "field 'upc'"), 0x7f1004ce, "field 'upc'");
        . = (TextView)viewbinder.dpci((View)viewbinder.dpci(obj, 0x7f1004cf, "field 'dpci'"), 0x7f1004cf, "field 'dpci'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
