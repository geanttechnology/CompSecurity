// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzhk, zzhh, zzen, zzhs, 
//            zzed, zzej, zzee, zzhe, 
//            zzid, zzhn, zzgh, zzem, 
//            zzcg

public class zzhg extends zzb
    implements zzhk
{

    private zzd zzGX;
    private String zzGY;
    private boolean zzGZ;
    private HashMap zzHa;

    public zzhg(Context context, AdSizeParcel adsizeparcel, zzem zzem1, VersionInfoParcel versioninfoparcel)
    {
        super(context, adsizeparcel, null, zzem1, versioninfoparcel, null);
        zzHa = new HashMap();
    }

    public void destroy()
    {
        Iterator iterator;
        zzx.zzci("destroy must be called on the main UI thread.");
        iterator = zzHa.keySet().iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        zzhh zzhh1 = (zzhh)zzHa.get(s);
        if (zzhh1 != null)
        {
            try
            {
                if (zzhh1.zzgc() != null)
                {
                    zzhh1.zzgc().destroy();
                }
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Fail to destroy adapter: ").append(s).toString());
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean isLoaded()
    {
        zzx.zzci("isLoaded must be called on the main UI thread.");
        return zzot.zzql == null && zzot.zzqm == null && zzot.zzqo != null && !zzGZ;
    }

    public void onRewardedVideoAdClosed()
    {
        if (zzGX == null)
        {
            return;
        }
        try
        {
            zzGX.onRewardedVideoAdClosed();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdClosed().", remoteexception);
        }
    }

    public void onRewardedVideoAdLeftApplication()
    {
        if (zzGX == null)
        {
            return;
        }
        try
        {
            zzGX.onRewardedVideoAdLeftApplication();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLeftApplication().", remoteexception);
        }
    }

    public void onRewardedVideoAdOpened()
    {
        zza(zzot.zzqo, false);
        if (zzGX == null)
        {
            return;
        }
        try
        {
            zzGX.onRewardedVideoAdOpened();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdOpened().", remoteexception);
        }
    }

    public void onRewardedVideoStarted()
    {
        zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzzu.zzyU);
        if (zzGX == null)
        {
            return;
        }
        try
        {
            zzGX.onRewardedVideoStarted();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", remoteexception);
        }
    }

    public void pause()
    {
        Iterator iterator;
        zzx.zzci("pause must be called on the main UI thread.");
        iterator = zzHa.keySet().iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        zzhh zzhh1 = (zzhh)zzHa.get(s);
        if (zzhh1 != null)
        {
            try
            {
                if (zzhh1.zzgc() != null)
                {
                    zzhh1.zzgc().pause();
                }
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Fail to pause adapter: ").append(s).toString());
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void resume()
    {
        Iterator iterator;
        zzx.zzci("resume must be called on the main UI thread.");
        iterator = zzHa.keySet().iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        zzhh zzhh1 = (zzhh)zzHa.get(s);
        if (zzhh1 != null)
        {
            try
            {
                if (zzhh1.zzgc() != null)
                {
                    zzhh1.zzgc().resume();
                }
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Fail to resume adapter: ").append(s).toString());
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setUserId(String s)
    {
        zzx.zzci("setUserId must be called on the main UI thread.");
        zzGY = s;
    }

    public void zza(RewardedVideoAdRequestParcel rewardedvideoadrequestparcel)
    {
        zzx.zzci("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedvideoadrequestparcel.zzqh))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid ad unit id. Aborting.");
            return;
        } else
        {
            zzGZ = false;
            zzot.zzqh = rewardedvideoadrequestparcel.zzqh;
            super.zzb(rewardedvideoadrequestparcel.zzEn);
            return;
        }
    }

    public void zza(zzd zzd1)
    {
        zzx.zzci("setRewardedVideoAdListener must be called on the main UI thread.");
        zzGX = zzd1;
    }

    public void zza(RewardItemParcel rewarditemparcel)
    {
        zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzzu.zzyV);
        if (zzGX == null)
        {
            return;
        }
        try
        {
            if (zzot.zzqo != null && zzot.zzqo.zzHx != null && !TextUtils.isEmpty(zzot.zzqo.zzHx.zzzd))
            {
                zzGX.zza(new zzhe(zzot.zzqo.zzHx.zzzd, zzot.zzqo.zzHx.zzze));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (RewardItemParcel rewarditemparcel)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onRewarded().", rewarditemparcel);
            return;
        }
        zzGX.zza(new zzhe(rewarditemparcel.type, rewarditemparcel.zzHv));
        return;
    }

    public void zza(zzhs.zza zza1, zzcg zzcg)
    {
        if (zza1.errorCode != -2)
        {
            zzid.zzIE.post(new _cls1(zza1));
            return;
        } else
        {
            zzot.zzqH = 0;
            zzot.zzqm = new zzhn(zzot.context, zzGY, zza1, this);
            com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder()).append("AdRenderer: ").append(zzot.zzqm.getClass().getName()).toString());
            zzot.zzqm.zzfu();
            return;
        }
    }

    public boolean zza(zzhs zzhs1, zzhs zzhs2)
    {
        if (zzGX != null)
        {
            try
            {
                zzGX.onRewardedVideoAdLoaded();
            }
            // Misplaced declaration of an exception variable
            catch (zzhs zzhs1)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLoaded().", zzhs1);
            }
        }
        return true;
    }

    public zzhh zzau(String s)
    {
        Object obj;
        Object obj1;
        obj = (zzhh)zzHa.get(s);
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj1 = new zzhh(zzox.zzae(s), this);
        zzHa.put(s, obj1);
        return ((zzhh) (obj1));
        obj1;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.zzd((new StringBuilder()).append("Fail to instantiate adapter ").append(s).toString(), ((Throwable) (obj1)));
        return ((zzhh) (obj));
        Exception exception;
        exception;
        obj = obj1;
        obj1 = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected boolean zze(int i)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder()).append("Failed to load ad: ").append(i).toString());
        if (zzGX == null)
        {
            return false;
        }
        try
        {
            zzGX.onRewardedVideoAdFailedToLoad(i);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdFailedToLoad().", remoteexception);
            return false;
        }
        return true;
    }

    public void zzga()
    {
        zzx.zzci("showAd must be called on the main UI thread.");
        if (!isLoaded())
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("The reward video has not loaded.");
        } else
        {
            zzGZ = true;
            zzhh zzhh1 = zzau(zzot.zzqo.zzzw);
            if (zzhh1 != null && zzhh1.zzgc() != null)
            {
                try
                {
                    zzhh1.zzgc().showVideo();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call showVideo.", remoteexception);
                }
                return;
            }
        }
    }

    public void zzgb()
    {
        onAdClicked();
    }

    /* member class not found */
    class _cls1 {}

}
