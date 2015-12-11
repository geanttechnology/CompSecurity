// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.common.NameView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (NameView)viewbinder.nameView((View)viewbinder.nameView(obj, 0x7f100371, "field 'nameView'"), 0x7f100371, "field 'nameView'");
        . = (EditText)viewbinder.emailId((View)viewbinder.emailId(obj, 0x7f100373, "field 'emailId'"), 0x7f100373, "field 'emailId'");
        .er = (CustomErrorViewWrapper)viewbinder.emailIdWrapper((View)viewbinder.emailIdWrapper(obj, 0x7f100372, "field 'emailIdWrapper'"), 0x7f100372, "field 'emailIdWrapper'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.er = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
