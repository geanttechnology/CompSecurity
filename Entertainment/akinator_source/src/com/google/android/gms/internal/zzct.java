// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzcs, zzcn, zzcm

public class zzct extends NativeContentAd
{

    private final List zzxe;
    private final zzcs zzxg;
    private final zzcn zzxh;

    public zzct(zzcs zzcs1)
    {
        zzxe = new ArrayList();
        zzxg = zzcs1;
        zzcs1 = zzxg.getImages().iterator();
_L2:
        zzcm zzcm;
        do
        {
            if (!zzcs1.hasNext())
            {
                break MISSING_BLOCK_LABEL_87;
            }
            zzcm = zzd(zzcs1.next());
        } while (zzcm == null);
        zzxe.add(new zzcn(zzcm));
        if (true) goto _L2; else goto _L1
_L1:
        zzcs1;
        zzb.zzb("Failed to get image.", zzcs1);
        zzcs1 = zzxg.zzdA();
        if (zzcs1 == null) goto _L4; else goto _L3
_L3:
        zzcs1 = new zzcn(zzcs1);
_L6:
        zzxh = zzcs1;
        return;
        zzcs1;
        zzb.zzb("Failed to get icon.", zzcs1);
_L4:
        zzcs1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public CharSequence getAdvertiser()
    {
        String s;
        try
        {
            s = zzxg.getAdvertiser();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get attribution.", remoteexception);
            return null;
        }
        return s;
    }

    public CharSequence getBody()
    {
        String s;
        try
        {
            s = zzxg.getBody();
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
            s = zzxg.getCallToAction();
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
            bundle = zzxg.getExtras();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Failed to get extras", remoteexception);
            return null;
        }
        return bundle;
    }

    public CharSequence getHeadline()
    {
        String s;
        try
        {
            s = zzxg.getHeadline();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to get headline.", remoteexception);
            return null;
        }
        return s;
    }

    public List getImages()
    {
        return zzxe;
    }

    public com.google.android.gms.ads.formats.NativeAd.Image getLogo()
    {
        return zzxh;
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
            zzd1 = zzxg.zzdx();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to retrieve native ad engine.", remoteexception);
            return null;
        }
        return zzd1;
    }
}
