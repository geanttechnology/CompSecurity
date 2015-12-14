// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class s
{

    public float a;
    public float b;
    public float c;
    private ad d;

    public s()
    {
        a = 240F;
        b = 20F;
        c = 0.0F;
    }

    public s(ad ad1)
    {
        a = 240F;
        b = 20F;
        c = 0.0F;
        d = ad1;
        d();
    }

    public final float a()
    {
        return c;
    }

    final void a(float f)
    {
        a = f;
        if (d != null)
        {
            d.a("hue", Float.valueOf(f));
        }
    }

    public final float b()
    {
        return a;
    }

    final void b(float f)
    {
        b = f;
        if (d != null)
        {
            d.a("replaceDeltaSaturation", Float.valueOf(f));
        }
    }

    public final float c()
    {
        return b;
    }

    final void c(float f)
    {
        c = f;
        if (d != null)
        {
            d.a("fade", Float.valueOf(f));
        }
    }

    public final void d()
    {
        a(240F);
        b(20F);
        c(0.0F);
    }

    // Unreferenced inner class com/socialin/camera/opengl/s$1

/* anonymous class */
    final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private s c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(i).toString());
            c.c(i);
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
                c = s.this;
                a = textview;
                b = s2;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/s$2

/* anonymous class */
    final class _cls2
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private s c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.a(seekbar.getProgress());
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
                c = s.this;
                a = textview;
                b = s2;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/s$3

/* anonymous class */
    final class _cls3
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private s c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.b(seekbar.getProgress() - 50);
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress()).toString());
            c.b(seekbar.getProgress() - 50);
        }

            
            {
                c = s.this;
                a = textview;
                b = s2;
                super();
            }
    }

}
