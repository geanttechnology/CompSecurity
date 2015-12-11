// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;

// Referenced classes of package com.target.ui.view.checkout:
//            PaymentCardEntryView, PaymentCardStaticView, AddressFormView

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.dView(obj, 0x7f10037d, "field 'progressBar'");
        . = (PaymentCardEntryView)viewbinder.ryView((View)viewbinder.dView(obj, 0x7f10037a, "field 'card'"), 0x7f10037a, "field 'card'");
        .ble = (PaymentCardStaticView)viewbinder.ticView((View)viewbinder.dView(obj, 0x7f10037b, "field 'cardNonEditable'"), 0x7f10037b, "field 'cardNonEditable'");
        .ble = (AddressFormView)viewbinder.w((View)viewbinder.dView(obj, 0x7f10037c, "field 'address'"), 0x7f10037c, "field 'address'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.ble = null;
        bind1.ble = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
