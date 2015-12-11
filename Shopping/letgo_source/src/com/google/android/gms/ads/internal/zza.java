// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.lk;
import android.support.v7.ll;
import android.support.v7.mm;
import android.support.v7.mw;
import android.support.v7.mz;
import android.support.v7.nj;
import android.support.v7.nn;
import android.support.v7.nq;
import android.support.v7.ns;
import android.support.v7.nt;
import android.support.v7.nx;
import android.support.v7.ou;
import android.support.v7.rf;
import android.support.v7.rj;
import android.support.v7.te;
import android.support.v7.tf;
import android.support.v7.tg;
import android.support.v7.ti;
import android.support.v7.tj;
import android.support.v7.tp;
import android.support.v7.tq;
import android.support.v7.ul;
import android.support.v7.um;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.x;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzp, zzq, zzo, zzd

public abstract class zza extends com.google.android.gms.ads.internal.client.zzr.zza
    implements ou, android.support.v7.ru.a, ti, com.google.android.gms.ads.internal.client.zza, zzn, com.google.android.gms.ads.internal.request.zza
{

    private nt zzon;
    private ns zzoo;
    private ns zzop;
    boolean zzoq;
    protected final zzo zzor;
    protected final zzq zzos;
    protected transient AdRequestParcel zzot;
    protected final mm zzou = zzp.zzbA().j();
    protected final zzd zzov;

    zza(zzq zzq1, zzo zzo1, zzd zzd)
    {
        zzoq = false;
        zzos = zzq1;
        if (zzo1 == null)
        {
            zzo1 = new zzo(this);
        }
        zzor = zzo1;
        zzov = zzd;
        zzp.zzbx().b(zzos.context);
        zzp.zzbA().a(zzos.context, zzos.zzqb);
    }

    private boolean zzaR()
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaD("Ad leaving application.");
        if (zzos.zzqk == null)
        {
            return false;
        }
        try
        {
            zzos.zzqk.onAdLeftApplication();
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
        x.b("destroy must be called on the main UI thread.");
        zzor.cancel();
        zzou.c(zzos.zzqg);
        zzos.destroy();
    }

    public boolean isLoading()
    {
        return zzoq;
    }

    public boolean isReady()
    {
        x.b("isLoaded must be called on the main UI thread.");
        return zzos.zzqd == null && zzos.zzqe == null && zzos.zzqg != null;
    }

    public void onAdClicked()
    {
        if (zzos.zzqg == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Ad state was null when trying to ping click URLs.");
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Pinging click URLs.");
            zzos.zzqi.b();
            if (zzos.zzqg.c != null)
            {
                zzp.zzbx().a(zzos.context, zzos.zzqb.zzIz, zzp.zzbx().a(zzos.context, zzos.zzqg.c, zzos.zzqg.x));
            }
            if (zzos.zzqj != null)
            {
                try
                {
                    zzos.zzqj.onAdClicked();
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
        if (zzos.zzql == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        zzos.zzql.onAppEvent(s, s1);
        return;
        s;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call the AppEventListener.", s);
        return;
    }

    public void pause()
    {
        x.b("pause must be called on the main UI thread.");
    }

    protected void recordImpression()
    {
        zzc(zzos.zzqg);
    }

    public void resume()
    {
        x.b("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean flag)
    {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void stopLoading()
    {
        x.b("stopLoading must be called on the main UI thread.");
        zzoq = false;
        zzos.zzf(true);
    }

    Bundle zza(mz mz1)
    {
        if (mz1 != null)
        {
            if (mz1.f())
            {
                mz1.d();
            }
            mw mw1 = mz1.c();
            if (mw1 != null)
            {
                mz1 = mw1.b();
                com.google.android.gms.ads.internal.util.client.zzb.zzaC((new StringBuilder()).append("In AdManger: loadAd, ").append(mw1.toString()).toString());
            } else
            {
                mz1 = null;
            }
            if (mz1 != null)
            {
                Bundle bundle = new Bundle(1);
                bundle.putString("fingerprint", mz1);
                bundle.putInt("v", 1);
                return bundle;
            }
        }
        return null;
    }

    public void zza(nx nx)
    {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(rf rf)
    {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(rj rj, String s)
    {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(android.support.v7.te.a a)
    {
        if (a.b.zzEb != -1L && !TextUtils.isEmpty(a.b.zzEl))
        {
            long l = zzo(a.b.zzEl);
            if (l != -1L)
            {
                ns ns1 = zzon.a(l + a.b.zzEb);
                zzon.a(ns1, new String[] {
                    "stc"
                });
            }
        }
        zzon.a(a.b.zzEl);
        zzon.a(zzoo, new String[] {
            "arf"
        });
        zzop = zzon.a();
        zzos.zzqd = null;
        zzos.zzqh = a;
        zza(a, zzon);
    }

    protected abstract void zza(android.support.v7.te.a a, nt nt1);

    public void zza(AdSizeParcel adsizeparcel)
    {
        x.b("setAdSize must be called on the main UI thread.");
        zzos.zzqf = adsizeparcel;
        if (zzos.zzqg != null && zzos.zzqg.b != null && zzos.zzqz == 0)
        {
            zzos.zzqg.b.a(adsizeparcel);
        }
        if (zzos.zzqc == null)
        {
            return;
        }
        if (zzos.zzqc.getChildCount() > 1)
        {
            zzos.zzqc.removeView(zzos.zzqc.getNextView());
        }
        zzos.zzqc.setMinimumWidth(adsizeparcel.widthPixels);
        zzos.zzqc.setMinimumHeight(adsizeparcel.heightPixels);
        zzos.zzqc.requestLayout();
    }

    public void zza(zzm zzm1)
    {
        x.b("setAdListener must be called on the main UI thread.");
        zzos.zzqj = zzm1;
    }

    public void zza(com.google.android.gms.ads.internal.client.zzn zzn1)
    {
        x.b("setAdListener must be called on the main UI thread.");
        zzos.zzqk = zzn1;
    }

    public void zza(zzt zzt1)
    {
        x.b("setAppEventListener must be called on the main UI thread.");
        zzos.zzql = zzt1;
    }

    public void zza(zzu zzu)
    {
        x.b("setCorrelationIdProvider must be called on the main UI thread");
        zzos.zzqm = zzu;
    }

    public void zza(HashSet hashset)
    {
        zzos.zza(hashset);
    }

    boolean zza(te te1)
    {
        return false;
    }

    protected abstract boolean zza(te te1, te te2);

    public boolean zza(AdRequestParcel adrequestparcel)
    {
        x.b("loadAd must be called on the main UI thread.");
        if (zzos.zzqd != null || zzos.zzqe != null)
        {
            if (zzot != null)
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaE("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            zzot = adrequestparcel;
            return false;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaD("Starting ad request.");
        zzoq = true;
        zzaL();
        zzoo = zzon.a();
        if (!adrequestparcel.zzst)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaD((new StringBuilder()).append("Use AdRequest.Builder.addTestDevice(\"").append(zzk.zzcE().zzQ(zzos.context)).append("\") to get test ads on this device.").toString());
        }
        return zza(adrequestparcel, zzon);
    }

    protected abstract boolean zza(AdRequestParcel adrequestparcel, nt nt1);

    void zzaL()
    {
        zzon = new nt(((Boolean)nn.G.c()).booleanValue(), "load_ad", zzos.zzqf.zzsG);
        zzoo = new ns(-1L, null, null);
        zzop = new ns(-1L, null, null);
    }

    public lk zzaM()
    {
        x.b("getAdFrame must be called on the main UI thread.");
        return ll.a(zzos.zzqc);
    }

    public AdSizeParcel zzaN()
    {
        x.b("getAdSize must be called on the main UI thread.");
        return zzos.zzqf;
    }

    public void zzaO()
    {
        zzaR();
    }

    public void zzaP()
    {
        x.b("recordManualImpression must be called on the main UI thread.");
        if (zzos.zzqg == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Ad state was null when trying to ping manual tracking URLs.");
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Pinging manual tracking URLs.");
            if (zzos.zzqg.f != null)
            {
                zzp.zzbx().a(zzos.context, zzos.zzqb.zzIz, zzp.zzbx().a(zzos.context, zzos.zzqg.f, zzos.zzqg.x));
                return;
            }
        }
    }

    protected boolean zzaQ()
    {
        com.google.android.gms.ads.internal.util.client.zzb.v("Ad closing.");
        if (zzos.zzqk == null)
        {
            return false;
        }
        try
        {
            zzos.zzqk.onAdClosed();
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
        com.google.android.gms.ads.internal.util.client.zzb.zzaD("Ad opening.");
        if (zzos.zzqk == null)
        {
            return false;
        }
        try
        {
            zzos.zzqk.onAdOpened();
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
        com.google.android.gms.ads.internal.util.client.zzb.zzaD("Ad finished loading.");
        zzoq = false;
        if (zzos.zzqk == null)
        {
            return false;
        }
        try
        {
            zzos.zzqk.onAdLoaded();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call AdListener.onAdLoaded().", remoteexception);
            return false;
        }
        return true;
    }

    public void zzb(te te1)
    {
        zzon.a(zzop, new String[] {
            "awr"
        });
        zzos.zzqe = null;
        if (te1.d != -2 && te1.d != 3)
        {
            zzp.zzbA().a(zzos.zzbL());
        }
        if (te1.d == -1)
        {
            zzoq = false;
        } else
        {
            if (zza(te1))
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Ad refresh scheduled.");
            }
            if (te1.d != -2)
            {
                zze(te1.d);
                return;
            }
            if (zzos.zzqx == null)
            {
                zzos.zzqx = new tj(zzos.zzpZ);
            }
            zzou.b(zzos.zzqg);
            if (zza(zzos.zzqg, te1))
            {
                zzos.zzqg = te1;
                zzos.zzbS();
                nt nt1 = zzon;
                if (zzos.zzqg.a())
                {
                    te1 = "1";
                } else
                {
                    te1 = "0";
                }
                nt1.a("is_mraid", te1);
                nt1 = zzon;
                if (zzos.zzqg.k)
                {
                    te1 = "1";
                } else
                {
                    te1 = "0";
                }
                nt1.a("is_mediation", te1);
                if (zzos.zzqg.b != null && zzos.zzqg.b.i() != null)
                {
                    nt nt2 = zzon;
                    if (zzos.zzqg.b.i().c())
                    {
                        te1 = "1";
                    } else
                    {
                        te1 = "0";
                    }
                    nt2.a("is_video", te1);
                }
                zzon.a(zzoo, new String[] {
                    "ttc"
                });
                if (zzp.zzbA().e() != null)
                {
                    zzp.zzbA().e().a(zzon);
                }
                if (zzos.zzbP())
                {
                    zzaT();
                    return;
                }
            }
        }
    }

    protected void zzb(View view)
    {
        zzos.zzqc.addView(view, zzp.zzbz().d());
    }

    protected boolean zzb(AdRequestParcel adrequestparcel)
    {
        adrequestparcel = zzos.zzqc.getParent();
        return (adrequestparcel instanceof View) && ((View)adrequestparcel).isShown() && zzp.zzbx().a();
    }

    protected void zzc(te te1)
    {
        if (te1 == null)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Ad state was null when trying to ping impression URLs.");
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Pinging Impression URLs.");
            zzos.zzqi.a();
            if (te1.e != null)
            {
                zzp.zzbx().a(zzos.context, zzos.zzqb.zzIz, zzp.zzbx().a(zzos.context, te1.e, te1.x));
                return;
            }
        }
    }

    public void zzc(AdRequestParcel adrequestparcel)
    {
        if (zzb(adrequestparcel))
        {
            zza(adrequestparcel);
            return;
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaD("Ad is not visible. Not refreshing ad.");
            zzor.zzf(adrequestparcel);
            return;
        }
    }

    protected boolean zze(int i)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaE((new StringBuilder()).append("Failed to load ad: ").append(i).toString());
        zzoq = false;
        if (zzos.zzqk == null)
        {
            return false;
        }
        try
        {
            zzos.zzqk.onAdFailedToLoad(i);
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
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Invalid index for Url fetch time in CSI latency info.");
_L2:
        return -1L;
        s;
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Cannot find valid format of Url fetch time in CSI latency info.");
        if (true) goto _L2; else goto _L1
_L1:
    }
}
