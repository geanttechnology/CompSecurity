// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import myobfuscated.ay.e;
import myobfuscated.ba.f;

// Referenced classes of package com.picsart.effectnew:
//            p, q

public final class EffectsDrawHistoryController
{

    public ArrayList a;
    public q b;

    public EffectsDrawHistoryController()
    {
        a = new ArrayList();
    }

    public static Bitmap a(Object obj, int i, int j, ArrayList arraylist)
    {
        Bitmap bitmap;
        Canvas canvas;
        Paint paint;
        Paint paint1;
        int k;
        int l;
        int i1;
        bitmap = com.socialin.android.util.c.a(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_579;
        }
        if (a(obj, bitmap, arraylist))
        {
            break MISSING_BLOCK_LABEL_576;
        }
        canvas = new Canvas(bitmap);
        j = bitmap.getWidth();
        k = bitmap.getHeight();
        paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint1 = new Paint();
        paint1.setFilterBitmap(true);
        paint1.setAntiAlias(true);
        l = Color.argb(255, 255, 255, 255);
        i1 = Color.argb(255, 0, 0, 0);
        canvas.drawColor(l);
        i = 0;
_L8:
        p p1;
        if (i >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_576;
        }
        p1 = (p)arraylist.get(i);
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[EffectDrawType.values().length];
                try
                {
                    a[EffectDrawType.DRAW_PATH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[EffectDrawType.DRAW_SHAPE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[EffectDrawType.INVERT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[EffectDrawType.FILL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[EffectDrawType.CLEAR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[p1.a.ordinal()];
        JVM INSTR tableswitch 1 5: default 216
    //                   1 223
    //                   2 312
    //                   3 513
    //                   4 556
    //                   5 566;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_566;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L9:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        float f1 = p1.c;
        int j1 = p1.e;
        float f3 = p1.d;
        paint.setStrokeWidth(f1);
        paint.setColor(Color.argb(255, j1, j1, j1));
        obj = null;
        if (f3 > 0.0F)
        {
            obj = new BlurMaskFilter(f3, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        paint.setMaskFilter(((android.graphics.MaskFilter) (obj)));
        canvas.drawPath(p1.b, paint);
          goto _L9
_L3:
        int k1 = p1.e;
        float f5 = p1.d;
        float f6 = p1.g;
        obj = p1.f;
        float f7 = p1.h;
        float f8 = p1.i;
        paint1.setColor(Color.argb(255, k1, k1, k1));
        canvas.save();
        float f2 = ((PointF) (obj)).x / f7;
        float f4 = ((PointF) (obj)).y / f8;
        canvas.scale(f7, f8);
        obj = null;
        if (f5 > 0.0F)
        {
            obj = new BlurMaskFilter((f6 * f5) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        paint1.setMaskFilter(((android.graphics.MaskFilter) (obj)));
        f5 = f6 - (f6 * f5) / 100F;
        if (p1.j == EffectShapeDrawerNew.ShapeType.Focal)
        {
            canvas.drawCircle(f2, f4, f5, paint1);
        } else
        {
            canvas.drawRect(f2 - f5, f4 - f5, f2 + f5, f5 + f4, paint1);
        }
        canvas.restore();
          goto _L9
_L4:
        obj = myobfuscated.ay.e.a(j * k * 4);
        bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj)));
        ImageOp.invertColorInplace(((java.nio.Buffer) (obj)), ((ByteBuffer) (obj)).capacity());
        ((ByteBuffer) (obj)).position(0);
        bitmap.copyPixelsFromBuffer(((java.nio.Buffer) (obj)));
        myobfuscated.ay.e.a(((ByteBuffer) (obj)));
          goto _L9
_L5:
        canvas.drawColor(l);
          goto _L9
        canvas.drawColor(i1);
          goto _L9
        return bitmap;
        return null;
    }

    private static boolean a(Object obj, Bitmap bitmap, ArrayList arraylist)
    {
        f f9;
        Canvas canvas;
        Paint paint;
        Paint paint1;
        int i;
        int j;
        int k;
        if (obj == null)
        {
            return false;
        }
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint1 = new Paint();
        paint1.setFilterBitmap(true);
        paint1.setAntiAlias(true);
        j = Color.argb(255, 255, 255, 255);
        k = Color.argb(255, 0, 0, 0);
        canvas.drawColor(j);
        f9 = null;
        i = 0;
_L8:
        p p1;
        if (i >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_577;
        }
        p1 = (p)arraylist.get(i);
        _cls1.a[p1.a.ordinal()];
        JVM INSTR tableswitch 1 5: default 188
    //                   1 197
    //                   2 287
    //                   3 490
    //                   4 557
    //                   5 567;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_567;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L9:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        float f1 = p1.c;
        int l = p1.e;
        float f3 = p1.d;
        paint.setStrokeWidth(f1);
        paint.setColor(Color.argb(255, l, l, l));
        BlurMaskFilter blurmaskfilter = null;
        if (f3 > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter(f3, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        paint.setMaskFilter(blurmaskfilter);
        canvas.drawPath(p1.b, paint);
          goto _L9
_L3:
        int i1 = p1.e;
        float f5 = p1.d;
        float f6 = p1.g;
        Object obj1 = p1.f;
        float f7 = p1.h;
        float f8 = p1.i;
        paint1.setColor(Color.argb(255, i1, i1, i1));
        canvas.save();
        float f2 = ((PointF) (obj1)).x / f7;
        float f4 = ((PointF) (obj1)).y / f8;
        canvas.scale(f7, f8);
        obj1 = null;
        if (f5 > 0.0F)
        {
            obj1 = new BlurMaskFilter((f6 * f5) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        paint1.setMaskFilter(((android.graphics.MaskFilter) (obj1)));
        f5 = f6 - (f6 * f5) / 100F;
        if (p1.j == EffectShapeDrawerNew.ShapeType.Focal)
        {
            canvas.drawCircle(f2, f4, f5, paint1);
        } else
        {
            canvas.drawRect(f2 - f5, f4 - f5, f2 + f5, f5 + f4, paint1);
        }
        canvas.restore();
          goto _L9
_L4:
        if (f9 == null)
        {
            try
            {
                f9 = new f((RenderScript)obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
        }
        try
        {
            Allocation allocation = Allocation.createFromBitmap((RenderScript)obj, bitmap);
            f9.a(allocation, allocation);
            allocation.copyTo(bitmap);
            allocation.destroy();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (f9 != null)
            {
                f9.destroy();
            }
            return false;
        }
          goto _L9
_L5:
        canvas.drawColor(j);
          goto _L9
        canvas.drawColor(k);
          goto _L9
        if (f9 != null)
        {
            f9.destroy();
        }
        return true;
    }

    public final void a()
    {
        p p1 = new p();
        p1.a = EffectDrawType.INVERT;
        a.add(p1);
        if (b != null)
        {
            b.a(this, true);
        }
    }

    public final void b()
    {
        a = new ArrayList();
        if (b != null)
        {
            b.a(this, false);
        }
    }

    public final boolean c()
    {
        boolean flag = false;
        int i = 0;
        int j;
        int k;
        for (j = 0; i < a.size(); j = k)
        {
            k = j;
            if (((p)a.get(i)).a == EffectDrawType.INVERT)
            {
                k = j + 1;
            }
            i++;
        }

        if (j % 2 == 1)
        {
            flag = true;
        }
        return flag;
    }

    public final ArrayList d()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < a.size(); i++)
        {
            arraylist.add((p)a.get(i));
        }

        return arraylist;
    }

    public final boolean e()
    {
        return a.size() == 0;
    }

    private class EffectDrawType extends Enum
    {

        private static final EffectDrawType $VALUES[];
        public static final EffectDrawType CLEAR;
        public static final EffectDrawType DRAW_PATH;
        public static final EffectDrawType DRAW_SHAPE;
        public static final EffectDrawType FILL;
        public static final EffectDrawType INVERT;

        public static EffectDrawType valueOf(String s)
        {
            return (EffectDrawType)Enum.valueOf(com/picsart/effectnew/EffectsDrawHistoryController$EffectDrawType, s);
        }

        public static EffectDrawType[] values()
        {
            return (EffectDrawType[])$VALUES.clone();
        }

        static 
        {
            DRAW_PATH = new EffectDrawType("DRAW_PATH", 0);
            DRAW_SHAPE = new EffectDrawType("DRAW_SHAPE", 1);
            INVERT = new EffectDrawType("INVERT", 2);
            FILL = new EffectDrawType("FILL", 3);
            CLEAR = new EffectDrawType("CLEAR", 4);
            $VALUES = (new EffectDrawType[] {
                DRAW_PATH, DRAW_SHAPE, INVERT, FILL, CLEAR
            });
        }

        private EffectDrawType(String s, int i)
        {
            super(s, i);
        }
    }

}
