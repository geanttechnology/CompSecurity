// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.EditText;

public class 
    implements butterknife.s..ViewBinder
{

    public void bind(butterknife.s..ViewBinder viewbinder,  , Object obj)
    {
        . = (EditText)viewbinder.searchField((View)viewbinder.searchField(obj, 0x7f1005a8, "field 'searchField'"), 0x7f1005a8, "field 'searchField'");
        . = (View)viewbinder.backButton(obj, 0x7f1005a9, "field 'backButton'");
        . = (View)viewbinder.clearButton(obj, 0x7f1005aa, "field 'clearButton'");
        . = (View)viewbinder.scanButton(obj, 0x7f1005ac, "field 'scanButton'");
        .utton = (View)viewbinder.voiceSearchButton(obj, 0x7f1005ab, "field 'voiceSearchButton'");
    }

    public volatile void bind(butterknife.s..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.utton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
