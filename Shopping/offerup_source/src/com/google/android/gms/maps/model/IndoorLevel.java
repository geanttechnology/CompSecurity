// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zze;

// Referenced classes of package com.google.android.gms.maps.model:
//            RuntimeRemoteException

public final class IndoorLevel
{

    private final zze zzaKe;

    public IndoorLevel(zze zze1)
    {
        zzaKe = (zze)zzx.zzw(zze1);
    }

    public final void activate()
    {
        try
        {
            zzaKe.activate();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof IndoorLevel))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = zzaKe.zza(((IndoorLevel)obj).zzaKe);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeRemoteException(((RemoteException) (obj)));
        }
        return flag;
    }

    public final String getName()
    {
        String s;
        try
        {
            s = zzaKe.getName();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return s;
    }

    public final String getShortName()
    {
        String s;
        try
        {
            s = zzaKe.getShortName();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return s;
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = zzaKe.hashCodeRemote();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }
}
