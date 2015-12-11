// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.view.GrouponSwipeRefreshLayout;

// Referenced classes of package com.groupon.fragment:
//            AbstractDealsAndWidgetsBaseFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment, Object obj)
    {
        abstractdealsandwidgetsbasefragment.swipeLayout = (GrouponSwipeRefreshLayout)ewbinder.peLayout((View)ewbinder.peLayout(obj, 0x7f1000db, null), 0x7f1000db, "field 'swipeLayout'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (AbstractDealsAndWidgetsBaseFragment)obj, obj1);
    }

    public void unbind(AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment)
    {
        abstractdealsandwidgetsbasefragment.swipeLayout = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((AbstractDealsAndWidgetsBaseFragment)obj);
    }

    public ()
    {
    }
}
