// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.util.ArrayList;

// Referenced classes of package netswipe:
//            cw, bp, ar, bh

class bq
    implements TextWatcher
{

    final bp a;
    private int b;
    private boolean c;

    bq(bp bp1)
    {
        a = bp1;
        super();
        b = -1;
        c = false;
    }

    public void afterTextChanged(Editable editable)
    {
        StringBuilder stringbuilder;
        Object obj;
        int j;
        stringbuilder = new StringBuilder(editable);
        obj = cw.b(stringbuilder);
        j = cw.a(stringbuilder, true, ((CreditCardType) (obj)));
        if (obj == CreditCardType.UNKNOWN && editable.length() <= 6) goto _L2; else goto _L1
_L1:
        bp.a(a).setImageBitmap(bp.a(a, ((CreditCardType) (obj))));
        a.a(true);
        if (bp.b(a) == null) goto _L4; else goto _L3
_L3:
        boolean flag;
        int i;
        if (!bp.b(a).contains(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bp.c(a).setText(ar.a(a.getContext(), "manual_entry_card_number_not_supported"));
        }
        obj = bp.e(a);
        if (flag || !bp.d(a))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        obj = a.b;
        if (flag || !bp.d(a))
        {
            i = 0xffcc0000;
        } else
        {
            i = 0xff444444;
        }
        ((EditText) (obj)).setTextColor(i);
_L6:
        a.b.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(j)
        });
        a.b.removeTextChangedListener(this);
        stringbuilder = cw.a(stringbuilder);
        editable.clear();
        editable.append(stringbuilder);
        a.b.addTextChangedListener(this);
        if (editable.length() == j && !flag)
        {
            a.b();
        }
        if (c)
        {
            a.b(false);
            a.d.b(bp.f(a));
        }
        if (b != -1 && b < stringbuilder.length())
        {
            if (editable.charAt(b) == ' ' && !c || b - 1 > 0 && editable.charAt(b - 1) == ' ' && !c)
            {
                b = b + 1;
            }
            Selection.setSelection(editable, b);
            a.b();
        }
        if (editable.length() != j && !flag)
        {
            bp.e(a).setVisibility(8);
            a.b.setTextColor(0xff444444);
        }
        stringbuilder.delete(0, stringbuilder.length());
        return;
_L2:
        a.a(false);
_L4:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        b = -1;
        c = false;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (j > k)
        {
            b = i;
            c = true;
        } else
        if (i + k < charsequence.length())
        {
            b = i + k;
            return;
        }
    }
}
