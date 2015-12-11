// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.text.InputFilter;
import android.text.Spanned;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishlistAddressFragment

class a
    implements InputFilter
{

    final WishlistAddressFragment a;

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        if (charsequence != null && WishlistAddressFragment.h(a).contains((new StringBuilder()).append("").append(charsequence).toString()))
        {
            return "";
        } else
        {
            return null;
        }
    }

    (WishlistAddressFragment wishlistaddressfragment)
    {
        a = wishlistaddressfragment;
        super();
    }
}
