// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.view.FilterBar;

// Referenced classes of package com.groupon.fragment:
//            Goods, AbstractDealsAndWidgetsBaseFragment

public class dgetsBaseFragment extends dgetsBaseFragment..ViewBinder
{

    public volatile void bind(butterknife. , AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment, Object obj)
    {
        bind(, (Goods)abstractdealsandwidgetsbasefragment, obj);
    }

    public void bind(butterknife. , Goods goods, Object obj)
    {
        super.bind(, goods, obj);
        goods.filterBar = (FilterBar).castView((View).findOptionalView(obj, 0x7f1000dd, null), 0x7f1000dd, "field 'filterBar'");
    }

    public volatile void bind(butterknife. , Object obj, Object obj1)
    {
        bind(, (Goods)obj, obj1);
    }

    public volatile void unbind(AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment)
    {
        unbind((Goods)abstractdealsandwidgetsbasefragment);
    }

    public void unbind(Goods goods)
    {
        super.unbind(goods);
        goods.filterBar = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((Goods)obj);
    }

    public dgetsBaseFragment()
    {
    }
}
