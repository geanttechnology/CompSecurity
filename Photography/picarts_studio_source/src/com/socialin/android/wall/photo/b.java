// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.wall.photo;

import android.util.Log;
import android.view.SurfaceHolder;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.socialin.android.wall.photo:
//            a, ColorLinesWallpaper, c

public final class b extends Thread
{

    private Random a;
    private a b;

    public b(a a1)
    {
        b = a1;
        super();
        a = new Random();
        setPriority(1);
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (a.nextInt(200) == 1 && ColorLinesWallpaper.c(b.a))
        {
            c c1 = new c(a.nextInt(ColorLinesWallpaper.d(b.a)), a.nextInt(ColorLinesWallpaper.e(b.a)), com.socialin.android.wall.photo.a.a());
            ColorLinesWallpaper.b(b.a).add(c1);
            c1 = new c(a.nextInt(ColorLinesWallpaper.d(b.a)), a.nextInt(ColorLinesWallpaper.e(b.a)), com.socialin.android.wall.photo.a.a());
            ColorLinesWallpaper.b(b.a).add(c1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void run()
    {
        super.run();
_L3:
        if (!b.isVisible())
        {
            break; /* Loop/switch isn't completed */
        }
        if (ColorLinesWallpaper.b(b.a).isEmpty())
        {
            break MISSING_BLOCK_LABEL_248;
        }
        if (ColorLinesWallpaper.a(b.a) == null)
        {
            ColorLinesWallpaper.a(b.a, b.getSurfaceHolder());
        }
        ColorLinesWallpaper.a(ColorLinesWallpaper.a(b.a).lockCanvas());
        ColorLinesWallpaper.a(true);
_L1:
        if (ColorLinesWallpaper.c() != null)
        {
            b.a(ColorLinesWallpaper.c());
        }
        try
        {
            ColorLinesWallpaper.a(b.a).unlockCanvasAndPost(ColorLinesWallpaper.c());
            ColorLinesWallpaper.a(false);
        }
        catch (Exception exception)
        {
            Log.e(ColorLinesWallpaper.d(), (new StringBuilder("Unexpected exception is thrown ")).append(exception.getMessage()).toString(), exception);
        }
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        Log.e(ColorLinesWallpaper.d(), (new StringBuilder("Unexpected exception is thrown ")).append(((Exception) (obj)).getMessage()).toString(), ((Throwable) (obj)));
          goto _L1
        obj;
        try
        {
            ColorLinesWallpaper.a(b.a).unlockCanvasAndPost(ColorLinesWallpaper.c());
            ColorLinesWallpaper.a(false);
        }
        catch (Exception exception1)
        {
            Log.e(ColorLinesWallpaper.d(), (new StringBuilder("Unexpected exception is thrown ")).append(exception1.getMessage()).toString(), exception1);
        }
        throw obj;
        a();
        if (true) goto _L3; else goto _L2
_L2:
    }
}
