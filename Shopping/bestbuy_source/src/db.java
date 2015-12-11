// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bestbuy.android.activities.registry.WeddingAddressFragment;

public class db
    implements TextWatcher
{

    final WeddingAddressFragment a;
    private EditText b;

    public db(WeddingAddressFragment weddingaddressfragment, EditText edittext)
    {
        a = weddingaddressfragment;
        super();
        b = edittext;
    }

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        b.getId();
        JVM INSTR lookupswitch 6: default 72
    //                   2131493031: 161
    //                   2131493032: 192
    //                   2131493748: 293
    //                   2131493864: 223
    //                   2131493866: 254
    //                   2131493867: 324;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_324;
_L8:
        if (WeddingAddressFragment.b(a) && WeddingAddressFragment.c(a) && WeddingAddressFragment.d(a) && WeddingAddressFragment.e(a) && WeddingAddressFragment.f(a) && WeddingAddressFragment.g(a) && WeddingAddressFragment.h(a))
        {
            WeddingAddressFragment.b(a, true);
            WeddingAddressFragment.c(a, true);
            return;
        } else
        {
            WeddingAddressFragment.b(a, false);
            WeddingAddressFragment.c(a, false);
            return;
        }
_L2:
        if (editable.isEmpty())
        {
            WeddingAddressFragment.d(a, false);
        } else
        {
            WeddingAddressFragment.d(a, true);
        }
          goto _L8
_L3:
        if (editable.isEmpty())
        {
            WeddingAddressFragment.e(a, false);
        } else
        {
            WeddingAddressFragment.e(a, true);
        }
          goto _L8
_L5:
        if (editable.isEmpty())
        {
            WeddingAddressFragment.f(a, false);
        } else
        {
            WeddingAddressFragment.f(a, true);
        }
          goto _L8
_L6:
        if (!editable.isEmpty() && editable.length() > 4)
        {
            WeddingAddressFragment.g(a, true);
        } else
        {
            WeddingAddressFragment.g(a, false);
        }
          goto _L8
_L4:
        if (editable.isEmpty())
        {
            WeddingAddressFragment.h(a, false);
        } else
        {
            WeddingAddressFragment.h(a, true);
        }
          goto _L8
        if (!editable.isEmpty() && editable.length() == 14)
        {
            WeddingAddressFragment.i(a, true);
        } else
        {
            WeddingAddressFragment.i(a, false);
        }
          goto _L8
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
