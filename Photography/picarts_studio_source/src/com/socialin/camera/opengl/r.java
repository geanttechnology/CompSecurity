// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class r
{

    public float a;
    public float b;
    public float c;
    private ad d;

    public r()
    {
        a = 0.0F;
        b = 3F;
        c = 3F;
    }

    public r(ad ad1)
    {
        a = 0.0F;
        b = 3F;
        c = 3F;
        d = ad1;
        ad1.a("fade", Float.valueOf(a));
        ad1.a("leftU", Float.valueOf(b));
        ad1.a("right", Float.valueOf(c));
    }

    public final float a()
    {
        return a;
    }

    public final void a(float f)
    {
        a = f;
        if (d != null)
        {
            d.a("fade", Float.valueOf(f));
        }
    }

    public final float b()
    {
        return c;
    }

    public final void b(float f)
    {
        b = f;
        if (d != null)
        {
            d.a("leftU", Float.valueOf(f));
        }
    }

    public final float c()
    {
        return b;
    }

    public final void c(float f)
    {
        c = f;
        if (d != null)
        {
            d.a("right", Float.valueOf(f));
        }
    }

    // Unreferenced inner class com/socialin/camera/opengl/r$1

/* anonymous class */
    final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private r c;

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
                c = r.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/r$2

/* anonymous class */
    final class _cls2
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private r c;

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
                c = r.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/r$3

/* anonymous class */
    final class _cls3
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private r c;

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
                c = r.this;
                a = textview;
                b = s;
                super();
            }
    }

}
