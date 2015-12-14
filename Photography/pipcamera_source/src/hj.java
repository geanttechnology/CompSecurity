// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.pipcamera.application.PIPCameraApplication;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class hj
{

    private static hj b;
    private LruCache a;
    private ExecutorService c;
    private hl d;
    private hk e;

    private hj()
    {
        c = Executors.newFixedThreadPool(1);
        e = new hk(this, this);
        a = new LruCache((int)(Runtime.getRuntime().maxMemory() / 8L)) {

            final hj a;

            protected int a(Integer integer, Bitmap bitmap)
            {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }

            protected int sizeOf(Object obj, Object obj1)
            {
                return a((Integer)obj, (Bitmap)obj1);
            }

            
            {
                a = hj.this;
                super(i);
            }
        };
    }

    private Bitmap a(int i)
    {
        return (Bitmap)a.get(Integer.valueOf(i));
    }

    private Bitmap a(FontTextLabelInfo fonttextlabelinfo, hb hb)
    {
        int i = fonttextlabelinfo.j;
        int k = fonttextlabelinfo.h;
        int l = fonttextlabelinfo.e;
        float f2 = fonttextlabelinfo.g;
        float f1 = fonttextlabelinfo.d;
        float f = f1;
        if (f1 != 0.0F)
        {
            f = f1 / 2.0F;
        }
        f1 = f2;
        if (f2 != 0.0F)
        {
            f1 = f2 / 2.0F + 0.5F;
        }
        f = ew.a(PIPCameraApplication.a, f);
        f1 = ew.a(PIPCameraApplication.a, f1);
        Object obj = fonttextlabelinfo.i;
        String s = fonttextlabelinfo.m;
        Paint paint = new Paint();
        paint.setTextSize(ew.c(PIPCameraApplication.a, 30F));
        paint.setColor(i);
        paint.setAntiAlias(true);
        if (hb != null)
        {
            paint.setTypeface(iq.a().a(hb));
        }
        hb = new Rect();
        paint.getTextBounds(s, 0, s.length(), hb);
        int i1 = ew.a(PIPCameraApplication.a, 20F);
        int j1 = hb.width() + i1 * 2;
        int k1 = hb.height() + i1 * 2;
        hb = Bitmap.createBitmap(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(hb);
        int l1 = (int)((float)(canvas.getHeight() / 2) - (paint.descent() + paint.ascent()) / 2.0F);
        canvas.drawText(s, i1, l1, paint);
        if (fonttextlabelinfo.o)
        {
            obj = a(((String) (obj)));
            if (obj != null)
            {
                paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
                int i2 = k1 * (((Bitmap) (obj)).getWidth() / ((Bitmap) (obj)).getHeight());
                if (fonttextlabelinfo.n)
                {
                    canvas.drawBitmap(((Bitmap) (obj)), null, new Rect(0, 0, j1, k1), paint);
                } else
                {
                    int j = 0;
                    while (j < j1) 
                    {
                        canvas.drawBitmap(((Bitmap) (obj)), null, new Rect(j, 0, j + i2, k1), paint);
                        j += i2;
                    }
                }
            }
        }
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        paint.setStrokeWidth(f1);
        paint.setColor(k);
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeMiter(0.0F);
        canvas.drawText(s, i1, l1, paint);
        paint.setColor(l);
        if (fonttextlabelinfo.f)
        {
            paint.setMaskFilter(new BlurMaskFilter(fonttextlabelinfo.p, android.graphics.BlurMaskFilter.Blur.SOLID));
        }
        canvas.drawText(s, (float)i1 + f, f + (float)l1, paint);
        return hb;
    }

    static Bitmap a(hj hj1, FontTextLabelInfo fonttextlabelinfo, hb hb)
    {
        return hj1.a(fonttextlabelinfo, hb);
    }

    private Bitmap a(String s)
    {
        InputStream inputstream;
        inputstream = PIPCameraApplication.a.getResources().getAssets().open(s);
        s = BitmapFactory.decodeStream(inputstream);
        inputstream.close();
        return s;
        IOException ioexception;
        ioexception;
        s = null;
_L2:
        ioexception.printStackTrace();
        return s;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static hj a()
    {
        if (b == null)
        {
            b = new hj();
        }
        return b;
    }

    static hk a(hj hj1)
    {
        return hj1.e;
    }

    private void a(int i, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            if (a(i) != null)
            {
                a.remove(Integer.valueOf(i));
            }
            a.put(Integer.valueOf(i), bitmap);
            System.out.println((new StringBuilder()).append("bitmapcache:").append(i).toString());
        }
    }

    static void a(hj hj1, int i, Bitmap bitmap)
    {
        hj1.a(i, bitmap);
    }

    static hl b(hj hj1)
    {
        return hj1.d;
    }

    public void a(boolean flag, FontTextLabelInfo fonttextlabelinfo, hb hb, int i, hl hl1)
    {
        d = hl1;
        hl1 = a(i);
        if (hl1 == null || hl1 != null && flag)
        {
            c.execute(new Runnable(fonttextlabelinfo, hb, i) {

                final FontTextLabelInfo a;
                final hb b;
                final int c;
                final hj d;

                public void run()
                {
                    Bitmap bitmap = hj.a(d, a, b);
                    Message message = hj.a(d).obtainMessage();
                    HashMap hashmap = new HashMap();
                    hashmap.put("bitmap", bitmap);
                    hashmap.put("position", Integer.valueOf(c));
                    message.obj = hashmap;
                    hj.a(d).sendMessage(message);
                    hj.a(d, c, bitmap);
                }

            
            {
                d = hj.this;
                a = fonttextlabelinfo;
                b = hb;
                c = i;
                super();
            }
            });
            return;
        } else
        {
            d.a(hl1, i);
            return;
        }
    }
}
