// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;
import myobfuscated.cg.b;
import myobfuscated.cg.c;
import myobfuscated.f.m;

public final class g extends c
{

    private boolean i;

    public g(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        i = true;
    }

    static b a(g g1)
    {
        return g1.c;
    }

    static boolean a(g g1, boolean flag)
    {
        g1.i = flag;
        return flag;
    }

    static boolean b(g g1)
    {
        return g1.i;
    }

    static b c(g g1)
    {
        return g1.c;
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(1, 0, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d1, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new myobfuscated.cg.g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10043c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10043a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10043b);
        layoutparams.d = EffectParameter.a(b, "Radius");
        d.add(layoutparams);
        layoutparams = (CheckBox)linearlayout.findViewById(0x7f100434);
        layoutparams.setOnCheckedChangeListener(null);
        layoutparams.setChecked(i);
        layoutparams.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            private g a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                g.a(a, flag);
                if (g.a(a) != null)
                {
                    myobfuscated.ch.g.c(a).b(myobfuscated.ch.g.b(a));
                }
            }

            
            {
                a = g.this;
                super();
            }
        });
        b();
        return linearlayout;
    }

    public final boolean a()
    {
        return i;
    }
}
