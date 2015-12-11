// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.google.analytics.tracking.android:
//            f, as, at, ax, 
//            an, am, al, g, 
//            m, p, s

final class ar
    implements f
{

    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] {
        "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"
    });
    private final at b;
    private volatile p c;
    private final g d;
    private final Context e;
    private final String f;
    private long g;
    private m h;

    ar(g g1, Context context)
    {
        this(g1, context, "google_analytics_v2.db");
    }

    private ar(g g1, Context context, String s1)
    {
        e = context.getApplicationContext();
        f = s1;
        d = g1;
        h = new as(this);
        b = new at(this, e, f);
        c = new ax(new DefaultHttpClient(), e);
        g = 0L;
    }

    private SQLiteDatabase a(String s1)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = b.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            an.d(s1);
            return null;
        }
        return sqlitedatabase;
    }

    static m a(ar ar1)
    {
        return ar1.h;
    }

    private static String a(Map map)
    {
        ArrayList arraylist = new ArrayList(map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add((new StringBuilder()).append(am.a((String)entry.getKey())).append("=").append(am.a((String)entry.getValue())).toString()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return TextUtils.join("&", arraylist);
    }

    private List a(int i)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            an.d("Invalid maxHits specified. Skipping");
            return arraylist;
        }
        obj = a("Error opening database for peekHitIds.");
        if (obj == null)
        {
            return arraylist;
        }
        Object obj1;
        obj1 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        String s1 = Integer.toString(i);
        obj1 = ((SQLiteDatabase) (obj)).query("hits2", new String[] {
            "hit_id"
        }, null, null, null, null, ((String) (obj1)), s1);
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst()) goto _L2; else goto _L1
_L1:
        obj = obj1;
        arraylist.add(String.valueOf(((Cursor) (obj1)).getLong(0)));
        obj = obj1;
        boolean flag = ((Cursor) (obj1)).moveToNext();
        if (flag) goto _L1; else goto _L2
_L2:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
_L3:
        return arraylist;
        SQLiteException sqliteexception;
        sqliteexception;
        obj1 = null;
