// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class 
    implements butterknife.wHolder..ViewBinder
{

    public void bind(butterknife.wHolder..ViewBinder viewbinder,  , Object obj)
    {
        .mImage = (ImageView)viewbinder.mHeaderBottomImage((View)viewbinder.mHeaderBottomImage(obj, 0x7f0b00c1, "field 'mHeaderBottomImage'"), 0x7f0b00c1, "field 'mHeaderBottomImage'");
        .age = (ImageView)viewbinder.mHeaderTopImage((View)viewbinder.mHeaderTopImage(obj, 0x7f0b00c2, "field 'mHeaderTopImage'"), 0x7f0b00c2, "field 'mHeaderTopImage'");
        .age = (TextView)viewbinder.mTitleView((View)viewbinder.mTitleView(obj, 0x7f0b00c3, "field 'mTitleView'"), 0x7f0b00c3, "field 'mTitleView'");
        .ne = (View)viewbinder.mTopShadowLine(obj, 0x7f0b00c4, "field 'mTopShadowLine'");
    }

    public volatile void bind(butterknife.wHolder..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.mImage = null;
        bind1.age = null;
        bind1.age = null;
        bind1.ne = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
