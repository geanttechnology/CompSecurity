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
import android.util.Base64;
import com.amazon.identity.auth.device.framework.AESCipher;
import com.amazon.identity.auth.device.framework.SQLTable;
import com.amazon.identity.auth.device.utils.DBHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LocalKeyValueStore, AccountInfoV2

public class LocalDataStorageV2
{
    static class LocalDataStorageDBHelper extends SQLiteOpenHelper
    {

        private final LocalKeyValueStore mkeyValueStore;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            MAPLog.i(LocalDataStorageV2.TAG, "Creating LocalDataStorageV2 Database");
            MAPLog.i(LocalDataStorageV2.TAG, "Creating Accounts table in LocalDataStorageV2 database");
            sqlitedatabase.execSQL((new SQLTable("accounts")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("directed_id", "TEXT UNIQUE NOT NULL").addColumn("display_name", "TEXT NOT NULL").toString());
            MAPLog.i(LocalDataStorageV2.TAG, "Creating AccountData table in LocalDataStorageV2 database");
            sqlitedatabase.execSQL((new SQLTable("account_data")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("account_data_directed_id", "TEXT NOT NULL").addColumn("account_data_key", "TEXT NOT NULL").addColumn("account_data_value", "BLOB").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
                "account_data_directed_id", "account_data_key"
            })).toString());
            MAPLog.i(LocalDataStorageV2.TAG, "Creating DeviceData table in LocalDataStorageV2 database");
            sqlitedatabase.execSQL((new SQLTable("device_data")).addColumn("_id", "INTEGER PRIMARY KEY AUTOINCREMENT").addColumn("device_data_namespace", "TEXT NOT NULL").addColumn("device_data_key", "TEXT NOT NULL").addColumn("device_data_value", "BLOB").addConstraint(String.format("UNIQUE(%s,%s)", new Object[] {
                "device_data_namespace", "device_data_key"
            })).toString());
            mkeyValueStore.setValue("com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key", AESCipher.generateAesSecureStorageKey());
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
            MAPLog.e(LocalDataStorageV2.TAG, String.format("Cannot upgrade from version %d to %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            }));
            throw new IllegalStateException(String.format("Cannot upgrade from version %d to %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            }));
        }

        public LocalDataStorageDBHelper(Context context, String s, LocalKeyValueStore localkeyvaluestore)
        {
            super(context, (new StringBuilder()).append(s).append(".db").toString(), null, 1);
            MAPLog.i(LocalDataStorageV2.TAG, "Constructing LocalDataStorageDBHelper");
            context = context.getDatabasePath((new StringBuilder()).append(s).append(".db").toString());
            MAPLog.i(LocalDataStorageV2.TAG, (new StringBuilder("Database ")).append(s).append(".db exists: ").append(context.exists()).toString());
            mkeyValueStore = localkeyvaluestore;
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/LocalDataStorageV2.getName();
    private static LocalDataStorageV2 sLocalDataStorage;
    private AESCipher mAESCipher;
    private Map mAccountCache;
    private final Context mContext;
    private Map mDeviceData;
    private final LocalKeyValueStore mKeyValueStore;
    private final LocalDataStorageDBHelper mLocalDataStorageHelper;

    private LocalDataStorageV2(Context context)
    {
        this(context, "map_data_storage_v2");
    }

    LocalDataStorageV2(Context context, String s)
    {
        MAPLog.i(TAG, "Constructing LocalDataStorageV2");
        mContext = context;
        mKeyValueStore = new LocalKeyValueStore(mContext, "com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encryption.namespace");
        mLocalDataStorageHelper = new LocalDataStorageDBHelper(context, s, mKeyValueStore);
        mAESCipher = null;
    }

    private void addToProjection(Map map, String s, String s1, String s2)
    {
        map.put(s2, DBHelpers.getAliasColumnName(s, s1, s2));
    }

    public static void cleanDb(Context context)
    {
        if (context != null)
        {
            if (context.deleteDatabase((new StringBuilder()).append("map_data_storage_v2").append(".db").toString()))
            {
                context = "successful";
            } else
            {
                context = "failed";
            }
            MAPLog.i(TAG, (new StringBuilder("cleanDb ")).append(context).toString());
        }
    }

    private String decode(byte abyte0[])
    {
        AESCipher aescipher;
        if (abyte0 == null)
        {
            return null;
        }
        try
        {
            aescipher = getCipher(true);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException(abyte0);
        }
        if (aescipher != null && abyte0 != null) goto _L2; else goto _L1
_L4:
        abyte0 = new String(abyte0, "UTF-8");
        return abyte0;
_L2:
        byte abyte1[] = aescipher.decryptCBCMode(abyte0);
        abyte0 = abyte1;
        if (abyte1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        MAPLog.e(TAG, "The decrypt result is null. This should not happen!");
        MetricsHelper.incrementCounter("DecryptionFailure", new String[] {
            "decryptCBCModeReturnNull"
        });
        cleanDb(mContext);
        throw new IllegalStateException("decryptCBCMode returns null. Something wrong with the decryption");
_L1:
        abyte0 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private byte[] encode(String s)
    {
        byte abyte0[] = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        s = abyte0;
_L4:
        return s;
_L2:
        byte abyte1[];
        AESCipher aescipher;
        try
        {
            abyte1 = s.getBytes("UTF-8");
            aescipher = getCipher(false);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        s = abyte0;
        if (aescipher == null) goto _L4; else goto _L3
_L3:
        s = abyte0;
        if (abyte1 == null) goto _L4; else goto _L5
_L5:
        abyte0 = aescipher.encryptCBCMode(abyte1);
        s = abyte0;
        if (abyte0 != null) goto _L4; else goto _L6
_L6:
        MAPLog.e(TAG, "The encrypt result is null. This should not happen!");
        MetricsHelper.incrementCounter("EncryptionFailure", new String[] {
            "encryptCBCModeReturnNull"
        });
        return abyte0;
    }

    private AccountInfoV2 fetchCachedAccountInfo(String s)
    {
        if (mAccountCache == null)
        {
            return null;
        } else
        {
            return (AccountInfoV2)mAccountCache.get(s);
        }
    }

    private Map getAccountDataFromDB(SQLiteDatabase sqlitedatabase, String s)
    {
        SQLiteDatabase sqlitedatabase1;
        Object obj;
        HashMap hashmap;
        hashmap = new HashMap();
        obj = null;
        sqlitedatabase1 = obj;
        String s1 = String.format("%s = ?", new Object[] {
            "account_data_directed_id"
        });
        sqlitedatabase1 = obj;
        sqlitedatabase = sqlitedatabase.query("account_data", new String[] {
            "account_data_directed_id", "account_data_key", "account_data_value"
        }, s1, new String[] {
            s
        }, null, null, null);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        sqlitedatabase1 = sqlitedatabase;
        boolean flag = sqlitedatabase.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        DBHelpers.closeCursor(sqlitedatabase);
        return hashmap;
        sqlitedatabase1 = sqlitedatabase;
        int i = sqlitedatabase.getColumnIndexOrThrow("account_data_key");
        sqlitedatabase1 = sqlitedatabase;
        int j = sqlitedatabase.getColumnIndexOrThrow("account_data_value");
_L2:
        sqlitedatabase1 = sqlitedatabase;
        s = sqlitedatabase.getString(i);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        sqlitedatabase1 = sqlitedatabase;
        hashmap.put(s, decode(sqlitedatabase.getBlob(j)));
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

    private Map getAndCacheAllAccounts()
    {
        if (mAccountCache == null)
        {
            mAccountCache = populateAccountCache();
        }
        return mAccountCache;
    }

    private AESCipher getCipher(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (mAESCipher != null) goto _L2; else goto _L1
_L1:
        String s = mKeyValueStore.getStringValue("com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key");
        Object obj = s;
        if (s != null) goto _L4; else goto _L3
_L3:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        MAPLog.e(TAG, "Cannot get the encryption key from SharedPreferences before decrypt. This should not happen!");
        MetricsHelper.incrementCounter("DecryptionFailure", new String[] {
            "EncryptionKeyNotFound"
        });
        cleanDb(mContext);
        throw new IllegalStateException("The encryption key is null!");
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        MAPLog.e(TAG, "Cannot get the encryption key from SharedPreferences before encrypt. Gonna create a new key. This should not happen!");
        MetricsHelper.incrementCounter("EncryptionFailure", new String[] {
            "EncryptionKeyNotFound"
        });
        if (!mKeyValueStore.setValue("com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key", AESCipher.generateAesSecureStorageKey())) goto _L6; else goto _L5
_L5:
        obj = mKeyValueStore.getStringValue("com.amazon.identity.auth.device.storage.LocalOnlySQLDB.encrypt.key");
_L4:
        mAESCipher = new AESCipher(Base64.decode(((String) (obj)), 0));
_L2:
        obj = mAESCipher;
_L8:
        this;
        JVM INSTR monitorexit ;
        return ((AESCipher) (obj));
_L6:
        MAPLog.e(TAG, "Try to re-generate the encryption key and save it into shared preferences failed!");
        MetricsHelper.incrementCounter("EncryptionFailure", new String[] {
            "TryToRegenerateEncryptionKeyFailure"
        });
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static LocalDataStorageV2 getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/LocalDataStorageV2;
        JVM INSTR monitorenter ;
        if (sLocalDataStorage == null)
        {
            sLocalDataStorage = new LocalDataStorageV2(context.getApplicationContext());
        }
        context = sLocalDataStorage;
        com/amazon/identity/auth/device/storage/LocalDataStorageV2;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private boolean hasAccount(SQLiteDatabase sqlitedatabase, String s)
    {
        if (mAccountCache == null)
        {
            mAccountCache = populateAccountCache(sqlitedatabase);
        }
        return (AccountInfoV2)mAccountCache.get(s) != null;
    }

    private Map populateAccountCache()
    {
        Map map = populateAccountCache(mLocalDataStorageHelper.getReadableDatabase());
        mLocalDataStorageHelper.close();
        return map;
        Exception exception;
        exception;
        mLocalDataStorageHelper.close();
        throw exception;
    }

    private Map populateAccountCache(SQLiteDatabase sqlitedatabase)
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
        ((StringBuilder) (obj1)).append("accounts");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(" LEFT OUTER JOIN account_data ON (");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(DBHelpers.getNamespaceColumnName("accounts", "directed_id")).append(" = ");
        cursor = cursor1;
        ((StringBuilder) (obj1)).append(DBHelpers.getNamespaceColumnName("account_data", "account_data_directed_id")).append(")");
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
        addToProjection(((Map) (obj1)), "account_data", "account_data_key", "account_data_key");
        cursor = cursor1;
        addToProjection(((Map) (obj1)), "account_data", "account_data_value", "account_data_value");
        cursor = cursor1;
        ((SQLiteQueryBuilder) (obj)).setProjectionMap(((Map) (obj1)));
        cursor = cursor1;
        cursor1 = sqlitedatabase.rawQuery(((SQLiteQueryBuilder) (obj)).buildQuery((String[])((HashMap) (obj1)).keySet().toArray(new String[0]), null, null, null, null, null, null), null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        cursor = cursor1;
        boolean flag = cursor1.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        DBHelpers.closeCursor(cursor1);
        return hashmap;
        cursor = cursor1;
        int i = cursor1.getColumnIndexOrThrow("directed_id");
        cursor = cursor1;
        int j = cursor1.getColumnIndexOrThrow("display_name");
        cursor = cursor1;
        int k = cursor1.getColumnIndexOrThrow("account_data_key");
        cursor = cursor1;
        int l = cursor1.getColumnIndexOrThrow("account_data_value");
_L2:
        cursor = cursor1;
        obj1 = cursor1.getString(i);
        cursor = cursor1;
        obj = (AccountInfoV2)hashmap.get(obj1);
        sqlitedatabase = ((SQLiteDatabase) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        cursor = cursor1;
        sqlitedatabase = new AccountInfoV2(((String) (obj1)), cursor1.getString(j));
        cursor = cursor1;
        hashmap.put(obj1, sqlitedatabase);
        cursor = cursor1;
        obj = cursor1.getString(k);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        cursor = cursor1;
        ((AccountInfoV2) (sqlitedatabase)).accountData.put(obj, decode(cursor1.getBlob(l)));
        cursor = cursor1;
        flag = cursor1.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
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
            "device_data_namespace", "device_data_key", "device_data_value"
        }, null, null, null, null, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        cursor = cursor1;
        boolean flag = cursor1.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        DBHelpers.closeCursor(cursor1);
        mLocalDataStorageHelper.close();
        return hashmap;
        cursor = cursor1;
        int i = cursor1.getColumnIndexOrThrow("device_data_namespace");
        cursor = cursor1;
        int j = cursor1.getColumnIndexOrThrow("device_data_key");
        cursor = cursor1;
        int k = cursor1.getColumnIndexOrThrow("device_data_value");
_L2:
        cursor = cursor1;
        String s = cursor1.getString(i);
        cursor = cursor1;
        Object obj1 = (Map)hashmap.get(s);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        cursor = cursor1;
        obj = new HashMap();
        cursor = cursor1;
        hashmap.put(s, obj);
        cursor = cursor1;
        obj1 = cursor1.getString(j);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        cursor = cursor1;
        ((Map) (obj)).put(obj1, decode(cursor1.getBlob(k)));
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

    private boolean setAccountDataAndUpdateCache(SQLiteDatabase sqlitedatabase, String s, String s1, String s2)
    {
        while (s == null || s1 == null || !hasAccount(sqlitedatabase, s) || !setAccountDataInDb(sqlitedatabase, s, s1, s2)) 
        {
            return false;
        }
        sqlitedatabase = fetchCachedAccountInfo(s);
        if (sqlitedatabase != null)
        {
            ((AccountInfoV2) (sqlitedatabase)).accountData.put(s1, s2);
        }
        return true;
    }

    private boolean setAccountDataInDb(SQLiteDatabase sqlitedatabase, String s, String s1, String s2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("account_data_directed_id", s);
        contentvalues.put("account_data_key", s1);
        contentvalues.put("account_data_value", encode(s2));
        return DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "account_data", contentvalues, String.format("%s = ? and %s = ?", new Object[] {
            "account_data_directed_id", "account_data_key"
        }), new String[] {
            s, s1
        });
    }

    private boolean setDeviceDataAndUpdateCache(SQLiteDatabase sqlitedatabase, String s, String s1, String s2)
    {
        if (s != null && s1 != null)
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("device_data_namespace", s);
            contentvalues.put("device_data_key", s1);
            contentvalues.put("device_data_value", encode(s2));
            if (DBHelpers.ifCannotUpdateThenInsert(sqlitedatabase, "device_data", contentvalues, String.format("%s = ? and %s = ?", new Object[] {
    "device_data_namespace", "device_data_key"
}), new String[] {
    s, s1
}))
            {
                if (mDeviceData != null)
                {
                    Map map = (Map)mDeviceData.get(s);
                    sqlitedatabase = map;
                    if (map == null)
                    {
                        sqlitedatabase = new HashMap();
                        mDeviceData.put(s, sqlitedatabase);
                    }
                    sqlitedatabase.put(s1, s2);
                }
                return true;
            }
        }
        return false;
    }

    public boolean addAccount(String s, String s1, Map map)
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
        if (s1 != null && s != null) goto _L2; else goto _L1
_L15:
        boolean flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        boolean flag1;
        flag1 = flag;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        sqlitedatabase2.endTransaction();
        mLocalDataStorageHelper.close();
        flag1 = flag;
_L11:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Object obj = new ContentValues();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("directed_id", s1);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((ContentValues) (obj)).put("display_name", s);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (DBHelpers.tryInsert(sqlitedatabase2, "accounts", ((ContentValues) (obj)))) goto _L4; else goto _L3
_L3:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        MAPLog.e(TAG, "Failed to add account");
        s = null;
          goto _L5
_L4:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        obj = getAccountDataFromDB(sqlitedatabase2, s1);
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        map = map.entrySet().iterator();
_L9:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!map.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (setAccountDataInDb(sqlitedatabase2, s1, (String)entry.getKey(), (String)entry.getValue())) goto _L7; else goto _L6
_L6:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        MAPLog.e(TAG, "Failed to save account because saving token was unsuccessful");
        s = null;
          goto _L5
_L7:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        ((Map) (obj)).put(entry.getKey(), entry.getValue());
        if (true) goto _L9; else goto _L8
_L8:
        break; /* Loop/switch isn't completed */
        s;
        sqlitedatabase1 = sqlitedatabase;
        MAPLog.e(TAG, "Cannot add account due to ", s);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        flag1 = false;
        if (true) goto _L11; else goto _L10
_L10:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        s = new AccountInfoV2(s1, s, ((Map) (obj)));
          goto _L5
        s;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L13:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (mAccountCache == null)
        {
            break MISSING_BLOCK_LABEL_470;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        mAccountCache.put(s1, s);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L1:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if (s != null) goto _L13; else goto _L12
_L12:
        flag = false;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public String getAccountData(String s, String s1)
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
        s = (AccountInfoV2)getAndCacheAllAccounts().get(s);
        s2 = obj;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = (String)((AccountInfoV2) (s)).accountData.get(s1);
        if (true) goto _L2; else goto _L5
_L5:
        s;
        throw s;
    }

    public Set getAccountNames()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1 = getAndCacheAllAccounts();
        obj = new HashSet();
        for (obj1 = ((Map) (obj1)).values().iterator(); ((Iterator) (obj1)).hasNext(); ((Set) (obj)).add(((AccountInfoV2)((Iterator) (obj1)).next()).displayName)) { }
        break MISSING_BLOCK_LABEL_63;
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
        Object obj1 = getAndCacheAllAccounts();
        obj = new HashSet();
        for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((Set) (obj)).add(((java.util.Map.Entry)((Iterator) (obj1)).next()).getKey())) { }
        break MISSING_BLOCK_LABEL_65;
        obj;
        throw obj;
        obj = Collections.unmodifiableSet(((Set) (obj)));
        this;
        JVM INSTR monitorexit ;
        return ((Set) (obj));
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
        if (mDeviceData == null)
        {
            mDeviceData = populateDeviceData();
        }
        s = (Map)mDeviceData.get(s);
        s2 = obj;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = (String)s.get(s1);
        if (true) goto _L2; else goto _L5
_L5:
        s;
        throw s;
    }

    public boolean removeAccount(String s)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        if (s != null) goto _L2; else goto _L1
_L1:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        sqlitedatabase = sqlitedatabase1;
        boolean flag;
        if (sqlitedatabase1.delete("accounts", String.format("%s = ?", new Object[] {
    "directed_id"
}), new String[] {
    s
}) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("account_data", String.format("%s = ?", new Object[] {
            "account_data_directed_id"
        }), new String[] {
            s
        });
        if (!flag) goto _L1; else goto _L3
_L3:
        sqlitedatabase = sqlitedatabase1;
        if (mAccountCache == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        sqlitedatabase = sqlitedatabase1;
        mAccountCache.remove(s);
        flag1 = true;
          goto _L1
        s;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean removeAccountData(String s, String s1)
    {
        boolean flag2 = false;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = mLocalDataStorageHelper.getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        boolean flag1 = flag2;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s1 != null) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
_L2:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L4:
        flag1 = flag2;
        sqlitedatabase = sqlitedatabase1;
        if (!hasAccount(sqlitedatabase1, s)) goto _L2; else goto _L5
_L5:
        sqlitedatabase = sqlitedatabase1;
        boolean flag;
        if (sqlitedatabase1.delete("account_data", String.format("%s = ? and %s = ?", new Object[] {
    "account_data_directed_id", "account_data_key"
}), new String[] {
    s, s1
}) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag2;
        if (!flag) goto _L2; else goto _L6
_L6:
        sqlitedatabase = sqlitedatabase1;
        s = fetchCachedAccountInfo(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        sqlitedatabase = sqlitedatabase1;
        ((AccountInfoV2) (s)).accountData.remove(s1);
        flag1 = true;
          goto _L2
        s;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean setAccountData(String s, String s1, String s2)
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
        boolean flag1 = setAccountDataAndUpdateCache(sqlitedatabase2, s, s1, s2);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        boolean flag;
        flag = flag1;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_92;
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
        MAPLog.e(TAG, "Cannot set data due to: ", s);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        break MISSING_BLOCK_LABEL_157;
        s;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_150;
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

    public boolean setAccountData(String s, Map map)
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
        boolean flag1;
        flag1 = true;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        map = map.entrySet().iterator();
_L2:
        boolean flag;
        flag = flag1;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!map.hasNext())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (setAccountDataAndUpdateCache(sqlitedatabase2, s, (String)entry.getKey(), (String)entry.getValue())) goto _L2; else goto _L1
_L1:
        flag = false;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        flag1 = flag;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        sqlitedatabase2.endTransaction();
        mLocalDataStorageHelper.close();
        flag1 = flag;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag1;
        s;
        sqlitedatabase1 = sqlitedatabase;
        MAPLog.e(TAG, "Cannot set data due to: ", s);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        break MISSING_BLOCK_LABEL_232;
        s;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        flag1 = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean setDeviceData(String s, String s1, String s2)
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
        boolean flag1 = setDeviceDataAndUpdateCache(sqlitedatabase2, s, s1, s2);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        boolean flag;
        flag = flag1;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_92;
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
            break MISSING_BLOCK_LABEL_156;
        }
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
        break MISSING_BLOCK_LABEL_156;
        s;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_149;
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

    public boolean setDeviceData(List list)
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
        boolean flag;
        flag = true;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        list = list.iterator();
_L9:
        boolean flag1;
        flag1 = flag;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (!list.hasNext()) goto _L2; else goto _L1
_L1:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        Object obj = (DeviceDataMigrationHelper.DeviceDataUnit)list.next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        String s = ((DeviceDataMigrationHelper.DeviceDataUnit) (obj)).mNamespace;
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        obj = ((DeviceDataMigrationHelper.DeviceDataUnit) (obj)).mData.entrySet().iterator();
_L6:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        flag1 = flag;
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        if (setDeviceDataAndUpdateCache(sqlitedatabase2, s, (String)entry.getKey(), (String)entry.getValue())) goto _L6; else goto _L5
_L5:
        flag1 = false;
          goto _L4
_L2:
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        sqlitedatabase = sqlitedatabase2;
        sqlitedatabase1 = sqlitedatabase2;
        sqlitedatabase2.setTransactionSuccessful();
        flag = flag1;
        if (sqlitedatabase2 == null)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        sqlitedatabase2.endTransaction();
        mLocalDataStorageHelper.close();
        flag = flag1;
_L10:
        this;
        JVM INSTR monitorexit ;
        return flag;
        list;
        sqlitedatabase1 = sqlitedatabase;
        MAPLog.e(TAG, "Cannot set device data since it violated a uniqueness constraint");
        if (sqlitedatabase == null) goto _L8; else goto _L7
_L7:
        sqlitedatabase.endTransaction();
        mLocalDataStorageHelper.close();
          goto _L8
        list;
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        sqlitedatabase1.endTransaction();
        mLocalDataStorageHelper.close();
        throw list;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
_L4:
        flag = flag1;
        if (flag1) goto _L9; else goto _L2
_L8:
        flag = false;
          goto _L10
    }


}
