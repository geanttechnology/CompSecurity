// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.content.pm.PackageInfo;
import android.support.v4.f.a;
import com.target.ui.analytics.b.c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            a, s

class k extends com.target.ui.analytics.a.a
{

    private static final String EVENT_NAME = "event:view";
    private static final DateFormat sDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private final c mEvent;
    private final PackageInfo mPackageInfo;

    k(c c1, PackageInfo packageinfo)
    {
        mEvent = c1;
        mPackageInfo = packageinfo;
    }

    private String a(long l)
    {
        return sDateFormat.format(new Date(l));
    }

    private void a(Map map)
    {
        String s1 = "appLaunch";
        if (mEvent.daysSinceFirstUse > 0) goto _L2; else goto _L1
_L1:
        map.put("appInstallDate", a(mPackageInfo.firstInstallTime));
        s1 = (new StringBuilder()).append("appLaunch").append(",appInstall").toString();
_L4:
        map.put("events", s1);
        return;
_L2:
        if (mEvent.daysSinceLastUpgrade <= 0)
        {
            map.put("appUpgradeDate", a(mPackageInfo.lastUpdateTime));
            s1 = (new StringBuilder()).append("appLaunch").append(",appUpgrade").toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Map map, String s1, int i)
    {
        map.put(s1, String.valueOf(i));
    }

    protected String a()
    {
        return "event:view";
    }

    protected Map b()
    {
        a a1 = new a();
        a(a1);
        a(a1, "daysSinceFirstUse", mEvent.daysSinceFirstUse);
        a(a1, "daysSinceLastUpgrade", mEvent.daysSinceLastUpgrade);
        a(a1, "daysSinceLastUse", mEvent.daysSinceLastUse);
        a(a1, "engagedDaysLifetime", mEvent.engagedDaysLifetime);
        a(a1, "engagedDaysSinceUpgrade", mEvent.engagedDaysSinceUpgrade);
        a(a1, "engagedDaysThisMonth", mEvent.engagedDaysThisMonth);
        return a1;
    }

    protected s c()
    {
        return s.Unknown;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

}
