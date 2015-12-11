// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

public class adj
    implements ServiceConnection
{

    final adi a;

    public adj(adi adi1)
    {
        a = adi1;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        java.util.HashMap hashmap = adh.a(a.a);
        hashmap;
        JVM INSTR monitorenter ;
        adi.a(a, ibinder);
        adi.a(a, componentname);
        for (Iterator iterator = adi.a(a).iterator(); iterator.hasNext(); ((adc)iterator.next()).onServiceConnected(componentname, ibinder)) { }
        break MISSING_BLOCK_LABEL_76;
        componentname;
        hashmap;
        JVM INSTR monitorexit ;
        throw componentname;
        adi.a(a, 1);
        hashmap;
        JVM INSTR monitorexit ;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        java.util.HashMap hashmap = adh.a(a.a);
        hashmap;
        JVM INSTR monitorenter ;
        adi.a(a, null);
        adi.a(a, componentname);
        for (Iterator iterator = adi.a(a).iterator(); iterator.hasNext(); ((adc)iterator.next()).onServiceDisconnected(componentname)) { }
        break MISSING_BLOCK_LABEL_72;
        componentname;
        hashmap;
        JVM INSTR monitorexit ;
        throw componentname;
        adi.a(a, 2);
        hashmap;
        JVM INSTR monitorexit ;
    }
}
