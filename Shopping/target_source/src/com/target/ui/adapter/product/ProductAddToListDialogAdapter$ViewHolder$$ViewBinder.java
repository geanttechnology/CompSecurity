// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class 
    implements butterknife.older..ViewBinder
{

    public void bind(butterknife.older..ViewBinder viewbinder,  , Object obj)
    {
        . = (RadioButton)viewbinder.radioButton((View)viewbinder.radioButton(obj, 0x7f1002f4, "field 'radioButton'"), 0x7f1002f4, "field 'radioButton'");
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f1001b2, "field 'title'"), 0x7f1001b2, "field 'title'");
    }

    public volatile void bind(butterknife.older..ViewBinder viewbinder, Object obj, Object obj1)
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
