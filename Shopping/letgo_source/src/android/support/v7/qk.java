// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            kk, kp, kl, ll, 
//            kn, ql, qm, kq, 
//            lk, qb, qc, qd

public final class qk extends qa.a
{

    private final kk a;
    private final kq b;

    public qk(kk kk1, kq kq)
    {
        a = kk1;
        b = kq;
    }

    private kp a(String s, int j, String s1)
        throws RemoteException
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        try
        {
            obj = new JSONObject(s);
            s1 = new HashMap(((JSONObject) (obj)).length());
            iterator = ((JSONObject) (obj)).keys();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzd("Could not get MediationServerParameters.", s);
            throw new RemoteException();
        }
        s = s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        s1.put(s, ((JSONObject) (obj)).getString(s));
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_34;
_L2:
        s = new HashMap(0);
_L3:
        obj = a.c();
        s1 = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s1 = (kp)((Class) (obj)).newInstance();
        s1.a(s);
        return s1;
    }

    public lk a()
        throws RemoteException
    {
        if (!(a instanceof kl))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        lk lk;
        try
        {
            lk = ll.a(((kl)a).d());
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return lk;
    }

    public void a(lk lk, AdRequestParcel adrequestparcel, String s, qb qb)
        throws RemoteException
    {
        a(lk, adrequestparcel, s, ((String) (null)), qb);
    }

    public void a(lk lk, AdRequestParcel adrequestparcel, String s, zza zza, String s1)
        throws RemoteException
    {
    }

    public void a(lk lk, AdRequestParcel adrequestparcel, String s, String s1, qb qb)
        throws RemoteException
    {
        if (!(a instanceof kn))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Requesting interstitial ad from adapter.");
        try
        {
            ((kn)a).a(new ql(qb), (Activity)ll.a(lk), a(s, adrequestparcel.zzsu, s1), qm.a(adrequestparcel), b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (lk lk)
        {
            zzb.zzd("Could not request interstitial ad from adapter.", lk);
        }
        throw new RemoteException();
    }

    public void a(lk lk, AdRequestParcel adrequestparcel, String s, String s1, qb qb, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
    }

    public void a(lk lk, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, qb qb)
        throws RemoteException
    {
        a(lk, adsizeparcel, adrequestparcel, s, null, qb);
    }

    public void a(lk lk, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, qb qb)
        throws RemoteException
    {
        if (!(a instanceof kl))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Requesting banner ad from adapter.");
        try
        {
            ((kl)a).a(new ql(qb), (Activity)ll.a(lk), a(s, adrequestparcel.zzsu, s1), qm.a(adsizeparcel), qm.a(adrequestparcel), b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (lk lk)
        {
            zzb.zzd("Could not request banner ad from adapter.", lk);
        }
        throw new RemoteException();
    }

    public void a(AdRequestParcel adrequestparcel, String s)
    {
    }

    public void b()
        throws RemoteException
    {
        if (!(a instanceof kn))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Showing interstitial from adapter.");
        try
        {
            ((kn)a).d();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void c()
        throws RemoteException
    {
        try
        {
            a.a();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void d()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void e()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void f()
    {
    }

    public boolean g()
    {
        return true;
    }

    public qc h()
    {
        return null;
    }

    public qd i()
    {
        return null;
    }
}
