// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.SQLTable;
import com.amazon.identity.auth.device.utils.DBHelpers;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LambortishClock, AccountTransaction, AccountInfo, DatabaseValue

public class LocalDataStorage
{
    private static final class GetDataOptions extends Enum
    {

        private static final GetDataOptions $VALUES[];
        public static final GetDataOptions Deleted;
        public static final GetDataOptions DirtyOnly;
        public static final GetDataOptions NotDeleted;
        public static final GetDataOptions NotDirtyOnly;

        public static GetDataOptions valueOf(String s)
        {
            return (GetDataOptions)Enum.valueOf(com/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions, s);
        }

        public static GetDataOptions[] values()
        {
            return (GetDataOptions[])$VALUES.clone();
        }

        static 
        {
            DirtyOnly = new GetDataOptions("DirtyOnly", 0);
            NotDirtyOnly = new GetDataOptions("NotDirtyOnly", 1);
            Deleted = new GetDataOptions("Deleted", 2);
            NotDeleted = new GetDataOptions("NotDeleted", 3);
            $VALUES = (new GetDataOptions[] {
                DirtyOnly, NotDirtyOnly, Deleted, NotDeleted
            });
        }

        private GetDataOptions(String s, int i)
        {
            super(s, i);
        }
    }

    static class LocalDataStorageDBHelper extends SQLiteOpenHelper
    {

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            MAPLog.i(LocalDataStorage.TAG, "Creating Local DataStore");
            sqlitedatabase.execSQL((new SQLTable("accounts")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("directed_id", "TEXT UNIQUE NOT NULL").addColumn("display_name", "TEXT UNIQUE").addColumn("account_timestamp", "INTEGER NOT NULL").addColumn("account_deleted", "INTEGER NOT NULL").addColumn("account_dirty", "INTEGER NOT NULL").toString());
            sqlitedatabase.execSQL((new SQLTable("userdata")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("userdata_account_id", "TEXT NOT NULL").addColumn("userdata_key", "TEXT NOT NULL").addColumn("userdata_value", "TEXT").addColumn("userdata_timestamp", "INTEGER NOT NULL").addColumn("userdata_deleted", "INTEGER NOT NULL").addColumn("userdata_dirty", "INTEGER NOT NULL").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
                "userdata_account_id", "userdata_key"
            })).toString());
            sqlitedatabase.execSQL((new SQLTable("tokens")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("token_account_id", "TEXT NOT NULL").addColumn("token_key", "TEXT NOT NULL").addColumn("token_value", "TEXT").addColumn("token_timestamp", "INTEGER NOT NULL").addColumn("token_deleted", "INTEGER NOT NULL").addColumn("token_dirty", "INTEGER NOT NULL").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
                "token_account_id", "token_key"
            })).toString());
            sqlitedatabase.execSQL((new SQLTable("device_data")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("device_data_namespace", "TEXT NOT NULL").addColumn("device_data_key", "TEXT NOT NULL").addColumn("device_data_value", "TEXT").addColumn("device_data_timestamp", "INTEGER NOT NULL").addColumn("device_data_deleted", "INTEGER NOT NULL").addColumn("device_data_dirty", "INTEGER NOT NULL").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
                "device_data_namespace", "device_data_key"
            })).toString());
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            super.onOpen(sqlitedatabase);
            if (!sqlitedatabase.isReadOnly())
            {
                sqlitedatabase.execSQL("PRAGMA foreign_keys=ON;");
            }
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            throw new IllegalStateException(String.format("Cannot upgrade from version %d to %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            }));
        }

        public LocalDataStorageDBHelper(Context context, String s, int i)
        {
            super(context, (new StringBuilder()).append(s).append(".db").toString(), null, i);
        }
    }


    static final String COLUMN_ACCOUNT_DELETED = "account_deleted";
    static final String COLUMN_ACCOUNT_DIRTY = "account_dirty";
    static final String COLUMN_ACCOUNT_TIMESTAMP = "account_timestamp";
    static final String COLUMN_DEVICE_DATA_DELETED = "device_data_deleted";
    static final String COLUMN_DEVICE_DATA_DIRTY = "device_data_dirty";
    static final String COLUMN_DEVICE_DATA_KEY = "device_data_key";
    static final String COLUMN_DEVICE_DATA_NAMESPACE = "device_data_namespace";
    static final String COLUMN_DEVICE_DATA_TIMESTAMP = "device_data_timestamp";
    static final String COLUMN_DEVICE_DATA_VALUE = "device_data_value";
    static final String COLUMN_DIRECTED_ID = "directed_id";
    static final String COLUMN_DISPLAY_NAME = "display_name";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_TOKEN_ACCOUNT_ID = "token_account_id";
    static final String COLUMN_TOKEN_DELETED = "token_deleted";
    static final String COLUMN_TOKEN_DIRTY = "token_dirty";
    static final String COLUMN_TOKEN_KEY = "token_key";
    static final String COLUMN_TOKEN_TIMESTAMP = "token_timestamp";
    static final String COLUMN_TOKEN_VALUE = "token_value";
    static final String COLUMN_USER_DATA_ACCOUNT_ID = "userdata_account_id";
    static final String COLUMN_USER_DATA_DELETED = "userdata_deleted";
    static final String COLUMN_USER_DATA_DIRTY = "userdata_dirty";
    static final String COLUMN_USER_DATA_KEY = "userdata_key";
    static final String COLUMN_USER_DATA_TIMESTAMP = "userdata_timestamp";
    static final String COLUMN_USER_DATA_VALUE = "userdata_value";
    static final String LOCAL_DATA_STORAGE_DB_NAME = "map_data_storage";
    static final int LOCAL_DATA_STORAGE_DB_VERSION = 1;
    static final String TABLE_ACCOUNTS = "accounts";
    static final String TABLE_DEVICE_DATA = "device_data";
    static final String TABLE_TOKENS = "tokens";
    static final String TABLE_USER_DATA = "userdata";
    private static final String TAG = com/amazon/identity/auth/device/storage/LocalDataStorage.getName();
    private static LocalDataStorage sLocalDataStorage;
    private Map mAccountInfos;
    private final Context mContext;
    private Map mDeviceData;
    private final LambortishClock mLambortishClock;
    private final LocalDataStorageDBHelper mLocalDataStorageHelper;

    LocalDataStorage(Context context)
    {
        mContext = context;
        mLocalDataStorageHelper = new LocalDataStorageDBHelper(context, "map_data_storage", 1);
        mLambortishClock = LambortishClock.getInstance(mContext);
    }

    private boolean addAccount(SQLiteDatabase sqlitedatabase, String s, AccountTransaction accounttransaction, Date date, boolean flag)
    {
        if (!TextUtils.isEmpty(s) && date != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("directed_id", accounttransaction.getDirectedId());
        contentvalues.put("display_name", s);
        contentvalues.put("account_timestamp", Long.valueOf(date.getTime()));
        contentvalues.put("account_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag)));
        contentvalues.put("account_deleted", Integer.valueOf(0));
        boolean flag1;
        if (flag)
        {
            flag1 = DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "accounts", contentvalues, String.format("%s = ? and %s < ?", new Object[] {
                "directed_id", "account_timestamp"
            }), new String[] {
                accounttransaction.getDirectedId(), Long.toString(date.getTime())
            });
        } else
        {
            flag1 = DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "accounts", contentvalues, String.format("%s = ? and %s < ? and %s = 1", new Object[] {
                "directed_id", "account_timestamp", "account_deleted"
            }), new String[] {
                accounttransaction.getDirectedId(), Long.toString(date.getTime())
            });
        }
        if (flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        MAPLog.e(TAG, "Failed to add account");
        sqlitedatabase = null;
_L5:
        if (sqlitedatabase != null)
        {
            if (mAccountInfos != null)
            {
                mAccountInfos.put(accounttransaction.getDirectedId(), sqlitedatabase);
            }
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Map map;
        Object obj;
        map = getUserdata(sqlitedatabase, accounttransaction.getDirectedId(), date);
        obj = accounttransaction.getUserData().entrySet().iterator();
_L6:
        Object obj1;
        Object obj2;
label0:
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_372;
            }
            obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            obj2 = insertUserdata(sqlitedatabase, accounttransaction.getDirectedId(), (String)((java.util.Map.Entry) (obj1)).getKey(), (String)((java.util.Map.Entry) (obj1)).getValue(), false, date, flag);
            if (obj2 != null)
            {
                break label0;
            }
            MAPLog.e(TAG, "Failed to save account because saving userdata was unsuccessful");
            sqlitedatabase = null;
        }
          goto _L5
        map.put(((java.util.Map.Entry) (obj1)).getKey(), obj2);
          goto _L6
        obj = getTokens(sqlitedatabase, accounttransaction.getDirectedId(), date);
        obj1 = accounttransaction.getTokens().entrySet().iterator();
_L7:
        DatabaseValue databasevalue;
label1:
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_497;
            }
            obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
            databasevalue = setTokenInDb(sqlitedatabase, accounttransaction.getDirectedId(), (String)((java.util.Map.Entry) (obj2)).getKey(), (String)((java.util.Map.Entry) (obj2)).getValue(), date, flag);
            if (databasevalue != null)
            {
                break label1;
            }
            MAPLog.e(TAG, "Failed to save account because saving token was unsuccessful");
            sqlitedatabase = null;
        }
          goto _L5
        ((Map) (obj)).put(((java.util.Map.Entry) (obj2)).getKey(), databasevalue);
          goto _L7
        sqlitedatabase = new AccountInfo(accounttransaction.getDirectedId(), s, map, ((Map) (obj)));
        boolean flag2;
        if (!flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        sqlitedatabase = new DatabaseValue(sqlitedatabase, date, flag2, false);
          goto _L5
    }

    private void addToProjection(Map map, String s, String s1, String s2)
    {
        map.put(s2, DBHelpers.getAliasColumnName(s, s1, s2));
    }

    public static void cleanDb(Context context)
    {
        if (context == null)
        {
            return;
        } else
        {
            context.deleteDatabase("map_data_storage.db");
            return;
        }
    }

    private void commonToData(Map map, DatabaseValue databasevalue)
    {
        map.put("timestamp_key", TimeUtil.serialize(databasevalue.getDateTime()));
        map.put("dirty_key", Boolean.toString(databasevalue.isDirty()));
        map.put("deleted_key", Boolean.toString(databasevalue.isDeleted()));
    }

    private boolean expireToken(SQLiteDatabase sqlitedatabase, String s, String s1, Date date, boolean flag)
    {
        Object obj = null;
        boolean flag3 = false;
        if (s == null || s1 == null || date == null)
        {
            flag = false;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("token_account_id", s);
            contentvalues.put("token_key", s1);
            contentvalues.putNull("token_value");
            contentvalues.put("token_timestamp", Long.valueOf(date.getTime()));
            contentvalues.put("token_deleted", Integer.valueOf(1));
            contentvalues.put("token_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag)));
            String s2 = String.format("%s = ? and %s = ? and %s < ? and %s = 0", new Object[] {
                "token_account_id", "token_key", "token_timestamp", "token_deleted"
            });
            String as[] = new String[3];
            as[0] = s;
            as[1] = s1;
            as[2] = Long.toString(date.getTime());
            boolean flag1;
            if (flag)
            {
                flag1 = DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "tokens", contentvalues, s2, as);
            } else
            if (sqlitedatabase.update("tokens", contentvalues, s2, as) > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                sqlitedatabase = obj;
            } else
            {
                boolean flag2 = flag3;
                if (!flag)
                {
                    flag2 = true;
                }
                sqlitedatabase = new DatabaseValue(null, date, flag2, true);
            }
            if (sqlitedatabase != null)
            {
                s = getLocalAccountInfo(s);
                if (s != null)
                {
                    ((AccountInfo)s.getValue()).tokens.put(s1, sqlitedatabase);
                }
                return true;
            }
        }
        return flag;
    }

    private DatabaseValue getAccountInfo(String s)
    {
        return (DatabaseValue)getAccountInfos().get(s);
    }

    private Map getAccountInfos()
    {
        if (mAccountInfos == null)
        {
            mAccountInfos = populateAccountInfo();
        }
        return mAccountInfos;
    }

    private Collection getAllData(Date date, EnumSet enumset)
    {
        LinkedList linkedlist = new LinkedList();
        for (Iterator iterator = getAccountInfos().entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (DatabaseValue)((java.util.Map.Entry)iterator.next()).getValue();
            AccountInfo accountinfo = (AccountInfo)((DatabaseValue) (obj)).getValue();
            if (includeDatabaseValue(enumset, date, ((DatabaseValue) (obj))))
            {
                HashMap hashmap = new HashMap();
                hashmap.put("directedId", ((AccountInfo)((DatabaseValue) (obj)).getValue()).directedId);
                hashmap.put("display_name", ((AccountInfo)((DatabaseValue) (obj)).getValue()).displayName);
                commonToData(hashmap, ((DatabaseValue) (obj)));
                linkedlist.add(hashmap);
            }
            obj = accountinfo.userdata.entrySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                if (includeDatabaseValue(enumset, date, (DatabaseValue)((java.util.Map.Entry) (obj1)).getValue()))
                {
                    String s = accountinfo.directedId;
                    String s3 = (String)((java.util.Map.Entry) (obj1)).getKey();
                    obj1 = (DatabaseValue)((java.util.Map.Entry) (obj1)).getValue();
                    HashMap hashmap1 = new HashMap();
                    hashmap1.put("userdata_account", s);
                    hashmap1.put("userdata_key", s3);
                    hashmap1.put("userdata_value", ((DatabaseValue) (obj1)).getValue());
                    commonToData(hashmap1, ((DatabaseValue) (obj1)));
                    linkedlist.add(hashmap1);
                }
            } while (true);
            obj = accountinfo.tokens.entrySet().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Object obj2 = (java.util.Map.Entry)((Iterator) (obj)).next();
                if (includeDatabaseValue(enumset, date, (DatabaseValue)((java.util.Map.Entry) (obj2)).getValue()))
                {
                    String s1 = accountinfo.directedId;
                    String s4 = (String)((java.util.Map.Entry) (obj2)).getKey();
                    obj2 = (DatabaseValue)((java.util.Map.Entry) (obj2)).getValue();
                    HashMap hashmap2 = new HashMap();
                    hashmap2.put("token_account", s1);
                    hashmap2.put("token_key", s4);
                    hashmap2.put("token_value", ((DatabaseValue) (obj2)).getValue());
                    commonToData(hashmap2, ((DatabaseValue) (obj2)));
                    linkedlist.add(hashmap2);
                }
            }
        }

        for (Iterator iterator1 = getDeviceData().entrySet().iterator(); iterator1.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
            Iterator iterator2 = ((Map)entry.getValue()).entrySet().iterator();
            while (iterator2.hasNext()) 
            {
                Object obj3 = (java.util.Map.Entry)iterator2.next();
                if (includeDatabaseValue(enumset, date, (DatabaseValue)((java.util.Map.Entry) (obj3)).getValue()))
                {
                    String s2 = (String)entry.getKey();
                    String s5 = (String)((java.util.Map.Entry) (obj3)).getKey();
                    obj3 = (DatabaseValue)((java.util.Map.Entry) (obj3)).getValue();
                    HashMap hashmap3 = new HashMap();
                    hashmap3.put("namespace", s2);
                    hashmap3.put("device_data_key", s5);
                    hashmap3.put("device_data_value", ((DatabaseValue) (obj3)).getValue());
                    commonToData(hashmap3, ((DatabaseValue) (obj3)));
                    linkedlist.add(hashmap3);
                }
            }
        }

        return Collections.unmodifiableCollection(linkedlist);
    }

    private Map getDeviceData()
    {
        if (mDeviceData == null)
        {
            mDeviceData = populateDeviceData();
        }
        return mDeviceData;
    }

    public static LocalDataStorage getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/LocalDataStorage;
        JVM INSTR monitorenter ;
        if (sLocalDataStorage == null)
        {
            sLocalDataStorage = new LocalDataStorage(context.getApplicationContext());
        }
        context = sLocalDataStorage;
        com/amazon/identity/auth/device/storage/LocalDataStorage;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private DatabaseValue getLocalAccountInfo(String s)
    {
        if (mAccountInfos == null)
        {
            return null;
        } else
        {
            return (DatabaseValue)mAccountInfos.get(s);
        }
    }

    private Map getTokens(SQLiteDatabase sqlitedatabase, String s, Date date)
    {
        SQLiteDatabase sqlitedatabase1;
        Object obj;
        HashMap hashmap;
        hashmap = new HashMap();
        obj = null;
        sqlitedatabase1 = obj;
        String s1 = String.format("%s = ? and %s >= ? and %s = 0", new Object[] {
            "token_account_id", "token_timestamp", "token_deleted"
        });
        sqlitedatabase1 = obj;
        date = Long.toString(date.getTime());
        sqlitedatabase1 = obj;
        sqlitedatabase = sqlitedatabase.query("tokens", new String[] {
            "token_account_id", "token_key", "token_value", "token_timestamp", "token_deleted", "token_dirty"
        }, s1, new String[] {
            s, date
        }, null, null, null);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        sqlitedatabase1 = sqlitedatabase;
        boolean flag = sqlitedatabase.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        DBHelpers.closeCursor(sqlitedatabase);
        return hashmap;
_L2:
        sqlitedatabase1 = sqlitedatabase;
        parseTokens(sqlitedatabase, hashmap);
        sqlitedatabase1 = sqlitedatabase;
        flag = sqlitedatabase.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
        DBHelpers.closeCursor(sqlitedatabase);
        return hashmap;
        sqlitedatabase;
        DBHelpers.closeCursor(sqlitedatabase1);
        throw sqlitedatabase;
    }

    private Map getUserdata(SQLiteDatabase sqlitedatabase, String s, Date date)
    {
        SQLiteDatabase sqlitedatabase1;
        Object obj;
        HashMap hashmap;
        hashmap = new HashMap();
        obj = null;
        sqlitedatabase1 = obj;
        String s1 = String.format("%s = ? and %s >= ? and %s = 0", new Object[] {
            "userdata_account_id", "userdata_timestamp", "userdata_deleted"
        });
        sqlitedatabase1 = obj;
        date = Long.toString(date.getTime());
        sqlitedatabase1 = obj;
        sqlitedatabase = sqlitedatabase.query("userdata", new String[] {
            "userdata_account_id", "userdata_key", "userdata_value", "userdata_timestamp", "userdata_deleted", "userdata_dirty"
        }, s1, new String[] {
            s, date
        }, null, null, null);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        sqlitedatabase1 = sqlitedatabase;
        boolean flag = sqlitedatabase.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        DBHelpers.closeCursor(sqlitedatabase);
        return hashmap;
_L2:
        sqlitedatabase1 = sqlitedatabase;
        parseUserdata(sqlitedatabase, hashmap);
        sqlitedatabase1 = sqlitedatabase;
        flag = sqlitedatabase.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
        DBHelpers.closeCursor(sqlitedatabase);
        return hashmap;
        sqlitedatabase;
        DBHelpers.closeCursor(sqlitedatabase1);
        throw sqlitedatabase;
    }

    private boolean hasAccount(SQLiteDatabase sqlitedatabase, String s)
    {
        if (mAccountInfos == null)
        {
            mAccountInfos = populateAccountInfo(sqlitedatabase);
        }
        sqlitedatabase = (DatabaseValue)mAccountInfos.get(s);
        return sqlitedatabase != null && !sqlitedatabase.isDeleted();
    }

    private boolean includeDatabaseValue(EnumSet enumset, Date date, DatabaseValue databasevalue)
    {
        boolean flag;
        if (enumset.contains(GetDataOptions.DirtyOnly) && !databasevalue.isDirty())
        {
            flag = false;
        } else
        if (enumset.contains(GetDataOptions.NotDirtyOnly) && databasevalue.isDirty())
        {
            flag = false;
        } else
        if (enumset.contains(GetDataOptions.Deleted) && !databasevalue.isDeleted())
        {
            flag = false;
        } else
        if (enumset.contains(GetDataOptions.NotDeleted) && databasevalue.isDeleted())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        do
        {
            if (flag)
            {
                if (date == null)
                {
                    flag = true;
                } else
                if (!databasevalue.isAfter(date))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    return true;
                }
            }
            return false;
        } while (true);
    }

    private void insertTokenNotDirty(SQLiteDatabase sqlitedatabase, String s, String s1, Date date)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("token_dirty", Integer.valueOf(0));
        sqlitedatabase.update("tokens", contentvalues, String.format("%s = ? and %s = ? and %s = ? and %s = 0 and %s = 1", new Object[] {
            "token_account_id", "token_key", "token_timestamp", "token_deleted", "token_dirty"
        }), new String[] {
            s, s1, Long.toString(date.getTime())
        });
    }

    private DatabaseValue insertUserdata(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, boolean flag, Date date, boolean flag1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("userdata_account_id", s);
        contentvalues.put("userdata_key", s1);
        contentvalues.put("userdata_value", s2);
        contentvalues.put("userdata_timestamp", Long.valueOf(date.getTime()));
        contentvalues.put("userdata_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag1)));
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("userdata_deleted", Integer.valueOf(i));
        if (!DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "userdata", contentvalues, String.format("%s = ? and %s = ? and %s < ?", new Object[] {
    "userdata_account_id", "userdata_key", "userdata_timestamp"
}), new String[] {
    s, s1, Long.toString(date.getTime())
}))
        {
            return null;
        }
        if (!flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return new DatabaseValue(s2, date, flag1, flag);
    }

    private void insertUserdataNotDirty(SQLiteDatabase sqlitedatabase, String s, String s1, Date date)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("userdata_dirty", Integer.valueOf(0));
        sqlitedatabase.update("userdata", contentvalues, String.format("%s = ? and %s = ? and %s = ? and %s = 1", new Object[] {
            "userdata_account_id", "userdata_key", "userdata_timestamp", "userdata_dirty"
        }), new String[] {
            s, s1, Long.toString(date.getTime())
        });
    }

    private boolean isAccountDataRow(Map map)
    {
        return map.get("directedId") != null;
    }

    private boolean isAccountKnowInvalid(SQLiteDatabase sqlitedatabase, String s, Date date)
    {
        return DBHelpers.querySingleResult(sqlitedatabase, "accounts", "directed_id", String.format("%s = ? and %s > ?", new Object[] {
            "directed_id", "account_timestamp"
        }), new String[] {
            s, Long.toString(date.getTime())
        }) != null;
    }

    private boolean isDeviceDataDataRow(Map map)
    {
        return map.get("namespace") != null;
    }

    private int isSyncSetToDirtyBit(boolean flag)
    {
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return !flag1 ? 0 : 1;
    }

    private boolean isTokenDataRow(Map map)
    {
        return map.get("token_account") != null;
    }

    private boolean isUserdataDataRow(Map map)
    {
        return map.get("userdata_account") != null;
    }

    private void locallyRemoveAccounts(String s, Date date, boolean flag)
    {
        Object obj;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = getLocalAccountInfo(s);
        if (obj != null)
        {
            AccountInfo accountinfo = new AccountInfo(((AccountInfo)((DatabaseValue) (obj)).getValue()).directedId, null);
            DatabaseValue databasevalue = new DatabaseValue(accountinfo, date, flag, true);
            java.util.Map.Entry entry1;
            for (Iterator iterator = ((AccountInfo)((DatabaseValue) (obj)).getValue()).userdata.entrySet().iterator(); iterator.hasNext(); accountinfo.userdata.put(entry1.getKey(), new DatabaseValue(null, date, flag, true)))
            {
                entry1 = (java.util.Map.Entry)iterator.next();
            }

            java.util.Map.Entry entry;
            for (obj = ((AccountInfo)((DatabaseValue) (obj)).getValue()).tokens.entrySet().iterator(); ((Iterator) (obj)).hasNext(); accountinfo.tokens.put(entry.getKey(), new DatabaseValue(null, date, flag, true)))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

            getAccountInfos().put(s, databasevalue);
        }
    }

    private void parseTokens(Cursor cursor, Map map)
    {
        String s = DBHelpers.getString(cursor, "token_key");
        if (s == null)
        {
            return;
        } else
        {
            map.put(s, new DatabaseValue(DBHelpers.getString(cursor, "token_value"), DBHelpers.getDate(cursor, "token_timestamp"), DBHelpers.getBoolean(cursor, "token_dirty"), DBHelpers.getBoolean(cursor, "token_deleted")));
            return;
        }
    }

    private void parseUserdata(Cursor cursor, Map map)
    {
        String s = DBHelpers.getString(cursor, "userdata_key");
        if (s == null)
        {
            return;
        } else
        {
            map.put(s, new DatabaseValue(DBHelpers.getString(cursor, "userdata_value"), DBHelpers.getDate(cursor, "userdata_timestamp"), DBHelpers.getBoolean(cursor, "userdata_dirty"), DBHelpers.getBoolean(cursor, "userdata_deleted")));
            return;
        }
    }

    private Map populateAccountInfo()
    {
        Map map = populateAccountInfo(mLocalDataStorageHelper.getReadableDatabase());
        mLocalDataStorageHelper.close();
        return map;
        Exception exception;
        exception;
        mLocalDataStorageHelper.close();
        throw exception;
    }

    private Map populateAccountInfo(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        Cursor cursor1;
        HashMap hashmap;
        hashmap = new HashMap();
        cursor1 = null;
        cursor = cursor1;
        Object obj = new SQLiteQueryBuilder();
        cursor = cursor1;
        Object obj1 = new StringBuilder();
        cursor = cursor1;
        ((StringBuilder) (obj1)).append("accounts LEFT OUTER JOIN ");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append("userdata");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(" ON (");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(DBHelpers.getNamespaceColumnName("accounts", "directed_id")).append(" = ");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(DBHelpers.getNamespaceColumnName("userdata", "userdata_account_id")).append(")");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(" LEFT OUTER JOIN tokens ON (");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(DBHelpers.getNamespaceColumnName("accounts", "directed_id")).append(" = ");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(DBHelpers.getNamespaceColumnName("tokens", "token_account_id")).append(")");
        cursor = cursor1;
        ((SQLiteQueryBuilder) (obj)).setTables(((StringBuilder) (obj1)).toString());
        cursor = cursor1;
        obj1 = new HashMap();
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "accounts", "_id", "_id");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "accounts", "directed_id", "directed_id");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "accounts", "display_name", "display_name");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "accounts", "account_timestamp", "account_timestamp");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "accounts", "account_dirty", "account_dirty");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "accounts", "account_deleted", "account_deleted");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "userdata", "userdata_key", "userdata_key");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "userdata", "userdata_value", "userdata_value");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "userdata", "userdata_timestamp", "userdata_timestamp");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "userdata", "userdata_dirty", "userdata_dirty");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "userdata", "userdata_deleted", "userdata_deleted");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "tokens", "token_key", "token_key");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "tokens", "token_value", "token_value");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "tokens", "token_timestamp", "token_timestamp");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "tokens", "token_dirty", "token_dirty");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "tokens", "token_deleted", "token_deleted");
        cursor = cursor1;
        ((SQLiteQueryBuilder) (obj)).setProjectionMap(((Map) (obj1)));
        cursor = cursor1;
        cursor1 = sqlitedatabase.rawQuery(((SQLiteQueryBuilder) (obj)).buildQuery((String[])((HashMap) (obj1)).keySet().toArray(new String[0]), null, null, null, null, null, null), null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_471;
        }
        cursor = cursor1;
        boolean flag = cursor1.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_478;
        }
        DBHelpers.closeCursor(cursor1);
        return hashmap;
