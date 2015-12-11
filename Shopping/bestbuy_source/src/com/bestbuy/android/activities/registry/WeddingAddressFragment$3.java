// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.text.InputFilter;
import android.text.Spanned;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingAddressFragment

class a
    implements InputFilter
{

    final WeddingAddressFragment a;

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        if (charsequence != null && WeddingAddressFragment.i(a).contains((new StringBuilder()).append("").append(charsequence).toString()))
        {
            return "";
        } else
        {
            return null;
        }
    }

    (WeddingAddressFragment weddingaddressfragment)
    {
        a = weddingaddressfragment;
        super();
    }
}
