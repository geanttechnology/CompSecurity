// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericArray, GenericData

public static class addAll extends AbstractList
    implements GenericArray, Comparable
{

    private static final Object EMPTY[] = new Object[0];
    private Object elements[];
    private final Schema schema;
    private int size;

    public void add(int i, Object obj)
    {
        if (i > size || i < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
        }
        if (size == elements.length)
        {
            Object aobj[] = new Object[(size * 3) / 2 + 1];
            System.arraycopy(((Object) (elements)), 0, ((Object) (aobj)), 0, size);
            elements = aobj;
        }
        System.arraycopy(((Object) (elements)), i, ((Object) (elements)), i + 1, size - i);
        elements[i] = obj;
        size = size + 1;
    }

    public boolean add(Object obj)
    {
        if (size == elements.length)
        {
            Object aobj[] = new Object[(size * 3) / 2 + 1];
            System.arraycopy(((Object) (elements)), 0, ((Object) (aobj)), 0, size);
            elements = aobj;
        }
        Object aobj1[] = elements;
        int i = size;
        size = i + 1;
        aobj1[i] = obj;
        return true;
    }

    public void clear()
    {
        size = 0;
    }

    public int compareTo(GenericArray genericarray)
    {
        return GenericData.get().compare(this, genericarray, getSchema());
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((GenericArray)obj);
    }

    public Object get(int i)
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
        } else
        {
            return elements[i];
        }
    }

    public Schema getSchema()
    {
        return schema;
    }

    public Iterator iterator()
    {
        return new Iterator() {

            private int position;
            final GenericData.Array this$0;

            public boolean hasNext()
            {
                return position < size;
            }

            public Object next()
            {
                Object aobj[] = elements;
                int i = position;
                position = i + 1;
                return aobj[i];
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }

            
            {
                this$0 = GenericData.Array.this;
                super();
                position = 0;
            }
        };
    }

    public Object peek()
    {
        if (size < elements.length)
        {
            return elements[size];
        } else
        {
            return null;
        }
    }

    public Object remove(int i)
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
        } else
        {
            Object obj = elements[i];
            size = size - 1;
            System.arraycopy(((Object) (elements)), i + 1, ((Object) (elements)), i, size - i);
            elements[size] = null;
            return obj;
        }
    }

    public void reverse()
    {
        int j = 0;
        for (int i = elements.length - 1; j < i; i--)
        {
            Object obj = elements[j];
            elements[j] = elements[i];
            elements[i] = obj;
            j++;
        }

    }

    public Object set(int i, Object obj)
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Index ").append(i).append(" out of bounds.").toString());
        } else
        {
            Object obj1 = elements[i];
            elements[i] = obj;
            return obj1;
        }
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("[");
        int i = 0;
        Iterator iterator1 = iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Object obj = iterator1.next();
            int j;
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = obj.toString();
            }
            stringbuffer.append(((String) (obj)));
            j = i + 1;
            i = j;
            if (j < size())
            {
                stringbuffer.append(", ");
                i = j;
            }
        } while (true);
        stringbuffer.append("]");
        return stringbuffer.toString();
    }




    public _cls1.position(int i, Schema schema1)
    {
        elements = EMPTY;
        if (schema1 == null || !com.flurry.org.apache.avro.a.Array.EMPTY.(schema1.getType()))
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Not an array schema: ").append(schema1).toString());
        }
        schema = schema1;
        if (i != 0)
        {
            elements = new Object[i];
        }
    }

    public elements(Schema schema1, Collection collection)
    {
        elements = EMPTY;
        if (schema1 == null || !com.flurry.org.apache.avro.a.Array.EMPTY.(schema1.getType()))
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Not an array schema: ").append(schema1).toString());
        }
        schema = schema1;
        if (collection != null)
        {
            elements = new Object[collection.size()];
            addAll(collection);
        }
    }
}
