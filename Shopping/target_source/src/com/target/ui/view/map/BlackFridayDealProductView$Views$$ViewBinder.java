// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;

public class I
    implements butterknife.ViewBinder
{

    public void bind(butterknife.ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (View)viewbinder.oot(obj, 0x7f10046b, "field 'root'");
        i.I = (BitmapImageView)viewbinder.mage((View)viewbinder.mage(obj, 0x7f10046c, "field 'image'"), 0x7f10046c, "field 'image'");
        i.I = (TextView)viewbinder.itle((View)viewbinder.itle(obj, 0x7f10046d, "field 'title'"), 0x7f10046d, "field 'title'");
        i.I = (TextView)viewbinder.rice((View)viewbinder.rice(obj, 0x7f10046e, "field 'price'"), 0x7f10046e, "field 'price'");
    }

    public volatile void bind(butterknife.ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
