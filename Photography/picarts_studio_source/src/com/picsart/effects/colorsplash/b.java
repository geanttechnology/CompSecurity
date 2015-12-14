// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;

// Referenced classes of package com.picsart.effects.colorsplash:
//            c, d, f, ColorSplashActivity, 
//            MyGLSurfaceView

public final class b
{

    Activity a;
    public c b;
    d c;
    int d;
    boolean e;
    boolean f;

    public b(Activity activity, int i)
    {
        a = null;
        e = true;
        f = false;
        a = activity;
        d = i;
        b = new c(this);
        c = new d();
        b.a = new f();
        b.a();
        activity = a.getLayoutInflater().inflate(0x7f030074, null);
        b.e = (LinearLayout)activity;
        Object obj = (SeekBar)b.e.findViewById(0x7f1002cb);
        ((SeekBar) (obj)).setMax(80);
        ((SeekBar) (obj)).setProgress(30);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private b a;

            public final void onProgressChanged(SeekBar seekbar, int j, boolean flag)
            {
                a.b.c(seekbar.getProgress());
                ((ColorSplashActivity)a.a).b.requestRender();
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.b.c(seekbar.getProgress());
                ((ColorSplashActivity)a.a).b.requestRender();
                a.f = true;
            }

            
            {
                a = b.this;
                super();
            }
        });
        obj = (SeekBar)b.e.findViewById(0x7f1002ce);
        ((SeekBar) (obj)).setMax(80);
        ((SeekBar) (obj)).setProgress(30);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private b a;

            public final void onProgressChanged(SeekBar seekbar, int j, boolean flag)
            {
                a.b.b(seekbar.getProgress());
                ((ColorSplashActivity)a.a).b.requestRender();
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                a.b.b(seekbar.getProgress());
                ((ColorSplashActivity)a.a).b.requestRender();
                a.f = true;
            }

            
            {
                a = b.this;
                super();
            }
        });
        obj = (SeekBar)b.e.findViewById(0x7f1002c8);
        if (i == 1)
        {
            ((SeekBar) (obj)).setVisibility(8);
            b.e.findViewById(0x7f1002c6).setVisibility(8);
            b.e.findViewById(0x7f1002c7).setVisibility(8);
            obj = (RadioGroup)b.e.findViewById(0x7f1002cf);
            ((RadioGroup) (obj)).check(0x7f1002d0);
            b.a(0);
            ((RadioGroup) (obj)).setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

                private b a;

                public final void onCheckedChanged(RadioGroup radiogroup, int j)
                {
                    if (j == 0x7f1002d0)
                    {
                        a.e = true;
                        a.f = true;
                        a.b.a(0);
                        ((ColorSplashActivity)a.a).b(0);
                        return;
                    } else
                    {
                        a.f = true;
                        a.e = false;
                        a.b.a(1);
                        ((ColorSplashActivity)a.a).b(1);
                        return;
                    }
                }

            
            {
                a = b.this;
                super();
            }
            });
        } else
        {
            b.e.findViewById(0x7f1002cf).setVisibility(8);
            ((SeekBar) (obj)).setMax(360);
            ((SeekBar) (obj)).setProgress(240);
            b.a.a("replaceHue", Float.valueOf(240F));
            ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

                private b a;

                public final void onProgressChanged(SeekBar seekbar, int j, boolean flag)
                {
                    a.b.d(seekbar.getProgress());
                    ((ColorSplashActivity)a.a).b.requestRender();
                }

                public final void onStartTrackingTouch(SeekBar seekbar)
                {
                }

                public final void onStopTrackingTouch(SeekBar seekbar)
                {
                    a.f = true;
                    a.b.d(seekbar.getProgress());
                    ((ColorSplashActivity)a.a).b.requestRender();
                }

            
            {
                a = b.this;
                super();
            }
            });
        }
        activity.findViewById(0x7f1002c4).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                if (a.a != null)
                {
                    ((ColorSplashActivity)a.a).c(false);
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        activity.findViewById(0x7f1002c5).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                if (a.b == null) goto _L2; else goto _L1
_L1:
                int j = a.b.l;
                if (a.a == null) goto _L2; else goto _L3
_L3:
                ColorSplashActivity colorsplashactivity;
                colorsplashactivity = (ColorSplashActivity)a.a;
                view = Integer.valueOf(0x7f1002b5);
                j;
                JVM INSTR tableswitch 0 2: default 76
            //                           0 333
            //                           1 342
            //                           2 351;
                   goto _L4 _L5 _L6 _L7
_L4:
                break; /* Loop/switch isn't completed */
_L7:
                break MISSING_BLOCK_LABEL_351;
_L8:
                ((ImageView)colorsplashactivity.findViewById(view.intValue())).setBackgroundResource(0x7f0203b6);
                view = a.b;
                ((c) (view)).h[j] = -1F;
                ((c) (view)).j[j] = -1F;
                ((c) (view)).k[j] = -1F;
                ((c) (view)).i[j] = 240F;
                if (((c) (view)).a != null)
                {
                    ((c) (view)).a.a((new StringBuilder("minHue")).append(j + 1).toString(), Float.valueOf(-1F));
                    ((c) (view)).a.a((new StringBuilder("maxHue")).append(j + 1).toString(), Float.valueOf(-1F));
                    if (((c) (view)).m.d == 0)
                    {
                        ((c) (view)).a.a((new StringBuilder("replaceHue")).append(j + 1).toString(), Float.valueOf(240F));
                        ((c) (view)).a.a((new StringBuilder("selectedColorHue")).append(j + 1).toString(), Float.valueOf(-1F));
                    }
                }
                j = a.b.b();
                if (j != -1)
                {
                    a.b.b(j);
                    ((ColorSplashActivity)a.a).a();
                } else
                {
                    a.b.b(0);
                    ((ColorSplashActivity)a.a).c(true);
                    j = 0;
                }
                view = (ColorSplashActivity)a.a;
                if (j == 0)
                {
                    j = 0x7f1002b4;
                } else
                if (j == 1)
                {
                    j = 0x7f1002b6;
                } else
                {
                    j = 0x7f1002b8;
                }
                view.a(j);
_L2:
                return;
_L5:
                view = Integer.valueOf(0x7f1002b5);
                  goto _L8
_L6:
                view = Integer.valueOf(0x7f1002b7);
                  goto _L8
                view = Integer.valueOf(0x7f1002b9);
                  goto _L8
            }

            
            {
                a = b.this;
                super();
            }
        });
    }
}
