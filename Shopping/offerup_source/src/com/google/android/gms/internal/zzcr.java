// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzcq, zzcn, zzcm

public class zzcr extends NativeAppInstallAd
{

    private final zzcq zzxd;
    private final List zzxe;
    private final zzcn zzxf;

    public zzcr(zzcq zzcq1)
    {
        zzxe = new ArrayList();
        zzxd = zzcq1;
        zzcq1 = zzxd.getImages().iterator();
_L2:
        zzcm zzcm;
        do
        {
            if (!zzcq1.hasNext())
            {
                break MISSING_BLOCK_LABEL_87;
            }
            zzcm = zzd(zzcq1.next());
        } while (zzcm == null);
        zzxe.add(new zzcn(zzcm));
        if (true) goto _L2; else goto _L1
_L1:
        zzcq1;
        zzb.zzb("Failed to get image.", zzcq1);
        zzcq1 = zzxd.zzdw();
        if (zzcq1 == null) goto _L4; else goto _L3
_L3:
        zzcq1 = new zzcn(zzcq1);
_L6:
        zzxf = zzcq1;
        return;
        zzcq1;
        zzb.zzb("Failed to get icon.", zzcq1);
_L4:
        zzcq1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public CharSequence getBody()
    {
        String s;
        try
        {
            s = zzxd.getBody();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get body.", remoteexception);
            return null;
        }
        return s;
    }

    public CharSequence getCallToAction()
    {
        String s;
        try
        {
            s = zzxd.getCallToAction();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get call to action.", remoteexception);
            return null;
        }
        return s;
    }

    public Bundle getExtras()
    {
        Bundle bundle;
        try
        {
            bundle = zzxd.getExtras();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get extras", remoteexception);
            return null;
        }
        return bundle;
    }

    public CharSequence getHeadline()
    {
        String s;
        try
        {
            s = zzxd.getHeadline();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get headline.", remoteexception);
            return null;
        }
        return s;
    }

    public com.google.android.gms.ads.formats.NativeAd.Image getIcon()
    {
        return zzxf;
    }

    public List getImages()
    {
        return zzxe;
    }

    public CharSequence getPrice()
    {
        String s;
        try
        {
            s = zzxd.getPrice();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get price.", remoteexception);
            return null;
        }
        return s;
    }

    public Double getStarRating()
    {
        double d;
        try
        {
            d = zzxd.getStarRating();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get star rating.", remoteexception);
            return null;
        }
        if (d == -1D)
        {
            return null;
        } else
        {
            return Double.valueOf(d);
        }
    }

    public CharSequence getStore()
    {
        String s;
        try
        {
            s = zzxd.getStore();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get store", remoteexception);
            return null;
        }
        return s;
    }

    protected Object zzaH()
    {
        return zzdx();
    }

    zzcm zzd(Object obj)
    {
        if (obj instanceof IBinder)
        {
            return zzcm.zza.zzt((IBinder)obj);
        } else
        {
            return null;
        }
    }

    protected zzd zzdx()
    {
        zzd zzd1;
        try
        {
            zzd1 = zzxd.zzdx();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to retrieve native ad engine.", remoteexception);
            return null;
        }
        return zzd1;
    }
}
