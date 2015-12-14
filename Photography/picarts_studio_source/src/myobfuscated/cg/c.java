// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cg;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.photo.effects.factory.b;
import java.util.ArrayList;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.cg:
//            a, b, e, g, 
//            f, d

public class c extends a
    implements android.view.View.OnClickListener, android.widget.RadioGroup.OnCheckedChangeListener, android.widget.SeekBar.OnSeekBarChangeListener
{

    public ArrayList d;
    public ArrayList e;
    public ArrayList f;
    public ArrayList g;
    protected int h;

    public c(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        h = -1;
    }

    private void a(int i)
    {
        Object obj;
        if (c != null)
        {
            if ((obj = c.getActivity()) != null && !((Activity) (obj)).isFinishing() && i >= 0 && i < f.size())
            {
                h = i;
                i = ((Integer)((e)f.get(i)).c.c).intValue();
                com.socialin.android.colorpicker.c c1 = new com.socialin.android.colorpicker.c() {

                    private c a;

                    public final void a(int j)
                    {
                        a.a(a.h, j);
                        a.h = -1;
                    }

            
            {
                a = c.this;
                super();
            }
                };
                g g1 = new g();
                g1.a = c1;
                g1.e = i;
                g1.f = i;
                g1.c = true;
                obj = g1.a(((Context) (obj)));
                ((f) (obj)).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    private c a;

                    public final void onCancel(DialogInterface dialoginterface)
                    {
                        a.h = -1;
                    }

            
            {
                a = c.this;
                super();
            }
                });
                ((f) (obj)).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                    private c a;

                    public final void onDismiss(DialogInterface dialoginterface)
                    {
                        a.h = -1;
                    }

            
            {
                a = c.this;
                super();
            }
                });
                ((f) (obj)).show();
                return;
            }
        }
    }

    public static void a(EffectParameter effectparameter, TextView textview)
    {
        if (effectparameter.b == com.photo.effect.EffectParameter.ParameterType.ParameterTypeInt)
        {
            textview.setText(String.valueOf(((Integer)effectparameter.c).intValue()));
        } else
        if (effectparameter.b == com.photo.effect.EffectParameter.ParameterType.ParameterTypeFloat)
        {
            float f1 = ((Float)effectparameter.c).floatValue();
            textview.setText((new StringBuilder()).append((float)(int)(f1 * 100F) / 100F).toString());
            return;
        }
    }

    private boolean b(int i, int j)
    {
        if (i >= 0 && i < d.size())
        {
            Object obj = (myobfuscated.cg.g)d.get(i);
            TextView textview = ((myobfuscated.cg.g) (obj)).c;
            obj = ((myobfuscated.cg.g) (obj)).d;
            i = m.c(((EffectParameter) (obj)));
            ((EffectParameter) (obj)).a((float)j / (float)i);
            a(((EffectParameter) (obj)), textview);
            return true;
        } else
        {
            return false;
        }
    }

    private void d()
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 0;
_L6:
        if (i >= e.size()) goto _L1; else goto _L3
_L3:
        Object obj;
        String s;
        ArrayList arraylist;
        ArrayList arraylist1;
        int j;
        int k;
        obj = (myobfuscated.cg.f)e.get(i);
        s = ((myobfuscated.cg.f) (obj)).d.g;
        arraylist = ((myobfuscated.cg.f) (obj)).c;
        arraylist1 = ((myobfuscated.cg.f) (obj)).b;
        k = ((Integer)arraylist1.get(0)).intValue();
        j = 0;
_L7:
        if (j >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        if (s.compareTo((String)arraylist.get(j)) != 0) goto _L5; else goto _L4
_L4:
        j = ((Integer)arraylist1.get(j)).intValue();
_L8:
        obj = ((myobfuscated.cg.f) (obj)).a;
        ((RadioGroup) (obj)).setOnCheckedChangeListener(null);
        ((RadioGroup) (obj)).check(j);
        ((RadioGroup) (obj)).setTag(new Integer(i));
        ((RadioGroup) (obj)).setOnCheckedChangeListener(this);
        i++;
          goto _L6
_L5:
        j++;
          goto _L7
        j = k;
          goto _L8
    }

    private void e()
    {
        if (f != null)
        {
            int i = 0;
            while (i < f.size()) 
            {
                e e1 = (e)f.get(i);
                int j = ((Integer)e1.c.c).intValue();
                e1.a.setBackgroundColor(j);
                e1.b.setTag(new Integer(i));
                e1.b.setOnClickListener(this);
                i++;
            }
        }
    }

    private void f()
    {
        if (g != null)
        {
            int i = 0;
            while (i < g.size()) 
            {
                d d1 = (d)g.get(i);
                d1.a.setOnCheckedChangeListener(null);
                d1.a.setChecked(((Boolean)d1.c.c).booleanValue());
                d1.a.setTag(new Integer(i));
                d1.a.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                    private c a;

                    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                    {
                        int j = ((Integer)compoundbutton.getTag()).intValue();
                        a.a(j, flag);
                    }

            
            {
                a = c.this;
                super();
            }
                });
                i++;
            }
        }
    }

    public View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return null;
    }

    public final void a(int i, int j, int k, int l)
    {
        if (i > 0)
        {
            d = new ArrayList(i);
        }
        if (j > 0)
        {
            e = new ArrayList(j);
        }
        if (k > 0)
        {
            f = new ArrayList(k);
        }
        if (l > 0)
        {
            g = new ArrayList(l);
        }
    }

    public boolean a(int i, int j)
    {
        if (i >= 0 && i < f.size())
        {
            e e1 = (e)f.get(i);
            e1.c.c = Integer.valueOf(j);
            e1.a.setBackgroundColor(j);
            a(b, false);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean a(int i, boolean flag)
    {
        if (i >= 0 && i < g.size())
        {
            d d1 = (d)g.get(i);
            d1.c.c = new Boolean(flag);
            if (d1.b && c != null)
            {
                a(b, false);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public final void b()
    {
        if (d != null)
        {
            for (int i = 0; i < d.size(); i++)
            {
                Object obj1 = (myobfuscated.cg.g)d.get(i);
                SeekBar seekbar = ((myobfuscated.cg.g) (obj1)).a;
                Object obj = ((myobfuscated.cg.g) (obj1)).d.a;
                String s = com.socialin.android.photo.effects.factory.b.b(a, ((String) (obj)));
                ((myobfuscated.cg.g) (obj1)).b.setText((new StringBuilder()).append(s).append(" : ").toString());
                obj1 = ((myobfuscated.cg.g) (obj1)).c;
                obj = EffectParameter.a(b, ((String) (obj)));
                m.a(((EffectParameter) (obj)), seekbar);
                a(((EffectParameter) (obj)), ((TextView) (obj1)));
                seekbar.setOnSeekBarChangeListener(this);
                seekbar.setTag(new Integer(i));
            }

        }
        d();
        e();
        f();
    }

    public final void c()
    {
        if (h >= 0 && h < f.size())
        {
            a(h);
        }
    }

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        int j = ((Integer)radiogroup.getTag()).intValue();
        if (j >= 0 && j < e.size())
        {
            radiogroup = (myobfuscated.cg.f)e.get(j);
            String s = radiogroup.a(i);
            ((myobfuscated.cg.f) (radiogroup)).d.a(s);
            a(b, false);
        }
    }

    public void onClick(View view)
    {
        a(((Integer)view.getTag()).intValue());
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            b(((Integer)seekbar.getTag()).intValue(), i);
            a(b, true);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        b(((Integer)seekbar.getTag()).intValue(), seekbar.getProgress());
        a(b, false);
    }
}
