// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.freecrop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.picsart.studio.editor.fragment.SelectionFragment;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.select.j;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.freecrop:
//            FreeCropDrawController, c

public final class b
{

    public ArrayList a;
    public boolean b;
    public boolean c;
    public RectF d;

    public b()
    {
        a = new ArrayList();
        b = false;
        c = false;
        d = new RectF();
    }

    public static String a(String s)
    {
        String s1 = (new StringBuilder()).append("selection").append("_").append(System.currentTimeMillis()).append(".png").toString();
        return (new StringBuilder()).append(s).append(s1).toString();
    }

    public final Bitmap a(Bitmap bitmap)
    {
        c = false;
        int i1 = bitmap.getWidth();
        int j1 = bitmap.getHeight();
        Path path = new Path();
        Bitmap bitmap1 = com.socialin.android.util.c.a(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap1 == null)
        {
            c = true;
            return null;
        }
        Canvas canvas = new Canvas(bitmap1);
        Object obj1 = new Paint();
        ((Paint) (obj1)).setAntiAlias(true);
        ((Paint) (obj1)).setFilterBitmap(true);
        ((Paint) (obj1)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        canvas.drawPaint(((Paint) (obj1)));
        Paint paint1 = FreeCropDrawController.e();
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(android.graphics.Paint.Style.FILL);
        paint2.setFilterBitmap(true);
        Paint paint = FreeCropDrawController.f();
        float f = 30F;
        boolean flag = false;
        int i = 0;
        while (i < a.size()) 
        {
            com.socialin.android.photo.freecrop.c c1 = (com.socialin.android.photo.freecrop.c)a.get(i);
            Bitmap bitmap2;
            boolean flag1;
            if (c1.d != 2)
            {
                c1.a(canvas, paint1, paint2);
                float f1 = Math.max(f, c1.b);
                flag1 = flag;
                f = f1;
                obj1 = canvas;
                bitmap2 = bitmap1;
                if (!c1.c)
                {
                    path.addPath(c1.a);
                    bitmap2 = bitmap1;
                    obj1 = canvas;
                    f = f1;
                    flag1 = flag;
                }
            } else
            {
                bitmap2 = com.socialin.android.util.c.a(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
                if (bitmap2 == null)
                {
                    com.socialin.android.util.c.a(bitmap1);
                    c = true;
                    return null;
                }
                obj1 = new Canvas(bitmap2);
                bitmap2.eraseColor(0);
                float f2 = c1.e;
                float f4 = c1.f;
                ((Canvas) (obj1)).save();
                ((Canvas) (obj1)).translate(f2, f4);
                ((Canvas) (obj1)).drawBitmap(bitmap1, 0.0F, 0.0F, paint);
                ((Canvas) (obj1)).restore();
                com.socialin.android.util.c.a(bitmap1);
                flag1 = true;
            }
            i++;
            flag = flag1;
            canvas = ((Canvas) (obj1));
            bitmap1 = bitmap2;
        }
        obj1 = new Paint();
        ((Paint) (obj1)).setFilterBitmap(true);
        ((Paint) (obj1)).setAntiAlias(true);
        ((Paint) (obj1)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, ((Paint) (obj1)));
        bitmap = bitmap1;
        if (!flag)
        {
            Object obj = new RectF();
            path.computeBounds(((RectF) (obj)), true);
            float f3 = ((RectF) (obj)).left - f;
            float f5 = ((RectF) (obj)).top - f;
            float f6 = ((RectF) (obj)).right + f;
            float f7 = ((RectF) (obj)).bottom + f;
            int ai[];
            int k;
            int l;
            if (f3 < 0.0F)
            {
                f = 0.0F;
            } else
            {
                f = f3;
            }
            f3 = f5;
            if (f5 < 0.0F)
            {
                f3 = 0.0F;
            }
            f5 = f6;
            if (f6 > (float)bitmap1.getWidth())
            {
                f5 = bitmap1.getWidth();
            }
            f6 = f7;
            if (f7 > (float)bitmap1.getHeight())
            {
                f6 = bitmap1.getHeight();
            }
            ((RectF) (obj)).set(f, f3, f5, f6);
            if ((int)((RectF) (obj)).width() <= 0 || (int)((RectF) (obj)).height() <= 0)
            {
                return null;
            }
            bitmap = com.socialin.android.util.c.a((int)((RectF) (obj)).width(), (int)((RectF) (obj)).height(), android.graphics.Bitmap.Config.ARGB_8888);
            if (bitmap == null)
            {
                c = true;
                return null;
            }
            (new Canvas(bitmap)).drawBitmap(bitmap1, -((RectF) (obj)).left, -((RectF) (obj)).top, paint);
            bitmap1.recycle();
        }
        obj = SelectionFragment.a(bitmap.getWidth() * 4 * bitmap.getHeight());
        ai = new int[4];
        ((ByteBuffer) (obj)).position(0);
        bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
        ((ByteBuffer) (obj)).position(0);
        ImageOpCommon.getCropRect(((java.nio.Buffer) (obj)), bitmap.getWidth(), bitmap.getHeight(), ai);
        SelectionFragment.a(((ByteBuffer) (obj)));
        if (ai[0] > ai[2] || ai[1] > ai[3])
        {
            bitmap.recycle();
            return null;
        }
        obj = new Rect(ai[0], ai[1], ai[2], ai[3]);
        if (((Rect) (obj)).width() <= 0 || ((Rect) (obj)).height() <= 0)
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                bitmap.recycle();
            }
            return null;
        }
        k = ai[0];
        l = ai[1];
        if (ai[2] - ai[0] <= 0 || ai[3] - ai[1] <= 0)
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                bitmap.recycle();
            }
            return null;
        }
        ai = com.socialin.android.util.c.a(ai[2] - ai[0], ai[3] - ai[1], android.graphics.Bitmap.Config.ARGB_8888);
        if (ai == null)
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                bitmap.recycle();
            }
            c = true;
            return null;
        } else
        {
            (new Canvas(ai)).drawBitmap(bitmap, -k, -l, paint);
            bitmap.recycle();
            return ai;
        }
    }

    public final Bitmap a(Bitmap bitmap, Bitmap bitmap1)
    {
        c = false;
        if (bitmap1 == null)
        {
            c = true;
            return null;
        }
        Bitmap bitmap2 = com.socialin.android.util.c.a(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap2 == null)
        {
            c = true;
            return null;
        }
        bitmap2.eraseColor(0);
        Paint paint = FreeCropDrawController.f();
        Object obj = new Canvas(bitmap2);
        ((Canvas) (obj)).drawBitmap(bitmap1, 0.0F, 0.0F, paint);
        bitmap1 = j.b();
        bitmap1.setColor(0xff000000);
        ((Canvas) (obj)).drawPaint(bitmap1);
        bitmap1 = new Paint();
        bitmap1.setFilterBitmap(true);
        bitmap1.setAntiAlias(true);
        bitmap1.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        ((Canvas) (obj)).drawBitmap(bitmap, 0.0F, 0.0F, bitmap1);
        obj = SelectionFragment.a(bitmap2.getWidth() * 4 * bitmap2.getHeight());
        bitmap1 = new int[4];
        ((ByteBuffer) (obj)).position(0);
        bitmap2.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
        ((ByteBuffer) (obj)).position(0);
        ImageOpCommon.getCropRect(((java.nio.Buffer) (obj)), bitmap2.getWidth(), bitmap2.getHeight(), bitmap1);
        SelectionFragment.a(((ByteBuffer) (obj)));
        if (bitmap1[0] > bitmap1[2] || bitmap1[1] > bitmap1[3])
        {
            com.socialin.android.util.c.a(bitmap2);
            return null;
        }
        obj = new Rect(bitmap1[0], bitmap1[1], bitmap1[2], bitmap1[3]);
        if (((Rect) (obj)).width() <= 0 || ((Rect) (obj)).height() <= 0)
        {
            com.socialin.android.util.c.a(bitmap2);
            return null;
        }
        int i = bitmap1[0];
        int k = bitmap1[1];
        if (bitmap1[2] - bitmap1[0] <= 0 || bitmap1[3] - bitmap1[1] <= 0)
        {
            com.socialin.android.util.c.a(bitmap2);
            return null;
        }
        int l = bitmap1[2] - bitmap1[0] - 1;
        int i1 = bitmap1[3] - bitmap1[1] - 1;
        bitmap1 = com.socialin.android.util.c.a(l, i1, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap1 == null)
        {
            c = true;
            return null;
        } else
        {
            d.left = (float)i / (float)bitmap.getWidth();
            d.top = (float)k / (float)bitmap.getHeight();
            d.right = (float)(l + i) / (float)bitmap.getWidth();
            d.bottom = (float)(i1 + k) / (float)bitmap.getHeight();
            (new Canvas(bitmap1)).drawBitmap(bitmap2, -i - 1, -k - 1, paint);
            com.socialin.android.util.c.a(bitmap2);
            return bitmap1;
        }
    }

    public final Bitmap a(Point point)
    {
        int k;
        int l;
        c = false;
        k = point.x;
        l = point.y;
        point = com.socialin.android.util.c.a(k, l, android.graphics.Bitmap.Config.ARGB_8888);
        if (point != null) goto _L2; else goto _L1
_L1:
        Object obj;
        c = true;
        obj = null;
_L4:
        return ((Bitmap) (obj));
_L2:
        Canvas canvas;
        Paint paint;
        Paint paint1;
        Paint paint2;
        int i;
        canvas = new Canvas(point);
        obj = new Paint();
        ((Paint) (obj)).setAntiAlias(true);
        ((Paint) (obj)).setFilterBitmap(true);
        ((Paint) (obj)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        canvas.drawPaint(((Paint) (obj)));
        paint = FreeCropDrawController.e();
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setStyle(android.graphics.Paint.Style.FILL);
        paint1.setFilterBitmap(true);
        paint2 = j.a();
        i = 0;
_L9:
        obj = point;
        if (i >= a.size()) goto _L4; else goto _L3
_L3:
        com.socialin.android.photo.freecrop.c c1 = (com.socialin.android.photo.freecrop.c)a.get(i);
        c1.d;
        JVM INSTR tableswitch 0 3: default 204
    //                   0 268
    //                   1 268
    //                   2 282
    //                   3 213;
           goto _L5 _L6 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_282;
_L10:
        i++;
          goto _L9
_L8:
        ByteBuffer bytebuffer = SelectionFragment.a(k * l * 4);
        bytebuffer.position(0);
        point.copyPixelsToBuffer(bytebuffer);
        ImageOpCommon.invertAlphaChannel(bytebuffer, k, l);
        bytebuffer.position(0);
        point.copyPixelsFromBuffer(bytebuffer);
        SelectionFragment.a(bytebuffer);
          goto _L10
_L6:
        c1.a(canvas, paint, paint1);
          goto _L10
        Bitmap bitmap = com.socialin.android.util.c.a(k, l, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap == null)
        {
            com.socialin.android.util.c.a(point);
            c = true;
            return null;
        }
        canvas = new Canvas(bitmap);
        bitmap.eraseColor(0);
        float f = c1.e;
        float f1 = c1.f;
        canvas.save();
        canvas.translate(f * 1.0F, f1 * 1.0F);
        canvas.drawBitmap(point, 0.0F, 0.0F, paint2);
        canvas.restore();
        com.socialin.android.util.c.a(point);
        point = bitmap;
          goto _L10
    }

    public final void a(Canvas canvas, Bitmap bitmap)
    {
        Paint paint = FreeCropDrawController.d();
        Paint paint1 = FreeCropDrawController.h();
        Paint paint2 = FreeCropDrawController.g();
        int i = 0;
        while (i < a.size()) 
        {
            com.socialin.android.photo.freecrop.c c1 = (com.socialin.android.photo.freecrop.c)a.get(i);
            if (c1.d == 0)
            {
                paint.setStrokeWidth(c1.b);
                paint2.setStrokeWidth(c1.b);
                canvas.drawPath(c1.a, paint);
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint1);
                if (!c1.c)
                {
                    canvas.drawPath(c1.a, paint2);
                }
            } else
            {
                Paint paint3 = new Paint();
                paint3.setAntiAlias(true);
                paint3.setStyle(android.graphics.Paint.Style.FILL);
                paint3.setFilterBitmap(true);
                paint3.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
                paint3.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
                canvas.drawPath(c1.a, paint3);
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint1);
                if (!c1.c)
                {
                    paint3.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
                    paint3.setColor(0xffff0000);
                    paint3.setAlpha(80);
                    canvas.drawPath(c1.a, paint3);
                }
            }
            i++;
        }
    }

    public final void a(Path path, float f, boolean flag)
    {
        com.socialin.android.photo.freecrop.c c1 = new com.socialin.android.photo.freecrop.c(this);
        c1.a = path;
        c1.b = f;
        c1.c = flag;
        c1.d = 0;
        a.add(c1);
    }

    public final void a(Path path, boolean flag)
    {
        com.socialin.android.photo.freecrop.c c1 = new com.socialin.android.photo.freecrop.c(this);
        c1.a = path;
        c1.c = flag;
        c1.d = 1;
        a.add(c1);
    }

    public final boolean a()
    {
        return a.size() > 0;
    }
}
