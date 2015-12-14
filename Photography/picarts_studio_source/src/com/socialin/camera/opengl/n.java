// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;

// Referenced classes of package com.socialin.camera.opengl:
//            ad, o

public final class n
{

    private static final Integer l = Integer.valueOf(0x7f100240);
    public float a;
    public Integer b;
    public int c;
    ad d;
    public o e;
    boolean f;
    public int g;
    public int h;
    public ByteBuffer i;
    public int j;
    public boolean k;
    private ImageView m;
    private Bitmap n;

    public n()
    {
        a = 0.0F;
        b = l;
        c = 0;
        f = false;
        g = 0;
        h = 0;
        i = null;
        j = 0;
        k = false;
    }

    public n(ad ad1)
    {
        a = 0.0F;
        b = l;
        c = 0;
        f = false;
        g = 0;
        h = 0;
        i = null;
        j = 0;
        k = false;
        d = ad1;
    }

    public static int a(Integer integer)
    {
        int i1 = 0;
        if (integer.intValue() == 0x7f100240)
        {
            i1 = 1;
        } else
        {
            if (integer.intValue() == 0x7f100241)
            {
                return 2;
            }
            if (integer.intValue() == 0x7f100242)
            {
                return 3;
            }
            if (integer.intValue() == 0x7f100243)
            {
                return 4;
            }
        }
        return i1;
    }

    static Bitmap a(n n1, Bitmap bitmap)
    {
        n1.n = bitmap;
        return bitmap;
    }

    static o a(n n1)
    {
        return n1.e;
    }

    private void a(float f1)
    {
        a = f1;
        if (d != null)
        {
            d.a("fade", Float.valueOf(f1));
        }
    }

    static void a(n n1, float f1)
    {
        n1.a(f1);
    }

    static void a(n n1, int i1)
    {
        n1.b(i1);
    }

    static int b(n n1)
    {
        return n1.g;
    }

    private void b(int i1)
    {
        b = Integer.valueOf(i1);
        if (d != null)
        {
            d.a("blendMode", Integer.valueOf(a(Integer.valueOf(i1))));
        }
    }

    static int c(n n1)
    {
        return n1.h;
    }

    static ImageView d(n n1)
    {
        return n1.m;
    }

    public final ByteBuffer a()
    {
        return i;
    }

    public final void a(int i1)
    {
        c = i1;
        if (d != null)
        {
            d.a("invertYCoord", Integer.valueOf(i1));
        }
    }

    public final void a(Activity activity, boolean flag, LinearLayout linearlayout)
    {
        Object obj;
        SeekBar seekbar;
        if (flag)
        {
            b(l.intValue());
            a(0.0F);
            a(0);
        } else
        {
            b(b.intValue());
            a(a);
            a(c);
        }
        obj = (RadioGroup)linearlayout.findViewById(0x7f10023e);
        ((RadioGroup) (obj)).check(b.intValue());
        ((RadioGroup) (obj)).setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            private n a;

            public final void onCheckedChanged(RadioGroup radiogroup, int i1)
            {
                n.a(a, i1);
            }

            
            {
                a = n.this;
                super();
            }
        });
        activity = activity.getString(0x7f0801bc);
        obj = (TextView)linearlayout.findViewById(0x7f100247);
        ((TextView) (obj)).setText((new StringBuilder()).append(activity).append(" : ").append((int)a).toString());
        seekbar = (SeekBar)linearlayout.findViewById(0x7f100248);
        seekbar.setMax(100);
        seekbar.setProgress((int)a);
        seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(((TextView) (obj)), activity) {

            private TextView a;
            private String b;
            private n c;

            public final void onProgressChanged(SeekBar seekbar1, int i1, boolean flag1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(i1).toString());
                n.a(c, i1);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                n.a(c, seekbar1.getProgress());
            }

            
            {
                c = n.this;
                a = textview;
                b = s;
                super();
            }
        });
        linearlayout.findViewById(0x7f100245).setOnClickListener(new android.view.View.OnClickListener() {

            private n a;

            public final void onClick(View view)
            {
                if (n.a(a) != null && a.i != null && n.b(a) > 0 && com.socialin.camera.opengl.n.c(a) > 0)
                {
                    view = com.socialin.android.util.c.a(n.b(a), com.socialin.camera.opengl.n.c(a), android.graphics.Bitmap.Config.ARGB_8888);
                    a.i.position(0);
                    view.copyPixelsFromBuffer(a.i);
                    a.i.position(0);
                    n.a(a).a(view, a.j, a.k);
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
        linearlayout.findViewById(0x7f100246).setOnClickListener(new android.view.View.OnClickListener() {

            private n a;

            public final void onClick(View view)
            {
                if (n.a(a) != null)
                {
                    n.a(a).c();
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
        m = (ImageView)linearlayout.findViewById(0x7f100244);
        if (n != null && !n.isRecycled())
        {
            m.setImageBitmap(n);
        }
    }

    public final void b()
    {
        a(0);
        f = true;
        if (i != null)
        {
            ImageOpCommon.freeNativeBuffer(i);
            i = null;
        }
    }

    public final void c()
    {
        if (m != null)
        {
            m.setImageBitmap(null);
            if (n != null && !n.isRecycled())
            {
                n.recycle();
            }
        }
        n = null;
        m = null;
    }


    // Unreferenced inner class com/socialin/camera/opengl/n$5

/* anonymous class */
    public final class _cls5
        implements Runnable
    {

        private Bitmap a;
        private n b;

        public final void run()
        {
            if (n.d(b) != null)
            {
                n.a(b, a);
                n.d(b).setImageBitmap(a);
            }
        }

            public 
            {
                b = n.this;
                a = bitmap;
                super();
            }
    }

}
