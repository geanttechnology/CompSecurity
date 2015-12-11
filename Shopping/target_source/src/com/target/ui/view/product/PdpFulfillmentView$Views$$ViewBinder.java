// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;

// Referenced classes of package com.target.ui.view.product:
//            ProductFulfillmentButton

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (ProductFulfillmentButton)viewbinder.on((View)viewbinder.on(obj, 0x7f1004a9, "field 'pickUpBtn'"), 0x7f1004a9, "field 'pickUpBtn'");
        . = (ProductFulfillmentButton)viewbinder.on((View)viewbinder.on(obj, 0x7f1004a8, "field 'fiatsBtn'"), 0x7f1004a8, "field 'fiatsBtn'");
        . = (ProductFulfillmentButton)viewbinder.on((View)viewbinder.on(obj, 0x7f1004a7, "field 'shipMeBtn'"), 0x7f1004a7, "field 'shipMeBtn'");
        . = (ProductFulfillmentButton)viewbinder.on((View)viewbinder.on(obj, 0x7f1004aa, "field 'addToListBtn'"), 0x7f1004aa, "field 'addToListBtn'");
        . = (ProductFulfillmentButton)viewbinder.on((View)viewbinder.on(obj, 0x7f1004a6, "field 'mailBtn'"), 0x7f1004a6, "field 'mailBtn'");
        . = (ProductFulfillmentButton)viewbinder.on((View)viewbinder.on(obj, 0x7f1004a4, "field 'emailBtn'"), 0x7f1004a4, "field 'emailBtn'");
        . = (ProductFulfillmentButton)viewbinder.on((View)viewbinder.on(obj, 0x7f1004a5, "field 'smsBtn'"), 0x7f1004a5, "field 'smsBtn'");
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
        bind1. = null;
        bind1. = null;
        bind1. = null;
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
