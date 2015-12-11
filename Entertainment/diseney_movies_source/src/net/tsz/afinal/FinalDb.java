// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.tsz.afinal.db.sqlite.CursorUtils;
import net.tsz.afinal.db.sqlite.DbModel;
import net.tsz.afinal.db.sqlite.SqlBuilder;
import net.tsz.afinal.db.sqlite.SqlInfo;
import net.tsz.afinal.db.table.Id;
import net.tsz.afinal.db.table.KeyValue;
import net.tsz.afinal.db.table.ManyToOne;
import net.tsz.afinal.db.table.OneToMany;
import net.tsz.afinal.db.table.TableInfo;

public class FinalDb
{
    public static class DaoConfig
    {

        private Context context;
        private String dbName;
        private DbUpdateListener dbUpdateListener;
        private int dbVersion;
        private boolean debug;

        public Context getContext()
        {
            return context;
        }

        public String getDbName()
        {
            return dbName;
        }

        public DbUpdateListener getDbUpdateListener()
        {
            return dbUpdateListener;
        }

        public int getDbVersion()
        {
            return dbVersion;
        }

        public boolean isDebug()
        {
            return debug;
        }

        public void setContext(Context context1)
        {
            context = context1;
        }

        public void setDbName(String s)
        {
            dbName = s;
        }

        public void setDbUpdateListener(DbUpdateListener dbupdatelistener)
        {
            dbUpdateListener = dbupdatelistener;
        }

        public void setDbVersion(int i)
        {
            dbVersion = i;
        }

        public void setDebug(boolean flag)
        {
            debug = flag;
        }

        public DaoConfig()
        {
            context = null;
            dbName = "afinal.db";
            dbVersion = 1;
            debug = true;
        }
    }

    public static interface DbUpdateListener
    {

