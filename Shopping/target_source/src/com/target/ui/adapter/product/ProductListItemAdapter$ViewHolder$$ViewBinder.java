// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.View;
import com.target.ui.view.product.PlpListItemView;

public class Q
    implements butterknife.older..ViewBinder
{

    public void bind(butterknife.older..ViewBinder viewbinder, Q q, Object obj)
    {
        q. = (PlpListItemView)viewbinder.listItemView((View)viewbinder.listItemView(obj, 0x7f1004fc, "field 'listItemView'"), 0x7f1004fc, "field 'listItemView'");
    }

    public volatile void bind(butterknife.older..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public Q()
    {
    }
}
