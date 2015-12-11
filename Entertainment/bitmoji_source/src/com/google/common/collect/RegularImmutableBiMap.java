// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableBiMap, ImmutableMap, ImmutableMapEntry, Hashing, 
//            CollectPreconditions, RegularImmutableMap, ImmutableSet, BiMap, 
//            ImmutableMapEntrySet, ImmutableList, UnmodifiableIterator, ImmutableAsList, 
//            Maps, ImmutableCollection

class RegularImmutableBiMap extends ImmutableBiMap
{
    private final class Inverse extends ImmutableBiMap
    {

        final RegularImmutableBiMap this$0;

        ImmutableSet createEntrySet()
        {
            return new InverseEntrySet();
        }

        public Object get(Object obj)
        {
            if (obj != null && valueTable != null)
            {
                int i = Hashing.smear(obj.hashCode());
                int j = mask;
                ImmutableMapEntry immutablemapentry = valueTable[i & j];
                while (immutablemapentry != null) 
                {
                    if (obj.equals(immutablemapentry.getValue()))
                    {
                        return immutablemapentry.getKey();
                    }
                    immutablemapentry = immutablemapentry.getNextInValueBucket();
                }
            }
            return null;
        }

        public volatile BiMap inverse()
        {
            return inverse();
        }

        public ImmutableBiMap inverse()
        {
            return RegularImmutableBiMap.this;
        }

        boolean isPartialView()
        {
            return false;
        }

        public int size()
        {
            return inverse().size();
        }

        Object writeReplace()
        {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }

        private Inverse()
        {
            this$0 = RegularImmutableBiMap.this;
            super();
        }

    }

    final class Inverse.InverseEntrySet extends ImmutableMapEntrySet
    {

        final Inverse this$1;

        ImmutableList createAsList()
        {
            return new ImmutableAsList() {

                final Inverse.InverseEntrySet this$2;

                ImmutableCollection delegateCollection()
                {
                    return Inverse.InverseEntrySet.this;
                }

                public volatile Object get(int i)
                {
                    return get(i);
                }

                public java.util.Map.Entry get(int i)
                {
                    java.util.Map.Entry entry = entries[i];
                    return Maps.immutableEntry(entry.getValue(), entry.getKey());
                }

            
            {
                this$2 = Inverse.InverseEntrySet.this;
                super();
            }
            };
        }

        public int hashCode()
        {
            return _fld0.hashCode;
        }

        boolean isHashCodeFast()
        {
            return true;
        }

        public UnmodifiableIterator iterator()
        {
            return asList().iterator();
        }

        public volatile Iterator iterator()
        {
            return iterator();
        }

        ImmutableMap map()
        {
            return Inverse.this;
        }

        Inverse.InverseEntrySet()
        {
            this$1 = Inverse.this;
            super();
        }
    }

    private static class InverseSerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        private final ImmutableBiMap forward;

        Object readResolve()
        {
            return forward.inverse();
        }

