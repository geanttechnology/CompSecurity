// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzez, zzfa, zzeo, zzeq, 
//            zzer

public final class zzey extends zzen.zza
{

    private final MediationAdapter zzzP;
    private final NetworkExtras zzzQ;

    public zzey(MediationAdapter mediationadapter, NetworkExtras networkextras)
    {
        zzzP = mediationadapter;
        zzzQ = networkextras;
    }

    private MediationServerParameters zzb(String s, int i, String s1)
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
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get MediationServerParameters.", s);
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
        obj = zzzP.getServerParametersType();
        s1 = null;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s1 = (MediationServerParameters)((Class) (obj)).newInstance();
        s1.load(s);
        return s1;
    }

    public void destroy()
        throws RemoteException
    {
        try
        {
            zzzP.destroy();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public zzd getView()
        throws RemoteException
    {
        if (!(zzzP instanceof MediationBannerAdapter))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzzP.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        zzd zzd;
        try
        {
            zzd = zze.zzy(((MediationBannerAdapter)zzzP).getBannerView());
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return zzd;
    }

    public boolean isInitialized()
    {
        return true;
    }

    public void pause()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void resume()
        throws RemoteException
    {
        throw new RemoteException();
    }

    public void showInterstitial()
        throws RemoteException
    {
        if (!(zzzP instanceof MediationInterstitialAdapter))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzzP.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Showing interstitial from adapter.");
        try
        {
            ((MediationInterstitialAdapter)zzzP).showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public void showVideo()
    {
    }

    public void zza(AdRequestParcel adrequestparcel, String s)
    {
    }

    public void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, zza zza1, String s1)
        throws RemoteException
    {
    }

    public void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, zzeo zzeo)
        throws RemoteException
    {
        zza(zzd, adrequestparcel, s, ((String) (null)), zzeo);
    }

    public void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, String s1, zzeo zzeo)
        throws RemoteException
    {
        if (!(zzzP instanceof MediationInterstitialAdapter))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("MediationAdapter is not a MediationInterstitialAdapter: ").append(zzzP.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting interstitial ad from adapter.");
        try
        {
            ((MediationInterstitialAdapter)zzzP).requestInterstitialAd(new zzez(zzeo), (Activity)zze.zzp(zzd), zzb(s, adrequestparcel.zzsF, s1), zzfa.zzh(adrequestparcel), zzzQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", zzd);
        }
        throw new RemoteException();
    }

    public void zza(zzd zzd, AdRequestParcel adrequestparcel, String s, String s1, zzeo zzeo, NativeAdOptionsParcel nativeadoptionsparcel, List list)
    {
    }

    public void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, zzeo zzeo)
        throws RemoteException
    {
        zza(zzd, adsizeparcel, adrequestparcel, s, null, zzeo);
    }

    public void zza(zzd zzd, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, zzeo zzeo)
        throws RemoteException
    {
        if (!(zzzP instanceof MediationBannerAdapter))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("MediationAdapter is not a MediationBannerAdapter: ").append(zzzP.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting banner ad from adapter.");
        try
        {
            ((MediationBannerAdapter)zzzP).requestBannerAd(new zzez(zzeo), (Activity)zze.zzp(zzd), zzb(s, adrequestparcel.zzsF, s1), com.google.android.gms.internal.zzfa.zzb(adsizeparcel), zzfa.zzh(adrequestparcel), zzzQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzd zzd)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", zzd);
        }
        throw new RemoteException();
    }

    public zzeq zzdV()
    {
        return null;
    }

    public zzer zzdW()
    {
        return null;
    }

    public Bundle zzdX()
    {
        return new Bundle();
    }

    public Bundle zzdY()
    {
        return new Bundle();
    }

    public Bundle zzdZ()
    {
        return new Bundle();
    }
}
