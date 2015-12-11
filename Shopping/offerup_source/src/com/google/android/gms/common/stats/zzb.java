// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.stats:
//            zzd, zze, ConnectionEvent

public class zzb
{

    private static final Object zzafW = new Object();
    private static Integer zzahE;
    private static zzb zzahy;
    private final List zzahA;
    private final List zzahB;
    private final List zzahC;
    private zze zzahD;
    private zze zzahF;
    private final List zzahz;

    private zzb()
    {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF)
        {
            zzahz = Collections.EMPTY_LIST;
            zzahA = Collections.EMPTY_LIST;
            zzahB = Collections.EMPTY_LIST;
            zzahC = Collections.EMPTY_LIST;
            return;
        }
        Object obj = (String)zzc.zza.zzahI.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        zzahz = ((List) (obj));
        obj = (String)zzc.zza.zzahJ.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        zzahA = ((List) (obj));
        obj = (String)zzc.zza.zzahK.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        zzahB = ((List) (obj));
        obj = (String)zzc.zza.zzahL.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        zzahC = ((List) (obj));
        zzahD = new zze(1024, ((Long)zzc.zza.zzahM.get()).longValue());
        zzahF = new zze(1024, ((Long)zzc.zza.zzahM.get()).longValue());
    }

    private static int getLogLevel()
    {
        if (zzahE != null) goto _L2; else goto _L1
_L1:
        if (!zzmm.zzjA()) goto _L4; else goto _L3
_L3:
        int i = ((Integer)zzc.zza.zzahH.get()).intValue();
_L5:
        zzahE = Integer.valueOf(i);
_L2:
        return zzahE.intValue();
_L4:
        i = zzd.LOG_LEVEL_OFF;
          goto _L5
        SecurityException securityexception;
        securityexception;
        zzahE = Integer.valueOf(zzd.LOG_LEVEL_OFF);
          goto _L2
    }

    private void zza(Context context, String s, int i, String s1, String s2, String s3, String s4)
    {
        long l1 = System.currentTimeMillis();
        Object obj = null;
        String s5 = obj;
        if ((getLogLevel() & zzd.zzahR) != 0)
        {
            s5 = obj;
            if (i != 13)
            {
                s5 = zzmy.zzl(3, 5);
            }
        }
        long l = 0L;
        if ((getLogLevel() & zzd.zzahT) != 0)
        {
            l = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14)
        {
            s = new ConnectionEvent(l1, i, null, null, null, null, s5, s, SystemClock.elapsedRealtime(), l);
        } else
        {
            s = new ConnectionEvent(l1, i, s1, s2, s3, s4, s5, s, SystemClock.elapsedRealtime(), l);
        }
        context.startService((new Intent()).setComponent(zzd.zzahN).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", s));
    }

    private void zza(Context context, String s, String s1, Intent intent, int i)
    {
        Object obj1 = null;
        if (zzqi() && zzahD != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s2;
        Object obj;
        if (i == 4 || i == 1)
        {
            if (!zzahD.zzcy(s))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = null;
            s2 = null;
            intent = obj1;
        } else
        {
            obj = zzd(context, intent);
            if (obj == null)
            {
                Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[] {
                    s1, intent.toUri(0)
                }));
                return;
            }
            s2 = ((ServiceInfo) (obj)).processName;
            obj = ((ServiceInfo) (obj)).name;
            intent = zzmy.zzaq(context);
            if (!zzb(intent, s1, s2, ((String) (obj))))
            {
                continue; /* Loop/switch isn't completed */
            }
            zzahD.zzcx(s);
        }
        zza(context, s, i, ((String) (intent)), s1, s2, ((String) (obj)));
        return;
        if (true) goto _L1; else goto _L3
_L3:
    }

    private String zzb(ServiceConnection serviceconnection)
    {
        return String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode(serviceconnection));
    }

    private boolean zzb(String s, String s1, String s2, String s3)
    {
        int i = getLogLevel();
        return !zzahz.contains(s) && !zzahA.contains(s1) && !zzahB.contains(s2) && !zzahC.contains(s3) && (!s2.equals(s) || (i & zzd.zzahS) == 0);
    }

    private boolean zzc(Context context, Intent intent)
    {
        intent = intent.getComponent();
        if (intent == null || zzd.zzaeK && "com.google.android.gms".equals(intent.getPackageName()))
        {
            return false;
        } else
        {
            return zzmm.zzl(context, intent.getPackageName());
        }
    }

    private static ServiceInfo zzd(Context context, Intent intent)
    {
        context = context.getPackageManager().queryIntentServices(intent, 128);
        if (context == null || context.size() == 0)
        {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] {
                intent.toUri(0), zzmy.zzl(3, 20)
            }));
            return null;
        }
        if (context.size() > 1)
        {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] {
                intent.toUri(0), zzmy.zzl(3, 20)
            }));
            intent = context.iterator();
            if (intent.hasNext())
            {
                Log.w("ConnectionTracker", ((ResolveInfo)intent.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo)context.get(0)).serviceInfo;
    }

    public static zzb zzqh()
    {
        synchronized (zzafW)
        {
            if (zzahy == null)
            {
                zzahy = new zzb();
            }
        }
        return zzahy;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean zzqi()
    {
        while (!zzd.zzaeK || getLogLevel() == zzd.LOG_LEVEL_OFF) 
        {
            return false;
        }
        return true;
    }

    public void zza(Context context, ServiceConnection serviceconnection)
    {
        context.unbindService(serviceconnection);
        zza(context, zzb(serviceconnection), ((String) (null)), ((Intent) (null)), 1);
    }

    public void zza(Context context, ServiceConnection serviceconnection, String s, Intent intent)
    {
        zza(context, zzb(serviceconnection), s, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceconnection, int i)
    {
        return zza(context, context.getClass().getName(), intent, serviceconnection, i);
    }

    public boolean zza(Context context, String s, Intent intent, ServiceConnection serviceconnection, int i)
    {
        if (zzc(context, intent))
        {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean flag = context.bindService(intent, serviceconnection, i);
        if (flag)
        {
            zza(context, zzb(serviceconnection), s, intent, 2);
        }
        return flag;
    }

    public void zzb(Context context, ServiceConnection serviceconnection)
    {
        zza(context, zzb(serviceconnection), ((String) (null)), ((Intent) (null)), 4);
    }

}
