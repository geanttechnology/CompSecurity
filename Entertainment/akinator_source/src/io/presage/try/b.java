// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.try;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import io.presage.Presage;
import io.presage.formats.multiwebviews.do.a;
import io.presage.model.Zone;
import io.presage.utils.n;
import shared_presage.com.google.android.exoplayer.AspectRatioFrameLayout;

// Referenced classes of package io.presage.try:
//            a, c

public final class b extends FrameLayout
    implements android.view.SurfaceHolder.Callback, io.presage.formats.multiwebviews.do.a.c, io.presage.try.a
{

    private a a;
    private String b;
    private AspectRatioFrameLayout c;
    private SurfaceView d;
    private int e;
    private a.a f;
    private android.view.View.OnTouchListener g;

    private b(Context context)
    {
        super(context);
        g = new io.presage.utils.b(new c(this));
    }

    static a.a a(b b1)
    {
        return b1.f;
    }

    public static b a(Context context, Zone zone)
    {
        b b1 = new b(context);
        String s = zone.getBackground();
        if (s != null)
        {
            b1.e = Color.parseColor(s);
        } else
        {
            b1.e = 0xff000000;
        }
        b1.setBackgroundColor(b1.e);
        b1.b = zone.getName();
        b1.d = new SurfaceView(context);
        b1.a = new a(context, zone.getName(), Presage.getInstance().getWS().b(), zone.getUrl(), zone.isVideoAutoPlay(), zone.isVideoMuted(), b1.d);
        b1.a.a(b1);
        b1.c = new AspectRatioFrameLayout(context);
        context = new android.widget.FrameLayout.LayoutParams(-1, -1);
        context.gravity = 17;
        b1.d.getHolder().addCallback(b1);
        b1.c.addView(b1.d, context);
        b1.addView(b1.c, context);
        b1.setLayoutParams(n.a(zone));
        b1.setOnTouchListener(b1.g);
        return b1;
    }

    public final String a()
    {
        return b;
    }

    public final void a(int i, int j, float f1)
    {
        if (c != null)
        {
            AspectRatioFrameLayout aspectratioframelayout = c;
            if (j == 0)
            {
                f1 = 1.0F;
            } else
            {
                f1 = ((float)i * f1) / (float)j;
            }
            aspectratioframelayout.setAspectRatio(f1);
        }
    }

    public final void a(a.a a1)
    {
        f = a1;
    }

    public final a b()
    {
        return a;
    }

    public final void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public final void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Paint paint = new Paint();
        paint.setColor(e);
        Canvas canvas = surfaceholder.lockCanvas();
        canvas.drawPaint(paint);
        surfaceholder.unlockCanvasAndPost(canvas);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }
}
