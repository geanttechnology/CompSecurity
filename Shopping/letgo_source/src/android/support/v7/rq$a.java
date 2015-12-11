// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            rq

protected final class b extends AsyncTask
{

    final rq a;
    private final WebView b;
    private Bitmap c;

    protected transient Boolean a(Void avoid[])
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        int j1;
        i1 = c.getWidth();
        j1 = c.getHeight();
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
        if (c.getPixel(i, k) != 0)
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
        c = Bitmap.createBitmap(rq.a(a), rq.b(a), android.graphics.p.Config.ARGB_8888);
        b.setVisibility(0);
        b.measure(android.view.MeasureSpec.makeMeasureSpec(rq.a(a), 0), android.view.MeasureSpec.makeMeasureSpec(rq.b(a), 0));
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

    public eSpec(rq rq1, WebView webview)
    {
        a = rq1;
        super();
        b = webview;
    }
}
