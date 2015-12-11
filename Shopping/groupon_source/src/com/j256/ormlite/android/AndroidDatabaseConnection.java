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
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
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
    private static class OurSavePoint
        implements Savepoint
    {

        private String name;

        public int getSavepointId()
        {
            return 0;
        }

        public String getSavepointName()
        {
            return name;
        }

        public OurSavePoint(String s)
        {
            name = s;
        }
    }


    private static final String NO_STRING_ARGS[] = new String[0];
    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/android/AndroidDatabaseConnection);
    private final SQLiteDatabase db;
    private final boolean readWrite;

    public AndroidDatabaseConnection(SQLiteDatabase sqlitedatabase, boolean flag)
    {
        db = sqlitedatabase;
        readWrite = flag;
        logger.trace("{}: db {} opened, read-write = {}", this, sqlitedatabase, Boolean.valueOf(flag));
    }

    private void bindArgs(SQLiteStatement sqlitestatement, Object aobj[], FieldType afieldtype[])
        throws SQLException
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
        SqlType sqltype = afieldtype[i].getSqlType();
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
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
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

        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
            throw new SQLException((new StringBuilder()).append("Invalid Android type: ").append(sqltype).toString());
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private String[] toStrings(Object aobj[])
    {
        if (aobj != null && aobj.length != 0) goto _L2; else goto _L1
_L1:
        String as[] = null;
_L4:
        return as;
_L2:
        String as1[] = new String[aobj.length];
        int i = 0;
        do
        {
            as = as1;
            if (i >= aobj.length)
            {
                continue;
            }
            Object obj = aobj[i];
            if (obj == null)
            {
                as1[i] = null;
            } else
            {
                as1[i] = obj.toString();
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int update(String s, Object aobj[], FieldType afieldtype[], String s1)
        throws SQLException
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
        aobj = sqlitestatement2;
        if (sqlitestatement2 != null)
        {
            sqlitestatement2.close();
            aobj = null;
        }
        afieldtype = ((FieldType []) (aobj));
        sqlitestatement = db.compileStatement("SELECT CHANGES()");
        afieldtype = sqlitestatement;
        aobj = sqlitestatement;
        long l = sqlitestatement.simpleQueryForLong();
        int i;
        int j = (int)l;
        i = j;
        if (sqlitestatement != null)
        {
            sqlitestatement.close();
            i = j;
        }
_L2:
        logger.trace("{} statement is compiled and executed, changed {}: {}", s1, Integer.valueOf(i), s);
        return i;
        aobj;
        sqlitestatement1 = sqlitestatement;
        throw SqlExceptionUtil.create((new StringBuilder()).append("updating database failed: ").append(s).toString(), ((Throwable) (aobj)));
        s;
        if (sqlitestatement1 != null)
        {
            sqlitestatement1.close();
        }
        throw s;
        aobj;
        boolean flag = true;
        i = ((flag) ? 1 : 0);
        if (afieldtype != null)
        {
            afieldtype.close();
            i = ((flag) ? 1 : 0);
        }
        if (true) goto _L2; else goto _L1
_L1:
        s;
        if (aobj != null)
        {
            ((SQLiteStatement) (aobj)).close();
        }
        throw s;
    }

    public void commit(Savepoint savepoint)
        throws SQLException
    {
        try
        {
            db.setTransactionSuccessful();
            db.endTransaction();
        }
        catch (android.database.SQLException sqlexception)
        {
            if (savepoint == null)
            {
                throw SqlExceptionUtil.create("problems commiting transaction", sqlexception);
            } else
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("problems commiting transaction ").append(savepoint.getSavepointName()).toString(), sqlexception);
            }
        }
        if (savepoint != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        logger.trace("{}: transaction is successfuly ended", this);
        return;
        logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
        return;
    }

    public CompiledStatement compileStatement(String s, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype, FieldType afieldtype[])
    {
        statementtype = new AndroidCompiledStatement(s, db, statementtype);
        logger.trace("{}: compiled statement got {}: {}", this, statementtype, s);
        return statementtype;
    }

    public CompiledStatement compileStatement(String s, com.j256.ormlite.stmt.StatementBuilder.StatementType statementtype, FieldType afieldtype[], int i)
    {
        return compileStatement(s, statementtype, afieldtype);
    }

    public int delete(String s, Object aobj[], FieldType afieldtype[])
        throws SQLException
    {
        return update(s, aobj, afieldtype, "deleted");
    }

    public int executeStatement(String s, int i)
        throws SQLException
    {
        return AndroidCompiledStatement.execSql(db, s, s, NO_STRING_ARGS);
    }

    public int insert(String s, Object aobj[], FieldType afieldtype[], GeneratedKeyHolder generatedkeyholder)
        throws SQLException
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
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        logger.trace("{}: insert statement is compiled and executed, changed {}: {}", this, Integer.valueOf(1), s);
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

    public boolean isAutoCommit()
        throws SQLException
    {
        boolean flag;
        try
        {
            flag = db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(flag));
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", sqlexception);
        }
        return !flag;
    }

    public boolean isAutoCommitSupported()
    {
        return true;
    }

    public boolean isTableExists(String s)
    {
        Cursor cursor = db.rawQuery((new StringBuilder()).append("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '").append(s).append("'").toString(), null);
        boolean flag;
        if (cursor.getCount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        logger.trace("{}: isTableExists '{}' returned {}", this, s, Boolean.valueOf(flag));
        cursor.close();
        return flag;
        s;
        cursor.close();
        throw s;
    }

    public long queryForLong(String s)
        throws SQLException
    {
        SQLiteStatement sqlitestatement;
        SQLiteStatement sqlitestatement1;
        sqlitestatement1 = null;
        sqlitestatement = null;
        SQLiteStatement sqlitestatement2 = db.compileStatement(s);
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        long l = sqlitestatement2.simpleQueryForLong();
        sqlitestatement = sqlitestatement2;
        sqlitestatement1 = sqlitestatement2;
        logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(l), s);
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

    public long queryForLong(String s, Object aobj[], FieldType afieldtype[])
        throws SQLException
    {
        Object aobj1[];
        aobj1 = null;
        afieldtype = null;
        aobj = db.rawQuery(s, toStrings(aobj));
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        AndroidDatabaseResults androiddatabaseresults = new AndroidDatabaseResults(((Cursor) (aobj)), null);
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        if (!androiddatabaseresults.first()) goto _L2; else goto _L1
_L1:
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        long l = androiddatabaseresults.getLong(0);
_L4:
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        logger.trace("{}: query for long raw query returned {}: {}", this, Long.valueOf(l), s);
        if (aobj != null)
        {
            ((Cursor) (aobj)).close();
        }
        return l;
_L2:
        l = 0L;
        if (true) goto _L4; else goto _L3
_L3:
        aobj;
        aobj1 = afieldtype;
        throw SqlExceptionUtil.create((new StringBuilder()).append("queryForLong from database failed: ").append(s).toString(), ((Throwable) (aobj)));
        s;
        if (aobj1 != null)
        {
            ((Cursor) (aobj1)).close();
        }
        throw s;
    }

    public Object queryForOne(String s, Object aobj[], FieldType afieldtype[], GenericRowMapper genericrowmapper, ObjectCache objectcache)
        throws SQLException
    {
        Object aobj1[];
        aobj1 = null;
        afieldtype = null;
        aobj = db.rawQuery(s, toStrings(aobj));
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        objectcache = new AndroidDatabaseResults(((Cursor) (aobj)), objectcache);
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        logger.trace("{}: queried for one result: {}", this, s);
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        boolean flag = objectcache.first();
        if (flag) goto _L2; else goto _L1
_L1:
        afieldtype = null;
        s = afieldtype;
        if (aobj != null)
        {
            ((Cursor) (aobj)).close();
            s = afieldtype;
        }
_L4:
        return s;
_L2:
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        genericrowmapper = ((GenericRowMapper) (genericrowmapper.mapRow(objectcache)));
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
        if (!objectcache.next())
        {
            break; /* Loop/switch isn't completed */
        }
        afieldtype = ((FieldType []) (aobj));
        aobj1 = aobj;
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
        if (aobj != null)
        {
            ((Cursor) (aobj)).close();
            return genericrowmapper;
        }
        if (true) goto _L4; else goto _L5
_L5:
        aobj;
        aobj1 = afieldtype;
        throw SqlExceptionUtil.create((new StringBuilder()).append("queryForOne from database failed: ").append(s).toString(), ((Throwable) (aobj)));
        s;
        if (aobj1 != null)
        {
            ((Cursor) (aobj1)).close();
        }
        throw s;
    }

    public void rollback(Savepoint savepoint)
        throws SQLException
    {
        try
        {
            db.endTransaction();
        }
        catch (android.database.SQLException sqlexception)
        {
            if (savepoint == null)
            {
                throw SqlExceptionUtil.create("problems rolling back transaction", sqlexception);
            } else
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("problems rolling back transaction ").append(savepoint.getSavepointName()).toString(), sqlexception);
            }
        }
        if (savepoint != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        logger.trace("{}: transaction is ended, unsuccessfuly", this);
        return;
        logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
        return;
    }

    public void setAutoCommit(boolean flag)
    {
        if (flag)
        {
            if (db.inTransaction())
            {
                db.setTransactionSuccessful();
                db.endTransaction();
            }
        } else
        if (!db.inTransaction())
        {
            db.beginTransaction();
            return;
        }
    }

    public Savepoint setSavePoint(String s)
        throws SQLException
    {
        OurSavePoint oursavepoint;
        try
        {
            db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, s);
            oursavepoint = new OurSavePoint(s);
        }
        catch (android.database.SQLException sqlexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("problems beginning transaction ").append(s).toString(), sqlexception);
        }
        return oursavepoint;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("@").append(Integer.toHexString(super.hashCode())).toString();
    }

    public int update(String s, Object aobj[], FieldType afieldtype[])
        throws SQLException
    {
        return update(s, aobj, afieldtype, "updated");
    }

    static 
    {
        VersionUtils.checkCoreVersusAndroidVersions("VERSION__4.47__");
    }
}
