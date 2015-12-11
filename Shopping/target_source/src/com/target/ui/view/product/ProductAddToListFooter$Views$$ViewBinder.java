// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class I
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (RadioButton)viewbinder.radioButton((View)viewbinder.radioButton(obj, 0x7f1002f6, "field 'radioButton'"), 0x7f1002f6, "field 'radioButton'");
        i.I = (EditText)viewbinder.editText((View)viewbinder.editText(obj, 0x7f1002f7, "field 'editText'"), 0x7f1002f7, "field 'editText'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
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

    public I()
    {
    }
}
