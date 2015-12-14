// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmi;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zza, zzq, zzp, zzo, 
//            zzd

public abstract class zzb extends com.google.android.gms.ads.internal.zza
    implements zzg, zzj, zzdm, zzef
{

    private final Messenger mMessenger;
    public final zzem zzox;
    protected transient boolean zzoy;

    public zzb(Context context, AdSizeParcel adsizeparcel, String s, zzem zzem, VersionInfoParcel versioninfoparcel, com.google.android.gms.ads.internal.zzd zzd1)
    {
        this(new zzq(context, adsizeparcel, s, versioninfoparcel), zzem, null, zzd1);
    }

    zzb(zzq zzq1, zzem zzem, zzo zzo1, com.google.android.gms.ads.internal.zzd zzd1)
    {
        super(zzq1, zzo1, zzd1);
        zzox = zzem;
        mMessenger = new Messenger(new zzfp(zzot.context));
        zzoy = false;
    }

    private com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza(AdRequestParcel adrequestparcel, Bundle bundle)
    {
        ApplicationInfo applicationinfo = zzot.context.getApplicationInfo();
        Object obj;
        Object obj1;
        String s;
        DisplayMetrics displaymetrics;
        String s1;
        Object obj2;
        Bundle bundle1;
        ArrayList arraylist;
        long l1;
        long l2;
        try
        {
            obj = zzot.context.getPackageManager().getPackageInfo(applicationinfo.packageName, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        displaymetrics = zzot.context.getResources().getDisplayMetrics();
        s = null;
        obj1 = s;
        if (zzot.zzqk != null)
        {
            obj1 = s;
            if (zzot.zzqk.getParent() != null)
            {
                obj1 = new int[2];
                zzot.zzqk.getLocationOnScreen(((int []) (obj1)));
                int k = obj1[0];
                int l = obj1[1];
                int i1 = zzot.zzqk.getWidth();
                int j1 = zzot.zzqk.getHeight();
                boolean flag = false;
                int i = ((flag) ? 1 : 0);
                if (zzot.zzqk.isShown())
                {
                    i = ((flag) ? 1 : 0);
                    if (k + i1 > 0)
                    {
                        i = ((flag) ? 1 : 0);
                        if (l + j1 > 0)
                        {
                            i = ((flag) ? 1 : 0);
                            if (k <= displaymetrics.widthPixels)
                            {
                                i = ((flag) ? 1 : 0);
                                if (l <= displaymetrics.heightPixels)
                                {
                                    i = 1;
                                }
                            }
                        }
                    }
                }
                obj1 = new Bundle(5);
                ((Bundle) (obj1)).putInt("x", k);
                ((Bundle) (obj1)).putInt("y", l);
                ((Bundle) (obj1)).putInt("width", i1);
                ((Bundle) (obj1)).putInt("height", j1);
                ((Bundle) (obj1)).putInt("visible", i);
            }
        }
        s = com.google.android.gms.ads.internal.zzp.zzby().zzgm();
        zzot.zzqq = new zzht(s, zzot.zzqh);
        zzot.zzqq.zzi(adrequestparcel);
        s1 = zzp.zzbv().zza(zzot.context, zzot.zzqk, zzot.zzqn);
        l2 = 0L;
        l1 = l2;
        if (zzot.zzqu != null)
        {
            try
            {
                l1 = zzot.zzqu.getValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot get correlation id, default to 0.");
                l1 = l2;
            }
        }
        obj2 = UUID.randomUUID().toString();
        bundle1 = com.google.android.gms.ads.internal.zzp.zzby().zza(zzot.context, this, s);
        arraylist = new ArrayList();
        for (int j = 0; j < zzot.zzqA.size(); j++)
        {
            arraylist.add(zzot.zzqA.keyAt(j));
        }

        boolean flag1;
        boolean flag2;
        if (zzot.zzqv != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (zzot.zzqw != null && com.google.android.gms.ads.internal.zzp.zzby().zzgv())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return new com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza(((Bundle) (obj1)), adrequestparcel, zzot.zzqn, zzot.zzqh, applicationinfo, ((PackageInfo) (obj)), s, com.google.android.gms.ads.internal.zzp.zzby().getSessionId(), zzot.zzqj, bundle1, zzot.zzqD, arraylist, bundle, com.google.android.gms.ads.internal.zzp.zzby().zzgq(), mMessenger, displaymetrics.widthPixels, displaymetrics.heightPixels, displaymetrics.density, s1, l1, ((String) (obj2)), zzby.zzdf(), zzot.zzqg, zzot.zzqB, new CapabilityParcel(flag1, flag2), zzot.zzbR());
    }

    public String getMediationAdapterClassName()
    {
        if (zzot.zzqo == null)
        {
            return null;
        } else
        {
            return zzot.zzqo.zzzw;
        }
    }

    public void onAdClicked()
    {
        if (zzot.zzqo == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (zzot.zzqo.zzHx != null && zzot.zzqo.zzHx.zzyY != null)
        {
            zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzHx.zzyY);
        }
        if (zzot.zzqo.zzzu != null && zzot.zzqo.zzzu.zzyR != null)
        {
            zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzzu.zzyR);
        }
        super.onAdClicked();
    }

    public void pause()
    {
        zzx.zzci("pause must be called on the main UI thread.");
        if (zzot.zzqo != null && zzot.zzqo.zzBD != null && zzot.zzbN())
        {
            zzp.zzbx().zza(zzot.zzqo.zzBD.getWebView());
        }
        if (zzot.zzqo != null && zzot.zzqo.zzzv != null)
        {
            try
            {
                zzot.zzqo.zzzv.pause();
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not pause mediation adapter.");
            }
        }
        zzov.zzg(zzot.zzqo);
        zzos.pause();
    }

    public void resume()
    {
        zzx.zzci("resume must be called on the main UI thread.");
        if (zzot.zzqo != null && zzot.zzqo.zzBD != null && zzot.zzbN())
        {
            zzp.zzbx().zzb(zzot.zzqo.zzBD.getWebView());
        }
        if (zzot.zzqo != null && zzot.zzqo.zzzv != null)
        {
            try
            {
                zzot.zzqo.zzzv.resume();
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not resume mediation adapter.");
            }
        }
        zzos.resume();
        zzov.zzh(zzot.zzqo);
    }

    public void showInterstitial()
    {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(zzfs zzfs1)
    {
        zzx.zzci("setInAppPurchaseListener must be called on the main UI thread.");
        zzot.zzqv = zzfs1;
    }

    public void zza(zzfw zzfw1, String s)
    {
        zzx.zzci("setPlayStorePurchaseParams must be called on the main UI thread.");
        zzot.zzqE = new zzk(s);
        zzot.zzqw = zzfw1;
        if (!com.google.android.gms.ads.internal.zzp.zzby().zzgp() && zzfw1 != null)
        {
            (new zzc(zzot.context, zzot.zzqw, zzot.zzqE)).zzgz();
        }
    }

    public void zza(zzhs zzhs1, boolean flag)
    {
        if (zzhs1 == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping impression URLs.");
        } else
        {
            super.zzc(zzhs1);
            if (zzhs1.zzHx != null && zzhs1.zzHx.zzyZ != null)
            {
                zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzhs1, zzot.zzqh, flag, zzhs1.zzHx.zzyZ);
            }
            if (zzhs1.zzzu != null && zzhs1.zzzu.zzyS != null)
            {
                zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzhs1, zzot.zzqh, flag, zzhs1.zzzu.zzyS);
                return;
            }
        }
    }

    public void zza(String s, ArrayList arraylist)
    {
        arraylist = new zzd(s, arraylist, zzot.context, zzot.zzqj.zzJu);
        if (zzot.zzqv == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzl.zzcF().zzR(zzot.context))
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            }
            if (zzot.zzqw == null)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseListener is not set.");
                return;
            }
            if (zzot.zzqE == null)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseVerifier is not initialized.");
                return;
            }
            if (zzot.zzqI)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("An in-app purchase request is already in progress, abort");
                return;
            }
            zzot.zzqI = true;
            try
            {
                if (!zzot.zzqw.isValidPurchase(s))
                {
                    zzot.zzqI = false;
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
                zzot.zzqI = false;
                return;
            }
            zzp.zzbF().zza(zzot.context, zzot.zzqj.zzJx, new GInAppPurchaseManagerInfoParcel(zzot.context, zzot.zzqE, arraylist, this));
            return;
        }
        try
        {
            zzot.zzqv.zza(arraylist);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
        }
    }

    public void zza(String s, boolean flag, int i, Intent intent, zzf zzf)
    {
        try
        {
            if (zzot.zzqw != null)
            {
                zzot.zzqw.zza(new com.google.android.gms.ads.internal.purchase.zzg(zzot.context, s, flag, i, intent, zzf));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to invoke PlayStorePurchaseListener.");
        }
        zzid.zzIE.postDelayed(new Runnable(intent) {

            final zzb zzoA;
            final Intent zzoz;

            public void run()
            {
                int j = zzp.zzbF().zzd(zzoz);
                zzp.zzbF();
                if (j == 0 && zzoA.zzot.zzqo != null && zzoA.zzot.zzqo.zzBD != null && zzoA.zzot.zzqo.zzBD.zzhc() != null)
                {
                    zzoA.zzot.zzqo.zzBD.zzhc().close();
                }
                zzoA.zzot.zzqI = false;
            }

            
            {
                zzoA = zzb.this;
                zzoz = intent;
                super();
            }
        }, 500L);
    }

    public boolean zza(AdRequestParcel adrequestparcel, zzcg zzcg1)
    {
        if (!zzaU())
        {
            return false;
        }
        Bundle bundle = zza(com.google.android.gms.ads.internal.zzp.zzby().zzE(zzot.context));
        zzos.cancel();
        zzot.zzqH = 0;
        adrequestparcel = zza(adrequestparcel, bundle);
        zzcg1.zze("seq_num", ((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza) (adrequestparcel)).zzEq);
        zzcg1.zze("request_id", ((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza) (adrequestparcel)).zzEC);
        zzcg1.zze("session_id", ((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza) (adrequestparcel)).zzEr);
        if (((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza) (adrequestparcel)).zzEo != null)
        {
            zzcg1.zze("app_version", String.valueOf(((com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza) (adrequestparcel)).zzEo.versionCode));
        }
        zzot.zzql = zzp.zzbr().zza(zzot.context, adrequestparcel, zzot.zzqi, this);
        return true;
    }

    protected boolean zza(AdRequestParcel adrequestparcel, zzhs zzhs1, boolean flag)
    {
        if (flag || !zzot.zzbN()) goto _L2; else goto _L1
_L1:
        if (zzhs1.zzzc <= 0L) goto _L4; else goto _L3
_L3:
        zzos.zza(adrequestparcel, zzhs1.zzzc);
_L2:
        return zzos.zzbp();
_L4:
        if (zzhs1.zzHx != null && zzhs1.zzHx.zzzc > 0L)
        {
            zzos.zza(adrequestparcel, zzhs1.zzHx.zzzc);
        } else
        if (!zzhs1.zzEK && zzhs1.errorCode == 2)
        {
            zzos.zzg(adrequestparcel);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    boolean zza(zzhs zzhs1)
    {
        boolean flag = false;
        if (zzou == null) goto _L2; else goto _L1
_L1:
        AdRequestParcel adrequestparcel;
        adrequestparcel = zzou;
        zzou = null;
_L4:
        return zza(adrequestparcel, zzhs1, flag);
_L2:
        AdRequestParcel adrequestparcel1 = zzhs1.zzEn;
        adrequestparcel = adrequestparcel1;
        if (adrequestparcel1.extras != null)
        {
            flag = adrequestparcel1.extras.getBoolean("_noRefresh", false);
            adrequestparcel = adrequestparcel1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean zza(zzhs zzhs1, zzhs zzhs2)
    {
        int i = 0;
        if (zzhs1 != null && zzhs1.zzzx != null)
        {
            zzhs1.zzzx.zza(null);
        }
        if (zzhs2.zzzx != null)
        {
            zzhs2.zzzx.zza(this);
        }
        int j;
        if (zzhs2.zzHx != null)
        {
            j = zzhs2.zzHx.zzzf;
            i = zzhs2.zzHx.zzzg;
        } else
        {
            j = 0;
        }
        zzot.zzqF.zzf(j, i);
        return true;
    }

    protected boolean zzaU()
    {
        boolean flag = true;
        if (!zzp.zzbv().zza(zzot.context.getPackageManager(), zzot.context.getPackageName(), "android.permission.INTERNET") || !zzp.zzbv().zzH(zzot.context))
        {
            flag = false;
        }
        return flag;
    }

    public void zzaV()
    {
        zzov.zze(zzot.zzqo);
        zzoy = false;
        zzaQ();
        zzot.zzqq.zzgh();
    }

    public void zzaW()
    {
        zzoy = true;
        zzaS();
    }

    public void zzaX()
    {
        onAdClicked();
    }

    public void zzaY()
    {
        zzaV();
    }

    public void zzaZ()
    {
        zzaO();
    }

    public void zzb(zzhs zzhs1)
    {
        super.zzb(zzhs1);
        if (zzhs1.errorCode == 3 && zzhs1.zzHx != null && zzhs1.zzHx.zzza != null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging no fill URLs.");
            zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzhs1, zzot.zzqh, false, zzhs1.zzHx.zzza);
        }
    }

    public void zzba()
    {
        zzaW();
    }

    public void zzbb()
    {
        if (zzot.zzqo != null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH((new StringBuilder("Mediation adapter ")).append(zzot.zzqo.zzzw).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        zza(zzot.zzqo, true);
        zzaT();
    }

    protected boolean zzc(AdRequestParcel adrequestparcel)
    {
        return super.zzc(adrequestparcel) && !zzoy;
    }
}
