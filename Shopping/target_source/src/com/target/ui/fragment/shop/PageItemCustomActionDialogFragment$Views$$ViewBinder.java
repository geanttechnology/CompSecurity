// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (ImageView)viewbinder.imageView((View)viewbinder.imageView(obj, 0x7f100169, "field 'imageView'"), 0x7f100169, "field 'imageView'");
        . = (TextView)viewbinder.textView((View)viewbinder.textView(obj, 0x7f10016a, "field 'textView'"), 0x7f10016a, "field 'textView'");
        .nButton = (Button)viewbinder.primaryActionButton((View)viewbinder.primaryActionButton(obj, 0x7f10016d, "field 'primaryActionButton'"), 0x7f10016d, "field 'primaryActionButton'");
        .ionButton = (Button)viewbinder.secondaryActionButton((View)viewbinder.secondaryActionButton(obj, 0x7f10016c, "field 'secondaryActionButton'"), 0x7f10016c, "field 'secondaryActionButton'");
        .out = (LinearLayout)viewbinder.twoButtonLayout((View)viewbinder.twoButtonLayout(obj, 0x7f10016b, "field 'twoButtonLayout'"), 0x7f10016b, "field 'twoButtonLayout'");
        .Button = (Button)viewbinder.singleActionButton((View)viewbinder.singleActionButton(obj, 0x7f10016e, "field 'singleActionButton'"), 0x7f10016e, "field 'singleActionButton'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.nButton = null;
        bind1.ionButton = null;
        bind1.out = null;
        bind1.Button = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
