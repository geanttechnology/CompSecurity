// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v7.nt;
import android.support.v7.nu;
import android.support.v7.nx;
import android.support.v7.pz;
import android.support.v7.qv;
import android.support.v7.ru;
import android.support.v7.te;
import android.support.v7.tp;
import android.support.v7.tr;
import android.support.v7.ul;
import android.support.v7.um;
import android.support.v7.un;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzb, zzg, zzq, zzp, 
//            zzd, zze

public abstract class zzc extends com.google.android.gms.ads.internal.zzb
    implements qv, zzg
{

    public zzc(Context context, AdSizeParcel adsizeparcel, String s, pz pz, VersionInfoParcel versioninfoparcel, zzd zzd)
    {
        super(context, adsizeparcel, s, pz, versioninfoparcel, zzd);
    }

    public void recordClick()
    {
        onAdClicked();
    }

    public void recordImpression()
    {
        zza(zzos.zzqg, false);
    }

    protected ul zza(android.support.v7.te.a a, zze zze)
    {
        Object obj = zzos.zzqc.getNextView();
        if (!(obj instanceof ul)) goto _L2; else goto _L1
_L1:
        zzb.zzaC("Reusing webview...");
        obj = (ul)obj;
        ((ul) (obj)).a(zzos.context, zzos.zzqf);
_L4:
        ((ul) (obj)).i().a(this, this, this, this, false, this, null, zze, this);
        ((ul) (obj)).b(a.a.zzDQ);
        ((ul) (obj)).c(a.a.zzDO);
        return ((ul) (obj));
_L2:
        if (obj != null)
        {
            zzos.zzqc.removeView(((View) (obj)));
        }
        obj = zzp.zzby().a(zzos.context, zzos.zzqf, false, false, zzos.zzqa, zzos.zzqb, zzov);
        if (zzos.zzqf.zzsI == null)
        {
            zzb(((ul) (obj)).getWebView());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void zza(int i, int j, int k, int l)
    {
        zzaS();
    }

    public void zza(nx nx)
    {
        x.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        zzos.zzqu = nx;
    }

    protected void zza(android.support.v7.te.a a, nt nt)
    {
        if (a.e != -2)
        {
            tp.a.post(new Runnable(a) {

                final android.support.v7.te.a zzoA;
                final zzc zzoB;

                public void run()
                {
                    zzoB.zzb(new te(zzoA, null, null, null, null, null, null));
                }

            
            {
                zzoB = zzc.this;
                zzoA = a;
                super();
            }
            });
            return;
        }
        if (a.d != null)
        {
            zzos.zzqf = a.d;
        }
        if (a.b.zzDX)
        {
            zzos.zzqz = 0;
            zzos.zzqe = zzp.zzbw().a(zzos.context, this, a, zzos.zzqa, null, zzow, this, nt);
            return;
        } else
        {
            tp.a.post(new Runnable(a, nt) {

                final android.support.v7.te.a zzoA;
                final zzc zzoB;
                final nt zzoC;

                public void run()
                {
                    if (zzoA.b.zzEg && zzoB.zzos.zzqu != null)
                    {
                        Object obj = null;
                        if (zzoA.b.zzAT != null)
                        {
                            obj = zzp.zzbx().a(zzoA.b.zzAT);
                        }
                        obj = new nu(zzoB, ((String) (obj)), zzoA.b.body);
                        zzoB.zzos.zzqz = 1;
                        try
                        {
                            zzoB.zzos.zzqu.a(((android.support.v7.nw) (obj)));
                            return;
                        }
                        catch (RemoteException remoteexception)
                        {
                            zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", remoteexception);
                        }
                    }
                    zze zze1 = new zze();
                    ul ul1 = zzoB.zza(zzoA, zze1);
                    zze1.zza(new zze.zzb(zzoA, ul1));
                    ul1.setOnTouchListener(new android.view.View.OnTouchListener(this, zze1) {

                        final zze zzoD;
                        final _cls2 zzoE;

                        public boolean onTouch(View view, MotionEvent motionevent)
                        {
                            zzoD.recordClick();
                            return false;
                        }

            
            {
                zzoE = _pcls2;
                zzoD = zze1;
                super();
            }
                    });
                    ul1.setOnClickListener(new android.view.View.OnClickListener(this, zze1) {

                        final zze zzoD;
                        final _cls2 zzoE;

                        public void onClick(View view)
                        {
                            zzoD.recordClick();
                        }

            
            {
                zzoE = _pcls2;
                zzoD = zze1;
                super();
            }
                    });
                    zzoB.zzos.zzqz = 0;
                    zzoB.zzos.zzqe = zzp.zzbw().a(zzoB.zzos.context, zzoB, zzoA, zzoB.zzos.zzqa, ul1, zzoB.zzow, zzoB, zzoC);
                }

            
            {
                zzoB = zzc.this;
                zzoA = a;
                zzoC = nt;
                super();
            }
            });
            return;
        }
    }

    protected boolean zza(te te1, te te2)
    {
        if (zzos.zzbP() && zzos.zzqc != null)
        {
            zzos.zzqc.zzbT().a(te2.v);
        }
        return super.zza(te1, te2);
    }

    public void zzbc()
    {
        zzaQ();
    }

    public void zzc(View view)
    {
        zzos.zzqy = view;
        zzb(new te(zzos.zzqh, null, null, null, null, null, null));
    }
}
