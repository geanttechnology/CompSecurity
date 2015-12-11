// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

// Referenced classes of package com.j256.ormlite.android:
//            AndroidCompiledStatement, AndroidDatabaseResults

public class AndroidDatabaseConnection
    implements DatabaseConnection
{

    private final SQLiteDatabase db;
    private final boolean readWrite;

    public AndroidDatabaseConnection(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        db = sqlitedatabase;
        readWrite = flag;
    }

    private void bindArgs(SQLiteStatement sqlitestatement, Object aobj[], FieldType afieldtype[])
    {
        if (aobj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 0;
_L6:
        if (i >= aobj.length) goto _L1; else goto _L3
_L3:
        Object obj = aobj[i];
        if (obj != null) goto _L5; else goto _L4
_L4:
        sqlitestatement.bindNull(i + 1);
_L8:
        i++;
          goto _L6
_L5:
        class _cls1
        {

            static final int $SwitchMap$com$j256$ormlite$field$SqlType[];

            static 
            {
                $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.j256.ormlite.field.SqlType[afieldtype[i].getSqlType().ordinal()])
        {
        default:
            throw new SQLException((new StringBuilder()).append("Unknown sql argument type ").append(afieldtype[i].getSqlType()).toString());

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            sqlitestatement.bindString(i + 1, obj.toString());
            break;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            sqlitestatement.bindLong(i + 1, ((Number)obj).longValue());
            break;

        case 9: // '\t'
        case 10: // '\n'
            sqlitestatement.bindDouble(i + 1, ((Number)obj).doubleValue());
            break;

        case 11: // '\013'
        case 12: // '\f'
            sqlitestatement.bindBlob(i + 1, (byte[])(byte[])obj);
            break;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private String[] toStrings(Object aobj[])
    {
        if (aobj == null)
        {
            return null;
        }
        String as[] = new String[aobj.length];
        int i = 0;
        while (i < aobj.length) 
        {
            Object obj = aobj[i];
            if (obj == null)
            {
                as[i] = null;
            } else
            {
                as[i] = obj.toString();
            }
            i++;
        }
        return as;
    }

    public void close()
    {
        try
        {
            db.close();
            return;
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create("problems closing the database connection", sqlexception);
        }
    }

    public void commit(Savepoint savepoint)
    {
        try
        {
            db.setTransactionSuccessful();
            db.endTransaction();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Savepoint savepoint)
        {
            throw SqlExceptionUtil.create("problems commiting transaction", savepoint);
        }
    }

    public CompiledStatement compileStatement(String s, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype, FieldType afieldtype[])
    {
        return new AndroidCompiledStatement(s, db, statementtype);
    }

    public int delete(String s, Object aobj[], FieldType afieldtype[])
    {
        return update(s, aobj, afieldtype);
    }

    public boolean getAutoCommit()
    {
        boolean flag;
        try
        {
            flag = db.inTransaction();
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", sqlexception);
        }
        return !flag;
    }

    public int insert(String s, Object aobj[], FieldType afieldtype[], GeneratedKeyHolder generatedkeyholder)
    {
        SQLiteStatement sqlitestatement;
        SQLiteStatement sqlitestatement1;
        sqlitestatement1 = null;
        sqlitestatement = null;
        SQLiteStatement sqlitestatement2 = db.compileStatement(s);
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        bindArgs(sqlitestatement2, aobj, afieldtype);
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        long l = sqlitestatement2.executeInsert();
        if (generatedkeyholder == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        generatedkeyholder.addKey(Long.valueOf(l));
        if (sqlitestatement2 != null)
        {
            sqlitestatement2.close();
        }
        return 1;
        aobj;
        sqlitestatement1 = sqlitestatement;
        throw SqlExceptionUtil.create((new StringBuilder()).append("inserting to database failed: ").append(s).toString(), ((Throwable) (aobj)));
        s;
        if (sqlitestatement1 != null)
        {
            sqlitestatement1.close();
        }
        throw s;
    }

    public boolean isAutoCommitSupported()
    {
        return false;
    }

    public boolean isClosed()
    {
        boolean flag;
        try
        {
            flag = db.isOpen();
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", sqlexception);
        }
        return !flag;
    }

    public boolean isReadWrite()
    {
        return readWrite;
    }

    public boolean isTableExists(String s)
    {
        return true;
    }

    public long queryForLong(String s)
    {
        SQLiteStatement sqlitestatement;
        SQLiteStatement sqlitestatement1;
        sqlitestatement1 = null;
        sqlitestatement = null;
        SQLiteStatement sqlitestatement2 = db.compileStatement(s);
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        long l = sqlitestatement2.simpleQueryForLong();
        if (sqlitestatement2 != null)
        {
            sqlitestatement2.close();
        }
        return l;
        android.database.SQLException sqlexception;
        sqlexception;
        sqlitestatement1 = sqlitestatement;
        throw SqlExceptionUtil.create((new StringBuilder()).append("queryForLong from database failed: ").append(s).toString(), sqlexception);
        s;
        if (sqlitestatement1 != null)
        {
            sqlitestatement1.close();
        }
        throw s;
    }

    public Object queryForOne(String s, Object aobj[], FieldType afieldtype[], GenericRowMapper genericrowmapper, ObjectCache objectcache)
    {
        Object obj = null;
        aobj = db.rawQuery(s, toStrings(aobj));
        afieldtype = ((FieldType []) (aobj));
        objectcache = new AndroidDatabaseResults(((Cursor) (aobj)), objectcache);
        afieldtype = ((FieldType []) (aobj));
        boolean flag = objectcache.next();
        if (flag) goto _L2; else goto _L1
_L1:
        s = obj;
        if (aobj != null)
        {
            ((Cursor) (aobj)).close();
            s = obj;
        }
_L4:
        return s;
_L2:
        afieldtype = ((FieldType []) (aobj));
        genericrowmapper = ((GenericRowMapper) (genericrowmapper.mapRow(objectcache)));
        afieldtype = ((FieldType []) (aobj));
        if (!objectcache.next())
        {
            break; /* Loop/switch isn't completed */
        }
        afieldtype = ((FieldType []) (aobj));
        genericrowmapper = ((GenericRowMapper) (MORE_THAN_ONE));
        s = genericrowmapper;
        if (aobj != null)
        {
            ((Cursor) (aobj)).close();
            return genericrowmapper;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s = genericrowmapper;
        if (aobj == null) goto _L4; else goto _L5
_L5:
        ((Cursor) (aobj)).close();
        return genericrowmapper;
        genericrowmapper;
        aobj = null;
_L9:
        afieldtype = ((FieldType []) (aobj));
        throw SqlExceptionUtil.create((new StringBuilder()).append("queryForOne from database failed: ").append(s).toString(), genericrowmapper);
        s;
_L7:
        if (afieldtype != null)
        {
            afieldtype.close();
        }
        throw s;
        s;
        afieldtype = null;
        if (true) goto _L7; else goto _L6
_L6:
        genericrowmapper;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void rollback(Savepoint savepoint)
    {
        try
        {
            db.endTransaction();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Savepoint savepoint)
        {
            throw SqlExceptionUtil.create("problems rolling back transaction", savepoint);
        }
    }

    public void setAutoCommit(boolean flag)
    {
    }

    public Savepoint setSavePoint(String s)
    {
        try
        {
            db.beginTransaction();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw SqlExceptionUtil.create("problems beginning transaction", s);
        }
        return null;
    }

    public int update(String s, Object aobj[], FieldType afieldtype[])
    {
        SQLiteStatement sqlitestatement;
        SQLiteStatement sqlitestatement1;
        sqlitestatement1 = null;
        sqlitestatement = null;
        SQLiteStatement sqlitestatement2 = db.compileStatement(s);
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        bindArgs(sqlitestatement2, aobj, afieldtype);
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        sqlitestatement2.execute();
        if (sqlitestatement2 != null)
        {
            sqlitestatement2.close();
        }
        return 1;
        aobj;
        sqlitestatement1 = sqlitestatement;
        throw SqlExceptionUtil.create((new StringBuilder()).append("updating database failed: ").append(s).toString(), ((Throwable) (aobj)));
        s;
        if (sqlitestatement1 != null)
        {
            sqlitestatement1.close();
        }
        throw s;
    }
}
