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

public final class fj
    implements TextWatcher
{

    private EditText a;
    private PaymentMethodCaptureActivity b;

    public fj(PaymentMethodCaptureActivity paymentmethodcaptureactivity, EditText edittext)
    {
        b = paymentmethodcaptureactivity;
        super();
        a = edittext;
    }

    private static String a(CharSequence charsequence)
    {
        String s = "";
        int j = 0;
        int i = 0;
        for (; j < charsequence.length(); j++)
        {
            String s1 = (new StringBuilder()).append(s).append(charsequence.charAt(j)).toString();
            int k = i + 1;
            s = s1;
            i = k;
            if (k == 4)
            {
                s = (new StringBuilder()).append(s1).append(" ").toString();
                i = 0;
            }
        }

        return s;
    }

    public final void afterTextChanged(Editable editable)
    {
        if (editable.length() <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        obj = editable.toString();
        i = ((String) (obj)).length();
        if (i <= 0) goto _L4; else goto _L3
_L3:
        String s;
        b.x = false;
        b.s.setFilters(b.o);
        b.u.setFilters(b.r);
        s = PaymentMethodCaptureActivity.a(b, ((CharSequence) (obj)));
        if (!b.k.matcher(s).matches()) goto _L6; else goto _L5
_L5:
        b.x = true;
        PaymentMethodCaptureActivity.a(b, 2);
        b.s.setFilters(b.p);
        b.u.setFilters(b.q);
        if (s.length() == 15)
        {
            b.t.requestFocus();
        }
          goto _L4
_L6:
        if (!b.d.matcher(s).matches()) goto _L8; else goto _L7
_L7:
        PaymentMethodCaptureActivity.a(b, 1);
        if (s.length() == 16)
        {
            b.t.requestFocus();
        }
          goto _L4
_L8:
        if (!b.j.matcher(s).matches()) goto _L10; else goto _L9
_L9:
        PaymentMethodCaptureActivity.a(b, 3);
        if (s.length() == 16)
        {
            b.t.requestFocus();
        }
          goto _L4
_L10:
        if (!b.l.matcher(s).matches()) goto _L12; else goto _L11
_L11:
        PaymentMethodCaptureActivity.a(b, 4);
        if (s.length() == 16)
        {
            b.t.requestFocus();
        }
          goto _L4
_L12:
        if (!b.m.matcher(s).matches()) goto _L14; else goto _L13
_L13:
        PaymentMethodCaptureActivity.a(b, 5);
        if (s.length() == 16)
        {
            b.t.requestFocus();
        }
          goto _L4
_L14:
        if (!b.n.matcher(s).matches()) goto _L16; else goto _L15
_L15:
        PaymentMethodCaptureActivity.a(b, 6);
        if (s.length() == 16)
        {
            b.t.requestFocus();
        }
          goto _L4
_L16:
        try
        {
            PaymentMethodCaptureActivity.a(b, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Editable editable)
        {
            g.a(this, editable);
            return;
        }
          goto _L4
_L22:
        if (b.x)
        {
            if (i >= 16)
            {
                break; /* Loop/switch isn't completed */
            }
        } else
        if (i >= 19)
        {
            return;
        }
        if (b.x && b.b.matcher(editable).matches() || b.a.matcher(editable).matches())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!b.x) goto _L18; else goto _L17
_L17:
        s = PaymentMethodCaptureActivity.a(b, ((CharSequence) (obj)));
        editable = "";
        i = 0;
_L23:
        obj = editable;
        if (i >= s.length()) goto _L20; else goto _L19
_L19:
        obj = (new StringBuilder()).append(editable).append(s.charAt(i)).toString();
        if (i != 3)
        {
            break MISSING_BLOCK_LABEL_579;
        }
        editable = (new StringBuilder()).append(((String) (obj))).append(" ").toString();
        break MISSING_BLOCK_LABEL_675;
        editable = ((Editable) (obj));
        if (i != 9)
        {
            break MISSING_BLOCK_LABEL_675;
        }
        editable = (new StringBuilder()).append(((String) (obj))).append(" ").toString();
        break MISSING_BLOCK_LABEL_675;
_L18:
        obj = a(PaymentMethodCaptureActivity.a(b, ((CharSequence) (obj))));
_L20:
        a.removeTextChangedListener(this);
        a.setText(((CharSequence) (obj)));
        a.setSelection(((String) (obj)).length());
_L21:
        a.addTextChangedListener(this);
        return;
        editable;
        g.a(this, editable);
        if (true) goto _L21; else goto _L4
_L4:
        if (i >= 3) goto _L22; else goto _L2
_L2:
        return;
        i++;
          goto _L23
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
