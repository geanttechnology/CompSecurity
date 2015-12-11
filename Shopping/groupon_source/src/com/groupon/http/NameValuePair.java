// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import roboguice.util.Strings;

public class NameValuePair
{

    public String name;
    public String value;

    public NameValuePair(String s, String s1)
    {
        if (Strings.isEmpty(s))
        {
            throw new IllegalArgumentException("Name may not be null");
        } else
        {
            name = s;
            value = s1;
            return;
        }
    }

    public String toString()
    {
        if (Strings.isEmpty(value))
        {
            return name;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(name.length() + 1 + value.length());
            stringbuilder.append(name);
            stringbuilder.append("=");
            stringbuilder.append(value);
            return stringbuilder.toString();
        }
    }
}
