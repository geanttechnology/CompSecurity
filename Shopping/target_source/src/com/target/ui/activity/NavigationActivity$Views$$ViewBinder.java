// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.target.ui.view.ToolbarSpinner;

public class A
    implements butterknife.ViewBinder
{

    public void bind(butterknife.ViewBinder viewbinder, A a, Object obj)
    {
        a. = (DrawerLayout)viewbinder.rawerLayout((View)viewbinder.rawerLayout(obj, 0x7f1000ae, "field 'drawerLayout'"), 0x7f1000ae, "field 'drawerLayout'");
        a. = (TextView)viewbinder.ustomTitle((View)viewbinder.ustomTitle(obj, 0x7f1000b1, "field 'customTitle'"), 0x7f1000b1, "field 'customTitle'");
        a. = (Toolbar)viewbinder.oolbar((View)viewbinder.oolbar(obj, 0x7f1000b0, "field 'toolbar'"), 0x7f1000b0, "field 'toolbar'");
        a.er = (ToolbarSpinner)viewbinder.oolbarSpinner((View)viewbinder.oolbarSpinner(obj, 0x7f1000b2, "field 'toolbarSpinner'"), 0x7f1000b2, "field 'toolbarSpinner'");
        a.ainer = (View)viewbinder.ragmentContainer(obj, 0x7f1000af, "field 'fragmentContainer'");
        a.ainer = (View)viewbinder.ropShadow(obj, 0x7f1000b3, "field 'dropShadow'");
        a.ainer = (View)viewbinder.rogress(obj, 0x7f1000b4, "field 'progress'");
    }

    public volatile void bind(butterknife.ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1. = null;
        bind1. = null;
        bind1.er = null;
        bind1.ainer = null;
        bind1.ainer = null;
        bind1.ainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public A()
    {
    }
}