        public abstract void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j);
    }

    class SqliteDbHelper extends SQLiteOpenHelper
    {

        private DbUpdateListener mDbUpdateListener;
        final FinalDb this$0;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            if (mDbUpdateListener == null) goto _L2; else goto _L1
_L1:
            mDbUpdateListener.onUpgrade(sqlitedatabase, i, j);
_L4:
            return;
_L2:
            Cursor cursor = sqlitedatabase.rawQuery("SELECT name FROM sqlite_master WHERE type ='table'", null);
            if (cursor == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            for (; cursor.moveToNext(); sqlitedatabase.execSQL((new StringBuilder("DROP TABLE ")).append(cursor.getString(0)).toString()))
            {
                break MISSING_BLOCK_LABEL_57;
            }

            if (cursor == null) goto _L4; else goto _L3
_L3:
            cursor.close();
            return;
        }

        public SqliteDbHelper(Context context, String s, int i, DbUpdateListener dbupdatelistener)
        {
            this$0 = FinalDb.this;
            super(context, s, null, i);
            mDbUpdateListener = dbupdatelistener;
        }
    }


    private static final String TAG = "FinalDb";
    private static HashMap daoMap = new HashMap();
    private DaoConfig config;
    private SQLiteDatabase db;

    private FinalDb(DaoConfig daoconfig)
    {
        if (daoconfig == null)
        {
            throw new RuntimeException("daoConfig is null");
        }
        if (daoconfig.getContext() == null)
        {
            throw new RuntimeException("android context is null");
        } else
        {
            db = (new SqliteDbHelper(daoconfig.getContext().getApplicationContext(), daoconfig.getDbName(), daoconfig.getDbVersion(), daoconfig.getDbUpdateListener())).getWritableDatabase();
            config = daoconfig;
            return;
        }
    }

    private void checkTableExist(Class class1)
    {
        if (!tableIsExist(TableInfo.get(class1)))
        {
            class1 = SqlBuilder.getCreatTableSQL(class1);
            debugSql(class1);
            db.execSQL(class1);
        }
    }

    public static FinalDb create(Context context)
    {
        DaoConfig daoconfig = new DaoConfig();
        daoconfig.setContext(context);
        return getInstance(daoconfig);
    }

    public static FinalDb create(Context context, String s)
    {
        DaoConfig daoconfig = new DaoConfig();
        daoconfig.setContext(context);
        daoconfig.setDbName(s);
        return getInstance(daoconfig);
    }

    public static FinalDb create(Context context, String s, boolean flag)
    {
        DaoConfig daoconfig = new DaoConfig();
        daoconfig.setContext(context);
        daoconfig.setDbName(s);
        daoconfig.setDebug(flag);
        return getInstance(daoconfig);
    }

    public static FinalDb create(Context context, String s, boolean flag, int i, DbUpdateListener dbupdatelistener)
    {
        DaoConfig daoconfig = new DaoConfig();
        daoconfig.setContext(context);
        daoconfig.setDbName(s);
        daoconfig.setDebug(flag);
        daoconfig.setDbVersion(i);
        daoconfig.setDbUpdateListener(dbupdatelistener);
        return getInstance(daoconfig);
    }

    public static FinalDb create(Context context, boolean flag)
    {
        DaoConfig daoconfig = new DaoConfig();
        daoconfig.setContext(context);
        daoconfig.setDebug(flag);
        return getInstance(daoconfig);
    }

    public static FinalDb create(DaoConfig daoconfig)
    {
        return getInstance(daoconfig);
    }

    private void debugSql(String s)
    {
        if (config != null && config.isDebug())
        {
            Log.d("Debug SQL", (new StringBuilder(">>>>>>  ")).append(s).toString());
        }
    }

    private void exeSqlInfo(SqlInfo sqlinfo)
    {
        if (sqlinfo != null)
        {
            debugSql(sqlinfo.getSql());
            db.execSQL(sqlinfo.getSql(), sqlinfo.getBindArgsAsArray());
            return;
        } else
        {
            Log.e("FinalDb", "sava error:sqlInfo is null");
            return;
        }
    }

    private List findAllBySql(Class class1, String s)
    {
        checkTableExist(class1);
        debugSql(s);
        s = db.rawQuery(s, null);
        ArrayList arraylist = new ArrayList();
_L1:
        boolean flag = s.moveToNext();
        if (!flag)
        {
            if (s != null)
            {
                s.close();
            }
            return arraylist;
        }
        arraylist.add(CursorUtils.getEntity(s, class1));
          goto _L1
        class1;
        class1.printStackTrace();
        if (s != null)
        {
            s.close();
        }
        return null;
        class1;
        if (s != null)
        {
            s.close();
        }
        throw class1;
    }

    private static FinalDb getInstance(DaoConfig daoconfig)
    {
        net/tsz/afinal/FinalDb;
        JVM INSTR monitorenter ;
        FinalDb finaldb1 = (FinalDb)daoMap.get(daoconfig.getDbName());
        FinalDb finaldb;
        finaldb = finaldb1;
        if (finaldb1 != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        finaldb = new FinalDb(daoconfig);
        daoMap.put(daoconfig.getDbName(), finaldb);
        net/tsz/afinal/FinalDb;
        JVM INSTR monitorexit ;
        return finaldb;
        daoconfig;
        throw daoconfig;
    }

    private void insertContentValues(List list, ContentValues contentvalues)
    {
        if (list != null && contentvalues != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    return;
                }
                KeyValue keyvalue = (KeyValue)list.next();
                contentvalues.put(keyvalue.getKey(), keyvalue.getValue().toString());
            } while (true);
        } else
        {
            Log.w("FinalDb", "insertContentValues: List<KeyValue> is empty or ContentValues is empty!");
            return;
        }
    }

    private boolean tableIsExist(TableInfo tableinfo)
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor2;
        Object obj;
        if (tableinfo.isCheckDatabese())
        {
            return true;
        }
        obj = null;
        cursor2 = null;
        cursor1 = cursor2;
        cursor = obj;
        String s = (new StringBuilder("SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name ='")).append(tableinfo.getTableName()).append("' ").toString();
        cursor1 = cursor2;
        cursor = obj;
        debugSql(s);
        cursor1 = cursor2;
        cursor = obj;
        cursor2 = db.rawQuery(s, null);
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor1 = cursor2;
        cursor = cursor2;
        if (!cursor2.moveToNext()) goto _L2; else goto _L3
_L3:
        cursor1 = cursor2;
        cursor = cursor2;
        if (cursor2.getInt(0) <= 0) goto _L2; else goto _L4
_L4:
        cursor1 = cursor2;
        cursor = cursor2;
        tableinfo.setCheckDatabese(true);
        if (cursor2 != null)
        {
            cursor2.close();
        }
        return true;
        tableinfo;
        cursor = cursor1;
        tableinfo.printStackTrace();
        if (cursor1 != null)
        {
            cursor1.close();
        }
_L6:
        return false;
        tableinfo;
        if (cursor != null)
        {
            cursor.close();
        }
        throw tableinfo;
