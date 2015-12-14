// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.text.InputFilter;
import android.text.Spanned;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            RenameFragment

static class 
    implements InputFilter
{

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        if (k == 0 && i != j)
        {
            l = 0;
            k = i;
            do
            {
                if (k >= j)
                {
                    break;
                }
                char c = charsequence.charAt(k);
                if (c != '.' && c != ' ')
                {
                    break;
                }
                l++;
                k++;
            } while (true);
            if (j - i == l)
            {
                return "";
            }
            if (l != 0)
            {
                return charsequence.subSequence(i + l, j).toString();
            }
        }
        return null;
    }

    ()
    {
    }
}
