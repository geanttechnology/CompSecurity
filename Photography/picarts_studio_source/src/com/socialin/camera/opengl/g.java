// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.picsin.camera.CameraMainActivity;

// Referenced classes of package com.socialin.camera.opengl:
//            ad, a

public final class g
{

    int a;
    float b;
    ad c;
    LinearLayout d;
    final a e;

    public g(a a1, ad ad1)
    {
        e = a1;
        super();
        a = 0;
        b = 0.0F;
        d = null;
        c = ad1;
        ad1.a("mode", Integer.valueOf(a));
        ad1.a("fade", Float.valueOf(b));
    }

    public final void a(float f, boolean flag)
    {
label0:
        {
label1:
            {
                b = f;
                if (c != null)
                {
                    if (com.socialin.camera.opengl.a.c(e) == null || !flag)
                    {
                        break label0;
                    }
                    CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)com.socialin.camera.opengl.a.c(e)).h;
                    if (cameraopenglsurfaceview == null)
                    {
                        break label1;
                    }
                    cameraopenglsurfaceview.queueEvent(new Runnable() {

                        private g a;

                        public final void run()
                        {
                            a.c.a("fade", Float.valueOf(a.b));
                        }

            
            {
                a = g.this;
                super();
            }
                    });
                }
                return;
            }
            c.a("fade", Float.valueOf(f));
            return;
        }
        c.a("fade", Float.valueOf(f));
    }

    public final void a(int i, boolean flag)
    {
label0:
        {
label1:
            {
                a = i;
                if (c != null)
                {
                    if (com.socialin.camera.opengl.a.c(e) == null || !flag)
                    {
                        break label0;
                    }
                    CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)com.socialin.camera.opengl.a.c(e)).h;
                    if (cameraopenglsurfaceview == null)
                    {
                        break label1;
                    }
                    cameraopenglsurfaceview.queueEvent(new Runnable() {

                        private g a;

                        public final void run()
                        {
                            a.c.a("mode", Integer.valueOf(a.a));
                        }

            
            {
                a = g.this;
                super();
            }
                    });
                }
                return;
            }
            c.a("mode", Integer.valueOf(i));
            return;
        }
        c.a("mode", Integer.valueOf(i));
    }

    // Unreferenced inner class com/socialin/camera/opengl/g$3

/* anonymous class */
    final class _cls3
        implements Runnable
    {

        private g a;

        public final void run()
        {
            String s = com.socialin.camera.opengl.a.c(a.e).getString(0x7f0801bc);
            ((TextView)a.d.findViewById(0x7f1004a7)).setText((new StringBuilder()).append(s).append(" : ").append(a.b).toString());
            ((SeekBar)a.d.findViewById(0x7f1004a8)).setProgress((int)a.b);
            ((RadioButton)a.d.findViewById(0x7f1004a5)).setChecked(true);
        }

            
            {
                a = g.this;
                super();
            }
    }

}
