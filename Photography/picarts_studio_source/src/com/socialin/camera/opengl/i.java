// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class i
{

    private ad a;
    private float b;
    private float c;
    private float d;

    public i()
    {
        b = 0.0F;
        c = 80F;
        d = 80F;
    }

    public i(ad ad1)
    {
        b = 0.0F;
        c = 80F;
        d = 80F;
        a = ad1;
        ad1.a("fade", Float.valueOf(b));
        ad1.a("lines", Float.valueOf(c));
        ad1.a("brightness", Float.valueOf(d));
    }

    public final float a()
    {
        return b;
    }

    public final void a(float f)
    {
        b = f;
        if (a != null)
        {
            a.a("fade", Float.valueOf(f));
        }
    }

    public final float b()
    {
        return d;
    }

    public final void b(float f)
    {
        c = f;
        if (a != null)
        {
            a.a("lines", Float.valueOf(f));
        }
    }

    public final float c()
    {
        return c;
    }

    public final void c(float f)
    {
        d = f;
        if (a != null)
        {
            a.a("brightness", Float.valueOf(f));
        }
    }

    // Unreferenced inner class com/socialin/camera/opengl/i$1

/* anonymous class */
    final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private i c;

        public final void onProgressChanged(SeekBar seekbar, int j, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(j).toString());
            c.a(j);
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
                c = i.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/i$2

/* anonymous class */
    final class _cls2
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private i c;

        public final void onProgressChanged(SeekBar seekbar, int j, boolean flag)
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
                c = i.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/i$3

/* anonymous class */
    final class _cls3
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private i c;

        public final void onProgressChanged(SeekBar seekbar, int j, boolean flag)
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
                c = i.this;
                a = textview;
                b = s;
                super();
            }
    }

}
