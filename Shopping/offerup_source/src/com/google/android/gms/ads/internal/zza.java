// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzp, zzq, zzo, zzd

public abstract class zza extends com.google.android.gms.ads.internal.client.zzs.zza
    implements com.google.android.gms.ads.internal.client.zza, zzn, com.google.android.gms.ads.internal.request.zza, zzdg, com.google.android.gms.internal.zzgg.zza, zzhw
{

    protected zzcg zzoo;
    protected zzce zzop;
    protected zzce zzoq;
    boolean zzor;
    protected final com.google.android.gms.ads.internal.zzo zzos;
    protected final zzq zzot;
    protected transient AdRequestParcel zzou;
    protected final zzay zzov = com.google.android.gms.ads.internal.zzp.zzby().zzgt();
    protected final com.google.android.gms.ads.internal.zzd zzow;

    zza(zzq zzq1, com.google.android.gms.ads.internal.zzo zzo1, com.google.android.gms.ads.internal.zzd zzd1)
    {
        zzor = false;
        zzot = zzq1;
        if (zzo1 == null)
        {
            zzo1 = new com.google.android.gms.ads.internal.zzo(this);
        }
        zzos = zzo1;
        zzow = zzd1;
        zzp.zzbv().zzI(zzot.context);
        com.google.android.gms.ads.internal.zzp.zzby().zzb(zzot.context, zzot.zzqj);
    }

    private AdRequestParcel zza(AdRequestParcel adrequestparcel)
    {
        AdRequestParcel adrequestparcel1 = adrequestparcel;
        if (GooglePlayServicesUtil.zzag(zzot.context))
        {
            adrequestparcel1 = adrequestparcel;
            if (adrequestparcel.zzsJ != null)
            {
                adrequestparcel1 = (new zzf(adrequestparcel)).zza(null).zzcA();
            }
        }
        return adrequestparcel1;
    }

    private boolean zzaR()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("Ad leaving application.");
        if (zzot.zzqs == null)
        {
            return false;
        }
        try
        {
            zzot.zzqs.onAdLeftApplication();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call AdListener.onAdLeftApplication().", remoteexception);
            return false;
        }
        return true;
    }

    public void destroy()
    {
        zzx.zzci("destroy must be called on the main UI thread.");
        zzos.cancel();
        zzov.zzf(zzot.zzqo);
        zzot.destroy();
    }

    public boolean isLoading()
    {
        return zzor;
    }

    public boolean isReady()
    {
        zzx.zzci("isLoaded must be called on the main UI thread.");
        return zzot.zzql == null && zzot.zzqm == null && zzot.zzqo != null;
    }

    public void onAdClicked()
    {
        if (zzot.zzqo == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping click URLs.");
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging click URLs.");
            zzot.zzqq.zzgg();
            if (zzot.zzqo.zzyY != null)
            {
                zzp.zzbv().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo.zzyY);
            }
            if (zzot.zzqr != null)
            {
                try
                {
                    zzot.zzqr.onAdClicked();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not notify onAdClicked event.", remoteexception);
                }
                return;
            }
        }
    }

    public void onAppEvent(String s, String s1)
    {
        if (zzot.zzqt == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        zzot.zzqt.onAppEvent(s, s1);
        return;
        s;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call the AppEventListener.", s);
        return;
    }

    public void pause()
    {
        zzx.zzci("pause must be called on the main UI thread.");
    }

    protected void recordImpression()
    {
        zzc(zzot.zzqo);
    }

    public void resume()
    {
        zzx.zzci("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean flag)
    {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void stopLoading()
    {
        zzx.zzci("stopLoading must be called on the main UI thread.");
        zzor = false;
        zzot.zzf(true);
    }

    Bundle zza(zzbk zzbk1)
    {
        if (zzbk1 != null)
        {
            if (zzbk1.zzcx())
            {
                zzbk1.wakeup();
            }
            zzbh zzbh1 = zzbk1.zzcv();
            if (zzbh1 != null)
            {
                zzbk1 = zzbh1.zzcm();
                com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder("In AdManger: loadAd, ")).append(zzbh1.toString()).toString());
            } else
            {
                zzbk1 = null;
            }
            if (zzbk1 != null)
            {
                Bundle bundle = new Bundle(1);
                bundle.putString("fingerprint", zzbk1);
                bundle.putInt("v", 1);
                return bundle;
            }
        }
        return null;
    }

    public void zza(AdSizeParcel adsizeparcel)
    {
        zzx.zzci("setAdSize must be called on the main UI thread.");
        zzot.zzqn = adsizeparcel;
        if (zzot.zzqo != null && zzot.zzqo.zzBD != null && zzot.zzqH == 0)
        {
            zzot.zzqo.zzBD.zza(adsizeparcel);
        }
        if (zzot.zzqk == null)
        {
            return;
        }
        if (zzot.zzqk.getChildCount() > 1)
        {
            zzot.zzqk.removeView(zzot.zzqk.getNextView());
        }
        zzot.zzqk.setMinimumWidth(adsizeparcel.widthPixels);
        zzot.zzqk.setMinimumHeight(adsizeparcel.heightPixels);
        zzot.zzqk.requestLayout();
    }

    public void zza(com.google.android.gms.ads.internal.client.zzn zzn1)
    {
        zzx.zzci("setAdListener must be called on the main UI thread.");
        zzot.zzqr = zzn1;
    }

    public void zza(zzo zzo1)
    {
        zzx.zzci("setAdListener must be called on the main UI thread.");
        zzot.zzqs = zzo1;
    }

    public void zza(zzu zzu1)
    {
        zzx.zzci("setAppEventListener must be called on the main UI thread.");
        zzot.zzqt = zzu1;
    }

    public void zza(zzv zzv)
    {
        zzx.zzci("setCorrelationIdProvider must be called on the main UI thread");
        zzot.zzqu = zzv;
    }

    public void zza(zzck zzck)
    {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzfs zzfs)
    {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzfw zzfw, String s)
    {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(com.google.android.gms.internal.zzhs.zza zza1)
    {
        if (zza1.zzHD.zzEO != -1L && !TextUtils.isEmpty(zza1.zzHD.zzEY))
        {
            long l = zzo(zza1.zzHD.zzEY);
            if (l != -1L)
            {
                zzce zzce1 = zzoo.zzb(l + zza1.zzHD.zzEO);
                zzoo.zza(zzce1, new String[] {
                    "stc"
                });
            }
        }
        zzoo.zzT(zza1.zzHD.zzEY);
        zzoo.zza(zzop, new String[] {
            "arf"
        });
        zzoq = zzoo.zzdn();
        zzoo.zze("gqi", zza1.zzHD.zzEZ);
        zzot.zzql = null;
        zzot.zzqp = zza1;
        zza(zza1, zzoo);
    }

    protected abstract void zza(com.google.android.gms.internal.zzhs.zza zza1, zzcg zzcg1);

    public void zza(HashSet hashset)
    {
        zzot.zza(hashset);
    }

    protected abstract boolean zza(AdRequestParcel adrequestparcel, zzcg zzcg1);

    boolean zza(zzhs zzhs1)
    {
        return false;
    }

    protected abstract boolean zza(zzhs zzhs1, zzhs zzhs2);

    void zzaL()
    {
        zzoo = new zzcg(((Boolean)zzby.zzuQ.get()).booleanValue(), "load_ad", zzot.zzqn.zzte);
        zzop = new zzce(-1L, null, null);
        zzoq = new zzce(-1L, null, null);
    }

    public zzd zzaM()
    {
        zzx.zzci("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zze.zzy(zzot.zzqk);
    }

    public AdSizeParcel zzaN()
    {
        zzx.zzci("getAdSize must be called on the main UI thread.");
        if (zzot.zzqn == null)
        {
            return null;
        } else
        {
            return new ThinAdSizeParcel(zzot.zzqn);
        }
    }

    public void zzaO()
    {
        zzaR();
    }

    public void zzaP()
    {
        zzx.zzci("recordManualImpression must be called on the main UI thread.");
        if (zzot.zzqo == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping manual tracking URLs.");
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging manual tracking URLs.");
            if (zzot.zzqo.zzEM != null)
            {
                zzp.zzbv().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo.zzEM);
                return;
            }
        }
    }

    protected boolean zzaQ()
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("Ad closing.");
        if (zzot.zzqs == null)
        {
            return false;
        }
        try
        {
            zzot.zzqs.onAdClosed();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call AdListener.onAdClosed().", remoteexception);
            return false;
        }
        return true;
    }

    protected boolean zzaS()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("Ad opening.");
        if (zzot.zzqs == null)
        {
            return false;
        }
        try
        {
            zzot.zzqs.onAdOpened();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call AdListener.onAdOpened().", remoteexception);
            return false;
        }
        return true;
    }

    protected boolean zzaT()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("Ad finished loading.");
        zzor = false;
        if (zzot.zzqs == null)
        {
            return false;
        }
        try
        {
            zzot.zzqs.onAdLoaded();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call AdListener.onAdLoaded().", remoteexception);
            return false;
        }
        return true;
    }

    protected void zzb(View view)
    {
        zzot.zzqk.addView(view, zzp.zzbx().zzgJ());
    }

    public void zzb(zzhs zzhs1)
    {
        zzoo.zza(zzoq, new String[] {
            "awr"
        });
        zzot.zzqm = null;
        if (zzhs1.errorCode != -2 && zzhs1.errorCode != 3)
        {
            com.google.android.gms.ads.internal.zzp.zzby().zzb(zzot.zzbJ());
        }
        if (zzhs1.errorCode == -1)
        {
            zzor = false;
        } else
        {
            if (zza(zzhs1))
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaF("Ad refresh scheduled.");
            }
            if (zzhs1.errorCode != -2)
            {
                zze(zzhs1.errorCode);
                return;
            }
            if (zzot.zzqF == null)
            {
                zzot.zzqF = new zzhx(zzot.zzqh);
            }
            zzov.zze(zzot.zzqo);
            if (zza(zzot.zzqo, zzhs1))
            {
                zzot.zzqo = zzhs1;
                zzot.zzbS();
                zzcg zzcg1 = zzoo;
                if (zzot.zzqo.zzbY())
                {
                    zzhs1 = "1";
                } else
                {
                    zzhs1 = "0";
                }
                zzcg1.zze("is_mraid", zzhs1);
                zzcg1 = zzoo;
                if (zzot.zzqo.zzEK)
                {
                    zzhs1 = "1";
                } else
                {
                    zzhs1 = "0";
                }
                zzcg1.zze("is_mediation", zzhs1);
                if (zzot.zzqo.zzBD != null && zzot.zzqo.zzBD.zzhe() != null)
                {
                    zzcg zzcg2 = zzoo;
                    if (zzot.zzqo.zzBD.zzhe().zzhr())
                    {
                        zzhs1 = "1";
                    } else
                    {
                        zzhs1 = "0";
                    }
                    zzcg2.zze("is_video", zzhs1);
                }
                zzoo.zza(zzop, new String[] {
                    "ttc"
                });
                if (com.google.android.gms.ads.internal.zzp.zzby().zzgo() != null)
                {
                    com.google.android.gms.ads.internal.zzp.zzby().zzgo().zza(zzoo);
                }
                if (zzot.zzbN())
                {
                    zzaT();
                    return;
                }
            }
        }
    }

    public boolean zzb(AdRequestParcel adrequestparcel)
    {
        zzx.zzci("loadAd must be called on the main UI thread.");
        adrequestparcel = zza(adrequestparcel);
        if (zzor)
        {
            if (zzou != null)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            zzou = adrequestparcel;
            return false;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("Starting ad request.");
        zzor = true;
        zzaL();
        zzop = zzoo.zzdn();
        if (!adrequestparcel.zzsE)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG((new StringBuilder("Use AdRequest.Builder.addTestDevice(\"")).append(zzl.zzcF().zzQ(zzot.context)).append("\") to get test ads on this device.").toString());
        }
        return zza(adrequestparcel, zzoo);
    }

    protected void zzc(zzhs zzhs1)
    {
        if (zzhs1 == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping impression URLs.");
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging Impression URLs.");
            zzot.zzqq.zzgf();
            if (zzhs1.zzyZ != null)
            {
                zzp.zzbv().zza(zzot.context, zzot.zzqj.zzJu, zzhs1.zzyZ);
                return;
            }
        }
    }

    protected boolean zzc(AdRequestParcel adrequestparcel)
    {
        adrequestparcel = zzot.zzqk.getParent();
        return (adrequestparcel instanceof View) && ((View)adrequestparcel).isShown() && zzp.zzbv().zzgB();
    }

    public void zzd(AdRequestParcel adrequestparcel)
    {
        if (zzc(adrequestparcel))
        {
            zzb(adrequestparcel);
            return;
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaG("Ad is not visible. Not refreshing ad.");
            zzos.zzg(adrequestparcel);
            return;
        }
    }

    protected boolean zze(int i)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Failed to load ad: ")).append(i).toString());
        zzor = false;
        if (zzot.zzqs == null)
        {
            return false;
        }
        try
        {
            zzot.zzqs.onAdFailedToLoad(i);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call AdListener.onAdFailedToLoad().", remoteexception);
            return false;
        }
        return true;
    }

    long zzo(String s)
    {
        int i;
        int k;
        k = s.indexOf("ufe");
        int j = s.indexOf(',', k);
        i = j;
        if (j == -1)
        {
            i = s.length();
        }
        long l = Long.parseLong(s.substring(k + 4, i));
        return l;
        s;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid index for Url fetch time in CSI latency info.");
_L2:
        return -1L;
        s;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot find valid format of Url fetch time in CSI latency info.");
        if (true) goto _L2; else goto _L1
_L1:
    }
}
