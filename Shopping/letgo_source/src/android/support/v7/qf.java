// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            kr, ll, qe, qg, 
//            qj, qh, qi, lk, 
//            qb, qc, qd

public final class qf extends qa.a
{

    private final MediationAdapter a;
    private qg b;

    public qf(MediationAdapter mediationadapter)
    {
        a = mediationadapter;
    }

    private Bundle a(String s, int j, String s1)
        throws RemoteException
    {
        Bundle bundle;
        zzb.zzaE((new StringBuilder()).append("Server parameters: ").append(s).toString());
        Iterator iterator;
        String s2;
        try
        {
            bundle = new Bundle();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzd("Could not get Server Parameters Bundle.", s);
            throw new RemoteException();
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        s = new JSONObject(s);
        bundle = new Bundle();
        for (iterator = s.keys(); iterator.hasNext(); bundle.putString(s2, s.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

        if (a instanceof kr)
        {
            bundle.putString("adJson", s1);
            bundle.putInt("tagForChildDirectedTreatment", j);
        }
        return bundle;
    }

    public lk a()
        throws RemoteException
    {
        if (!(a instanceof MediationBannerAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        lk lk;
        try
        {
            lk = ll.a(((MediationBannerAdapter)a).getBannerView());
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

    public void a(lk lk, AdRequestParcel adrequestparcel, String s, com.google.android.gms.ads.internal.reward.mediation.client.zza zza1, String s1)
        throws RemoteException
    {
        if (!(a instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Initialize rewarded video adapter.");
        MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter = (MediationRewardedVideoAdAdapter)a;
        if (adrequestparcel.zzss == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzss);
_L5:
        Object obj1;
        if (adrequestparcel.zzsq == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsq);
            }
            // Misplaced declaration of an exception variable
            catch (lk lk)
            {
                zzb.zzd("Could not initialize rewarded video adapter.", lk);
                throw new RemoteException();
            }
        }
        obj1 = new qe(((Date) (obj1)), adrequestparcel.zzsr, ((java.util.Set) (obj)), adrequestparcel.zzsy, adrequestparcel.zzst, adrequestparcel.zzsu);
        if (adrequestparcel.zzsA == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        obj = adrequestparcel.zzsA.getBundle(mediationrewardedvideoadadapter.getClass().getName());
_L3:
        mediationrewardedvideoadadapter.initialize((Context)ll.a(lk), ((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), s, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zza1), a(s1, adrequestparcel.zzsu, null), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(lk lk, AdRequestParcel adrequestparcel, String s, String s1, qb qb)
        throws RemoteException
    {
        if (!(a instanceof MediationInterstitialAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Requesting interstitial ad from adapter.");
        MediationInterstitialAdapter mediationinterstitialadapter = (MediationInterstitialAdapter)a;
        if (adrequestparcel.zzss == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzss);
_L5:
        Object obj1;
        if (adrequestparcel.zzsq == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsq);
            }
            // Misplaced declaration of an exception variable
            catch (lk lk)
            {
                zzb.zzd("Could not request interstitial ad from adapter.", lk);
                throw new RemoteException();
            }
        }
        obj1 = new qe(((Date) (obj1)), adrequestparcel.zzsr, ((java.util.Set) (obj)), adrequestparcel.zzsy, adrequestparcel.zzst, adrequestparcel.zzsu);
        if (adrequestparcel.zzsA == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        obj = adrequestparcel.zzsA.getBundle(mediationinterstitialadapter.getClass().getName());
_L3:
        mediationinterstitialadapter.requestInterstitialAd((Context)ll.a(lk), new qg(qb), a(s, adrequestparcel.zzsu, s1), ((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(lk lk, AdRequestParcel adrequestparcel, String s, String s1, qb qb, NativeAdOptionsParcel nativeadoptionsparcel, List list)
        throws RemoteException
    {
        if (!(a instanceof zza))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationNativeAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zza zza1 = (zza)a;
        if (adrequestparcel.zzss == null) goto _L2; else goto _L1
_L1:
        HashSet hashset = new HashSet(adrequestparcel.zzss);
_L5:
        Date date;
        if (adrequestparcel.zzsq == -1L)
        {
            date = null;
        } else
        {
            try
            {
                date = new Date(adrequestparcel.zzsq);
            }
            // Misplaced declaration of an exception variable
            catch (lk lk)
            {
                zzb.zzd("Could not request interstitial ad from adapter.", lk);
                throw new RemoteException();
            }
        }
        list = new qj(date, adrequestparcel.zzsr, hashset, adrequestparcel.zzsy, adrequestparcel.zzst, adrequestparcel.zzsu, nativeadoptionsparcel, list);
        if (adrequestparcel.zzsA == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        nativeadoptionsparcel = adrequestparcel.zzsA.getBundle(zza1.getClass().getName());
_L3:
        b = new qg(qb);
        zza1.requestNativeAd((Context)ll.a(lk), b, a(s, adrequestparcel.zzsu, s1), list, nativeadoptionsparcel);
        return;
        nativeadoptionsparcel = null;
          goto _L3
_L2:
        hashset = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(lk lk, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, qb qb)
        throws RemoteException
    {
        a(lk, adsizeparcel, adrequestparcel, s, null, qb);
    }

    public void a(lk lk, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, qb qb)
        throws RemoteException
    {
        if (!(a instanceof MediationBannerAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Requesting banner ad from adapter.");
        MediationBannerAdapter mediationbanneradapter = (MediationBannerAdapter)a;
        if (adrequestparcel.zzss == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzss);
_L5:
        Object obj1;
        if (adrequestparcel.zzsq == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsq);
            }
            // Misplaced declaration of an exception variable
            catch (lk lk)
            {
                zzb.zzd("Could not request banner ad from adapter.", lk);
                throw new RemoteException();
            }
        }
        obj1 = new qe(((Date) (obj1)), adrequestparcel.zzsr, ((java.util.Set) (obj)), adrequestparcel.zzsy, adrequestparcel.zzst, adrequestparcel.zzsu);
        if (adrequestparcel.zzsA == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        obj = adrequestparcel.zzsA.getBundle(mediationbanneradapter.getClass().getName());
_L3:
        mediationbanneradapter.requestBannerAd((Context)ll.a(lk), new qg(qb), a(s, adrequestparcel.zzsu, s1), com.google.android.gms.ads.zza.zza(adsizeparcel.width, adsizeparcel.height, adsizeparcel.zzsG), ((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(AdRequestParcel adrequestparcel, String s)
        throws RemoteException
    {
        if (!(a instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Requesting rewarded video ad from adapter.");
        MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter = (MediationRewardedVideoAdAdapter)a;
        if (adrequestparcel.zzss == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzss);
_L5:
        Object obj1;
        if (adrequestparcel.zzsq == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsq);
            }
            // Misplaced declaration of an exception variable
            catch (AdRequestParcel adrequestparcel)
            {
                zzb.zzd("Could not load rewarded video ad from adapter.", adrequestparcel);
                throw new RemoteException();
            }
        }
        obj1 = new qe(((Date) (obj1)), adrequestparcel.zzsr, ((java.util.Set) (obj)), adrequestparcel.zzsy, adrequestparcel.zzst, adrequestparcel.zzsu);
        if (adrequestparcel.zzsA == null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        obj = adrequestparcel.zzsA.getBundle(mediationrewardedvideoadadapter.getClass().getName());
_L3:
        mediationrewardedvideoadadapter.loadAd(((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), a(s, adrequestparcel.zzsu, null), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void b()
        throws RemoteException
    {
        if (!(a instanceof MediationInterstitialAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Showing interstitial from adapter.");
        try
        {
            ((MediationInterstitialAdapter)a).showInterstitial();
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
            a.onDestroy();
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
        try
        {
            a.onPause();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not pause adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void e()
        throws RemoteException
    {
        try
        {
            a.onResume();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not resume adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void f()
        throws RemoteException
    {
        if (!(a instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Show rewarded video ad from adapter.");
        try
        {
            ((MediationRewardedVideoAdAdapter)a).showVideo();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not show rewarded video ad from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public boolean g()
        throws RemoteException
    {
        if (!(a instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaE((new StringBuilder()).append("MediationAdapter is not a MediationRewardedVideoAdAdapter: ").append(a.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaC("Check if adapter is initialized.");
        boolean flag;
        try
        {
            flag = ((MediationRewardedVideoAdAdapter)a).isInitialized();
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not check if adapter is initialized.", throwable);
            throw new RemoteException();
        }
        return flag;
    }

    public qc h()
    {
        com.google.android.gms.ads.mediation.NativeAdMapper nativeadmapper = b.a();
        if (nativeadmapper instanceof NativeAppInstallAdMapper)
        {
            return new qh((NativeAppInstallAdMapper)nativeadmapper);
        } else
        {
            return null;
        }
    }

    public qd i()
    {
        com.google.android.gms.ads.mediation.NativeAdMapper nativeadmapper = b.a();
        if (nativeadmapper instanceof NativeContentAdMapper)
        {
            return new qi((NativeContentAdMapper)nativeadmapper);
        } else
        {
            return null;
        }
    }
}
