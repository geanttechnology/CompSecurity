// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            ImmutableMapEntry

static final class nextInValueBucket extends nextInValueBucket
{

    private final transient ImmutableMapEntry nextInValueBucket;

    ImmutableMapEntry getNextInValueBucket()
    {
        return nextInValueBucket;
    }

    (Object obj, Object obj1, ImmutableMapEntry immutablemapentry, ImmutableMapEntry immutablemapentry1)
    {
        super(obj, obj1, immutablemapentry);
        nextInValueBucket = immutablemapentry1;
    }
}
