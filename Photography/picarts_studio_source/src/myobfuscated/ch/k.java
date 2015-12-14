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

public final class k extends c
{

    public k(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(1, 2, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300ce, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100450);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10044e);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10044f);
        layoutparams.d = EffectParameter.a(b, "Offset");
        d.add(layoutparams);
        layoutparams = new f();
        layoutparams.a = (RadioGroup)linearlayout.findViewById(0x7f10044a);
        ArrayList arraylist = new ArrayList(2);
        arraylist.add(Integer.valueOf(0x7f10044b));
        arraylist.add(Integer.valueOf(0x7f10044c));
        layoutparams.b = arraylist;
        arraylist = new ArrayList(2);
        arraylist.add("Horizontal");
        arraylist.add("Vertical");
        layoutparams.c = arraylist;
        layoutparams.d = EffectParameter.a(b, "FlipMode");
        e.add(layoutparams);
        layoutparams = new f();
        layoutparams.a = (RadioGroup)linearlayout.findViewById(0x7f10044d);
        arraylist = new ArrayList(2);
        arraylist.add(Integer.valueOf(0x7f100250));
        arraylist.add(Integer.valueOf(0x7f100251));
        layoutparams.b = arraylist;
        arraylist = new ArrayList(2);
        arraylist.add("Mode1");
        arraylist.add("Mode2");
        layoutparams.c = arraylist;
        layoutparams.d = EffectParameter.a(b, "Mode");
        e.add(layoutparams);
        b();
        return linearlayout;
    }
}
