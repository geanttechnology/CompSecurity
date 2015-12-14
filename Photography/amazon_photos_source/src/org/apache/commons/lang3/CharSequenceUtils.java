// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;


public class CharSequenceUtils
{

    static int indexOf(CharSequence charsequence, CharSequence charsequence1, int i)
    {
        return charsequence.toString().indexOf(charsequence1.toString(), i);
    }

    static boolean regionMatches(CharSequence charsequence, boolean flag, int i, CharSequence charsequence1, int j, int k)
    {
        if ((charsequence instanceof String) && (charsequence1 instanceof String))
        {
            return ((String)charsequence).regionMatches(flag, i, (String)charsequence1, j, k);
        }
        do
        {
            int l = k - 1;
            if (k > 0)
            {
                k = i + 1;
                char c = charsequence.charAt(i);
                i = j + 1;
                char c1 = charsequence1.charAt(j);
                if (c == c1)
                {
                    j = i;
                    i = k;
                    k = l;
                } else
                {
                    if (!flag)
                    {
                        return false;
                    }
                    if (Character.toUpperCase(c) != Character.toUpperCase(c1) && Character.toLowerCase(c) != Character.toLowerCase(c1))
                    {
                        return false;
                    }
                    j = i;
                    i = k;
                    k = l;
                }
            } else
            {
                return true;
            }
        } while (true);
    }
}
