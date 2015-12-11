// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.CustomErrorViewWrapper;
import com.target.ui.view.common.NameView;

// Referenced classes of package com.target.ui.view.checkout:
//            AddressView

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (NameView)viewbinder.nameView((View)viewbinder.w(obj, 0x7f100367, "field 'nameView'"), 0x7f100367, "field 'nameView'");
        . = (AddressView)viewbinder.addressView((View)viewbinder.w(obj, 0x7f100368, "field 'addressView'"), 0x7f100368, "field 'addressView'");
        . = (EditText)viewbinder.phoneNumber((View)viewbinder.w(obj, 0x7f10036a, "field 'phoneNumber'"), 0x7f10036a, "field 'phoneNumber'");
        .rapper = (CustomErrorViewWrapper)viewbinder.phoneNumberWrapper((View)viewbinder.w(obj, 0x7f100369, "field 'phoneNumberWrapper'"), 0x7f100369, "field 'phoneNumberWrapper'");
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
        bind1.rapper = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
