// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class p
{

    public int a;
    public int b;
    String c;
    private ad d;
    private float e;
    private float f;
    private float g;
    private float h;

    public p()
    {
        e = 0.0F;
        f = 50F;
        g = 100F;
        h = 35F;
        a = 0;
        b = 0;
        c = "texture_2_2048.jpg";
    }

    public p(ad ad1)
    {
        e = 0.0F;
        f = 50F;
        g = 100F;
        h = 35F;
        a = 0;
        b = 0;
        c = "texture_2_2048.jpg";
        d = ad1;
        ad1.a("fade", Float.valueOf(e));
        ad1.a("lines", Float.valueOf(f));
        ad1.a("brightness", Float.valueOf(g));
        ad1.a("contrast", Float.valueOf(h));
    }

    public final float a()
    {
        return e;
    }

    public final void a(float f1)
    {
        e = f1;
        if (d != null)
        {
            d.a("fade", Float.valueOf(f1));
        }
    }

    public final float b()
    {
        return g;
    }

    public final void b(float f1)
    {
        f = f1;
        if (d != null)
        {
            d.a("lines", Float.valueOf(f1));
        }
    }

    public final float c()
    {
        return f;
    }

    public final void c(float f1)
    {
        g = f1;
        if (d != null)
        {
            d.a("brightness", Float.valueOf(f1));
        }
    }

    public final float d()
    {
        return h;
    }

    public final void d(float f1)
    {
        h = f1;
        if (d != null)
        {
            d.a("contrast", Float.valueOf(f1));
        }
    }

    // Unreferenced inner class com/socialin/camera/opengl/p$1

/* anonymous class */
    final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private p c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(i).toString());
            c.d(i);
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.d(seekbar.getProgress());
        }

            
            {
                c = p.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/p$2

/* anonymous class */
    final class _cls2
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private p c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(i).toString());
            c.a(i);
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.a(seekbar.getProgress());
        }

            
            {
                c = p.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/p$3

/* anonymous class */
    final class _cls3
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private p c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.b(seekbar.getProgress());
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.b(seekbar.getProgress());
        }

            
            {
                c = p.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/p$4

/* anonymous class */
    final class _cls4
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private p c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.c(seekbar.getProgress());
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.c(seekbar.getProgress());
        }

            
            {
                c = p.this;
                a = textview;
                b = s;
                super();
            }
    }

}
