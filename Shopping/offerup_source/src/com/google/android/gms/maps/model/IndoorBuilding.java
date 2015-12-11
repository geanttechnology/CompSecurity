// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            RuntimeRemoteException, IndoorLevel

public final class IndoorBuilding
{

    private final zzd zzaKd;

    public IndoorBuilding(zzd zzd1)
    {
        zzaKd = (zzd)zzx.zzw(zzd1);
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof IndoorBuilding))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = zzaKd.zzb(((IndoorBuilding)obj).zzaKd);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeRemoteException(((RemoteException) (obj)));
        }
        return flag;
    }

    public final int getActiveLevelIndex()
    {
        int i;
        try
        {
            i = zzaKd.getActiveLevelIndex();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final int getDefaultLevelIndex()
    {
        int i;
        try
        {
            i = zzaKd.getActiveLevelIndex();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final List getLevels()
    {
        Object obj;
        try
        {
            Object obj1 = zzaKd.getLevels();
            obj = new ArrayList(((List) (obj1)).size());
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(new IndoorLevel(com.google.android.gms.maps.model.internal.zze.zza.zzcT((IBinder)((Iterator) (obj1)).next())))) { }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeRemoteException(((RemoteException) (obj)));
        }
        return ((List) (obj));
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = zzaKd.hashCodeRemote();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final boolean isUnderground()
    {
        boolean flag;
        try
        {
            flag = zzaKd.isUnderground();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }
}
