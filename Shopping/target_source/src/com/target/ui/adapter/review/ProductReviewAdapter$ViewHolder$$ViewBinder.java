// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.review;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.StarRatingView;

public class 
    implements butterknife.lder..ViewBinder
{

    public void bind(butterknife.lder..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.mTitle((View)viewbinder.mTitle(obj, 0x7f10051f, "field 'mTitle'"), 0x7f10051f, "field 'mTitle'");
        . = (TextView)viewbinder.mDate((View)viewbinder.mDate(obj, 0x7f100520, "field 'mDate'"), 0x7f100520, "field 'mDate'");
        . = (TextView)viewbinder.mName((View)viewbinder.mName(obj, 0x7f100521, "field 'mName'"), 0x7f100521, "field 'mName'");
        . = (TextView)viewbinder.mReview((View)viewbinder.mReview(obj, 0x7f100523, "field 'mReview'"), 0x7f100523, "field 'mReview'");
        . = (StarRatingView)viewbinder.mRating((View)viewbinder.mRating(obj, 0x7f100522, "field 'mRating'"), 0x7f100522, "field 'mRating'");
    }

    public volatile void bind(butterknife.lder..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
