// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;
import myobfuscated.cg.c;
import myobfuscated.cg.f;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class j extends c
{

    public j(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(4, 1, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300cd, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100449);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100447);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100448);
        layoutparams.d = EffectParameter.a(b, "Vignette");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10042a);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100428);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100429);
        layoutparams.d = EffectParameter.a(b, "Contrast");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10042d);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10042b);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10042c);
        layoutparams.d = EffectParameter.a(b, "Amount");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        layoutparams = new f();
        layoutparams.a = (RadioGroup)linearlayout.findViewById(0x7f100405);
        ArrayList arraylist = new ArrayList(5);
        arraylist.add(Integer.valueOf(0x7f10024a));
        arraylist.add(Integer.valueOf(0x7f10024b));
        arraylist.add(Integer.valueOf(0x7f10024c));
        arraylist.add(Integer.valueOf(0x7f10024d));
        arraylist.add(Integer.valueOf(0x7f10024e));
        layoutparams.b = arraylist;
        arraylist = new ArrayList(5);
        arraylist.add("L1");
        arraylist.add("L2");
        arraylist.add("L3");
        arraylist.add("L4");
        arraylist.add("L5");
        layoutparams.c = arraylist;
        layoutparams.d = EffectParameter.a(b, "Mode");
        e.add(layoutparams);
        b();
        return linearlayout;
    }
}
