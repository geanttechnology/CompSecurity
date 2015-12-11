// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package netswipe:
//            ba

class bd
    implements TextWatcher
{

    final ba a;

    bd(ba ba1)
    {
        a = ba1;
        super();
    }

    public void afterTextChanged(Editable editable)
    {
        String s;
        String s1;
        s = (new SimpleDateFormat("MM", Locale.getDefault())).format(new Date());
        s1 = (new SimpleDateFormat("yy", Locale.getDefault())).format(new Date());
        ba.a(a).removeTextChangedListener(ba.e(a));
        if (editable.length() != 1 || editable.charAt(0) >= s1.charAt(0)) goto _L2; else goto _L1
_L1:
        editable.delete(0, 1);
_L4:
        Selection.setSelection(editable, editable.length());
        ba.d(a);
        ba.a(a).addTextChangedListener(ba.e(a));
        return;
_L2:
        if (editable.length() == 2 && (Integer.valueOf(editable.toString()).intValue() < Integer.valueOf(s1).intValue() || Integer.valueOf(a.getMonthText().toString()).intValue() < Integer.valueOf(s).intValue() && Integer.valueOf(editable.toString()) == Integer.valueOf(s1)))
        {
            editable.delete(1, 2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (j > i && k == 0)
        {
            ba.b(a).requestFocus();
        }
    }
}
