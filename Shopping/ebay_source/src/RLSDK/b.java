// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.ebay.redlasersdk.BarcodeTypes;
import com.ebay.redlasersdk.recognizers.NewLaserScanner;
import com.ebay.redlasersdk.recognizers.RealtimeScanner;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package RLSDK:
//            a, k, e

public final class b extends Handler
{
    public final class a
    {

        public byte a[];
        public int b;
        public int c;
        public RectF d;
        public int e;
        public int f;
        final b g;

        public a()
        {
            g = b.this;
            super();
        }
    }


    public BarcodeTypes a;
    public RectF b;
    private final String c = "BarcodeEngine";
    private final boolean d = true;
    private NewLaserScanner e;
    private boolean f;
    private RealtimeScanner g;
    private final boolean h = true;
    private com.ebay.redlasersdk.recognizers.b i;
    private long j;
    private int k;
    private int l;
    private int m;
    private k n;

    public b(BarcodeTypes barcodetypes, Context context)
    {
        f = false;
        j = 0L;
        k = 0;
        l = 0;
        m = 0;
        RLSDK.a.a();
        a = barcodetypes;
        n = new k();
        b = new RectF();
        b.setEmpty();
        e = new NewLaserScanner(a);
        e.setHandler(n);
        e.start();
        e.isBusy = false;
        g = new RealtimeScanner(context, a);
        g.setHandler(n);
        g.start();
        g.isBusy = false;
        i = new com.ebay.redlasersdk.recognizers.b(a);
        i.setHandler(n);
        i.start();
        i.isBusy = false;
    }

    public final Set a(Bitmap bitmap)
    {
        int i1;
        SystemClock.uptimeMillis();
        new HashSet();
        if (a.a.b == a.a.c || a.a.b == a.a.e)
        {
            return null;
        }
        int ai[];
        a a1;
        byte abyte0[];
        RectF rectf;
        int j1;
        int k1;
        int l1;
        try
        {
            abyte0 = new byte[bitmap.getHeight() * bitmap.getWidth()];
            ai = new int[bitmap.getWidth() * 4 + 16];
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        i1 = 0;
_L2:
        if (i1 >= bitmap.getHeight())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        k1 = bitmap.getWidth();
        bitmap.getPixels(ai, 0, bitmap.getWidth(), 0, i1, bitmap.getWidth(), 1);
        j1 = 0;
        while (j1 < bitmap.getWidth()) 
        {
            l1 = ai[j1];
            abyte0[k1 * i1 + j1] = (byte)((l1 & 0xff) + ((l1 >> 16 & 0xff) + (l1 >> 7 & 0x1fe)) >> 2);
            j1++;
        }
        break MISSING_BLOCK_LABEL_300;
        rectf = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        a1 = new a();
        a1.a = abyte0;
        a1.b = bitmap.getWidth();
        a1.c = bitmap.getHeight();
        a1.d = rectf;
        a1.e = 0;
        a1.f = 0;
        bitmap = e.ProcessFrameSync(a1);
        n.a(bitmap);
        bitmap = g.ProcessFrameSync(a1);
        n.a(bitmap);
        bitmap = i.ProcessFrameSync(a1);
        n.a(bitmap);
        bitmap = (Set)n.a().get("FoundBarcodes");
        return bitmap;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a()
    {
        if (e != null)
        {
            Message.obtain(e.getThreadHandler(), 0x783205, null).sendToTarget();
            e = null;
        }
        if (g != null)
        {
            Message.obtain(g.getThreadHandler(), 0x783205, null).sendToTarget();
            g = null;
        }
        if (i != null)
        {
            Message.obtain(i.getThreadHandler(), 0x783205, null).sendToTarget();
            i = null;
        }
        n.b();
    }

    public final void a(RectF rectf)
    {
        b = rectf;
    }

    public final void a(BarcodeTypes barcodetypes)
    {
        a = barcodetypes;
        e.enabledScanTypes = a;
        if (f)
        {
            g.enabledScanTypes = a;
        }
        barcodetypes = i;
        BarcodeTypes barcodetypes1 = a;
        barcodetypes.a();
    }

    public final void a(boolean flag)
    {
        f = flag;
    }

    public final void a(byte abyte0[])
    {
        n.a(abyte0);
    }

    final void a(byte abyte0[], int i1, int j1, int k1)
    {
        Integer integer1 = Integer.valueOf(0);
        Integer integer = integer1;
        if (!e.isBusy)
        {
            integer = integer1;
            if ((e.getRecognizableTypes() & a.getEnabledTypes()) != 0)
            {
                integer = Integer.valueOf(integer1.intValue() | 4);
            }
        }
        integer1 = integer;
        if (f)
        {
            integer1 = integer;
            if (!g.isBusy)
            {
                integer1 = integer;
                if ((g.getRecognizableTypes() & a.getEnabledTypes()) != 0)
                {
                    integer1 = Integer.valueOf(integer.intValue() | 1);
                }
            }
        }
        integer = integer1;
        if (!i.isBusy)
        {
            integer = integer1;
            if ((i.getRecognizableTypes() & a.getEnabledTypes()) != 0)
            {
                integer = Integer.valueOf(integer1.intValue() | 2);
            }
        }
        if (integer.intValue() != 0)
        {
            Object obj = new RectF(0.0F, 0.0F, i1, j1);
            RectF rectf1 = new RectF(b);
            RectF rectf = rectf1;
            if (rectf1.isEmpty())
            {
                rectf = ((RectF) (obj));
            }
            rectf.setIntersect(rectf, ((RectF) (obj)));
            obj = new a();
            obj.a = abyte0;
            obj.b = i1;
            obj.c = j1;
            obj.d = rectf;
            obj.e = integer.intValue();
            obj.f = k1;
            if ((integer.intValue() & 4) != 0)
            {
                e.isBusy = true;
                Message.obtain(e.getThreadHandler(), 0x783200, obj).sendToTarget();
                k = k + 1;
            }
            if ((integer.intValue() & 1) != 0)
            {
                g.isBusy = true;
                Message.obtain(g.getThreadHandler(), 0x783200, obj).sendToTarget();
                l = l + 1;
            }
            if ((integer.intValue() & 2) != 0)
            {
                i.isBusy = true;
                Message.obtain(i.getThreadHandler(), 0x783200, obj).sendToTarget();
                m = m + 1;
            }
        } else
        {
            RLSDK.e.get().addCallbackBuffer(abyte0);
        }
        if (j == 0L)
        {
            j = Calendar.getInstance().getTimeInMillis();
            k = 0;
            l = 0;
            m = 0;
        } else
        {
            long l1 = (Calendar.getInstance().getTimeInMillis() - j) / 1000L;
            if ((double)l1 > 10D)
            {
                String.format("Last 10 seconds:%.2f NL scans/s, %.2f OCC scans/s, %.2f ZXing scans/s", new Object[] {
                    Float.valueOf((float)k / (float)l1), Float.valueOf((float)l / (float)l1), Float.valueOf((float)m / (float)l1)
                });
                j = Calendar.getInstance().getTimeInMillis();
                k = 0;
                l = 0;
                m = 0;
                return;
            }
        }
    }

    public final HashMap b()
    {
        return n.a();
    }
}
