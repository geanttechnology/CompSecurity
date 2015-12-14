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
import com.socialin.android.photo.effects.factory.a;
import java.util.ArrayList;
import myobfuscated.cg.c;
import myobfuscated.cg.e;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class d extends c
{

    private LinearLayout i;

    public d(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
    }

    static LinearLayout a(d d1)
    {
        return d1.i;
    }

    private void a(View view, boolean flag)
    {
        int j = Integer.parseInt(EffectParameter.f(b, "CustomColors"));
        if (flag)
        {
            switch (j)
            {
            default:
                return;

            case 0: // '\0'
                view.findViewById(0x7f10040d).setVisibility(0);
                return;

            case 1: // '\001'
                view.findViewById(0x7f10040f).setVisibility(0);
                return;

            case 2: // '\002'
                view.findViewById(0x7f100411).setVisibility(0);
                return;

            case 3: // '\003'
                view.findViewById(0x7f100413).setVisibility(0);
                return;

            case 4: // '\004'
                view.findViewById(0x7f100415).setVisibility(0);
                break;
            }
            return;
        }
        switch (j)
        {
        default:
            return;

        case 0: // '\0'
            view.findViewById(0x7f10040d).setVisibility(4);
            return;

        case 1: // '\001'
            view.findViewById(0x7f10040f).setVisibility(4);
            return;

        case 2: // '\002'
            view.findViewById(0x7f100411).setVisibility(4);
            return;

        case 3: // '\003'
            view.findViewById(0x7f100413).setVisibility(4);
            return;

        case 4: // '\004'
            view.findViewById(0x7f100415).setVisibility(4);
            break;
        }
    }

    static void a(d d1, int j)
    {
        Object obj = EffectParameter.a(d1.b, "CustomColors");
        ((EffectParameter) (obj)).a((String)((EffectParameter) (obj)).h.get(j));
        EffectParameter.a(d1.b, "useCustomColors", true);
        j = Integer.parseInt(EffectParameter.f(d1.b, "CustomColors"));
        obj = EffectParameter.a(d1.b, "Color1");
        EffectParameter effectparameter = EffectParameter.a(d1.b, "Color2");
        obj.c = Integer.valueOf(com.socialin.android.photo.effects.factory.a.c(j));
        effectparameter.c = Integer.valueOf(com.socialin.android.photo.effects.factory.a.b(j));
        View view = d1.i.findViewById(0x7f100419);
        View view1 = d1.i.findViewById(0x7f10041c);
        view.setBackgroundColor(((Integer)((EffectParameter) (obj)).c).intValue());
        view1.setBackgroundColor(((Integer)effectparameter.c).intValue());
        EffectParameter.a(d1.b, "Hue").e();
        obj = (g)d1.d.get(1);
        m.a(((g) (obj)).d, ((g) (obj)).a);
        a(((g) (obj)).d, ((g) (obj)).c);
        d1.a(d1.b, false);
    }

    static void a(d d1, View view)
    {
        d1.a(view, false);
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(2, 0, 2, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300c7, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100422);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100420);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100421);
        layoutparams.d = EffectParameter.a(b, "Saturation");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10041f);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10041d);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10041e);
        layoutparams.d = EffectParameter.a(b, "Hue");
        d.add(layoutparams);
        boolean flag = EffectParameter.d(b, "useCustomColors");
        Object obj = EffectParameter.a(b, "Color1");
        layoutparams = EffectParameter.a(b, "Color2");
        if (flag)
        {
            int j = Integer.parseInt(EffectParameter.f(b, "CustomColors"));
            obj.c = Integer.valueOf(com.socialin.android.photo.effects.factory.a.c(j));
            layoutparams.c = Integer.valueOf(com.socialin.android.photo.effects.factory.a.b(j));
        }
        Object obj1 = (RelativeLayout)linearlayout.findViewById(0x7f100418);
        Object obj2 = ((RelativeLayout) (obj1)).findViewById(0x7f100419);
        e e1 = new e();
        e1.b = ((View) (obj1));
        e1.a = ((View) (obj2));
        e1.c = ((EffectParameter) (obj));
        f.add(e1);
        obj = (RelativeLayout)linearlayout.findViewById(0x7f10041b);
        obj1 = ((RelativeLayout) (obj)).findViewById(0x7f10041c);
        obj2 = new e();
        obj2.b = ((View) (obj));
        obj2.a = ((View) (obj1));
        obj2.c = layoutparams;
        f.add(obj2);
        ((TextView)linearlayout.findViewById(0x7f100417)).setText((new StringBuilder()).append(a.getResources().getString(0x7f0802a6)).append("1").toString());
        ((TextView)linearlayout.findViewById(0x7f10041a)).setText((new StringBuilder()).append(a.getResources().getString(0x7f0802a6)).append("2").toString());
        if (flag)
        {
            a(((View) (linearlayout)), true);
        }
        layoutparams = new android.view.View.OnClickListener() {

            private d a;

            public final void onClick(View view)
            {
                myobfuscated.ch.d.a(a, myobfuscated.ch.d.a(a));
                if (view.getId() == 0x7f10040e)
                {
                    myobfuscated.ch.d.a(a, 0);
                    myobfuscated.ch.d.a(a).findViewById(0x7f10040d).setVisibility(0);
                } else
                {
                    if (view.getId() == 0x7f100410)
                    {
                        myobfuscated.ch.d.a(a, 1);
                        myobfuscated.ch.d.a(a).findViewById(0x7f10040f).setVisibility(0);
                        return;
                    }
                    if (view.getId() == 0x7f100412)
                    {
                        myobfuscated.ch.d.a(a, 2);
                        myobfuscated.ch.d.a(a).findViewById(0x7f100411).setVisibility(0);
                        return;
                    }
                    if (view.getId() == 0x7f100414)
                    {
                        myobfuscated.ch.d.a(a, 3);
                        myobfuscated.ch.d.a(a).findViewById(0x7f100413).setVisibility(0);
                        return;
                    }
                    if (view.getId() == 0x7f100416)
                    {
                        myobfuscated.ch.d.a(a, 4);
                        myobfuscated.ch.d.a(a).findViewById(0x7f100415).setVisibility(0);
                        return;
                    }
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        linearlayout.findViewById(0x7f10040e).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100410).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100412).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100414).setOnClickListener(layoutparams);
        linearlayout.findViewById(0x7f100416).setOnClickListener(layoutparams);
        i = linearlayout;
        b();
        c();
        return linearlayout;
    }

    protected final boolean a(int j, int k)
    {
        EffectParameter.a(b, "useCustomColors", false);
        a(((View) (i)), false);
        return super.a(j, k);
    }
}
