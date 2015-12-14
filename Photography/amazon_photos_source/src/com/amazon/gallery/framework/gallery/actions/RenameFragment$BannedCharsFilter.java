// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            RenameFragment

static class 
    implements InputFilter
{

    public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
    {
        for (k = i; k < j; k++)
        {
            if (RenameFragment.BANNED_NAME_CHARACTERS.contains(Character.valueOf(charsequence.charAt(k))))
            {
                spanned = new char[j - i];
                TextUtils.getChars(charsequence, i, k, spanned, 0);
                l = 1;
                k++;
                while (k < j) 
                {
                    char c = charsequence.charAt(k);
                    if (RenameFragment.BANNED_NAME_CHARACTERS.contains(Character.valueOf(c)))
                    {
                        l++;
                    } else
                    {
                        spanned[k - i - l] = c;
                    }
                    k++;
                }
                if (spanned.length == l)
                {
                    return "";
                } else
                {
                    return new String(spanned, 0, spanned.length - l);
                }
            }
        }

        return null;
    }

    ()
    {
    }
}
