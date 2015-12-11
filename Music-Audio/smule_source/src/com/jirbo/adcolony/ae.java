// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import java.io.FileInputStream;

// Referenced classes of package com.jirbo.adcolony:
//            ad, af, bl, ak, 
//            cx, m, be, aa, 
//            bd, o, ab, db, 
//            AdColonyOverlay, bq, ay, bo, 
//            cz, AdColonyFullscreen

class ae extends TextureView
    implements android.view.TextureView.SurfaceTextureListener
{

    boolean a;
    boolean b;
    final ad c;

    ae(ad ad1, Context context, boolean flag)
    {
        c = ad1;
        super(context);
        a = false;
        b = false;
        setSurfaceTextureListener(this);
        setWillNotDraw(false);
        setBackgroundColor(0xff000000);
        a = flag;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        if (surfacetexture == null)
        {
            c.p = true;
            c.I.setVisibility(8);
        } else
        {
            c.J.setVisibility(0);
            c.e = surfacetexture;
            if (!c.p && !a)
            {
                c.U = new Surface(surfacetexture);
                if (c.T != null)
                {
                    c.T.release();
                }
                c.f = i;
                c.g = j;
                c.T = new MediaPlayer();
                try
                {
                    c.ax = new FileInputStream(c.c);
                    c.T.setDataSource(c.ax.getFD());
                    c.T.setSurface(c.U);
                    c.T.setOnCompletionListener(c);
                    c.T.setOnPreparedListener(c);
                    c.T.setOnErrorListener(c);
                    c.T.prepareAsync();
                    bl.c.b("[ADC] Native Ad Prepare called.");
                    b = true;
                    surfacetexture = new Handler();
                    Runnable runnable = new Runnable() {

                        final ae a;

                        public void run()
                        {
                            if (!a.c.t && !a.c.u)
                            {
                                a.b = false;
                                a.c.p = true;
                                a.c.I.setVisibility(8);
                            }
                        }

            
            {
                a = ae.this;
                super();
            }
                    };
                    if (!b)
                    {
                        surfacetexture.postDelayed(runnable, 1800L);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (SurfaceTexture surfacetexture)
                {
                    c.p = true;
                    c.I.setVisibility(8);
                    return;
                }
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        bl.c.b("[ADC] Native surface destroyed");
        c.t = false;
        c.I.setVisibility(4);
        c.J.setVisibility(0);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
        bl.c.b("[ADC] onSurfaceTextureSizeChanged");
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        if (i == 1 && ak.m && cx.c() && (f <= (float)((c.aj - c.G.f) + 8) || f1 >= (float)(c.G.g + 8) || c.p || c.T == null || !c.T.isPlaying()))
        {
            ak.A = c.C;
            ak.c.a.a(c.b, c.C.d);
            o.a();
            c.C.e = "native";
            c.C.f = "fullscreen";
            c.C.m = true;
            c.C.n = c.w;
            if ((c.t || c.p) && cx.c())
            {
                if (c.D != null)
                {
                    c.D.a(true, c);
                }
                if (c.T != null && c.T.isPlaying())
                {
                    o.c = c.T.getCurrentPosition();
                    c.C.j = c.C.i;
                    c.T.pause();
                    c.p = true;
                } else
                {
                    c.C.j = 0.0D;
                    o.c = 0;
                }
                ak.m = false;
                ak.c.d.b("video_expanded", c.C);
                if (ak.d)
                {
                    bl.a.b("Launching AdColonyOverlay");
                    ak.b().startActivity(new Intent(ak.b(), com/jirbo/adcolony/AdColonyOverlay));
                } else
                {
                    bl.a.b("Launching AdColonyFullscreen");
                    ak.b().startActivity(new Intent(ak.b(), com/jirbo/adcolony/AdColonyFullscreen));
                }
                if (c.p)
                {
                    motionevent = c.C.c.k;
                    motionevent.d = ((ay) (motionevent)).d + 1;
                    ak.c.a("start", (new StringBuilder()).append("{\"ad_slot\":").append(c.C.c.k.d).append(", \"replay\":").append(c.C.n).append("}").toString(), c.C);
                    ak.c.h.a(c.C.b, c.C.d.d);
                }
                c.w = true;
                return true;
            }
        }
        return true;
    }
}
