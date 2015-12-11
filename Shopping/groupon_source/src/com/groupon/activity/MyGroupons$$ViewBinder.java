// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.activity:
//            MyGroupons, GrouponActivity

public class nder extends nder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (MyGroupons)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, MyGroupons mygroupons, Object obj)
    {
        super.bind(ewbinder, mygroupons, obj);
        mygroupons.toolbarTitle = (TextView)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f100562, "field 'toolbarTitle'"), 0x7f100562, "field 'toolbarTitle'");
        mygroupons.myGrouponsViewPager = (GrouponViewPager)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f100448, "field 'myGrouponsViewPager'"), 0x7f100448, "field 'myGrouponsViewPager'");
        mygroupons.tabStrip = (PagerSlidingTabStrip)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f1000a9, "field 'tabStrip'"), 0x7f1000a9, "field 'tabStrip'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (MyGroupons)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((MyGroupons)grouponactivity);
    }

    public void unbind(MyGroupons mygroupons)
    {
        super.unbind(mygroupons);
        mygroupons.toolbarTitle = null;
        mygroupons.myGrouponsViewPager = null;
        mygroupons.tabStrip = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((MyGroupons)obj);
    }

    public nder()
    {
    }
}
