// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.list;

import android.view.View;

public class 
    implements butterknife.er..ViewBinder
{

    public void bind(butterknife.er..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.gripper(obj, 0x7f1002a9, "field 'gripper'");
    }

    public volatile void bind(butterknife.er..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
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
