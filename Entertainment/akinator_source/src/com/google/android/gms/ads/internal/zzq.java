// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzmi;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzp, zzh

public final class zzq
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{

    public final Context context;
    boolean zzpt;
    zzmi zzqA;
    NativeAdOptionsParcel zzqB;
    zzck zzqC;
    List zzqD;
    zzk zzqE;
    public zzhx zzqF;
    View zzqG;
    public int zzqH;
    boolean zzqI;
    private HashSet zzqJ;
    private int zzqK;
    private int zzqL;
    private zzik zzqM;
    private boolean zzqN;
    private boolean zzqO;
    private boolean zzqP;
    final String zzqg;
    public String zzqh;
    final zzan zzqi;
    public final VersionInfoParcel zzqj;
    zza zzqk;
    public zzhz zzql;
    public zzgh zzqm;
    public AdSizeParcel zzqn;
    public zzhs zzqo;
    public com.google.android.gms.internal.zzhs.zza zzqp;
    public zzht zzqq;
    zzn zzqr;
    zzo zzqs;
    zzu zzqt;
    zzv zzqu;
    zzfs zzqv;
    zzfw zzqw;
    zzcw zzqx;
    zzcx zzqy;
    zzmi zzqz;

    public zzq(Context context1, AdSizeParcel adsizeparcel, String s, VersionInfoParcel versioninfoparcel)
    {
        this(context1, adsizeparcel, s, versioninfoparcel, null);
    }

    zzq(Context context1, AdSizeParcel adsizeparcel, String s, VersionInfoParcel versioninfoparcel, zzan zzan1)
    {
        zzqF = null;
        zzqG = null;
        zzqH = 0;
        zzqI = false;
        zzpt = false;
        zzqJ = null;
        zzqK = -1;
        zzqL = -1;
        zzqN = true;
        zzqO = true;
        zzqP = false;
        zzby.initialize(context1);
        if (com.google.android.gms.ads.internal.zzp.zzby().zzgo() != null)
        {
            List list = zzby.zzdf();
            if (versioninfoparcel.zzJv != 0)
            {
                list.add(Integer.toString(versioninfoparcel.zzJv));
            }
            com.google.android.gms.ads.internal.zzp.zzby().zzgo().zzb(list);
        }
        zzqg = UUID.randomUUID().toString();
        if (adsizeparcel.zztf || adsizeparcel.zzth)
        {
            zzqk = null;
        } else
        {
    /* block-local class not found */
    class zza {}

            zzqk = new zza(context1, this, this);
            zzqk.setMinimumWidth(adsizeparcel.widthPixels);
            zzqk.setMinimumHeight(adsizeparcel.heightPixels);
            zzqk.setVisibility(4);
        }
        zzqn = adsizeparcel;
        zzqh = s;
        context = context1;
        zzqj = versioninfoparcel;
        if (zzan1 == null)
        {
            zzan1 = new zzan(new zzh(this));
        }
        zzqi = zzan1;
        zzqM = new zzik(200L);
        zzqA = new zzmi();
    }

    private void zzbQ()
    {
        View view = zzqk.getRootView().findViewById(0x1020002);
        if (view != null)
        {
            Rect rect = new Rect();
            Rect rect1 = new Rect();
            zzqk.getGlobalVisibleRect(rect);
            view.getGlobalVisibleRect(rect1);
            if (rect.top != rect1.top)
            {
                zzqN = false;
            }
            if (rect.bottom != rect1.bottom)
            {
                zzqO = false;
                return;
            }
        }
    }

    private void zze(boolean flag)
    {
        boolean flag1;
        for (flag1 = true; zzqk == null || zzqo == null || zzqo.zzBD == null || flag && !zzqM.tryAcquire();)
        {
            return;
        }

        if (zzqo.zzBD.zzhe().zzbY())
        {
            int ai[] = new int[2];
            zzqk.getLocationOnScreen(ai);
            int i = zzl.zzcF().zzc(context, ai[0]);
            int j = zzl.zzcF().zzc(context, ai[1]);
            if (i != zzqK || j != zzqL)
            {
                zzqK = i;
                zzqL = j;
                zzja zzja1 = zzqo.zzBD.zzhe();
                i = zzqK;
                j = zzqL;
                if (!flag)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                zzja1.zza(i, j, flag);
            }
        }
        zzbQ();
    }

    public void destroy()
    {
        zzbP();
        zzqs = null;
        zzqt = null;
        zzqw = null;
        zzqv = null;
        zzqC = null;
        zzqu = null;
        zzf(false);
        if (zzqk != null)
        {
            zzqk.removeAllViews();
        }
        zzbK();
        zzbM();
        zzqo = null;
    }

    public void onGlobalLayout()
    {
        zze(false);
    }

    public void onScrollChanged()
    {
        zze(true);
        zzqP = true;
    }

    public void zza(HashSet hashset)
    {
        zzqJ = hashset;
    }

    public HashSet zzbJ()
    {
        return zzqJ;
    }

    public void zzbK()
    {
        if (zzqo != null && zzqo.zzBD != null)
        {
            zzqo.zzBD.destroy();
        }
    }

    public void zzbL()
    {
        if (zzqo != null && zzqo.zzBD != null)
        {
            zzqo.zzBD.stopLoading();
        }
    }

    public void zzbM()
    {
        if (zzqo == null || zzqo.zzzv == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        zzqo.zzzv.destroy();
        return;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzaH("Could not destroy mediation adapter.");
        return;
    }

    public boolean zzbN()
    {
        return zzqH == 0;
    }

    public boolean zzbO()
    {
        return zzqH == 1;
    }

    public void zzbP()
    {
        if (zzqk != null)
        {
            zzqk.zzbP();
        }
    }

    public String zzbR()
    {
        if (zzqN && zzqO)
        {
            return "";
        }
        if (zzqN)
        {
            if (zzqP)
            {
                return "top-scrollable";
            } else
            {
                return "top-locked";
            }
        }
        if (zzqO)
        {
            if (zzqP)
            {
                return "bottom-scrollable";
            } else
            {
                return "bottom-locked";
            }
        } else
        {
            return "";
        }
    }

    public void zzbS()
    {
        zzqq.zzl(zzqo.zzHz);
        zzqq.zzm(zzqo.zzHA);
        zzqq.zzy(zzqn.zztf);
        zzqq.zzz(zzqo.zzEK);
    }

    public void zzf(boolean flag)
    {
        if (zzqH == 0)
        {
            zzbL();
        }
        if (zzql != null)
        {
            zzql.cancel();
        }
        if (zzqm != null)
        {
            zzqm.cancel();
        }
        if (flag)
        {
            zzqo = null;
        }
    }
}
