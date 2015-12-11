// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper

public class SelectIterator
    implements CloseableIterator
{

    private static final Logger logger = LoggerFactory.getLogger(com/j256/ormlite/stmt/SelectIterator);
    private final Dao classDao;
    private boolean closed;
    private final CompiledStatement compiledStmt;
    private final DatabaseConnection connection;
    private final ConnectionSource connectionSource;
    private final Class dataClass;
    private Object last;
    private final DatabaseResults results;
    private int rowC;
    private final GenericRowMapper rowMapper;
    private final String statement;

    public SelectIterator(Class class1, Dao dao, GenericRowMapper genericrowmapper, ConnectionSource connectionsource, DatabaseConnection databaseconnection, CompiledStatement compiledstatement, String s, 
            ObjectCache objectcache)
    {
        closed = false;
        last = null;
        rowC = 0;
        dataClass = class1;
        classDao = dao;
        rowMapper = genericrowmapper;
        connectionSource = connectionsource;
        connection = databaseconnection;
        compiledStmt = compiledstatement;
        results = compiledstatement.runQuery(objectcache);
        statement = s;
        if (s != null)
        {
            logger.debug("starting iterator @{} for '{}'", new Object[] {
                Integer.valueOf(hashCode()), s
            });
        }
    }

    public void close()
    {
        if (!closed)
        {
            compiledStmt.close();
            closed = true;
            last = null;
            if (statement != null)
            {
                logger.debug("closed iterator @{} after {} rows", new Object[] {
                    Integer.valueOf(hashCode()), Integer.valueOf(rowC)
                });
            }
            connectionSource.releaseConnection(connection);
        }
    }

    public DatabaseResults getRawResults()
    {
        return results;
    }

    public boolean hasNext()
    {
        boolean flag;
        try
        {
            flag = hasNextThrow();
        }
        catch (SQLException sqlexception)
        {
            last = null;
            try
            {
                close();
            }
            catch (SQLException sqlexception1) { }
            throw new IllegalStateException((new StringBuilder()).append("Errors getting more results of ").append(dataClass).toString(), sqlexception);
        }
        return flag;
    }

    public boolean hasNextThrow()
    {
        if (closed)
        {
            return false;
        }
        if (results.next())
        {
            return true;
        } else
        {
            close();
            return false;
        }
    }

    public Object next()
    {
        Object obj;
        try
        {
            obj = nextThrow();
        }
        catch (SQLException sqlexception)
        {
            last = null;
            try
            {
                close();
            }
            catch (SQLException sqlexception1) { }
            throw new IllegalStateException((new StringBuilder()).append("Errors getting more results of ").append(dataClass).toString(), sqlexception);
        }
        return obj;
    }

    public Object nextThrow()
    {
        if (closed)
        {
            return null;
        } else
        {
            last = rowMapper.mapRow(results);
            rowC = rowC + 1;
            return last;
        }
    }

    public void remove()
    {
        try
        {
            removeThrow();
            return;
        }
        catch (SQLException sqlexception)
        {
            try
            {
                close();
            }
            catch (SQLException sqlexception1) { }
        }
        throw new IllegalStateException((new StringBuilder()).append("Errors trying to delete ").append(dataClass).append(" object ").append(last).toString(), sqlexception);
    }

    public void removeThrow()
    {
        if (last == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No last ").append(dataClass).append(" object to remove. Must be called after a call to next.").toString());
        }
        if (classDao == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Cannot remove ").append(dataClass).append(" object because classDao not initialized").toString());
        }
        classDao.delete(last);
        last = null;
        return;
        Exception exception;
        exception;
        last = null;
        throw exception;
    }

}
