// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.framework.data.dao.SortOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            CursorListDataProvider, ReadOnlySQLiteDatabase, CursorRowProcessor, GalleryDBConnectionManager, 
//            DBReadExecutor

public class CursorRowDataProvider
    implements CursorListDataProvider
{
    public static class Builder
    {

        private String columns[];
        private GalleryDBConnectionManager connectionManager;
        private String groupBy;
        private String having;
        private String orderBy;
        private CursorRowProcessor rowProcessor;
        private String selection;
        private String selectionArgs[];
        private String table;

        public CursorRowDataProvider build()
        {
            boolean flag1 = true;
            boolean flag;
            if (rowProcessor != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            DebugAssert.assertTrue(flag);
            if (table != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            DebugAssert.assertTrue(flag);
            if (columns != null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            DebugAssert.assertTrue(flag);
            return new CursorRowDataProvider(connectionManager, rowProcessor, table, columns, selection, selectionArgs, groupBy, having, orderBy);
        }

        public Builder from(String s)
        {
            table = s;
            return this;
        }

        public Builder groupBy(String s)
        {
            groupBy = s;
            return this;
        }

        public Builder orderBy(SortOrder sortorder)
        {
            orderBy = sortorder.getOrderByString();
            return this;
        }

        public Builder orderBy(String s)
        {
            orderBy = s;
            return this;
        }

        public transient Builder select(String as[])
        {
            columns = as;
            return this;
        }

        public Builder setRowProcessor(CursorRowProcessor cursorrowprocessor)
        {
            rowProcessor = cursorrowprocessor;
            return this;
        }

        public transient Builder where(String s, String as[])
        {
            selection = s;
            selectionArgs = as;
            return this;
        }

        public Builder(GalleryDBConnectionManager gallerydbconnectionmanager)
        {
            connectionManager = gallerydbconnectionmanager;
        }
    }

    private static class Limit
    {

        private final int length;
        private final int pos;

        public int getLength()
        {
            return length;
        }

        public String toString()
        {
            return (new StringBuilder()).append(pos).append(",").append(length).toString();
        }

        private Limit(int i, int j)
        {
            pos = i;
            length = j;
        }

    }


    private static final Limit NO_LIMIT = new Limit(0, 0) {

        public int getLength()
        {
            return 10;
        }

        public String toString()
        {
            return null;
        }

    };
    private final String columns[];
    private final GalleryDBConnectionManager connectionManager;
    private final String groupBy;
    private final String having;
    private final String orderBy;
    private final CursorRowProcessor rowProcessor;
    private final String selection;
    private final String selectionArgs[];
    private int size;
    private final String table;

    CursorRowDataProvider(GalleryDBConnectionManager gallerydbconnectionmanager, CursorRowProcessor cursorrowprocessor, String s, String as[], String s1, String as1[], String s2, 
            String s3, String s4)
    {
        size = -1;
        connectionManager = gallerydbconnectionmanager;
        rowProcessor = cursorrowprocessor;
        table = s;
        columns = as;
        selection = s1;
        selectionArgs = as1;
        groupBy = s2;
        having = s3;
        orderBy = s4;
    }

    private List query(final Limit limit)
    {
        return (List)(new DBReadExecutor() {

            final CursorRowDataProvider this$0;
            final Limit val$limit;

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            protected List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return queryHelper(readonlysqlitedatabase, limit);
            }

            
            {
                this$0 = CursorRowDataProvider.this;
                limit = limit1;
                super();
            }
        }).execute(connectionManager);
    }

    public List query()
    {
        return query(NO_LIMIT);
    }

    public List query(int i, int j)
    {
        return query(new Limit(i, j));
    }

    protected List queryHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase, Limit limit)
    {
        readonlysqlitedatabase = readonlysqlitedatabase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit.toString());
        if (readonlysqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        if (!readonlysqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        limit = new ArrayList(limit.getLength());
        for (; !readonlysqlitedatabase.isAfterLast(); readonlysqlitedatabase.moveToNext())
        {
            limit.add(rowProcessor.process(readonlysqlitedatabase));
        }

        break MISSING_BLOCK_LABEL_107;
        limit;
        readonlysqlitedatabase.close();
        throw limit;
        readonlysqlitedatabase.close();
        return limit;
        readonlysqlitedatabase.close();
        return Collections.emptyList();
    }

    public int size()
    {
        size = ((Integer)(new DBReadExecutor() {

            final CursorRowDataProvider this$0;

            protected Integer execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return Integer.valueOf(sizeHelper(readonlysqlitedatabase));
            }

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = CursorRowDataProvider.this;
                super();
            }
        }).execute(connectionManager)).intValue();
        return size;
    }

    protected int sizeHelper(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        String s = table;
        String s1 = selection;
        String s2 = groupBy;
        String s3 = having;
        readonlysqlitedatabase = readonlysqlitedatabase.compileStatement(SQLiteQueryBuilder.buildQueryString(false, s, new String[] {
            "count(*)"
        }, s1, s2, s3, null, null));
        if (selectionArgs != null)
        {
            readonlysqlitedatabase.bindAllArgsAsStrings(selectionArgs);
        }
        return (int)readonlysqlitedatabase.simpleQueryForLong();
    }

}
