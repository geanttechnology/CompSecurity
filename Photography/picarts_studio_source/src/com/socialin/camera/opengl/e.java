// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.opengl.GLSurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.camera.masks.a;
import com.socialin.picsin.camera.CameraMainActivity;

// Referenced classes of package com.socialin.camera.opengl:
//            ad, a

public final class e
{

    ad a;
    public float b;
    int c;
    int d;
    public int e;
    public String f;
    a g;
    final com.socialin.camera.opengl.a h;

    public e(com.socialin.camera.opengl.a a1, ad ad1)
    {
        h = a1;
        super();
        b = 0.0F;
        c = -1;
        d = -1;
        f = null;
        g = null;
        a = ad1;
        ad1.a("fade", Float.valueOf(b));
        a(0);
    }

    public final void a(float f1, boolean flag)
    {
label0:
        {
label1:
            {
                b = f1;
                if (a != null)
                {
                    if (com.socialin.camera.opengl.a.c(h) == null || !flag)
                    {
                        break label0;
                    }
                    CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)com.socialin.camera.opengl.a.c(h)).h;
                    if (cameraopenglsurfaceview == null)
                    {
                        break label1;
                    }
                    cameraopenglsurfaceview.queueEvent(new Runnable() {

                        private e a;

                        public final void run()
                        {
                            a.a.a("fade", Float.valueOf(a.b));
                        }

            
            {
                a = e.this;
                super();
            }
                    });
                }
                return;
            }
            a.a("fade", Float.valueOf(f1));
            return;
        }
        a.a("fade", Float.valueOf(f1));
    }

    public final void a(int i)
    {
        e = i;
        com.socialin.camera.opengl.a.c(h);
        a.a("blendMode", Integer.valueOf(i));
    }

    // Unreferenced inner class com/socialin/camera/opengl/e$2

/* anonymous class */
    final class _cls2
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private e c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(i).toString());
            c.a(i, true);
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.a(seekbar.getProgress(), true);
        }

            
            {
                c = e.this;
                a = textview;
                b = s;
                super();
            }
    }

}
