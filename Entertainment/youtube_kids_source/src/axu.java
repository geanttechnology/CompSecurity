// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

public final class axu
    implements ServiceConnection
{

    private axt a;

    public axu(axt axt1)
    {
        a = axt1;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        java.util.HashMap hashmap = axs.a(a.h);
        hashmap;
        JVM INSTR monitorenter ;
        a.f = ibinder;
        a.g = componentname;
        for (Iterator iterator = a.c.iterator(); iterator.hasNext(); ((axn)iterator.next()).onServiceConnected(componentname, ibinder)) { }
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
        java.util.HashMap hashmap = axs.a(a.h);
        hashmap;
        JVM INSTR monitorenter ;
        a.f = null;
        a.g = componentname;
        for (Iterator iterator = a.c.iterator(); iterator.hasNext(); ((axn)iterator.next()).onServiceDisconnected(componentname)) { }
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
