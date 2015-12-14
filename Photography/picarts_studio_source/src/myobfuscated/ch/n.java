// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
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

public final class n extends c
{

    public n(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    static ArrayList a(n n1)
    {
        return n1.b;
    }

    static void a(View view, boolean flag, String s)
    {
        b(view, flag, s);
    }

    static void a(n n1, ArrayList arraylist)
    {
        n1.a(arraylist, false);
    }

    static ArrayList b(n n1)
    {
        return n1.d;
    }

    private static void b(View view, boolean flag, String s)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (s.compareTo("Lines") != 0) goto _L4; else goto _L3
_L3:
        view.findViewById(0x7f10045d).setVisibility(0);
_L6:
        return;
_L4:
        if (s.compareTo("Cross") == 0)
        {
            view.findViewById(0x7f10045b).setVisibility(0);
            return;
        }
        if (s.compareTo("Circles") == 0)
        {
            view.findViewById(0x7f10045f).setVisibility(0);
            return;
        }
        if (s.compareTo("Squares") == 0)
        {
            view.findViewById(0x7f100461).setVisibility(0);
            return;
        }
        if (s.compareTo("Random") == 0)
        {
            view.findViewById(0x7f100463).setVisibility(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.compareTo("Lines") == 0)
        {
            view.findViewById(0x7f10045d).setVisibility(4);
            return;
        }
        if (s.compareTo("Cross") == 0)
        {
            view.findViewById(0x7f10045b).setVisibility(4);
            return;
        }
        if (s.compareTo("Circles") == 0)
        {
            view.findViewById(0x7f10045f).setVisibility(4);
            return;
        }
        if (s.compareTo("Squares") == 0)
        {
            view.findViewById(0x7f100461).setVisibility(4);
            return;
        }
        if (s.compareTo("Random") == 0)
        {
            view.findViewById(0x7f100463).setVisibility(4);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static ArrayList c(n n1)
    {
        return n1.d;
    }

    static ArrayList d(n n1)
    {
        return n1.b;
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(2, 0, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d2, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100468);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100466);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100467);
        layoutparams.d = EffectParameter.a(b, "Size");
        d.add(layoutparams);
        g g1 = new g();
        g1.a = (SeekBar)linearlayout.findViewById(0x7f100457);
        g1.b = (TextView)linearlayout.findViewById(0x7f100455);
        g1.c = (TextView)linearlayout.findViewById(0x7f100456);
        g1.d = EffectParameter.a(b, "Angle");
        d.add(g1);
        String s = EffectParameter.a(b, "Shape").g;
        b(linearlayout, true, s);
        if (s.compareTo("Lines") == 0)
        {
            g1.a.setVisibility(0);
            linearlayout.findViewById(0x7f100469).setVisibility(0);
            linearlayout.findViewById(0x7f100465).setVisibility(0);
            ((g) (layoutparams)).a.setVisibility(0);
        } else
        if (s.compareTo("Random") == 0)
        {
            g1.a.setVisibility(8);
            linearlayout.findViewById(0x7f100469).setVisibility(8);
            linearlayout.findViewById(0x7f100465).setVisibility(8);
            ((g) (layoutparams)).a.setVisibility(8);
        } else
        {
            g1.a.setVisibility(8);
            linearlayout.findViewById(0x7f100469).setVisibility(8);
            linearlayout.findViewById(0x7f100465).setVisibility(0);
            ((g) (layoutparams)).a.setVisibility(0);
        }
        layoutparams = new android.view.View.OnClickListener(linearlayout) {

            private LinearLayout a;
            private n b;

            public final void onClick(View view)
            {
                EffectParameter effectparameter = EffectParameter.a(n.a(b), "Shape");
                String s1 = effectparameter.g;
                n.a(a, false, s1);
                g g2 = (g)n.b(b).get(0);
                g g3 = (g)myobfuscated.ch.n.c(b).get(1);
                if (view.getId() == 0x7f10045e)
                {
                    g3.a.setVisibility(0);
                    a.findViewById(0x7f100469).setVisibility(0);
                    a.findViewById(0x7f100465).setVisibility(0);
                    g2.a.setVisibility(0);
                    view = "Lines";
                } else
                if (view.getId() == 0x7f10045c)
                {
                    g3.a.setVisibility(8);
                    a.findViewById(0x7f100469).setVisibility(8);
                    a.findViewById(0x7f100465).setVisibility(0);
                    g2.a.setVisibility(0);
                    view = "Cross";
                } else
                if (view.getId() == 0x7f100460)
                {
                    g3.a.setVisibility(8);
                    a.findViewById(0x7f100469).setVisibility(8);
                    a.findViewById(0x7f100465).setVisibility(0);
                    g2.a.setVisibility(0);
                    view = "Circles";
                } else
                if (view.getId() == 0x7f100462)
                {
                    g3.a.setVisibility(8);
                    a.findViewById(0x7f100469).setVisibility(8);
                    a.findViewById(0x7f100465).setVisibility(0);
                    g2.a.setVisibility(0);
                    view = "Squares";
                } else
                {
                    if (view.getId() == 0x7f100464)
                    {
                        s1 = "Random";
                        g3.a.setVisibility(8);
                        a.findViewById(0x7f100469).setVisibility(8);
                        a.findViewById(0x7f100465).setVisibility(8);
                        g2.a.setVisibility(8);
                    }
                    view = s1;
                }
                effectparameter.a(view);
                n.a(a, true, view);
                n.a(b, n.d(b));
            }

            
            {
                b = n.this;
                a = linearlayout;
                super();
            }
        };
        linearlayout.findViewById(0x7f10045e).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f10045c).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100460).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100462).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100464).setOnClickListener(layoutparams);
        b();
        return linearlayout;
    }
}
