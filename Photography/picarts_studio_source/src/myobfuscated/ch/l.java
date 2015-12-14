// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import com.socialin.android.photo.effects.factory.b;
import java.util.ArrayList;
import myobfuscated.cg.c;
import myobfuscated.cg.d;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class l extends c
{

    public l(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(5, 0, 0, 1);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300cf, null);
        m.a(a, linearlayout, layoutparams);
        Object obj = (CheckBox)linearlayout.findViewById(0x7f100451);
        layoutparams = new d();
        layoutparams.a = ((CheckBox) (obj));
        obj = EffectParameter.a(b, "Colorize");
        layoutparams.c = ((EffectParameter) (obj));
        g.add(layoutparams);
        boolean flag = ((Boolean)((EffectParameter) (obj)).c).booleanValue();
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10041f);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10041d);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10041e);
        layoutparams.d = EffectParameter.a(b, "Hue");
        d.add(layoutparams);
        ((g) (layoutparams)).a.setEnabled(flag);
        obj = b.b(a, ((g) (layoutparams)).d.a);
        if (flag)
        {
            ((g) (layoutparams)).c.setVisibility(0);
            ((g) (layoutparams)).b.setText((new StringBuilder()).append(((String) (obj))).append(" : ").toString());
        } else
        {
            ((g) (layoutparams)).c.setVisibility(8);
            ((g) (layoutparams)).b.setText(((CharSequence) (obj)));
        }
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100454);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100452);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100453);
        layoutparams.d = EffectParameter.a(b, "Distance");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100457);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100455);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100456);
        layoutparams.d = EffectParameter.a(b, "Angle");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10045a);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100458);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100459);
        layoutparams.d = EffectParameter.a(b, "Noise");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        b();
        return linearlayout;
    }

    protected final boolean a(int i, boolean flag)
    {
        g g1;
        String s;
        boolean flag1;
label0:
        {
            flag1 = super.a(i, flag);
            if (flag1)
            {
                g1 = (g)d.get(0);
                g1.a.setEnabled(flag);
                s = b.b(a, g1.d.a);
                if (!flag)
                {
                    break label0;
                }
                g1.c.setVisibility(0);
                g1.b.setText((new StringBuilder()).append(s).append(" : ").toString());
            }
            return flag1;
        }
        g1.c.setVisibility(8);
        g1.b.setText(s);
        return flag1;
    }
}
