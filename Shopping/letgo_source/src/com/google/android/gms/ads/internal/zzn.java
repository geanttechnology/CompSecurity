// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v7.nt;
import android.support.v7.nx;
import android.support.v7.oj;
import android.support.v7.ok;
import android.support.v7.ol;
import android.support.v7.om;
import android.support.v7.pz;
import android.support.v7.qa;
import android.support.v7.qc;
import android.support.v7.qd;
import android.support.v7.rf;
import android.support.v7.ru;
import android.support.v7.te;
import android.support.v7.tp;
import android.support.v7.vk;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.x;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzb, zzq, zzp, zzo

public class zzn extends com.google.android.gms.ads.internal.zzb
{

    public zzn(Context context, AdSizeParcel adsizeparcel, String s, pz pz, VersionInfoParcel versioninfoparcel)
    {
        super(context, adsizeparcel, s, pz, versioninfoparcel, null);
    }

    private static zzd zza(qc qc1)
        throws RemoteException
    {
        String s = qc1.a();
        List list = qc1.b();
        String s1 = qc1.c();
        android.support.v7.nz nz;
        if (qc1.d() != null)
        {
            nz = qc1.d();
        } else
        {
            nz = null;
        }
        return new zzd(s, list, s1, nz, qc1.e(), qc1.f(), qc1.g(), qc1.h(), null, qc1.l());
    }

    private static zze zza(qd qd1)
        throws RemoteException
    {
        String s = qd1.a();
        List list = qd1.b();
        String s1 = qd1.c();
        android.support.v7.nz nz;
        if (qd1.d() != null)
        {
            nz = qd1.d();
        } else
        {
            nz = null;
        }
        return new zze(s, list, s1, nz, qd1.e(), qd1.f(), null, qd1.j());
    }

    private void zza(te te1, String s)
    {
        tp.a.post(new Runnable(s, te1) {

            final zzn zzpt;
            final String zzpw;
            final te zzpx;

            public void run()
            {
                try
                {
                    ((om)zzpt.zzos.zzqs.get(zzpw)).a((zzf)zzpx.w);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", remoteexception);
                }
            }

            
            {
                zzpt = zzn.this;
                zzpw = s;
                zzpx = te1;
                super();
            }
        });
    }

    private void zza(zzd zzd1)
    {
        tp.a.post(new Runnable(zzd1) {

            final zzn zzpt;
            final zzd zzpu;

            public void run()
            {
                try
                {
                    zzpt.zzos.zzqp.a(zzpu);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", remoteexception);
                }
            }

            
            {
                zzpt = zzn.this;
                zzpu = zzd1;
                super();
            }
        });
    }

    private void zza(zze zze1)
    {
        tp.a.post(new Runnable(zze1) {

            final zzn zzpt;
            final zze zzpv;

            public void run()
            {
                try
                {
                    zzpt.zzos.zzqq.a(zzpv);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", remoteexception);
                }
            }

            
            {
                zzpt = zzn.this;
                zzpv = zze1;
                super();
            }
        });
    }

    public void pause()
    {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void recordImpression()
    {
        zza(zzos.zzqg, false);
    }

    public void resume()
    {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial()
    {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(nx nx)
    {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(rf rf)
    {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(android.support.v7.te.a a, nt nt)
    {
        if (a.d != null)
        {
            zzos.zzqf = a.d;
        }
        if (a.e != -2)
        {
            tp.a.post(new Runnable(a) {

                final android.support.v7.te.a zzoA;
                final zzn zzpt;

                public void run()
                {
                    zzpt.zzb(new te(zzoA, null, null, null, null, null, null));
                }

            
            {
                zzpt = zzn.this;
                zzoA = a;
                super();
            }
            });
            return;
        } else
        {
            zzos.zzqz = 0;
            zzos.zzqe = zzp.zzbw().a(zzos.context, this, a, zzos.zzqa, null, zzow, this, nt);
            com.google.android.gms.ads.internal.util.client.zzb.zzaC((new StringBuilder()).append("AdRenderer: ").append(zzos.zzqe.getClass().getName()).toString());
            return;
        }
    }

    public void zza(vk vk1)
    {
        x.b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzos.zzqs = vk1;
    }

    public void zza(List list)
    {
        x.b("setNativeTemplates must be called on the main UI thread.");
        zzos.zzqv = list;
    }

    protected boolean zza(te te1, te te2)
    {
        zza(((List) (null)));
        if (!zzos.zzbP())
        {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (!te2.k) goto _L2; else goto _L1
_L1:
        qc qc1;
        Object obj;
        qc1 = te2.m.h();
        obj = te2.m.i();
        if (qc1 == null) goto _L4; else goto _L3
_L3:
        try
        {
            obj = zza(qc1);
            ((zzd) (obj)).zza(new zzg(zzos.context, this, zzos.zzqa, qc1));
            zza(((zzd) (obj)));
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get native ad mapper", remoteexception);
        }
_L6:
        return super.zza(te1, te2);
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        zze zze1 = zza(((qd) (obj)));
        zze1.zza(new zzg(zzos.context, this, zzos.zzqa, ((qd) (obj))));
        zza(zze1);
        continue; /* Loop/switch isn't completed */
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("No matching mapper for retrieved native ad template.");
        zze(0);
        return false;
_L2:
        com.google.android.gms.ads.internal.formats.zzh.zza zza1 = te2.w;
        if ((zza1 instanceof zze) && zzos.zzqq != null)
        {
            zza((zze)te2.w);
        } else
        if ((zza1 instanceof zzd) && zzos.zzqp != null)
        {
            zza((zzd)te2.w);
        } else
        if ((zza1 instanceof zzf) && zzos.zzqs != null && zzos.zzqs.get(((zzf)zza1).getCustomTemplateId()) != null)
        {
            zza(te2, ((zzf)zza1).getCustomTemplateId());
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("No matching listener for retrieved native ad template.");
            zze(0);
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected boolean zza(AdRequestParcel adrequestparcel, te te1, boolean flag)
    {
        return zzor.zzbr();
    }

    public void zzb(oj oj)
    {
        x.b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzos.zzqp = oj;
    }

    public void zzb(ok ok)
    {
        x.b("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzos.zzqq = ok;
    }

    public void zzb(vk vk1)
    {
        x.b("setOnCustomClickListener must be called on the main UI thread.");
        zzos.zzqr = vk1;
    }

    public void zzb(NativeAdOptionsParcel nativeadoptionsparcel)
    {
        x.b("setNativeAdOptions must be called on the main UI thread.");
        zzos.zzqt = nativeadoptionsparcel;
    }

    public vk zzbq()
    {
        x.b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return zzos.zzqs;
    }

    public ol zzr(String s)
    {
        x.b("getOnCustomClickListener must be called on the main UI thread.");
        return (ol)zzos.zzqr.get(s);
    }
}
