// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.j256.ormlite.dao:
//            BaseForeignCollection, CloseableWrappedIterable, ForeignCollection, Dao, 
//            CloseableIterator

public class EagerForeignCollection extends BaseForeignCollection
    implements CloseableWrappedIterable, ForeignCollection, Serializable
{

    private static final long serialVersionUID = 0xdcfb4fa278aa2727L;
    private final List results;

    public EagerForeignCollection(Dao dao, Object obj, FieldType fieldtype, Object obj1, String s)
    {
        super(dao, fieldtype.getDbColumnName(), obj1, s, obj);
        if (obj1 == null)
        {
            results = new ArrayList();
            return;
        } else
        {
            results = dao.query(getPreparedQuery());
            return;
        }
    }

    public boolean add(Object obj)
    {
        if (results.add(obj))
        {
            return super.add(obj);
        } else
        {
            return false;
        }
    }

    public boolean addAll(Collection collection)
    {
        if (results.addAll(collection))
        {
            return super.addAll(collection);
        } else
        {
            return false;
        }
    }

    public void clear()
    {
        results.clear();
        super.clear();
    }

    public void close()
    {
    }

    public void closeLastIterator()
    {
    }

    public CloseableIterator closeableIterator()
    {
        return iteratorThrow();
    }

    public boolean contains(Object obj)
    {
        return results.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return results.containsAll(collection);
    }

    public boolean equals(Object obj)
    {
        return results.equals(obj);
    }

    public CloseableWrappedIterable getWrappedIterable()
    {
        return this;
    }

    public int hashCode()
    {
        return results.hashCode();
    }

    public boolean isEager()
    {
        return true;
    }

    public boolean isEmpty()
    {
        return results.isEmpty();
    }

    public CloseableIterator iterator()
    {
        return iteratorThrow();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public CloseableIterator iteratorThrow()
    {
        return new CloseableIterator() {

            private Iterator iterator;
            private Object last;
            final EagerForeignCollection this$0;

            public void close()
            {
            }

            public boolean hasNext()
            {
                return iterator.hasNext();
            }

            public Object next()
            {
                last = iterator.next();
                return last;
            }

            public void remove()
            {
                iterator.remove();
                if (dao == null)
                {
                    break MISSING_BLOCK_LABEL_36;
                }
                dao.delete(last);
                return;
                SQLException sqlexception;
                sqlexception;
                throw new RuntimeException(sqlexception);
            }

            
            {
                this$0 = EagerForeignCollection.this;
                super();
                iterator = results.iterator();
                last = null;
            }
        };
    }

    public boolean remove(Object obj)
    {
        boolean flag = true;
        if (!results.remove(obj) || dao == null)
        {
            flag = false;
        } else
        {
            int i;
            try
            {
                i = dao.delete(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalStateException("Could not delete data element from dao", ((Throwable) (obj)));
            }
            if (i != 1)
            {
                return false;
            }
        }
        return flag;
    }

    public boolean removeAll(Collection collection)
    {
        boolean flag = false;
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            if (remove(collection.next()))
            {
                flag = true;
            }
        } while (true);
        return flag;
    }

    public boolean retainAll(Collection collection)
    {
        return super.retainAll(collection);
    }

    public int size()
    {
        return results.size();
    }

    public Object[] toArray()
    {
        return results.toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return results.toArray(aobj);
    }

}
