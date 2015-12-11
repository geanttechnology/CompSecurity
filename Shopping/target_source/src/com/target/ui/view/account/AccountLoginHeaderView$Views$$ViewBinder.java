// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.TextView;

public class I
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (View)viewbinder.bullseye(obj, 0x7f1000a5, "field 'bullseye'");
        i.I = (View)viewbinder.errorLayout(obj, 0x7f1000a6, "field 'errorLayout'");
        i.I = (TextView)viewbinder.errorText((View)viewbinder.errorText(obj, 0x7f1000a7, "field 'errorText'"), 0x7f1000a7, "field 'errorText'");
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
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
