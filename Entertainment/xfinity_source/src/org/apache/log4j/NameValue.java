// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;


class NameValue
{

    String key;
    String value;

    public NameValue(String s, String s1)
    {
        key = s;
        value = s1;
    }

    public String toString()
    {
        return key + "=" + value;
    }
}
