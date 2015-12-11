// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .t = (EditText)viewbinder.promoCodeText((View)viewbinder.promoCodeText(obj, 0x7f1003d6, "field 'promoCodeText'"), 0x7f1003d6, "field 'promoCodeText'");
        .or = (CustomErrorViewWrapper)viewbinder.promoCodeError((View)viewbinder.promoCodeError(obj, 0x7f1003d5, "field 'promoCodeError'"), 0x7f1003d5, "field 'promoCodeError'");
        .or = (Button)viewbinder.applyButton((View)viewbinder.applyButton(obj, 0x7f1003d8, "field 'applyButton'"), 0x7f1003d8, "field 'applyButton'");
        .ainer = (View)viewbinder.progressContainer(obj, 0x7f1003d7, "field 'progressContainer'");
        .ainer = (ProgressBar)viewbinder.progressBar((View)viewbinder.progressBar(obj, 0x7f1003d9, "field 'progressBar'"), 0x7f1003d9, "field 'progressBar'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.t = null;
        bind1.or = null;
        bind1.or = null;
        bind1.ainer = null;
        bind1.ainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
