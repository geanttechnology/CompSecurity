// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            eq, en, dg

public final class em
    implements eq
{

    private static em a;
    private final List b = b();

    private em()
    {
    }

    public static em a()
    {
        com/flurry/sdk/em;
        JVM INSTR monitorenter ;
        em em1;
        if (a == null)
        {
            a = new em();
        }
        em1 = a;
        com/flurry/sdk/em;
        JVM INSTR monitorexit ;
        return em1;
        Exception exception;
        exception;
        throw exception;
    }

    private static List b()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new en("com.flurry.android.impl.analytics.FlurryAnalyticsModule", 10));
        arraylist.add(new en("com.flurry.android.impl.ads.FlurryAdModule", 10));
        return Collections.unmodifiableList(arraylist);
    }

    public void a(dg dg)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((eq)iterator.next()).a(dg)) { }
    }

    public void a(dg dg, Context context)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((eq)iterator.next()).a(dg, context)) { }
    }

    public void b(dg dg, Context context)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((eq)iterator.next()).b(dg, context)) { }
    }

    public void c(dg dg, Context context)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((eq)iterator.next()).c(dg, context)) { }
    }
}
