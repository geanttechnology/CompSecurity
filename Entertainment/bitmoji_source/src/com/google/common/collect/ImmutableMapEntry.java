// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            ImmutableEntry, CollectPreconditions

class ImmutableMapEntry extends ImmutableEntry
{
    static final class NonTerminalImmutableBiMapEntry extends NonTerminalImmutableMapEntry
    {

        private final transient ImmutableMapEntry nextInValueBucket;

        ImmutableMapEntry getNextInValueBucket()
        {
            return nextInValueBucket;
        }

        NonTerminalImmutableBiMapEntry(Object obj, Object obj1, ImmutableMapEntry immutablemapentry, ImmutableMapEntry immutablemapentry1)
        {
            super(obj, obj1, immutablemapentry);
            nextInValueBucket = immutablemapentry1;
        }
    }

    static class NonTerminalImmutableMapEntry extends ImmutableMapEntry
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

        NonTerminalImmutableMapEntry(Object obj, Object obj1, ImmutableMapEntry immutablemapentry)
        {
            super(obj, obj1);
            nextInKeyBucket = immutablemapentry;
        }
    }


    ImmutableMapEntry(ImmutableMapEntry immutablemapentry)
    {
        super(immutablemapentry.getKey(), immutablemapentry.getValue());
    }

    ImmutableMapEntry(Object obj, Object obj1)
    {
        super(obj, obj1);
        CollectPreconditions.checkEntryNotNull(obj, obj1);
    }

    static ImmutableMapEntry[] createEntryArray(int i)
    {
        return new ImmutableMapEntry[i];
    }

    ImmutableMapEntry getNextInKeyBucket()
    {
        return null;
    }

    ImmutableMapEntry getNextInValueBucket()
    {
        return null;
    }

    boolean isReusable()
    {
        return true;
    }
}
