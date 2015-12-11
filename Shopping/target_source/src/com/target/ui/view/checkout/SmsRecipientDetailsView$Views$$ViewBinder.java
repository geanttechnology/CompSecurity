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
        . = (View)viewbinder.root(obj, 0x7f1003ea, "field 'root'");
        .Number = (TextView)viewbinder.smsRecipientNumber((View)viewbinder.smsRecipientNumber(obj, 0x7f1003ed, "field 'smsRecipientNumber'"), 0x7f1003ed, "field 'smsRecipientNumber'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.Number = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
