// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzn, zzg, LocationRequestUpdateData

public class zzi
{
    private static class zza extends com.google.android.gms.location.zzc.zza
    {

        private Handler zzayO;

        private void zzb(int i, Object obj)
        {
            if (zzayO == null)
            {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = i;
                message.obj = obj;
                zzayO.sendMessage(message);
                return;
            }
        }

        public void onLocationAvailability(LocationAvailability locationavailability)
        {
            zzb(1, locationavailability);
        }

        public void onLocationResult(LocationResult locationresult)
        {
            zzb(0, locationresult);
        }
    }

    private static class zzc extends com.google.android.gms.location.zzd.zza
    {

        private Handler zzayO;

        public void onLocationChanged(Location location)
        {
            if (zzayO == null)
            {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = 1;
                message.obj = location;
                zzayO.sendMessage(message);
                return;
            }
        }
    }


    private final Context mContext;
    private Map zzakE;
    private ContentProviderClient zzayL;
    private boolean zzayM;
    private Map zzayN;
    private final zzn zzayq;

    public zzi(Context context, zzn zzn1)
    {
        zzayL = null;
        zzayM = false;
        zzakE = new HashMap();
        zzayN = new HashMap();
        mContext = context;
        zzayq = zzn1;
    }

    public void removeAllListeners()
    {
        Object obj = zzakE;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = zzakE.values().iterator();
_L2:
        Object obj1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_84;
            }
            obj1 = (zzc)iterator.next();
        } while (obj1 == null);
        ((zzg)zzayq.zznM()).zza(LocationRequestUpdateData.zzb(((com.google.android.gms.location.zzd) (obj1))));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
        zzakE.clear();
        exception = zzayN.values().iterator();
_L3:
        do
        {
            if (!exception.hasNext())
            {
                break MISSING_BLOCK_LABEL_155;
            }
            obj1 = (zza)exception.next();
        } while (obj1 == null);
        ((zzg)zzayq.zznM()).zza(LocationRequestUpdateData.zza(((com.google.android.gms.location.zzc) (obj1))));
          goto _L3
        zzayN.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void zzac(boolean flag)
        throws RemoteException
    {
        zzayq.zznL();
        ((zzg)zzayq.zznM()).zzac(flag);
        zzayM = flag;
    }

    public void zzux()
    {
        if (!zzayM)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        zzac(false);
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new IllegalStateException(remoteexception);
    }
}
