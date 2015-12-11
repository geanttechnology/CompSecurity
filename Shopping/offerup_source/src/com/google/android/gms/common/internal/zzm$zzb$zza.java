// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzm

public class zzagh
    implements ServiceConnection
{

    final zzagh zzagh;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        java.util.HashMap hashmap = zzm.zza(zzagh.g);
        hashmap;
        JVM INSTR monitorenter ;
        g(zzagh, ibinder);
        zzagh(zzagh, componentname);
        for (Iterator iterator = zzagh(zzagh).iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceConnected(componentname, ibinder)) { }
        break MISSING_BLOCK_LABEL_80;
        componentname;
        hashmap;
        JVM INSTR monitorexit ;
        throw componentname;
        d(zzagh, 1);
        hashmap;
        JVM INSTR monitorexit ;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        java.util.HashMap hashmap = zzm.zza(zzagh.g);
        hashmap;
        JVM INSTR monitorenter ;
        g(zzagh, null);
        zzagh(zzagh, componentname);
        for (Iterator iterator = zzagh(zzagh).iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceDisconnected(componentname)) { }
        break MISSING_BLOCK_LABEL_76;
        componentname;
        hashmap;
        JVM INSTR monitorexit ;
        throw componentname;
        cted(zzagh, 2);
        hashmap;
        JVM INSTR monitorexit ;
    }

    public ( )
    {
        zzagh = ;
        super();
    }
}
