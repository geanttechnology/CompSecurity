// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            zzd, zzb, zza, PlayLoggerContext, 
//            LogEvent

public class zzf extends zzj
{

    private final String zzQe;
    private final zzd zzaRZ;
    private final com.google.android.gms.playlog.internal.zzb zzaSa = new com.google.android.gms.playlog.internal.zzb();
    private boolean zzaSb;
    private final Object zzpd = new Object();

    public zzf(Context context, Looper looper, zzd zzd1, com.google.android.gms.common.internal.zzf zzf1)
    {
        super(context, looper, 24, zzf1, zzd1, zzd1);
        zzQe = context.getPackageName();
        zzaRZ = (zzd)zzx.zzw(zzd1);
        zzaRZ.zza(this);
        zzaSb = true;
    }

    private void zzBv()
    {
        Object obj;
        ArrayList arraylist;
        zzb.zza zza1;
        Iterator iterator;
        boolean flag;
        if (!zzaSb)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
        if (zzaSa.isEmpty()) goto _L2; else goto _L1
_L1:
        arraylist = new ArrayList();
        iterator = zzaSa.zzBt().iterator();
        obj = null;
_L5:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_195;
        }
        zza1 = (zzb.zza)iterator.next();
        if (zza1.zzaRO == null) goto _L4; else goto _L3
_L3:
        ((zza)zzpc()).zza(zzQe, zza1.zzaRM, zzse.zzf(zza1.zzaRO));
          goto _L5
        obj;
        Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
_L2:
        return;
_L4:
label0:
        {
            if (!zza1.zzaRM.equals(obj))
            {
                break label0;
            }
            arraylist.add(zza1.zzaRN);
        }
          goto _L5
        if (!arraylist.isEmpty())
        {
            ((zza)zzpc()).zza(zzQe, ((PlayLoggerContext) (obj)), arraylist);
            arraylist.clear();
        }
        obj = zza1.zzaRM;
        arraylist.add(zza1.zzaRN);
          goto _L5
        if (!arraylist.isEmpty())
        {
            ((zza)zzpc()).zza(zzQe, ((PlayLoggerContext) (obj)), arraylist);
        }
        zzaSa.clear();
        return;
    }

    private void zzc(PlayLoggerContext playloggercontext, LogEvent logevent)
    {
        zzaSa.zza(playloggercontext, logevent);
    }

    private void zzd(PlayLoggerContext playloggercontext, LogEvent logevent)
    {
        try
        {
            zzBv();
            ((zza)zzpc()).zza(zzQe, playloggercontext, logevent);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playloggercontext, logevent);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
        }
        zzc(playloggercontext, logevent);
    }

    public void start()
    {
label0:
        {
            synchronized (zzpd)
            {
                if (!isConnecting() && !isConnected())
                {
                    break label0;
                }
            }
            return;
        }
        zzaRZ.zzao(true);
        zzoZ();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void stop()
    {
        synchronized (zzpd)
        {
            zzaRZ.zzao(false);
            disconnect();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzdA(ibinder);
    }

    void zzap(boolean flag)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        boolean flag1;
        flag1 = zzaSb;
        zzaSb = flag;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        if (!zzaSb)
        {
            zzBv();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzb(PlayLoggerContext playloggercontext, LogEvent logevent)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (!zzaSb)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        zzc(playloggercontext, logevent);
_L2:
        return;
        zzd(playloggercontext, logevent);
        if (true) goto _L2; else goto _L1
_L1:
        playloggercontext;
        obj;
        JVM INSTR monitorexit ;
        throw playloggercontext;
    }

    protected zza zzdA(IBinder ibinder)
    {
        return zza.zza.zzdz(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
