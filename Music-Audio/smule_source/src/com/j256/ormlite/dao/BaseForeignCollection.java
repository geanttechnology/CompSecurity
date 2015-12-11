// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.j256.ormlite.dao:
//            ForeignCollection, Dao, CloseableIterator

public abstract class BaseForeignCollection
    implements ForeignCollection, Serializable
{

    private static final long serialVersionUID = 0xb8681d892ada296bL;
    protected final transient Dao dao;
    private final transient String fieldName;
    private final transient Object fieldValue;
    private final transient String orderColumn;
    private final transient Object parent;
    private transient PreparedQuery preparedQuery;

    protected BaseForeignCollection(Dao dao1, String s, Object obj, String s1, Object obj1)
    {
        dao = dao1;
        fieldName = s;
        fieldValue = obj;
        orderColumn = s1;
        parent = obj1;
    }

    public boolean add(Object obj)
    {
        if (dao == null)
        {
            return false;
        }
        try
        {
            dao.create(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException("Could not create data element in dao", ((Throwable) (obj)));
        }
        return true;
    }

    public boolean addAll(Collection collection)
    {
        boolean flag1 = false;
        boolean flag = false;
        if (dao != null)
        {
            collection = collection.iterator();
            flag = flag1;
            while (collection.hasNext()) 
            {
                Object obj = collection.next();
                try
                {
                    dao.create(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Collection collection)
                {
                    throw new IllegalStateException("Could not create data elements in dao", collection);
                }
                flag = true;
            }
        }
        return flag;
    }

    public void clear()
    {
        CloseableIterator closeableiterator;
        if (dao == null)
        {
            return;
        }
        closeableiterator = closeableIterator();
        while (closeableiterator.hasNext()) 
        {
            closeableiterator.next();
            closeableiterator.remove();
        }
        break MISSING_BLOCK_LABEL_47;
        Object obj;
        obj;
        try
        {
            closeableiterator.close();
        }
        catch (SQLException sqlexception) { }
        throw obj;
        try
        {
            closeableiterator.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    protected PreparedQuery getPreparedQuery()
    {
        if (dao == null)
        {
            return null;
        }
        if (preparedQuery == null)
        {
            SelectArg selectarg = new SelectArg();
            selectarg.setValue(fieldValue);
            QueryBuilder querybuilder = dao.queryBuilder();
            if (orderColumn != null)
            {
                querybuilder.orderBy(orderColumn, true);
            }
            preparedQuery = querybuilder.where().eq(fieldName, selectarg).prepare();
            if (preparedQuery instanceof MappedPreparedStmt)
            {
                ((MappedPreparedStmt)preparedQuery).setParentObject(parent);
            }
        }
        return preparedQuery;
    }

    public abstract boolean remove(Object obj);

    public abstract boolean removeAll(Collection collection);

    public boolean retainAll(Collection collection)
    {
        CloseableIterator closeableiterator;
        boolean flag;
        flag = false;
        if (dao == null)
        {
            return false;
        }
        closeableiterator = closeableIterator();
_L2:
        if (!closeableiterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        if (collection.contains(closeableiterator.next()))
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
}
