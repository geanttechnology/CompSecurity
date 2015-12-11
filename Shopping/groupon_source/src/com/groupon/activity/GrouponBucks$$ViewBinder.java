// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            GrouponBucks, GrouponActivity

public class er extends er
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (GrouponBucks)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, GrouponBucks grouponbucks, Object obj)
    {
        super.bind(ewbinder, grouponbucks, obj);
        grouponbucks.gbucksDisclaimerShort = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10035e, "field 'gbucksDisclaimerShort'"), 0x7f10035e, "field 'gbucksDisclaimerShort'");
        grouponbucks.gbucksDisclaimer = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100360, "field 'gbucksDisclaimer'"), 0x7f100360, "field 'gbucksDisclaimer'");
        grouponbucks.gBucksValue = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f10035d, "field 'gBucksValue'"), 0x7f10035d, "field 'gBucksValue'");
        grouponbucks.gbucksDetailsContainer = (View)ewbinder.quiredView(obj, 0x7f10035f, "field 'gbucksDetailsContainer'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GrouponBucks)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((GrouponBucks)grouponactivity);
    }

    public void unbind(GrouponBucks grouponbucks)
    {
        super.unbind(grouponbucks);
        grouponbucks.gbucksDisclaimerShort = null;
        grouponbucks.gbucksDisclaimer = null;
        grouponbucks.gBucksValue = null;
        grouponbucks.gbucksDetailsContainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GrouponBucks)obj);
    }

    public er()
    {
    }
}
