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
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class u extends c
{

    private boolean i;

    public u(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        i = true;
    }

    static b a(u u1)
    {
        return u1.c;
    }

    static boolean a(u u1, boolean flag)
    {
        u1.i = flag;
        return flag;
    }

    static boolean b(u u1)
    {
        return u1.i;
    }

    static b c(u u1)
    {
        return u1.c;
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(3, 0, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300da, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100496);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100494);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100495);
        layoutparams.d = EffectParameter.a(b, "Phase");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100499);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100497);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100498);
        layoutparams.d = EffectParameter.a(b, "Wave");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10043c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10043a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10043b);
        layoutparams.d = EffectParameter.a(b, "Radius");
        d.add(layoutparams);
        layoutparams = (CheckBox)linearlayout.findViewById(0x7f100434);
        layoutparams.setOnCheckedChangeListener(null);
        layoutparams.setChecked(i);
        layoutparams.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            private u a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                u.a(a, flag);
                if (u.a(a) != null)
                {
                    myobfuscated.ch.u.c(a).b(myobfuscated.ch.u.b(a));
                }
            }

            
            {
                a = u.this;
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
