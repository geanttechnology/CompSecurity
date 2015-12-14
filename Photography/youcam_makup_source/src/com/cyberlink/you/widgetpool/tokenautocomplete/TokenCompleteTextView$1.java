// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            TokenCompleteTextView

class a
    implements InputFilter
{

    final TokenCompleteTextView a;

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        if (TokenCompleteTextView.a(a) != -1 && TokenCompleteTextView.b(a).size() == TokenCompleteTextView.a(a))
        {
            return "";
        }
        if (charsequence.length() == 1 && TokenCompleteTextView.a(a, charsequence.charAt(0)))
        {
            a.performCompletion();
            return "";
        }
        if (k < TokenCompleteTextView.c(a).length() && l == TokenCompleteTextView.c(a).length())
        {
            return TokenCompleteTextView.c(a).substring(k, l);
        } else
        {
            return null;
        }
    }

    (TokenCompleteTextView tokencompletetextview)
    {
        a = tokencompletetextview;
        super();
    }
}
