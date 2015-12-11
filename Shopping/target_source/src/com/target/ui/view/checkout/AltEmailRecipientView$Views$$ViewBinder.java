// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;

public class I
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (EditText)viewbinder.toName((View)viewbinder.toName(obj, 0x7f10036c, "field 'toName'"), 0x7f10036c, "field 'toName'");
        i.I = (EditText)viewbinder.email((View)viewbinder.email(obj, 0x7f10036e, "field 'email'"), 0x7f10036e, "field 'email'");
        i.I = (EditText)viewbinder.fromName((View)viewbinder.fromName(obj, 0x7f100370, "field 'fromName'"), 0x7f100370, "field 'fromName'");
        i.r = (CustomErrorViewWrapper)viewbinder.toNameWrapper((View)viewbinder.toNameWrapper(obj, 0x7f10036b, "field 'toNameWrapper'"), 0x7f10036b, "field 'toNameWrapper'");
        i. = (CustomErrorViewWrapper)viewbinder.emailWrapper((View)viewbinder.emailWrapper(obj, 0x7f10036d, "field 'emailWrapper'"), 0x7f10036d, "field 'emailWrapper'");
        i.per = (CustomErrorViewWrapper)viewbinder.fromNameWrapper((View)viewbinder.fromNameWrapper(obj, 0x7f10036f, "field 'fromNameWrapper'"), 0x7f10036f, "field 'fromNameWrapper'");
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
        bind1.r = null;
        bind1. = null;
        bind1.per = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
