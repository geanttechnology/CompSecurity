// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.view.cart:
//            SavedForLaterOverflowView

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        . = (BitmapImageView)viewbinder.image((View)viewbinder.image(obj, 0x7f10058d, "field 'image'"), 0x7f10058d, "field 'image'");
        . = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f10058e, "field 'title'"), 0x7f10058e, "field 'title'");
        . = (TextView)viewbinder.outOfStock((View)viewbinder.outOfStock(obj, 0x7f10058f, "field 'outOfStock'"), 0x7f10058f, "field 'outOfStock'");
        . = (TextView)viewbinder.price((View)viewbinder.price(obj, 0x7f100590, "field 'price'"), 0x7f100590, "field 'price'");
        . = (SavedForLaterOverflowView)viewbinder.overflow((View)viewbinder.overflow(obj, 0x7f100591, "field 'overflow'"), 0x7f100591, "field 'overflow'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
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
