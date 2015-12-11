// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.text.TextUtils;
import java.util.Iterator;

public final class DelimitedStringBuilder
{

    private final boolean appendDelimiterEvenForEmptyItems;
    private boolean firstTime;
    private final String requestedDelimiter;
    private final StringBuilder stringBuilder;

    public DelimitedStringBuilder(String s)
    {
        this(new StringBuilder(), s, false);
    }

    public DelimitedStringBuilder(StringBuilder stringbuilder, String s)
    {
        this(stringbuilder, s, false);
    }

    public DelimitedStringBuilder(StringBuilder stringbuilder, String s, boolean flag)
    {
        firstTime = true;
        if (stringbuilder == null)
        {
            throw new IllegalArgumentException("invalid StringBuilder");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("invalid delimiter");
        } else
        {
            stringBuilder = stringbuilder;
            requestedDelimiter = s;
            appendDelimiterEvenForEmptyItems = flag;
            return;
        }
    }

    private static boolean isEmpty(Object obj)
    {
        return obj == null || (obj instanceof CharSequence) && ((CharSequence)obj).length() == 0;
    }

    public static String join(CharSequence charsequence, boolean flag, Iterable iterable)
    {
        return join(new StringBuilder(), charsequence, flag, iterable).toString();
    }

    public static String join(CharSequence charsequence, boolean flag, Object aobj[])
    {
        return join(new StringBuilder(), charsequence, flag, aobj).toString();
    }

    public static StringBuilder join(StringBuilder stringbuilder, CharSequence charsequence, boolean flag, Iterable iterable)
    {
        boolean flag3 = true;
        boolean flag1 = true;
        if (flag)
        {
            iterable = iterable.iterator();
            do
            {
                if (!iterable.hasNext())
                {
                    break;
                }
                Object obj = iterable.next();
                if (flag1)
                {
                    flag3 = false;
                } else
                {
                    stringbuilder.append(charsequence);
                    flag3 = flag1;
                }
                flag1 = flag3;
                if (!isEmpty(obj))
                {
                    stringbuilder.append(obj);
                    flag1 = flag3;
                }
            } while (true);
        } else
        {
            iterable = iterable.iterator();
            boolean flag2 = flag3;
            do
            {
                if (!iterable.hasNext())
                {
                    break;
                }
                Object obj1 = iterable.next();
                if (!isEmpty(obj1))
                {
                    if (flag2)
                    {
                        flag2 = false;
                    } else
                    {
                        stringbuilder.append(charsequence);
                    }
                    stringbuilder.append(obj1);
                }
            } while (true);
        }
        return stringbuilder;
    }

    public static StringBuilder join(StringBuilder stringbuilder, CharSequence charsequence, boolean flag, Object aobj[])
    {
        int i = 1;
        boolean flag1 = true;
        if (flag)
        {
            int k = aobj.length;
            i = 0;
            while (i < k) 
            {
                Object obj = aobj[i];
                if (flag1)
                {
                    flag1 = false;
                } else
                {
                    stringbuilder.append(charsequence);
                }
                if (!isEmpty(obj))
                {
                    stringbuilder.append(obj);
                }
                i++;
            }
        } else
        {
            int l = aobj.length;
            int j = 0;
            while (j < l) 
            {
                Object obj1 = aobj[j];
                if (!isEmpty(obj1))
                {
                    if (i != 0)
                    {
                        i = 0;
                    } else
                    {
                        stringbuilder.append(charsequence);
                    }
                    stringbuilder.append(obj1);
                }
                j++;
            }
        }
        return stringbuilder;
    }

    public DelimitedStringBuilder append(Object obj)
    {
        if (!isEmpty(obj))
        {
            appendDelimiterExceptFirstTime().append(obj);
        } else
        if (appendDelimiterEvenForEmptyItems)
        {
            appendDelimiterExceptFirstTime();
            return this;
        }
        return this;
    }

    public DelimitedStringBuilder append(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            appendDelimiterExceptFirstTime().append(s);
        } else
        if (appendDelimiterEvenForEmptyItems)
        {
            appendDelimiterExceptFirstTime();
            return this;
        }
        return this;
    }

    public StringBuilder appendDelimiterExceptFirstTime()
    {
        if (firstTime)
        {
            firstTime = false;
        } else
        {
            stringBuilder.append(requestedDelimiter);
        }
        return stringBuilder;
    }

    public String toString()
    {
        return stringBuilder.toString();
    }
}
