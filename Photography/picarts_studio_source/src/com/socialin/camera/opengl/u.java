// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import java.lang.reflect.Array;

// Referenced classes of package com.socialin.camera.opengl:
//            ad

public final class u
{

    private int a[][];
    private ad b;
    private float c;
    private float d;
    private float e;
    private int f;

    public u()
    {
        a = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            5, 3
        });
        c = 0.0F;
        d = 0.0F;
        e = 0.45F;
        f = 0;
        a();
    }

    public u(ad ad1)
    {
        a = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            5, 3
        });
        c = 0.0F;
        d = 0.0F;
        e = 0.45F;
        f = 0;
        b = ad1;
        a();
        ad1.a("contrast", Float.valueOf(c));
        ad1.a("vignette", Float.valueOf(0.0F));
        ad1.a("amount", Float.valueOf(e));
        a(0);
    }

    private void a()
    {
        a[0][0] = 2;
        a[0][1] = 5;
        a[0][2] = 2;
        a[1][0] = 2;
        a[1][1] = 5;
        a[1][2] = 5;
        a[2][0] = 5;
        a[2][1] = 5;
        a[2][2] = 2;
        a[3][0] = 1;
        a[3][1] = 0;
        a[3][2] = 1;
        a[4][0] = 0;
        a[4][1] = 1;
        a[4][2] = 1;
    }

    public final LinearLayout a(Activity activity, boolean flag, ViewGroup viewgroup)
    {
        viewgroup = (LinearLayout)activity.getLayoutInflater().inflate(0x7f03004f, viewgroup, false);
        if (flag)
        {
            a(0.0F);
            d = 0.0F;
            if (b != null)
            {
                b.a("vignette", Float.valueOf(0.0F));
            }
            b(0.45F);
            a(0);
        }
        Object obj = activity.getString(0x7f0801b8);
        Object obj1 = (TextView)viewgroup.findViewById(0x7f10023a);
        ((TextView) (obj1)).setText((new StringBuilder()).append(((String) (obj))).append(" : ").append((int)c * 100).toString());
        SeekBar seekbar = (SeekBar)viewgroup.findViewById(0x7f10023b);
        seekbar.setMax(100);
        seekbar.setProgress((int)c * 100);
        seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(((TextView) (obj1)), ((String) (obj))) {

            private TextView a;
            private String b;
            private u c;

            public final void onProgressChanged(SeekBar seekbar1, int i, boolean flag1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                c.a((float)seekbar1.getProgress() / 100F);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                c.a((float)seekbar1.getProgress() / 100F);
            }

            
            {
                c = u.this;
                a = textview;
                b = s;
                super();
            }
        });
        obj = (TextView)viewgroup.findViewById(0x7f100236);
        obj1 = (SeekBar)viewgroup.findViewById(0x7f100237);
        ((TextView) (obj)).setVisibility(8);
        ((SeekBar) (obj1)).setVisibility(8);
        activity = activity.getString(0x7f0801a2);
        obj = (TextView)viewgroup.findViewById(0x7f100238);
        ((TextView) (obj)).setText((new StringBuilder()).append(activity).append(" : ").append((int)(e * 100F)).toString());
        obj1 = (SeekBar)viewgroup.findViewById(0x7f100239);
        ((SeekBar) (obj1)).setMax(100);
        ((SeekBar) (obj1)).setProgress((int)(e * 100F));
        ((SeekBar) (obj1)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(((TextView) (obj)), activity) {

            private TextView a;
            private String b;
            private u c;

            public final void onProgressChanged(SeekBar seekbar1, int i, boolean flag1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                c.b((float)seekbar1.getProgress() / 100F);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                c.b((float)seekbar1.getProgress() / 100F);
            }

            
            {
                c = u.this;
                a = textview;
                b = s;
                super();
            }
        });
        activity = (RadioGroup)viewgroup.findViewById(0x7f100249);
        f;
        JVM INSTR tableswitch 0 4: default 348
    //                   0 362
    //                   1 378
    //                   2 394
    //                   3 410
    //                   4 426;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        activity.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            private u a;

            public final void onCheckedChanged(RadioGroup radiogroup, int i)
            {
                int j = 0;
                if (i != 0x7f10024b) goto _L2; else goto _L1
_L1:
                j = 1;
_L4:
                a.a(j);
                return;
_L2:
                if (i == 0x7f10024c)
                {
                    j = 2;
                } else
                if (i == 0x7f10024d)
                {
                    j = 3;
                } else
                if (i == 0x7f10024e)
                {
                    j = 4;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = u.this;
                super();
            }
        });
        return viewgroup;
_L2:
        ((RadioButton)viewgroup.findViewById(0x7f10024a)).setChecked(true);
        continue; /* Loop/switch isn't completed */
_L3:
        ((RadioButton)viewgroup.findViewById(0x7f10024b)).setChecked(true);
        continue; /* Loop/switch isn't completed */
_L4:
        ((RadioButton)viewgroup.findViewById(0x7f10024c)).setChecked(true);
        continue; /* Loop/switch isn't completed */
_L5:
        ((RadioButton)viewgroup.findViewById(0x7f10024d)).setChecked(true);
        continue; /* Loop/switch isn't completed */
_L6:
        ((RadioButton)viewgroup.findViewById(0x7f10024e)).setChecked(true);
        if (true) goto _L1; else goto _L7
_L7:
    }

    public final void a(float f1)
    {
        c = f1;
        if (b != null)
        {
            b.a("contrast", Float.valueOf(f1));
        }
    }

    public final void a(int i)
    {
        f = i;
        if (b != null)
        {
            b.a("mode_r", Integer.valueOf(a[i][0]));
            b.a("mode_g", Integer.valueOf(a[i][1]));
            b.a("mode_b", Integer.valueOf(a[i][2]));
        }
    }

    public final void b(float f1)
    {
        e = f1;
        if (b != null)
        {
            b.a("amount", Float.valueOf(f1));
        }
    }
}
