// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.text.Editable;
import android.text.TextWatcher;
import com.b.a.a.g;
import com.offerup.android.utils.as;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodCaptureActivity

public final class fk
    implements TextWatcher
{

    private PaymentMethodCaptureActivity a;

    public fk(PaymentMethodCaptureActivity paymentmethodcaptureactivity)
    {
        a = paymentmethodcaptureactivity;
        super();
    }

    public final void afterTextChanged(Editable editable)
    {
        try
        {
            if (editable.length() == 5)
            {
                as.a(a, a.v);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Editable editable)
        {
            g.a(this, editable);
        }
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
