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

    private final zzj zzasF;

    zzb(zzj zzj1)
    {
        zzasF = (zzj)zzx.zzw(zzj1);
    }

    public void publish(DataPoint datapoint)
        throws RemoteException
    {
        datapoint.zzsn();
        zzasF.zzc(datapoint);
    }

    public void publish(List list)
        throws RemoteException
    {
        for (list = list.iterator(); list.hasNext(); publish((DataPoint)list.next())) { }
    }
}
