// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import b.a.a;
import com.b.a.a.g;
import com.b.a.a.j;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.utils:
//            m

public class az
{

    public az()
    {
    }

    public static void a(Context context)
    {
        com/offerup/android/utils/az;
        JVM INSTR monitorenter ;
        a a1;
        String s;
        int i;
        i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        context = j.a();
        a1 = b.a.a.b(com.offerup.android.utils.m.a);
        s = context.e();
        if (i >= context.h()) goto _L2; else goto _L1
_L1:
        context.a(3);
_L3:
        com/offerup/android/utils/az;
        JVM INSTR monitorexit ;
        return;
_L2:
        int l;
        if (i >= context.i())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if (!StringUtils.isNotEmpty(s))
        {
            break MISSING_BLOCK_LABEL_132;
        }
        l = a1.a(new a(s));
        i = l;
        if (l < 0)
        {
            i = l + 365;
        }
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        context.a(0);
          goto _L3
        context;
        g.a(com/offerup/android/utils/az.getSimpleName(), context);
          goto _L3
        context;
        throw context;
        context.b(null);
        context.a(2);
          goto _L3
label0:
        {
            if (i >= context.j())
            {
                break MISSING_BLOCK_LABEL_229;
            }
            if (context.g() != context.j())
            {
                break label0;
            }
            context.a(0);
        }
          goto _L3
        if (!StringUtils.isNotEmpty(s))
        {
            break MISSING_BLOCK_LABEL_221;
        }
        l = a1.a(new a(s));
        int k = l;
        if (l < 0)
        {
            k = l + 365;
        }
        if (k >= 3)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        context.a(0);
          goto _L3
        context.b(null);
        context.a(1);
          goto _L3
        context.a(0);
        context.a(null);
        context.b(null);
        context.b(0);
        context.c(0);
        context.d(0);
        context.e(0);
          goto _L3
    }
}