_L2:
        if (cursor2 != null)
        {
            cursor2.close();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void delete(Object obj)
    {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.buildDeleteSql(obj));
    }

    public void deleteById(Class class1, Object obj)
    {
        checkTableExist(class1);
        exeSqlInfo(SqlBuilder.buildDeleteSql(class1, obj));
    }

    public void deleteByWhere(Class class1, String s)
    {
        checkTableExist(class1);
        class1 = SqlBuilder.buildDeleteSql(class1, s);
        debugSql(class1);
        db.execSQL(class1);
    }

    public List findAll(Class class1)
    {
        checkTableExist(class1);
        return findAllBySql(class1, SqlBuilder.getSelectSQL(class1));
    }

    public List findAll(Class class1, String s)
    {
        checkTableExist(class1);
        return findAllBySql(class1, (new StringBuilder(String.valueOf(SqlBuilder.getSelectSQL(class1)))).append(" ORDER BY ").append(s).append(" DESC").toString());
    }

    public List findAllByWhere(Class class1, String s)
    {
        checkTableExist(class1);
        return findAllBySql(class1, SqlBuilder.getSelectSQLByWhere(class1, s));
    }

    public List findAllByWhere(Class class1, String s, String s1)
    {
        checkTableExist(class1);
        return findAllBySql(class1, (new StringBuilder(String.valueOf(SqlBuilder.getSelectSQLByWhere(class1, s)))).append(" ORDER BY '").append(s1).append("' DESC").toString());
    }

    public Object findById(Object obj, Class class1)
    {
        checkTableExist(class1);
        obj = SqlBuilder.getSelectSqlAsSqlInfo(class1, obj);
        if (obj == null) goto _L2; else goto _L1
_L1:
        debugSql(((SqlInfo) (obj)).getSql());
        obj = db.rawQuery(((SqlInfo) (obj)).getSql(), ((SqlInfo) (obj)).getBindArgsAsStringArray());
        if (!((Cursor) (obj)).moveToNext()) goto _L4; else goto _L3
_L3:
        class1 = ((Class) (CursorUtils.getEntity(((Cursor) (obj)), class1)));
        ((Cursor) (obj)).close();
        return class1;
        class1;
        class1.printStackTrace();
        ((Cursor) (obj)).close();
_L2:
        return null;
        class1;
        ((Cursor) (obj)).close();
        throw class1;
_L4:
        ((Cursor) (obj)).close();
        if (true) goto _L2; else goto _L5
_L5:
    }

    public DbModel findDbModelBySQL(String s)
    {
        debugSql(s);
        s = db.rawQuery(s, null);
        DbModel dbmodel;
        if (!s.moveToNext())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        dbmodel = CursorUtils.getDbModel(s);
        s.close();
        return dbmodel;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        s.close();
        return null;
        obj;
        s.close();
        throw obj;
        s.close();
        return null;
    }

    public List findDbModelListBySQL(String s)
    {
        ArrayList arraylist;
        debugSql(s);
        s = db.rawQuery(s, null);
        arraylist = new ArrayList();
_L1:
        boolean flag = s.moveToNext();
        if (!flag)
        {
            s.close();
            return arraylist;
        }
        arraylist.add(CursorUtils.getDbModel(s));
          goto _L1
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        s.close();
        return arraylist;
        Exception exception;
        exception;
        s.close();
        throw exception;
    }

    public Object findWithManyToOneById(Object obj, Class class1)
    {
        Object obj1;
        DbModel dbmodel;
        checkTableExist(class1);
        obj = SqlBuilder.getSelectSQL(class1, obj);
        debugSql(((String) (obj)));
        dbmodel = findDbModelBySQL(((String) (obj)));
        if (dbmodel == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj1 = CursorUtils.dbModel2Entity(dbmodel, class1);
        obj = obj1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = TableInfo.get(class1).manyToOneMap.values().iterator();
_L2:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                return obj1;
            }
            Object obj2;
            try
            {
                class1 = (ManyToOne)((Iterator) (obj)).next();
                obj2 = dbmodel.get(class1.getColumn());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return obj1;
            }
        } while (obj2 == null);
        obj2 = findById(Integer.valueOf(obj2.toString()), class1.getDataType());
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        class1.setValue(obj1, obj2);
          goto _L2
        obj = null;
        return obj;
    }

    public transient Object findWithManyToOneById(Object obj, Class class1, Class aclass[])
    {
        DbModel dbmodel;
        checkTableExist(class1);
        obj = SqlBuilder.getSelectSQL(class1, obj);
        debugSql(((String) (obj)));
        dbmodel = findDbModelBySQL(((String) (obj)));
        if (dbmodel == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = CursorUtils.dbModel2Entity(dbmodel, class1);
        obj = obj1;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj = TableInfo.get(class1).manyToOneMap.values().iterator();
_L7:
        int i;
        boolean flag;
        int j;
        if (!((Iterator) (obj)).hasNext())
        {
            return obj1;
        }
        Object obj2;
        try
        {
            class1 = (ManyToOne)((Iterator) (obj)).next();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return obj1;
        }
        flag = false;
        j = aclass.length;
        i = 0;
          goto _L5
_L9:
        if (i == 0) goto _L7; else goto _L6
_L6:
        obj2 = findById(dbmodel.get(class1.getColumn()), class1.getDataType());
        if (obj2 == null) goto _L7; else goto _L8
_L8:
        class1.setValue(obj1, obj2);
          goto _L7
_L11:
        Class class2 = aclass[i];
        Class class3 = class1.getManyClass();
        if (class3 == class2)
        {
            i = 1;
        } else
        {
            i++;
            continue; /* Loop/switch isn't completed */
        }
          goto _L9
_L2:
        obj = null;
_L4:
        return obj;
_L5:
        if (i < j) goto _L11; else goto _L10
_L10:
        i = ((flag) ? 1 : 0);
          goto _L9
    }

    public Object findWithOneToManyById(Object obj, Class class1)
    {
        Object obj1;
        Object obj2;
        checkTableExist(class1);
        obj1 = SqlBuilder.getSelectSQL(class1, obj);
        debugSql(((String) (obj1)));
        obj1 = findDbModelBySQL(((String) (obj1)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj2 = CursorUtils.dbModel2Entity(((DbModel) (obj1)), class1);
        obj1 = obj2;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        class1 = TableInfo.get(class1).oneToManyMap.values().iterator();
_L1:
        do
        {
            if (!class1.hasNext())
            {
                return obj2;
            }
            List list;
            try
            {
                obj1 = (OneToMany)class1.next();
                list = findAllByWhere(((OneToMany) (obj1)).getOneClass(), (new StringBuilder(String.valueOf(((OneToMany) (obj1)).getColumn()))).append("=").append(obj).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return obj2;
            }
        } while (list == null);
        ((OneToMany) (obj1)).setValue(obj2, list);
          goto _L1
        obj1 = null;
        return obj1;
    }

    public transient Object findWithOneToManyById(Object obj, Class class1, Class aclass[])
    {
        Object obj1;
        checkTableExist(class1);
        obj1 = SqlBuilder.getSelectSQL(class1, obj);
        debugSql(((String) (obj1)));
        obj1 = findDbModelBySQL(((String) (obj1)));
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        Object obj2;
        obj2 = CursorUtils.dbModel2Entity(((DbModel) (obj1)), class1);
        obj1 = obj2;
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        class1 = TableInfo.get(class1).oneToManyMap.values().iterator();
_L7:
        int i;
        boolean flag;
        int j;
        if (!class1.hasNext())
        {
            return obj2;
        }
        List list;
        try
        {
            obj1 = (OneToMany)class1.next();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return obj2;
        }
        flag = false;
        j = aclass.length;
        i = 0;
          goto _L5
_L9:
        if (i == 0) goto _L7; else goto _L6
_L6:
        list = findAllByWhere(((OneToMany) (obj1)).getOneClass(), (new StringBuilder(String.valueOf(((OneToMany) (obj1)).getColumn()))).append("=").append(obj).toString());
        if (list == null) goto _L7; else goto _L8
_L8:
        ((OneToMany) (obj1)).setValue(obj2, list);
          goto _L7
_L11:
        Class class2 = aclass[i];
        boolean flag1 = ((OneToMany) (obj1)).getOneClass().equals(class2.getName());
        if (flag1)
        {
            i = 1;
        } else
        {
            i++;
            continue; /* Loop/switch isn't completed */
        }
          goto _L9
_L2:
        obj1 = null;
_L4:
        return obj1;
_L5:
        if (i < j) goto _L11; else goto _L10
_L10:
        i = ((flag) ? 1 : 0);
          goto _L9
    }

    public void save(Object obj)
    {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.buildInsertSql(obj));
    }

    public boolean saveBindId(Object obj)
    {
        TableInfo tableinfo;
        Object obj1;
label0:
        {
            checkTableExist(obj.getClass());
            obj1 = SqlBuilder.getSaveKeyValueListByEntity(obj);
            if (obj1 != null && ((List) (obj1)).size() > 0)
            {
                tableinfo = TableInfo.get(obj.getClass());
                ContentValues contentvalues = new ContentValues();
                insertContentValues(((List) (obj1)), contentvalues);
                obj1 = Long.valueOf(db.insert(tableinfo.getTableName(), null, contentvalues));
                if (((Long) (obj1)).longValue() != -1L)
                {
                    break label0;
                }
            }
            return false;
        }
        tableinfo.getId().setValue(obj, obj1);
        return true;
    }

    public void update(Object obj)
    {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(obj));
    }

    public void update(Object obj, String s)
    {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(obj, s));
    }

}
