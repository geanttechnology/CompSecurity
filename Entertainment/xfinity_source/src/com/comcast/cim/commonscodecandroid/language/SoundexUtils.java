// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.language;

import java.util.Locale;

final class SoundexUtils
{

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
}
