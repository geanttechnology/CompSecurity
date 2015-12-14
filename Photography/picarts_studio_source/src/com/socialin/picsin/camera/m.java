// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

// Referenced classes of package com.socialin.picsin.camera:
//            n, o

public final class m
    implements android.widget.RadioGroup.OnCheckedChangeListener
{

    RelativeLayout a;
    private o b;
    private RadioGroup c;
    private RadioGroup d;
    private Activity e;
    private n f;
    private boolean g;

    public m(Activity activity, RelativeLayout relativelayout, o o1)
    {
        g = false;
        b = o1;
        e = activity;
        f = (n)activity;
        a = (RelativeLayout)e.getLayoutInflater().inflate(0x7f03009e, null);
        c = (RadioGroup)a.findViewById(0x7f10035b);
        c.check(0x7f10035c);
        c.setOnCheckedChangeListener(this);
        d = (RadioGroup)a.findViewById(0x7f10035e);
        d.setOnCheckedChangeListener(this);
        activity = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        activity.addRule(13, -1);
        relativelayout.addView(a, activity);
        a.setOnClickListener((android.view.View.OnClickListener)e);
        activity = new android.view.View.OnClickListener() {

            private m a;

            public final void onClick(View view)
            {
                Log.e("ex", "onRadioButtonClickListener");
                if (m.a(a))
                {
                    m.b(a).setVisibility(8);
                    m.c(a);
                    return;
                } else
                {
                    a.a();
                    return;
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        a.findViewById(0x7f10035c).setOnClickListener(activity);
        a.findViewById(0x7f100360).setOnClickListener(activity);
        a.findViewById(0x7f10035f).setOnClickListener(activity);
        a.findViewById(0x7f10035d).setOnClickListener(activity);
    }

    static boolean a(m m1)
    {
        return m1.g;
    }

    static RelativeLayout b(m m1)
    {
        return m1.a;
    }

    static boolean c(m m1)
    {
        m1.g = false;
        return false;
    }

    public final void a()
    {
        a.setVisibility(8);
        if (f != null)
        {
            f.g();
        }
    }

    public final void a(int i)
    {
        if (a != null)
        {
            a.setRotation(i);
        }
    }

    public final void a(CameraShutter.ShutterMode shuttermode)
    {
        if (shuttermode == CameraShutter.ShutterMode.NORMAL)
        {
            ((RadioButton)c.findViewById(0x7f10035c)).performClick();
        }
    }

    public final boolean b()
    {
        return a.getVisibility() == 0;
    }

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        g = true;
        Log.e("ex", "onCheckedChanged");
        if (radiogroup == c)
        {
            radiogroup = d;
        } else
        {
            radiogroup = c;
        }
        radiogroup.setOnCheckedChangeListener(null);
        radiogroup.clearCheck();
        radiogroup.setOnCheckedChangeListener(this);
        b.a(i);
    }
}
