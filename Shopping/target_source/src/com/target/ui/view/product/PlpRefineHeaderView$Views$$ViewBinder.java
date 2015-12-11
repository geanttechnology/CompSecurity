// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.target.ui.view.ConfigurableDropShadowView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (ConfigurableDropShadowView)viewbinder.dropShadow((View)viewbinder.dropShadow(obj, 0x7f100509, "field 'dropShadow'"), 0x7f100509, "field 'dropShadow'");
        . = (RecyclerView)viewbinder.recyclerView((View)viewbinder.recyclerView(obj, 0x7f10016f, "field 'recyclerView'"), 0x7f10016f, "field 'recyclerView'");
        . = (TextView)viewbinder.resultCount((View)viewbinder.resultCount(obj, 0x7f10050a, "field 'resultCount'"), 0x7f10050a, "field 'resultCount'");
        . = (View)viewbinder.refineButton(obj, 0x7f100170, "field 'refineButton'");
        .tWrapper = (View)viewbinder.selectedFacetWrapper(obj, 0x7f100507, "field 'selectedFacetWrapper'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1. = null;
        bind1. = null;
        bind1. = null;
        bind1.tWrapper = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
