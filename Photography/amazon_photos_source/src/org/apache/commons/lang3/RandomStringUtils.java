// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.util.Random;

public class RandomStringUtils
{

    private static final Random RANDOM = new Random();

    public static String random(int i, int j, int k, boolean flag, boolean flag1)
    {
        return random(i, j, k, flag, flag1, null, RANDOM);
    }

    public static String random(int i, int j, int k, boolean flag, boolean flag1, char ac[], Random random1)
    {
        if (i == 0)
        {
            return "";
        }
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Requested random string length ").append(i).append(" is less than 0.").toString());
        }
        if (ac != null && ac.length == 0)
        {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
        char ac1[];
        int l;
        int i1;
        if (j == 0 && k == 0)
        {
            if (ac != null)
            {
                l = ac.length;
                i1 = j;
            } else
            if (!flag && !flag1)
            {
                l = 0x7fffffff;
                i1 = j;
            } else
            {
                l = 123;
                i1 = 32;
            }
        } else
        {
            i1 = j;
            l = k;
            if (k <= j)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Parameter end (").append(k).append(") must be greater than start (").append(j).append(")").toString());
            }
        }
        ac1 = new char[i];
        k = l - i1;
        do
        {
            j = i - 1;
            if (i != 0)
            {
                char c;
                if (ac == null)
                {
                    c = (char)(random1.nextInt(k) + i1);
                } else
                {
                    c = ac[random1.nextInt(k) + i1];
                }
                if (flag && Character.isLetter(c) || flag1 && Character.isDigit(c) || !flag && !flag1)
                {
                    if (c >= '\uDC00' && c <= '\uDFFF')
                    {
                        if (j == 0)
                        {
                            i = j + 1;
                        } else
                        {
                            ac1[j] = c;
                            i = j - 1;
                            ac1[i] = (char)(random1.nextInt(128) + 55296);
                        }
                    } else
                    if (c >= '\uD800' && c <= '\uDB7F')
                    {
                        if (j == 0)
                        {
                            i = j + 1;
                        } else
                        {
                            ac1[j] = (char)(random1.nextInt(128) + 56320);
                            i = j - 1;
                            ac1[i] = c;
                        }
                    } else
                    if (c >= '\uDB80' && c <= '\uDBFF')
                    {
                        i = j + 1;
                    } else
                    {
                        ac1[j] = c;
                        i = j;
                    }
                } else
                {
                    i = j + 1;
                }
            } else
            {
                return new String(ac1);
            }
        } while (true);
    }

    public static String random(int i, boolean flag, boolean flag1)
    {
        return random(i, 0, 0, flag, flag1);
    }

    public static String randomAlphabetic(int i)
    {
        return random(i, true, false);
    }

}
