// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

// Referenced classes of package com.ebay.mobile.sell:
//            TitleSpokeFragment

class this._cls0
    implements InputFilter
{

    final TitleSpokeFragment this$0;

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        if (charsequence instanceof Editable)
        {
            spanned = (Editable)charsequence;
            android.text.style.CharacterStyle acharacterstyle[] = (android.text.style.CharacterStyle[])spanned.getSpans(0, spanned.length(), android/text/style/MetricAffectingSpan);
            for (k = 0; k < acharacterstyle.length; k++)
            {
                spanned.removeSpan(acharacterstyle[k]);
            }

        }
        for (k = i; k < j; k++)
        {
            if (charsequence.charAt(k) == '\n')
            {
                spanned = new char[j - i];
                TextUtils.getChars(charsequence, i, j, spanned, 0);
                return (new String(spanned)).replace("\n", "");
            }
        }

        return null;
    }

    ()
    {
        this$0 = TitleSpokeFragment.this;
        super();
    }
}
