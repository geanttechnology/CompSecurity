// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.navigation;

import android.view.View;

// Referenced classes of package com.target.ui.view.navigation:
//            NavigationStoreView

public class 
    implements butterknife.Views..ViewBinder
{

    public void bind(butterknife.Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (NavigationStoreView)viewbinder.currentStore((View)viewbinder.currentStore(obj, 0x7f100482, "field 'currentStore'"), 0x7f100482, "field 'currentStore'");
        . = (View)viewbinder.editStore(obj, 0x7f100483, "field 'editStore'");
    }

    public volatile void bind(butterknife.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
