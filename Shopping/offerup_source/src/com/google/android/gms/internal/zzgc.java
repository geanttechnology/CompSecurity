// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.internal:
//            zzgh, zzhs, zziz, zzie, 
//            zzid, zzby, zzbu

public abstract class zzgc
    implements zzgh, zzja.zza
{

    protected final Context mContext;
    protected final zzgg.zza zzDd;
    protected final zzhs.zza zzDe;
    protected AdResponseParcel zzDf;
    private Runnable zzDg;
    protected final Object zzDh = new Object();
    private AtomicBoolean zzDi;
    protected final zziz zzoM;

    protected zzgc(Context context, zzhs.zza zza1, zziz zziz1, zzgg.zza zza2)
    {
        zzDi = new AtomicBoolean(true);
        mContext = context;
        zzDe = zza1;
        zzDf = zzDe.zzHD;
        zzoM = zziz1;
        zzDd = zza2;
    }

    private zzhs zzA(int i)
    {
        AdRequestInfoParcel adrequestinfoparcel = zzDe.zzHC;
        return new zzhs(adrequestinfoparcel.zzEn, zzoM, zzDf.zzyY, i, zzDf.zzyZ, zzDf.zzEM, zzDf.orientation, zzDf.zzzc, adrequestinfoparcel.zzEq, zzDf.zzEK, null, null, null, null, null, zzDf.zzEL, zzDe.zzqn, zzDf.zzEJ, zzDe.zzHz, zzDf.zzEO, zzDf.zzEP, zzDe.zzHw, null);
    }

    static AtomicBoolean zza(zzgc zzgc1)
    {
        return zzgc1.zzDi;
    }

    public void cancel()
    {
        if (!zzDi.getAndSet(false))
        {
            return;
        } else
        {
            zzoM.stopLoading();
            zzp.zzbx().zza(zzoM.getWebView());
            zzz(-1);
            zzid.zzIE.removeCallbacks(zzDg);
            return;
        }
    }

    public void zza(zziz zziz1, boolean flag)
    {
        zzb.zzaF("WebView finished loading.");
        if (!zzDi.getAndSet(false))
        {
            return;
        }
        int i;
        if (flag)
        {
            i = zzft();
        } else
        {
            i = -1;
        }
        zzz(i);
        zzid.zzIE.removeCallbacks(zzDg);
    }

    public final Void zzfr()
    {
        zzx.zzci("Webview render task needs to be called on UI thread.");
        zzDg = new _cls1();
        zzid.zzIE.postDelayed(zzDg, ((Long)zzby.zzvw.get()).longValue());
        zzfs();
        return null;
    }

    protected abstract void zzfs();

    protected int zzft()
    {
        return -2;
    }

    public Object zzfu()
    {
        return zzfr();
    }

    protected void zzz(int i)
    {
        if (i != -2)
        {
            zzDf = new AdResponseParcel(i, zzDf.zzzc);
        }
        zzDd.zzb(zzA(i));
    }

    private class _cls1
        implements Runnable
    {

        final zzgc zzDj;

        public void run()
        {
            if (!zzgc.zza(zzDj).get())
            {
                return;
            } else
            {
                zzb.e("Timed out waiting for WebView to finish loading.");
                zzDj.cancel();
                return;
            }
        }

        _cls1()
        {
            zzDj = zzgc.this;
            super();
        }
    }

}
