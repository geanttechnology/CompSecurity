// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .er = (TargetErrorView)viewbinder.errorContainer((View)viewbinder.iew(obj, 0x7f1001c6, "field 'errorContainer'"), 0x7f1001c6, "field 'errorContainer'");
        .er = (TextView)viewbinder.find((View)viewbinder.iew(obj, 0x7f1004f8, "field 'find'"), 0x7f1004f8, "field 'find'");
        .er = (TextView)viewbinder.inStore((View)viewbinder.iew(obj, 0x7f1004f9, "field 'inStore'"), 0x7f1004f9, "field 'inStore'");
        .er = (AisleBadgeView)viewbinder.aisle((View)viewbinder.iew(obj, 0x7f1004f7, "field 'aisle'"), 0x7f1004f7, "field 'aisle'");
        .nHeader = (View)viewbinder.iew(obj, 0x7f1004f5, "field 'storeLocationHeader'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.er = null;
        bind1.er = null;
        bind1.er = null;
        bind1.er = null;
        bind1.nHeader = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
