// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (ImageView)viewbinder.cardImg((View)viewbinder.cardImg(obj, 0x7f1003b5, "field 'cardImg'"), 0x7f1003b5, "field 'cardImg'");
        . = (EditText)viewbinder.cardText((View)viewbinder.cardText(obj, 0x7f1003b7, "field 'cardText'"), 0x7f1003b7, "field 'cardText'");
        . = (EditText)viewbinder.lastCardText((View)viewbinder.lastCardText(obj, 0x7f1003ba, "field 'lastCardText'"), 0x7f1003ba, "field 'lastCardText'");
        . = (BackSpaceDetectorEditText)viewbinder.expiryText((View)viewbinder.expiryText(obj, 0x7f1003bb, "field 'expiryText'"), 0x7f1003bb, "field 'expiryText'");
        .Text = (BackSpaceDetectorEditText)viewbinder.securityCodeText((View)viewbinder.securityCodeText(obj, 0x7f1003bc, "field 'securityCodeText'"), 0x7f1003bc, "field 'securityCodeText'");
        .per = (CustomErrorViewWrapper)viewbinder.cardTextWrapper((View)viewbinder.cardTextWrapper(obj, 0x7f1003b6, "field 'cardTextWrapper'"), 0x7f1003b6, "field 'cardTextWrapper'");
        .pper = (CustomErrorViewWrapper)viewbinder.pinAndCvvWrapper((View)viewbinder.pinAndCvvWrapper(obj, 0x7f1003b8, "field 'pinAndCvvWrapper'"), 0x7f1003b8, "field 'pinAndCvvWrapper'");
        .eView = (ImageView)viewbinder.scanCardImageView((View)viewbinder.scanCardImageView(obj, 0x7f1003be, "field 'scanCardImageView'"), 0x7f1003be, "field 'scanCardImageView'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1. = null;
        bind1. = null;
        bind1.Text = null;
        bind1.per = null;
        bind1.pper = null;
        bind1.eView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
