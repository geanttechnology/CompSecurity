// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package jumiomobile:
//            ei

class ek
    implements TextWatcher
{

    final ei a;
    private int b;

    ek(ei ei1)
    {
        a = ei1;
        super();
    }

    public void afterTextChanged(Editable editable)
    {
        boolean flag;
        flag = false;
        ei.b(a).removeTextChangedListener(ei.c(a));
        if (editable.length() != 1 || editable.toString().equals("0") || editable.toString().equals("1")) goto _L2; else goto _L1
_L1:
        editable.insert(0, "0");
_L7:
        flag = true;
_L4:
        if (flag)
        {
            Selection.setSelection(editable, editable.length());
            ei.a(a).requestFocus();
        }
        ei.d(a);
        ei.b(a).addTextChangedListener(ei.c(a));
        return;
_L2:
        if (editable.length() != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        if (editable.charAt(0) == '1' && editable.charAt(1) != '0' && editable.charAt(1) != '1' && editable.charAt(1) != '2' || editable.charAt(0) == '0' && editable.charAt(1) == '0')
        {
            editable.delete(1, 2);
        } else
        if (editable.charAt(0) != '0' && editable.charAt(0) != '1' && b == 0)
        {
            editable.delete(0, 1);
        } else
        {
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (editable.length() != 3) goto _L4; else goto _L5
_L5:
        CharSequence charsequence = editable.subSequence(2, 3);
        editable.delete(2, 3);
        if (ei.a(a).getText().length() <= 1)
        {
            ei.a(a).getText().insert(0, charsequence);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        b = i;
    }
}
