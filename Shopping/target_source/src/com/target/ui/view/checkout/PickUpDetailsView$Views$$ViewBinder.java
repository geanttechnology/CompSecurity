// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.common.NameView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.root(obj, 0x7f1003c6, "field 'root'");
        .sView = (View)viewbinder.pickUpDetailsView(obj, 0x7f100338, "field 'pickUpDetailsView'");
        .Name = (TextView)viewbinder.pickUpPersonName((View)viewbinder.pickUpPersonName(obj, 0x7f1003c9, "field 'pickUpPersonName'"), 0x7f1003c9, "field 'pickUpPersonName'");
        .ew = (NameView)viewbinder.pickUpNameView((View)viewbinder.pickUpNameView(obj, 0x7f100371, "field 'pickUpNameView'"), 0x7f100371, "field 'pickUpNameView'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.sView = null;
        bind1.Name = null;
        bind1.ew = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
