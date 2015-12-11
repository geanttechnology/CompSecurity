// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (TextView)viewbinder.titleTV((View)viewbinder.titleTV(obj, 0x7f1000d3, "field 'titleTV'"), 0x7f1000d3, "field 'titleTV'");
        . = (TextView)viewbinder.messageTV((View)viewbinder.messageTV(obj, 0x7f1000d4, "field 'messageTV'"), 0x7f1000d4, "field 'messageTV'");
        . = (RadioGroup)viewbinder.radioGroup((View)viewbinder.radioGroup(obj, 0x7f1000d5, "field 'radioGroup'"), 0x7f1000d5, "field 'radioGroup'");
        .o = (RadioButton)viewbinder.clearAllRadio((View)viewbinder.clearAllRadio(obj, 0x7f1000d6, "field 'clearAllRadio'"), 0x7f1000d6, "field 'clearAllRadio'");
        .edRadio = (RadioButton)viewbinder.clearCompletedRadio((View)viewbinder.clearCompletedRadio(obj, 0x7f1000d7, "field 'clearCompletedRadio'"), 0x7f1000d7, "field 'clearCompletedRadio'");
        .edRadio = (Button)viewbinder.cancelBtn((View)viewbinder.cancelBtn(obj, 0x7f1000d8, "field 'cancelBtn'"), 0x7f1000d8, "field 'cancelBtn'");
        .edRadio = (Button)viewbinder.clearBtn((View)viewbinder.clearBtn(obj, 0x7f1000d9, "field 'clearBtn'"), 0x7f1000d9, "field 'clearBtn'");
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
        bind1.o = null;
        bind1.edRadio = null;
        bind1.edRadio = null;
        bind1.edRadio = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
