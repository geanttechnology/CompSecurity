// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.webkit.WebView;

public final class zz extends AsyncTask
{

    final zy a;
    private final WebView b;
    private Bitmap c;

    public zz(zy zy1, WebView webview)
    {
        a = zy1;
        super();
        b = webview;
    }

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
        zy.c(a);
        if (boolean1.booleanValue() || a.c() || zy.d(a) <= 0L)
        {
            a.c = boolean1.booleanValue();
            zy.e(a).a(a.a);
        } else
        if (zy.d(a) > 0L)
        {
            if (acb.a(2))
            {
                acb.a("Ad not detected, scheduling another run.");
            }
            zy.g(a).postDelayed(a, zy.f(a));
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
        c = Bitmap.createBitmap(zy.a(a), zy.b(a), android.graphics.Bitmap.Config.ARGB_8888);
        b.setVisibility(0);
        b.measure(android.view.View.MeasureSpec.makeMeasureSpec(zy.a(a), 0), android.view.View.MeasureSpec.makeMeasureSpec(zy.b(a), 0));
        b.layout(0, 0, zy.a(a), zy.b(a));
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
}
