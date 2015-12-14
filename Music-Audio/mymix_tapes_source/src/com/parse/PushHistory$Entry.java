// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            PushHistory

private static class timestamp
    implements Comparable
{

    public String pushId;
    public String timestamp;

    public int compareTo(timestamp timestamp1)
    {
        return timestamp.compareTo(timestamp1.timestamp);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public (String s, String s1)
    {
        pushId = s;
        timestamp = s1;
    }
}
