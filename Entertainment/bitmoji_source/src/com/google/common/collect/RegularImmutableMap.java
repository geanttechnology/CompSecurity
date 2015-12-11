// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.collect:
//            ImmutableMap, ImmutableMapEntry, Hashing, CollectPreconditions, 
//            ImmutableSet

final class RegularImmutableMap extends ImmutableMap
{

    private static final double MAX_LOAD_FACTOR = 1.2D;
    private static final long serialVersionUID = 0L;
    private final transient java.util.Map.Entry entries[];
    private final transient int mask;
    private final transient ImmutableMapEntry table[];

    private RegularImmutableMap(java.util.Map.Entry aentry[], ImmutableMapEntry aimmutablemapentry[], int i)
    {
        entries = aentry;
        table = aimmutablemapentry;
        mask = i;
    }

    static void checkNoConflictInKeyBucket(Object obj, java.util.Map.Entry entry, ImmutableMapEntry immutablemapentry)
    {
        while (immutablemapentry != null) 
        {
            boolean flag;
            if (!obj.equals(immutablemapentry.getKey()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            checkNoConflict(flag, "key", entry, immutablemapentry);
            immutablemapentry = immutablemapentry.getNextInKeyBucket();
        }
    }

    static transient RegularImmutableMap fromEntries(java.util.Map.Entry aentry[])
    {
        return fromEntryArray(aentry.length, aentry);
    }

    static RegularImmutableMap fromEntryArray(int i, java.util.Map.Entry aentry[])
    {
        Preconditions.checkPositionIndex(i, aentry.length);
        Object aobj[];
        ImmutableMapEntry aimmutablemapentry[];
        int j;
        int k;
        if (i == aentry.length)
        {
            aobj = aentry;
        } else
        {
            aobj = ImmutableMapEntry.createEntryArray(i);
        }
        j = Hashing.closedTableSize(i, 1.2D);
        aimmutablemapentry = ImmutableMapEntry.createEntryArray(j);
        k = j - 1;
        j = 0;
        while (j < i) 
        {
            Object obj = aentry[j];
            Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
            Object obj2 = ((java.util.Map.Entry) (obj)).getValue();
            CollectPreconditions.checkEntryNotNull(obj1, obj2);
            int l = Hashing.smear(obj1.hashCode()) & k;
            ImmutableMapEntry immutablemapentry = aimmutablemapentry[l];
            if (immutablemapentry == null)
            {
                boolean flag;
                if ((obj instanceof ImmutableMapEntry) && ((ImmutableMapEntry)obj).isReusable())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    obj = (ImmutableMapEntry)obj;
                } else
                {
                    obj = new ImmutableMapEntry(obj1, obj2);
                }
            } else
            {
                obj = new ImmutableMapEntry.NonTerminalImmutableMapEntry(obj1, obj2, immutablemapentry);
            }
            aimmutablemapentry[l] = ((ImmutableMapEntry) (obj));
            aobj[j] = ((java.util.Map.Entry) (obj));
            checkNoConflictInKeyBucket(obj1, ((java.util.Map.Entry) (obj)), immutablemapentry);
            j++;
        }
        return new RegularImmutableMap(((java.util.Map.Entry []) (aobj)), aimmutablemapentry, k);
    }

    static Object get(Object obj, ImmutableMapEntry aimmutablemapentry[], int i)
    {
        if (obj != null)
        {
            aimmutablemapentry = aimmutablemapentry[Hashing.smear(obj.hashCode()) & i];
            while (aimmutablemapentry != null) 
            {
                if (obj.equals(aimmutablemapentry.getKey()))
                {
                    return aimmutablemapentry.getValue();
                }
                aimmutablemapentry = aimmutablemapentry.getNextInKeyBucket();
            }
        }
        return null;
    }

    ImmutableSet createEntrySet()
    {
        return new ImmutableMapEntrySet.RegularEntrySet(this, entries);
    }

    public Object get(Object obj)
    {
        return get(obj, table, mask);
    }

    boolean isPartialView()
    {
        return false;
    }

    public int size()
    {
        return entries.length;
    }
}
