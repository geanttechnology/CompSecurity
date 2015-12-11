// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.Message;
import com.apptentive.android.sdk.model.MessageFactory;
import com.apptentive.android.sdk.model.Payload;
import com.apptentive.android.sdk.model.PayloadFactory;
import com.apptentive.android.sdk.model.StoredFile;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.apptentive.android.sdk.storage:
//            EventStore, FileStore, MessageStore, PayloadStore

public class ApptentiveDatabase extends SQLiteOpenHelper
    implements EventStore, FileStore, MessageStore, PayloadStore
{

    private static final String DATABASE_NAME = "apptentive";
    private static final int DATABASE_VERSION = 1;
    private static final int FALSE = 0;
    private static final String FILESTORE_KEY_APPTENTIVE_URL = "apptentive_uri";
    private static final String FILESTORE_KEY_ID = "id";
    private static final String FILESTORE_KEY_LOCAL_URL = "local_uri";
    private static final String FILESTORE_KEY_MIME_TYPE = "mime_type";
    private static final String FILESTORE_KEY_ORIGINAL_URL = "original_uri";
    private static final String MESSAGE_KEY_CLIENT_CREATED_AT = "client_created_at";
    private static final String MESSAGE_KEY_DB_ID = "_id";
    private static final String MESSAGE_KEY_ID = "id";
    private static final String MESSAGE_KEY_JSON = "json";
    private static final String MESSAGE_KEY_NONCE = "nonce";
    private static final String MESSAGE_KEY_READ = "read";
    private static final String MESSAGE_KEY_STATE = "state";
    private static final String PAYLOAD_KEY_BASE_TYPE = "base_type";
    private static final String PAYLOAD_KEY_DB_ID = "_id";
    private static final String PAYLOAD_KEY_JSON = "json";
    private static final String QUERY_MESSAGE_GET_ALL_IN_ORDER = "SELECT * FROM message ORDER BY COALESCE(id, 'z') ASC";
    private static final String QUERY_MESSAGE_GET_BY_NONCE = "SELECT * FROM message WHERE nonce = ?";
    private static final String QUERY_MESSAGE_GET_LAST_ID;
    private static final String QUERY_MESSAGE_UNREAD = "SELECT id FROM message WHERE read = 0 AND id NOTNULL";
    private static final String QUERY_PAYLOAD_GET_NEXT_TO_SEND = "SELECT * FROM payload ORDER BY _id ASC LIMIT 1";
    private static final String TABLE_CREATE_FILESTORE = "CREATE TABLE file_store (id TEXT PRIMARY KEY, mime_type TEXT, original_uri TEXT, local_uri TEXT, apptentive_uri TEXT);";
    private static final String TABLE_CREATE_MESSAGE = "CREATE TABLE message (_id INTEGER PRIMARY KEY, id TEXT, client_created_at DOUBLE, nonce TEXT, state TEXT, read INTEGER, json TEXT);";
    private static final String TABLE_CREATE_PAYLOAD = "CREATE TABLE payload (_id INTEGER PRIMARY KEY, base_type TEXT, json TEXT);";
    private static final String TABLE_FILESTORE = "file_store";
    private static final String TABLE_MESSAGE = "message";
    private static final String TABLE_PAYLOAD = "payload";
    private static final int TRUE = 1;
    private static ApptentiveDatabase instance;
    private boolean payloadsDirty;

    private ApptentiveDatabase(Context context)
    {
        super(context, "apptentive", null, 1);
        payloadsDirty = true;
    }

    public static void ensureClosed(Cursor cursor)
    {
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        cursor.close();
        return;
        cursor;
        Log.w("Error closing SQLite cursor.", cursor, new Object[0]);
        return;
    }

    public static void ensureClosed(SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        sqlitedatabase.close();
        return;
        sqlitedatabase;
        Log.w("Error closing SQLite database.", sqlitedatabase, new Object[0]);
        return;
    }

    public static ApptentiveDatabase getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new ApptentiveDatabase(context.getApplicationContext());
        }
        return instance;
    }

    public static void reset(Context context)
    {
        synchronized (instance)
        {
            context.deleteDatabase("apptentive");
            instance = null;
        }
        return;
        context;
        apptentivedatabase;
        JVM INSTR monitorexit ;
        throw context;
    }

    public transient void addOrUpdateMessages(Message amessage[])
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int k = amessage.length;
        int i = 0;
