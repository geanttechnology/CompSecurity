// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class aa
{

    public float a;
    public float b;
    private ad c;

    public aa()
    {
    }

    public aa(ad ad1)
    {
        c = ad1;
        c();
    }

    public final float a()
    {
        return a;
    }

    final void a(float f)
    {
        a = f;
        if (c != null)
        {
            c.a("radiusPercent", Float.valueOf(f));
        }
    }

    public final float b()
    {
        return b;
    }

    final void b(float f)
    {
        b = f;
        if (c != null)
        {
            c.a("angle", Float.valueOf((float)(((double)f * 3.1415926535897931D) / 180D / 2D)));
        }
    }

    public final void c()
    {
        a(50F);
        b(20F);
    }

    // Unreferenced inner class com/socialin/camera/opengl/aa$1

/* anonymous class */
    final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private aa c;

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
                c = aa.this;
                a = textview;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/aa$2

/* anonymous class */
    final class _cls2
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private String b;
        private aa c;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress() - 180).toString());
            c.b(seekbar.getProgress() - 180);
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar.getProgress() - 180).toString());
            c.b(seekbar.getProgress() - 180);
        }

            
            {
                c = aa.this;
                a = textview;
                b = s;
                super();
            }
    }

}