_L2:
        cursor = cursor1;
        obj1 = DBHelpers.getString(cursor1, "directed_id");
        cursor = cursor1;
        obj = (DatabaseValue)hashmap.get(obj1);
        sqlitedatabase = ((SQLiteDatabase) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_590;
        }
        cursor = cursor1;
        sqlitedatabase = DBHelpers.getString(cursor1, "display_name");
        cursor = cursor1;
        obj = DBHelpers.getDate(cursor1, "account_timestamp");
        cursor = cursor1;
        flag = DBHelpers.getBoolean(cursor1, "account_dirty");
        cursor = cursor1;
        boolean flag1 = DBHelpers.getBoolean(cursor1, "account_deleted");
        cursor = cursor1;
        sqlitedatabase = new DatabaseValue(new AccountInfo(((String) (obj1)), sqlitedatabase), ((Date) (obj)), flag, flag1);
        cursor = cursor1;
        hashmap.put(obj1, sqlitedatabase);
        cursor = cursor1;
        parseUserdata(cursor1, ((AccountInfo)sqlitedatabase.getValue()).userdata);
        cursor = cursor1;
        parseTokens(cursor1, ((AccountInfo)sqlitedatabase.getValue()).tokens);
        cursor = cursor1;
        if (cursor1.moveToNext()) goto _L2; else goto _L1
