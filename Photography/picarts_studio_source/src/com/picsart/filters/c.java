// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import java.nio.ByteBuffer;
import myobfuscated.az.a;
import myobfuscated.az.e;

// Referenced classes of package com.picsart.filters:
//            d

public abstract class c
    implements e
{

    protected int a;
    protected int b;
    protected a c[];
    protected int d;
    d e;
    private String f;

    public c(String s, int i, int j)
    {
        a = -1;
        b = -1;
        f = s;
        a = i;
        b = j;
        b();
    }

    private void a(int i, ViewGroup viewgroup)
    {
        d = i;
        a a1 = c[i];
        if (viewgroup != null && a1.h != null && a1.i != null && a1.g != null)
        {
            TextView textview = (TextView)viewgroup.findViewById(a1.h.intValue());
            textview.setText(a1.a());
            viewgroup = (SeekBar)viewgroup.findViewById(a1.i.intValue());
            i = ((Integer)a1.g).intValue();
            int j = ((Integer)a1.e).intValue();
            viewgroup.setMax(((Integer)a1.d).intValue() - j);
            viewgroup.setProgress(i - j);
            viewgroup.setOnSeekBarChangeListener(new myobfuscated.az.a._cls1(a1, textview));
        }
    }

    static void a(c c1, Activity activity, int i, ViewGroup viewgroup)
    {
        c1.a(i, viewgroup);
    }

    protected final int a(int i)
    {
        for (int j = 0; j < c.length; j++)
        {
            a a1 = c[j];
            if (a1.k == i)
            {
                return a1.a;
            }
        }

        return -1;
    }

    public final void a()
    {
        if (e != null)
        {
            e.a();
        }
    }

    public final void a(Activity activity, ViewGroup viewgroup)
    {
        a(d, viewgroup);
    }

    public final void a(Activity activity, RadioGroup radiogroup, ViewGroup viewgroup)
    {
        LayoutInflater layoutinflater = activity.getLayoutInflater();
        for (int i = 0; i < c.length; i++)
        {
            a a1 = c[i];
            RadioButton radiobutton = (RadioButton)layoutinflater.inflate(0x7f0300fc, radiogroup, false);
            radiobutton.setId(a1.k);
            radiobutton.setBackgroundResource(a1.j);
            radiogroup.addView(radiobutton);
        }

        radiogroup.check(c[d].k);
        radiogroup.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener(activity, viewgroup) {

            private Activity a;
            private ViewGroup b;
            private c c;

            public final void onCheckedChanged(RadioGroup radiogroup1, int j)
            {
                j = c.a(j);
                com.picsart.filters.c.a(c, a, j, b);
            }

            
            {
                c = c.this;
                a = activity;
                b = viewgroup;
                super();
            }
        });
        a(d, viewgroup);
    }

    public final void a(Context context)
    {
        for (int i = 0; i < c.length; i++)
        {
            a a1 = c[i];
            if (a1.c != -1)
            {
                a1.b = context.getString(a1.c);
            }
        }

    }

    protected final void a(a a1, int i, int j, int k)
    {
        a1.h = Integer.valueOf(j);
        a1.i = Integer.valueOf(k);
        c[i] = a1;
        a1.a(this);
    }

    public boolean a(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, int j, boolean flag, int k)
    {
        return true;
    }

    protected abstract void b();

    public final void c()
    {
        if (c != null)
        {
            for (int i = 0; i < c.length; i++)
            {
                a a1 = c[i];
                a1.g = a1.f;
            }

        }
    }
}
