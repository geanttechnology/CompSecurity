// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.view.GrouponSwipeRefreshLayout;

// Referenced classes of package com.groupon.fragment:
//            BusinessTipsFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, BusinessTipsFragment businesstipsfragment, Object obj)
    {
        businesstipsfragment.swipeLayout = (GrouponSwipeRefreshLayout)ewbinder.peLayout((View)ewbinder.ew(obj, 0x7f1000db, "field 'swipeLayout'"), 0x7f1000db, "field 'swipeLayout'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BusinessTipsFragment)obj, obj1);
    }

    public void unbind(BusinessTipsFragment businesstipsfragment)
    {
        businesstipsfragment.swipeLayout = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((BusinessTipsFragment)obj);
    }

    public ()
    {
    }
}
