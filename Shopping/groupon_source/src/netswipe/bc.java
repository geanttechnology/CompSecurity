// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package netswipe:
//            ba

class bc
    implements TextWatcher
{

    final ba a;
    private int b;

    bc(ba ba1)
    {
        a = ba1;
        super();
    }

    public void afterTextChanged(Editable editable)
    {
        boolean flag1;
        flag1 = true;
        ba.b(a).removeTextChangedListener(ba.c(a));
        if (editable.length() != 1 || editable.toString().equals("0") || editable.toString().equals("1")) goto _L2; else goto _L1
_L1:
        boolean flag;
        editable.insert(0, "0");
        flag = flag1;
_L4:
        if (flag)
        {
            Selection.setSelection(editable, editable.length());
            ba.a(a).requestFocus();
        }
        ba.d(a);
        ba.b(a).addTextChangedListener(ba.c(a));
        return;
_L2:
        if (editable.length() == 2)
        {
            if (editable.charAt(0) == '1' && editable.charAt(1) != '0' && editable.charAt(1) != '1' && editable.charAt(1) != '2' || editable.charAt(0) == '0' && editable.charAt(1) == '0')
            {
                editable.delete(1, 2);
                flag = false;
            } else
            {
                flag = flag1;
                if (editable.charAt(0) != '0')
                {
                    flag = flag1;
                    if (editable.charAt(0) != '1')
                    {
                        flag = flag1;
                        if (b == 0)
                        {
                            editable.delete(0, 1);
                            flag = false;
                        }
                    }
                }
            }
        } else
        if (editable.length() == 3)
        {
            CharSequence charsequence = editable.subSequence(2, 3);
            editable.delete(2, 3);
            flag = flag1;
            if (ba.a(a).getText().length() <= 1)
            {
                ba.a(a).getText().insert(0, charsequence);
                flag = flag1;
            }
        } else
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        b = i;
    }
}
