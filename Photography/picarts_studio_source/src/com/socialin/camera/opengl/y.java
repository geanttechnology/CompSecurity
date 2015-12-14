// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.picsin.camera.CameraMainActivity;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class y
{

    ad a;
    float b;
    float c;
    float d;
    private Activity e;

    public y(Activity activity, ad ad1)
    {
        e = activity;
        a = ad1;
        a(false);
    }

    final float a()
    {
        return b;
    }

    public final void a(float f, boolean flag)
    {
        b = f;
        if (e != null && flag)
        {
            CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)e).h;
            if (cameraopenglsurfaceview != null)
            {
                cameraopenglsurfaceview.queueEvent(new Runnable() {

                    private y a;

                    public final void run()
                    {
                        a.a.a("deltaHue", Float.valueOf(a.b));
                    }

            
            {
                a = y.this;
                super();
            }
                });
                return;
            } else
            {
                a.a("deltaHue", Float.valueOf(f));
                return;
            }
        } else
        {
            a.a("deltaHue", Float.valueOf(f));
            return;
        }
    }

    public final void a(boolean flag)
    {
        a(6F, flag);
        b(10F, flag);
        c(20F, flag);
    }

    final float b()
    {
        return c;
    }

    public final void b(float f, boolean flag)
    {
        c = f;
        if (e != null && flag)
        {
            CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)e).h;
            if (cameraopenglsurfaceview != null)
            {
                cameraopenglsurfaceview.queueEvent(new Runnable() {

                    private y a;

                    public final void run()
                    {
                        a.a.a("deltaSaturation", Float.valueOf(a.c));
                    }

            
            {
                a = y.this;
                super();
            }
                });
                return;
            } else
            {
                a.a("deltaSaturation", Float.valueOf(f));
                return;
            }
        } else
        {
            a.a("deltaSaturation", Float.valueOf(f));
            return;
        }
    }

    final float c()
    {
        return d;
    }

    public final void c(float f, boolean flag)
    {
        d = f;
        if (e != null && flag)
        {
            CameraOpenGlSurfaceView cameraopenglsurfaceview = ((CameraMainActivity)e).h;
            if (cameraopenglsurfaceview != null)
            {
                cameraopenglsurfaceview.queueEvent(new Runnable() {

                    private y a;

                    public final void run()
                    {
                        a.a.a("deltaLightness", Float.valueOf(a.d));
                    }

            
            {
                a = y.this;
                super();
            }
                });
                return;
            } else
            {
                a.a("deltaLightness", Float.valueOf(f));
                return;
            }
        } else
        {
            a.a("deltaLightness", Float.valueOf(f));
            return;
        }
    }

    // Unreferenced inner class com/socialin/camera/opengl/y$4

/* anonymous class */
    final class _cls4
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private y c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress() + 5).toString());
            c.c(seekbar.getProgress() + 5, true);
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress() + 5).toString());
            c.c(seekbar.getProgress() + 5, true);
        }

            
            {
                c = y.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/y$5

/* anonymous class */
    final class _cls5
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private y c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            c.a(seekbar.getProgress() + 5, true);
            a.setText((new StringBuilder()).append(b).append(" : ").append((int)c.b).toString());
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            c.a(seekbar.getProgress() + 5, true);
            a.setText((new StringBuilder()).append(b).append(" : ").append((int)c.b).toString());
        }

            
            {
                c = y.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/y$6

/* anonymous class */
    final class _cls6
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private y c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            c.b(seekbar.getProgress() + 5, true);
            a.setText((new StringBuilder()).append(b).append(" : ").append((int)c.c).toString());
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            c.b(seekbar.getProgress() + 5, true);
            a.setText((new StringBuilder()).append(b).append(" : ").append((int)c.c).toString());
        }

            
            {
                c = y.this;
                a = textview;
                b = s;
                super();
            }
    }

}
