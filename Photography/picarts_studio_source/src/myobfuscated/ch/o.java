// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;
import myobfuscated.cg.c;
import myobfuscated.cg.e;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class o extends c
{

    public o(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(5, 0, 2, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d3, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10046c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10046a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10046b);
        layoutparams.d = EffectParameter.a(b, "Mask 1");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10046f);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10046d);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10046e);
        layoutparams.d = EffectParameter.a(b, "Mask 2");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100472);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100470);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100471);
        layoutparams.d = EffectParameter.a(b, "Magic 1");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100475);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100473);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100474);
        layoutparams.d = EffectParameter.a(b, "Magic 2");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        layoutparams = (RelativeLayout)linearlayout.findViewById(0x7f100418);
        View view = layoutparams.findViewById(0x7f100419);
        EffectParameter effectparameter = EffectParameter.a(b, "Color1");
        e e1 = new e();
        e1.b = layoutparams;
        e1.a = view;
        e1.c = effectparameter;
        f.add(e1);
        layoutparams = (RelativeLayout)linearlayout.findViewById(0x7f10041b);
        view = layoutparams.findViewById(0x7f10041c);
        effectparameter = EffectParameter.a(b, "Color2");
        e1 = new e();
        e1.b = layoutparams;
        e1.a = view;
        e1.c = effectparameter;
        f.add(e1);
        ((TextView)linearlayout.findViewById(0x7f100417)).setText((new StringBuilder()).append(a.getResources().getString(0x7f0802a6)).append("1").toString());
        ((TextView)linearlayout.findViewById(0x7f10041a)).setText((new StringBuilder()).append(a.getResources().getString(0x7f0802a6)).append("2").toString());
        b();
        c();
        return linearlayout;
    }
}
