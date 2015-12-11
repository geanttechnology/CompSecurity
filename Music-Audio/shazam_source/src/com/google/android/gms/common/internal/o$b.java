// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.internal:
//            o

private final class c
{
    public final class a
        implements ServiceConnection
    {

        final o.b a;

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            java.util.HashMap hashmap = o.a(a.h);
            hashmap;
            JVM INSTR monitorenter ;
            a.e = ibinder;
            a.g = componentname;
            for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceConnected(componentname, ibinder)) { }
            break MISSING_BLOCK_LABEL_78;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.c = 1;
            hashmap;
            JVM INSTR monitorexit ;
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            java.util.HashMap hashmap = o.a(a.h);
            hashmap;
            JVM INSTR monitorenter ;
            a.e = null;
            a.g = componentname;
            for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceDisconnected(componentname)) { }
            break MISSING_BLOCK_LABEL_74;
            componentname;
            hashmap;
            JVM INSTR monitorexit ;
            throw componentname;
            a.c = 2;
            hashmap;
            JVM INSTR monitorexit ;
        }

        public a()
        {
            a = o.b.this;
            super();
        }
    }


    final a a = new a();
    final Set b = new HashSet();
    int c;
    boolean d;
    IBinder e;
    final a f;
    ComponentName g;
    final o h;

    public final void a(ServiceConnection serviceconnection, String s)
    {
        o.c(h).a(com.google.android.gms.common.internal.o.b(h), serviceconnection, s, f.a(), 3);
        b.add(serviceconnection);
    }

    public final void a(String s)
    {
        d = o.c(h).a(com.google.android.gms.common.internal.o.b(h), s, f.a(), a, 129);
        if (d)
        {
            c = 3;
            return;
        }
        try
        {
            o.c(h).a(com.google.android.gms.common.internal.o.b(h), a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public final boolean a()
    {
        return b.isEmpty();
    }

    public final boolean a(ServiceConnection serviceconnection)
    {
        return b.contains(serviceconnection);
    }

    public a.a(o o1, a.a a1)
    {
        h = o1;
        super();
        f = a1;
        c = 2;
    }
}
