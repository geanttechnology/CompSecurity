// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.widget.EditText;
import android.widget.RelativeLayout;

// Referenced classes of package netswipe:
//            aw, bc, bd, be, 
//            as, dc, ar, bb, 
//            cw

public class ba extends aw
{

    private EditText n;
    private EditText o;
    private EditText p;
    private boolean q;
    private TextWatcher r;
    private TextWatcher s;
    private android.view.View.OnFocusChangeListener t;

    public ba(Context context)
    {
        super(context);
        q = false;
        r = new bc(this);
        s = new bd(this);
        t = new be(this);
        e = false;
        b.removeTextChangedListener(m);
        int i = indexOfChild(b);
        removeView(b);
        RelativeLayout relativelayout = new RelativeLayout(context);
        Object obj = new android.widget.TableRow.LayoutParams(-1, -2);
        obj.weight = 1.0F;
        relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        addView(relativelayout, i);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        b.setId(as.I);
        b.setHint("");
        b.setTextColor(0);
        b.setEnabled(false);
        b.setFocusable(false);
        relativelayout.addView(b);
        i = dc.a(context, 17);
        n = new EditText(context);
        n.setHint(ar.a(context, "manual_entry_hint_year"));
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        n.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        n.setTextSize(0, i);
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
        n.setOnKeyListener(new bb(this));
        n.setLongClickable(false);
        n.setId(as.J);
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
        o.setTextSize(0, i);
        o.setTypeface(b.getTypeface());
        o.setGravity(17);
        o.setBackgroundColor(0);
        o.setFocusable(false);
        o.setPadding(0, o.getPaddingTop(), 0, o.getPaddingBottom());
        relativelayout.addView(o);
        p = new EditText(context);
        p.setHint(ar.a(context, "manual_entry_hint_month"));
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(0, o.getId());
        p.setLayoutParams(context);
        p.setTextSize(0, i);
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
        p.setId(as.K);
        a(p);
        relativelayout.addView(p);
        setValidationPattern(cw.a());
    }

    static EditText a(ba ba1)
    {
        return ba1.n;
    }

    static boolean a(ba ba1, boolean flag)
    {
        ba1.q = flag;
        return flag;
    }

    static EditText b(ba ba1)
    {
        return ba1.p;
    }

    static TextWatcher c(ba ba1)
    {
        return ba1.r;
    }

    private void d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(p.getText());
        stringbuilder.append(" / ");
        stringbuilder.append(n.getText());
        b.setText(stringbuilder);
        if (stringbuilder.length() == 7)
        {
            b();
        }
    }

    static void d(ba ba1)
    {
        ba1.d();
    }

    static TextWatcher e(ba ba1)
    {
        return ba1.s;
    }

    static boolean f(ba ba1)
    {
        return ba1.q;
    }

    public boolean a()
    {
        int j = 0xff444444;
        boolean flag = super.a();
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

    public void setValueId(int i)
    {
    }

    public void setValueText(CharSequence charsequence)
    {
    }
}
