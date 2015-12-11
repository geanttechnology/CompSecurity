// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

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

public class PrimeUpsellDatabaseHelper extends DatabaseHelper
{

    private static final String TAG = com/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper.getSimpleName();
    private static PrimeUpsellDatabaseHelper sInstance = new PrimeUpsellDatabaseHelper();

    private PrimeUpsellDatabaseHelper()
    {
        super((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), "prime.db", 2);
    }

    public static PrimeUpsellDatabaseHelper getInstance()
    {
        return sInstance;
    }

    private Cursor getPrimeCounterInfo(String s)
    {
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        s = getUserIdFromName(s);
        return sqlitedatabase.query("primeUpsell", new String[] {
            "showedTimes", "errorRetryCount"
        }, "usernameHash =? ", new String[] {
            s
        }, null, null, null);
    }

    private String getUserIdFromName(String s)
    {
        return new String(Hex.encodeHex(DigestUtils.md5(s)));
    }

    public void clearDatabase()
    {
        if (DebugSettings.isDebugEnabled())
        {
            getWritableDatabase().delete("primeUpsell", null, null);
        }
    }

    public boolean notExceedMaxCount(String s, int i, int j)
    {
        boolean flag1;
        flag1 = false;
        s = getPrimeCounterInfo(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.getCount() <= 0) goto _L2; else goto _L3
_L3:
        int k;
        int l;
        s.moveToFirst();
        k = s.getInt(s.getColumnIndex("showedTimes"));
        l = s.getInt(s.getColumnIndex("errorRetryCount"));
        boolean flag;
        if (k < i && l < j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L7:
        flag1 = flag;
        if (s != null)
        {
            s.close();
            flag1 = flag;
        }
_L5:
        return flag1;
_L2:
        flag = true;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        AmazonErrorUtils.postExceptionToServer(mContext, ((Exception) (obj)));
        if (s == null) goto _L5; else goto _L4
_L4:
        s.close();
        return false;
        obj;
        if (s != null)
        {
            s.close();
        }
        throw obj;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        StringBuilder stringbuilder = new StringBuilder("CREATE TABLE primeUpsell(id INTEGER PRIMARY KEY AUTOINCREMENT ");
        stringbuilder.append(", usernameHash TEXT UNIQUE ").append(", showedTimes INTEGER DEFAULT 0 ").append(", errorRetryCount INTEGER DEFAULT 0").append(")");
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
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS primeUpsell");
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
        if (DebugSettings.isDebugEnabled())
        {
            Log.d(TAG, (new StringBuilder()).append("onUpgrade old: ").append(String.valueOf(i)).append(" new: ").append(String.valueOf(j)).toString());
        }
        if (i != 1 || j != 2)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        sqlitedatabase.execSQL("UPDATE primeUpsell SET showedTimes=0, errorRetryCount=0 ");
        return;
        sqlitedatabase;
        Log.d(TAG, sqlitedatabase.toString());
        return;
    }

    public void showedPrimeTo(String s, boolean flag)
    {
        Object obj;
        String s1;
        boolean flag2;
        boolean flag3;
        s1 = getUserIdFromName(s);
        ContentValues contentvalues;
        boolean flag1;
        int i;
        if (flag)
        {
            obj = "errorRetryCount";
        } else
        {
            obj = "showedTimes";
        }
        s = getPrimeCounterInfo(s);
        flag3 = false;
        flag2 = false;
        flag1 = flag2;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        i = s.getCount();
        flag1 = flag2;
        if (i > 0)
        {
            flag1 = true;
        }
        flag2 = flag1;
        if (s != null)
        {
            s.close();
            flag2 = flag1;
        }
_L3:
        s = getWritableDatabase();
        s.beginTransaction();
        if (flag2) goto _L2; else goto _L1
_L1:
        contentvalues = new ContentValues();
        contentvalues.put("usernameHash", s1);
        contentvalues.put(((String) (obj)), Integer.valueOf(1));
        s.insertOrThrow("primeUpsell", null, contentvalues);
        s.delete("primeUpsell", "id NOT IN (SELECT id FROM primeUpsell ORDER BY id DESC limit 10 )", null);
_L4:
        s.setTransactionSuccessful();
_L5:
        s.endTransaction();
        return;
        Exception exception;
        exception;
        AmazonErrorUtils.postExceptionToServer(mContext, exception);
        flag2 = flag3;
        if (s != null)
        {
            s.close();
            flag2 = flag3;
        }
          goto _L3
        obj;
        if (s != null)
        {
            s.close();
        }
        throw obj;
_L2:
        s.execSQL(String.format("UPDATE %1$s SET %2$s=%2$s+1 WHERE %3$s='%4$s'", new Object[] {
            "primeUpsell", obj, "usernameHash", s1
        }));
          goto _L4
        SQLException sqlexception;
        sqlexception;
        if (DebugSettings.isDebugEnabled())
        {
            Log.d(TAG, "showedPrimeTo user failed :");
            sqlexception.printStackTrace();
        }
        AmazonErrorUtils.postExceptionToServer(mContext, sqlexception);
          goto _L5
    }

}
