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

public final class e extends c
{

    public e(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(1, 1, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300c8, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        layoutparams = new f();
        layoutparams.a = (RadioGroup)linearlayout.findViewById(0x7f100405);
        ArrayList arraylist = new ArrayList(3);
        arraylist.add(Integer.valueOf(0x7f100423));
        arraylist.add(Integer.valueOf(0x7f100424));
        arraylist.add(Integer.valueOf(0x7f100425));
        layoutparams.b = arraylist;
        arraylist = new ArrayList(3);
        arraylist.add("Green");
        arraylist.add("Red");
        arraylist.add("Blue");
        layoutparams.c = arraylist;
        layoutparams.d = EffectParameter.a(b, "Mode");
        e.add(layoutparams);
        b();
        return linearlayout;
    }

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        int j = ((Integer)radiogroup.getTag()).intValue();
        if (j >= 0 && j < e.size())
        {
            radiogroup = (g)d.get(0);
            ((g) (radiogroup)).d.e();
            m.a(((g) (radiogroup)).d, ((g) (radiogroup)).a);
            a(((g) (radiogroup)).d, ((g) (radiogroup)).c);
            radiogroup = (f)e.get(j);
            String s = radiogroup.a(i);
            ((f) (radiogroup)).d.a(s);
            a(b, false);
        }
    }
}
