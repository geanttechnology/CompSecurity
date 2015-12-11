// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class 
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder,  , Object obj)
    {
        . = (CheckBox)viewbinder.checkBox((View)viewbinder.checkBox(obj, 0x7f10055d, "field 'checkBox'"), 0x7f10055d, "field 'checkBox'");
        . = (TextView)viewbinder.count((View)viewbinder.count(obj, 0x7f10055e, "field 'count'"), 0x7f10055e, "field 'count'");
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
