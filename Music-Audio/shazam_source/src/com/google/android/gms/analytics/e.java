// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.z;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            i, h

public final class e extends i
{

    private static List j = new ArrayList();
    public boolean a;
    public boolean b;
    public boolean c;
    volatile boolean d;
    public boolean e;
    private Set k;

    public e(r r1)
    {
        super(r1);
        k = new HashSet();
    }

    public static e a(Context context)
    {
        return r.a(context).d();
    }

    public static void a()
    {
        com/google/android/gms/analytics/e;
        JVM INSTR monitorenter ;
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        for (Iterator iterator = j.iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        com/google/android/gms/analytics/e;
        JVM INSTR monitorexit ;
        throw exception;
        j = null;
        com/google/android/gms/analytics/e;
        JVM INSTR monitorexit ;
    }

    public final h a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = new h(super.f, s);
        s.p();
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final String b()
    {
        w.c("getClientId can not be called from the main thread");
        return super.f.g().b();
    }

}
