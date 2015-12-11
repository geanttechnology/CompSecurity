// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzc, zzq, zzp, zzd, 
//            zze

public class zzf extends zzc
{

    private boolean zzoN;

    public zzf(Context context, AdSizeParcel adsizeparcel, String s, zzem zzem, VersionInfoParcel versioninfoparcel, zzd zzd)
    {
        super(context, adsizeparcel, s, zzem, versioninfoparcel, zzd);
    }

    private AdSizeParcel zzb(com.google.android.gms.internal.zzhs.zza zza1)
    {
        if (zza1.zzHD.zzti)
        {
            return zzot.zzqn;
        }
        zza1 = zza1.zzHD.zzEN;
        if (zza1 != null)
        {
            zza1 = zza1.split("[xX]");
            zza1[0] = zza1[0].trim();
            zza1[1] = zza1[1].trim();
            zza1 = new AdSize(Integer.parseInt(zza1[0]), Integer.parseInt(zza1[1]));
        } else
        {
            zza1 = zzot.zzqn.zzcD();
        }
        return new AdSizeParcel(zzot.context, zza1);
    }

    private boolean zzb(zzhs zzhs1, zzhs zzhs2)
    {
        if (!zzhs2.zzEK)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        View view;
        try
        {
            zzhs2 = zzhs2.zzzv.getView();
        }
        // Misplaced declaration of an exception variable
        catch (zzhs zzhs1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get View from mediation adapter.", zzhs1);
            return false;
        }
        if (zzhs2 != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("View in mediation adapter is null.");
        return false;
        zzhs2 = (View)com.google.android.gms.dynamic.zze.zzp(zzhs2);
        view = zzot.zzqk.getNextView();
        if (view != null)
        {
            if (view instanceof zziz)
            {
                ((zziz)view).destroy();
            }
            zzot.zzqk.removeView(view);
        }
        try
        {
            zzb(((View) (zzhs2)));
        }
        // Misplaced declaration of an exception variable
        catch (zzhs zzhs1)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not add mediation view to view hierarchy.", zzhs1);
            return false;
        }
_L1:
        if (zzot.zzqk.getChildCount() > 1)
        {
            zzot.zzqk.showNext();
        }
        if (zzhs1 != null)
        {
            zzhs1 = zzot.zzqk.getNextView();
            if (zzhs1 instanceof zziz)
            {
                ((zziz)zzhs1).zza(zzot.context, zzot.zzqn, zzoo);
            } else
            if (zzhs1 != null)
            {
                zzot.zzqk.removeView(zzhs1);
            }
            zzot.zzbM();
        }
        zzot.zzqk.setVisibility(0);
        return true;
        if (zzhs2.zzHy != null && zzhs2.zzBD != null)
        {
            zzhs2.zzBD.zza(zzhs2.zzHy);
            zzot.zzqk.removeAllViews();
            zzot.zzqk.setMinimumWidth(zzhs2.zzHy.widthPixels);
            zzot.zzqk.setMinimumHeight(zzhs2.zzHy.heightPixels);
            zzb(zzhs2.zzBD.getView());
        }
          goto _L1
    }

    public void setManualImpressionsEnabled(boolean flag)
    {
        zzx.zzci("setManualImpressionsEnabled must be called from the main thread.");
        zzoN = flag;
    }

    public void showInterstitial()
    {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    protected zziz zza(com.google.android.gms.internal.zzhs.zza zza1, com.google.android.gms.ads.internal.zze zze1)
    {
        if (zzot.zzqn.zzti)
        {
            zzot.zzqn = zzb(zza1);
        }
        return super.zza(zza1, zze1);
    }

    public boolean zza(zzhs zzhs1, zzhs zzhs2)
    {
        if (!super.zza(zzhs1, zzhs2))
        {
            return false;
        }
        if (zzot.zzbN() && !zzb(zzhs1, zzhs2))
        {
            zze(0);
            return false;
        }
        zza(zzhs2, false);
        if (!zzot.zzbN()) goto _L2; else goto _L1
_L1:
        if (zzhs2.zzBD != null)
        {
            if (zzhs2.zzHw != null)
            {
                zzov.zza(zzot.zzqn, zzhs2);
            }
            if (zzhs2.zzbY())
            {
                zzov.zza(zzot.zzqn, zzhs2).zza(zzhs2.zzBD);
            } else
            {
                zzhs2.zzBD.zzhe().zza(new _cls1(zzhs2));
            }
        }
_L4:
        return true;
_L2:
        if (zzot.zzqG != null && zzhs2.zzHw != null)
        {
            zzov.zza(zzot.zzqn, zzhs2, zzot.zzqG);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean zzaU()
    {
        boolean flag = true;
        if (!zzp.zzbv().zza(zzot.context.getPackageManager(), zzot.context.getPackageName(), "android.permission.INTERNET"))
        {
            zzl.zzcF().zza(zzot.zzqk, zzot.zzqn, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            flag = false;
        }
        if (!zzp.zzbv().zzH(zzot.context))
        {
            zzl.zzcF().zza(zzot.zzqk, zzot.zzqn, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            flag = false;
        }
        if (!flag && zzot.zzqk != null)
        {
            zzot.zzqk.setVisibility(0);
        }
        return flag;
    }

    public boolean zzb(AdRequestParcel adrequestparcel)
    {
        return super.zzb(zze(adrequestparcel));
    }

    AdRequestParcel zze(AdRequestParcel adrequestparcel)
    {
        if (adrequestparcel.zzsG == zzoN)
        {
            return adrequestparcel;
        }
        int i = adrequestparcel.versionCode;
        long l = adrequestparcel.zzsB;
        android.os.Bundle bundle = adrequestparcel.extras;
        int j = adrequestparcel.zzsC;
        java.util.List list = adrequestparcel.zzsD;
        boolean flag1 = adrequestparcel.zzsE;
        int k = adrequestparcel.zzsF;
        boolean flag;
        if (adrequestparcel.zzsG || zzoN)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new AdRequestParcel(i, l, bundle, j, list, flag1, k, flag, adrequestparcel.zzsH, adrequestparcel.zzsI, adrequestparcel.zzsJ, adrequestparcel.zzsK, adrequestparcel.zzsL, adrequestparcel.zzsM, adrequestparcel.zzsN, adrequestparcel.zzsO, adrequestparcel.zzsP);
    }

    private class _cls1
        implements com.google.android.gms.internal.zzja.zzb
    {

        final zzhs zzoO;
        final zzf zzoP;

        public void zzbf()
        {
            zzoP.zzov.zza(zzoP.zzot.zzqn, zzoO).zza(zzoO.zzBD);
        }

        _cls1(zzhs zzhs1)
        {
            zzoP = zzf.this;
            zzoO = zzhs1;
            super();
        }
    }

}
