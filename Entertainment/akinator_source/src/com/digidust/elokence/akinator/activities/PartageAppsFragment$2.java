// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import java.util.Comparator;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PartageAppsFragment

class this._cls0
    implements Comparator
{

    final PartageAppsFragment this$0;

    public int compare(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
    {
        resolveinfo = resolveinfo.activityInfo;
        resolveinfo = new ComponentName(((ActivityInfo) (resolveinfo)).applicationInfo.packageName, ((ActivityInfo) (resolveinfo)).name);
        resolveinfo1 = resolveinfo1.activityInfo;
        resolveinfo1 = new ComponentName(((ActivityInfo) (resolveinfo1)).applicationInfo.packageName, ((ActivityInfo) (resolveinfo1)).name);
        if (resolveinfo.getPackageName().contains("facebook") || resolveinfo.getPackageName().contains("twitter"))
        {
            return -1;
        }
        if (resolveinfo1.getPackageName().contains("twitter") || resolveinfo1.getPackageName().contains("twitter"))
        {
            return 1;
        } else
        {
            return resolveinfo.compareTo(resolveinfo1);
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ResolveInfo)obj, (ResolveInfo)obj1);
    }

    ()
    {
        this$0 = PartageAppsFragment.this;
        super();
    }
}
