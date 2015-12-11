// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.e;


// Referenced classes of package com.google.api.a.c.e:
//            d, b

public class c
    implements d
{

    private final String key;
    private final String userIp;

    public c()
    {
        this(null);
    }

    public c(String s)
    {
        this(s, null);
    }

    public c(String s, String s1)
    {
        key = s;
        userIp = s1;
    }

    public final String getKey()
    {
        return key;
    }

    public final String getUserIp()
    {
        return userIp;
    }

    public void initialize(b b1)
    {
        if (key != null)
        {
            b1.put("key", key);
        }
        if (userIp != null)
        {
            b1.put("userIp", userIp);
        }
    }
}
