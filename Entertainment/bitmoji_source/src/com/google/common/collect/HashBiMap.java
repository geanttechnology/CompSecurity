// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            BiMap, CollectPreconditions, Hashing, Maps, 
//            Serialization, AbstractMapEntry, ImmutableEntry

public final class HashBiMap extends Maps.IteratorBasedAbstractMap
    implements BiMap, Serializable
{
    class MapEntry extends AbstractMapEntry
    {

        BiEntry _flddelegate;
        final _cls1 this$1;

        public Object getKey()
        {
            return _flddelegate.key;
        }

        public Object getValue()
        {
            return _flddelegate.value;
        }

        public Object setValue(Object obj)
        {
            Object obj1 = _flddelegate.value;
            int i = Hashing.smearedHash(obj);
            if (i == _flddelegate.valueHash && Objects.equal(obj, obj1))
            {
                return obj;
            }
            class _cls1 extends Itr
            {

                final HashBiMap this$0;

                volatile Object output(BiEntry bientry)
                {
                    return output(bientry);
                }

                java.util.Map.Entry output(BiEntry bientry)
                {
                    return new MapEntry(bientry);
                }

            
            {
                this$0 = HashBiMap.this;
                super();
            }
            }

            boolean flag;
            if (seekByValue(obj, i) == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "value already present: %s", new Object[] {
                obj
            });
            delete(_flddelegate);
            obj = new BiEntry(_flddelegate.key, _flddelegate.keyHash, obj, i);
            insert(((BiEntry) (obj)), _flddelegate);
            _flddelegate.prevInKeyInsertionOrder = null;
            _flddelegate.nextInKeyInsertionOrder = null;
            expectedModCount = modCount;
            if (toRemove == _flddelegate)
            {
                toRemove = ((BiEntry) (obj));
            }
            _flddelegate = ((BiEntry) (obj));
            return obj1;
        }

        MapEntry(BiEntry bientry)
        {
            this$1 = _cls1.this;
            super();
            _flddelegate = bientry;
        }
    }

    private static final class BiEntry extends ImmutableEntry
    {

        final int keyHash;
        BiEntry nextInKToVBucket;
        BiEntry nextInKeyInsertionOrder;
        BiEntry nextInVToKBucket;
        BiEntry prevInKeyInsertionOrder;
        final int valueHash;

        BiEntry(Object obj, int i, Object obj1, int j)
        {
            super(obj, obj1);
            keyHash = i;
            valueHash = j;
        }
    }

    private final class Inverse extends AbstractMap
        implements BiMap, Serializable
    {

        final HashBiMap this$0;

        public void clear()
        {
            forward().clear();
        }

        public boolean containsKey(Object obj)
        {
            return forward().containsValue(obj);
        }

        public Set entrySet()
        {
            return new Maps.EntrySet() {

                final Inverse this$1;

                public Iterator iterator()
                {
                    return new Itr() {

                        final Inverse._cls1 this$2;

                        volatile Object output(BiEntry bientry)
                        {
                            return output(bientry);
                        }

                        java.util.Map.Entry output(BiEntry bientry)
                        {
                            return new InverseEntry(bientry);
                        }

            
            {
                this$2 = Inverse._cls1.this;
                super();
            }
                    };
                }

                Map map()
                {
                    return Inverse.this;
                }

            
            {
                this$1 = Inverse.this;
                super();
            }
            };
        }

        public Object forcePut(Object obj, Object obj1)
        {
            return putInverse(obj, obj1, true);
        }

        BiMap forward()
        {
            return HashBiMap.this;
        }

        public Object get(Object obj)
        {
            return Maps.keyOrNull(seekByValue(obj, Hashing.smearedHash(obj)));
        }

        public BiMap inverse()
        {
            return forward();
        }

        public Set keySet()
        {
            return new InverseKeySet();
        }

        public Object put(Object obj, Object obj1)
        {
            return putInverse(obj, obj1, false);
        }

        public Object remove(Object obj)
        {
            obj = seekByValue(obj, Hashing.smearedHash(obj));
            if (obj == null)
            {
                return null;
            } else
            {
                delete(((BiEntry) (obj)));
                obj.prevInKeyInsertionOrder = null;
                obj.nextInKeyInsertionOrder = null;
                return ((BiEntry) (obj)).key;
            }
        }

        public int size()
        {
            return HashBiMap.this.size;
        }

        public volatile Collection values()
        {
            return values();
        }

        public Set values()
        {
            return forward().keySet();
        }

        Object writeReplace()
        {
            return new InverseSerializedForm(HashBiMap.this);
        }

        private Inverse()
        {
            this$0 = HashBiMap.this;
            super();
        }

    }

    class Inverse._cls1._cls1.InverseEntry extends AbstractMapEntry
    {

        BiEntry _flddelegate;
        final Inverse._cls1._cls1 this$3;

        public Object getKey()
        {
            return _flddelegate.value;
        }

        public Object getValue()
        {
            return _flddelegate.key;
        }

        public Object setValue(Object obj)
        {
            Object obj1 = _flddelegate.key;
            int i = Hashing.smearedHash(obj);
            if (i == _flddelegate.keyHash && Objects.equal(obj, obj1))
            {
                return obj;
            }
            boolean flag;
            if (seekByKey(obj, i) == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "value already present: %s", new Object[] {
                obj
            });
            delete(_flddelegate);
            obj = new BiEntry(obj, i, _flddelegate.value, _flddelegate.valueHash);
            _flddelegate = ((BiEntry) (obj));
            insert(((BiEntry) (obj)), null);
            expectedModCount = modCount;
            return obj1;
        }

        Inverse._cls1._cls1.InverseEntry(BiEntry bientry)
        {
            this$3 = Inverse._cls1._cls1.this;
            super();
            _flddelegate = bientry;
        }
    }

    private final class Inverse.InverseKeySet extends Maps.KeySet
    {

        final Inverse this$1;

        public Iterator iterator()
        {
            return new Itr() {

                final Inverse.InverseKeySet this$2;

                Object output(BiEntry bientry)
                {
                    return bientry.value;
                }

            
            {
                this$2 = Inverse.InverseKeySet.this;
                super();
            }
            };
        }

        public boolean remove(Object obj)
        {
            obj = seekByValue(obj, Hashing.smearedHash(obj));
            if (obj == null)
            {
                return false;
            } else
            {
                delete(((BiEntry) (obj)));
                return true;
            }
        }

        Inverse.InverseKeySet()
        {
            this$1 = Inverse.this;
            super(Inverse.this);
        }
    }

    private static final class InverseSerializedForm
        implements Serializable
    {

        private final HashBiMap bimap;

        Object readResolve()
        {
            return bimap.inverse();
        }

        InverseSerializedForm(HashBiMap hashbimap)
        {
            bimap = hashbimap;
        }
    }

    abstract class Itr
        implements Iterator
    {

        int expectedModCount;
        BiEntry next;
        final HashBiMap this$0;
        BiEntry toRemove;

        public boolean hasNext()
        {
            if (modCount != expectedModCount)
            {
                throw new ConcurrentModificationException();
            }
            return next != null;
        }

        public Object next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            } else
            {
                BiEntry bientry = next;
                next = bientry.nextInKeyInsertionOrder;
                toRemove = bientry;
                return output(bientry);
            }
        }

        abstract Object output(BiEntry bientry);

        public void remove()
        {
            if (modCount != expectedModCount)
            {
                throw new ConcurrentModificationException();
            }
            boolean flag;
            if (toRemove != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            CollectPreconditions.checkRemove(flag);
            delete(toRemove);
            expectedModCount = modCount;
            toRemove = null;
        }

        Itr()
        {
            this$0 = HashBiMap.this;
            super();
            next = firstInKeyInsertionOrder;
            toRemove = null;
            expectedModCount = modCount;
        }
    }

    private final class KeySet extends Maps.KeySet
    {

        final HashBiMap this$0;

        public Iterator iterator()
        {
            return new Itr() {

                final KeySet this$1;

                Object output(BiEntry bientry)
                {
                    return bientry.key;
                }

            
            {
                this$1 = KeySet.this;
                super();
            }
            };
        }

        public boolean remove(Object obj)
        {
            obj = seekByKey(obj, Hashing.smearedHash(obj));
            if (obj == null)
            {
                return false;
            } else
            {
                delete(((BiEntry) (obj)));
                obj.prevInKeyInsertionOrder = null;
                obj.nextInKeyInsertionOrder = null;
                return true;
            }
        }

        KeySet()
        {
            this$0 = HashBiMap.this;
            super(HashBiMap.this);
        }
    }


    private static final double LOAD_FACTOR = 1D;
    private static final long serialVersionUID = 0L;
    private transient BiEntry firstInKeyInsertionOrder;
    private transient BiEntry hashTableKToV[];
    private transient BiEntry hashTableVToK[];
    private transient BiMap inverse;
    private transient BiEntry lastInKeyInsertionOrder;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    private HashBiMap(int i)
    {
        init(i);
    }

    public static HashBiMap create()
    {
        return create(16);
    }

    public static HashBiMap create(int i)
    {
        return new HashBiMap(i);
    }

    public static HashBiMap create(Map map)
    {
        HashBiMap hashbimap = create(map.size());
        hashbimap.putAll(map);
        return hashbimap;
    }

    private BiEntry[] createTable(int i)
    {
        return new BiEntry[i];
    }

    private void delete(BiEntry bientry)
    {
        BiEntry bientry1;
        BiEntry bientry2;
        int i;
        i = bientry.keyHash & mask;
        bientry2 = null;
        bientry1 = hashTableKToV[i];
_L3:
        if (bientry1 != bientry) goto _L2; else goto _L1
_L1:
        if (bientry2 == null)
        {
            hashTableKToV[i] = bientry.nextInKToVBucket;
        } else
        {
            bientry2.nextInKToVBucket = bientry.nextInKToVBucket;
        }
        i = bientry.valueHash & mask;
        bientry2 = null;
        bientry1 = hashTableVToK[i];
_L4:
        if (bientry1 == bientry)
        {
            if (bientry2 == null)
            {
                hashTableVToK[i] = bientry.nextInVToKBucket;
            } else
            {
                bientry2.nextInVToKBucket = bientry.nextInVToKBucket;
            }
            if (bientry.prevInKeyInsertionOrder == null)
            {
                firstInKeyInsertionOrder = bientry.nextInKeyInsertionOrder;
            } else
            {
                bientry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = bientry.nextInKeyInsertionOrder;
            }
            if (bientry.nextInKeyInsertionOrder == null)
            {
                lastInKeyInsertionOrder = bientry.prevInKeyInsertionOrder;
            } else
            {
                bientry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = bientry.prevInKeyInsertionOrder;
            }
            size = size - 1;
            modCount = modCount + 1;
            return;
        }
        break MISSING_BLOCK_LABEL_165;
_L2:
        bientry2 = bientry1;
        bientry1 = bientry1.nextInKToVBucket;
          goto _L3
        bientry2 = bientry1;
        bientry1 = bientry1.nextInVToKBucket;
          goto _L4
    }

    private void init(int i)
    {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        i = Hashing.closedTableSize(i, 1.0D);
        hashTableKToV = createTable(i);
        hashTableVToK = createTable(i);
        firstInKeyInsertionOrder = null;
        lastInKeyInsertionOrder = null;
        size = 0;
        mask = i - 1;
        modCount = 0;
    }

    private void insert(BiEntry bientry, BiEntry bientry1)
    {
        int i = bientry.keyHash & mask;
        bientry.nextInKToVBucket = hashTableKToV[i];
        hashTableKToV[i] = bientry;
        i = bientry.valueHash & mask;
        bientry.nextInVToKBucket = hashTableVToK[i];
        hashTableVToK[i] = bientry;
        if (bientry1 == null)
        {
            bientry.prevInKeyInsertionOrder = lastInKeyInsertionOrder;
            bientry.nextInKeyInsertionOrder = null;
            if (lastInKeyInsertionOrder == null)
            {
                firstInKeyInsertionOrder = bientry;
            } else
            {
                lastInKeyInsertionOrder.nextInKeyInsertionOrder = bientry;
            }
            lastInKeyInsertionOrder = bientry;
        } else
        {
            bientry.prevInKeyInsertionOrder = bientry1.prevInKeyInsertionOrder;
            if (bientry.prevInKeyInsertionOrder == null)
            {
                firstInKeyInsertionOrder = bientry;
            } else
            {
                bientry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = bientry;
            }
            bientry.nextInKeyInsertionOrder = bientry1.nextInKeyInsertionOrder;
            if (bientry.nextInKeyInsertionOrder == null)
            {
                lastInKeyInsertionOrder = bientry;
            } else
            {
                bientry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = bientry;
            }
        }
        size = size + 1;
        modCount = modCount + 1;
    }

    private Object put(Object obj, Object obj1, boolean flag)
    {
label0:
        {
            int i = Hashing.smearedHash(obj);
            int j = Hashing.smearedHash(obj1);
            BiEntry bientry = seekByKey(obj, i);
            if (bientry != null && j == bientry.valueHash && Objects.equal(obj1, bientry.value))
            {
                return obj1;
            }
            BiEntry bientry1 = seekByValue(obj1, j);
            if (bientry1 != null)
            {
                if (!flag)
                {
                    break label0;
                }
                delete(bientry1);
            }
            obj = new BiEntry(obj, i, obj1, j);
            if (bientry != null)
            {
                delete(bientry);
                insert(((BiEntry) (obj)), bientry);
                bientry.prevInKeyInsertionOrder = null;
                bientry.nextInKeyInsertionOrder = null;
                rehashIfNecessary();
                return bientry.value;
            } else
            {
                insert(((BiEntry) (obj)), null);
                rehashIfNecessary();
                return null;
            }
        }
        obj = String.valueOf(obj1);
        throw new IllegalArgumentException((new StringBuilder(String.valueOf(obj).length() + 23)).append("value already present: ").append(((String) (obj))).toString());
    }

    private Object putInverse(Object obj, Object obj1, boolean flag)
    {
label0:
        {
            int i = Hashing.smearedHash(obj);
            int j = Hashing.smearedHash(obj1);
            BiEntry bientry = seekByValue(obj, i);
            if (bientry != null && j == bientry.keyHash && Objects.equal(obj1, bientry.key))
            {
                return obj1;
            }
            BiEntry bientry1 = seekByKey(obj1, j);
            if (bientry1 != null)
            {
                if (!flag)
                {
                    break label0;
                }
                delete(bientry1);
            }
            if (bientry != null)
            {
                delete(bientry);
            }
            insert(new BiEntry(obj1, j, obj, i), bientry1);
            if (bientry1 != null)
            {
                bientry1.prevInKeyInsertionOrder = null;
                bientry1.nextInKeyInsertionOrder = null;
            }
            rehashIfNecessary();
            return Maps.keyOrNull(bientry);
        }
        obj = String.valueOf(obj1);
        throw new IllegalArgumentException((new StringBuilder(String.valueOf(obj).length() + 23)).append("value already present: ").append(((String) (obj))).toString());
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        init(16);
        Serialization.populateMap(this, objectinputstream, Serialization.readCount(objectinputstream));
    }

    private void rehashIfNecessary()
    {
        BiEntry abientry[] = hashTableKToV;
        if (Hashing.needsResizing(size, abientry.length, 1.0D))
        {
            int i = abientry.length * 2;
            hashTableKToV = createTable(i);
            hashTableVToK = createTable(i);
            mask = i - 1;
            size = 0;
            for (BiEntry bientry = firstInKeyInsertionOrder; bientry != null; bientry = bientry.nextInKeyInsertionOrder)
            {
                insert(bientry, bientry);
            }

            modCount = modCount + 1;
        }
    }

    private BiEntry seekByKey(Object obj, int i)
    {
        for (BiEntry bientry = hashTableKToV[mask & i]; bientry != null; bientry = bientry.nextInKToVBucket)
        {
            if (i == bientry.keyHash && Objects.equal(obj, bientry.key))
            {
                return bientry;
            }
        }

        return null;
    }

    private BiEntry seekByValue(Object obj, int i)
    {
        for (BiEntry bientry = hashTableVToK[mask & i]; bientry != null; bientry = bientry.nextInVToKBucket)
        {
            if (i == bientry.valueHash && Objects.equal(obj, bientry.value))
            {
                return bientry;
            }
        }

        return null;
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.defaultWriteObject();
        Serialization.writeMap(this, objectoutputstream);
    }

    public void clear()
    {
        size = 0;
        Arrays.fill(hashTableKToV, null);
        Arrays.fill(hashTableVToK, null);
        firstInKeyInsertionOrder = null;
        lastInKeyInsertionOrder = null;
        modCount = modCount + 1;
    }

    public boolean containsKey(Object obj)
    {
        return seekByKey(obj, Hashing.smearedHash(obj)) != null;
    }

    public boolean containsValue(Object obj)
    {
        return seekByValue(obj, Hashing.smearedHash(obj)) != null;
    }

    Iterator entryIterator()
    {
        return new _cls1();
    }

    public volatile Set entrySet()
    {
        return super.entrySet();
    }

    public Object forcePut(Object obj, Object obj1)
    {
        return put(obj, obj1, true);
    }

    public Object get(Object obj)
    {
        return Maps.valueOrNull(seekByKey(obj, Hashing.smearedHash(obj)));
    }

    public BiMap inverse()
    {
        if (inverse == null)
        {
            Inverse inverse1 = new Inverse(null);
            inverse = inverse1;
            return inverse1;
        } else
        {
            return inverse;
        }
    }

    public Set keySet()
    {
        return new KeySet();
    }

    public Object put(Object obj, Object obj1)
    {
        return put(obj, obj1, false);
    }

    public Object remove(Object obj)
    {
        obj = seekByKey(obj, Hashing.smearedHash(obj));
        if (obj == null)
        {
            return null;
        } else
        {
            delete(((BiEntry) (obj)));
            obj.prevInKeyInsertionOrder = null;
            obj.nextInKeyInsertionOrder = null;
            return ((BiEntry) (obj)).value;
        }
    }

    public int size()
    {
        return size;
    }

    public volatile Collection values()
    {
        return values();
    }

    public Set values()
    {
        return inverse().keySet();
    }








}
