// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.wall.photo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.socialin.android.wall.photo:
//            ColorLinesWallpaper, b, c

public final class a extends android.service.wallpaper.WallpaperService.Engine
{

    final ColorLinesWallpaper a;

    public a(ColorLinesWallpaper colorlineswallpaper)
    {
        a = colorlineswallpaper;
        super(colorlineswallpaper);
        if (ColorLinesWallpaper.a() != null)
        {
            ColorLinesWallpaper.a(null);
            if (ColorLinesWallpaper.b())
            {
                try
                {
                    ColorLinesWallpaper.a(colorlineswallpaper, getSurfaceHolder());
                    ColorLinesWallpaper.a(colorlineswallpaper).unlockCanvasAndPost(ColorLinesWallpaper.c());
                }
                // Misplaced declaration of an exception variable
                catch (ColorLinesWallpaper colorlineswallpaper)
                {
                    Log.e(ColorLinesWallpaper.d(), (new StringBuilder("Unexpected exception is thrown ")).append(colorlineswallpaper.getMessage()).toString(), colorlineswallpaper);
                }
            }
        }
        if (ColorLinesWallpaper.a() == null)
        {
            ColorLinesWallpaper.a(new b(this));
            ColorLinesWallpaper.a().start();
        }
    }

    public static int a()
    {
        Random random = new Random();
        return Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
_L13:
        if (i >= ColorLinesWallpaper.b(a).size()) goto _L2; else goto _L1
_L1:
        if (ColorLinesWallpaper.b(a).get(i) == null || !((c)ColorLinesWallpaper.b(a).get(i)).h)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        ColorLinesWallpaper.b(a).remove(i);
        i--;
        break MISSING_BLOCK_LABEL_1023;
        Object obj;
        Canvas canvas;
        if (ColorLinesWallpaper.b(a).get(i) == null || ColorLinesWallpaper.c() == null)
        {
            break MISSING_BLOCK_LABEL_1023;
        }
        obj = (c)ColorLinesWallpaper.b(a).get(i);
        canvas = ColorLinesWallpaper.c();
        if (((c) (obj)).i) goto _L4; else goto _L3
_L3:
        obj.p = ((c) (obj)).p + ((c) (obj)).w;
        obj.s = ((c) (obj)).b;
        obj.t = ((c) (obj)).c;
        if ((double)((c) (obj)).p >= 6.0831853071795861D) goto _L6; else goto _L5
_L5:
        if (Math.abs(6.2831853071795862D - (double)((c) (obj)).p) > 0.20000000000000001D)
        {
            obj.b = ((c) (obj)).b + (float)((c) (obj)).l * ((c) (obj)).w;
        }
_L10:
        obj.c = (float)((double)((c) (obj)).n + (double)((c) (obj)).k * Math.sin(((c) (obj)).p));
        ((c) (obj)).a.quadTo(((Float)((c) (obj)).r.get(((c) (obj)).r.size() - 1)).floatValue(), ((Float)((c) (obj)).q.get(((c) (obj)).q.size() - 1)).floatValue(), (((Float)((c) (obj)).r.get(((c) (obj)).r.size() - 1)).floatValue() + ((c) (obj)).b) / 2.0F, (((Float)((c) (obj)).q.get(((c) (obj)).q.size() - 1)).floatValue() + ((c) (obj)).c) / 2.0F);
        ((c) (obj)).r.add(Float.valueOf(((c) (obj)).b));
        ((c) (obj)).q.add(Float.valueOf(((c) (obj)).c));
_L4:
        int j;
        j = ((c) (obj)).g;
        if (((c) (obj)).r.size() <= j)
        {
            break MISSING_BLOCK_LABEL_854;
        }
        ((c) (obj)).a.reset();
        ((c) (obj)).a.moveTo(((Float)((c) (obj)).r.get(((c) (obj)).r.size() - j - 1)).floatValue(), ((Float)((c) (obj)).q.get(((c) (obj)).q.size() - j - 1)).floatValue());
        j = ((c) (obj)).r.size() - j;
_L7:
        if (j >= ((c) (obj)).r.size() - 1)
        {
            break MISSING_BLOCK_LABEL_854;
        }
        Path path = ((c) (obj)).a;
        float f = ((Float)((c) (obj)).r.get(j)).floatValue();
        float f1 = ((Float)((c) (obj)).q.get(j)).floatValue();
        float f2 = ((Float)((c) (obj)).r.get(j)).floatValue();
        f2 = (((Float)((c) (obj)).r.get(j + 1)).floatValue() + f2) / 2.0F;
        float f3 = ((Float)((c) (obj)).q.get(j)).floatValue();
        path.quadTo(f, f1, f2, (((Float)((c) (obj)).q.get(j + 1)).floatValue() + f3) / 2.0F);
        j++;
          goto _L7
_L6:
        if ((double)((c) (obj)).p <= 6.2831853071795862D || (double)((c) (obj)).p >= 12.366370614359173D) goto _L9; else goto _L8
_L8:
        if (Math.abs(12.566370614359172D - (double)((c) (obj)).p) > 0.20000000000000001D)
        {
            obj.b = ((c) (obj)).b - (float)((c) (obj)).l * ((c) (obj)).w;
        }
          goto _L10
        obj;
        Log.e(ColorLinesWallpaper.d(), (new StringBuilder("Unexpected exception is thrown ")).append(((IndexOutOfBoundsException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L9:
        if ((double)((c) (obj)).p < 12.566370614359172D) goto _L10; else goto _L11
_L11:
        obj.p = 0.0F;
          goto _L10
        obj;
        throw obj;
        canvas.rotate(((c) (obj)).v, ((c) (obj)).m, ((c) (obj)).n);
        canvas.drawPath(((c) (obj)).a, ((c) (obj)).e);
        canvas.drawPath(((c) (obj)).a, ((c) (obj)).d);
        if (((c) (obj)).r.size() > 3)
        {
            canvas.drawCircle(((c) (obj)).s, ((c) (obj)).t, ((c) (obj)).u, ((c) (obj)).f);
        }
        canvas.rotate(-((c) (obj)).v, ((c) (obj)).m, ((c) (obj)).n);
        obj.o = ((c) (obj)).o + 1;
        if (((c) (obj)).o >= ((c) (obj)).j)
        {
            obj.i = true;
            obj.g = ((c) (obj)).g - 1;
            if (((c) (obj)).g <= 0)
            {
                obj.h = true;
            }
        }
        i++;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public final void a(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        int i = ColorLinesWallpaper.b(a).size();
        if (i != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        wait(60 / i);
_L3:
        if (canvas == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        canvas.drawColor(Color.parseColor("#222222"));
        b();
          goto _L1
        canvas;
        throw canvas;
        InterruptedException interruptedexception;
        interruptedexception;
        ColorLinesWallpaper.d();
        (new StringBuilder("Unexpected exception is thrown ")).append(interruptedexception.getMessage());
          goto _L3
    }

    public final void onCreate(SurfaceHolder surfaceholder)
    {
        super.onCreate(surfaceholder);
        setTouchEventsEnabled(true);
    }

    public final void onTouchEvent(MotionEvent motionevent)
    {
        this;
        JVM INSTR monitorenter ;
        super.onTouchEvent(motionevent);
        if (motionevent.getAction() == 1) goto _L2; else goto _L1
_L1:
        int i = ColorLinesWallpaper.b(a).size();
        if (i <= 35) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        motionevent = new c(motionevent.getX(), motionevent.getY(), a());
        ColorLinesWallpaper.b(a).add(motionevent);
        if (true) goto _L2; else goto _L4
_L4:
        motionevent;
        throw motionevent;
    }

    public final void onVisibilityChanged(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        b b1;
        ColorLinesWallpaper.a(a, flag);
        super.onVisibilityChanged(flag);
        b1 = ColorLinesWallpaper.a();
        if (b1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        ColorLinesWallpaper.b(a).clear();
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        ColorLinesWallpaper.a(new b(this));
        ColorLinesWallpaper.a().start();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
