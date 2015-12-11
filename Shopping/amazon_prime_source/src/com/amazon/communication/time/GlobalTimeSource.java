// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.time;


// Referenced classes of package com.amazon.communication.time:
//            SystemTimeSource, TimeSource

public final class GlobalTimeSource
{

    public static TimeSource INSTANCE;

    private GlobalTimeSource()
    {
    }

    static 
    {
        INSTANCE = SystemTimeSource.INSTANCE;
    }
}
