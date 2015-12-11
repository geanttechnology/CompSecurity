// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.b.a.a.g;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodCaptureActivity

public final class fh
    implements TextWatcher
{

    private PaymentMethodCaptureActivity a;

    public fh(PaymentMethodCaptureActivity paymentmethodcaptureactivity)
    {
        a = paymentmethodcaptureactivity;
        super();
    }

    public final void afterTextChanged(Editable editable)
    {
        int i = editable.length();
        if (a.x && i == 4)
        {
            try
            {
                a.v.requestFocus();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Editable editable)
            {
                g.a(this, editable);
            }
            break MISSING_BLOCK_LABEL_67;
        }
        if (a.x || i != 3)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        a.v.requestFocus();
        return;
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
