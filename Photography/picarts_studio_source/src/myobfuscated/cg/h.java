// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cg;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import com.socialin.android.photo.effects.factory.b;
import java.util.ArrayList;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.cg:
//            a

public final class h extends a
{

    private ArrayList d;
    private ArrayList e;

    public h(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        d = new ArrayList();
        e = new ArrayList();
        b();
    }

    static void a(h h1, int i, int j, int k, boolean flag)
    {
        EffectParameter effectparameter = (EffectParameter)h1.b.get(i);
        TextView textview = (TextView)h1.d.get(j);
        i = m.c(effectparameter);
        effectparameter.a((float)k / (float)i);
        if (effectparameter.b == com.photo.effect.EffectParameter.ParameterType.ParameterTypeInt)
        {
            textview.setText((new StringBuilder()).append(effectparameter.c).toString());
        } else
        {
            textview.setText((new StringBuilder()).append((float)(int)(((Float)effectparameter.c).floatValue() * 100F) / 100F).toString());
        }
        h1.a(h1.b, flag);
    }

    private void b()
    {
        d = new ArrayList(b.size());
        e = new ArrayList(b.size());
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        LinearLayout linearlayout = new LinearLayout(a);
        m.a(a, linearlayout, layoutparams);
        b();
        int j = 0;
        int i = 0;
        while (j < b.size()) 
        {
            layoutparams = (EffectParameter)b.get(j);
            int k;
            if (((EffectParameter) (layoutparams)).b == com.photo.effect.EffectParameter.ParameterType.ParameterTypeInt || ((EffectParameter) (layoutparams)).b == com.photo.effect.EffectParameter.ParameterType.ParameterTypeFloat)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (k != 0)
            {
                Object obj = new LinearLayout(a);
                Object obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                ((LinearLayout) (obj)).setOrientation(0);
                ((LinearLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                obj1 = new TextView(a);
                ((TextView) (obj1)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
                ((TextView) (obj1)).setTextColor(-1);
                ((TextView) (obj1)).setTextSize(2, 13F);
                String s = ((EffectParameter) (layoutparams)).a;
                s = com.socialin.android.photo.effects.factory.b.b(a, s);
                ((TextView) (obj1)).setText((new StringBuilder()).append(s).append(" : ").toString());
                ((LinearLayout) (obj)).addView(((View) (obj1)));
                obj1 = new TextView(a);
                ((TextView) (obj1)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
                ((TextView) (obj1)).setTextColor(-1);
                ((TextView) (obj1)).setTextSize(2, 13F);
                ((TextView) (obj1)).setText("50");
                ((LinearLayout) (obj)).addView(((View) (obj1)));
                d.add(obj1);
                linearlayout.addView(((View) (obj)));
                obj = new SeekBar(a);
                ((SeekBar) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
                ((SeekBar) (obj)).setMax(m.c(layoutparams));
                ((SeekBar) (obj)).setTag(0x7f100044, new Integer(j));
                ((SeekBar) (obj)).setTag(0x7f100045, new Integer(i));
                ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

                    private h a;

                    public final void onProgressChanged(SeekBar seekbar, int l, boolean flag)
                    {
                        if (flag)
                        {
                            int i1 = ((Integer)seekbar.getTag(0x7f100044)).intValue();
                            int j1 = ((Integer)seekbar.getTag(0x7f100045)).intValue();
                            h.a(a, i1, j1, l, true);
                        }
                    }

                    public final void onStartTrackingTouch(SeekBar seekbar)
                    {
                    }

                    public final void onStopTrackingTouch(SeekBar seekbar)
                    {
                        int l = ((Integer)seekbar.getTag(0x7f100044)).intValue();
                        int i1 = ((Integer)seekbar.getTag(0x7f100045)).intValue();
                        h.a(a, l, i1, seekbar.getProgress(), false);
                    }

            
            {
                a = h.this;
                super();
            }
                });
                linearlayout.addView(((View) (obj)));
                e.add(obj);
                layoutparams = (EffectParameter)b.get(j);
                obj = (TextView)d.get(i);
                obj1 = (SeekBar)e.get(i);
                if (((EffectParameter) (layoutparams)).b == com.photo.effect.EffectParameter.ParameterType.ParameterTypeInt)
                {
                    ((TextView) (obj)).setText(String.valueOf(((Integer)((EffectParameter) (layoutparams)).c).intValue()));
                    k = m.a(layoutparams);
                } else
                {
                    float f = ((Float)((EffectParameter) (layoutparams)).c).floatValue();
                    ((TextView) (obj)).setText((new StringBuilder()).append((f * 100F) / 100F).toString());
                    k = m.b(layoutparams);
                }
                ((SeekBar) (obj1)).setProgress(k);
                i++;
            }
            j++;
        }
        return linearlayout;
    }
}
