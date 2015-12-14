// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;
import myobfuscated.cg.c;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class q extends c
{

    public q(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    static ArrayList a(q q1)
    {
        return q1.b;
    }

    static void a(View view, String s)
    {
        a(view, false, s);
    }

    private static void a(View view, boolean flag, String s)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (s.compareTo("Mode1") != 0) goto _L4; else goto _L3
_L3:
        view.findViewById(0x7f100481).setVisibility(0);
_L6:
        return;
_L4:
        if (s.compareTo("Mode2") == 0)
        {
            view.findViewById(0x7f100483).setVisibility(0);
            return;
        }
        if (s.compareTo("Mode3") == 0)
        {
            view.findViewById(0x7f100485).setVisibility(0);
            return;
        }
        if (s.compareTo("Mode4") == 0)
        {
            view.findViewById(0x7f100487).setVisibility(0);
            return;
        }
        if (s.compareTo("Mode5") == 0)
        {
            view.findViewById(0x7f100489).setVisibility(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.compareTo("Mode1") == 0)
        {
            view.findViewById(0x7f100481).setVisibility(4);
            return;
        }
        if (s.compareTo("Mode2") == 0)
        {
            view.findViewById(0x7f100483).setVisibility(4);
            return;
        }
        if (s.compareTo("Mode3") == 0)
        {
            view.findViewById(0x7f100485).setVisibility(4);
            return;
        }
        if (s.compareTo("Mode4") == 0)
        {
            view.findViewById(0x7f100487).setVisibility(4);
            return;
        }
        if (s.compareTo("Mode5") == 0)
        {
            view.findViewById(0x7f100489).setVisibility(4);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void a(q q1, ArrayList arraylist)
    {
        q1.a(arraylist, false);
    }

    static ArrayList b(q q1)
    {
        return q1.b;
    }

    static void b(q q1, ArrayList arraylist)
    {
        q1.a(arraylist, false);
    }

    static ArrayList c(q q1)
    {
        return q1.b;
    }

    static void c(q q1, ArrayList arraylist)
    {
        q1.a(arraylist, false);
    }

    static ArrayList d(q q1)
    {
        return q1.b;
    }

    static void d(q q1, ArrayList arraylist)
    {
        q1.a(arraylist, false);
    }

    static ArrayList e(q q1)
    {
        return q1.b;
    }

    static void e(q q1, ArrayList arraylist)
    {
        q1.a(arraylist, false);
    }

    static ArrayList f(q q1)
    {
        return q1.b;
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(1, 0, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d5, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        a(((View) (linearlayout)), true, EffectParameter.a(b, "Mode").g);
        layoutparams = new android.view.View.OnClickListener(linearlayout) {

            private LinearLayout a;
            private q b;

            public final void onClick(View view)
            {
                EffectParameter effectparameter = EffectParameter.a(q.a(b), "Mode");
                String s = effectparameter.g;
                q.a(a, s);
                Log.e("ex1", "onClick suntan");
                if (view.getId() == 0x7f100482)
                {
                    Log.e("ex1", "suntan_mode1");
                    if (s.compareTo("Mode1") != 0)
                    {
                        Log.e("ex1", "compareTo mode1");
                        effectparameter.a("Mode1");
                        q.a(b, q.b(b));
                    }
                    a.findViewById(0x7f100481).setVisibility(0);
                } else
                {
                    if (view.getId() == 0x7f100484)
                    {
                        if (s.compareTo("Mode2") != 0)
                        {
                            effectparameter.a("Mode2");
                            q.b(b, myobfuscated.ch.q.c(b));
                        }
                        a.findViewById(0x7f100483).setVisibility(0);
                        return;
                    }
                    if (view.getId() == 0x7f100486)
                    {
                        if (s.compareTo("Mode3") != 0)
                        {
                            effectparameter.a("Mode3");
                            myobfuscated.ch.q.c(b, q.d(b));
                        }
                        a.findViewById(0x7f100485).setVisibility(0);
                        return;
                    }
                    if (view.getId() == 0x7f100488)
                    {
                        if (s.compareTo("Mode4") != 0)
                        {
                            effectparameter.a("Mode4");
                            q.d(b, q.e(b));
                        }
                        a.findViewById(0x7f100487).setVisibility(0);
                        return;
                    }
                    if (view.getId() == 0x7f10048a)
                    {
                        if (s.compareTo("Mode5") != 0)
                        {
                            effectparameter.a("Mode5");
                            q.e(b, q.f(b));
                        }
                        a.findViewById(0x7f100489).setVisibility(0);
                        return;
                    }
                }
            }

            
            {
                b = q.this;
                a = linearlayout;
                super();
            }
        };
        linearlayout.findViewById(0x7f100482).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100484).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100486).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100488).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f10048a).setOnClickListener(layoutparams);
        b();
        return linearlayout;
    }
}
