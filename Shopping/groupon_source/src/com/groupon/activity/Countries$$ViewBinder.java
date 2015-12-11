// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            Countries, GrouponListActivity

public class iewBinder extends iewBinder
{

    public void bind(butterknife.ewBinder ewbinder, Countries countries, Object obj)
    {
        super.bind(ewbinder, countries, obj);
        countries.noItems = (TextView)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f1001b2, "field 'noItems'"), 0x7f1001b2, "field 'noItems'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponListActivity grouponlistactivity, Object obj)
    {
        bind(ewbinder, (Countries)grouponlistactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (Countries)obj, obj1);
    }

    public void unbind(Countries countries)
    {
        super.unbind(countries);
        countries.noItems = null;
    }

    public volatile void unbind(GrouponListActivity grouponlistactivity)
    {
        unbind((Countries)grouponlistactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((Countries)obj);
    }

    public iewBinder()
    {
    }
}
