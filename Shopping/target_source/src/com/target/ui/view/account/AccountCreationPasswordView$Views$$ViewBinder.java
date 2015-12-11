// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (CustomErrorViewWrapper)viewbinder.error((View)viewbinder.error(obj, 0x7f1000ac, "field 'error'"), 0x7f1000ac, "field 'error'");
        . = (EditText)viewbinder.input((View)viewbinder.input(obj, 0x7f1000ad, "field 'input'"), 0x7f1000ad, "field 'input'");
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
