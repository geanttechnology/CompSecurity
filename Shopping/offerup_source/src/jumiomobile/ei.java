// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import java.nio.CharBuffer;

// Referenced classes of package jumiomobile:
//            ee, ek, el, em, 
//            bg, ed, ec, ej, 
//            cs, fs

public class ei extends ee
{

    private EditText n;
    private EditText o;
    private EditText p;
    private boolean q;
    private TextWatcher r;
    private TextWatcher s;
    private android.view.View.OnFocusChangeListener t;

    public ei(Context context)
    {
        super(context);
        q = false;
        r = new ek(this);
        s = new el(this);
        t = new em(this);
        d = false;
        int i = bg.a(context, 9);
        b.removeTextChangedListener(e);
        int j = indexOfChild(b);
        removeView(b);
        RelativeLayout relativelayout = new RelativeLayout(context);
        Object obj = new android.widget.TableRow.LayoutParams(-1, -2);
        obj.weight = 1.0F;
        relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.setPadding(0, 0, 0, 0);
        addView(relativelayout, j);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        b.setId(ed.E);
        b.setHint("");
        b.setTextColor(0);
        b.setEnabled(false);
        b.setFocusable(false);
        b.setPadding(0, i, 0, i);
        b.setTextSize(2, 20F);
        relativelayout.addView(b);
        n = new EditText(context);
        n.setHint(ec.a(context, "manual_entry_hint_year"));
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        n.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        n.setPadding(0, i, 0, i);
        n.setTextSize(2, 20F);
        n.setTypeface(b.getTypeface());
        n.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        n.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(2)
        });
        n.setBackgroundColor(0);
        n.setImeOptions(5);
        n.addTextChangedListener(s);
        n.setOnFocusChangeListener(t);
        n.setTextColor(0xff444444);
        n.setHintTextColor(b.getHintTextColors());
        n.setOnKeyListener(new ej(this));
        n.setLongClickable(false);
        n.setId(ed.F);
        if (cs.a())
        {
            n.setContentDescription("ExipryYear");
        }
        a(n);
        relativelayout.addView(n);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(0, n.getId());
        o = new EditText(context);
        o.setHint("/");
        o.setEnabled(false);
        o.setId(b.getId() + 2001);
        o.setHintTextColor(0xff969696);
        o.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        o.setPadding(0, i, 0, i);
        o.setTextSize(2, 20F);
        o.setTypeface(b.getTypeface());
        o.setGravity(17);
        o.setBackgroundColor(0);
        o.setFocusable(false);
        relativelayout.addView(o);
        p = new EditText(context);
        p.setHint(ec.a(context, "manual_entry_hint_month"));
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(0, o.getId());
        p.setLayoutParams(context);
        p.setPadding(0, i, 0, i);
        p.setTextSize(2, 20F);
        p.setTypeface(b.getTypeface());
        p.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        p.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(3)
        });
        p.setBackgroundColor(0);
        p.setImeOptions(5);
        p.addTextChangedListener(r);
        p.setOnFocusChangeListener(t);
        p.setLongClickable(false);
        p.setTextColor(0xff444444);
        p.setHintTextColor(b.getHintTextColors());
        p.setId(ed.G);
        if (cs.a())
        {
            n.setContentDescription("ExipryMonth");
        }
        a(p);
        relativelayout.addView(p);
        setValidationPattern(fs.a());
    }

    static EditText a(ei ei1)
    {
        return ei1.n;
    }

    static boolean a(ei ei1, boolean flag)
    {
        ei1.q = flag;
        return flag;
    }

    static EditText b(ei ei1)
    {
        return ei1.p;
    }

    static TextWatcher c(ei ei1)
    {
        return ei1.r;
    }

    private void d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(p.getText());
        stringbuilder.append(" / ");
        stringbuilder.append(n.getText());
        b.setText(stringbuilder);
        b();
    }

    static void d(ei ei1)
    {
        ei1.d();
    }

    static TextWatcher e(ei ei1)
    {
        return ei1.s;
    }

    static boolean f(ei ei1)
    {
        return ei1.q;
    }

    public void a(char ac[], char ac1[])
    {
        p.setText(CharBuffer.wrap(ac));
        n.setText(CharBuffer.wrap(ac1));
        d();
    }

    public boolean a()
    {
        int j = 0xff444444;
        boolean flag = super.a();
        if (b.length() == 7)
        {
            EditText edittext = n;
            int i;
            if (flag)
            {
                i = 0xff444444;
            } else
            {
                i = 0xffcc0000;
            }
            edittext.setTextColor(i);
            edittext = p;
            if (flag)
            {
                i = j;
            } else
            {
                i = 0xffcc0000;
            }
            edittext.setTextColor(i);
        }
        return flag;
    }

    public Editable getMonthText()
    {
        return p.getText();
    }

    public Editable getYearText()
    {
        return n.getText();
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        n.setEnabled(flag);
        p.setEnabled(flag);
    }

    public void setTypeface(Typeface typeface)
    {
        n.setTypeface(typeface);
        o.setTypeface(typeface);
        p.setTypeface(typeface);
        b.setTypeface(typeface);
    }

    public void setValueId(int i)
    {
    }

    public void setValueText(CharSequence charsequence)
    {
    }
}
