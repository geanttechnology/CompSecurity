// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

// Referenced classes of package com.target.ui.view.product:
//            ProductFulfillmentFloatingActionButton

public class Q
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, Q q, Object obj)
    {
        q.Q = (FloatingActionsMenu)viewbinder.rootMenu((View)viewbinder.rootMenu(obj, 0x7f1004b0, "field 'rootMenu'"), 0x7f1004b0, "field 'rootMenu'");
        q.Q = (ProductFulfillmentFloatingActionButton)viewbinder.tton((View)viewbinder.tton(obj, 0x7f1004b2, "field 'pickUpBtn'"), 0x7f1004b2, "field 'pickUpBtn'");
        q.Q = (ProductFulfillmentFloatingActionButton)viewbinder.tton((View)viewbinder.tton(obj, 0x7f1004b3, "field 'fiatsBtn'"), 0x7f1004b3, "field 'fiatsBtn'");
        q.Q = (ProductFulfillmentFloatingActionButton)viewbinder.tton((View)viewbinder.tton(obj, 0x7f1004b4, "field 'shipMeBtn'"), 0x7f1004b4, "field 'shipMeBtn'");
        q. = (ProductFulfillmentFloatingActionButton)viewbinder.tton((View)viewbinder.tton(obj, 0x7f1004b1, "field 'addToListBtn'"), 0x7f1004b1, "field 'addToListBtn'");
        q. = (ProductFulfillmentFloatingActionButton)viewbinder.tton((View)viewbinder.tton(obj, 0x7f1004b5, "field 'mailBtn'"), 0x7f1004b5, "field 'mailBtn'");
        q. = (ProductFulfillmentFloatingActionButton)viewbinder.tton((View)viewbinder.tton(obj, 0x7f1004b7, "field 'emailBtn'"), 0x7f1004b7, "field 'emailBtn'");
        q. = (ProductFulfillmentFloatingActionButton)viewbinder.tton((View)viewbinder.tton(obj, 0x7f1004b6, "field 'smsBtn'"), 0x7f1004b6, "field 'smsBtn'");
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

    public Q()
    {
    }
}
