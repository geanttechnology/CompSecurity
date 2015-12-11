// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.StringEncoder;

final class SoundexUtils
{

    SoundexUtils()
    {
    }

    static String clean(String s)
    {
        if (s == null || s.length() == 0)
        {
            return s;
        }
        int l = s.length();
        char ac[] = new char[l];
        int j = 0;
        int i = 0;
        for (; j < l; j++)
        {
            if (Character.isLetter(s.charAt(j)))
            {
                int k = i + 1;
                ac[i] = s.charAt(j);
                i = k;
            }
        }

        if (i == l)
        {
            return s.toUpperCase(Locale.ENGLISH);
        } else
        {
            return (new String(ac, 0, i)).toUpperCase(Locale.ENGLISH);
        }
    }

    static int difference(StringEncoder stringencoder, String s, String s1)
    {
        return differenceEncoded(stringencoder.encode(s), stringencoder.encode(s1));
    }

    static int differenceEncoded(String s, String s1)
    {
        int i;
        boolean flag;
        int k;
        i = 0;
        flag = false;
        k = ((flag) ? 1 : 0);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s1 != null) goto _L4; else goto _L3
_L3:
        k = ((flag) ? 1 : 0);
_L2:
        return k;
_L4:
        int l = Math.min(s.length(), s1.length());
        int j = 0;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            k = i;
            if (s.charAt(j) == s1.charAt(j))
            {
                k = i + 1;
            }
            j++;
            i = k;
        } while (true);
        if (true) goto _L2; else goto _L5
_L5:
    }
}
