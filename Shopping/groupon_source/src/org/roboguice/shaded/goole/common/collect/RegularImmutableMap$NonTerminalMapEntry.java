// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;


// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableMapEntry, RegularImmutableMap

private static final class nextInKeyBucket extends ImmutableMapEntry
{

    private final ImmutableMapEntry nextInKeyBucket;

    ImmutableMapEntry getNextInKeyBucket()
    {
        return nextInKeyBucket;
    }

    (Object obj, Object obj1, ImmutableMapEntry immutablemapentry)
    {
        super(obj, obj1);
        nextInKeyBucket = immutablemapentry;
    }

    nextInKeyBucket(ImmutableMapEntry immutablemapentry, ImmutableMapEntry immutablemapentry1)
    {
        super(immutablemapentry);
        nextInKeyBucket = immutablemapentry1;
    }
}