_L6:
        obj = obj1;
        an.d((new StringBuilder("Error in peekHits fetching hitIds: ")).append(sqliteexception.getMessage()).toString());
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
          goto _L3
        Exception exception;
        exception;
        obj = null;
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L5; else goto _L4
_L4:
        sqliteexception;
          goto _L6
    }

    private void a(Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            an.d("Empty/Null collection passed to deleteHits.");
            return;
        }
        String as1[] = new String[collection.size()];
        collection = collection.iterator();
        for (int i = 0; collection.hasNext(); i++)
        {
            as1[i] = String.valueOf(((al)collection.next()).b);
        }

        a(as1);
    }

    private static void a(Map map, Collection collection)
    {
label0:
        {
            String s1 = "&_v".substring(1);
            if (collection == null)
            {
                break label0;
            }
            collection = collection.iterator();
            Command command;
            do
            {
                if (!collection.hasNext())
                {
                    break label0;
                }
                command = (Command)collection.next();
            } while (!"appendVersion".equals(command.a));
            map.put(s1, command.b);
        }
    }

    private void a(String as1[])
    {
        boolean flag = true;
        if (as1 != null && as1.length != 0) goto _L2; else goto _L1
_L1:
        an.d("Empty hitIds passed to deleteHits.");
_L4:
        return;
_L2:
        Object obj = a("Error opening database for deleteHits.");
        if (obj == null) goto _L4; else goto _L3
_L3:
        String s1 = String.format("HIT_ID in (%s)", new Object[] {
            TextUtils.join(",", Collections.nCopies(as1.length, "?"))
        });
        ((SQLiteDatabase) (obj)).delete("hits2", s1, as1);
        obj = d;
        SQLiteException sqliteexception;
        if (f() != 0)
        {
            flag = false;
        }
        ((g) (obj)).a(flag);
        return;
        sqliteexception;
        an.d((new StringBuilder("Error deleting hits ")).append(as1).toString());
        return;
    }

    static String b(ar ar1)
    {
        return ar1.f;
    }

    static Context c(ar ar1)
    {
        return ar1.e;
    }

    static String d()
    {
        return a;
    }

    private List e()
    {
        Object obj;
        Object obj1;
        Object obj4;
        obj = null;
        obj1 = new ArrayList();
        obj4 = a("Error opening database for peekHits");
        if (obj4 != null) goto _L2; else goto _L1
_L1:
        Object obj2 = obj1;
_L11:
        return ((List) (obj2));
_L2:
        obj2 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        String s1 = Integer.toString(40);
        obj2 = ((SQLiteDatabase) (obj4)).query("hits2", new String[] {
            "hit_id", "hit_time"
        }, null, null, null, null, ((String) (obj2)), s1);
        obj = obj2;
        Object obj3 = new ArrayList();
        boolean flag;
        if (((Cursor) (obj)).moveToFirst())
        {
            do
            {
                ((List) (obj3)).add(new al(((Cursor) (obj)).getLong(0), ((Cursor) (obj)).getLong(1)));
                flag = ((Cursor) (obj)).moveToNext();
            } while (flag);
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj1 = obj;
        obj2 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        obj1 = obj;
        String s2 = Integer.toString(40);
        obj1 = obj;
        obj2 = ((SQLiteDatabase) (obj4)).query("hits2", new String[] {
            "hit_id", "hit_string", "hit_url"
        }, null, null, null, null, ((String) (obj2)), s2);
        if (!((Cursor) (obj2)).moveToFirst()) goto _L4; else goto _L3
_L3:
        int i = 0;
_L19:
        if (((SQLiteCursor)obj2).getWindow().getNumRows() <= 0) goto _L6; else goto _L5
_L5:
        ((al)((List) (obj3)).get(i)).a = ((Cursor) (obj2)).getString(1);
        obj = (al)((List) (obj3)).get(i);
        obj1 = ((Cursor) (obj2)).getString(2);
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        if (!TextUtils.isEmpty(((String) (obj1)).trim())) goto _L9; else goto _L8
_L8:
        boolean flag1 = ((Cursor) (obj2)).moveToNext();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_634;
        }
_L4:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        return ((List) (obj3));
        obj2;
        obj3 = null;
        obj = obj1;
        obj1 = obj3;
_L18:
        an.d((new StringBuilder("Error in peekHits fetching hitIds: ")).append(((SQLiteException) (obj2)).getMessage()).toString());
        obj2 = obj;
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        ((Cursor) (obj1)).close();
        return ((List) (obj));
        obj2;
        obj1 = obj;
        obj = obj2;
_L17:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L9:
        if (!((String) (obj1)).toLowerCase().startsWith("http:")) goto _L8; else goto _L12
_L12:
        obj.d = "http:";
          goto _L8
        obj1;
        obj = obj2;
        obj2 = obj1;
_L16:
        obj1 = obj;
        an.d((new StringBuilder("Error in peekHits fetching hitString: ")).append(((SQLiteException) (obj2)).getMessage()).toString());
        obj1 = obj;
        obj2 = new ArrayList();
        obj1 = obj;
        obj3 = ((List) (obj3)).iterator();
        i = 0;
_L14:
        obj1 = obj;
        if (!((Iterator) (obj3)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj4 = (al)((Iterator) (obj3)).next();
        int j;
        j = i;
        obj1 = obj;
        if (TextUtils.isEmpty(((al) (obj4)).a))
        {
            if (i != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            j = 1;
        }
        obj1 = obj;
        ((List) (obj2)).add(obj4);
        i = j;
        if (true) goto _L14; else goto _L13
        obj;
_L15:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L6:
        an.d(String.format("HitString for hitId %d too large.  Hit will be deleted.", new Object[] {
            Long.valueOf(((al)((List) (obj3)).get(i)).b)
        }));
          goto _L8
        obj;
        obj1 = obj2;
          goto _L15
_L13:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj2));
        obj2;
          goto _L16
        obj2;
        obj1 = obj;
        obj = obj2;
          goto _L17
        obj;
          goto _L17
        obj2;
        obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L18
        obj2;
        obj1 = obj;
        obj = obj3;
          goto _L18
        i++;
          goto _L19
    }

    private int f()
    {
        Cursor cursor;
        Object obj;
        Object obj1;
        int i;
        int j;
        obj = null;
        cursor = null;
        i = 0;
        j = 0;
        obj1 = a("Error opening database for getNumStoredHits.");
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        obj1 = ((SQLiteDatabase) (obj1)).rawQuery("SELECT COUNT(*) from hits2", null);
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        cursor = ((Cursor) (obj1));
        obj = obj1;
        long l = ((Cursor) (obj1)).getLong(0);
        i = (int)l;
        j = i;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
            return i;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        obj = cursor;
        an.d("Error getting numStoredHits");
        if (cursor == null) goto _L1; else goto _L4
_L4:
        cursor.close();
        return 0;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
    }

    public final void a()
    {
        boolean flag = true;
        Object obj = a("Error opening database for clearHits");
        if (obj != null)
        {
            if (0L == 0L)
            {
                ((SQLiteDatabase) (obj)).delete("hits2", null, null);
            } else
            {
                ((SQLiteDatabase) (obj)).delete("hits2", "hit_app_id = ?", new String[] {
                    Long.valueOf(0L).toString()
                });
            }
            obj = d;
            if (f() != 0)
            {
                flag = false;
            }
            ((g) (obj)).a(flag);
        }
    }

    public final void a(Map map, long l, String s1, Collection collection)
    {
        Object obj;
        boolean flag = true;
        long l1 = h.a();
        if (l1 > g + 0x5265c00L)
        {
            g = l1;
            obj = a("Error opening database for deleteStaleHits.");
            if (obj != null)
            {
                ((SQLiteDatabase) (obj)).delete("hits2", "HIT_TIME < ?", new String[] {
                    Long.toString(h.a() - 0x9a7ec800L)
                });
                obj = d;
                int i;
                if (f() != 0)
                {
                    flag = false;
                }
                ((g) (obj)).a(flag);
            }
        }
        i = (f() - 2000) + 1;
        if (i > 0)
        {
            obj = a(i);
            an.c((new StringBuilder("Store full, deleting ")).append(((List) (obj)).size()).append(" hits to make room.").toString());
            a((String[])((List) (obj)).toArray(new String[0]));
        }
        a(map, collection);
        collection = a("Error opening database for putHit");
        if (collection == null) goto _L2; else goto _L1
_L1:
        obj = new ContentValues();
        ((ContentValues) (obj)).put("hit_string", a(map));
        ((ContentValues) (obj)).put("hit_time", Long.valueOf(l));
        if (!map.containsKey("AppUID")) goto _L4; else goto _L3
_L3:
        l = Long.parseLong((String)map.get("AppUID"));
_L6:
        ((ContentValues) (obj)).put("hit_app_id", Long.valueOf(l));
        map = s1;
        if (s1 == null)
        {
            map = "http://www.google-analytics.com/collect";
        }
        if (map.length() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        an.d("Empty path: not sending hit");
_L2:
        return;
        map;
_L4:
        l = 0L;
        if (true) goto _L6; else goto _L5
_L5:
        ((ContentValues) (obj)).put("hit_url", map);
        try
        {
            collection.insert("hits2", null, ((ContentValues) (obj)));
            d.a(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            an.d("Error storing hit");
        }
        return;
    }

    public final void b()
    {
        an.c("Dispatch running...");
        if (c.a())
        {
            List list = e();
            if (list.isEmpty())
            {
                an.c("...nothing to dispatch");
                d.a(true);
                return;
            }
            int i = c.a(list);
            an.c((new StringBuilder("sent ")).append(i).append(" of ").append(list.size()).append(" hits").toString());
            a(list.subList(0, Math.min(i, list.size())));
            if (i == list.size() && f() > 0)
            {
                s.a().c();
                return;
            }
        }
    }

    public final p c()
    {
        return c;
    }

}
