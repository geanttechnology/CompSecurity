// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bestbuy.android.activities.registry.WishlistAddressFragment;

public class di
    implements TextWatcher
{

    final WishlistAddressFragment a;
    private EditText b;

    public di(WishlistAddressFragment wishlistaddressfragment, EditText edittext)
    {
        a = wishlistaddressfragment;
        super();
        b = edittext;
    }

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        b.getId();
        JVM INSTR lookupswitch 4: default 56
    //                   2131493748: 186
    //                   2131493864: 116
    //                   2131493866: 147
    //                   2131493867: 217;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_217;
_L6:
        if (WishlistAddressFragment.c(a) && WishlistAddressFragment.d(a) && WishlistAddressFragment.f(a) && WishlistAddressFragment.e(a) && WishlistAddressFragment.g(a))
        {
            WishlistAddressFragment.b(a, true);
            return;
        } else
        {
            WishlistAddressFragment.b(a, false);
            return;
        }
_L3:
        if (editable.isEmpty())
        {
            WishlistAddressFragment.c(a, false);
        } else
        {
            WishlistAddressFragment.c(a, true);
        }
          goto _L6
_L4:
        if (!editable.isEmpty() && editable.length() > 4)
        {
            WishlistAddressFragment.d(a, true);
        } else
        {
            WishlistAddressFragment.d(a, false);
        }
          goto _L6
_L2:
        if (editable.isEmpty())
        {
            WishlistAddressFragment.e(a, false);
        } else
        {
            WishlistAddressFragment.e(a, true);
        }
          goto _L6
        if (!editable.isEmpty() && editable.length() == 14)
        {
            WishlistAddressFragment.f(a, true);
        } else
        {
            WishlistAddressFragment.f(a, false);
        }
          goto _L6
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
