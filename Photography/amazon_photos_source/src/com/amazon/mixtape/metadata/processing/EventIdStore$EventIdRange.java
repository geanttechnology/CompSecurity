// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.metadata.processing;


// Referenced classes of package com.amazon.mixtape.metadata.processing:
//            EventIdStore

public static class maximumEventId
{

    public final long lowerEventId;
    public final long maximumEventId;
    public final long upperEventId;

    public (long l, long l1, long l2)
    {
        lowerEventId = l;
        upperEventId = l1;
        maximumEventId = l2;
    }
}
