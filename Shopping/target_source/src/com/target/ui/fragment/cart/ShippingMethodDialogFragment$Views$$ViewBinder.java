// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .ainer = (View)viewbinder.progressContainer(obj, 0x7f1001fa, "field 'progressContainer'");
        .MethodsContent = (View)viewbinder.cartShippingMethodsContent(obj, 0x7f100353, "field 'cartShippingMethodsContent'");
        .er = (TargetErrorView)viewbinder.errorContainer((View)viewbinder.errorContainer(obj, 0x7f100352, "field 'errorContainer'"), 0x7f100352, "field 'errorContainer'");
        .odListView = (ListView)viewbinder.shippingMethodListView((View)viewbinder.shippingMethodListView(obj, 0x7f100354, "field 'shippingMethodListView'"), 0x7f100354, "field 'shippingMethodListView'");
        .odListView = (Button)viewbinder.applyButton((View)viewbinder.applyButton(obj, 0x7f100355, "field 'applyButton'"), 0x7f100355, "field 'applyButton'");
        . = (Button)viewbinder.cancelButton((View)viewbinder.cancelButton(obj, 0x7f100356, "field 'cancelButton'"), 0x7f100356, "field 'cancelButton'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ainer = null;
        bind1.MethodsContent = null;
        bind1.er = null;
        bind1.odListView = null;
        bind1.odListView = null;
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
