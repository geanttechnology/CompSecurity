// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.container(obj, 0x7f10059e, "field 'container'");
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f10059f, "field 'title'"), 0x7f10059f, "field 'title'");
    }

    public volatile void bind(butterknife.s..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
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
