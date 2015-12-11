// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.stats.zzb;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzl, zzx

final class zzm extends zzl
    implements android.os.Handler.Callback
{

    private final Handler mHandler;
    private final HashMap zzafY = new HashMap();
    private final com.google.android.gms.common.stats.zzb zzafZ = com.google.android.gms.common.stats.zzb.zzqh();
    private final long zzaga = 5000L;
    private final Context zzqZ;

    zzm(Context context)
    {
        zzqZ = context.getApplicationContext();
        mHandler = new Handler(context.getMainLooper(), this);
    }

    static HashMap zza(zzm zzm1)
    {
        return zzm1.zzafY;
    }

    private boolean zza(zza zza1, ServiceConnection serviceconnection, String s)
    {
        com.google.android.gms.common.internal.zzx.zzb(serviceconnection, "ServiceConnection must not be null");
        HashMap hashmap = zzafY;
        hashmap;
        JVM INSTR monitorenter ;
        zzb zzb1 = (zzb)zzafY.get(zza1);
        if (zzb1 != null) goto _L2; else goto _L1
_L1:
        zzb1 = new zzb(zza1);
        zzb1.zza(serviceconnection, s);
        zzb1.zzcm(s);
        zzafY.put(zza1, zzb1);
        zza1 = zzb1;
_L7:
        boolean flag = zza1.isBound();
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        mHandler.removeMessages(0, zzb1);
        if (zzb1.zza(serviceconnection))
        {
            throw new IllegalStateException((new StringBuilder("Trying to bind a GmsServiceConnection that was already connected before.  config=")).append(zza1).toString());
        }
        break MISSING_BLOCK_LABEL_133;
        zza1;
        hashmap;
        JVM INSTR monitorexit ;
        throw zza1;
        zzb1.zza(serviceconnection, s);
        zzb1.getState();
        JVM INSTR tableswitch 1 2: default 202
    //                   1 168
    //                   2 190;
           goto _L3 _L4 _L5
_L4:
        serviceconnection.onServiceConnected(zzb1.getComponentName(), zzb1.getBinder());
        zza1 = zzb1;
        continue; /* Loop/switch isn't completed */
_L5:
        zzb1.zzcm(s);
        zza1 = zzb1;
        continue; /* Loop/switch isn't completed */
_L3:
        zza1 = zzb1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static Context zzb(zzm zzm1)
    {
        return zzm1.zzqZ;
    }

    private void zzb(zza zza1, ServiceConnection serviceconnection, String s)
    {
        com.google.android.gms.common.internal.zzx.zzb(serviceconnection, "ServiceConnection must not be null");
        HashMap hashmap = zzafY;
        hashmap;
        JVM INSTR monitorenter ;
        zzb zzb1 = (zzb)zzafY.get(zza1);
        if (zzb1 != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        throw new IllegalStateException((new StringBuilder("Nonexistent connection status for service config: ")).append(zza1).toString());
        zza1;
        hashmap;
        JVM INSTR monitorexit ;
        throw zza1;
        if (!zzb1.zza(serviceconnection))
        {
            throw new IllegalStateException((new StringBuilder("Trying to unbind a GmsServiceConnection  that was not bound before.  config=")).append(zza1).toString());
        }
        zzb1.zzb(serviceconnection, s);
        if (zzb1.zzpn())
        {
            zza1 = mHandler.obtainMessage(0, zzb1);
            mHandler.sendMessageDelayed(zza1, zzaga);
        }
        hashmap;
        JVM INSTR monitorexit ;
    }

    static com.google.android.gms.common.stats.zzb zzc(zzm zzm1)
    {
        return zzm1.zzafZ;
    }

    public final boolean handleMessage(Message message)
    {
        zzb zzb1;
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            zzb1 = (zzb)message.obj;
            break;
        }
        synchronized (zzafY)
        {
            if (zzb1.zzpn())
            {
                if (zzb1.isBound())
                {
                    zzb1.zzcn("GmsClientSupervisor");
                }
                zzafY.remove(zzb.zza(zzb1));
            }
        }
        return true;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean zza(ComponentName componentname, ServiceConnection serviceconnection, String s)
    {
        return zza(new zza(componentname), serviceconnection, s);
    }

    public final boolean zza(String s, ServiceConnection serviceconnection, String s1)
    {
        return zza(new zza(s), serviceconnection, s1);
    }

    public final void zzb(ComponentName componentname, ServiceConnection serviceconnection, String s)
    {
        zzb(new zza(componentname), serviceconnection, s);
    }

    public final void zzb(String s, ServiceConnection serviceconnection, String s1)
    {
        zzb(new zza(s), serviceconnection, s1);
    }

    private class zzb
    {

        private int mState;
        private IBinder zzaeJ;
        private ComponentName zzagb;
        private final zza zzagc = new zza();
        private final Set zzagd = new HashSet();
        private boolean zzage;
        private final zza zzagf;
        final zzm zzagg;

        static int zza(zzb zzb1, int i)
        {
            zzb1.mState = i;
            return i;
        }

        static ComponentName zza(zzb zzb1, ComponentName componentname)
        {
            zzb1.zzagb = componentname;
            return componentname;
        }

        static IBinder zza(zzb zzb1, IBinder ibinder)
        {
            zzb1.zzaeJ = ibinder;
            return ibinder;
        }

        static zza zza(zzb zzb1)
        {
            return zzb1.zzagf;
        }

        static Set zzb(zzb zzb1)
        {
            return zzb1.zzagd;
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

        public zzb(zza zza1)
        {
            zzagg = zzm.this;
            super();
            zzagf = zza1;
            class zza
                implements ServiceConnection
            {

                final zzb zzagh;

                public void onServiceConnected(ComponentName componentname, IBinder ibinder)
                {
                    HashMap hashmap = zzm.zza(zzagh.zzagg);
                    hashmap;
                    JVM INSTR monitorenter ;
                    zzb.zza(zzagh, ibinder);
                    zzb.zza(zzagh, componentname);
                    for (Iterator iterator = com.google.android.gms.common.internal.zzb.zzb(zzagh).iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceConnected(componentname, ibinder)) { }
                    break MISSING_BLOCK_LABEL_80;
                    componentname;
                    hashmap;
                    JVM INSTR monitorexit ;
                    throw componentname;
                    zzb.zza(zzagh, 1);
                    hashmap;
                    JVM INSTR monitorexit ;
                }

                public void onServiceDisconnected(ComponentName componentname)
                {
                    HashMap hashmap = zzm.zza(zzagh.zzagg);
                    hashmap;
                    JVM INSTR monitorenter ;
                    zzb.zza(zzagh, null);
                    zzb.zza(zzagh, componentname);
                    for (Iterator iterator = com.google.android.gms.common.internal.zzb.zzb(zzagh).iterator(); iterator.hasNext(); ((ServiceConnection)iterator.next()).onServiceDisconnected(componentname)) { }
                    break MISSING_BLOCK_LABEL_76;
                    componentname;
                    hashmap;
                    JVM INSTR monitorexit ;
                    throw componentname;
                    zzb.zza(zzagh, 2);
                    hashmap;
                    JVM INSTR monitorexit ;
                }

                public zza()
                {
                    zzagh = zzb.this;
                    super();
                }
            }

            mState = 2;
        }
    }


    private class zza
    {

        private final String zzPp;
        private final ComponentName zzagb;

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof zza))
                {
                    return false;
                }
                obj = (zza)obj;
                if (!zzw.equal(zzPp, ((zza) (obj)).zzPp) || !zzw.equal(zzagb, ((zza) (obj)).zzagb))
                {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode()
        {
            return zzw.hashCode(new Object[] {
                zzPp, zzagb
            });
        }

        public final String toString()
        {
            if (zzPp == null)
            {
                return zzagb.flattenToString();
            } else
            {
                return zzPp;
            }
        }

        public final Intent zzpm()
        {
            if (zzPp != null)
            {
                return (new Intent(zzPp)).setPackage("com.google.android.gms");
            } else
            {
                return (new Intent()).setComponent(zzagb);
            }
        }

        public zza(ComponentName componentname)
        {
            zzPp = null;
            zzagb = (ComponentName)zzx.zzw(componentname);
        }

        public zza(String s)
        {
            zzPp = zzx.zzcr(s);
            zzagb = null;
        }
    }

}
