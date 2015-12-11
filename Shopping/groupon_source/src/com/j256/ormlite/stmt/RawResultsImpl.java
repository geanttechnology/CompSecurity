// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Iterator;

// Referenced classes of package com.j256.ormlite.stmt:
//            SelectIterator, GenericRowMapper

public class RawResultsImpl
    implements GenericRawResults
{

    private final String columnNames[];
    private SelectIterator iterator;

    public RawResultsImpl(ConnectionSource connectionsource, DatabaseConnection databaseconnection, String s, Class class1, CompiledStatement compiledstatement, GenericRowMapper genericrowmapper, ObjectCache objectcache)
        throws SQLException
    {
        iterator = new SelectIterator(class1, null, genericrowmapper, connectionsource, databaseconnection, compiledstatement, s, objectcache);
        columnNames = iterator.getRawResults().getColumnNames();
    }

    public CloseableIterator closeableIterator()
    {
        return iterator;
    }

    public CloseableIterator iterator()
    {
        return iterator;
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }
}
