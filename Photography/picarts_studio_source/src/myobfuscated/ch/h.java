// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import com.socialin.android.photo.effects.factory.b;
import java.util.ArrayList;
import myobfuscated.ay.d;
import myobfuscated.cg.c;
import myobfuscated.cg.e;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class h extends c
{

    private boolean i;

    public h(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        i = true;
    }

    static myobfuscated.cg.b a(h h1)
    {
        return h1.c;
    }

    static void a(h h1, ArrayList arraylist)
    {
        h1.a(arraylist, false);
    }

    static boolean a(h h1, boolean flag)
    {
        h1.i = flag;
        return flag;
    }

    static myobfuscated.cg.b b(h h1)
    {
        return h1.c;
    }

    static ArrayList c(h h1)
    {
        return h1.b;
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        LinearLayout linearlayout;
        ArrayList arraylist;
        ArrayList arraylist1;
        Object obj;
        int k;
        a(4, 0, 0, 0);
        linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300cb, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = (CheckBox)linearlayout.findViewById(0x7f100434);
        layoutparams.setOnCheckedChangeListener(null);
        layoutparams.setEnabled(i);
        layoutparams.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            private h a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                h.a(a, flag);
                if (h.a(a) != null)
                {
                    myobfuscated.ch.h.b(a).b(flag);
                }
            }

            
            {
                a = h.this;
                super();
            }
        });
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f100439);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f100437);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f100438);
        layoutparams.d = EffectParameter.a(b, "Focal zoom");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10043c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10043a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10043b);
        layoutparams.d = EffectParameter.a(b, "Radius");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10043f);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10043d);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10043e);
        layoutparams.d = EffectParameter.a(b, "Hardness");
        d.add(layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10040c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10040a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10040b);
        layoutparams.d = EffectParameter.a(b, "Fade");
        d.add(layoutparams);
        layoutparams = EffectParameter.a(b, "BlendMode");
        arraylist = ((EffectParameter) (layoutparams)).h;
        arraylist1 = new ArrayList();
        for (int j = 0; j < arraylist.size(); j++)
        {
            arraylist1.add(com.socialin.android.photo.effects.factory.b.c(a, (String)arraylist.get(j)));
        }

        obj = ((EffectParameter) (layoutparams)).g;
        k = 0;
_L3:
        if (k >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_572;
        }
        if (((String) (obj)).compareTo((String)arraylist.get(k)) != 0) goto _L2; else goto _L1
_L1:
        Button button = (Button)linearlayout.findViewById(0x7f100436);
        button.setText(com.socialin.android.photo.effects.factory.b.c(a, ((String) (obj))));
        obj = new d(a, arraylist1);
        ((d) (obj)).setDropDownViewResource(0x7f03024f);
        Spinner spinner = (Spinner)linearlayout.findViewById(0x7f100435);
        spinner.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        spinner.setSelection(k);
        spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(arraylist, layoutparams, button, arraylist1) {

            private ArrayList a;
            private EffectParameter b;
            private Button c;
            private ArrayList d;
            private h e;

            public final void onItemSelected(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = (String)a.get(l);
                if (adapterview.compareTo(b.g) == 0)
                {
                    return;
                } else
                {
                    c.setText((CharSequence)d.get(l));
                    b.a(adapterview);
                    h.a(e, myobfuscated.ch.h.c(e));
                    return;
                }
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                e = h.this;
                a = arraylist;
                b = effectparameter;
                c = button;
                d = arraylist1;
                super();
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener(spinner) {

            private Spinner a;

            public final void onClick(View view)
            {
                a.performClick();
            }

            
            {
                a = spinner;
                super();
            }
        });
        b();
        return linearlayout;
_L2:
        k++;
          goto _L3
        k = 0;
          goto _L1
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