_L11:
        if (i >= k) goto _L2; else goto _L1
_L1:
        Message message = amessage[i];
        obj = sqlitedatabase.rawQuery("SELECT * FROM message WHERE nonce = ?", new String[] {
            message.getNonce()
        });
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        String s = ((Cursor) (obj)).getString(0);
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("id", message.getId());
        contentvalues1.put("state", message.getState().name());
        if (message.isRead())
        {
            contentvalues1.put("read", Integer.valueOf(1));
        }
        contentvalues1.put("json", message.toString());
        sqlitedatabase.update("message", contentvalues1, "_id = ?", new String[] {
            s
        });
_L5:
        ensureClosed(((Cursor) (obj)));
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        ContentValues contentvalues;
        sqlitedatabase.beginTransaction();
        contentvalues = new ContentValues();
        contentvalues.put("id", message.getId());
        contentvalues.put("client_created_at", message.getClientCreatedAt());
        contentvalues.put("nonce", message.getNonce());
        contentvalues.put("state", message.getState().name());
        int j;
        if (message.isRead())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        contentvalues.put("read", Integer.valueOf(j));
        contentvalues.put("json", message.toString());
        sqlitedatabase.insert("message", null, contentvalues);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
          goto _L5
        amessage;
_L9:
        ensureClosed(((Cursor) (obj)));
        throw amessage;
        amessage;
        obj = sqlitedatabase;
_L7:
        ensureClosed(((SQLiteDatabase) (obj)));
        throw amessage;
        amessage;
        this;
        JVM INSTR monitorexit ;
        throw amessage;
