// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        . = (BitmapImageView)viewbinder.image((View)viewbinder.(obj, 0x7f10007c, "field 'image'"), 0x7f10007c, "field 'image'");
        . = (TextView)viewbinder.displayText((View)viewbinder.(obj, 0x7f1002b4, "field 'displayText'"), 0x7f1002b4, "field 'displayText'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
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
