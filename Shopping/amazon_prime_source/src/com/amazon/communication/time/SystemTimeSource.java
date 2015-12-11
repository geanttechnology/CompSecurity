// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.time;


// Referenced classes of package com.amazon.communication.time:
//            TimeSource

public final class SystemTimeSource
    implements TimeSource
{

    public static final SystemTimeSource INSTANCE = new SystemTimeSource();

    private SystemTimeSource()
    {
    }

    public long currentTimeMillis()
    {
        return System.currentTimeMillis();
    }

}
