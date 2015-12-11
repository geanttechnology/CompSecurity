// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.maps.model.internal.zzd;

// Referenced classes of package com.google.android.gms.maps.model:
//            BitmapDescriptor, RuntimeRemoteException

public final class BitmapDescriptorFactory
{

    private static zzd zzaCP;

    public static BitmapDescriptor fromResource(int i)
    {
        BitmapDescriptor bitmapdescriptor;
        try
        {
            bitmapdescriptor = new BitmapDescriptor(zzvH().zzhD(i));
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return bitmapdescriptor;
    }

    public static void zza(zzd zzd1)
    {
        if (zzaCP != null)
        {
            return;
        } else
        {
            zzaCP = (zzd)zzu.zzu(zzd1);
            return;
        }
    }

    private static zzd zzvH()
    {
        return (zzd)zzu.zzb(zzaCP, "IBitmapDescriptorFactory is not initialized");
    }
}
