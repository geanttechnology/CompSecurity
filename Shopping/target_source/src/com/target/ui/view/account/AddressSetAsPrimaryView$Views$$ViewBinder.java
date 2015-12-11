// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import com.target.ui.view.TargetCheckBox;
import com.target.ui.view.TargetTextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (TargetCheckBox)viewbinder.checkBox((View)viewbinder.checkBox(obj, 0x7f1002f8, "field 'checkBox'"), 0x7f1002f8, "field 'checkBox'");
        . = (TargetTextView)viewbinder.description((View)viewbinder.description(obj, 0x7f1002f9, "field 'description'"), 0x7f1002f9, "field 'description'");
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