        InverseSerializedForm(ImmutableBiMap immutablebimap)
        {
            forward = immutablebimap;
        }
    }


    static final RegularImmutableBiMap EMPTY;
    static final double MAX_LOAD_FACTOR = 1.2D;
    private final transient java.util.Map.Entry entries[];
    private final transient int hashCode;
    private transient ImmutableBiMap inverse;
    private final transient ImmutableMapEntry keyTable[];
    private final transient int mask;
    private final transient ImmutableMapEntry valueTable[];

    private RegularImmutableBiMap(ImmutableMapEntry aimmutablemapentry[], ImmutableMapEntry aimmutablemapentry1[], java.util.Map.Entry aentry[], int i, int j)
    {
        keyTable = aimmutablemapentry;
        valueTable = aimmutablemapentry1;
        entries = aentry;
        mask = i;
        hashCode = j;
    }

    private static void checkNoConflictInValueBucket(Object obj, java.util.Map.Entry entry, ImmutableMapEntry immutablemapentry)
    {
        while (immutablemapentry != null) 
        {
            boolean flag;
            if (!obj.equals(immutablemapentry.getValue()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            checkNoConflict(flag, "value", entry, immutablemapentry);
            immutablemapentry = immutablemapentry.getNextInValueBucket();
        }
    }

    static transient RegularImmutableBiMap fromEntries(java.util.Map.Entry aentry[])
    {
        return fromEntryArray(aentry.length, aentry);
    }

    static RegularImmutableBiMap fromEntryArray(int i, java.util.Map.Entry aentry[])
    {
        Preconditions.checkPositionIndex(i, aentry.length);
        int j = Hashing.closedTableSize(i, 1.2D);
        int l = j - 1;
        ImmutableMapEntry aimmutablemapentry[] = ImmutableMapEntry.createEntryArray(j);
        ImmutableMapEntry aimmutablemapentry1[] = ImmutableMapEntry.createEntryArray(j);
        Object aobj[];
        int k;
        if (i == aentry.length)
        {
            aobj = aentry;
        } else
        {
            aobj = ImmutableMapEntry.createEntryArray(i);
        }
        k = 0;
        j = 0;
        while (j < i) 
        {
            Object obj = aentry[j];
            Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
            Object obj2 = ((java.util.Map.Entry) (obj)).getValue();
            CollectPreconditions.checkEntryNotNull(obj1, obj2);
            int i1 = obj1.hashCode();
            int j1 = obj2.hashCode();
            int k1 = Hashing.smear(i1) & l;
            int l1 = Hashing.smear(j1) & l;
            ImmutableMapEntry immutablemapentry = aimmutablemapentry[k1];
            RegularImmutableMap.checkNoConflictInKeyBucket(obj1, ((java.util.Map.Entry) (obj)), immutablemapentry);
            ImmutableMapEntry immutablemapentry1 = aimmutablemapentry1[l1];
            checkNoConflictInValueBucket(obj2, ((java.util.Map.Entry) (obj)), immutablemapentry1);
            if (immutablemapentry1 == null && immutablemapentry == null)
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
                obj = new ImmutableMapEntry.NonTerminalImmutableBiMapEntry(obj1, obj2, immutablemapentry, immutablemapentry1);
            }
            aimmutablemapentry[k1] = ((ImmutableMapEntry) (obj));
            aimmutablemapentry1[l1] = ((ImmutableMapEntry) (obj));
            aobj[j] = ((java.util.Map.Entry) (obj));
            k += i1 ^ j1;
            j++;
        }
        return new RegularImmutableBiMap(aimmutablemapentry, aimmutablemapentry1, ((java.util.Map.Entry []) (aobj)), l, k);
    }

    ImmutableSet createEntrySet()
    {
        if (isEmpty())
        {
            return ImmutableSet.of();
        } else
        {
            return new ImmutableMapEntrySet.RegularEntrySet(this, entries);
        }
    }

    public Object get(Object obj)
    {
        if (keyTable == null)
        {
            return null;
        } else
        {
            return RegularImmutableMap.get(obj, keyTable, mask);
        }
    }

    public int hashCode()
    {
        return hashCode;
    }

    public volatile BiMap inverse()
    {
        return inverse();
    }

    public ImmutableBiMap inverse()
    {
        ImmutableBiMap immutablebimap;
        if (isEmpty())
        {
            immutablebimap = ImmutableBiMap.of();
        } else
        {
            ImmutableBiMap immutablebimap1 = inverse;
            immutablebimap = immutablebimap1;
            if (immutablebimap1 == null)
            {
                Inverse inverse1 = new Inverse();
                inverse = inverse1;
                return inverse1;
            }
        }
        return immutablebimap;
    }

    boolean isHashCodeFast()
    {
        return true;
    }

    boolean isPartialView()
    {
        return false;
    }

    public int size()
    {
        return entries.length;
    }

    static 
    {
        EMPTY = new RegularImmutableBiMap(null, null, (java.util.Map.Entry[])ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    }




}
