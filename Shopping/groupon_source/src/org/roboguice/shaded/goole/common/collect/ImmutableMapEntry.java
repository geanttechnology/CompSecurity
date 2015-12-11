// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;


// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableEntry, CollectPreconditions

abstract class ImmutableMapEntry extends ImmutableEntry
{
    static final class TerminalEntry extends ImmutableMapEntry
    {

        ImmutableMapEntry getNextInKeyBucket()
        {
            return null;
        }

        TerminalEntry(Object obj, Object obj1)
        {
            super(obj, obj1);
        }
    }


    ImmutableMapEntry(Object obj, Object obj1)
    {
        super(obj, obj1);
        CollectPreconditions.checkEntryNotNull(obj, obj1);
    }

    ImmutableMapEntry(ImmutableMapEntry immutablemapentry)
    {
        super(immutablemapentry.getKey(), immutablemapentry.getValue());
    }

    abstract ImmutableMapEntry getNextInKeyBucket();
}
