// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.wall.photo;

import android.graphics.Canvas;
import android.graphics.Point;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.wall.photo:
//            a, b

public class ColorLinesWallpaper extends WallpaperService
{

    private static final String a = com/socialin/android/wall/photo/ColorLinesWallpaper.getSimpleName();
    private static b d;
    private static Canvas h = null;
    private static boolean i = false;
    private List b;
    private SurfaceHolder c;
    private int e;
    private int f;
    private boolean g;

    public ColorLinesWallpaper()
    {
        b = new ArrayList();
        g = true;
    }

    static Canvas a(Canvas canvas)
    {
        h = canvas;
        return canvas;
    }

    static SurfaceHolder a(ColorLinesWallpaper colorlineswallpaper)
    {
        return colorlineswallpaper.c;
    }

    static SurfaceHolder a(ColorLinesWallpaper colorlineswallpaper, SurfaceHolder surfaceholder)
    {
        colorlineswallpaper.c = surfaceholder;
        return surfaceholder;
    }

    static b a()
    {
        return d;
    }

    static b a(b b1)
    {
        d = b1;
        return b1;
    }

    static boolean a(ColorLinesWallpaper colorlineswallpaper, boolean flag)
    {
        colorlineswallpaper.g = flag;
        return flag;
    }

    static boolean a(boolean flag)
    {
        i = flag;
        return flag;
    }

    static List b(ColorLinesWallpaper colorlineswallpaper)
    {
        return colorlineswallpaper.b;
    }

    static boolean b()
    {
        return i;
    }

    static Canvas c()
    {
        return h;
    }

    static boolean c(ColorLinesWallpaper colorlineswallpaper)
    {
        return colorlineswallpaper.g;
    }

    static int d(ColorLinesWallpaper colorlineswallpaper)
    {
        return colorlineswallpaper.e;
    }

    static String d()
    {
        return a;
    }

    static int e(ColorLinesWallpaper colorlineswallpaper)
    {
        return colorlineswallpaper.f;
    }

    public void onCreate()
    {
        super.onCreate();
        Object obj = new DisplayMetrics();
        Display display = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        display.getMetrics(((DisplayMetrics) (obj)));
        obj = new Point();
        display.getSize(((Point) (obj)));
        e = ((Point) (obj)).x;
        f = ((Point) (obj)).y;
    }

    public android.service.wallpaper.WallpaperService.Engine onCreateEngine()
    {
        return new a(this);
    }

    public void onDestroy()
    {
        if (d != null)
        {
            d = null;
        }
        super.onDestroy();
    }

}
