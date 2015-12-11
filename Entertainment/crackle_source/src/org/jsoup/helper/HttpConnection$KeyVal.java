// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.helper;


// Referenced classes of package org.jsoup.helper:
//            HttpConnection, Validate

public static class value
    implements org.jsoup.KeyVal
{

    private String key;
    private String value;

    public static value create(String s, String s1)
    {
        Validate.notEmpty(s, "Data key must not be empty");
        Validate.notNull(s1, "Data value must not be null");
        return new <init>(s, s1);
    }

    public String key()
    {
        return key;
    }

    public volatile org.jsoup.KeyVal key(String s)
    {
        return key(s);
    }

    public key key(String s)
    {
        Validate.notEmpty(s, "Data key must not be empty");
        key = s;
        return this;
    }

    public String toString()
    {
        return (new StringBuilder()).append(key).append("=").append(value).toString();
    }

    public String value()
    {
        return value;
    }

    public volatile org.jsoup.KeyVal value(String s)
    {
        return value(s);
    }

    public value value(String s)
    {
        Validate.notNull(s, "Data value must not be null");
        value = s;
        return this;
    }

    private (String s, String s1)
    {
        key = s;
        value = s1;
    }
}