_L1:
        cursor = cursor1;
        sqlitedatabase = getGreatestTimestamp(hashmap);
        cursor = cursor1;
        if (!mLambortishClock.markDateSeen(sqlitedatabase))
        {
            break MISSING_BLOCK_LABEL_669;
        }
        cursor = cursor1;
        MetricsHelper.increasePeriodicCounter("LamportTimestampUpdatedBasedOnDBSnapshot", new String[0]);
        DBHelpers.closeCursor(cursor1);
        return hashmap;
        sqlitedatabase;
        DBHelpers.closeCursor(cursor);
        throw sqlitedatabase;
    }

    private Map populateDeviceData()
    {
        Cursor cursor;
        HashMap hashmap;
        hashmap = new HashMap();
        cursor = null;
        Cursor cursor1 = mLocalDataStorageHelper.getReadableDatabase().query("device_data", new String[] {
            "device_data_namespace", "device_data_key", "device_data_value", "device_data_timestamp", "device_data_dirty", "device_data_deleted"
        }, null, null, null, null, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        cursor = cursor1;
        boolean flag = cursor1.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        DBHelpers.closeCursor(cursor1);
        mLocalDataStorageHelper.close();
        return hashmap;
_L2:
        cursor = cursor1;
        String s = DBHelpers.getString(cursor1, "device_data_namespace");
        cursor = cursor1;
        Map map = (Map)hashmap.get(s);
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        cursor = cursor1;
        obj = new HashMap();
        cursor = cursor1;
        hashmap.put(s, obj);
        cursor = cursor1;
        ((Map) (obj)).put(DBHelpers.getString(cursor1, "device_data_key"), new DatabaseValue(DBHelpers.getString(cursor1, "device_data_value"), DBHelpers.getDate(cursor1, "device_data_timestamp"), DBHelpers.getBoolean(cursor1, "device_data_dirty"), DBHelpers.getBoolean(cursor1, "device_data_deleted")));
        cursor = cursor1;
        flag = cursor1.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
        DBHelpers.closeCursor(cursor1);
        mLocalDataStorageHelper.close();
        return hashmap;
        Exception exception;
        exception;
        DBHelpers.closeCursor(cursor);
        mLocalDataStorageHelper.close();
        throw exception;
    }

    private boolean removeAccount(SQLiteDatabase sqlitedatabase, String s, Date date, boolean flag)
    {
        boolean flag2;
        if (s == null || date == null)
        {
            flag2 = false;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("directed_id", s);
            contentvalues.putNull("display_name");
            contentvalues.put("account_timestamp", Long.valueOf(date.getTime()));
            contentvalues.put("account_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag)));
            contentvalues.put("account_deleted", Integer.valueOf(1));
            String s1 = String.format("%s = ? and %s < ? and %s = 0", new Object[] {
                "directed_id", "account_timestamp", "account_deleted"
            });
            String as[] = new String[2];
            as[0] = s;
            as[1] = Long.toString(date.getTime());
            boolean flag1;
            if (flag)
            {
                flag1 = DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "accounts", contentvalues, s1, as);
            } else
            if (sqlitedatabase.update("accounts", contentvalues, s1, as) > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            contentvalues = new ContentValues();
            contentvalues.putNull("userdata_value");
            contentvalues.put("userdata_timestamp", Long.valueOf(date.getTime()));
            contentvalues.put("userdata_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag)));
            contentvalues.put("userdata_deleted", Integer.valueOf(1));
            sqlitedatabase.update("userdata", contentvalues, String.format("%s = ? and %s < ? and %s = 0", new Object[] {
                "userdata_account_id", "userdata_timestamp", "userdata_deleted"
            }), new String[] {
                s, Long.toString(date.getTime())
            });
            contentvalues = new ContentValues();
            contentvalues.putNull("token_value");
            contentvalues.put("token_timestamp", Long.valueOf(date.getTime()));
            contentvalues.put("token_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag)));
            contentvalues.put("token_deleted", Integer.valueOf(1));
            sqlitedatabase.update("tokens", contentvalues, String.format("%s = ? and %s < ? and %s = 0", new Object[] {
                "token_account_id", "token_timestamp", "token_deleted"
            }), new String[] {
                s, Long.toString(date.getTime())
            });
            flag2 = flag;
            if (flag1)
            {
                locallyRemoveAccounts(s, date, flag);
                return true;
            }
        }
        return flag2;
    }

    private boolean setAllBeforeTimeNotDirtyInDb(Date date)
    {
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        setTableItemBeforeTimeNotDirty(sqlitedatabase1, "accounts", "account_timestamp", "account_dirty", date);
        sqlitedatabase = sqlitedatabase1;
        setTableItemBeforeTimeNotDirty(sqlitedatabase1, "userdata", "userdata_timestamp", "userdata_dirty", date);
        sqlitedatabase = sqlitedatabase1;
        setTableItemBeforeTimeNotDirty(sqlitedatabase1, "tokens", "token_timestamp", "token_dirty", date);
        sqlitedatabase = sqlitedatabase1;
        setTableItemBeforeTimeNotDirty(sqlitedatabase1, "device_data", "device_data_timestamp", "device_data_dirty", date);
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.endTransaction();
            mLocalDataStorageHelper.close();
        }
        return true;
        date;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.endTransaction();
            mLocalDataStorageHelper.close();
        }
        throw date;
    }

    private boolean setDeviceData(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, boolean flag, Date date, boolean flag1)
    {
        if (s == null || s1 == null || date == null)
        {
            flag1 = false;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("device_data_namespace", s);
            contentvalues.put("device_data_key", s1);
            contentvalues.put("device_data_value", s2);
            contentvalues.put("device_data_timestamp", Long.valueOf(date.getTime()));
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            contentvalues.put("device_data_deleted", Integer.valueOf(i));
            contentvalues.put("device_data_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag1)));
            if (!DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "device_data", contentvalues, String.format("%s = ? and %s = ? and %s < ?", new Object[] {
    "device_data_namespace", "device_data_key", "device_data_timestamp"
}), new String[] {
    s, s1, Long.toString(date.getTime())
}))
            {
                sqlitedatabase = null;
            } else
            {
                boolean flag2;
                if (!flag1)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                sqlitedatabase = new DatabaseValue(s2, date, flag2, flag);
            }
            if (sqlitedatabase != null)
            {
                if (mDeviceData != null)
                {
                    date = (Map)mDeviceData.get(s);
                    s2 = date;
                    if (date == null)
                    {
                        s2 = new HashMap();
                        mDeviceData.put(s, s2);
                    }
                    s2.put(s1, sqlitedatabase);
                }
                return true;
            }
        }
        return flag1;
    }

    private void setTableItemBeforeTimeNotDirty(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, Date date)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(s2, Integer.valueOf(0));
        int i = sqlitedatabase.update(s, contentvalues, String.format("%s <= ?", new Object[] {
            s1
        }), new String[] {
            Long.toString(date.getTime())
        });
        sqlitedatabase = TAG;
        String.format("Update %d items not dirty in table %s.", new Object[] {
            Integer.valueOf(i), s
        });
    }

    private boolean setToken(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, Date date, boolean flag)
    {
        if (s == null || s1 == null || date == null)
        {
            flag = false;
        } else
        {
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1 && !hasAccount(sqlitedatabase, s))
            {
                return false;
            }
            sqlitedatabase = setTokenInDb(sqlitedatabase, s, s1, s2, date, flag);
            if (sqlitedatabase != null)
            {
                s = getLocalAccountInfo(s);
                if (s != null)
                {
                    ((AccountInfo)s.getValue()).tokens.put(s1, sqlitedatabase);
                }
                return true;
            }
        }
        return flag;
    }

    private DatabaseValue setTokenInDb(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, Date date, boolean flag)
    {
        boolean flag1 = isAccountKnowInvalid(sqlitedatabase, s, date);
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("token_account_id", s);
        contentvalues.put("token_key", s1);
        contentvalues.put("token_value", s2);
        contentvalues.put("token_timestamp", Long.valueOf(date.getTime()));
        contentvalues.put("token_dirty", Integer.valueOf(isSyncSetToDirtyBit(flag)));
        int i;
        if (flag1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("token_deleted", Integer.valueOf(i));
        if (!DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "tokens", contentvalues, String.format("%s = ? and %s < ? and %s = ?", new Object[] {
    "token_account_id", "token_timestamp", "token_key"
}), new String[] {
    s, Long.toString(date.getTime()), s1
}))
        {
            return null;
        }
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new DatabaseValue(s2, date, flag, flag1);
    }

    private boolean setUserData(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, boolean flag, Date date, boolean flag1)
    {
        if (s == null || s1 == null || date == null)
        {
            flag1 = false;
        } else
        {
            boolean flag2;
            if (!flag1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2 && !hasAccount(sqlitedatabase, s))
            {
                return false;
            }
            if (flag || isAccountKnowInvalid(sqlitedatabase, s, date))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            sqlitedatabase = insertUserdata(sqlitedatabase, s, s1, s2, flag, date, flag1);
            if (sqlitedatabase != null)
            {
                s = getLocalAccountInfo(s);
                if (s != null)
                {
                    ((AccountInfo)s.getValue()).userdata.put(s1, sqlitedatabase);
                }
                return true;
            }
        }
        return flag1;
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase2 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.beginTransaction();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        boolean flag1 = addAccount(sqlitedatabase2, s, accounttransaction, date, flag);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        flag = flag1;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        sqlitedatabase2.endTransaction();
        mLocalDataStorageHelper.close();
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        sqlitedatabase1 = sqlitedatabase;
        MAPLog.e(TAG, "Cannot add account since it violated a uniqueness constraint");
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        break MISSING_BLOCK_LABEL_158;
        s;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean clearBulkData(Collection collection)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        if (collection != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        flag1 = true;
        sqlitedatabase = sqlitedatabase1;
        collection = collection.iterator();
_L3:
        sqlitedatabase = sqlitedatabase1;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_862;
        }
        sqlitedatabase = sqlitedatabase1;
        Object obj1 = (Map)collection.next();
        sqlitedatabase = sqlitedatabase1;
        Object obj = TimeUtil.deserialize((String)((Map) (obj1)).get("timestamp_key"));
        sqlitedatabase = sqlitedatabase1;
        if (Boolean.parseBoolean((String)((Map) (obj1)).get("deleted_key")))
        {
            break MISSING_BLOCK_LABEL_144;
        }
        sqlitedatabase = sqlitedatabase1;
        MAPLog.e(TAG, "Given a row that is not marked deleted. Cannot remove from the database!");
          goto _L3
        collection;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw collection;
        collection;
        this;
        JVM INSTR monitorexit ;
        throw collection;
        sqlitedatabase = sqlitedatabase1;
        if (!isAccountDataRow(((Map) (obj1))))
        {
            break MISSING_BLOCK_LABEL_380;
        }
        sqlitedatabase = sqlitedatabase1;
        obj1 = (String)((Map) (obj1)).get("directedId");
        boolean flag;
        if (obj1 == null)
        {
            flag = false;
            break MISSING_BLOCK_LABEL_886;
        }
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("accounts", String.format("%s = ? and %s = ? and %s = 1", new Object[] {
            "directed_id", "account_timestamp", "account_deleted"
        }), new String[] {
            obj1, Long.toString(((Date) (obj)).getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("userdata", String.format("%s = ? and %s = ? and %s = 1", new Object[] {
            "userdata_account_id", "userdata_timestamp", "userdata_deleted"
        }), new String[] {
            obj1, Long.toString(((Date) (obj)).getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("tokens", String.format("%s = ? and %s = ? and %s = 1", new Object[] {
            "token_account_id", "token_timestamp", "token_deleted"
        }), new String[] {
            obj1, Long.toString(((Date) (obj)).getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        if (mAccountInfos == null)
        {
            flag = true;
            break MISSING_BLOCK_LABEL_886;
        }
        sqlitedatabase = sqlitedatabase1;
        mAccountInfos.remove(obj1);
        flag = true;
        break MISSING_BLOCK_LABEL_886;
        sqlitedatabase = sqlitedatabase1;
        if (!isUserdataDataRow(((Map) (obj1))))
        {
            break MISSING_BLOCK_LABEL_538;
        }
        sqlitedatabase = sqlitedatabase1;
        String s = (String)((Map) (obj1)).get("userdata_account");
        if (s == null)
        {
            flag = false;
            break MISSING_BLOCK_LABEL_896;
        }
        sqlitedatabase = sqlitedatabase1;
        obj1 = (String)((Map) (obj1)).get("userdata_key");
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("userdata", String.format("%s = ? and %s = ? and %s = ? and %s = 1", new Object[] {
            "userdata_account_id", "userdata_key", "userdata_timestamp", "userdata_deleted"
        }), new String[] {
            s, obj1, Long.toString(((Date) (obj)).getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        obj = getLocalAccountInfo(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_906;
        }
        sqlitedatabase = sqlitedatabase1;
        ((AccountInfo)((DatabaseValue) (obj)).getValue()).userdata.remove(obj1);
        break MISSING_BLOCK_LABEL_906;
        sqlitedatabase = sqlitedatabase1;
        if (!isTokenDataRow(((Map) (obj1))))
        {
            break MISSING_BLOCK_LABEL_696;
        }
        sqlitedatabase = sqlitedatabase1;
        s = (String)((Map) (obj1)).get("token_account");
        if (s == null)
        {
            flag = false;
            break MISSING_BLOCK_LABEL_912;
        }
        sqlitedatabase = sqlitedatabase1;
        obj1 = (String)((Map) (obj1)).get("token_key");
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("tokens", String.format("%s = ? and %s = ? and %s = ? and %s = 1", new Object[] {
            "token_account_id", "token_key", "token_timestamp", "token_deleted"
        }), new String[] {
            s, obj1, Long.toString(((Date) (obj)).getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        obj = getLocalAccountInfo(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_922;
        }
        sqlitedatabase = sqlitedatabase1;
        ((AccountInfo)((DatabaseValue) (obj)).getValue()).tokens.remove(obj1);
        break MISSING_BLOCK_LABEL_922;
        sqlitedatabase = sqlitedatabase1;
        if (!isDeviceDataDataRow(((Map) (obj1)))) goto _L3; else goto _L4
_L4:
        sqlitedatabase = sqlitedatabase1;
        s = (String)((Map) (obj1)).get("namespace");
        if (s == null)
        {
            flag = false;
            break MISSING_BLOCK_LABEL_928;
        }
        sqlitedatabase = sqlitedatabase1;
        obj1 = (String)((Map) (obj1)).get("device_data_key");
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("device_data", String.format("%s = ? and %s = ? and %s = ?  and %s = 1", new Object[] {
            "device_data_namespace", "device_data_key", "device_data_timestamp", "device_data_deleted"
        }), new String[] {
            s, obj1, Long.toString(((Date) (obj)).getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        if (mDeviceData == null)
        {
            break MISSING_BLOCK_LABEL_938;
        }
        sqlitedatabase = sqlitedatabase1;
        obj = (Map)mDeviceData.get(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_938;
        }
        sqlitedatabase = sqlitedatabase1;
        ((Map) (obj)).remove(s);
        break MISSING_BLOCK_LABEL_938;
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null) goto _L1; else goto _L5
_L5:
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
          goto _L1
        flag1 &= flag;
          goto _L3
_L6:
        flag1 &= flag;
          goto _L3
        flag = true;
          goto _L6
_L7:
        flag1 &= flag;
          goto _L3
        flag = true;
          goto _L7
_L8:
        flag1 &= flag;
          goto _L3
        flag = true;
          goto _L8
    }

    public boolean expireToken(String s, String s1, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        flag = expireToken(sqlitedatabase1, s, s1, date, flag);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Set getAccountNames()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1 = getAccountInfos();
        obj = new HashSet();
        obj1 = ((Map) (obj1)).values().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            DatabaseValue databasevalue = (DatabaseValue)((Iterator) (obj1)).next();
            if (!databasevalue.isDeleted())
            {
                ((Set) (obj)).add(((AccountInfo)databasevalue.getValue()).displayName);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_78;
        obj;
        throw obj;
        this;
        JVM INSTR monitorexit ;
        return ((Set) (obj));
    }

    public Set getAccounts()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1 = getAccountInfos();
        obj = new HashSet();
        obj1 = ((Map) (obj1)).entrySet().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            if (!((DatabaseValue)entry.getValue()).isDeleted())
            {
                ((Set) (obj)).add(entry.getKey());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_82;
        obj;
        throw obj;
        obj = Collections.unmodifiableSet(((Set) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((Set) (obj));
    }

    public Collection getAllDirtyData()
    {
        this;
        JVM INSTR monitorenter ;
        Collection collection = getAllDirtyData(null);
        this;
        JVM INSTR monitorexit ;
        return collection;
        Exception exception;
        exception;
        throw exception;
    }

    public Collection getAllDirtyData(Date date)
    {
        this;
        JVM INSTR monitorenter ;
        date = getAllData(date, EnumSet.of(GetDataOptions.DirtyOnly));
        this;
        JVM INSTR monitorexit ;
        return date;
        date;
        throw date;
    }

    public Collection getAllNonDirtyDeletedData()
    {
        this;
        JVM INSTR monitorenter ;
        Collection collection = getAllData(null, EnumSet.of(GetDataOptions.NotDirtyOnly, GetDataOptions.Deleted));
        this;
        JVM INSTR monitorexit ;
        return collection;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceData(String s, String s1)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        String s2 = obj;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s2 = obj;
_L2:
        this;
        JVM INSTR monitorexit ;
        return s2;
_L4:
        s = (Map)getDeviceData().get(s);
        s2 = obj;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = (DatabaseValue)s.get(s1);
        s2 = obj;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = obj;
        if (!s.isDeleted())
        {
            s2 = (String)s.getValue();
        }
        if (true) goto _L2; else goto _L5
_L5:
        s;
        throw s;
    }

    public Date getGreatestTimestamp(Map map)
    {
        DatabaseValue databasevalue = null;
        Iterator iterator = map.values().iterator();
        for (map = databasevalue; iterator.hasNext(); map = getMaxDateTime(map, databasevalue.getDateTime()))
        {
            databasevalue = (DatabaseValue)iterator.next();
            for (Iterator iterator1 = ((AccountInfo)databasevalue.getValue()).userdata.values().iterator(); iterator1.hasNext();)
            {
                map = getMaxDateTime(map, ((DatabaseValue)iterator1.next()).getDateTime());
            }

            for (Iterator iterator2 = ((AccountInfo)databasevalue.getValue()).tokens.values().iterator(); iterator2.hasNext();)
            {
                map = getMaxDateTime(map, ((DatabaseValue)iterator2.next()).getDateTime());
            }

        }

        return map;
    }

    public Date getMaxDateTime(Date date, Date date1)
    {
        while (date == null || date1.after(date)) 
        {
            return date1;
        }
        return date;
    }

    public Collection getSnapShotOfData()
    {
        this;
        JVM INSTR monitorenter ;
        Collection collection = getAllData(null, EnumSet.noneOf(com/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions));
        this;
        JVM INSTR monitorexit ;
        return collection;
        Exception exception;
        exception;
        throw exception;
    }

    public String getToken(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s != null && s1 != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = getAccountInfo(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (s.isDeleted())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        s = (DatabaseValue)((AccountInfo)s.getValue()).tokens.get(s1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (s.isDeleted())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = (String)s.getValue();
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
        s = null;
        continue; /* Loop/switch isn't completed */
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getUserData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s != null && s1 != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = getAccountInfo(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (s.isDeleted())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        s = (DatabaseValue)((AccountInfo)s.getValue()).userdata.get(s1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (s.isDeleted())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = (String)s.getValue();
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
        s = null;
        continue; /* Loop/switch isn't completed */
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    void populateInMemoryCache()
    {
        this;
        JVM INSTR monitorenter ;
        getAccountInfos();
        getDeviceData();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean removeAccount(String s, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        flag = removeAccount(sqlitedatabase1, s, date, flag);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean setAllBeforeTimeNotDirty(Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        Iterator iterator;
        setAllBeforeTimeNotDirtyInDb(date);
        if (mAccountInfos == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        iterator = mAccountInfos.values().iterator();
_L3:
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_166;
        }
        obj = (DatabaseValue)iterator.next();
        ((DatabaseValue) (obj)).setNotDirtyIfIsBeforeOrEqualToTimestamp(date);
        for (Iterator iterator3 = ((AccountInfo)((DatabaseValue) (obj)).getValue()).userdata.values().iterator(); iterator3.hasNext(); ((DatabaseValue)iterator3.next()).setNotDirtyIfIsBeforeOrEqualToTimestamp(date)) { }
        break MISSING_BLOCK_LABEL_120;
        date;
        throw date;
        obj = ((AccountInfo)((DatabaseValue) (obj)).getValue()).tokens.values().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            ((DatabaseValue)((Iterator) (obj)).next()).setNotDirtyIfIsBeforeOrEqualToTimestamp(date);
        }
          goto _L3
        if (mDeviceData != null)
        {
            for (Iterator iterator1 = mDeviceData.values().iterator(); iterator1.hasNext();)
            {
                Iterator iterator2 = ((Map)iterator1.next()).values().iterator();
                while (iterator2.hasNext()) 
                {
                    ((DatabaseValue)iterator2.next()).setNotDirtyIfIsBeforeOrEqualToTimestamp(date);
                }
            }

        }
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean setBulkData(Collection collection)
    {
        this;
        JVM INSTR monitorenter ;
        if (collection != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        boolean flag;
        flag = true;
        sqlitedatabase = sqlitedatabase1;
        collection = collection.iterator();
_L4:
        sqlitedatabase = sqlitedatabase1;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_479;
        }
        sqlitedatabase = sqlitedatabase1;
        Map map = (Map)collection.next();
        sqlitedatabase = sqlitedatabase1;
        Date date = TimeUtil.deserialize((String)map.get("timestamp_key"));
        sqlitedatabase = sqlitedatabase1;
        flag1 = Boolean.parseBoolean((String)map.get("deleted_key"));
        sqlitedatabase = sqlitedatabase1;
        if (!isAccountDataRow(map))
        {
            break MISSING_BLOCK_LABEL_205;
        }
        sqlitedatabase = sqlitedatabase1;
        String s = (String)map.get("directedId");
        if (s == null)
        {
            flag1 = false;
            break MISSING_BLOCK_LABEL_534;
        }
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        sqlitedatabase = sqlitedatabase1;
        flag1 = addAccount(sqlitedatabase1, (String)map.get("display_name"), new AccountTransaction(s, null, null), date, true);
        break MISSING_BLOCK_LABEL_534;
        sqlitedatabase = sqlitedatabase1;
        flag1 = removeAccount(sqlitedatabase1, s, date, true);
        break MISSING_BLOCK_LABEL_534;
        sqlitedatabase = sqlitedatabase1;
        if (!isUserdataDataRow(map))
        {
            break MISSING_BLOCK_LABEL_287;
        }
        sqlitedatabase = sqlitedatabase1;
        s = (String)map.get("userdata_account");
        if (s == null)
        {
            flag1 = false;
            break MISSING_BLOCK_LABEL_544;
        }
        sqlitedatabase = sqlitedatabase1;
        flag1 = setUserData(sqlitedatabase1, s, (String)map.get("userdata_key"), (String)map.get("userdata_value"), flag1, date, true);
        break MISSING_BLOCK_LABEL_544;
        sqlitedatabase = sqlitedatabase1;
        if (!isTokenDataRow(map))
        {
            break MISSING_BLOCK_LABEL_397;
        }
        sqlitedatabase = sqlitedatabase1;
        s = (String)map.get("token_account");
        if (s == null)
        {
            flag1 = false;
            break MISSING_BLOCK_LABEL_554;
        }
        sqlitedatabase = sqlitedatabase1;
        String s1 = (String)map.get("token_key");
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        sqlitedatabase = sqlitedatabase1;
        flag1 = setToken(sqlitedatabase1, s, s1, (String)map.get("token_value"), date, true);
        break MISSING_BLOCK_LABEL_554;
        sqlitedatabase = sqlitedatabase1;
        flag1 = expireToken(sqlitedatabase1, s, s1, date, true);
        break MISSING_BLOCK_LABEL_554;
        sqlitedatabase = sqlitedatabase1;
        if (!isDeviceDataDataRow(map)) goto _L4; else goto _L3
_L3:
        sqlitedatabase = sqlitedatabase1;
        s = (String)map.get("namespace");
        if (s == null)
        {
            flag1 = false;
            break MISSING_BLOCK_LABEL_564;
        }
        sqlitedatabase = sqlitedatabase1;
        flag1 = setDeviceData(sqlitedatabase1, s, (String)map.get("device_data_key"), (String)map.get("device_data_value"), flag1, date, true);
        break MISSING_BLOCK_LABEL_564;
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        flag1 = flag;
        if (sqlitedatabase1 == null) goto _L6; else goto _L5
_L5:
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        flag1 = flag;
          goto _L6
        collection;
        throw collection;
        collection;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_532;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw collection;
        flag &= flag1;
          goto _L4
        flag &= flag1;
          goto _L4
        flag &= flag1;
          goto _L4
        flag &= flag1;
          goto _L4
    }

    public boolean setData(AccountTransaction accounttransaction, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase2 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.beginTransaction();
        boolean flag2;
        flag2 = true;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Iterator iterator = accounttransaction.getUserData().entrySet().iterator();
_L2:
        boolean flag1;
        flag1 = flag2;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_146;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (setUserData(sqlitedatabase2, accounttransaction.getDirectedId(), (String)entry.getKey(), (String)entry.getValue(), false, date, flag)) goto _L2; else goto _L1
_L1:
        flag1 = false;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        iterator = accounttransaction.getTokens().entrySet().iterator();
_L4:
        flag2 = flag1;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_258;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        entry = (java.util.Map.Entry)iterator.next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (setToken(sqlitedatabase2, accounttransaction.getDirectedId(), (String)entry.getKey(), (String)entry.getValue(), date, flag)) goto _L4; else goto _L3
_L3:
        flag2 = false;
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        flag = flag2;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        sqlitedatabase2.endTransaction();
        mLocalDataStorageHelper.close();
        flag = flag2;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
        accounttransaction;
        sqlitedatabase1 = sqlitedatabase;
        MAPLog.e(TAG, "Cannot set token since it violated a uniqueness constraint");
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        break MISSING_BLOCK_LABEL_362;
        accounttransaction;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        throw accounttransaction;
        accounttransaction;
        this;
        JVM INSTR monitorexit ;
        throw accounttransaction;
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean setDeviceData(String s, String s1, String s2, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        SQLiteDatabase sqlitedatabase1;
        sqlitedatabase1 = null;
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase2 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.beginTransaction();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        boolean flag1 = setDeviceData(sqlitedatabase2, s, s1, s2, false, date, flag);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        flag = flag1;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        sqlitedatabase2.endTransaction();
        mLocalDataStorageHelper.close();
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        sqlitedatabase1 = sqlitedatabase;
        MAPLog.e(TAG, "Cannot set device data since it violated a uniqueness constraint");
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        break MISSING_BLOCK_LABEL_161;
        s;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setNotDirtyAddAccount(AccountTransaction accounttransaction, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(date, "dateTime");
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        Object obj = new ContentValues();
        sqlitedatabase = sqlitedatabase1;
        ((ContentValues) (obj)).put("account_dirty", Integer.valueOf(0));
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.update("accounts", ((ContentValues) (obj)), String.format("%s = ? and %s = ? and %s = 1 and %s = 0", new Object[] {
            "directed_id", "account_timestamp", "account_dirty", "account_deleted"
        }), new String[] {
            accounttransaction.getDirectedId(), Long.toString(date.getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        obj = accounttransaction.getUserData().entrySet().iterator();
_L2:
        sqlitedatabase = sqlitedatabase1;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        sqlitedatabase = sqlitedatabase1;
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        sqlitedatabase = sqlitedatabase1;
        insertUserdataNotDirty(sqlitedatabase1, accounttransaction.getDirectedId(), (String)entry.getKey(), date);
        if (true) goto _L2; else goto _L1
        accounttransaction;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw accounttransaction;
        accounttransaction;
        this;
        JVM INSTR monitorexit ;
        throw accounttransaction;
_L1:
        sqlitedatabase = sqlitedatabase1;
        obj = accounttransaction.getTokens().entrySet().iterator();
_L4:
        sqlitedatabase = sqlitedatabase1;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        sqlitedatabase = sqlitedatabase1;
        entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        sqlitedatabase = sqlitedatabase1;
        insertTokenNotDirty(sqlitedatabase1, accounttransaction.getDirectedId(), (String)entry.getKey(), date);
        if (true) goto _L4; else goto _L3
_L3:
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        accounttransaction = getLocalAccountInfo(accounttransaction.getDirectedId());
        if (accounttransaction != null) goto _L6; else goto _L5
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        accounttransaction.setNotDirtyIfHasCurrentTimeStamp(date);
        for (Iterator iterator = ((AccountInfo)accounttransaction.getValue()).userdata.entrySet().iterator(); iterator.hasNext(); ((DatabaseValue)((java.util.Map.Entry)iterator.next()).getValue()).setNotDirtyIfHasCurrentTimeStamp(date)) { }
        accounttransaction = ((AccountInfo)accounttransaction.getValue()).tokens.entrySet().iterator();
        while (accounttransaction.hasNext()) 
        {
            ((DatabaseValue)((java.util.Map.Entry)accounttransaction.next()).getValue()).setNotDirtyIfHasCurrentTimeStamp(date);
        }
          goto _L5
    }

    public void setNotDirtyExpireToken(String s, String s1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(s, "directedId");
        MAPArgContracts.throwIfNull(s1, "key");
        MAPArgContracts.throwIfNull(date, "dateTime");
        SQLiteDatabase sqlitedatabase = mLocalDataStorageHelper.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("token_dirty", Integer.valueOf(0));
        sqlitedatabase.update("tokens", contentvalues, String.format("%s = ? and %s = ? and %s = ? and %s = 1 and %s = 1", new Object[] {
            "token_account_id", "token_key", "token_timestamp", "token_deleted", "token_dirty"
        }), new String[] {
            s, s1, Long.toString(date.getTime())
        });
        mLocalDataStorageHelper.close();
        s = getLocalAccountInfo(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = (DatabaseValue)((AccountInfo)s.getValue()).tokens.get(s1);
        if (s == null) goto _L1; else goto _L3
_L3:
        if (s.getValue() != null) goto _L1; else goto _L4
_L4:
        s.setNotDirtyIfHasCurrentTimeStamp(date);
          goto _L1
    }

    public void setNotDirtyRemoveAccount(String s, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(s, "directedId");
        MAPArgContracts.throwIfNull(date, "dateTime");
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        ContentValues contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("account_dirty", Integer.valueOf(0));
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.update("accounts", contentvalues, String.format("%s = ? and %s = ? and %s = 1 and %s = 1", new Object[] {
            "directed_id", "account_timestamp", "account_deleted", "account_dirty"
        }), new String[] {
            s, Long.toString(date.getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("userdata_dirty", Integer.valueOf(0));
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.update("userdata", contentvalues, String.format("%s = ? and %s = ? and %s = 1 and %s = 1", new Object[] {
            "userdata_account_id", "userdata_timestamp", "userdata_deleted", "userdata_dirty"
        }), new String[] {
            s, Long.toString(date.getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("token_dirty", Integer.valueOf(0));
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.update("tokens", contentvalues, String.format("%s = ? and %s = ? and %s = 1 and %s = 1", new Object[] {
            "token_account_id", "token_timestamp", "token_deleted", "token_dirty"
        }), new String[] {
            s, Long.toString(date.getTime())
        });
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        s = getLocalAccountInfo(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_350;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s.setNotDirtyIfHasCurrentTimeStamp(date);
        for (Iterator iterator = ((AccountInfo)s.getValue()).userdata.values().iterator(); iterator.hasNext(); ((DatabaseValue)iterator.next()).setNotDirtyIfHasCurrentTimeStamp(date)) { }
        s = ((AccountInfo)s.getValue()).tokens.values().iterator();
        while (s.hasNext()) 
        {
            ((DatabaseValue)s.next()).setNotDirtyIfHasCurrentTimeStamp(date);
        }
          goto _L1
    }

    public void setNotDirtySetDeviceData(String s, String s1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(s, "namespace");
        MAPArgContracts.throwIfNull(s1, "key");
        MAPArgContracts.throwIfNull(date, "dateTime");
        SQLiteDatabase sqlitedatabase = mLocalDataStorageHelper.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("device_data_dirty", Integer.valueOf(0));
        sqlitedatabase.update("device_data", contentvalues, String.format("%s = ? and %s = ? and %s = ? and %s = 0 and %s = 1", new Object[] {
            "device_data_namespace", "device_data_key", "device_data_timestamp", "device_data_deleted", "device_data_dirty"
        }), new String[] {
            s, s1, Long.toString(date.getTime())
        });
        Map map;
        mLocalDataStorageHelper.close();
        map = mDeviceData;
        if (map != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = (Map)mDeviceData.get(s);
        if (s == null) goto _L1; else goto _L3
_L3:
        s = (DatabaseValue)s.get(s1);
        if (s == null) goto _L1; else goto _L4
_L4:
        s.setNotDirtyIfHasCurrentTimeStamp(date);
          goto _L1
    }

    public void setNotDirtySetToken(String s, String s1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(s, "directedId");
        MAPArgContracts.throwIfNull(s1, "key");
        MAPArgContracts.throwIfNull(date, "dateTime");
        insertTokenNotDirty(mLocalDataStorageHelper.getWritableDatabase(), s, s1, date);
        mLocalDataStorageHelper.close();
        s = getLocalAccountInfo(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = (DatabaseValue)((AccountInfo)s.getValue()).tokens.get(s1);
        if (s == null) goto _L1; else goto _L3
_L3:
        s.setNotDirtyIfHasCurrentTimeStamp(date);
          goto _L1
    }

    public void setNotDirtySetUserData(String s, String s1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        MAPArgContracts.throwIfNull(s, "directedId");
        MAPArgContracts.throwIfNull(s1, "key");
        MAPArgContracts.throwIfNull(date, "dateTime");
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        insertUserdataNotDirty(sqlitedatabase1, s, s1, date);
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        s = getLocalAccountInfo(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = (DatabaseValue)((AccountInfo)s.getValue()).userdata.get(s1);
        if (s == null) goto _L1; else goto _L3
_L3:
        s.setNotDirtyIfHasCurrentTimeStamp(date);
          goto _L1
    }

    public boolean setSnapshotOfData(Collection collection)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        cleanDb(mContext);
        mAccountInfos = null;
        mDeviceData = null;
        flag = setBulkData(collection);
        this;
        JVM INSTR monitorexit ;
        return flag;
        collection;
        throw collection;
    }

    public boolean setToken(String s, String s1, String s2, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        flag = setData(new AccountTransaction(s, null, Collections.singletonMap(s1, s2)), date, flag);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public boolean setTokens(AccountTransaction accounttransaction, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        flag = setData(accounttransaction, date, flag);
        this;
        JVM INSTR monitorexit ;
        return flag;
        accounttransaction;
        throw accounttransaction;
    }

    public boolean setUserData(AccountTransaction accounttransaction, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        flag = setData(accounttransaction, date, flag);
        this;
        JVM INSTR monitorexit ;
        return flag;
        accounttransaction;
        throw accounttransaction;
    }

    public boolean setUserData(String s, String s1, String s2, Date date, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        flag = setData(new AccountTransaction(s, Collections.singletonMap(s1, s2), null), date, flag);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }


}
