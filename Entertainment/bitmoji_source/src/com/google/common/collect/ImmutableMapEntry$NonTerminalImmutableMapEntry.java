// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            ImmutableMapEntry

static class nextInKeyBucket extends ImmutableMapEntry
{

    private final transient ImmutableMapEntry nextInKeyBucket;

    final ImmutableMapEntry getNextInKeyBucket()
    {
        return nextInKeyBucket;
    }

    final boolean isReusable()
    {
        return false;
    }

    (Object obj, Object obj1, ImmutableMapEntry immutablemapentry)
    {
        super(obj, obj1);
        nextInKeyBucket = immutablemapentry;
    }
}
