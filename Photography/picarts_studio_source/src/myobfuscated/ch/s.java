// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;
import myobfuscated.cg.c;
import myobfuscated.cg.e;
import myobfuscated.cg.f;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class s extends c
{

    public s(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(2, 1, 1, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d7, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10043c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10043a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10043b);
        layoutparams.d = EffectParameter.a(b, "Radius");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        layoutparams = (RelativeLayout)linearlayout.findViewById(0x7f10047f);
        Object obj = layoutparams.findViewById(0x7f100480);
        EffectParameter effectparameter = EffectParameter.a(b, "Color");
        e e1 = new e();
        e1.b = layoutparams;
        e1.a = ((View) (obj));
        e1.c = effectparameter;
        f.add(e1);
        layoutparams = new f();
        layoutparams.a = (RadioGroup)linearlayout.findViewById(0x7f100405);
        obj = new ArrayList(3);
        ((ArrayList) (obj)).add(Integer.valueOf(0x7f10048b));
        ((ArrayList) (obj)).add(Integer.valueOf(0x7f10048c));
        ((ArrayList) (obj)).add(Integer.valueOf(0x7f10048d));
        layoutparams.b = ((ArrayList) (obj));
        obj = new ArrayList(3);
        ((ArrayList) (obj)).add("Sin");
        ((ArrayList) (obj)).add("Sqrt");
        ((ArrayList) (obj)).add("Square");
        layoutparams.c = ((ArrayList) (obj));
        layoutparams.d = EffectParameter.a(b, "Mode");
        e.add(layoutparams);
        b();
        c();
        return linearlayout;
    }
}
