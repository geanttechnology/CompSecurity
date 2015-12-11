// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.search;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.view.AisleBadgeView;

public class 
    implements butterknife.lder..ViewBinder
{

    public void bind(butterknife.lder..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f100445, "field 'title'"), 0x7f100445, "field 'title'");
        . = (AisleBadgeView)viewbinder.aisle((View)viewbinder.aisle(obj, 0x7f100446, "field 'aisle'"), 0x7f100446, "field 'aisle'");
        .age = (ImageView)viewbinder.searchEditImage((View)viewbinder.searchEditImage(obj, 0x7f100447, "field 'searchEditImage'"), 0x7f100447, "field 'searchEditImage'");
    }

    public volatile void bind(butterknife.lder..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.age = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
