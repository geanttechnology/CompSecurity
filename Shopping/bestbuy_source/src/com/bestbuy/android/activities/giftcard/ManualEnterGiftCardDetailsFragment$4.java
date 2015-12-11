// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.giftcard;

import android.text.Editable;
import android.text.TextWatcher;
import com.bestbuy.android.bbyobjects.BBYButton;

// Referenced classes of package com.bestbuy.android.activities.giftcard:
//            ManualEnterGiftCardDetailsFragment

class a
    implements TextWatcher
{

    final ManualEnterGiftCardDetailsFragment a;

    public void afterTextChanged(Editable editable)
    {
        if (editable.toString().length() == 4)
        {
            ManualEnterGiftCardDetailsFragment.b(a, true);
        } else
        {
            ManualEnterGiftCardDetailsFragment.b(a, false);
        }
        if (ManualEnterGiftCardDetailsFragment.d(a) && ManualEnterGiftCardDetailsFragment.e(a))
        {
            ManualEnterGiftCardDetailsFragment.a(a).setEnabled(true);
            return;
        } else
        {
            ManualEnterGiftCardDetailsFragment.a(a).setEnabled(false);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    (ManualEnterGiftCardDetailsFragment manualentergiftcarddetailsfragment)
    {
        a = manualentergiftcarddetailsfragment;
        super();
    }
}
