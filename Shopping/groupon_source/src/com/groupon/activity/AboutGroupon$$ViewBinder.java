// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            AboutGroupon, GrouponActivity

public class er extends er
{

    public void bind(butterknife.ewBinder ewbinder, AboutGroupon aboutgroupon, Object obj)
    {
        super.bind(ewbinder, aboutgroupon, obj);
        aboutgroupon.privacyStatement = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100092, "field 'privacyStatement'"), 0x7f100092, "field 'privacyStatement'");
        aboutgroupon.termsOfUse = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100093, "field 'termsOfUse'"), 0x7f100093, "field 'termsOfUse'");
        aboutgroupon.versionNumber = (TextView)ewbinder.ew((View)ewbinder.quiredView(obj, 0x7f100095, "field 'versionNumber'"), 0x7f100095, "field 'versionNumber'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (AboutGroupon)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (AboutGroupon)obj, obj1);
    }

    public void unbind(AboutGroupon aboutgroupon)
    {
        super.unbind(aboutgroupon);
        aboutgroupon.privacyStatement = null;
        aboutgroupon.termsOfUse = null;
        aboutgroupon.versionNumber = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((AboutGroupon)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((AboutGroupon)obj);
    }

    public er()
    {
    }
}
