// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            eo, ez, eb, cf, 
//            mf, fa, en, cs, 
//            c

public class ey extends eo
{

    protected ArrayList a;
    protected boolean b;
    protected boolean c;
    protected TextView d;
    protected Spinner e;
    private String n;
    private String o;

    public ey(Context context, String s, boolean flag, String s1)
    {
        super(context);
        n = s;
        b = flag;
        o = s1;
        c = true;
        setLayoutParams(new android.widget.TableLayout.LayoutParams(-2, -2));
        setOrientation(0);
        setGravity(16);
        d = new TextView(context);
        s1 = new android.widget.TableRow.LayoutParams(-2, -2);
        d.setLayoutParams(s1);
        d.setTextColor(0xff646464);
        d.setTextSize(2, 18F);
        addView(d);
        e = new Spinner(context);
        s1 = new android.widget.TableRow.LayoutParams(0, -2);
        s1.weight = 1.0F;
        e.setPrompt(s);
        e.setOnFocusChangeListener(new ez(this, context));
        e.setLayoutParams(s1);
        e.setGravity(5);
        e.setFocusable(true);
        e.setFocusableInTouchMode(true);
        context = cf.a(context, eb.t, eb.u);
        mf.a(e, context);
        e.setOnItemSelectedListener(new fa(this));
        addView(e);
    }

    public boolean a()
    {
        return !b || e.getSelectedItem() != null;
    }

    protected void b()
    {
label0:
        {
            boolean flag = a();
            if (m != null)
            {
                if (!flag)
                {
                    break label0;
                }
                m.a(this);
            }
            return;
        }
        m.b(this);
    }

    public Editable getValueText()
    {
        Object obj1 = e.getSelectedItem();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = "";
        }
        return new SpannableStringBuilder(obj.toString());
    }

    public void setEnabled(boolean flag)
    {
        d.setEnabled(flag);
        e.setEnabled(flag);
    }

    public void setLabelId(int i)
    {
        d.setId(i);
    }

    public void setLabelText(CharSequence charsequence)
    {
        d.setText(charsequence);
        if (cs.a())
        {
            e.setContentDescription(charsequence);
        }
    }

    public void setValueHint(CharSequence charsequence)
    {
        e.setPrompt(charsequence);
    }

    public void setValueId(int i)
    {
        e.setId(i);
    }

    public void setValues(ArrayList arraylist)
    {
        a = arraylist;
        Spinner spinner = e;
        Context context = getContext();
        String s = n;
        boolean flag;
        if (!b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        spinner.setAdapter(new c(context, arraylist, s, flag, o));
        e.setSelection(0);
    }
}
