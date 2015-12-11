// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (RadioButton)viewbinder.radioButton((View)viewbinder.w(obj, 0x7f10048b, "field 'radioButton'"), 0x7f10048b, "field 'radioButton'");
        . = (ImageView)viewbinder.cardImage((View)viewbinder.w(obj, 0x7f10048c, "field 'cardImage'"), 0x7f10048c, "field 'cardImage'");
        . = (TextView)viewbinder.cardNumber((View)viewbinder.w(obj, 0x7f10048d, "field 'cardNumber'"), 0x7f10048d, "field 'cardNumber'");
        . = (TextView)viewbinder.subtitle((View)viewbinder.w(obj, 0x7f10048e, "field 'subtitle'"), 0x7f10048e, "field 'subtitle'");
        . = (View)viewbinder.w(obj, 0x7f10048f, "field 'editButton'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
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
