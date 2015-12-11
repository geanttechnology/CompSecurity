// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.j256.ormlite.android:
//            AndroidDatabaseResults

public class AndroidCompiledStatement
    implements CompiledStatement
{

    private final List args = new ArrayList();
    private Cursor cursor;
    private final SQLiteDatabase db;
    private Integer max;
    private final String sql;
    private final com.j256.ormlite.stmt.StatementBuilder.StatementType type;

    public AndroidCompiledStatement(String s, SQLiteDatabase sqlitedatabase, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype)
    {
        sql = s;
        db = sqlitedatabase;
        type = statementtype;
    }

    private void isInPrep()
    {
        if (cursor != null)
        {
            throw new SQLException("Query already run. Cannot add argument values.");
        } else
        {
            return;
        }
    }

    public void close()
    {
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        cursor.close();
        return;
        android.database.SQLException sqlexception;
        sqlexception;
        throw SqlExceptionUtil.create("Problems closing Android cursor", sqlexception);
    }

    public int getColumnCount()
    {
        return getCursor().getColumnCount();
    }

    public String getColumnName(int i)
    {
        return getCursor().getColumnName(i);
    }

    public Cursor getCursor()
    {
        String s;
        String s1;
        if (cursor != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s = null;
        s1 = s;
        if (max != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        s1 = s;
        try
        {
            s = sql;
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems executing Android query: ").append(s1).toString(), sqlexception);
        }
        s1 = s;
        cursor = db.rawQuery(s, (String[])args.toArray(new String[args.size()]));
        s1 = s;
        cursor.moveToFirst();
        return cursor;
        s1 = s;
        s = (new StringBuilder()).append(sql).append(" ").append(max).toString();
        break MISSING_BLOCK_LABEL_25;
    }

    public int runExecute()
    {
        if (type != com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot call execute on a ").append(type).append(" statement").toString());
        }
        try
        {
            db.execSQL(sql, new Object[0]);
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems executing Android statement: ").append(sql).toString(), sqlexception);
        }
        return 0;
    }

    public DatabaseResults runQuery(ObjectCache objectcache)
    {
        if (type != com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot call query on a ").append(type).append(" statement").toString());
        } else
        {
            return new AndroidDatabaseResults(getCursor(), objectcache);
        }
    }

    public int runUpdate()
    {
        String s;
        String s1;
        if (type == com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot call update on a ").append(type).append(" statement").toString());
        }
        s = null;
        s1 = s;
        if (max != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        s1 = s;
        try
        {
            s = sql;
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems executing Android statement: ").append(s1).toString(), sqlexception);
        }
        s1 = s;
        db.execSQL(s, args.toArray(new Object[args.size()]));
        return 1;
        s1 = s;
        s = (new StringBuilder()).append(sql).append(" ").append(max).toString();
        break MISSING_BLOCK_LABEL_63;
    }

    public void setMaxRows(int i)
    {
        isInPrep();
        max = Integer.valueOf(i);
    }

    public void setNull(int i, SqlType sqltype)
    {
        isInPrep();
        args.add(i, null);
    }

    public void setObject(int i, Object obj, SqlType sqltype)
    {
        isInPrep();
        args.add(i, obj.toString());
    }
}
