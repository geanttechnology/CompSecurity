// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.text.Spanned;

// Referenced classes of package com.ebay.mobile.checkout:
//            IncentivesActivity

public final class this._cls0 extends android.text.lphaNumCaps
{

    final IncentivesActivity this$0;

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        for (int i1 = i; i1 < j; i1++)
        {
            if (!Character.isLetterOrDigit(charsequence.charAt(i1)))
            {
                return "";
            }
        }

        return super.lphaNumCaps(charsequence, i, j, spanned, k, l);
    }

    public I()
    {
        this$0 = IncentivesActivity.this;
        super();
    }
}
