// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

// Referenced classes of package com.groupon.activity:
//            PreconfiguredAbTests, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (PreconfiguredAbTests)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, PreconfiguredAbTests preconfiguredabtests, Object obj)
    {
        super.bind(ewbinder, preconfiguredabtests, obj);
        preconfiguredabtests.search = (EditText)ewbinder.rch((View)ewbinder.ew(obj, 0x7f1003e9, "field 'search'"), 0x7f1003e9, "field 'search'");
        preconfiguredabtests.aBTestList = (ListView)ewbinder.estList((View)ewbinder.ew(obj, 0x7f100483, "field 'aBTestList'"), 0x7f100483, "field 'aBTestList'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (PreconfiguredAbTests)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((PreconfiguredAbTests)grouponactivity);
    }

    public void unbind(PreconfiguredAbTests preconfiguredabtests)
    {
        super.d(preconfiguredabtests);
        preconfiguredabtests.search = null;
        preconfiguredabtests.aBTestList = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((PreconfiguredAbTests)obj);
    }

    public ()
    {
    }
}
