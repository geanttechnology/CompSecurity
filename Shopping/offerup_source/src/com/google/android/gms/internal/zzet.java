// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzes, zzeu, zzex, zzev, 
//            zzew, zzjj, zzjk, zzeo, 
//            zzeq, zzer

public final class zzet extends zzen.zza
{

    private final MediationAdapter zzzJ;
    private zzeu zzzK;

    public zzet(MediationAdapter mediationadapter)
    {
        zzzJ = mediationadapter;
    }

    private Bundle zza(String s, int i, String s1)
    {
        Bundle bundle;
        zzb.zzaH((new StringBuilder("Server parameters: ")).append(s).toString());
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
            break MISSING_BLOCK_LABEL_109;
        }
        s = new JSONObject(s);
        bundle = new Bundle();
        for (iterator = s.keys(); iterator.hasNext(); bundle.putString(s2, s.getString(s2)))
        {
            s2 = (String)iterator.next();
        }

        if (zzzJ instanceof AdMobAdapter)
        {
            bundle.putString("adJson", s1);
            bundle.putInt("tagForChildDirectedTreatment", i);
        }
        return bundle;
    }

    public final void destroy()
    {
        try
        {
            zzzJ.onDestroy();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final zzd getView()
    {
        if (!(zzzJ instanceof MediationBannerAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzd zzd;
        try
        {
            zzd = zze.zzy(((MediationBannerAdapter)zzzJ).getBannerView());
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return zzd;
    }

    public final boolean isInitialized()
    {
        if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaF("Check if adapter is initialized.");
        boolean flag;
        try
        {
            flag = ((MediationRewardedVideoAdAdapter)zzzJ).isInitialized();
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not check if adapter is initialized.", throwable);
            throw new RemoteException();
        }
        return flag;
    }

    public final void pause()
    {
        try
        {
            zzzJ.onPause();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not pause adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final void resume()
    {
        try
        {
            zzzJ.onResume();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not resume adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final void showInterstitial()
    {
        if (!(zzzJ instanceof MediationInterstitialAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaF("Showing interstitial from adapter.");
        try
        {
            ((MediationInterstitialAdapter)zzzJ).showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final void showVideo()
    {
        if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaF("Show rewarded video ad from adapter.");
        try
        {
            ((MediationRewardedVideoAdAdapter)zzzJ).showVideo();
            return;
        }
        catch (Throwable throwable)
        {
            zzb.zzd("Could not show rewarded video ad from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final void zza(AdRequestParcel adrequestparcel, String s)
    {
        if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaF("Requesting rewarded video ad from adapter.");
        MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter = (MediationRewardedVideoAdAdapter)zzzJ;
        if (adrequestparcel.zzsD == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzsD);
_L5:
        Object obj1;
        if (adrequestparcel.zzsB == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsB);
            }
            // Misplaced declaration of an exception variable
            catch (AdRequestParcel adrequestparcel)
            {
                zzb.zzd("Could not load rewarded video ad from adapter.", adrequestparcel);
                throw new RemoteException();
            }
        }
        obj1 = new zzes(((Date) (obj1)), adrequestparcel.zzsC, ((java.util.Set) (obj)), adrequestparcel.zzsJ, adrequestparcel.zzsE, adrequestparcel.zzsF);
        if (adrequestparcel.zzsL == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        obj = adrequestparcel.zzsL.getBundle(mediationrewardedvideoadadapter.getClass().getName());
_L3:
        mediationrewardedvideoadadapter.loadAd(((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), zza(s, adrequestparcel.zzsF, null), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, com.google.android.gms.ads.internal.reward.mediation.client.zza zza1, String s1)
    {
        if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationRewardedVideoAdAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaF("Initialize rewarded video adapter.");
        MediationRewardedVideoAdAdapter mediationrewardedvideoadadapter = (MediationRewardedVideoAdAdapter)zzzJ;
        if (adrequestparcel.zzsD == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzsD);
_L5:
        Object obj1;
        if (adrequestparcel.zzsB == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsB);
            }
            // Misplaced declaration of an exception variable
            catch (zzd zzd)
            {
                zzb.zzd("Could not initialize rewarded video adapter.", zzd);
                throw new RemoteException();
            }
        }
        obj1 = new zzes(((Date) (obj1)), adrequestparcel.zzsC, ((java.util.Set) (obj)), adrequestparcel.zzsJ, adrequestparcel.zzsE, adrequestparcel.zzsF);
        if (adrequestparcel.zzsL == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        obj = adrequestparcel.zzsL.getBundle(mediationrewardedvideoadadapter.getClass().getName());
_L3:
        mediationrewardedvideoadadapter.initialize((Context)zze.zzp(zzd), ((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), s, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zza1), zza(s1, adrequestparcel.zzsF, null), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, zzeo zzeo)
    {
        zza(zzd, adrequestparcel, s, ((String) (null)), zzeo);
    }

    public final void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, String s1, zzeo zzeo)
    {
        if (!(zzzJ instanceof MediationInterstitialAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaF("Requesting interstitial ad from adapter.");
        MediationInterstitialAdapter mediationinterstitialadapter = (MediationInterstitialAdapter)zzzJ;
        if (adrequestparcel.zzsD == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzsD);
_L5:
        Object obj1;
        if (adrequestparcel.zzsB == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsB);
            }
            // Misplaced declaration of an exception variable
            catch (zzd zzd)
            {
                zzb.zzd("Could not request interstitial ad from adapter.", zzd);
                throw new RemoteException();
            }
        }
        obj1 = new zzes(((Date) (obj1)), adrequestparcel.zzsC, ((java.util.Set) (obj)), adrequestparcel.zzsJ, adrequestparcel.zzsE, adrequestparcel.zzsF);
        if (adrequestparcel.zzsL == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        obj = adrequestparcel.zzsL.getBundle(mediationinterstitialadapter.getClass().getName());
_L3:
        mediationinterstitialadapter.requestInterstitialAd((Context)zze.zzp(zzd), new zzeu(zzeo), zza(s, adrequestparcel.zzsF, s1), ((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, String s1, zzeo zzeo, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
        if (!(zzzJ instanceof MediationNativeAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationNativeAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        MediationNativeAdapter mediationnativeadapter = (MediationNativeAdapter)zzzJ;
        if (adrequestparcel.zzsD == null) goto _L2; else goto _L1
_L1:
        HashSet hashset = new HashSet(adrequestparcel.zzsD);
_L5:
        Date date;
        if (adrequestparcel.zzsB == -1L)
        {
            date = null;
        } else
        {
            try
            {
                date = new Date(adrequestparcel.zzsB);
            }
            // Misplaced declaration of an exception variable
            catch (zzd zzd)
            {
                zzb.zzd("Could not request interstitial ad from adapter.", zzd);
                throw new RemoteException();
            }
        }
        list = new zzex(date, adrequestparcel.zzsC, hashset, adrequestparcel.zzsJ, adrequestparcel.zzsE, adrequestparcel.zzsF, nativeadoptionsparcel, list);
        if (adrequestparcel.zzsL == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        nativeadoptionsparcel = adrequestparcel.zzsL.getBundle(mediationnativeadapter.getClass().getName());
_L3:
        zzzK = new zzeu(zzeo);
        mediationnativeadapter.requestNativeAd((Context)zze.zzp(zzd), zzzK, zza(s, adrequestparcel.zzsF, s1), list, nativeadoptionsparcel);
        return;
        nativeadoptionsparcel = null;
          goto _L3
_L2:
        hashset = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, zzeo zzeo)
    {
        zza(zzd, adsizeparcel, adrequestparcel, s, null, zzeo);
    }

    public final void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, zzeo zzeo)
    {
        if (!(zzzJ instanceof MediationBannerAdapter))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzb.zzaF("Requesting banner ad from adapter.");
        MediationBannerAdapter mediationbanneradapter = (MediationBannerAdapter)zzzJ;
        if (adrequestparcel.zzsD == null) goto _L2; else goto _L1
_L1:
        Object obj = new HashSet(adrequestparcel.zzsD);
_L5:
        Object obj1;
        if (adrequestparcel.zzsB == -1L)
        {
            obj1 = null;
        } else
        {
            try
            {
                obj1 = new Date(adrequestparcel.zzsB);
            }
            // Misplaced declaration of an exception variable
            catch (zzd zzd)
            {
                zzb.zzd("Could not request banner ad from adapter.", zzd);
                throw new RemoteException();
            }
        }
        obj1 = new zzes(((Date) (obj1)), adrequestparcel.zzsC, ((java.util.Set) (obj)), adrequestparcel.zzsJ, adrequestparcel.zzsE, adrequestparcel.zzsF);
        if (adrequestparcel.zzsL == null)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        obj = adrequestparcel.zzsL.getBundle(mediationbanneradapter.getClass().getName());
_L3:
        mediationbanneradapter.requestBannerAd((Context)zze.zzp(zzd), new zzeu(zzeo), zza(s, adrequestparcel.zzsF, s1), com.google.android.gms.ads.zza.zza(adsizeparcel.width, adsizeparcel.height, adsizeparcel.zzte), ((com.google.android.gms.ads.mediation.MediationAdRequest) (obj1)), ((Bundle) (obj)));
        return;
        obj = null;
          goto _L3
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final zzeq zzdV()
    {
        com.google.android.gms.ads.mediation.NativeAdMapper nativeadmapper = zzzK.zzeb();
        if (nativeadmapper instanceof NativeAppInstallAdMapper)
        {
            return new zzev((NativeAppInstallAdMapper)nativeadmapper);
        } else
        {
            return null;
        }
    }

    public final zzer zzdW()
    {
        com.google.android.gms.ads.mediation.NativeAdMapper nativeadmapper = zzzK.zzeb();
        if (nativeadmapper instanceof NativeContentAdMapper)
        {
            return new zzew((NativeContentAdMapper)nativeadmapper);
        } else
        {
            return null;
        }
    }

    public final Bundle zzdX()
    {
        if (!(zzzJ instanceof zzjj))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a v2 MediationBannerAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            return new Bundle();
        } else
        {
            return ((zzjj)zzzJ).zzdX();
        }
    }

    public final Bundle zzdY()
    {
        if (!(zzzJ instanceof zzjk))
        {
            zzb.zzaH((new StringBuilder("MediationAdapter is not a v2 MediationInterstitialAdapter: ")).append(zzzJ.getClass().getCanonicalName()).toString());
            return new Bundle();
        } else
        {
            return ((zzjk)zzzJ).zzdY();
        }
    }

    public final Bundle zzdZ()
    {
        return new Bundle();
    }
}
