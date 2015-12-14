// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zzji, zzid

public class zzgd
    implements Runnable
{

    private final Handler zzDk;
    private final long zzDl;
    private long zzDm;
    private zzja.zza zzDn;
    protected boolean zzDo;
    protected boolean zzDp;
    private final int zznQ;
    private final int zznR;
    protected final zziz zzoM;

    public zzgd(zzja.zza zza1, zziz zziz1, int i, int j)
    {
        this(zza1, zziz1, i, j, 200L, 50L);
    }

    public zzgd(zzja.zza zza1, zziz zziz1, int i, int j, long l, long l1)
    {
        zzDl = l;
        zzDm = l1;
        zzDk = new Handler(Looper.getMainLooper());
        zzoM = zziz1;
        zzDn = zza1;
        zzDo = false;
        zzDp = false;
        zznR = j;
        zznQ = i;
    }

    static int zza(zzgd zzgd1)
    {
        return zzgd1.zznQ;
    }

    static int zzb(zzgd zzgd1)
    {
        return zzgd1.zznR;
    }

    static long zzc(zzgd zzgd1)
    {
        long l = zzgd1.zzDm - 1L;
        zzgd1.zzDm = l;
        return l;
    }

    static long zzd(zzgd zzgd1)
    {
        return zzgd1.zzDm;
    }

    static zzja.zza zze(zzgd zzgd1)
    {
        return zzgd1.zzDn;
    }

    static long zzf(zzgd zzgd1)
    {
        return zzgd1.zzDl;
    }

    static Handler zzg(zzgd zzgd1)
    {
        return zzgd1.zzDk;
    }

    public void run()
    {
        if (zzoM == null || zzfx())
        {
            zzDn.zza(zzoM, true);
            return;
        } else
        {
            (new zza(zzoM.getWebView())).execute(new Void[0]);
            return;
        }
    }

    public void zza(AdResponseParcel adresponseparcel)
    {
        zza(adresponseparcel, new zzji(this, zzoM, adresponseparcel.zzER));
    }

    public void zza(AdResponseParcel adresponseparcel, zzji zzji1)
    {
        zzoM.setWebViewClient(zzji1);
        zziz zziz1 = zzoM;
        if (TextUtils.isEmpty(adresponseparcel.zzBF))
        {
            zzji1 = null;
        } else
        {
            zzji1 = zzp.zzbv().zzaz(adresponseparcel.zzBF);
        }
        zziz1.loadDataWithBaseURL(zzji1, adresponseparcel.body, "text/html", "UTF-8", null);
    }

    public void zzfv()
    {
        zzDk.postDelayed(this, zzDl);
    }

    public void zzfw()
    {
        this;
        JVM INSTR monitorenter ;
        zzDo = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean zzfx()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzDo;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean zzfy()
    {
        return zzDp;
    }

    private class zza extends AsyncTask
    {

        private final WebView zzDq;
        private Bitmap zzDr;
        final zzgd zzDs;

        protected final Object doInBackground(Object aobj[])
        {
            return zza((Void[])aobj);
        }

        protected final void onPostExecute(Object obj)
        {
            zza((Boolean)obj);
        }

        protected final void onPreExecute()
        {
            this;
            JVM INSTR monitorenter ;
            zzDr = Bitmap.createBitmap(zzgd.zza(zzDs), com.google.android.gms.internal.zzgd.zzb(zzDs), android.graphics.Bitmap.Config.ARGB_8888);
            zzDq.setVisibility(0);
            zzDq.measure(android.view.View.MeasureSpec.makeMeasureSpec(zzgd.zza(zzDs), 0), android.view.View.MeasureSpec.makeMeasureSpec(com.google.android.gms.internal.zzgd.zzb(zzDs), 0));
            zzDq.layout(0, 0, zzgd.zza(zzDs), com.google.android.gms.internal.zzgd.zzb(zzDs));
            Canvas canvas = new Canvas(zzDr);
            zzDq.draw(canvas);
            zzDq.invalidate();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        protected final transient Boolean zza(Void avoid[])
        {
            this;
            JVM INSTR monitorenter ;
            int i1;
            int j1;
            i1 = zzDr.getWidth();
            j1 = zzDr.getHeight();
            if (i1 != 0 && j1 != 0) goto _L2; else goto _L1
_L1:
            avoid = Boolean.valueOf(false);
_L3:
            this;
            JVM INSTR monitorexit ;
            return avoid;
_L2:
            int i;
            int j;
            i = 0;
            j = 0;
_L4:
            int k;
            if (i < i1)
            {
                k = 0;
                break MISSING_BLOCK_LABEL_52;
            }
            boolean flag;
            if ((double)j / ((double)(i1 * j1) / 100D) > 0.10000000000000001D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            avoid = Boolean.valueOf(flag);
              goto _L3
            avoid;
            throw avoid;
            if (zzDr.getPixel(i, k) != 0)
            {
                l = j + 1;
            }
            k += 10;
            j = l;
            int l;
            if (k < j1)
            {
                l = j;
                break MISSING_BLOCK_LABEL_62;
            }
            i += 10;
              goto _L4
        }

        protected final void zza(Boolean boolean1)
        {
            zzgd.zzc(zzDs);
            if (boolean1.booleanValue() || zzDs.zzfx() || zzgd.zzd(zzDs) <= 0L)
            {
                zzDs.zzDp = boolean1.booleanValue();
                zzgd.zze(zzDs).zza(zzDs.zzoM, true);
            } else
            if (zzgd.zzd(zzDs) > 0L)
            {
                if (com.google.android.gms.ads.internal.util.client.zzb.zzN(2))
                {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Ad not detected, scheduling another run.");
                }
                zzgd.zzg(zzDs).postDelayed(zzDs, zzgd.zzf(zzDs));
                return;
            }
        }

        public zza(WebView webview)
        {
            zzDs = zzgd.this;
            super();
            zzDq = webview;
        }
    }

}
