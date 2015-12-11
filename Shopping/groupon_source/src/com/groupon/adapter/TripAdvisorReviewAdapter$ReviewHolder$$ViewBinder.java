// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.TripAdvisorRatingBar;

public class 
    implements butterknife.wBinder
{

    public void bind(butterknife.wBinder wbinder,  , Object obj)
    {
        . = (TripAdvisorRatingBar)wbinder.ngBar((View)wbinder.ngBar(obj, 0x7f100566, "field 'ratingBar'"), 0x7f100566, "field 'ratingBar'");
        . = (TextView)wbinder.ewerName((View)wbinder.ewerName(obj, 0x7f100567, "field 'reviewerName'"), 0x7f100567, "field 'reviewerName'");
        . = (TextView)wbinder.((View)wbinder.(obj, 0x7f100568, "field 'date'"), 0x7f100568, "field 'date'");
        . = (TextView)wbinder.e((View)wbinder.e(obj, 0x7f100569, "field 'title'"), 0x7f100569, "field 'title'");
        . = (TextView)wbinder.((View)wbinder.(obj, 0x7f10056a, "field 'body'"), 0x7f10056a, "field 'body'");
    }

    public volatile void bind(butterknife.wBinder wbinder, Object obj, Object obj1)
    {
        bind(wbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1. = null;
        bind1. = null;
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
