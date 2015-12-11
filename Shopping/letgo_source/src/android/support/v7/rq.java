// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            ut, ul, tp

public class rq
    implements Runnable
{
    protected final class a extends AsyncTask
    {

        final rq a;
        private final WebView b;
        private Bitmap c;

        protected transient Boolean a(Void avoid[])
        {
            this;
            JVM INSTR monitorenter ;
            int j1;
            int k1;
            j1 = c.getWidth();
            k1 = c.getHeight();
            if (j1 != 0 && k1 != 0) goto _L2; else goto _L1
_L1:
            avoid = Boolean.valueOf(false);
_L3:
            this;
            JVM INSTR monitorexit ;
            return avoid;
_L2:
            int j;
            int k;
            j = 0;
            k = 0;
_L4:
            int l;
            if (j < j1)
            {
                l = 0;
                break MISSING_BLOCK_LABEL_52;
            }
            boolean flag;
            if ((double)k / ((double)(j1 * k1) / 100D) > 0.10000000000000001D)
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
            if (c.getPixel(j, l) != 0)
            {
                i1 = k + 1;
            }
            l += 10;
            k = i1;
            int i1;
            if (l < k1)
            {
                i1 = k;
                break MISSING_BLOCK_LABEL_62;
            }
            j += 10;
              goto _L4
        }

        protected void a(Boolean boolean1)
        {
            rq.c(a);
            if (boolean1.booleanValue() || a.c() || rq.d(a) <= 0L)
            {
                a.c = boolean1.booleanValue();
                rq.e(a).zza(a.a, true);
            } else
            if (rq.d(a) > 0L)
            {
                if (zzb.zzM(2))
                {
                    zzb.zzaC("Ad not detected, scheduling another run.");
                }
                rq.g(a).postDelayed(a, rq.f(a));
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Boolean)obj);
        }

        protected void onPreExecute()
        {
            this;
            JVM INSTR monitorenter ;
            c = Bitmap.createBitmap(rq.a(a), rq.b(a), android.graphics.Bitmap.Config.ARGB_8888);
            b.setVisibility(0);
            b.measure(android.view.View.MeasureSpec.makeMeasureSpec(rq.a(a), 0), android.view.View.MeasureSpec.makeMeasureSpec(rq.b(a), 0));
            b.layout(0, 0, rq.a(a), rq.b(a));
            Canvas canvas = new Canvas(c);
            b.draw(canvas);
            b.invalidate();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public a(WebView webview)
        {
            a = rq.this;
            super();
            b = webview;
        }
    }


    protected final ul a;
    protected boolean b;
    protected boolean c;
    private final Handler d;
    private final long e;
    private long f;
    private um.a g;
    private final int h;
    private final int i;

    public rq(um.a a1, ul ul1, int j, int k)
    {
        this(a1, ul1, j, k, 200L, 50L);
    }

    public rq(um.a a1, ul ul1, int j, int k, long l, long l1)
    {
        e = l;
        f = l1;
        d = new Handler(Looper.getMainLooper());
        a = ul1;
        g = a1;
        b = false;
        c = false;
        h = k;
        i = j;
    }

    static int a(rq rq1)
    {
        return rq1.i;
    }

    static int b(rq rq1)
    {
        return rq1.h;
    }

    static long c(rq rq1)
    {
        long l = rq1.f - 1L;
        rq1.f = l;
        return l;
    }

    static long d(rq rq1)
    {
        return rq1.f;
    }

    static um.a e(rq rq1)
    {
        return rq1.g;
    }

    static long f(rq rq1)
    {
        return rq1.e;
    }

    static Handler g(rq rq1)
    {
        return rq1.d;
    }

    public void a()
    {
        d.postDelayed(this, e);
    }

    public void a(AdResponseParcel adresponseparcel)
    {
        a(adresponseparcel, new ut(this, a, adresponseparcel.zzEe));
    }

    public void a(AdResponseParcel adresponseparcel, ut ut1)
    {
        a.setWebViewClient(ut1);
        ul ul1 = a;
        if (TextUtils.isEmpty(adresponseparcel.zzAT))
        {
            ut1 = null;
        } else
        {
            ut1 = zzp.zzbx().a(adresponseparcel.zzAT);
        }
        ul1.loadDataWithBaseURL(ut1, adresponseparcel.body, "text/html", "UTF-8", null);
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        b = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean d()
    {
        return c;
    }

    public void run()
    {
        if (a == null || c())
        {
            g.zza(a, true);
            return;
        } else
        {
            (new a(a.getWebView())).execute(new Void[0]);
            return;
        }
    }
}
