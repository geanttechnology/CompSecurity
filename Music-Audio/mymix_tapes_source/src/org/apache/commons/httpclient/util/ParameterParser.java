// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.NameValuePair;

public class ParameterParser
{

    private char chars[];
    private int i1;
    private int i2;
    private int len;
    private int pos;

    public ParameterParser()
    {
        chars = null;
        pos = 0;
        len = 0;
        i1 = 0;
        i2 = 0;
    }

    private String getToken(boolean flag)
    {
        for (; i1 < i2 && Character.isWhitespace(chars[i1]); i1 = i1 + 1) { }
        for (; i2 > i1 && Character.isWhitespace(chars[i2 - 1]); i2 = i2 - 1) { }
        if (flag && i2 - i1 >= 2 && chars[i1] == '"' && chars[i2 - 1] == '"')
        {
            i1 = i1 + 1;
            i2 = i2 - 1;
        }
        String s = null;
        if (i2 >= i1)
        {
            s = new String(chars, i1, i2 - i1);
        }
        return s;
    }

    private boolean hasChar()
    {
        return pos < len;
    }

    private boolean isOneOf(char c, char ac[])
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < ac.length)
                {
                    if (c != ac[i])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private String parseQuotedToken(char ac[])
    {
        i1 = pos;
        i2 = pos;
        boolean flag2 = false;
        boolean flag1 = false;
        do
        {
            char c;
label0:
            {
                if (hasChar())
                {
                    c = chars[pos];
                    if (flag2 || !isOneOf(c, ac))
                    {
                        break label0;
                    }
                }
                return getToken(true);
            }
            boolean flag = flag2;
            if (!flag1)
            {
                flag = flag2;
                if (c == '"')
                {
                    if (!flag2)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
            }
            if (!flag1 && c == '\\')
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            i2 = i2 + 1;
            pos = pos + 1;
            flag2 = flag;
        } while (true);
    }

    private String parseToken(char ac[])
    {
        i1 = pos;
        i2 = pos;
        do
        {
            if (!hasChar() || isOneOf(chars[pos], ac))
            {
                return getToken(false);
            }
            i2 = i2 + 1;
            pos = pos + 1;
        } while (true);
    }

    public List parse(String s, char c)
    {
        if (s == null)
        {
            return new ArrayList();
        } else
        {
            return parse(s.toCharArray(), c);
        }
    }

    public List parse(char ac[], char c)
    {
        if (ac == null)
        {
            return new ArrayList();
        } else
        {
            return parse(ac, 0, ac.length, c);
        }
    }

    public List parse(char ac[], int i, int j, char c)
    {
        if (ac != null) goto _L2; else goto _L1
_L1:
        Object obj = new ArrayList();
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        chars = ac;
        pos = i;
        len = j;
        do
        {
            obj = arraylist;
            if (!hasChar())
            {
                continue;
            }
            String s = parseToken(new char[] {
                '=', c
            });
            Object obj1 = null;
            obj = obj1;
            if (hasChar())
            {
                obj = obj1;
                if (ac[pos] == '=')
                {
                    pos = pos + 1;
                    obj = parseQuotedToken(new char[] {
                        c
                    });
                }
            }
            if (hasChar() && ac[pos] == c)
            {
                pos = pos + 1;
            }
            if (s != null && (!s.equals("") || obj != null))
            {
                arraylist.add(new NameValuePair(s, ((String) (obj))));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
