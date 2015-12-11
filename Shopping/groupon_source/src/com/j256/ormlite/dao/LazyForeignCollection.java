// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.j256.ormlite.dao:
//            BaseForeignCollection, ForeignCollection, Dao, CloseableIterator

public class LazyForeignCollection extends BaseForeignCollection
    implements ForeignCollection, Serializable
{

    private transient CloseableIterator lastIterator;

    public LazyForeignCollection(Dao dao, Object obj, Object obj1, FieldType fieldtype, String s, boolean flag)
    {
        super(dao, obj, obj1, fieldtype, s, flag);
    }

    private CloseableIterator seperateIteratorThrow(int i)
        throws SQLException
    {
        if (dao == null)
        {
            throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
        } else
        {
            return dao.iterator(getPreparedQuery(), i);
        }
    }

    public CloseableIterator closeableIterator()
    {
        return closeableIterator(-1);
    }

    public CloseableIterator closeableIterator(int i)
    {
        CloseableIterator closeableiterator;
        try
        {
            closeableiterator = iteratorThrow(i);
        }
        catch (SQLException sqlexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not build lazy iterator for ").append(dao.getDataClass()).toString(), sqlexception);
        }
        return closeableiterator;
    }

    public boolean contains(Object obj)
    {
        CloseableIterator closeableiterator = iterator();
_L3:
        if (!closeableiterator.hasNext()) goto _L2; else goto _L1
_L1:
        boolean flag = closeableiterator.next().equals(obj);
        if (flag)
        {
            try
            {
                closeableiterator.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return true;
            }
            return true;
        }
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            closeableiterator.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return false;
        obj;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception) { }
        throw obj;
    }

    public boolean containsAll(Collection collection)
    {
        Object obj;
        obj = new HashSet(collection);
        collection = iterator();
        while (collection.hasNext()) 
        {
            ((Set) (obj)).remove(collection.next());
        }
        break MISSING_BLOCK_LABEL_48;
        obj;
        boolean flag;
        try
        {
            collection.close();
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection) { }
        throw obj;
        flag = ((Set) (obj)).isEmpty();
        try
        {
            collection.close();
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return flag;
        }
        return flag;
    }

    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    public boolean isEmpty()
    {
        CloseableIterator closeableiterator = iterator();
        boolean flag = closeableiterator.hasNext();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Exception exception;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception)
        {
            return flag;
        }
        return flag;
        exception;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception1) { }
        throw exception;
    }

    public CloseableIterator iterator()
    {
        return closeableIterator(-1);
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public CloseableIterator iteratorThrow(int i)
        throws SQLException
    {
        lastIterator = seperateIteratorThrow(i);
        return lastIterator;
    }

    public boolean remove(Object obj)
    {
        CloseableIterator closeableiterator = iterator();
        do
        {
            if (!closeableiterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_41;
            }
        } while (!closeableiterator.next().equals(obj));
        closeableiterator.remove();
        try
        {
            closeableiterator.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return true;
        }
        return true;
        try
        {
            closeableiterator.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return false;
        obj;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception) { }
        throw obj;
    }

    public boolean removeAll(Collection collection)
    {
        CloseableIterator closeableiterator;
        boolean flag;
        flag = false;
        closeableiterator = iterator();
_L2:
        if (!closeableiterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!collection.contains(closeableiterator.next()))
        {
            continue; /* Loop/switch isn't completed */
        }
        closeableiterator.remove();
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            closeableiterator.close();
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return flag;
        }
        return flag;
        collection;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception) { }
        throw collection;
    }

    public int size()
    {
        CloseableIterator closeableiterator;
        int i;
        closeableiterator = iterator();
        i = 0;
_L2:
        if (!closeableiterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        closeableiterator.moveToNext();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception)
        {
            return i;
        }
        return i;
        exception;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception1) { }
        throw exception;
    }

    public Object[] toArray()
    {
        CloseableIterator closeableiterator;
        Object obj;
        obj = new ArrayList();
        closeableiterator = iterator();
        while (closeableiterator.hasNext()) 
        {
            ((List) (obj)).add(closeableiterator.next());
        }
        break MISSING_BLOCK_LABEL_47;
        obj;
        SQLException sqlexception;
        Object aobj[];
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception1) { }
        throw obj;
        aobj = ((List) (obj)).toArray();
        try
        {
            closeableiterator.close();
        }
        // Misplaced declaration of an exception variable
        catch (SQLException sqlexception)
        {
            return aobj;
        }
        return aobj;
    }

    public Object[] toArray(Object aobj[])
    {
        ArrayList arraylist;
        CloseableIterator closeableiterator;
        int i;
        i = 0;
        closeableiterator = iterator();
        arraylist = null;
_L10:
        if (!closeableiterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = closeableiterator.next();
        if (i < aobj.length) goto _L4; else goto _L3
_L3:
        if (arraylist != null) goto _L6; else goto _L5
_L5:
        ArrayList arraylist1 = new ArrayList();
        int k = aobj.length;
        int j = 0;
_L7:
        arraylist = arraylist1;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist1.add(aobj[j]);
        j++;
        if (true) goto _L7; else goto _L6
_L6:
        arraylist.add(obj);
_L8:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        aobj[i] = obj;
        if (true) goto _L8; else goto _L2
_L2:
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception1) { }
        if (arraylist == null)
        {
            if (i < aobj.length - 1)
            {
                aobj[i] = null;
            }
            return aobj;
        } else
        {
            return arraylist.toArray(aobj);
        }
        if (true) goto _L10; else goto _L9
_L9:
        aobj;
_L12:
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception) { }
        throw aobj;
        aobj;
        if (true) goto _L12; else goto _L11
_L11:
    }
}
