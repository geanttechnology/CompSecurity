// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzc, zzp, zzq, InterstitialAdParameterParcel, 
//            zzo, zzd, zze

public class zzk extends zzc
    implements zzdo
{

    protected transient boolean zzpk;
    private boolean zzpl;
    private float zzpm;
    private String zzpn;

    public zzk(Context context, AdSizeParcel adsizeparcel, String s, zzem zzem, VersionInfoParcel versioninfoparcel, zzd zzd1)
    {
        super(context, adsizeparcel, s, zzem, versioninfoparcel, zzd1);
        zzpk = false;
        zzpn = (new StringBuilder("background")).append(hashCode()).append(".png").toString();
    }

    static boolean zza(zzk zzk1)
    {
        return zzk1.zzpl;
    }

    static float zzb(zzk zzk1)
    {
        return zzk1.zzpm;
    }

    private void zzb(Bundle bundle)
    {
        zzp.zzbv().zzb(zzot.context, zzot.zzqj.zzJu, "gmob-apps", bundle, false);
    }

    private void zzbm()
    {
        (new zza(zzpn)).zzgz();
        if (zzot.zzbN())
        {
            zzot.zzbK();
            zzot.zzqo = null;
            zzot.zzpt = false;
            zzpk = false;
        }
    }

    public void showInterstitial()
    {
        zzx.zzci("showInterstitial must be called on the main UI thread.");
        if (zzot.zzqo == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("The interstitial has not loaded.");
        } else
        {
            if (((Boolean)zzby.zzvo.get()).booleanValue())
            {
                Object obj;
                if (zzot.context.getApplicationContext() != null)
                {
                    obj = zzot.context.getApplicationContext().getPackageName();
                } else
                {
                    obj = zzot.context.getPackageName();
                }
                if (!zzpk)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("It is not recommended to show an interstitial before onAdLoaded completes.");
                    Bundle bundle = new Bundle();
                    bundle.putString("appid", ((String) (obj)));
                    bundle.putString("action", "show_interstitial_before_load_finish");
                    zzb(bundle);
                }
                if (!zzp.zzbv().zzN(zzot.context))
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("It is not recommended to show an interstitial when app is not in foreground.");
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("appid", ((String) (obj)));
                    bundle1.putString("action", "show_interstitial_app_not_in_foreground");
                    zzb(bundle1);
                }
            }
            if (!zzot.zzbO())
            {
                if (zzot.zzqo.zzEK)
                {
                    try
                    {
                        zzot.zzqo.zzzv.showInterstitial();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial.", ((Throwable) (obj)));
                    }
                    zzbm();
                    return;
                }
                if (zzot.zzqo.zzBD == null)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("The interstitial failed to load.");
                    return;
                }
                if (zzot.zzqo.zzBD.zzhi())
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaH("The interstitial is already showing.");
                    return;
                }
                zzot.zzqo.zzBD.zzC(true);
                if (zzot.zzqo.zzHw != null)
                {
                    zzov.zza(zzot.zzqn, zzot.zzqo);
                }
                Object obj1;
                if (zzot.zzpt)
                {
                    obj1 = zzp.zzbv().zzO(zzot.context);
                } else
                {
                    obj1 = null;
                }
                if (((Boolean)zzby.zzvz.get()).booleanValue() && obj1 != null)
                {
                    (new zzb(((Bitmap) (obj1)), zzpn)).zzgz();
                    return;
                }
                obj1 = new InterstitialAdParameterParcel(zzot.zzpt, zzbl(), null, false, 0.0F);
                int j = zzot.zzqo.zzBD.getRequestedOrientation();
                int i = j;
                if (j == -1)
                {
                    i = zzot.zzqo.orientation;
                }
                obj1 = new AdOverlayInfoParcel(this, this, this, zzot.zzqo.zzBD, i, zzot.zzqj, zzot.zzqo.zzEP, ((InterstitialAdParameterParcel) (obj1)));
                zzp.zzbt().zza(zzot.context, ((AdOverlayInfoParcel) (obj1)));
                return;
            }
        }
    }

    protected zziz zza(com.google.android.gms.internal.zzhs.zza zza1, com.google.android.gms.ads.internal.zze zze1)
    {
        zziz zziz1 = zzp.zzbw().zza(zzot.context, zzot.zzqn, false, false, zzot.zzqi, zzot.zzqj, zzoo, zzow);
        zziz1.zzhe().zzb(this, null, this, this, ((Boolean)zzby.zzvc.get()).booleanValue(), this, this, zze1, null);
        zziz1.zzaJ(zza1.zzHC.zzEC);
        return zziz1;
    }

    public void zza(boolean flag, float f)
    {
        zzpl = flag;
        zzpm = f;
    }

    public boolean zza(AdRequestParcel adrequestparcel, zzcg zzcg)
    {
        if (zzot.zzqo != null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("An interstitial is already loading. Aborting.");
            return false;
        } else
        {
            return super.zza(adrequestparcel, zzcg);
        }
    }

    protected boolean zza(AdRequestParcel adrequestparcel, zzhs zzhs1, boolean flag)
    {
        if (zzot.zzbN() && zzhs1.zzBD != null)
        {
            zzp.zzbx().zza(zzhs1.zzBD.getWebView());
        }
        return zzos.zzbp();
    }

    public boolean zza(zzhs zzhs1, zzhs zzhs2)
    {
        if (!super.zza(zzhs1, zzhs2))
        {
            return false;
        }
        if (!zzot.zzbN() && zzot.zzqG != null && zzhs2.zzHw != null)
        {
            zzov.zza(zzot.zzqn, zzhs2, zzot.zzqG);
        }
        return true;
    }

    protected boolean zzaQ()
    {
        zzbm();
        return super.zzaQ();
    }

    protected boolean zzaT()
    {
        if (super.zzaT())
        {
            zzpk = true;
            return true;
        } else
        {
            return false;
        }
    }

    public void zzaW()
    {
        recordImpression();
        super.zzaW();
    }

    protected boolean zzbl()
    {
        if (!(zzot.context instanceof Activity))
        {
            return false;
        }
        Window window = ((Activity)zzot.context).getWindow();
        if (window == null || window.getDecorView() == null)
        {
            return false;
        }
        Rect rect = new Rect();
        Rect rect1 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect1);
        return rect.bottom != 0 && rect1.bottom != 0 && rect.top == rect1.top;
    }

    public void zzd(boolean flag)
    {
        zzot.zzpt = flag;
    }

    private class zza extends zzhz
    {

        private final String zzpo;
        final zzk zzpp;

        public void onStop()
        {
        }

        public void zzbn()
        {
            zzp.zzbv().zzh(zzpp.zzot.context, zzpo);
        }

        public zza(String s)
        {
            zzpp = zzk.this;
            super();
            zzpo = s;
        }
    }


    private class zzb extends zzhz
    {

        private final String zzpo;
        final zzk zzpp;
        private final Bitmap zzpq;

        public void onStop()
        {
        }

        public void zzbn()
        {
            class _cls1
                implements Runnable
            {

                final AdOverlayInfoParcel zzpr;
                final zzb zzps;

                public void run()
                {
                    zzp.zzbt().zza(zzps.zzpp.zzot.context, zzpr);
                }

                _cls1(AdOverlayInfoParcel adoverlayinfoparcel)
                {
                    zzps = zzb.this;
                    zzpr = adoverlayinfoparcel;
                    super();
                }
            }

            Object obj;
            int i;
            int j;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (zzpp.zzot.zzpt)
            {
                flag = zzp.zzbv().zza(zzpp.zzot.context, zzpq, zzpo);
            } else
            {
                flag = false;
            }
            flag1 = zzpp.zzot.zzpt;
            flag2 = zzpp.zzbl();
            if (flag)
            {
                obj = zzpo;
            } else
            {
                obj = null;
            }
            obj = new InterstitialAdParameterParcel(flag1, flag2, ((String) (obj)), zzk.zza(zzpp), com.google.android.gms.ads.internal.zzk.zzb(zzpp));
            j = zzpp.zzot.zzqo.zzBD.getRequestedOrientation();
            i = j;
            if (j == -1)
            {
                i = zzpp.zzot.zzqo.orientation;
            }
            obj = new AdOverlayInfoParcel(zzpp, zzpp, zzpp, zzpp.zzot.zzqo.zzBD, i, zzpp.zzot.zzqj, zzpp.zzot.zzqo.zzEP, ((InterstitialAdParameterParcel) (obj)));
            zzid.zzIE.post(new _cls1(((AdOverlayInfoParcel) (obj))));
        }

        public zzb(Bitmap bitmap, String s)
        {
            zzpp = zzk.this;
            super();
            zzpq = bitmap;
            zzpo = s;
        }
    }

}
