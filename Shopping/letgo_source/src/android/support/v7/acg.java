// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package android.support.v7:
//            abd, vo, adf, abo, 
//            abe, aam, adc, vn, 
//            aaz, aau

class acg
    implements abd
{
    class a
        implements adf.a
    {

        final acg a;

        public void a(aaz aaz1)
        {
            acg.a(a, aaz1.a());
        }

        public void b(aaz aaz1)
        {
            acg.a(a, aaz1.a());
            abo.d((new StringBuilder()).append("Permanent failure dispatching hitId: ").append(aaz1.a()).toString());
        }

        public void c(aaz aaz1)
        {
            long l = aaz1.b();
            if (l == 0L)
            {
                acg.a(a, aaz1.a(), acg.a(a).a());
            } else
            if (l + 0xdbba00L < acg.a(a).a())
            {
                acg.a(a, aaz1.a());
                abo.d((new StringBuilder()).append("Giving up on failed hitId: ").append(aaz1.a()).toString());
                return;
            }
        }

        a()
        {
            a = acg.this;
            super();
        }
    }

    class b extends SQLiteOpenHelper
    {

        final acg a;
        private boolean b;
        private long c;

        private void a(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            obj = new HashSet();
            String as[] = sqlitedatabase.getColumnNames();
            int j = 0;
_L2:
            if (j >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Set) (obj)).add(as[j]);
            j++;
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase.close();
            if (!((Set) (obj)).remove("hit_id") || !((Set) (obj)).remove("hit_url") || !((Set) (obj)).remove("hit_time") || !((Set) (obj)).remove("hit_first_send_time"))
            {
                throw new SQLiteException("Database column missing");
            }
            break MISSING_BLOCK_LABEL_122;
            obj;
            sqlitedatabase.close();
            throw obj;
            if (!((Set) (obj)).isEmpty())
            {
                throw new SQLiteException("Database has extra columns");
            } else
            {
                return;
            }
        }

        private boolean a(String s, SQLiteDatabase sqlitedatabase)
        {
            Object obj = null;
            sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", new String[] {
                "name"
            }, "name=?", new String[] {
                s
            }, null, null, null);
            boolean flag = sqlitedatabase.moveToFirst();
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return flag;
            sqlitedatabase;
            sqlitedatabase = null;
_L4:
            abo.b((new StringBuilder()).append("Error querying for table ").append(s).toString());
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return false;
            s;
            sqlitedatabase = obj;
_L2:
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            throw s;
            s;
            continue; /* Loop/switch isn't completed */
            s;
            if (true) goto _L2; else goto _L1
