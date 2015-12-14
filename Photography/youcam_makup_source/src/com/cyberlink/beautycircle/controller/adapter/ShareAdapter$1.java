// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Comparator;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            ShareAdapter

final class a
    implements Comparator
{

    final areListMode a;

    public int a(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
    {
        List list = ShareAdapter.a();
        if (a == areListMode.e)
        {
            list = ShareAdapter.b();
        }
        int j = list.indexOf(resolveinfo.activityInfo.packageName);
        int k = list.indexOf(resolveinfo1.activityInfo.packageName);
        int i = j;
        if (j == -1)
        {
            i = 0x7fffffff;
        }
        j = k;
        if (k == -1)
        {
            j = 0x7fffffff;
        }
        return i - j;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((ResolveInfo)obj, (ResolveInfo)obj1);
    }

    areListMode(areListMode arelistmode)
    {
        a = arelistmode;
        super();
    }
}
