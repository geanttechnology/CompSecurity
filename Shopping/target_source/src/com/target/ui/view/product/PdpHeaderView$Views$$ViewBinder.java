// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.view.AisleBadgeView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (ImageView)viewbinder.calloutImage((View)viewbinder.iew(obj, 0x7f1004b8, "field 'calloutImage'"), 0x7f1004b8, "field 'calloutImage'");
        . = (TextView)viewbinder.storeName((View)viewbinder.iew(obj, 0x7f1004bd, "field 'storeName'"), 0x7f1004bd, "field 'storeName'");
        .ainer = (View)viewbinder.iew(obj, 0x7f1004b9, "field 'registryContainer'");
        .e = (ImageView)viewbinder.registryImage((View)viewbinder.iew(obj, 0x7f1004ba, "field 'registryImage'"), 0x7f1004ba, "field 'registryImage'");
        .e = (TextView)viewbinder.registryTitle((View)viewbinder.iew(obj, 0x7f1004bb, "field 'registryTitle'"), 0x7f1004bb, "field 'registryTitle'");
        .ility = (TextView)viewbinder.storeAvailability((View)viewbinder.iew(obj, 0x7f1004bc, "field 'storeAvailability'"), 0x7f1004bc, "field 'storeAvailability'");
        .bility = (TextView)viewbinder.onlineAvailability((View)viewbinder.iew(obj, 0x7f1004be, "field 'onlineAvailability'"), 0x7f1004be, "field 'onlineAvailability'");
        .bility = (AisleBadgeView)viewbinder.aisleBadge((View)viewbinder.iew(obj, 0x7f1004c0, "field 'aisleBadge'"), 0x7f1004c0, "field 'aisleBadge'");
        .bility = (ImageView)viewbinder.onlineIcon((View)viewbinder.iew(obj, 0x7f1004bf, "field 'onlineIcon'"), 0x7f1004bf, "field 'onlineIcon'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1. = null;
        bind1.ainer = null;
        bind1.e = null;
        bind1.e = null;
        bind1.ility = null;
        bind1.bility = null;
        bind1.bility = null;
        bind1.bility = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
