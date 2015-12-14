// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import com.socialin.android.brushlib.layer.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.socialin.android.brushlib.util:
//            d

public final class c
{

    public final Map a = new HashMap();
    public final Map b = new HashMap();
    final int c;
    final int d;
    Handler e;
    public Bitmap f;
    private ExecutorService g;
    private final Resources h;

    public c(Resources resources, int i, int j)
    {
        g = Executors.newSingleThreadExecutor();
        e = new Handler(Looper.getMainLooper());
        h = resources;
        c = i;
        d = j;
    }

    static void a(c c1, int i, int j)
    {
        if (c1.f == null || c1.f.isRecycled())
        {
            Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            BitmapDrawable bitmapdrawable = (BitmapDrawable)c1.h.getDrawable(0x7f020120);
            bitmapdrawable.setTileModeXY(android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
            bitmapdrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            bitmapdrawable.draw(new Canvas(bitmap));
            c1.f = bitmap;
        }
    }

    public final Bitmap a()
    {
        Bitmap bitmap = Bitmap.createBitmap(c, d, android.graphics.Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(-1);
        return bitmap;
    }

    public final void a(b b1, d d1)
    {
        if (b1.i)
        {
            return;
        }
        if (a.containsKey(b1))
        {
            BitmapDrawable bitmapdrawable1 = (BitmapDrawable)a.get(b1);
            Canvas canvas;
            if (b.containsKey(bitmapdrawable1))
            {
                canvas = (Canvas)b.get(bitmapdrawable1);
            } else
            {
                canvas = new Canvas(bitmapdrawable1.getBitmap());
                b.put(bitmapdrawable1, canvas);
            }
            g.execute(new Runnable(canvas, b1, d1, bitmapdrawable1) {

                final b a;
                final d b;
                private Canvas c;
                private c d;

                public final void run()
                {
                    c.a(d, d.c, d.d);
                    c.save();
                    c.drawBitmap(d.f, 0.0F, 0.0F, null);
                    c.scale((float)d.c / (float)a.i(), (float)d.d / (float)a.j());
                    a.b(c);
                    c.restore();
                    if (b != null)
                    {
                        d.e.post(new Runnable(this) {

                            private _cls1 a;

                            public final void run()
                            {
                                a.b.a(a.a);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }
                }

            
            {
                d = c.this;
                c = canvas;
                a = b1;
                b = d1;
                super();
            }
            });
            return;
        } else
        {
            BitmapDrawable bitmapdrawable = new BitmapDrawable(a());
            a.put(b1, bitmapdrawable);
            Canvas canvas1 = new Canvas(bitmapdrawable.getBitmap());
            b.put(bitmapdrawable, canvas1);
            g.execute(new Runnable(canvas1, b1, d1, bitmapdrawable) {

                final b a;
                final d b;
                private Canvas c;
                private c d;

                public final void run()
                {
                    c.a(d, d.c, d.d);
                    c.save();
                    c.drawBitmap(d.f, 0.0F, 0.0F, null);
                    c.scale((float)d.c / (float)a.i(), (float)d.d / (float)a.j());
                    a.b(c);
                    c.restore();
                    if (b != null)
                    {
                        d.e.post(new Runnable(this) {

                            private _cls2 a;

                            public final void run()
                            {
                                a.b.a(a.a);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }
                }

            
            {
                d = c.this;
                c = canvas;
                a = b1;
                b = d1;
                super();
            }
            });
            return;
        }
    }
}
