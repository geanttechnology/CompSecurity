// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzfh, zzdk, zziz, zzbq, 
//            zzid, zzja, zzff

public class zzfg extends zzfh
    implements zzdk
{

    private final Context mContext;
    private final zzbq zzAA;
    DisplayMetrics zzAB;
    private float zzAC;
    int zzAD;
    int zzAE;
    private int zzAF;
    int zzAG;
    int zzAH;
    int zzAI;
    int zzAJ;
    private final zziz zzoM;
    private final WindowManager zzri;

    public zzfg(zziz zziz1, Context context, zzbq zzbq1)
    {
        super(zziz1);
        zzAD = -1;
        zzAE = -1;
        zzAG = -1;
        zzAH = -1;
        zzAI = -1;
        zzAJ = -1;
        zzoM = zziz1;
        mContext = context;
        zzAA = zzbq1;
        zzri = (WindowManager)context.getSystemService("window");
    }

    private void zzei()
    {
        zzAB = new DisplayMetrics();
        Display display = zzri.getDefaultDisplay();
        display.getMetrics(zzAB);
        zzAC = zzAB.density;
        zzAF = display.getRotation();
    }

    private void zzen()
    {
        int ai[] = new int[2];
        zzoM.getLocationOnScreen(ai);
        zze(zzl.zzcF().zzc(mContext, ai[0]), zzl.zzcF().zzc(mContext, ai[1]));
    }

    private zzff zzeq()
    {
        return (new zzff.zza()).zzp(zzAA.zzcW()).zzo(zzAA.zzcX()).zzq(zzAA.zzdb()).zzr(zzAA.zzcY()).zzs(zzAA.zzcZ()).zzeh();
    }

    public void zza(zziz zziz1, Map map)
    {
        zzel();
    }

    public void zze(int i, int j)
    {
        int k;
        if (mContext instanceof Activity)
        {
            k = zzp.zzbv().zzj((Activity)mContext)[0];
        } else
        {
            k = 0;
        }
        zzc(i, j - k, zzAI, zzAJ);
        zzoM.zzhe().zzd(i, j);
    }

    void zzej()
    {
        zzAD = zzl.zzcF().zzb(zzAB, zzAB.widthPixels);
        zzAE = zzl.zzcF().zzb(zzAB, zzAB.heightPixels);
        Activity activity = zzoM.zzgZ();
        if (activity == null || activity.getWindow() == null)
        {
            zzAG = zzAD;
            zzAH = zzAE;
            return;
        } else
        {
            int ai[] = zzp.zzbv().zzg(activity);
            zzAG = zzl.zzcF().zzb(zzAB, ai[0]);
            zzAH = zzl.zzcF().zzb(zzAB, ai[1]);
            return;
        }
    }

    void zzek()
    {
        if (zzoM.zzaN().zztf)
        {
            zzAI = zzAD;
            zzAJ = zzAE;
            return;
        } else
        {
            zzoM.measure(0, 0);
            zzAI = zzl.zzcF().zzc(mContext, zzoM.getMeasuredWidth());
            zzAJ = zzl.zzcF().zzc(mContext, zzoM.getMeasuredHeight());
            return;
        }
    }

    public void zzel()
    {
        zzei();
        zzej();
        zzek();
        zzeo();
        zzep();
        zzen();
        zzem();
    }

    void zzem()
    {
        if (zzb.zzN(2))
        {
            zzb.zzaG("Dispatching Ready Event.");
        }
        zzal(zzoM.zzhh().zzJu);
    }

    void zzeo()
    {
        zza(zzAD, zzAE, zzAG, zzAH, zzAC, zzAF);
    }

    void zzep()
    {
        zzff zzff1 = zzeq();
        zzoM.zzb("onDeviceFeaturesReceived", zzff1.toJson());
    }
}
