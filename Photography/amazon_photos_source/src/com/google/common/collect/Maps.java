// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Collections2, ImmutableEntry, Sets, TransformedIterator

public final class Maps
{
    static abstract class EntrySet extends Sets.ImprovedAbstractSet
    {

        public void clear()
        {
            map().clear();
        }

        public boolean contains(Object obj)
        {
            boolean flag;
label0:
            {
                boolean flag1 = false;
                flag = flag1;
                if (!(obj instanceof java.util.Map.Entry))
                {
                    break label0;
                }
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                Object obj2 = map().get(obj1);
                flag = flag1;
                if (!Objects.equal(obj2, ((java.util.Map.Entry) (obj)).getValue()))
                {
                    break label0;
                }
                if (obj2 == null)
                {
                    flag = flag1;
                    if (!map().containsKey(obj1))
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            return flag;
        }

        public boolean isEmpty()
        {
            return map().isEmpty();
        }

        abstract Map map();

        public boolean remove(Object obj)
        {
            if (contains(obj))
            {
                obj = (java.util.Map.Entry)obj;
                return map().keySet().remove(((java.util.Map.Entry) (obj)).getKey());
            } else
            {
                return false;
            }
        }

        public boolean removeAll(Collection collection)
        {
            boolean flag1;
            try
            {
                flag1 = super.removeAll((Collection)Preconditions.checkNotNull(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                boolean flag = true;
                collection = collection.iterator();
                do
                {
                    flag1 = flag;
                    if (!collection.hasNext())
                    {
                        continue;
                    }
                    flag |= remove(collection.next());
                } while (true);
            }
            return flag1;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_13;
_L1:
        }

        public boolean retainAll(Collection collection)
        {
            boolean flag;
            try
            {
                flag = super.retainAll((Collection)Preconditions.checkNotNull(collection));
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                java.util.HashSet hashset = Sets.newHashSetWithExpectedSize(collection.size());
                collection = collection.iterator();
                do
                {
                    if (!collection.hasNext())
                    {
                        break;
                    }
                    Object obj = collection.next();
                    if (contains(obj))
                    {
                        hashset.add(((java.util.Map.Entry)obj).getKey());
                    }
                } while (true);
                return map().keySet().retainAll(hashset);
            }
            return flag;
        }

        public int size()
        {
            return map().size();
        }

        EntrySet()
        {
        }
    }

    static abstract class KeySet extends Sets.ImprovedAbstractSet
    {

        public void clear()
        {
            map().clear();
        }

        public boolean contains(Object obj)
        {
            return map().containsKey(obj);
        }

        public boolean isEmpty()
        {
            return map().isEmpty();
        }

        public Iterator iterator()
        {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        abstract Map map();

        public boolean remove(Object obj)
        {
            if (contains(obj))
            {
                map().remove(obj);
                return true;
            } else
            {
                return false;
            }
        }

        public int size()
        {
            return map().size();
        }

        KeySet()
        {
        }
    }


    static final com.google.common.base.Joiner.MapJoiner STANDARD_JOINER;

    static int capacity(int i)
    {
        if (i < 3)
        {
            boolean flag;
            if (i >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            return i + 1;
        }
        if (i < 0x40000000)
        {
            return i / 3 + i;
        } else
        {
            return 0x7fffffff;
        }
    }

    public static java.util.Map.Entry immutableEntry(Object obj, Object obj1)
    {
        return new ImmutableEntry(obj, obj1);
    }

    static Iterator keyIterator(Iterator iterator)
    {
        return new TransformedIterator(iterator) {

            volatile Object transform(Object obj)
            {
                return transform((java.util.Map.Entry)obj);
            }

            Object transform(java.util.Map.Entry entry)
            {
                return entry.getKey();
            }

        };
    }

    static boolean safeContainsKey(Map map, Object obj)
    {
        boolean flag;
        try
        {
            flag = map.containsKey(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return flag;
    }

    static Object safeGet(Map map, Object obj)
    {
        try
        {
            map = ((Map) (map.get(obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return null;
        }
        return map;
    }

    static 
    {
        STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
    }
}
