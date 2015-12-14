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
import android.support.v4.util.LruCache;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class akf
{

    private static akf b;
    private LruCache a;
    private ExecutorService c;
    private akj d;
    private aki e;

    private akf()
    {
        c = Executors.newFixedThreadPool(1);
        e = new aki(this, this);
        a = new akg(this, (int)(Runtime.getRuntime().maxMemory() / 8L));
    }

    public static akf a()
    {
        if (b == null)
        {
            b = new akf();
        }
        return b;
    }

    static aki a(akf akf1)
    {
        return akf1.e;
    }

    private Bitmap a(int i)
    {
        return (Bitmap)a.get(Integer.valueOf(i));
    }

    static Bitmap a(akf akf1, FontTextLabelInfo fonttextlabelinfo, ama ama)
    {
        return akf1.a(fonttextlabelinfo, ama);
    }

    private Bitmap a(FontTextLabelInfo fonttextlabelinfo, ama ama)
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
        f = yp.a(InstaBeautyApplication.a, f);
        f1 = yp.a(InstaBeautyApplication.a, f1);
        Object obj = fonttextlabelinfo.i;
        String s = fonttextlabelinfo.m;
        Paint paint = new Paint();
        paint.setTextSize(yp.c(InstaBeautyApplication.a, 30F));
        paint.setColor(i);
        paint.setAntiAlias(true);
        if (ama != null)
        {
            paint.setTypeface(alr.a().a(ama));
        }
        ama = new Rect();
        paint.getTextBounds(s, 0, s.length(), ama);
        int i1 = yp.a(InstaBeautyApplication.a, 20F);
        int j1 = ama.width() + i1 * 2;
        int k1 = ama.height() + i1 * 2;
        ama = Bitmap.createBitmap(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(ama);
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
        return ama;
    }

    private Bitmap a(String s)
    {
        InputStream inputstream;
        inputstream = InstaBeautyApplication.a.getResources().getAssets().open(s);
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

    static void a(akf akf1, int i, Bitmap bitmap)
    {
        akf1.a(i, bitmap);
    }

    static akj b(akf akf1)
    {
        return akf1.d;
    }

    public void a(boolean flag, FontTextLabelInfo fonttextlabelinfo, ama ama, int i, akj akj1)
    {
        d = akj1;
        akj1 = a(i);
        if (akj1 == null || akj1 != null && flag)
        {
            c.execute(new akh(this, fonttextlabelinfo, ama, i));
            return;
        } else
        {
            d.a(akj1, i);
            return;
        }
    }
}
