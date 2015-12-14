// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import org.apache.commons.httpclient.NameValuePair;

public class ParameterFormatter
{

    private static final char SEPARATORS[] = {
        '(', ')', '<', '>', '@', ',', ';', ':', '\\', '"', 
        '/', '[', ']', '?', '=', '{', '}', ' ', '\t'
    };
    private static final char UNSAFE_CHARS[] = {
        '"', '\\'
    };
    private boolean alwaysUseQuotes;

    public ParameterFormatter()
    {
        alwaysUseQuotes = true;
    }

    public static void formatValue(StringBuffer stringbuffer, String s, boolean flag)
    {
        if (stringbuffer == null)
        {
            throw new IllegalArgumentException("String buffer may not be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("Value buffer may not be null");
        }
        if (flag)
        {
            stringbuffer.append('"');
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (isUnsafeChar(c))
                {
                    stringbuffer.append('\\');
                }
                stringbuffer.append(c);
            }

            stringbuffer.append('"');
        } else
        {
            int k = stringbuffer.length();
            boolean flag1 = false;
            for (int j = 0; j < s.length(); j++)
            {
                char c1 = s.charAt(j);
                if (isSeparator(c1))
                {
                    flag1 = true;
                }
                if (isUnsafeChar(c1))
                {
                    stringbuffer.append('\\');
                }
                stringbuffer.append(c1);
            }

            if (flag1)
            {
                stringbuffer.insert(k, '"');
                stringbuffer.append('"');
                return;
            }
        }
    }

    private static boolean isOneOf(char ac[], char c)
    {
        for (int i = 0; i < ac.length; i++)
        {
            if (c == ac[i])
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isSeparator(char c)
    {
        return isOneOf(SEPARATORS, c);
    }

    private static boolean isUnsafeChar(char c)
    {
        return isOneOf(UNSAFE_CHARS, c);
    }

    public String format(NameValuePair namevaluepair)
    {
        StringBuffer stringbuffer = new StringBuffer();
        format(stringbuffer, namevaluepair);
        return stringbuffer.toString();
    }

    public void format(StringBuffer stringbuffer, NameValuePair namevaluepair)
    {
        if (stringbuffer == null)
        {
            throw new IllegalArgumentException("String buffer may not be null");
        }
        if (namevaluepair == null)
        {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        stringbuffer.append(namevaluepair.getName());
        namevaluepair = namevaluepair.getValue();
        if (namevaluepair != null)
        {
            stringbuffer.append("=");
            formatValue(stringbuffer, namevaluepair, alwaysUseQuotes);
        }
    }

    public boolean isAlwaysUseQuotes()
    {
        return alwaysUseQuotes;
    }

    public void setAlwaysUseQuotes(boolean flag)
    {
        alwaysUseQuotes = flag;
    }

}
