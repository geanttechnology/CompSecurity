// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.ImageView;
import com.target.ui.view.BitmapImageView;

public class 
    implements butterknife.er..ViewBinder
{

    public void bind(butterknife.er..ViewBinder viewbinder,  , Object obj)
    {
        . = (BitmapImageView)viewbinder.imageView((View)viewbinder.imageView(obj, 0x7f1004d9, "field 'imageView'"), 0x7f1004d9, "field 'imageView'");
        . = (ImageView)viewbinder.checkView((View)viewbinder.checkView(obj, 0x7f1004da, "field 'checkView'"), 0x7f1004da, "field 'checkView'");
        . = (ImageView)viewbinder.greyOut((View)viewbinder.greyOut(obj, 0x7f1004db, "field 'greyOut'"), 0x7f1004db, "field 'greyOut'");
    }

    public volatile void bind(butterknife.er..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
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
