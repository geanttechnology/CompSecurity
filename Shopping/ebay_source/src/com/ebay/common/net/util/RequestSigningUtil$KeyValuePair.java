// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.util;


// Referenced classes of package com.ebay.common.net.util:
//            RequestSigningUtil

private static class <init>
    implements Comparable
{

    public String key;
    public String value;

    public int compareTo(<init> <init>1)
    {
        if (key.compareTo(<init>1.key) == 0 && value.compareTo(<init>1.value) == 0)
        {
            return 0;
        }
        if (key.compareTo(<init>1.key) != 0)
        {
            return key.compareTo(<init>1.key);
        } else
        {
            return value.compareTo(<init>1.value);
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public String toString()
    {
        return String.format("%s=%s", new Object[] {
            RequestSigningUtil.access$100(key), RequestSigningUtil.access$100(value)
        });
    }

    private ()
    {
        value = null;
    }

    value(value value1)
    {
        this();
    }
}
