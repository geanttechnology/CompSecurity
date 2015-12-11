// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.DatabaseHelper;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class SocialConnectDatabaseHelper extends DatabaseHelper
{

    private static final String TAG = com/amazon/mShop/social/SocialConnectDatabaseHelper.getSimpleName();
    private static SocialConnectDatabaseHelper sInstance = new SocialConnectDatabaseHelper();

    private SocialConnectDatabaseHelper()
    {
        super((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), "social.db", 1);
    }

    public static SocialConnectDatabaseHelper getInstance()
    {
        return sInstance;
    }

    private String getSecureId(String s)
    {
        return new String(Hex.encodeHex(DigestUtils.md5(s)));
    }

    private Cursor getSocialCursorInfo(String s)
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        s = getSecureId(s);
        return sqlitedatabase.query("socialConnect", new String[] {
            "showedTimes", "lastShown", "doNotShowAgain"
        }, "currentAccountHash =? ", new String[] {
            s
        }, null, null, null);
    }

    public void clearDatabase()
    {
        if (DebugSettings.isDebugEnabled())
        {
            getWritableDatabase().delete("socialConnect", null, null);
        }
    }

    public boolean getDoNotShowAgain(String s)
    {
        int i;
        s = getSocialCursorInfo(s);
        i = 0;
        boolean flag = false;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        i = ((flag) ? 1 : 0);
        if (s.moveToFirst())
        {
            i = s.getInt(s.getColumnIndex("doNotShowAgain"));
        }
        s.close();
        Exception exception;
        return i == 1;
        exception;
        s.close();
        throw exception;
    }

    public String getLastShown(String s)
    {
        String s1;
        Cursor cursor;
        cursor = getSocialCursorInfo(s);
        s = "never";
        s1 = s;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (cursor.moveToFirst())
        {
            s = cursor.getString(cursor.getColumnIndex("lastShown"));
        }
        cursor.close();
        s1 = s;
        return s1;
        s;
        cursor.close();
        throw s;
    }

    public int getNumberTimesShown(String s)
    {
        int i;
        s = getSocialCursorInfo(s);
        i = 0;
        boolean flag = false;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        i = ((flag) ? 1 : 0);
        if (s.moveToFirst())
        {
            i = s.getInt(s.getColumnIndex("showedTimes"));
        }
        s.close();
        return i;
        Exception exception;
        exception;
        s.close();
        throw exception;
    }

    public void increaseDisplayCounter(String s)
    {
        Object obj;
        boolean flag;
        boolean flag1;
        boolean flag2;
        obj = getSecureId(s);
        s = getSocialCursorInfo(s);
        flag2 = false;
        flag1 = false;
        flag = flag1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        int i = s.getCount();
        flag = flag1;
        if (i > 0)
        {
            flag = true;
        }
        flag1 = flag;
        if (s != null)
        {
            s.close();
            flag1 = flag;
        }
_L3:
        s = getWritableDatabase();
        s.beginTransaction();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("currentAccountHash", ((String) (obj)));
        contentvalues.put("showedTimes", Integer.valueOf(1));
        s.insertOrThrow("socialConnect", null, contentvalues);
        s.delete("socialConnect", "id NOT IN (SELECT id FROM socialConnect ORDER BY id DESC limit 10 )", null);
_L1:
        s.setTransactionSuccessful();
        s.endTransaction();
        return;
        Exception exception;
        exception;
        AmazonErrorUtils.postExceptionToServer(mContext, exception);
        flag1 = flag2;
        if (s != null)
        {
            s.close();
            flag1 = flag2;
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (s != null)
        {
            s.close();
        }
        throw obj;
        s.execSQL(String.format("UPDATE %1$s SET %2$s=%2$s+1 WHERE %3$s='%4$s'", new Object[] {
            "socialConnect", "showedTimes", "currentAccountHash", obj
        }));
          goto _L1
        Object obj1;
        obj1;
        if (DebugSettings.isDebugEnabled())
        {
            Log.d(TAG, "incrementDisplayCounter user failed :");
            ((SQLException) (obj1)).printStackTrace();
        }
        AmazonErrorUtils.postExceptionToServer(mContext, ((Exception) (obj1)));
        s.endTransaction();
        return;
        obj1;
        s.endTransaction();
        throw obj1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void markDoNotShowAgain(String s)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        s = getSecureId(s);
        sqlitedatabase.beginTransaction();
        try
        {
            sqlitedatabase.execSQL(String.format("UPDATE %1$s SET %2$s=%3$d WHERE %4$s='%5$s'", new Object[] {
                "socialConnect", "doNotShowAgain", Integer.valueOf(1), "currentAccountHash", s
            }));
            sqlitedatabase.setTransactionSuccessful();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (DebugSettings.isDebugEnabled())
            {
                Log.d(TAG, "markDoNotShowAgain user failed :");
                s.printStackTrace();
            }
            AmazonErrorUtils.postExceptionToServer(mContext, s);
        }
        sqlitedatabase.endTransaction();
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        StringBuilder stringbuilder = new StringBuilder("CREATE TABLE socialConnect(id INTEGER PRIMARY KEY AUTOINCREMENT ");
        stringbuilder.append(", currentAccountHash TEXT UNIQUE ").append(", showedTimes INTEGER DEFAULT 0 ").append(", lastShown TEXT ").append(", doNotShowAgain INTEGER DEFAULT 0 ").append(")");
        sqlitedatabase.execSQL(stringbuilder.toString());
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (DebugSettings.isDebugEnabled())
        {
            Log.d(TAG, (new StringBuilder()).append("onDowngrade old: ").append(String.valueOf(i)).append(" new: ").append(String.valueOf(j)).toString());
        }
        try
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS socialConnect");
            onCreate(sqlitedatabase);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            Log.d(TAG, sqlitedatabase.toString());
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    public void recordInteraction(String s, long l, boolean flag)
    {
        increaseDisplayCounter(s);
        updateLastShown(s, l);
        if (flag)
        {
            markDoNotShowAgain(s);
        }
    }

    public void updateLastShown(String s, long l)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        s = getSecureId(s);
        sqlitedatabase.beginTransaction();
        try
        {
            sqlitedatabase.execSQL(String.format("UPDATE %1$s SET %2$s=%3$d WHERE %4$s='%5$s'", new Object[] {
                "socialConnect", "lastShown", Long.valueOf(l), "currentAccountHash", s
            }));
            sqlitedatabase.setTransactionSuccessful();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (DebugSettings.isDebugEnabled())
            {
                Log.d(TAG, "updateLastShown user failed :");
                s.printStackTrace();
            }
            AmazonErrorUtils.postExceptionToServer(mContext, s);
        }
        sqlitedatabase.endTransaction();
    }

}
