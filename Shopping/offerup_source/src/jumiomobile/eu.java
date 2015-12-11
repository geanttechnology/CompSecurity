// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

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

// Referenced classes of package jumiomobile:
//            fs, et, ec, en

class eu
    implements TextWatcher
{

    final et a;
    private int b;
    private boolean c;

    eu(et et1)
    {
        a = et1;
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
        obj = fs.b(stringbuilder);
        j = fs.a(stringbuilder, true, ((CreditCardType) (obj)));
        if (obj == CreditCardType.UNKNOWN && editable.length() <= 6) goto _L2; else goto _L1
_L1:
        android.graphics.Bitmap bitmap = et.a(a, ((CreditCardType) (obj)));
        et.a(a).setImageBitmap(bitmap);
        if (bitmap != null)
        {
            a.a(true);
        }
        if (et.b(a) == null) goto _L4; else goto _L3
_L3:
        boolean flag;
        int i;
        if (!et.b(a).contains(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            et.c(a).setText(ec.a(a.getContext(), "manual_entry_card_number_not_supported"));
        }
        obj = et.e(a);
        if (flag || !et.d(a))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        obj = a.b;
        if (flag || !et.d(a))
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
        fs.a(stringbuilder);
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
            a.m.b(et.f(a));
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
            et.e(a).setVisibility(8);
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
