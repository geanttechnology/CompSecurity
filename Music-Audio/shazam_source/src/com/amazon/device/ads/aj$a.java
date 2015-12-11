// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.HashSet;

// Referenced classes of package com.amazon.device.ads:
//            aj, cm, bg, at

static final class a
{

    private final HashSet a = new HashSet();
    private boolean b;

    static float a()
    {
        return cm.a().b.g;
    }

    final boolean a(Context context)
    {
        HashSet hashset;
        if (b)
        {
            return true;
        }
        hashset = new HashSet();
        int j;
        if (!at.a(8))
        {
            break MISSING_BLOCK_LABEL_100;
        }
        String s = at.a(context);
        context = context.getPackageManager().getPackageArchiveInfo(s, 1).activities;
        j = context.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add(((ActivityInfo) (context[i])).name);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        boolean flag;
        b = hashset.containsAll(a);
        flag = b;
        return flag;
        context;
        b = true;
        return true;
    }

    Info()
    {
        b = false;
        a.add("com.amazon.device.ads.AdActivity");
    }
}
