// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Iterator;

class ParseTextUtils
{

    private ParseTextUtils()
    {
    }

    public static boolean equals(CharSequence charsequence, CharSequence charsequence1)
    {
        return charsequence == charsequence1 || charsequence != null && charsequence.equals(charsequence1);
    }

    public static boolean isEmpty(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }

    static String join(CharSequence charsequence, Iterable iterable)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        iterable = iterable.iterator();
        while (iterable.hasNext()) 
        {
            Object obj = iterable.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(charsequence);
            }
            stringbuilder.append(obj);
        }
        return stringbuilder.toString();
    }
}
