// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package jumiomobile:
//            ei

class el
    implements TextWatcher
{

    final ei a;

    el(ei ei1)
    {
        a = ei1;
        super();
    }

    public void afterTextChanged(Editable editable)
    {
        Object obj;
        Object obj1;
        obj = (new SimpleDateFormat("MM", Locale.getDefault())).format(new Date());
        obj1 = (new SimpleDateFormat("yy", Locale.getDefault())).format(new Date());
        ei.a(a).removeTextChangedListener(ei.e(a));
        if (editable.length() != 1 || editable.charAt(0) >= ((String) (obj1)).charAt(0)) goto _L2; else goto _L1
_L1:
        editable.delete(0, 1);
_L4:
        Selection.setSelection(editable, editable.length());
        ei.d(a);
        ei.a(a).addTextChangedListener(ei.e(a));
        return;
_L2:
        if (editable.length() == 2 && (a.getMonthText() == null || a.getMonthText().toString().equals("")))
        {
            Integer integer = Integer.valueOf(editable.toString());
            Integer integer2 = Integer.valueOf(((String) (obj1)));
            if (integer.intValue() < integer2.intValue())
            {
                editable.delete(1, 2);
            }
        } else
        if (editable.length() == 2 && a.getMonthText() != null && a.getMonthText().length() > 0)
        {
            Integer integer1 = Integer.valueOf(editable.toString());
            Integer integer3 = Integer.valueOf(a.getMonthText().toString());
            obj1 = Integer.valueOf(((String) (obj1)));
            obj = Integer.valueOf(((String) (obj)));
            if (integer1.compareTo(((Integer) (obj1))) < 0 || integer3.compareTo(((Integer) (obj))) < 0 && integer1.equals(obj1))
            {
                editable.delete(1, 2);
            }
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
            ei.b(a).requestFocus();
        }
    }
}
