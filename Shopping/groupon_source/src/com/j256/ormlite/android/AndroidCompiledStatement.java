// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
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

    private static final String NO_STRING_ARGS[] = new String[0];
    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/android/AndroidCompiledStatement);
    private List args;
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

    static int execSql(SQLiteDatabase sqlitedatabase, String s, String s1, Object aobj[])
        throws SQLException
    {
        SQLiteDatabase sqlitedatabase1;
        int i;
        int j;
        long l;
        try
        {
            sqlitedatabase.execSQL(s1, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems executing ").append(s).append(" Android statement: ").append(s1).toString(), sqlitedatabase);
        }
        sqlitedatabase1 = null;
        aobj = null;
        sqlitedatabase = sqlitedatabase.compileStatement("SELECT CHANGES()");
        aobj = sqlitedatabase;
        sqlitedatabase1 = sqlitedatabase;
        l = sqlitedatabase.simpleQueryForLong();
        j = (int)l;
        i = j;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
            i = j;
        }
_L2:
        logger.trace("executing statement {} changed {} rows: {}", s, Integer.valueOf(i), s1);
        return i;
        sqlitedatabase;
        boolean flag = true;
        i = ((flag) ? 1 : 0);
        if (aobj != null)
        {
            ((SQLiteStatement) (aobj)).close();
            i = ((flag) ? 1 : 0);
        }
        if (true) goto _L2; else goto _L1
_L1:
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
    }

    private Object[] getArgArray()
    {
        if (args == null)
        {
            return NO_STRING_ARGS;
        } else
        {
            return args.toArray(new Object[args.size()]);
        }
    }

    private String[] getStringArray()
    {
        if (args == null)
        {
            return NO_STRING_ARGS;
        } else
        {
            return (String[])args.toArray(new String[args.size()]);
        }
    }

    private void isInPrep()
        throws SQLException
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
        throws SQLException
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

    public Cursor getCursor()
        throws SQLException
    {
        String s;
        String s1;
        if (cursor != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        s = null;
        s1 = s;
        if (max != null)
        {
            break MISSING_BLOCK_LABEL_72;
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
        cursor = db.rawQuery(s, getStringArray());
        s1 = s;
        cursor.moveToFirst();
        s1 = s;
        logger.trace("{}: started rawQuery cursor for: {}", this, s);
        return cursor;
        s1 = s;
        s = (new StringBuilder()).append(sql).append(" ").append(max).toString();
        break MISSING_BLOCK_LABEL_25;
    }

    public int runExecute()
        throws SQLException
    {
        if (!type.isOkForExecute())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot call execute on a ").append(type).append(" statement").toString());
        } else
        {
            return execSql(db, "runExecute", sql, getArgArray());
        }
    }

    public DatabaseResults runQuery(ObjectCache objectcache)
        throws SQLException
    {
        if (!type.isOkForQuery())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot call query on a ").append(type).append(" statement").toString());
        } else
        {
            return new AndroidDatabaseResults(getCursor(), objectcache);
        }
    }

    public int runUpdate()
        throws SQLException
    {
        if (!type.isOkForUpdate())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot call update on a ").append(type).append(" statement").toString());
        }
        String s;
        if (max == null)
        {
            s = sql;
        } else
        {
            s = (new StringBuilder()).append(sql).append(" ").append(max).toString();
        }
        return execSql(db, "runUpdate", s, getArgArray());
    }

    public void setMaxRows(int i)
        throws SQLException
    {
        isInPrep();
        max = Integer.valueOf(i);
    }

    public void setObject(int i, Object obj, SqlType sqltype)
        throws SQLException
    {
        isInPrep();
        if (args == null)
        {
            args = new ArrayList();
        }
        if (obj == null)
        {
            args.add(i, null);
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$j256$ormlite$field$SqlType[];

            static 
            {
                $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.j256.ormlite.field.SqlType[sqltype.ordinal()])
        {
        default:
            throw new SQLException((new StringBuilder()).append("Unknown sql argument type: ").append(sqltype).toString());

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            args.add(i, obj.toString());
            return;

        case 12: // '\f'
        case 13: // '\r'
            args.add(i, obj);
            return;

        case 14: // '\016'
        case 15: // '\017'
            throw new SQLException((new StringBuilder()).append("Invalid Android type: ").append(sqltype).toString());
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("@").append(Integer.toHexString(super.hashCode())).toString();
    }

}
