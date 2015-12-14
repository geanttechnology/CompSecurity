// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.picsin.camera.CameraMainActivity;

// Referenced classes of package com.socialin.camera.opengl:
//            ad, a

public final class b
{

    float a;
    ad b;
    LinearLayout c;
    int d;
    private float e;
    private float f;
    private a g;

    public b(a a1)
    {
        g = a1;
        super();
        a = 240F;
        e = 30F;
        f = 30F;
        d = 0xff0000ff;
    }

    final void a()
    {
        float f2 = a - e;
        float f1 = f2;
        if (f2 < 0.0F)
        {
            f1 = f2 + 360F;
        }
        b.a("minHue", Float.valueOf(f1));
    }

    public final void a(float f1)
    {
        e = f1;
        if (com.socialin.camera.opengl.a.c(g) != null)
        {
            CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)com.socialin.camera.opengl.a.c(g)).h;
            if (cameraopenglsurfaceview != null)
            {
                cameraopenglsurfaceview.queueEvent(new Runnable() {

                    private b a;

                    public final void run()
                    {
                        a.a();
                    }

            
            {
                a = b.this;
                super();
            }
                });
                return;
            } else
            {
                a();
                return;
            }
        } else
        {
            a();
            return;
        }
    }

    public final void a(int i, float f1, boolean flag)
    {
        d = i;
        a = f1;
        if (c != null)
        {
            com.socialin.camera.opengl.a.c(g).runOnUiThread(new Runnable(i) {

                private int a;
                private b b;

                public final void run()
                {
                    b.c.findViewById(0x7f1002be).setBackgroundColor(a);
                }

            
            {
                b = b.this;
                a = i;
                super();
            }
            });
        }
        View view = c.findViewById(0x7f1002c1);
        if (view != null && flag)
        {
            String s = com.socialin.camera.opengl.a.c(g).getString(0x7f0801d8);
            ((TextView)c.findViewById(0x7f1002c0)).setText((new StringBuilder()).append(s).append(" : 30").toString());
            ((SeekBar)view).setProgress(30);
        }
        a(30F);
        view = c.findViewById(0x7f1002c3);
        if (view != null && flag)
        {
            String s1 = com.socialin.camera.opengl.a.c(g).getString(0x7f0801d6);
            ((TextView)c.findViewById(0x7f1002c2)).setText((new StringBuilder()).append(s1).append(" : 30").toString());
            ((SeekBar)view).setProgress(30);
        }
        b(30F);
    }

    final void b()
    {
        float f2 = a + f;
        float f1 = f2;
        if (f2 > 360F)
        {
            f1 = f2 - 360F;
        }
        b.a("maxHue", Float.valueOf(f1));
    }

    public final void b(float f1)
    {
        f = f1;
        if (com.socialin.camera.opengl.a.c(g) != null)
        {
            CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)com.socialin.camera.opengl.a.c(g)).h;
            if (cameraopenglsurfaceview != null)
            {
                cameraopenglsurfaceview.queueEvent(new Runnable() {

                    private b a;

                    public final void run()
                    {
                        a.b();
                    }

            
            {
                a = b.this;
                super();
            }
                });
                return;
            } else
            {
                b();
                return;
            }
        } else
        {
            b();
            return;
        }
    }
}
