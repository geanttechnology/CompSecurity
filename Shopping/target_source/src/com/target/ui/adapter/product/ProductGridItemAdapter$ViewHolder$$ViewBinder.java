// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.View;
import com.target.ui.view.product.PlpCardView;

public class Q
    implements butterknife.older..ViewBinder
{

    public void bind(butterknife.older..ViewBinder viewbinder, Q q, Object obj)
    {
        q.Q = (PlpCardView)viewbinder.plpCardView((View)viewbinder.plpCardView(obj, 0x7f1004f3, "field 'plpCardView'"), 0x7f1004f3, "field 'plpCardView'");
    }

    public volatile void bind(butterknife.older..ViewBinder viewbinder, Object obj, Object obj1)
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

    public Q()
    {
    }
}
