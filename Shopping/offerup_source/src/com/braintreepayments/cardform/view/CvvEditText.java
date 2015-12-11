// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.braintreepayments.cardform.a.a;

// Referenced classes of package com.braintreepayments.cardform.view:
//            c

public class CvvEditText extends c
    implements TextWatcher
{

    private a b;
    private boolean c;

    public CvvEditText(Context context)
    {
        super(context);
        c = false;
        d();
    }

    public CvvEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = false;
        d();
    }

    public CvvEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = false;
        d();
    }

    private void d()
    {
        setInputType(2);
        setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(3)
        });
        addTextChangedListener(this);
    }

    private int getSecurityCodeLength()
    {
        if (b == null)
        {
            return 3;
        } else
        {
            return b.b();
        }
    }

    public final boolean a()
    {
        return getText().toString().length() == getSecurityCodeLength();
    }

    public void afterTextChanged(Editable editable)
    {
        if (b != null && b.b() == editable.length() && getSelectionStart() == editable.length())
        {
            c();
            if (a())
            {
                b();
                return;
            }
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        if (flag || c)
        {
            if (b != null && b == a.a)
            {
                i = 0x7f02008a;
            } else
            {
                i = 0x7f02008c;
            }
        } else
        {
            i = 0;
        }
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

    public void setAlwaysDisplayHint(boolean flag)
    {
        c = flag;
        invalidate();
    }

    public void setCardType(a a1)
    {
        b = a1;
        setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(a1.b())
        });
        invalidate();
    }
}
