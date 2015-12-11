// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support;

import android.text.TextUtils;
import java.util.ArrayList;

public class IgnitedStrings
{

    private static String[] splitByCharacterType(String s, boolean flag)
    {
        if (s == null)
        {
            return null;
        }
        if (s.length() == 0)
        {
            return new String[0];
        }
        s = s.toCharArray();
        ArrayList arraylist = new ArrayList();
        int k = 0;
        int i = Character.getType(s[0]);
        int j = 0 + 1;
        while (j < s.length) 
        {
            int l = Character.getType(s[j]);
            if (l == i)
            {
                l = k;
                k = i;
            } else
            {
                if (flag && l == 2 && i == 1)
                {
                    int i1 = j - 1;
                    i = k;
                    if (i1 != k)
                    {
                        arraylist.add(new String(s, k, i1 - k));
                        i = i1;
                    }
                } else
                {
                    arraylist.add(new String(s, k, j - k));
                    i = j;
                }
                k = l;
                l = i;
            }
            j++;
            i = k;
            k = l;
        }
        arraylist.add(new String(s, k, s.length - k));
        return (String[])(String[])arraylist.toArray(new String[arraylist.size()]);
    }

    public static String[] splitByCharacterTypeCamelCase(String s)
    {
        return splitByCharacterType(s, true);
    }

    public static String underscore(String s)
    {
        return TextUtils.join("_", splitByCharacterTypeCamelCase(s)).toLowerCase();
    }
}
