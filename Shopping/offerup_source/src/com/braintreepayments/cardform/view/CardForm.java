// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.braintreepayments.cardform.a;
import com.braintreepayments.cardform.b;
import com.braintreepayments.cardform.c;

// Referenced classes of package com.braintreepayments.cardform.view:
//            a, CardEditText, MonthYearEditText, CvvEditText, 
//            PostalCodeEditText

public class CardForm extends LinearLayout
    implements TextWatcher, android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.widget.TextView.OnEditorActionListener, com.braintreepayments.cardform.view.a
{

    private CardEditText a;
    private MonthYearEditText b;
    private CvvEditText c;
    private PostalCodeEditText d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private c j;
    private b k;
    private a l;

    public CardForm(Context context)
    {
        super(context);
        i = false;
        g();
    }

    public CardForm(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        i = false;
        g();
    }

    public CardForm(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        i = false;
        g();
    }

    public CardForm(Context context, AttributeSet attributeset, int i1, int j1)
    {
        super(context, attributeset, i1, j1);
        i = false;
        g();
    }

    private void a(EditText edittext)
    {
        edittext.requestFocus();
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(edittext, 1);
    }

    private void a(EditText edittext, String s)
    {
        edittext.setImeOptions(2);
        edittext.setImeActionLabel(s, 2);
        edittext.setOnEditorActionListener(this);
    }

    private void g()
    {
        inflate(getContext(), 0x7f04005e, this);
        setVisibility(8);
        a = (CardEditText)findViewById(0x7f100198);
        b = (MonthYearEditText)findViewById(0x7f100199);
        c = (CvvEditText)findViewById(0x7f10019a);
        d = (PostalCodeEditText)findViewById(0x7f10019b);
        a.setOnFocusChangeListener(this);
        b.setOnFocusChangeListener(this);
        c.setOnFocusChangeListener(this);
        d.setOnFocusChangeListener(this);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        a.setOnCardTypeChangedListener(this);
    }

    public final void a(Activity activity, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            activity.getWindow().setFlags(8192, 8192);
        }
        e = true;
        f = true;
        g = flag2;
        h = flag3;
        a.addTextChangedListener(this);
        b.addTextChangedListener(this);
        if (flag2 || flag3)
        {
            b.setImeOptions(5);
        } else
        {
            a(((EditText) (b)), s);
        }
        if (flag2)
        {
            c.addTextChangedListener(this);
            if (flag3)
            {
                c.setImeOptions(5);
            } else
            {
                a(((EditText) (c)), s);
            }
        } else
        {
            c.setVisibility(8);
        }
        if (flag3)
        {
            d.addTextChangedListener(this);
            a(((EditText) (d)), s);
        } else
        {
            d.setVisibility(8);
        }
        a.setOnCardTypeChangedListener(this);
        setVisibility(0);
    }

    public final void a(com.braintreepayments.cardform.a.a a1)
    {
        c.setCardType(a1);
    }

    public final boolean a()
    {
        boolean flag;
        boolean flag1;
        if (e)
        {
            if (a.a())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        } else
        {
            flag1 = true;
        }
        flag = flag1;
        if (f)
        {
            if (flag1 && b.a())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        flag1 = flag;
        if (g)
        {
            if (flag && c.a())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        if (h)
        {
            return flag1 && d.a();
        } else
        {
            return flag1;
        }
    }

    public void afterTextChanged(Editable editable)
    {
        boolean flag = a();
        if (i != flag)
        {
            i = flag;
            if (j != null)
            {
                j.onCardFormValid(flag);
            }
        }
    }

    public final void b()
    {
        if (e)
        {
            a.c();
        }
        if (f)
        {
            b.c();
        }
        if (g)
        {
            c.c();
        }
        if (h)
        {
            d.c();
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
    {
    }

    public final void c()
    {
        if (e)
        {
            a.setError(true);
            a(a);
        }
    }

    public final void d()
    {
        if (f)
        {
            b.setError(true);
            if (!e || !a.isFocused())
            {
                a(b);
            }
        }
    }

    public final void e()
    {
        if (g)
        {
            c.setError(true);
            if (!e && !f || !a.isFocused() && !b.isFocused())
            {
                a(c);
            }
        }
    }

    public final void f()
    {
        if (h)
        {
            d.setError(true);
            if (!e && !f && !g || !a.isFocused() && !b.isFocused() && !c.isFocused())
            {
                a(d);
            }
        }
    }

    public String getCardNumber()
    {
        return a.getText().toString();
    }

    public String getCvv()
    {
        return c.getText().toString();
    }

    public String getExpirationMonth()
    {
        return b.getMonth();
    }

    public String getExpirationYear()
    {
        return b.getYear();
    }

    public String getPostalCode()
    {
        return d.getText().toString();
    }

    public void onClick(View view)
    {
        if (l != null)
        {
            l.onCardFormFieldFocused(view);
        }
    }

    public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
    {
        if (i1 == 2 && k != null)
        {
            k.onCardFormSubmit();
            return true;
        } else
        {
            return false;
        }
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (flag && l != null)
        {
            l.onCardFormFieldFocused(view);
        }
    }

    public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
    {
    }

    public void setEnabled(boolean flag)
    {
        a.setEnabled(flag);
        b.setEnabled(flag);
        c.setEnabled(flag);
        d.setEnabled(flag);
    }

    public void setOnCardFormSubmitListener(b b1)
    {
        k = b1;
    }

    public void setOnCardFormValidListener(c c1)
    {
        j = c1;
    }

    public void setOnFormFieldFocusedListener(a a1)
    {
        l = a1;
    }
}
