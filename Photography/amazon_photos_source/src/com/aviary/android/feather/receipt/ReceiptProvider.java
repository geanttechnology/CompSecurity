// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import com.aviary.android.feather.common.log.LoggerFactory;
import java.nio.charset.Charset;
import org.json.JSONObject;

public class ReceiptProvider
{
    private static final class DatabaseHelper extends SQLiteOpenHelper
    {

        private static final String DATABASE_NAME = "receipts";
        private static final int DATABASE_VERSION = 1;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            ReceiptProvider.logger.info("onCreate");
            ReceiptProvider.logger.log("CREATE TABLE IF NOT EXISTS receipts_table( r_id INTEGER PRIMARY KEY AUTOINCREMENT, r_json BLOB NOT NULL, r_is_free INTEGER NOT NULL DEFAULT 1 )");
            ReceiptProvider.logger.log("CREATE TABLE IF NOT EXISTS uploads_table( u_id INTEGER PRIMARY KEY AUTOINCREMENT, u_receipt_id INTEGER NOT NULL UNIQUE, u_response_status INTEGER NOT NULL, u_fail_count INTEGER NOT NULL DEFAULT 1, FOREIGN KEY(u_receipt_id) REFERENCES receipts_table(r_id) ON DELETE CASCADE);");
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS receipts_table( r_id INTEGER PRIMARY KEY AUTOINCREMENT, r_json BLOB NOT NULL, r_is_free INTEGER NOT NULL DEFAULT 1 )");
            sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS uploads_table( u_id INTEGER PRIMARY KEY AUTOINCREMENT, u_receipt_id INTEGER NOT NULL UNIQUE, u_response_status INTEGER NOT NULL, u_fail_count INTEGER NOT NULL DEFAULT 1, FOREIGN KEY(u_receipt_id) REFERENCES receipts_table(r_id) ON DELETE CASCADE);");
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            super.onOpen(sqlitedatabase);
            ReceiptProvider.logger.info("onOpen");
            if (!sqlitedatabase.isReadOnly())
            {
                ReceiptProvider.logger.info("onConfigure");
                sqlitedatabase.execSQL("PRAGMA foreign_keys = ON;");
                sqlitedatabase.execSQL("PRAGMA encoding=\"UTF-8\";");
            }
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            ReceiptProvider.logger.info("onUpgrade");
        }

        public DatabaseHelper(Context context)
        {
            super(context, "receipts", null, 1);
        }
    }

    static class ReceiptColumns
        implements BaseColumns
    {

        static final String ITEM_IS_FREE = "r_is_free";
        static final String ITEM_JSON = "r_json";
        static final String RECEIPT_ID = "r_id";
        static final String TABLE_NAME = "receipts_table";
        static final String TABLE_SQL = "CREATE TABLE IF NOT EXISTS receipts_table( r_id INTEGER PRIMARY KEY AUTOINCREMENT, r_json BLOB NOT NULL, r_is_free INTEGER NOT NULL DEFAULT 1 )";

        ReceiptColumns()
        {
        }
    }

    static class UploadedColumns
        implements BaseColumns
    {

        static final String FAIL_COUNT = "u_fail_count";
        static final String RECEIPT_ID = "u_receipt_id";
        static final String RESPONSE_STATUS = "u_response_status";
        static final String TABLE_NAME = "uploads_table";
        static final String TABLE_SQL = "CREATE TABLE IF NOT EXISTS uploads_table( u_id INTEGER PRIMARY KEY AUTOINCREMENT, u_receipt_id INTEGER NOT NULL UNIQUE, u_response_status INTEGER NOT NULL, u_fail_count INTEGER NOT NULL DEFAULT 1, FOREIGN KEY(u_receipt_id) REFERENCES receipts_table(r_id) ON DELETE CASCADE);";
        static final String UPLOAD_ID = "u_id";

        UploadedColumns()
        {
        }
    }


    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private static ReceiptProvider sInstance;
    private Context mContext;
    private SQLiteDatabase mDb;

    public ReceiptProvider(Context context)
    {
        try
        {
            mDb = (new DatabaseHelper(context)).getWritableDatabase();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        logger.error("cannot open the database!!!!");
    }

    public static ReceiptProvider getInstance(Context context)
    {
        if (sInstance != null) goto _L2; else goto _L1
_L1:
        com/aviary/android/feather/receipt/ReceiptProvider;
        JVM INSTR monitorenter ;
        if (sInstance != null) goto _L4; else goto _L3
_L3:
        com/aviary/android/feather/receipt/ReceiptProvider;
        JVM INSTR monitorenter ;
        sInstance = new ReceiptProvider(context);
        com/aviary/android/feather/receipt/ReceiptProvider;
        JVM INSTR monitorexit ;
_L4:
        com/aviary/android/feather/receipt/ReceiptProvider;
        JVM INSTR monitorexit ;
_L2:
        return sInstance;
        context;
        com/aviary/android/feather/receipt/ReceiptProvider;
        JVM INSTR monitorexit ;
        throw context;
        context;
        com/aviary/android/feather/receipt/ReceiptProvider;
        JVM INSTR monitorexit ;
        throw context;
    }

    public long addTicket(JSONObject jsonobject, boolean flag)
    {
        int i = 1;
        if (mDb == null)
        {
            return -1L;
        }
        logger.info("addTicket: %s", new Object[] {
            jsonobject
        });
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("r_json", jsonobject.toString().getBytes(Charset.forName("UTF-8")));
        if (!flag)
        {
            i = 0;
        }
        contentvalues.put("r_is_free", Integer.valueOf(i));
        return mDb.insert("receipts_table", null, contentvalues);
    }

    public int delete(String s, String s1, String as[])
    {
        if (mDb == null)
        {
            return 0;
        } else
        {
            return mDb.delete(s, s1, as);
        }
    }

    public Cursor getFailedReceipts()
    {
        if (mDb == null)
        {
            return null;
        } else
        {
            SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
            sqlitequerybuilder.setTables("receipts_table INNER JOIN uploads_table ON (r_id=u_receipt_id)");
            return sqlitequerybuilder.query(mDb, null, null, null, null, null, "u_response_status DESC, r_id DESC");
        }
    }

    public Cursor getNewReceipts()
    {
        if (mDb == null)
        {
            return null;
        } else
        {
            SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
            sqlitequerybuilder.setTables("receipts_table LEFT JOIN uploads_table ON (r_id=u_receipt_id)");
            sqlitequerybuilder.appendWhere("IFNULL(u_receipt_id, 0) = 0");
            return sqlitequerybuilder.query(mDb, null, null, null, null, null, "r_id ASC");
        }
    }

    public long insert(String s, String s1, ContentValues contentvalues, int i)
    {
        if (mDb == null)
        {
            return -1L;
        } else
        {
            return mDb.insertWithOnConflict(s, s1, contentvalues, i);
        }
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4)
    {
        if (mDb == null)
        {
            return null;
        } else
        {
            SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
            sqlitequerybuilder.setTables(s);
            return sqlitequerybuilder.query(mDb, as, s1, as1, s2, s3, s4);
        }
    }

    static 
    {
        logger = LoggerFactory.getLogger(com/aviary/android/feather/receipt/ReceiptProvider.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
