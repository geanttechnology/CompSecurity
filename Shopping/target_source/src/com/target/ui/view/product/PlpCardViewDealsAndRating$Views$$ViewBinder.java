// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.ui.view.StarRatingView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .ew = (StarRatingView)viewbinder.starRatingView((View)viewbinder.starRatingView(obj, 0x7f1004f0, "field 'starRatingView'"), 0x7f1004f0, "field 'starRatingView'");
        .w = (View)viewbinder.noRatingsView(obj, 0x7f1004f1, "field 'noRatingsView'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ew = null;
        bind1.w = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
