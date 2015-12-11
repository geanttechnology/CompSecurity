// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;

public class Q
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder, Q q, Object obj)
    {
        q.istoryButton = (View)viewbinder.clearRecentHistoryButton(obj, 0x7f100441, "field 'clearRecentHistoryButton'");
    }

    public volatile void bind(butterknife.s..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.istoryButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public Q()
    {
    }
}
