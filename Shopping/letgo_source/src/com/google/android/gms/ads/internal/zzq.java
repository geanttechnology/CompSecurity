// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.v7.mc;
import android.support.v7.nn;
import android.support.v7.nq;
import android.support.v7.nx;
import android.support.v7.oj;
import android.support.v7.ok;
import android.support.v7.qa;
import android.support.v7.rf;
import android.support.v7.rj;
import android.support.v7.te;
import android.support.v7.tf;
import android.support.v7.tg;
import android.support.v7.tj;
import android.support.v7.tl;
import android.support.v7.tr;
import android.support.v7.tx;
import android.support.v7.tz;
import android.support.v7.ul;
import android.support.v7.um;
import android.support.v7.vk;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.ads.internal:
//            zzp, zzh

public final class zzq
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{
    public static final class zza extends ViewSwitcher
    {

        private final tr zzqF;
        private final tz zzqG;

        protected void onAttachedToWindow()
        {
            super.onAttachedToWindow();
            if (zzqG != null)
            {
                zzqG.c();
            }
        }

        protected void onDetachedFromWindow()
        {
            super.onDetachedFromWindow();
            if (zzqG != null)
            {
                zzqG.d();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            zzqF.a(motionevent);
            return false;
        }

        public void removeAllViews()
        {
            Object obj = new ArrayList();
            for (int i = 0; i < getChildCount(); i++)
            {
                View view = getChildAt(i);
                if (view != null && (view instanceof ul))
                {
                    ((List) (obj)).add((ul)view);
                }
            }

            super.removeAllViews();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((ul)((Iterator) (obj)).next()).destroy()) { }
        }

        public void zzbR()
        {
            zzb.v("Disable position monitoring on adFrame.");
            if (zzqG != null)
            {
                zzqG.b();
            }
        }

        public tr zzbT()
        {
            return zzqF;
        }

        public zza(Context context1, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
        {
            super(context1);
            zzqF = new tr(context1);
            if (context1 instanceof Activity)
            {
                zzqG = new tz((Activity)context1, ongloballayoutlistener, onscrollchangedlistener);
                zzqG.a();
                return;
            } else
            {
                zzqG = null;
                return;
            }
        }
    }


    public final Context context;
    final String zzpY;
    public String zzpZ;
    boolean zzpk;
    boolean zzqA;
    private HashSet zzqB;
    private int zzqC;
    private int zzqD;
    private tx zzqE;
    final mc zzqa;
    public final VersionInfoParcel zzqb;
    zza zzqc;
    public tl zzqd;
    public tl zzqe;
    public AdSizeParcel zzqf;
    public te zzqg;
    public android.support.v7.te.a zzqh;
    public tf zzqi;
    zzm zzqj;
    zzn zzqk;
    zzt zzql;
    zzu zzqm;
    rf zzqn;
    rj zzqo;
    oj zzqp;
    ok zzqq;
    vk zzqr;
    vk zzqs;
    NativeAdOptionsParcel zzqt;
    nx zzqu;
    List zzqv;
    com.google.android.gms.ads.internal.purchase.zzk zzqw;
    public tj zzqx;
    View zzqy;
    public int zzqz;

    public zzq(Context context1, AdSizeParcel adsizeparcel, String s, VersionInfoParcel versioninfoparcel)
    {
        this(context1, adsizeparcel, s, versioninfoparcel, null);
    }

    zzq(Context context1, AdSizeParcel adsizeparcel, String s, VersionInfoParcel versioninfoparcel, mc mc1)
    {
        zzqx = null;
        zzqy = null;
        zzqz = 0;
        zzqA = false;
        zzpk = false;
        zzqB = null;
        zzqC = -1;
        zzqD = -1;
        nn.a(context1);
        if (zzp.zzbA().e() != null)
        {
            List list = nn.a();
            if (versioninfoparcel.zzIA != 0)
            {
                list.add(Integer.toString(versioninfoparcel.zzIA));
            }
            zzp.zzbA().e().a(list);
        }
        zzpY = UUID.randomUUID().toString();
        if (adsizeparcel.zzsH || adsizeparcel.zzsJ)
        {
            zzqc = null;
        } else
        {
            zzqc = new zza(context1, this, this);
            zzqc.setMinimumWidth(adsizeparcel.widthPixels);
            zzqc.setMinimumHeight(adsizeparcel.heightPixels);
            zzqc.setVisibility(4);
        }
        zzqf = adsizeparcel;
        zzpZ = s;
        context = context1;
        zzqb = versioninfoparcel;
        if (mc1 == null)
        {
            mc1 = new mc(new zzh(this));
        }
        zzqa = mc1;
        zzqE = new tx(200L);
        zzqs = new vk();
    }

    private void zze(boolean flag)
    {
        boolean flag1;
        flag1 = true;
        break MISSING_BLOCK_LABEL_3;
        if (zzqc != null && zzqg != null && zzqg.b != null && zzqg.b.i().b() && (!flag || zzqE.a()))
        {
            int ai[] = new int[2];
            zzqc.getLocationOnScreen(ai);
            int i = zzk.zzcE().zzc(context, ai[0]);
            int j = zzk.zzcE().zzc(context, ai[1]);
            if (i != zzqC || j != zzqD)
            {
                zzqC = i;
                zzqD = j;
                um um1 = zzqg.b.i();
                i = zzqC;
                j = zzqD;
                if (!flag)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                um1.a(i, j, flag);
                return;
            }
        }
        return;
    }

    public void destroy()
    {
        zzbR();
        zzqk = null;
        zzql = null;
        zzqo = null;
        zzqn = null;
        zzqu = null;
        zzqm = null;
        zzf(false);
        if (zzqc != null)
        {
            zzqc.removeAllViews();
        }
        zzbM();
        zzbO();
        zzqg = null;
    }

    public void onGlobalLayout()
    {
        zze(false);
    }

    public void onScrollChanged()
    {
        zze(true);
    }

    public void zza(HashSet hashset)
    {
        zzqB = hashset;
    }

    public HashSet zzbL()
    {
        return zzqB;
    }

    public void zzbM()
    {
        if (zzqg != null && zzqg.b != null)
        {
            zzqg.b.destroy();
        }
    }

    public void zzbN()
    {
        if (zzqg != null && zzqg.b != null)
        {
            zzqg.b.stopLoading();
        }
    }

    public void zzbO()
    {
        if (zzqg == null || zzqg.m == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        zzqg.m.c();
        return;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzaE("Could not destroy mediation adapter.");
        return;
    }

    public boolean zzbP()
    {
        return zzqz == 0;
    }

    public boolean zzbQ()
    {
        return zzqz == 1;
    }

    public void zzbR()
    {
        if (zzqc != null)
        {
            zzqc.zzbR();
        }
    }

    public void zzbS()
    {
        zzqi.a(zzqg.t);
        zzqi.b(zzqg.u);
        zzqi.a(zzqf.zzsH);
        zzqi.b(zzqg.k);
    }

    public void zzf(boolean flag)
    {
        if (zzqz == 0)
        {
            zzbN();
        }
        if (zzqd != null)
        {
            zzqd.cancel();
        }
        if (zzqe != null)
        {
            zzqe.cancel();
        }
        if (flag)
        {
            zzqg = null;
        }
    }
}
