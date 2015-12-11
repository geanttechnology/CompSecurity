// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (ProgressBar)viewbinder.progressBar((View)viewbinder.iew(obj, 0x7f1004e4, "field 'progressBar'"), 0x7f1004e4, "field 'progressBar'");
        . = (ImageButton)viewbinder.retry((View)viewbinder.iew(obj, 0x7f1004e5, "field 'retry'"), 0x7f1004e5, "field 'retry'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
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
