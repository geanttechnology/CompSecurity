// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v7.ll;
import android.support.v7.mm;
import android.support.v7.mn;
import android.support.v7.pz;
import android.support.v7.qa;
import android.support.v7.te;
import android.support.v7.tp;
import android.support.v7.ul;
import android.support.v7.um;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzc, zzq, zzp

public class zzf extends zzc
{

    private boolean zzoM;

    public zzf(Context context, AdSizeParcel adsizeparcel, String s, pz pz, VersionInfoParcel versioninfoparcel)
    {
        super(context, adsizeparcel, s, pz, versioninfoparcel, null);
    }

    private boolean zzb(te te1, te te2)
    {
        if (!te2.k)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        View view;
        try
        {
            te2 = te2.m.a();
        }
        // Misplaced declaration of an exception variable
        catch (te te1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get View from mediation adapter.", te1);
            return false;
        }
        if (te2 != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("View in mediation adapter is null.");
        return false;
        te2 = (View)ll.a(te2);
        view = zzos.zzqc.getNextView();
        if (view != null)
        {
            if (view instanceof ul)
            {
                ((ul)view).destroy();
            }
            zzos.zzqc.removeView(view);
        }
        try
        {
            zzb(((View) (te2)));
        }
        // Misplaced declaration of an exception variable
        catch (te te1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not add mediation view to view hierarchy.", te1);
            return false;
        }
_L1:
        if (zzos.zzqc.getChildCount() > 1)
        {
            zzos.zzqc.showNext();
        }
        if (te1 != null)
        {
            te1 = zzos.zzqc.getNextView();
            if (te1 instanceof ul)
            {
                ((ul)te1).a(zzos.context, zzos.zzqf);
            } else
            if (te1 != null)
            {
                zzos.zzqc.removeView(te1);
            }
            zzos.zzbO();
        }
        zzos.zzqc.setVisibility(0);
        return true;
        if (te2.r != null && te2.b != null)
        {
            te2.b.a(te2.r);
            zzos.zzqc.removeAllViews();
            zzos.zzqc.setMinimumWidth(te2.r.widthPixels);
            zzos.zzqc.setMinimumHeight(te2.r.heightPixels);
            zzb(((View) (te2.b.getWebView())));
        }
          goto _L1
    }

    public void setManualImpressionsEnabled(boolean flag)
    {
        x.b("setManualImpressionsEnabled must be called from the main thread.");
        zzoM = flag;
    }

    public void showInterstitial()
    {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public boolean zza(te te1, te te2)
    {
        if (!super.zza(te1, te2))
        {
            return false;
        }
        if (zzos.zzbP() && !zzb(te1, te2))
        {
            zze(0);
            return false;
        }
        zza(te2, false);
        if (!zzos.zzbP()) goto _L2; else goto _L1
_L1:
        if (te2.b != null)
        {
            if (te2.j != null)
            {
                zzou.a(zzos.zzqf, te2);
            }
            if (te2.a())
            {
                zzou.a(zzos.zzqf, te2).a(te2.b);
            } else
            {
                te2.b.i().a(new android.support.v7.um.b(te2) {

                    final te zzoN;
                    final zzf zzoO;

                    public void zzbf()
                    {
                        zzoO.zzou.a(zzoO.zzos.zzqf, zzoN).a(zzoN.b);
                    }

            
            {
                zzoO = zzf.this;
                zzoN = te1;
                super();
            }
                });
            }
        }
_L4:
        return true;
_L2:
        if (zzos.zzqy != null && te2.j != null)
        {
            zzou.a(zzos.zzqf, te2, zzos.zzqy);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean zza(AdRequestParcel adrequestparcel)
    {
        return super.zza(zzd(adrequestparcel));
    }

    protected boolean zzaU()
    {
        boolean flag = true;
        if (!zzp.zzbx().a(zzos.context.getPackageManager(), zzos.context.getPackageName(), "android.permission.INTERNET"))
        {
            zzk.zzcE().zza(zzos.zzqc, zzos.zzqf, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            flag = false;
        }
        if (!zzp.zzbx().a(zzos.context))
        {
            zzk.zzcE().zza(zzos.zzqc, zzos.zzqf, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            flag = false;
        }
        if (!flag && zzos.zzqc != null)
        {
            zzos.zzqc.setVisibility(0);
        }
        return flag;
    }

    AdRequestParcel zzd(AdRequestParcel adrequestparcel)
    {
        if (adrequestparcel.zzsv == zzoM)
        {
            return adrequestparcel;
        }
        int i = adrequestparcel.versionCode;
        long l = adrequestparcel.zzsq;
        android.os.Bundle bundle = adrequestparcel.extras;
        int j = adrequestparcel.zzsr;
        java.util.List list = adrequestparcel.zzss;
        boolean flag1 = adrequestparcel.zzst;
        int k = adrequestparcel.zzsu;
        boolean flag;
        if (adrequestparcel.zzsv || zzoM)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new AdRequestParcel(i, l, bundle, j, list, flag1, k, flag, adrequestparcel.zzsw, adrequestparcel.zzsx, adrequestparcel.zzsy, adrequestparcel.zzsz, adrequestparcel.zzsA, adrequestparcel.zzsB, adrequestparcel.zzsC, adrequestparcel.zzsD, adrequestparcel.zzsE);
    }
}
