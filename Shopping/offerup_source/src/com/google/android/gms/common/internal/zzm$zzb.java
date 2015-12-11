// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.zzb;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzm

final class mState
{

    private int mState;
    private IBinder zzaeJ;
    private ComponentName zzagb;
    private final zza zzagc = new zza();
    private final Set zzagd = new HashSet();
    private boolean zzage;
    private final zza zzagf;
    final zzm zzagg;

    static int zza(mState mstate, int i)
    {
        mstate.mState = i;
        return i;
    }

    static ComponentName zza(mState mstate, ComponentName componentname)
    {
        mstate.zzagb = componentname;
        return componentname;
    }

    static IBinder zza(zzagb zzagb1, IBinder ibinder)
    {
        zzagb1.zzaeJ = ibinder;
        return ibinder;
    }

    static zzaeJ zza(zzaeJ zzaej)
    {
        return zzaej.zzagf;
    }

    static Set zzb(zzagf zzagf1)
    {
        return zzagf1.zzagd;
    }

    public final IBinder getBinder()
    {
        return zzaeJ;
    }

    public final ComponentName getComponentName()
    {
        return zzagb;
    }

    public final int getState()
    {
        return mState;
    }

    public final boolean isBound()
    {
        return zzage;
    }

    public final void zza(ServiceConnection serviceconnection, String s)
    {
        zzm.zzc(zzagg).zza(com.google.android.gms.common.internal.zzm.zzb(zzagg), serviceconnection, s, zzagf.zzpm());
        zzagd.add(serviceconnection);
    }

    public final boolean zza(ServiceConnection serviceconnection)
    {
        return zzagd.contains(serviceconnection);
    }

    public final void zzb(ServiceConnection serviceconnection, String s)
    {
        zzm.zzc(zzagg).zzb(com.google.android.gms.common.internal.zzm.zzb(zzagg), serviceconnection);
        zzagd.remove(serviceconnection);
    }

    public final void zzcm(String s)
    {
        mState = 3;
        zzage = zzm.zzc(zzagg).zza(com.google.android.gms.common.internal.zzm.zzb(zzagg), s, zzagf.zzpm(), zzagc, 129);
        if (zzage)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        mState = 2;
        zzm.zzc(zzagg).zza(com.google.android.gms.common.internal.zzm.zzb(zzagg), zzagc);
        return;
        s;
    }

    public final void zzcn(String s)
    {
        zzm.zzc(zzagg).zza(com.google.android.gms.common.internal.zzm.zzb(zzagg), zzagc);
        zzage = false;
        mState = 2;
    }

    public final boolean zzpn()
    {
        return zzagd.isEmpty();
    }

    public zza.zzagh(zzm zzm1, zza zza1)
    {
        zzagg = zzm1;
        super();
        zzagf = zza1;
        class zza
            implements ServiceConnection
        {

            final zzm.zzb zzagh;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                java.util.HashMap hashmap = zzm.zza(zzagh.zzagg);
                hashmap;
                JVM INSTR monitorenter ;
                zzm.zzb.zza(zzagh, ibinder);
                zzm.zzb.zza(zzagh, componentname);
                for (Iterator iterator = com.google.android.gms.common.internal.zzm.zzb.zzb(zzagh).iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceConnected(componentname, ibinder)) { }
                break MISSING_BLOCK_LABEL_80;
                componentname;
                hashmap;
                JVM INSTR monitorexit ;
                throw componentname;
                zzm.zzb.zza(zzagh, 1);
                hashmap;
                JVM INSTR monitorexit ;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                java.util.HashMap hashmap = zzm.zza(zzagh.zzagg);
                hashmap;
                JVM INSTR monitorenter ;
                zzm.zzb.zza(zzagh, null);
                zzm.zzb.zza(zzagh, componentname);
                for (Iterator iterator = com.google.android.gms.common.internal.zzm.zzb.zzb(zzagh).iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceDisconnected(componentname)) { }
                break MISSING_BLOCK_LABEL_76;
                componentname;
                hashmap;
                JVM INSTR monitorexit ;
                throw componentname;
                zzm.zzb.zza(zzagh, 2);
                hashmap;
                JVM INSTR monitorexit ;
            }

            public zza()
            {
                zzagh = zzm.zzb.this;
                super();
            }
        }

        mState = 2;
    }
}
