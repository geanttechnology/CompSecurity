// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.picsin.camera.CameraMainActivity;

// Referenced classes of package com.socialin.camera.opengl:
//            ad, a

public final class d
{

    ad a;
    LinearLayout b;
    float c;
    final a d;

    public d(a a1, ad ad1)
    {
        d = a1;
        super();
        c = 0.0F;
        a = ad1;
        ad1.a("fade", Float.valueOf(c));
    }

    public final void a(float f, boolean flag)
    {
label0:
        {
label1:
            {
                c = f;
                if (a != null)
                {
                    if (com.socialin.camera.opengl.a.c(d) == null || !flag)
                    {
                        break label0;
                    }
                    CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)com.socialin.camera.opengl.a.c(d)).h;
                    if (cameraopenglsurfaceview == null)
                    {
                        break label1;
                    }
                    cameraopenglsurfaceview.queueEvent(new Runnable() {

                        private d a;

                        public final void run()
                        {
                            a.a.a("fade", Float.valueOf(a.c));
                        }

            
            {
                a = d.this;
                super();
            }
                    });
                }
                return;
            }
            a.a("fade", Float.valueOf(f));
            return;
        }
        a.a("fade", Float.valueOf(f));
    }

    // Unreferenced inner class com/socialin/camera/opengl/d$2

/* anonymous class */
    final class _cls2
        implements Runnable
    {

        private d a;

        public final void run()
        {
            String s = com.socialin.camera.opengl.a.c(a.d).getString(0x7f0801bc);
            ((TextView)a.b.findViewById(0x7f100400)).setText((new StringBuilder()).append(s).append(" : ").append(a.c).toString());
            ((SeekBar)a.b.findViewById(0x7f100401)).setProgress((int)a.c);
        }

            
            {
                a = d.this;
                super();
            }
    }

}
