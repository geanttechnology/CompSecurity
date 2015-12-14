// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
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

public final class p extends c
{

    public p(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(5, 0, 1, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d4, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100478);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100476);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100477);
        layoutparams.d = EffectParameter.a(b, "Intensity");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10047b);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100479);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10047a);
        layoutparams.d = EffectParameter.a(b, "Gamma");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10047e);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10047c);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10047d);
        layoutparams.d = EffectParameter.a(b, "Median");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100449);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100447);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100448);
        layoutparams.d = EffectParameter.a(b, "Vignette");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        layoutparams = (RelativeLayout)linearlayout.findViewById(0x7f10047f);
        View view = layoutparams.findViewById(0x7f100480);
        EffectParameter effectparameter = EffectParameter.a(b, "Color");
        e e1 = new e();
        e1.b = layoutparams;
        e1.a = view;
        e1.c = effectparameter;
        f.add(e1);
        b();
        c();
        return linearlayout;
    }
}
