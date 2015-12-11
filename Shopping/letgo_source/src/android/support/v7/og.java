// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            of, oa, lk, nz

public class og extends NativeContentAd
{

    private final of a;
    private final List b;
    private final oa c;

    public og(of of1)
    {
        b = new ArrayList();
        a = of1;
        of1 = a.getImages().iterator();
_L2:
        nz nz;
        do
        {
            if (!of1.hasNext())
            {
                break MISSING_BLOCK_LABEL_87;
            }
            nz = a(of1.next());
        } while (nz == null);
        b.add(new oa(nz));
        if (true) goto _L2; else goto _L1
_L1:
        of1;
        zzb.zzb("Failed to get image.", of1);
        of1 = a.zzdw();
        if (of1 == null) goto _L4; else goto _L3
_L3:
        of1 = new oa(of1);
_L6:
        c = of1;
        return;
        of1;
        zzb.zzb("Failed to get icon.", of1);
_L4:
        of1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected lk a()
    {
        lk lk;
        try
        {
            lk = a.zzdt();
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzb("Failed to retrieve native ad engine.", remoteexception);
            return null;
        }
        return lk;
    }

    nz a(Object obj)
    {
        if (obj instanceof IBinder)
        {
            return nz.a.zzt((IBinder)obj);
        } else
        {
            return null;
        }
    }

    public CharSequence getAdvertiser()
    {
        String s;
        try
        {
            s = a.getAdvertiser();
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
            s = a.getBody();
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
            s = a.getCallToAction();
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
            bundle = a.getExtras();
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
            s = a.getHeadline();
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
        return b;
    }

    public com.google.android.gms.ads.formats.NativeAd.Image getLogo()
    {
        return c;
    }

    protected Object zzaH()
    {
        return a();
    }
}
