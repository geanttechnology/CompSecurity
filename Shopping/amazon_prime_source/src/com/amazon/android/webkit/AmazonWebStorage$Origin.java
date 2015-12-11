// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebStorage

public static class mUsage
{

    private final String mOrigin;
    private final long mQuota;
    private final long mUsage;

    public String getOrigin()
    {
        return mOrigin;
    }

    public long getQuota()
    {
        return mQuota;
    }

    public long getUsage()
    {
        return mUsage;
    }

    public (String s, long l, long l1)
    {
        mOrigin = s;
        mQuota = l;
        mUsage = l1;
    }
}