_L2:
        ensureClosed(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return;
        amessage;
        if (true) goto _L7; else goto _L6
_L6:
        amessage;
        obj = null;
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    public transient void addPayload(Payload apayload[])
    {
        SQLiteDatabase sqlitedatabase = null;
        this;
        JVM INSTR monitorenter ;
        payloadsDirty = true;
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        int j = apayload.length;
        int i = 0;
_L2:
        Payload payload;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        payload = apayload[i];
        sqlitedatabase = sqlitedatabase1;
        ContentValues contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("base_type", payload.getBaseType().name());
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("json", payload.toString());
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.insert("payload", null, contentvalues);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.endTransaction();
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return;
        apayload;
        ensureClosed(sqlitedatabase);
        throw apayload;
        apayload;
        this;
        JVM INSTR monitorexit ;
        throw apayload;
    }

    public void deleteAllMessages()
    {
        SQLiteDatabase sqlitedatabase = null;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("message", "", null);
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        ensureClosed(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void deleteAllPayloads()
    {
        SQLiteDatabase sqlitedatabase = null;
        this;
        JVM INSTR monitorenter ;
        payloadsDirty = true;
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("payload", "", null);
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        ensureClosed(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void deleteMessage(String s)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        Log.d("Deleted %d messages.", new Object[] {
            Integer.valueOf(sqlitedatabase1.delete("message", "nonce = ?", new String[] {
                s
            }))
        });
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        ensureClosed(sqlitedatabase);
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void deletePayload(Payload payload)
    {
        this;
        JVM INSTR monitorenter ;
        payloadsDirty = true;
        SQLiteDatabase sqlitedatabase;
        if (payload == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.delete("payload", "_id = ?", new String[] {
            Long.toString(payload.getDatabaseId())
        });
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return;
        payload;
        ensureClosed(sqlitedatabase);
        throw payload;
        payload;
        this;
        JVM INSTR monitorexit ;
        throw payload;
    }

    public void deleteStoredFile(String s)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        Log.d("Deleted %d stored files.", new Object[] {
            Integer.valueOf(sqlitedatabase1.delete("file_store", "id = ?", new String[] {
                s
            }))
        });
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        ensureClosed(sqlitedatabase);
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public List getAllMessages()
    {
        Object obj = null;
        Cursor cursor = null;
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList();
        Object obj1 = getReadableDatabase();
        obj = obj1;
        obj1 = ((SQLiteDatabase) (obj)).rawQuery("SELECT * FROM message ORDER BY COALESCE(id, 'z') ASC", null);
        cursor = ((Cursor) (obj1));
        if (!((Cursor) (obj1)).moveToFirst()) goto _L2; else goto _L1
_L1:
        cursor = ((Cursor) (obj1));
        String s = ((Cursor) (obj1)).getString(6);
        cursor = ((Cursor) (obj1));
        Message message = MessageFactory.fromJson(s);
        if (message != null) goto _L4; else goto _L3
_L3:
        cursor = ((Cursor) (obj1));
        Log.e("Error parsing Record json from database: %s", new Object[] {
            s
        });
_L5:
        cursor = ((Cursor) (obj1));
        boolean flag = ((Cursor) (obj1)).moveToNext();
        if (flag) goto _L1; else goto _L2
_L2:
        ensureClosed(((Cursor) (obj1)));
        ensureClosed(((SQLiteDatabase) (obj)));
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L4:
        cursor = ((Cursor) (obj1));
        message.setDatabaseId(((Cursor) (obj1)).getLong(0));
        cursor = ((Cursor) (obj1));
        message.setState(com.apptentive.android.sdk.model.Message.State.parse(((Cursor) (obj1)).getString(4)));
        cursor = ((Cursor) (obj1));
        Exception exception;
        Exception exception1;
        boolean flag1;
        if (((Cursor) (obj1)).getInt(5) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        cursor = ((Cursor) (obj1));
        message.setRead(flag1);
        cursor = ((Cursor) (obj1));
        arraylist.add(message);
          goto _L5
        exception1;
        obj1 = obj;
        obj = cursor;
        exception = exception1;
_L7:
        ensureClosed(((Cursor) (obj)));
        ensureClosed(((SQLiteDatabase) (obj1)));
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        obj1 = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public String getLastReceivedMessageId()
    {
        String s = null;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        Cursor cursor = sqlitedatabase.rawQuery(QUERY_MESSAGE_GET_LAST_ID, null);
        if (cursor.moveToFirst())
        {
            s = cursor.getString(0);
        }
        ensureClosed(cursor);
        ensureClosed(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        sqlitedatabase = null;
        cursor = null;
_L2:
        ensureClosed(cursor);
        ensureClosed(sqlitedatabase);
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        cursor = null;
        continue; /* Loop/switch isn't completed */
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Payload getOldestUnsentPayload()
    {
        Object obj = null;
        Cursor cursor = null;
        this;
        JVM INSTR monitorenter ;
        boolean flag = payloadsDirty;
        if (flag) goto _L2; else goto _L1
_L1:
        obj = cursor;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Payload) (obj));
_L2:
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        cursor = sqlitedatabase.rawQuery("SELECT * FROM payload ORDER BY _id ASC LIMIT 1", null);
        if (cursor.moveToFirst())
        {
            long l = Long.parseLong(cursor.getString(0));
            obj = com.apptentive.android.sdk.model.Payload.BaseType.parse(cursor.getString(1));
            obj = PayloadFactory.fromJson(cursor.getString(2), ((com.apptentive.android.sdk.model.Payload.BaseType) (obj)));
            ((Payload) (obj)).setDatabaseId(l);
        }
        payloadsDirty = false;
        ensureClosed(cursor);
        ensureClosed(sqlitedatabase);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        exception;
        sqlitedatabase = null;
        cursor = null;
_L6:
        ensureClosed(cursor);
        ensureClosed(sqlitedatabase);
        throw exception;
        exception;
        cursor = null;
        continue; /* Loop/switch isn't completed */
        exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public StoredFile getStoredFile(String s)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        Object obj;
        sqlitedatabase = getReadableDatabase();
        obj = sqlitedatabase.rawQuery("SELECT * FROM file_store WHERE id = ?", new String[] {
            s
        });
        Cursor cursor = ((Cursor) (obj));
        SQLiteDatabase sqlitedatabase1 = getReadableDatabase();
        cursor = ((Cursor) (obj));
        sqlitedatabase = sqlitedatabase1;
        Cursor cursor1 = sqlitedatabase1.rawQuery("SELECT * FROM file_store WHERE id = ?", new String[] {
            s
        });
        obj = null;
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        obj = new StoredFile();
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        ((StoredFile) (obj)).setId(s);
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        ((StoredFile) (obj)).setMimeType(cursor1.getString(1));
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        ((StoredFile) (obj)).setOriginalUri(cursor1.getString(2));
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        ((StoredFile) (obj)).setLocalFilePath(cursor1.getString(3));
        cursor = cursor1;
        sqlitedatabase = sqlitedatabase1;
        ((StoredFile) (obj)).setApptentiveUri(cursor1.getString(4));
        ensureClosed(cursor1);
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return ((StoredFile) (obj));
        s;
        ensureClosed(cursor);
        ensureClosed(sqlitedatabase);
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public int getUnreadMessageCount()
    {
        Cursor cursor1 = null;
        Cursor cursor = null;
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        cursor = cursor1;
        cursor1 = sqlitedatabase.rawQuery("SELECT id FROM message WHERE read = 0 AND id NOTNULL", null);
        cursor = cursor1;
        int i = cursor1.getCount();
        ensureClosed(cursor1);
        ensureClosed(sqlitedatabase);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception1;
        exception1;
        sqlitedatabase = null;
_L2:
        ensureClosed(cursor);
        ensureClosed(sqlitedatabase);
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        Log.d("ApptentiveDatabase.onCreate(db)", new Object[0]);
        sqlitedatabase.execSQL("CREATE TABLE payload (_id INTEGER PRIMARY KEY, base_type TEXT, json TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE message (_id INTEGER PRIMARY KEY, id TEXT, client_created_at DOUBLE, nonce TEXT, state TEXT, read INTEGER, json TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE file_store (id TEXT PRIMARY KEY, mime_type TEXT, original_uri TEXT, local_uri TEXT, apptentive_uri TEXT);");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Log.d("ApptentiveDatabase.onUpgrade(db, %d, %d)", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public boolean putStoredFile(StoredFile storedfile)
    {
        Object obj1 = null;
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Object obj = getWritableDatabase();
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("id", storedfile.getId());
        contentvalues.put("mime_type", storedfile.getMimeType());
        contentvalues.put("original_uri", storedfile.getOriginalUri());
        contentvalues.put("local_uri", storedfile.getLocalFilePath());
        contentvalues.put("apptentive_uri", storedfile.getApptentiveUri());
        obj1 = ((SQLiteDatabase) (obj)).rawQuery("SELECT * FROM file_store WHERE id = ?", new String[] {
            storedfile.getId()
        });
        int i;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_155;
        }
        i = ((SQLiteDatabase) (obj)).update("file_store", contentvalues, "id = ?", new String[] {
            storedfile.getId()
        });
        long l = i;
_L1:
        if (l == -1L)
        {
            flag = false;
        }
        ensureClosed(((Cursor) (obj1)));
        ensureClosed(((SQLiteDatabase) (obj)));
        this;
        JVM INSTR monitorexit ;
        return flag;
        l = ((SQLiteDatabase) (obj)).insert("file_store", null, contentvalues);
          goto _L1
        storedfile;
        obj = null;
_L3:
        ensureClosed(((Cursor) (obj)));
        ensureClosed(((SQLiteDatabase) (obj1)));
        throw storedfile;
        storedfile;
        this;
        JVM INSTR monitorexit ;
        throw storedfile;
        storedfile;
        Object obj2 = null;
        obj1 = obj;
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        storedfile;
        SQLiteDatabase sqlitedatabase = ((SQLiteDatabase) (obj));
        obj = obj1;
        obj1 = sqlitedatabase;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void updateMessage(Message message)
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = getWritableDatabase();
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.beginTransaction();
        sqlitedatabase = sqlitedatabase1;
        ContentValues contentvalues = new ContentValues();
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("id", message.getId());
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("client_created_at", message.getClientCreatedAt());
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("nonce", message.getNonce());
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("state", message.getState().name());
        sqlitedatabase = sqlitedatabase1;
        if (!message.isRead())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("read", Integer.valueOf(1));
        sqlitedatabase = sqlitedatabase1;
        contentvalues.put("json", message.toString());
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.update("message", contentvalues, "nonce = ?", new String[] {
            message.getNonce()
        });
        sqlitedatabase = sqlitedatabase1;
        sqlitedatabase1.setTransactionSuccessful();
        if (sqlitedatabase1 == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        sqlitedatabase1.endTransaction();
        ensureClosed(sqlitedatabase1);
        this;
        JVM INSTR monitorexit ;
        return;
        message;
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        sqlitedatabase.endTransaction();
        ensureClosed(sqlitedatabase);
        throw message;
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
    }

    static 
    {
        QUERY_MESSAGE_GET_LAST_ID = (new StringBuilder("SELECT id FROM message WHERE state = '")).append(com.apptentive.android.sdk.model.Message.State.saved).append("' AND id").append(" NOTNULL ORDER BY id").append(" DESC LIMIT 1").toString();
    }
}
