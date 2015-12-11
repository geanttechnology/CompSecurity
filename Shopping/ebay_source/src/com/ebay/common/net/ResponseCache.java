// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ResponseCache
{
    private static class RequestCacheDao
    {

        private static final String EXPIRATION = "expiration";
        private static final String NAME = "name";
        private static final String RESPONSE = "response";
        private static final String TABLE = "responses";
        private SQLiteDatabase db;

        private void close()
        {
            if (db == null)
            {
                return;
            }
            try
            {
                db.close();
                return;
            }
            catch (SQLException sqlexception)
            {
                Log.e("ResponseCache", sqlexception.toString());
            }
        }

        public void deleteExpiredResponses()
        {
            if (db == null)
            {
                return;
            } else
            {
                String s = (new StringBuilder()).append("").append(System.currentTimeMillis()).toString();
                int i = db.delete("responses", "expiration<?", new String[] {
                    s
                });
                Log.d(com/ebay/common/net/ResponseCache.getSimpleName(), (new StringBuilder()).append("Removed ").append(i).append(" cached responses").toString());
                return;
            }
        }

        public String getResponse(String s)
        {
            if (db == null)
            {
                return null;
            }
            Cursor cursor = db.query("responses", new String[] {
                "response", "expiration"
            }, "name=?", new String[] {
                s
            }, null, null, null);
            Object obj = null;
            s = obj;
            if (cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                s = obj;
                if (cursor.getLong(1) > System.currentTimeMillis())
                {
                    s = cursor.getString(0);
                }
            }
            cursor.close();
            return s;
        }

        public void setResponse(String s, String s1, long l)
        {
            if (db == null)
            {
                return;
            }
            String as[] = new String[1];
            as[0] = s;
            Object obj = db.query("responses", new String[0], "name=?", as, null, null, null);
            boolean flag;
            if (((Cursor) (obj)).getCount() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Cursor) (obj)).close();
            obj = new ContentValues();
            ((ContentValues) (obj)).put("name", s);
            ((ContentValues) (obj)).put("response", s1);
            ((ContentValues) (obj)).put("expiration", Long.valueOf(System.currentTimeMillis() + l));
            if (flag)
            {
                db.insert("responses", null, ((ContentValues) (obj)));
                return;
            } else
            {
                db.update("responses", ((ContentValues) (obj)), "name=?", as);
                return;
            }
        }


        private RequestCacheDao(Context context)
        {
            db = null;
            try
            {
                db = (new ResponseDbHelper(context)).getWritableDatabase();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e("ResponseCache", context.toString());
            }
        }

    }

    private static class ResponseDbHelper extends SQLiteOpenHelper
    {

        public static final String DB_NAME = "responses_db";
        public static final int DB_VERSION = 1;

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            try
            {
                sqlitedatabase.execSQL("CREATE TABLE responses( id INTEGER PRIMARY KEY, name TEXT NOT NULL, response TEXT NOT NULL, expiration DATETIME)");
                sqlitedatabase.execSQL("CREATE INDEX responses_name ON responses (name)");
                sqlitedatabase.execSQL("CREATE INDEX responses_expiration ON responses (expiration)");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                Log.e("ResponseCache", sqlitedatabase.toString());
            }
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            throw new UnsupportedOperationException();
        }

        public ResponseDbHelper(Context context)
        {
            super(context, "responses_db", null, 1);
        }
    }


    public static final long EXPIRATION_ONE_DAY = 0x5265c00L;
    public static final long EXPIRATION_SIXTY_DAY = 0x134fd9000L;
    private static final String TAG = "ResponseCache";
    private static boolean initialize = true;

    private ResponseCache()
    {
    }

    public static String getResponse(Context context, String s)
    {
        context = new RequestCacheDao(context);
        try
        {
            if (initialize)
            {
                initialize = false;
                context.deleteExpiredResponses();
            }
            s = context.getResponse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            context.close();
            return null;
        }
        finally
        {
            context.close();
        }
        context.close();
        return s;
        throw s;
    }

    public static void setResponse(Context context, String s, byte abyte0[], long l)
    {
        context = new RequestCacheDao(context);
        context.setResponse(s, new String(abyte0), l);
        context.close();
        return;
        s;
        context.close();
        throw s;
    }

}
