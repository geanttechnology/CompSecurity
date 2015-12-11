// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.pm.ResolveInfo;
import java.util.Comparator;

// Referenced classes of package com.target.ui.util:
//            n

static final class 
    implements Comparator
{

    final Context val$context;

    public int a(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
    {
        resolveinfo = resolveinfo.loadLabel(val$context.getPackageManager());
        resolveinfo1 = resolveinfo1.loadLabel(val$context.getPackageManager());
        if (resolveinfo != null)
        {
            resolveinfo = resolveinfo.toString();
        } else
        {
            resolveinfo = "";
        }
        if (resolveinfo1 != null)
        {
            resolveinfo1 = resolveinfo1.toString();
        } else
        {
            resolveinfo1 = "";
        }
        return resolveinfo.compareTo(resolveinfo1);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((ResolveInfo)obj, (ResolveInfo)obj1);
    }

    (Context context1)
    {
        val$context = context1;
        super();
    }
}
