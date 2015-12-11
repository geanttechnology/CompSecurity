// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class I
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f1004d5, "field 'title'"), 0x7f1004d5, "field 'title'");
        i.ons = (RecyclerView)viewbinder.recommendations((View)viewbinder.recommendations(obj, 0x7f1004d6, "field 'recommendations'"), 0x7f1004d6, "field 'recommendations'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.ons = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
