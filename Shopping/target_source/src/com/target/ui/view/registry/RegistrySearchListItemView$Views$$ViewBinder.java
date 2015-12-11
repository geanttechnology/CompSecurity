// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .ame = (TextView)viewbinder.mRegistrantName((View)viewbinder.mRegistrantName(obj, 0x7f100589, "field 'mRegistrantName'"), 0x7f100589, "field 'mRegistrantName'");
        .e = (TextView)viewbinder.mRegistryName((View)viewbinder.mRegistryName(obj, 0x7f10058a, "field 'mRegistryName'"), 0x7f10058a, "field 'mRegistryName'");
        .reatedDate = (TextView)viewbinder.mRegistrantCreatedDate((View)viewbinder.mRegistrantCreatedDate(obj, 0x7f10058b, "field 'mRegistrantCreatedDate'"), 0x7f10058b, "field 'mRegistrantCreatedDate'");
        .ityAndState = (TextView)viewbinder.mRegistrantCityAndState((View)viewbinder.mRegistrantCityAndState(obj, 0x7f10058c, "field 'mRegistrantCityAndState'"), 0x7f10058c, "field 'mRegistrantCityAndState'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ame = null;
        bind1.e = null;
        bind1.reatedDate = null;
        bind1.ityAndState = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
