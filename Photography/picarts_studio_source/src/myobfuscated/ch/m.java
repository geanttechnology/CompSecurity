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
import myobfuscated.cg.e;
import myobfuscated.cg.g;

public final class m extends c
{

    private boolean i;

    public m(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        i = true;
    }

    static b a(m m1)
    {
        return m1.c;
    }

    static boolean a(m m1, boolean flag)
    {
        m1.i = flag;
        return flag;
    }

    static b b(m m1)
    {
        return m1.c;
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(1, 0, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d0, null);
        myobfuscated.f.m.a(a, linearlayout, layoutparams);
        layoutparams = (CheckBox)linearlayout.findViewById(0x7f100434);
        layoutparams.setOnCheckedChangeListener(null);
        layoutparams.setEnabled(i);
        layoutparams.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            private m a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                m.a(a, flag);
                if (m.a(a) != null)
                {
                    myobfuscated.ch.m.b(a).b(flag);
                }
            }

            
            {
                a = m.this;
                super();
            }
        });
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100439);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100437);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100438);
        layoutparams.d = EffectParameter.a(b, "Blur");
        d.add(layoutparams);
        b();
        return linearlayout;
    }

    public final boolean a()
    {
        return i;
    }

    protected final boolean a(int j, boolean flag)
    {
        boolean flag1 = super.a(j, flag);
        if (flag1)
        {
            ((e)f.get(0)).b.setEnabled(flag);
        }
        return flag1;
    }
}
