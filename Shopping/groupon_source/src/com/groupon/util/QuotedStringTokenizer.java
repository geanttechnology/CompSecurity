// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public class QuotedStringTokenizer
{

    private char chars[];
    private int pos;
    private String seps;

    public QuotedStringTokenizer(String s, String s1)
    {
        chars = s.toCharArray();
        seps = s1;
        pos = -1;
    }

    public boolean hasMoreTokens()
    {
        return pos < chars.length - 1;
    }

    public String nextToken()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = chars.length;
        int i = 65535;
        do
        {
            int k = pos + 1;
            pos = k;
            if (k >= j)
            {
                break;
            }
            String s = seps;
            char c1 = chars[pos];
            i = c1;
            if (s.indexOf(c1) >= 0)
            {
                continue;
            }
            i = c1;
            break;
        } while (true);
        if (pos >= j)
        {
            return "";
        }
        if (i == 34)
        {
            do
            {
label0:
                {
                    int l = pos + 1;
                    pos = l;
                    if (l < j)
                    {
                        i = chars[pos];
                        if (i == 92)
                        {
                            int i1 = pos + 1;
                            pos = i1;
                            if (i1 < j)
                            {
                                stringbuilder.append(chars[pos]);
                            }
                            continue;
                        }
                        if (i != 34)
                        {
                            break label0;
                        }
                    }
                    return stringbuilder.toString();
                }
                stringbuilder.append(i);
            } while (true);
        } else
        {
            stringbuilder.append(i);
            do
            {
                char c;
label1:
                {
                    int j1 = pos + 1;
                    pos = j1;
                    if (j1 < j)
                    {
                        c = chars[pos];
                        if (seps.indexOf(c) < 0)
                        {
                            break label1;
                        }
                    }
                    return stringbuilder.toString();
                }
                stringbuilder.append(c);
            } while (true);
        }
    }
}
