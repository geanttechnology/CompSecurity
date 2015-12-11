// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Comparator;
import java.util.Map;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ResolveInfosSorter

static class priorityMap
    implements Comparator
{

    private Map priorityMap;

    private int calculatePriority(ResolveInfo resolveinfo)
    {
        resolveinfo = resolveinfo.activityInfo.packageName;
        if (priorityMap.containsKey(resolveinfo))
        {
            return ((Integer)priorityMap.get(resolveinfo)).intValue();
        } else
        {
            return 0;
        }
    }

    public int compare(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
    {
        return calculatePriority(resolveinfo1) - calculatePriority(resolveinfo);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ResolveInfo)obj, (ResolveInfo)obj1);
    }

    (Map map)
    {
        priorityMap = map;
    }
}
