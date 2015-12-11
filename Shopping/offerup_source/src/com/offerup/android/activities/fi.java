// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.b.a.a.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodCaptureActivity

public final class fi
    implements TextWatcher
{

    private EditText a;
    private PaymentMethodCaptureActivity b;

    public fi(PaymentMethodCaptureActivity paymentmethodcaptureactivity, EditText edittext)
    {
        b = paymentmethodcaptureactivity;
        super();
        a = edittext;
    }

    public final void afterTextChanged(Editable editable)
    {
        if (editable.length() <= 0) goto _L2; else goto _L1
_L1:
        String s3;
        String s = editable.toString();
        s3 = PaymentMethodCaptureActivity.a(b, s);
        String s1;
        int i;
        s1 = "";
        i = 0;
_L8:
        if (i >= s3.length()) goto _L4; else goto _L3
_L3:
        String s2 = (new StringBuilder()).append(s1).append(s3.charAt(i)).toString();
        s1 = s2;
        if (i != 1) goto _L6; else goto _L5
_L5:
        s1 = (new StringBuilder()).append(s2).append(" / ").toString();
          goto _L6
_L4:
        if (s3.length() == 4)
        {
            b.u.requestFocus();
        }
        if (b.c.matcher(editable).matches())
        {
            return;
        }
        a.removeTextChangedListener(this);
        a.setText(s1);
        a.setSelection(s1.length());
_L7:
        try
        {
            a.addTextChangedListener(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Editable editable)
        {
            g.a(this, editable);
        }
        return;
        editable;
        g.a(this, editable);
        if (true) goto _L7; else goto _L6
_L6:
        i++;
        if (true) goto _L8; else goto _L2
_L2:
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
