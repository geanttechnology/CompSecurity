// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            LRUCache

private static class key
    implements Comparable
{

    private String key;
    private Long time;

    public int compareTo(key key1)
    {
        if (key1 == null)
        {
            return -1;
        } else
        {
            return time.compareTo(key1.getTime());
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public String getKey()
    {
        return key;
    }

    public Long getTime()
    {
        return time;
    }

    public void setTime(Long long1)
    {
        time = long1;
    }

    public (String s, Long long1)
    {
        time = long1;
        key = s;
    }
}