_L1:
            SQLiteException sqliteexception;
            sqliteexception;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public SQLiteDatabase getWritableDatabase()
        {
            SQLiteDatabase sqlitedatabase;
            if (b && c + 0x36ee80L > acg.a(a).a())
            {
                throw new SQLiteException("Database creation failed");
            }
            sqlitedatabase = null;
            b = true;
            c = acg.a(a).a();
            SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
            sqlitedatabase = sqlitedatabase1;
_L2:
            SQLiteDatabase sqlitedatabase2 = sqlitedatabase;
            if (sqlitedatabase == null)
            {
                sqlitedatabase2 = super.getWritableDatabase();
            }
            b = false;
            return sqlitedatabase2;
            SQLiteException sqliteexception;
            sqliteexception;
            acg.c(a).getDatabasePath(acg.b(a)).delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            aau.a(sqlitedatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Cursor cursor;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            cursor = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            cursor.moveToFirst();
            cursor.close();
            if (!a("gtm_hits", sqlitedatabase))
            {
                sqlitedatabase.execSQL(acg.e());
                return;
            } else
            {
                a(sqlitedatabase);
                return;
            }
            sqlitedatabase;
            cursor.close();
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
        {
        }

        b(Context context, String s)
        {
            a = acg.this;
            super(context, s, null, 1);
            c = 0L;
        }
    }


    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] {
        "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"
    });
    private final b b;
    private volatile aam c;
    private final abe d;
    private final Context e;
    private final String f;
    private long g;
    private vn h;
    private final int i;

    acg(abe abe1, Context context)
    {
        this(abe1, context, "gtm_urls.db", 2000);
    }

    acg(abe abe1, Context context, String s, int j)
    {
        e = context.getApplicationContext();
        f = s;
        d = abe1;
        h = vo.d();
        b = new b(e, f);
        c = new adf(new DefaultHttpClient(), e, new a());
        g = 0L;
        i = j;
    }

    private SQLiteDatabase a(String s)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = b.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            abo.b(s);
            return null;
        }
        return sqlitedatabase;
    }

    static vn a(acg acg1)
    {
        return acg1.h;
    }

    private void a(long l)
    {
        a(new String[] {
            String.valueOf(l)
        });
    }

    private void a(long l, long l1)
    {
        SQLiteDatabase sqlitedatabase = a("Error opening database for getNumStoredHits.");
        if (sqlitedatabase == null)
        {
            return;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("hit_first_send_time", Long.valueOf(l1));
        try
        {
            sqlitedatabase.update("gtm_hits", contentvalues, "hit_id=?", new String[] {
                String.valueOf(l)
            });
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            abo.b((new StringBuilder()).append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ").append(l).toString());
        }
        a(l);
    }

    static void a(acg acg1, long l)
    {
        acg1.a(l);
    }

    static void a(acg acg1, long l, long l1)
    {
        acg1.a(l, l1);
    }

    static String b(acg acg1)
    {
        return acg1.f;
    }

    private void b(long l, String s)
    {
        SQLiteDatabase sqlitedatabase = a("Error opening database for putHit");
        if (sqlitedatabase == null)
        {
            return;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("hit_time", Long.valueOf(l));
        contentvalues.put("hit_url", s);
        contentvalues.put("hit_first_send_time", Integer.valueOf(0));
        try
        {
            sqlitedatabase.insert("gtm_hits", null, contentvalues);
            d.a(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            abo.b("Error storing hit");
        }
    }

    static Context c(acg acg1)
    {
        return acg1.e;
    }

    static String e()
    {
        return a;
    }

    private void f()
    {
        int j = (c() - i) + 1;
        if (j > 0)
        {
            List list = a(j);
            abo.d((new StringBuilder()).append("Store full, deleting ").append(list.size()).append(" hits to make room.").toString());
            a((String[])list.toArray(new String[0]));
        }
    }

    List a(int j)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (j <= 0)
        {
            abo.b("Invalid maxHits specified. Skipping");
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
        String s = Integer.toString(j);
        obj1 = ((SQLiteDatabase) (obj)).query("gtm_hits", new String[] {
            "hit_id"
        }, null, null, null, null, ((String) (obj1)), s);
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
        abo.b((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(sqliteexception.getMessage()).toString());
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

    public void a()
    {
        abo.d("GTM Dispatch running...");
        if (c.a())
        {
            List list = b(40);
            if (list.isEmpty())
            {
                abo.d("...nothing to dispatch");
                d.a(true);
                return;
            }
            c.a(list);
            if (d() > 0)
            {
                adc.c().a();
                return;
            }
        }
    }

    public void a(long l, String s)
    {
        b();
        f();
        b(l, s);
    }

    void a(String as[])
    {
        boolean flag = true;
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase;
        return;
_L2:
        if ((sqlitedatabase = a("Error opening database for deleteHits.")) == null) goto _L1; else goto _L3
_L3:
        String s = String.format("HIT_ID in (%s)", new Object[] {
            TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        sqlitedatabase.delete("gtm_hits", s, as);
        as = d;
        if (c() != 0)
        {
            flag = false;
        }
        as.a(flag);
        return;
        as;
        abo.b("Error deleting hits");
        return;
    }

    int b()
    {
        boolean flag = true;
        long l = h.a();
        if (l > g + 0x5265c00L)
        {
            g = l;
            Object obj = a("Error opening database for deleteStaleHits.");
            if (obj != null)
            {
                int j = ((SQLiteDatabase) (obj)).delete("gtm_hits", "HIT_TIME < ?", new String[] {
                    Long.toString(h.a() - 0x9a7ec800L)
                });
                obj = d;
                if (c() != 0)
                {
                    flag = false;
                }
                ((abe) (obj)).a(flag);
                return j;
            }
        }
        return 0;
    }

    public List b(int j)
    {
        Object obj1;
        Object obj4;
        obj1 = new ArrayList();
        obj4 = a("Error opening database for peekHits");
        if (obj4 != null) goto _L2; else goto _L1
_L1:
        Object obj2 = obj1;
_L8:
        return ((List) (obj2));
_L2:
        Object obj = null;
        obj2 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        String s = Integer.toString(j);
        obj2 = ((SQLiteDatabase) (obj4)).query("gtm_hits", new String[] {
            "hit_id", "hit_time", "hit_first_send_time"
        }, null, null, null, null, ((String) (obj2)), s);
        obj = obj2;
        Object obj3 = new ArrayList();
        boolean flag;
        if (((Cursor) (obj)).moveToFirst())
        {
            do
            {
                ((List) (obj3)).add(new aaz(((Cursor) (obj)).getLong(0), ((Cursor) (obj)).getLong(1), ((Cursor) (obj)).getLong(2)));
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
        String s1 = Integer.toString(j);
        obj1 = obj;
        obj2 = ((SQLiteDatabase) (obj4)).query("gtm_hits", new String[] {
            "hit_id", "hit_url"
        }, null, null, null, null, ((String) (obj2)), s1);
        if (!((Cursor) (obj2)).moveToFirst()) goto _L4; else goto _L3
_L3:
        j = 0;
_L18:
        if (((SQLiteCursor)obj2).getWindow().getNumRows() <= 0) goto _L6; else goto _L5
_L5:
        ((aaz)((List) (obj3)).get(j)).a(((Cursor) (obj2)).getString(1));
_L9:
        boolean flag1 = ((Cursor) (obj2)).moveToNext();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_617;
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
_L17:
        abo.b((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(((SQLiteException) (obj2)).getMessage()).toString());
        obj2 = obj;
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        ((Cursor) (obj1)).close();
        return ((List) (obj));
        obj2;
        obj1 = obj;
        obj = obj2;
_L16:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L6:
        abo.b(String.format("HitString for hitId %d too large.  Hit will be deleted.", new Object[] {
            Long.valueOf(((aaz)((List) (obj3)).get(j)).a())
        }));
          goto _L9
        obj1;
        obj = obj2;
        obj2 = obj1;
_L15:
        obj1 = obj;
        abo.b((new StringBuilder()).append("Error in peekHits fetching hit url: ").append(((SQLiteException) (obj2)).getMessage()).toString());
        obj1 = obj;
        obj2 = new ArrayList();
        j = 0;
        obj1 = obj;
        obj3 = ((List) (obj3)).iterator();
_L11:
        obj1 = obj;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_521;
        }
        obj1 = obj;
        obj4 = (aaz)((Iterator) (obj3)).next();
        obj1 = obj;
        flag1 = TextUtils.isEmpty(((aaz) (obj4)).c());
        int k;
        k = j;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_537;
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_534;
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj2));
        k = 1;
        obj1 = obj;
        ((List) (obj2)).add(obj4);
        j = k;
        if (true) goto _L11; else goto _L10
_L10:
        obj;
_L13:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        obj;
        obj1 = obj2;
        if (true) goto _L13; else goto _L12
_L12:
        obj2;
        if (true) goto _L15; else goto _L14
_L14:
        obj2;
        obj1 = obj;
        obj = obj2;
          goto _L16
        obj;
          goto _L16
        obj2;
        obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L17
        obj2;
        obj1 = obj;
        obj = obj3;
          goto _L17
        j++;
          goto _L18
    }

    int c()
    {
        Cursor cursor;
        Object obj;
        Object obj1;
        int j;
        int k;
        obj = null;
        cursor = null;
        j = 0;
        k = 0;
        obj1 = a("Error opening database for getNumStoredHits.");
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        obj1 = ((SQLiteDatabase) (obj1)).rawQuery("SELECT COUNT(*) from gtm_hits", null);
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_64;
        }
        cursor = ((Cursor) (obj1));
        obj = obj1;
        long l = ((Cursor) (obj1)).getLong(0);
        j = (int)l;
        k = j;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
            return j;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        obj = cursor;
        abo.b("Error getting numStoredHits");
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

    int d()
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = a("Error opening database for getNumStoredHits.");
        if (obj == null)
        {
            return 0;
        }
        obj = ((SQLiteDatabase) (obj)).query("gtm_hits", new String[] {
            "hit_id", "hit_first_send_time"
        }, "hit_first_send_time=0", null, null, null, null);
        int k = ((Cursor) (obj)).getCount();
        int j;
        j = k;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            j = k;
        }
_L1:
        return j;
        obj;
        obj = null;
_L4:
        abo.b("Error getting num untried hits");
        SQLiteException sqliteexception;
        Exception exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            j = 0;
        } else
        {
            j = 0;
        }
          goto _L1
        obj;
_L3:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        exception;
        obj1 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L3; else goto _L2
_L2:
        sqliteexception;
          goto _L4
    }

}
