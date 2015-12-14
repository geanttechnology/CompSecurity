// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class q
{

    public float a;
    public float b;
    public float c;
    public int d;
    public int e;
    public String f;
    private ad g;

    public q()
    {
        a = 0.0F;
        b = 25F;
        c = 25F;
        d = 0;
        e = 0;
        f = "texture_4_2048.jpg";
    }

    public q(ad ad1)
    {
        a = 0.0F;
        b = 25F;
        c = 25F;
        d = 0;
        e = 0;
        f = "texture_4_2048.jpg";
        g = ad1;
        ad1.a("fade", Float.valueOf(a));
        ad1.a("leftU", Float.valueOf(b));
        ad1.a("right", Float.valueOf(c));
    }

    public final float a()
    {
        return a;
    }

    public final void a(float f1)
    {
        a = f1;
        if (g != null)
        {
            g.a("fade", Float.valueOf(f1));
        }
    }

    public final float b()
    {
        return c;
    }

    public final void b(float f1)
    {
        b = f1;
        if (g != null)
        {
            g.a("leftU", Float.valueOf(f1));
        }
    }

    public final float c()
    {
        return b;
    }

    public final void c(float f1)
    {
        c = f1;
        if (g != null)
        {
            g.a("right", Float.valueOf(f1));
        }
    }

    // Unreferenced inner class com/socialin/camera/opengl/q$1

/* anonymous class */
    final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private q c;

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
                c = q.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/q$2

/* anonymous class */
    final class _cls2
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private q c;

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
                c = q.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/q$3

/* anonymous class */
    final class _cls3
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private q c;

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
                c = q.this;
                a = textview;
                b = s;
                super();
            }
    }

}
