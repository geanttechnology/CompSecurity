// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            gj, gi, gb

public final class gk
    implements ServiceConnection
{

    final gj a;

    public gk(gj gj1)
    {
        a = gj1;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        java.util.HashMap hashmap = gi.a(a.h);
        hashmap;
        JVM INSTR monitorenter ;
        a.f = ibinder;
        a.g = componentname;
        for (Iterator iterator = a.c.iterator(); iterator.hasNext(); ((gb)iterator.next()).onServiceConnected(componentname, ibinder)) { }
        break MISSING_BLOCK_LABEL_74;
        componentname;
        hashmap;
        JVM INSTR monitorexit ;
        throw componentname;
        a.d = 1;
        hashmap;
        JVM INSTR monitorexit ;
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        java.util.HashMap hashmap = gi.a(a.h);
        hashmap;
        JVM INSTR monitorenter ;
        a.f = null;
        a.g = componentname;
        for (Iterator iterator = a.c.iterator(); iterator.hasNext(); ((gb)iterator.next()).onServiceDisconnected(componentname)) { }
        break MISSING_BLOCK_LABEL_70;
        componentname;
        hashmap;
        JVM INSTR monitorexit ;
        throw componentname;
        a.d = 2;
        hashmap;
        JVM INSTR monitorexit ;
    }
}
