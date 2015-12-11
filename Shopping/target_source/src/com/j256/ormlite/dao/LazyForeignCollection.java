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
//            BaseForeignCollection, ForeignCollection, Dao, CloseableIterator, 
//            CloseableWrappedIterableImpl, CloseableWrappedIterable, CloseableIterable

public class LazyForeignCollection extends BaseForeignCollection
    implements ForeignCollection, Serializable
{

    private static final long serialVersionUID = 0xb437aae8a98e5087L;
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

    public void closeLastIterator()
        throws SQLException
    {
        if (lastIterator != null)
        {
            lastIterator.close();
            lastIterator = null;
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

    public CloseableWrappedIterable getWrappedIterable()
    {
        return getWrappedIterable(-1);
    }

    public CloseableWrappedIterable getWrappedIterable(final int flags)
    {
        return new CloseableWrappedIterableImpl(new CloseableIterable() {

            final LazyForeignCollection this$0;
            final int val$flags;

            public CloseableIterator closeableIterator()
            {
                CloseableIterator closeableiterator;
                try
                {
                    closeableiterator = seperateIteratorThrow(flags);
                }
                catch (Exception exception)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Could not build lazy iterator for ").append(dao.getDataClass()).toString(), exception);
                }
                return closeableiterator;
            }

            public CloseableIterator iterator()
            {
                return closeableIterator();
            }

            public volatile Iterator iterator()
            {
                return iterator();
            }

            
            {
                this$0 = LazyForeignCollection.this;
                flags = i;
                super();
            }
        });
    }

    public int hashCode()
    {
        return super.hashCode();
    }

    public boolean isEager()
    {
        return false;
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

    public CloseableIterator iterator(int i)
    {
        return closeableIterator(i);
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public CloseableIterator iteratorThrow()
        throws SQLException
    {
        return iteratorThrow(-1);
    }

    public CloseableIterator iteratorThrow(int i)
        throws SQLException
    {
        lastIterator = seperateIteratorThrow(i);
        return lastIterator;
    }

    public int refreshAll()
    {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    public int refreshCollection()
    {
        return 0;
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
        closeableiterator = iterator();
        i = 0;
        arraylist = null;
_L5:
        Object obj;
        if (!closeableiterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj = closeableiterator.next();
        if (i < aobj.length)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        ArrayList arraylist1 = arraylist;
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        int k;
        arraylist = new ArrayList();
        k = aobj.length;
        int j = 0;
_L3:
        arraylist1 = arraylist;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(aobj[j]);
        j++;
        if (true) goto _L3; else goto _L2
_L2:
        arraylist1.add(obj);
        arraylist = arraylist1;
        break MISSING_BLOCK_LABEL_163;
        aobj[i] = obj;
        break MISSING_BLOCK_LABEL_163;
        aobj;
        SQLException sqlexception1;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception) { }
        throw aobj;
        try
        {
            closeableiterator.close();
        }
        // Misplaced declaration of an exception variable
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
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int updateAll()
    {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

}
