// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.codeText((View)viewbinder.codeText(obj, 0x7f1003d0, "field 'codeText'"), 0x7f1003d0, "field 'codeText'");
        . = (TextView)viewbinder.discount((View)viewbinder.discount(obj, 0x7f1003d1, "field 'discount'"), 0x7f1003d1, "field 'discount'");
        . = (View)viewbinder.removeBtn(obj, 0x7f1003d2, "field 'removeBtn'");
        . = (View)viewbinder.progress(obj, 0x7f1003d3, "field 'progress'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
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

    public ()
    {
    }
}
