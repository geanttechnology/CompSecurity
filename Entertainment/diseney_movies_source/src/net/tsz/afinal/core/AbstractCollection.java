// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection
    implements Collection
{

    protected AbstractCollection()
    {
    }

    public boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection)
    {
        boolean flag = false;
        collection = collection.iterator();
        do
        {
            do
            {
                if (!collection.hasNext())
                {
                    return flag;
                }
            } while (!add(collection.next()));
            flag = true;
        } while (true);
    }

    public void clear()
    {
        Iterator iterator1 = iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                return;
            }
            iterator1.next();
            iterator1.remove();
        } while (true);
    }

    public boolean contains(Object obj)
    {
        Iterator iterator1;
        boolean flag1;
        flag1 = true;
        iterator1 = iterator();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (iterator1.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        boolean flag = false;
_L4:
        return flag;
        if (!obj.equals(iterator1.next())) goto _L1; else goto _L3
_L3:
        return true;
_L6:
        flag = flag1;
        if (iterator1.next() == null) goto _L4; else goto _L2
_L2:
        if (iterator1.hasNext()) goto _L6; else goto _L5
    }

    public boolean containsAll(Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                return true;
            }
        } while (contains(collection.next()));
        return false;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public abstract Iterator iterator();

    public boolean remove(Object obj)
    {
        Iterator iterator1;
        iterator1 = iterator();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
_L2:
        if (iterator1.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
_L3:
        return false;
        if (!obj.equals(iterator1.next())) goto _L2; else goto _L1
_L1:
        iterator1.remove();
        return true;
        while (iterator1.hasNext()) 
        {
            if (iterator1.next() == null)
            {
                iterator1.remove();
                return true;
            }
        }
          goto _L3
    }

    public boolean removeAll(Collection collection)
    {
        boolean flag = false;
        Iterator iterator1 = iterator();
        do
        {
            do
            {
                if (!iterator1.hasNext())
                {
                    return flag;
                }
            } while (!collection.contains(iterator1.next()));
            iterator1.remove();
            flag = true;
        } while (true);
    }

    public boolean retainAll(Collection collection)
    {
        boolean flag = false;
        Iterator iterator1 = iterator();
        do
        {
            do
            {
                if (!iterator1.hasNext())
                {
                    return flag;
                }
            } while (collection.contains(iterator1.next()));
            iterator1.remove();
            flag = true;
        } while (true);
    }

    public abstract int size();

    public Object[] toArray()
    {
        int j = size();
        Iterator iterator1 = iterator();
        Object aobj[] = new Object[j];
        int i = 0;
        do
        {
            if (i >= j)
            {
                return aobj;
            }
            aobj[i] = iterator1.next();
            i++;
        } while (true);
    }

    public Object[] toArray(Object aobj[])
    {
        int j = size();
        int i = 0;
        Object aobj1[] = aobj;
        if (j > aobj.length)
        {
            aobj1 = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), j);
        }
        aobj = iterator();
        do
        {
            if (!((Iterator) (aobj)).hasNext())
            {
                if (i < aobj1.length)
                {
                    aobj1[i] = null;
                }
                return aobj1;
            }
            aobj1[i] = (Object)((Iterator) (aobj)).next();
            i++;
        } while (true);
    }

    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(size() * 16);
        stringbuilder.append('[');
        Iterator iterator1 = iterator();
        do
        {
            do
            {
                if (!iterator1.hasNext())
                {
                    stringbuilder.append(']');
                    return stringbuilder.toString();
                }
                Object obj = iterator1.next();
                if (obj != this)
                {
                    stringbuilder.append(obj);
                } else
                {
                    stringbuilder.append("(this Collection)");
                }
            } while (!iterator1.hasNext());
            stringbuilder.append(", ");
        } while (true);
    }
}
