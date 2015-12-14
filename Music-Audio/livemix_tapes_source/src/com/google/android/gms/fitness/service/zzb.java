// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzj;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.service:
//            SensorEventDispatcher

class zzb
    implements SensorEventDispatcher
{

    private final zzj zzaqi;

    zzb(zzj zzj1)
    {
        zzaqi = (zzj)zzx.zzv(zzj1);
    }

    public void publish(DataPoint datapoint)
        throws RemoteException
    {
        datapoint.zzrB();
        zzaqi.zzc(datapoint);
    }

    public void publish(List list)
        throws RemoteException
    {
        for (list = list.iterator(); list.hasNext(); publish((DataPoint)list.next())) { }
    }
}
