// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.util.CrashUtil;
import java.util.HashMap;

public class VineUploadDatabaseHelper extends SQLiteOpenHelper
{

    public static final int DATABASE_VERSION = 4;
    private static final String DB_NAME = "upload";
    public static final int SCHEMA_VERSION = 1;
    private static final String SEPARATOR = "-";
    private static final HashMap sHelperMap = new HashMap();
    private final Context mAppContext;

    private VineUploadDatabaseHelper(Context context, String s)
    {
        super(context, s, null, 4);
        mAppContext = context.getApplicationContext();
    }

    public static VineUploadDatabaseHelper getDatabaseHelper(Context context)
    {
        co/vine/android/provider/VineUploadDatabaseHelper;
        JVM INSTR monitorenter ;
        VineUploadDatabaseHelper vineuploaddatabasehelper1;
        String s;
        s = getDatabaseName(1);
        vineuploaddatabasehelper1 = (VineUploadDatabaseHelper)sHelperMap.get(s);
        VineUploadDatabaseHelper vineuploaddatabasehelper;
        vineuploaddatabasehelper = vineuploaddatabasehelper1;
        if (vineuploaddatabasehelper1 != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        vineuploaddatabasehelper = new VineUploadDatabaseHelper(context.getApplicationContext(), s);
        sHelperMap.put(s, vineuploaddatabasehelper);
        co/vine/android/provider/VineUploadDatabaseHelper;
        JVM INSTR monitorexit ;
        return vineuploaddatabasehelper;
        context;
        throw context;
    }

    public static String getDatabaseName(int i)
    {
        return (new StringBuilder()).append("upload-").append(i).toString();
    }

    protected void createTables(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE  IF NOT EXISTS uploads (_id INTEGER PRIMARY KEY,path TEXT,hash TEXT,status INT,post_info TEXT,video_url TEXT,thumbnail_path TEXT,thumbnail_url TEXT,upload_time TEXT,is_private INT,conversation_row_id INT,reference TEXT,owner_id INT,captcha_url TEXT, max_loops INT, message_row INT);");
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        createTables(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        j = i;
        i = j;
        if (j == 1)
        {
            try
            {
                sqlitedatabase.execSQL("ALTER TABLE uploads ADD COLUMN reference TEXT;");
                sqlitedatabase.execSQL("ALTER TABLE uploads ADD COLUMN owner_id INT;");
                sqlitedatabase.execSQL("UPDATE uploads SET status=2 WHERE (status=0 OR status=1);");
                long l = AppController.getInstance(mAppContext).getActiveSessionReadOnly().getUserId();
                sqlitedatabase.execSQL((new StringBuilder()).append("UPDATE uploads SET owner_id=").append(l).append(";").toString());
            }
            catch (SQLiteException sqliteexception)
            {
                CrashUtil.logException(sqliteexception);
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS uploads;");
                sqlitedatabase.execSQL("CREATE TABLE  IF NOT EXISTS uploads (_id INTEGER PRIMARY KEY,path TEXT,hash TEXT,status INT,post_info TEXT,video_url TEXT,thumbnail_path TEXT,thumbnail_url TEXT,upload_time TEXT,is_private INT,conversation_row_id INT,reference TEXT,owner_id INT,captcha_url TEXT, max_loops INT, message_row INT);");
                return;
            }
            i = 2;
        }
        j = i;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        sqlitedatabase.execSQL("ALTER TABLE uploads ADD COLUMN captcha_url TEXT;");
        j = 3;
        if (j != 3)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        sqlitedatabase.execSQL("ALTER TABLE uploads ADD COLUMN is_private INT;");
        sqlitedatabase.execSQL("ALTER TABLE uploads ADD COLUMN conversation_row_id INT;");
        sqlitedatabase.execSQL("ALTER TABLE uploads ADD COLUMN max_loops INT;");
        sqlitedatabase.execSQL("ALTER TABLE uploads ADD COLUMN message_row INT;");
    }

}
