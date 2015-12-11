// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.braintreepayments.cardform.a.a;

// Referenced classes of package com.braintreepayments.cardform.view:
//            c, h, a

public class CardEditText extends c
    implements TextWatcher
{

    private a b;
    private com.braintreepayments.cardform.view.a c;

    public CardEditText(Context context)
    {
        super(context);
        b = a.b;
        d();
    }

    public CardEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = a.b;
        d();
    }

    public CardEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = a.b;
        d();
    }

    private static void a(Editable editable, int ai[])
    {
        int j = editable.length();
        int k = ai.length;
        for (int i = 0; i < k; i++)
        {
            int l = ai[i];
            if (l <= j)
            {
                editable.setSpan(new h(), l - 1, l, 33);
            }
        }

    }

    private void d()
    {
        setInputType(2);
        setCardIcon(0x7f020089);
        addTextChangedListener(this);
    }

    private void setCardIcon(int i)
    {
        if (a)
        {
            setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            return;
        } else
        {
            setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
            return;
        }
    }

    public final boolean a()
    {
        return b.a(getText().toString());
    }

    public void afterTextChanged(Editable editable)
    {
        Object aobj[] = editable.getSpans(0, editable.length(), com/braintreepayments/cardform/view/h);
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            editable.removeSpan(aobj[i]);
        }

        a a1 = com.braintreepayments.cardform.a.a.b(getText().toString());
        if (b != a1)
        {
            b = a1;
            setFilters(new InputFilter[] {
                new android.text.InputFilter.LengthFilter(b.c())
            });
            invalidate();
            if (c != null)
            {
                c.a(b);
            }
        }
        setCardIcon(b.a());
        if (!a)
        {
            a(editable, b.d());
        }
        if (b.c() == getSelectionStart())
        {
            c();
            if (a())
            {
                b();
            }
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public a getCardType()
    {
        return b;
    }

    public void setOnCardTypeChangedListener(com.braintreepayments.cardform.view.a a1)
    {
        c = a1;
    }
}
