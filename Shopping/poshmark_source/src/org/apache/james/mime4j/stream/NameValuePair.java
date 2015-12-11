// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import org.apache.james.mime4j.util.LangUtils;

public final class NameValuePair
{

    private final String name;
    private final String value;

    public NameValuePair(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        } else
        {
            name = s;
            value = s1;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof NameValuePair)
            {
                if (!name.equals(((NameValuePair) (obj = (NameValuePair)obj)).name) || !LangUtils.equals(value, ((NameValuePair) (obj)).value))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(17, name), value);
    }

    public String toString()
    {
        if (value == null)
        {
            return name;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(name);
            stringbuilder.append("=");
            stringbuilder.append("\"");
            stringbuilder.append(value);
            stringbuilder.append("\"");
            return stringbuilder.toString();
        }
    }
}
