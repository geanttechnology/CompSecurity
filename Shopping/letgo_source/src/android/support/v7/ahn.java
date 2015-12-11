// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ahm, ahk

class ahn
{
    private static class a extends SQLiteOpenHelper
    {

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL("CREATE TABLE TRACK_EVENTS (id INTEGER PRIMARY KEY AUTOINCREMENT, created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,url TEXT NOT NULL,type TEXT NOT NULL,name TEXT,attempt INTEGER DEFAULT 0)");
        }

        public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            onUpgrade(sqlitedatabase, i, j);
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS TRACK_EVENTS");
            onCreate(sqlitedatabase);
        }

        public a(Context context)
        {
            super(context, "Nanigans.db", null, 1);
        }
    }

    private static class b
    {

        private final String a;
        private final String b[];

        static String a(b b1)
        {
            return b1.a;
        }

        static String[] b(b b1)
        {
            return b1.b;
        }

        private b(String s, String as[])
        {
            a = s;
            b = as;
        }

    }


    private static final String a[] = {
        "id", "url", "attempt", "type", "name"
    };

    public static ahm a(Context context)
    {
        Object obj1 = null;
        context = (new a(context)).getReadableDatabase();
        if (context != null) goto _L2; else goto _L1
_L1:
        throw new IllegalArgumentException("Could not instantiate DB?!");
        Exception exception;
        exception;
        Object obj;
        obj = context;
        context = exception;
_L8:
        if (obj1 != null && !((Cursor) (obj1)).isClosed())
        {
            ((Cursor) (obj1)).close();
        }
        if (obj != null)
        {
            ((SQLiteDatabase) (obj)).close();
        }
        throw context;
_L2:
        Cursor cursor = context.query("TRACK_EVENTS", a, null, null, null, null, "created DESC");
        boolean flag = cursor.moveToNext();
        if (flag) goto _L4; else goto _L3
_L3:
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        if (context != null)
        {
            context.close();
        }
        obj = null;
_L6:
        return ((ahm) (obj));
_L4:
        obj1 = new ahm(cursor.getInt(cursor.getColumnIndexOrThrow("id")), aho.a.valueOf(cursor.getString(cursor.getColumnIndexOrThrow("type"))), cursor.getString(cursor.getColumnIndexOrThrow("name")), cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getInt(cursor.getColumnIndexOrThrow("attempt")));
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        obj = obj1;
        if (context == null) goto _L6; else goto _L5
_L5:
        context.close();
        return ((ahm) (obj1));
        context;
        obj = null;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        obj = context;
        context = exception1;
        exception1 = cursor;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static b a(List list)
    {
        String as[] = new String[list.size()];
        StringBuilder stringbuilder = new StringBuilder("id");
        stringbuilder.append(" IN (");
        for (int i = 0; i < list.size(); i++)
        {
            if (i != 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append("?");
            as[i] = Integer.toString(((ahm)list.get(i)).a);
        }

        stringbuilder.append(")");
        return new b(stringbuilder.toString(), as);
    }

    public static void a(Context context, ahm ahm1)
    {
        Object obj;
        String s;
        Object obj1;
        obj1 = null;
        s = null;
        obj = null;
        SQLiteDatabase sqlitedatabase = (new a(context)).getReadableDatabase();
        if (sqlitedatabase != null) goto _L2; else goto _L1
_L1:
        throw new IllegalArgumentException("Could not instantiate DB?!");
        context;
        ahm1 = sqlitedatabase;
_L11:
        if (ahm1 != null)
        {
            ahm1.close();
        }
        throw context;
_L2:
        context = new ContentValues();
        context.put("type", ahm1.e.toString());
        if (ahm1.d != null)
        {
            context.put("name", ahm1.d);
        }
        context.put("url", ahm1.c);
        ahm1.a = (int)sqlitedatabase.insert("TRACK_EVENTS", null, context);
        context = obj1;
        ahm1 = s;
        obj = sqlitedatabase.rawQuery("select count(*) from TRACK_EVENTS", new String[0]);
        context = ((Context) (obj));
        ahm1 = ((ahm) (obj));
        if (((Cursor) (obj)).moveToNext()) goto _L4; else goto _L3
_L3:
        context = ((Context) (obj));
        ahm1 = ((ahm) (obj));
        ahk.a().a("move to next returns false for count?", null);
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        if (!((Cursor) (obj)).isClosed())
        {
            ((Cursor) (obj)).close();
        }
_L8:
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return;
_L4:
        context = ((Context) (obj));
        ahm1 = ((ahm) (obj));
        int i = ((Cursor) (obj)).getInt(0);
        if (i <= 100) goto _L6; else goto _L5
_L5:
        context = ((Context) (obj));
        ahm1 = ((ahm) (obj));
        s = (new StringBuilder()).append("id in (select id from TRACK_EVENTS order by created limit ").append(i - 100).append(")").toString();
        context = ((Context) (obj));
        ahm1 = ((ahm) (obj));
        ahk.a().b("Exceeded max queue depth (100) trimming", null);
        context = ((Context) (obj));
        ahm1 = ((ahm) (obj));
        sqlitedatabase.delete("TRACK_EVENTS", s, new String[0]);
          goto _L6
        obj;
        ahm1 = context;
        ahk.a().a("error attempting to trim queue", ((Throwable) (obj)));
        if (context == null) goto _L8; else goto _L7
_L7:
        if (context.isClosed()) goto _L8; else goto _L9
_L9:
        context.close();
          goto _L8
        context;
        if (ahm1 == null)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        if (!ahm1.isClosed())
        {
            ahm1.close();
        }
        throw context;
        context;
        ahm1 = ((ahm) (obj));
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static void a(Context context, List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Context context1 = null;
        context = (new a(context)).getReadableDatabase();
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        context1 = context;
        throw new IllegalArgumentException("Could not instantiate DB?!");
        context;
        if (context1 != null)
        {
            context1.close();
        }
        throw context;
        context1 = context;
        list = a(list);
        context1 = context;
        context.delete("TRACK_EVENTS", b.a(list), b.b(list));
        if (context != null)
        {
            context.close();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static int b(Context context, List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        return i;
_L2:
        Context context1 = null;
        context = (new a(context)).getReadableDatabase();
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        context1 = context;
        throw new IllegalArgumentException("Could not instantiate DB?!");
        context;
        if (context1 != null)
        {
            context1.close();
        }
        throw context;
        context1 = context;
        ContentValues contentvalues = new ContentValues();
        context1 = context;
        Iterator iterator = list.iterator();
_L4:
        context1 = context;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        context1 = context;
        contentvalues.put("attempt", Integer.valueOf(((ahm)iterator.next()).b + 1));
        if (true) goto _L4; else goto _L3
_L3:
        context1 = context;
        list = a(list);
        context1 = context;
        int j = context.update("TRACK_EVENTS", contentvalues, b.a(list), b.b(list));
        i = j;
        if (context != null)
        {
            context.close();
            return j;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

}
