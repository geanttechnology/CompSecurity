// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.view.ExpandableImageViewPager;

public class 
    implements butterknife.iews..ViewBinder
{

    public void bind(butterknife.iews..ViewBinder viewbinder,  , Object obj)
    {
        .mage = (ImageView)viewbinder.placeholderImage((View)viewbinder.placeholderImage(obj, 0x7f1005e8, "field 'placeholderImage'"), 0x7f1005e8, "field 'placeholderImage'");
        .mage = (TextView)viewbinder.dates((View)viewbinder.dates(obj, 0x7f1005e6, "field 'dates'"), 0x7f1005e6, "field 'dates'");
        .mage = (ExpandableImageViewPager)viewbinder.pager((View)viewbinder.pager(obj, 0x7f1005e7, "field 'pager'"), 0x7f1005e7, "field 'pager'");
    }

    public volatile void bind(butterknife.iews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.mage = null;
        bind1.mage = null;
        bind1.mage = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
