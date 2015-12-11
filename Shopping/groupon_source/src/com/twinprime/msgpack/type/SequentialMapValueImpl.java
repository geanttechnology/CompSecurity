// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

// Referenced classes of package com.twinprime.msgpack.type:
//            AbstractMapValue, Value, ValueType, MapValue

class SequentialMapValueImpl extends AbstractMapValue
{
    private static class EntrySet extends AbstractSet
    {

        private Value array[];

        public Iterator iterator()
        {
            return new EntrySetIterator(array);
        }

        public int size()
        {
            return array.length / 2;
        }

        EntrySet(Value avalue[])
        {
            array = avalue;
        }
    }

    private static class EntrySetIterator
        implements Iterator
    {

        private Value array[];
        private int pos;

        public boolean hasNext()
        {
            return pos < array.length;
        }

        public volatile Object next()
        {
            return next();
        }

        public java.util.Map.Entry next()
        {
            if (pos >= array.length)
            {
                throw new NoSuchElementException();
            } else
            {
                java.util.AbstractMap.SimpleImmutableEntry simpleimmutableentry = new java.util.AbstractMap.SimpleImmutableEntry(array[pos], array[pos + 1]);
                pos = pos + 2;
                return simpleimmutableentry;
            }
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        EntrySetIterator(Value avalue[])
        {
            array = avalue;
            pos = 0;
        }
    }

    private static class KeySet extends AbstractSet
    {

        private Value array[];

        public Iterator iterator()
        {
            return new ValueIterator(array, 0);
        }

        public int size()
        {
            return array.length / 2;
        }

        KeySet(Value avalue[])
        {
            array = avalue;
        }
    }

    private static class ValueCollection extends AbstractCollection
    {

        private Value array[];

        public Iterator iterator()
        {
            return new ValueIterator(array, 1);
        }

        public int size()
        {
            return array.length / 2;
        }

        ValueCollection(Value avalue[])
        {
            array = avalue;
        }
    }

    private static class ValueIterator
        implements Iterator
    {

        private Value array[];
        private int pos;

        public boolean hasNext()
        {
            return pos < array.length;
        }

        public Value next()
        {
            if (pos >= array.length)
            {
                throw new NoSuchElementException();
            } else
            {
                Value value = array[pos];
                pos = pos + 2;
                return value;
            }
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        ValueIterator(Value avalue[], int i)
        {
            array = avalue;
            pos = i;
        }
    }


    private static SequentialMapValueImpl emptyInstance = new SequentialMapValueImpl(new Value[0], true);
    private Value array[];

    SequentialMapValueImpl(Value avalue[], boolean flag)
    {
        if (avalue.length % 2 != 0)
        {
            throw new IllegalArgumentException();
        }
        if (flag)
        {
            array = avalue;
            return;
        } else
        {
            array = new Value[avalue.length];
            System.arraycopy(avalue, 0, array, 0, avalue.length);
            return;
        }
    }

    public static MapValue getEmptyInstance()
    {
        return emptyInstance;
    }

    public Set entrySet()
    {
        return new EntrySet(array);
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof Value))
        {
            return false;
        }
        obj = (Value)obj;
        if (((Value) (obj)).getType() != ValueType.MAP)
        {
            return false;
        }
        obj = (MapValue)((Value) (obj)).getValue();
        if (((Map) (obj)).size() != array.length / 2)
        {
            return false;
        }
        int i = 0;
        do
        {
            boolean flag;
            try
            {
                if (i >= array.length)
                {
                    break;
                }
                Value value = array[i];
                flag = array[i + 1].equals(((Map) (obj)).get(value));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            if (!flag)
            {
                return false;
            }
            i += 2;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public Value get(Object obj)
    {
        if (obj != null)
        {
            int i = array.length - 2;
            while (i >= 0) 
            {
                if (array[i].equals(obj))
                {
                    return array[i + 1];
                }
                i -= 2;
            }
        }
        return null;
    }

    public volatile Object get(Object obj)
    {
        return get(obj);
    }

    public AbstractMapValue getValue()
    {
        return this;
    }

    public volatile MapValue getValue()
    {
        return getValue();
    }

    public volatile Value getValue()
    {
        return getValue();
    }

    public int hashCode()
    {
        int j = 0;
        for (int i = 0; i < array.length; i += 2)
        {
            j += array[i].hashCode() ^ array[i + 1].hashCode();
        }

        return j;
    }

    public Set keySet()
    {
        return new KeySet(array);
    }

    public String toString()
    {
        return toString(new StringBuilder()).toString();
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        if (array.length == 0)
        {
            return stringbuilder.append("{}");
        }
        stringbuilder.append("{");
        stringbuilder.append(array[0]);
        stringbuilder.append(":");
        stringbuilder.append(array[1]);
        for (int i = 2; i < array.length; i += 2)
        {
            stringbuilder.append(",");
            array[i].toString(stringbuilder);
            stringbuilder.append(":");
            array[i + 1].toString(stringbuilder);
        }

        stringbuilder.append("}");
        return stringbuilder;
    }

    public Collection values()
    {
        return new ValueCollection(array);
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.writeMapBegin(array.length / 2);
        for (int i = 0; i < array.length; i++)
        {
            array[i].writeTo(packer);
        }

        packer.writeMapEnd();
    }

}
