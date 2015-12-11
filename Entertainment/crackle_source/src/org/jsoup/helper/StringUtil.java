// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.helper;

import java.util.Collection;
import java.util.Iterator;

public final class StringUtil
{

    private static final String padding[] = {
        "", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", 
        "          "
    };

    public StringUtil()
    {
    }

    public static transient boolean in(String s, String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (as[i].equals(s))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isBlank(String s)
    {
        if (s != null && s.length() != 0)
        {
            int j = s.length();
            int i = 0;
            while (i < j) 
            {
                if (!isWhitespace(s.codePointAt(i)))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean isNumeric(String s)
    {
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = s.length();
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (!Character.isDigit(s.codePointAt(i)))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static boolean isWhitespace(int i)
    {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public static String join(Collection collection, String s)
    {
        return join(collection.iterator(), s);
    }

    public static String join(Iterator iterator, String s)
    {
        String s1;
        if (!iterator.hasNext())
        {
            s1 = "";
        } else
        {
            String s2 = iterator.next().toString();
            s1 = s2;
            if (iterator.hasNext())
            {
                StringBuilder stringbuilder = (new StringBuilder(64)).append(s2);
                for (; iterator.hasNext(); stringbuilder.append(iterator.next()))
                {
                    stringbuilder.append(s);
                }

                return stringbuilder.toString();
            }
        }
        return s1;
    }

    public static String normaliseWhitespace(String s)
    {
        StringBuilder stringbuilder = new StringBuilder(s.length());
        boolean flag1 = false;
        boolean flag = false;
        int j = s.length();
        int i = 0;
        while (i < j) 
        {
            int k = s.codePointAt(i);
            if (isWhitespace(k))
            {
                if (flag1)
                {
                    flag = true;
                } else
                {
                    if (k != 32)
                    {
                        flag = true;
                    }
                    stringbuilder.append(' ');
                    flag1 = true;
                }
            } else
            {
                stringbuilder.appendCodePoint(k);
                flag1 = false;
            }
            i++;
        }
        if (flag)
        {
            s = stringbuilder.toString();
        }
        return s;
    }

    public static String padding(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (i < padding.length)
        {
            return padding[i];
        }
        char ac[] = new char[i];
        for (int j = 0; j < i; j++)
        {
            ac[j] = ' ';
        }

        return String.valueOf(ac);
    }

}
