// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ij;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.google.android.gms.e:
//            y, ca, aj, z, 
//            u, h, bx, p

final class bb
    implements y
{
    final class a
        implements ca.a
    {

        final bb a;

        public final void a(u u1)
        {
            bb.a(a, u1.a);
        }

        public final void b(u u1)
        {
            bb.a(a, u1.a);
            (new StringBuilder("Permanent failure dispatching hitId: ")).append(u1.a);
            aj.d();
        }

        public final void c(u u1)
        {
            long l = u1.b;
            if (l == 0L)
            {
                bb.a(a, u1.a, bb.a(a).a());
            } else
            if (l + 0xdbba00L < bb.a(a).a())
            {
                bb.a(a, u1.a);
                (new StringBuilder("Giving up on failed hitId: ")).append(u1.a);
                aj.d();
                return;
            }
        }

        a()
        {
            a = bb.this;
            super();
        }
    }

    final class b extends SQLiteOpenHelper
    {

        final bb a;
        private boolean b;
        private long c;

        private static boolean a(String s, SQLiteDatabase sqlitedatabase)
        {
            Object obj = null;
            s = sqlitedatabase.query("SQLITE_MASTER", new String[] {
                "name"
            }, "name=?", new String[] {
                s
            }, null, null, null);
            boolean flag = s.moveToFirst();
            if (s != null)
            {
                s.close();
            }
            return flag;
            s;
            s = null;
_L4:
            aj.a();
            if (s != null)
            {
                s.close();
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
            Exception exception;
            exception;
            sqlitedatabase = s;
            s = exception;
            continue; /* Loop/switch isn't completed */
            exception;
            sqlitedatabase = s;
            s = exception;
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final SQLiteDatabase getWritableDatabase()
        {
            SQLiteDatabase sqlitedatabase;
            if (b && c + 0x36ee80L > bb.a(a).a())
            {
                throw new SQLiteException("Database creation failed");
            }
            sqlitedatabase = null;
            b = true;
            c = bb.a(a).a();
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
            bb.c(a).getDatabasePath(bb.b(a)).delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void onCreate(SQLiteDatabase sqlitedatabase)
        {
            p.a(sqlitedatabase.getPath());
        }

        public final void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            obj = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            ((Cursor) (obj)).moveToFirst();
            ((Cursor) (obj)).close();
            if (a("gtm_hits", sqlitedatabase)) goto _L2; else goto _L1
_L1:
            sqlitedatabase.execSQL(bb.b());
_L6:
            return;
            sqlitedatabase;
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
_L2:
            sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            obj = new HashSet();
            String as[] = sqlitedatabase.getColumnNames();
            int j = 0;
_L4:
            if (j >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Set) (obj)).add(as[j]);
            j++;
            if (true) goto _L4; else goto _L3
_L3:
            sqlitedatabase.close();
            if (!((Set) (obj)).remove("hit_id") || !((Set) (obj)).remove("hit_url") || !((Set) (obj)).remove("hit_time") || !((Set) (obj)).remove("hit_first_send_time"))
            {
                throw new SQLiteException("Database column missing");
            }
            continue; /* Loop/switch isn't completed */
            obj;
            sqlitedatabase.close();
            throw obj;
            if (((Set) (obj)).isEmpty()) goto _L6; else goto _L5
_L5:
            throw new SQLiteException("Database has extra columns");
        }

        public final void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
        {
        }

        b(Context context, String s)
        {
            a = bb.this;
            super(context, s, null, 1);
            c = 0L;
        }
    }


    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] {
        "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"
    });
    private final b b;
    private volatile h c;
    private final z d;
    private final Context e;
    private final String f;
    private long g;
    private ii h;
    private final int i;

    bb(z z1, Context context)
    {
        this(z1, context, "gtm_urls.db");
    }

    private bb(z z1, Context context, String s)
    {
        e = context.getApplicationContext();
        f = s;
        d = z1;
        h = ij.d();
        b = new b(e, f);
        c = new ca(new DefaultHttpClient(), e, new a());
        g = 0L;
        i = 2000;
    }

    static ii a(bb bb1)
    {
        return bb1.h;
    }

    private List a(int j)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (j <= 0)
        {
            aj.a();
            return arraylist;
        }
        obj = f();
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
        (new StringBuilder("Error in peekHits fetching hitIds: ")).append(sqliteexception.getMessage());
        obj = obj1;
        aj.a();
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

    private void a(long l)
    {
        a(new String[] {
            String.valueOf(l)
        });
    }

    static void a(bb bb1, long l)
    {
        bb1.a(l);
    }

    static void a(bb bb1, long l, long l1)
    {
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = bb1.f();
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        contentvalues = new ContentValues();
        contentvalues.put("hit_first_send_time", Long.valueOf(l1));
        sqlitedatabase.update("gtm_hits", contentvalues, "hit_id=?", new String[] {
            String.valueOf(l)
        });
        return;
        SQLiteException sqliteexception;
        sqliteexception;
        aj.a();
        bb1.a(l);
        return;
    }

    private void a(String as[])
    {
        boolean flag = true;
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase;
        return;
_L2:
        if ((sqlitedatabase = f()) == null) goto _L1; else goto _L3
_L3:
        String s = String.format("HIT_ID in (%s)", new Object[] {
            TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        sqlitedatabase.delete("gtm_hits", s, as);
        as = d;
        if (d() != 0)
        {
            flag = false;
        }
        as.a(flag);
        return;
        as;
        aj.a();
        return;
    }

    static String b()
    {
        return a;
    }

    static String b(bb bb1)
    {
        return bb1.f;
    }

    static Context c(bb bb1)
    {
        return bb1.e;
    }

    private List c()
    {
        Object obj;
        Object obj1;
        Object obj4;
        obj = null;
        obj1 = new ArrayList();
        obj4 = f();
        if (obj4 != null) goto _L2; else goto _L1
_L1:
        Object obj2 = obj1;
_L11:
        return ((List) (obj2));
_L2:
        obj2 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        String s = Integer.toString(40);
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
                ((List) (obj3)).add(new u(((Cursor) (obj)).getLong(0), ((Cursor) (obj)).getLong(1), ((Cursor) (obj)).getLong(2)));
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
        String s1 = Integer.toString(40);
        obj1 = obj;
        obj2 = ((SQLiteDatabase) (obj4)).query("gtm_hits", new String[] {
            "hit_id", "hit_url"
        }, null, null, null, null, ((String) (obj2)), s1);
        if (!((Cursor) (obj2)).moveToFirst()) goto _L4; else goto _L3
_L3:
        int j = 0;
_L18:
        if (((SQLiteCursor)obj2).getWindow().getNumRows() <= 0) goto _L6; else goto _L5
_L5:
        obj = (u)((List) (obj3)).get(j);
        obj1 = ((Cursor) (obj2)).getString(1);
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        if (!TextUtils.isEmpty(((String) (obj1)).trim())) goto _L9; else goto _L8
_L8:
        boolean flag1 = ((Cursor) (obj2)).moveToNext();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_600;
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
        (new StringBuilder("Error in peekHits fetching hitIds: ")).append(((SQLiteException) (obj2)).getMessage());
        aj.a();
        obj2 = obj;
        if (obj1 == null) goto _L11; else goto _L10
_L10:
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
_L9:
        obj.c = ((String) (obj1));
          goto _L8
        obj1;
        obj = obj2;
        obj2 = obj1;
_L15:
        obj1 = obj;
        (new StringBuilder("Error in peekHits fetching hit url: ")).append(((SQLiteException) (obj2)).getMessage());
        obj1 = obj;
        aj.a();
        obj1 = obj;
        obj2 = new ArrayList();
        obj1 = obj;
        obj3 = ((List) (obj3)).iterator();
        j = 0;
_L13:
        obj1 = obj;
        if (!((Iterator) (obj3)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj4 = (u)((Iterator) (obj3)).next();
        int k;
        k = j;
        obj1 = obj;
        if (TextUtils.isEmpty(((u) (obj4)).c))
        {
            if (j != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = 1;
        }
        obj1 = obj;
        ((List) (obj2)).add(obj4);
        j = k;
        if (true) goto _L13; else goto _L12
        obj;
_L14:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L6:
        String.format("HitString for hitId %d too large.  Hit will be deleted.", new Object[] {
            Long.valueOf(((u)((List) (obj3)).get(j)).a)
        });
        aj.a();
          goto _L8
        obj;
        obj1 = obj2;
          goto _L14
_L12:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj2));
        obj2;
          goto _L15
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

    private int d()
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
        obj1 = f();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        obj1 = ((SQLiteDatabase) (obj1)).rawQuery("SELECT COUNT(*) from gtm_hits", null);
        cursor = ((Cursor) (obj1));
        obj = obj1;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_62;
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
        aj.a();
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

    private int e()
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = f();
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
        aj.a();
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

    private SQLiteDatabase f()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = b.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            aj.a();
            return null;
        }
        return sqlitedatabase;
    }

    public final void a()
    {
        aj.d();
        if (c.a())
        {
            List list = c();
            if (list.isEmpty())
            {
                aj.d();
                d.a(true);
                return;
            }
            c.a(list);
            if (e() > 0)
            {
                bx.c().a();
                return;
            }
        }
    }

    public final void a(long l, String s)
    {
        boolean flag = true;
        long l1 = h.a();
        if (l1 > g + 0x5265c00L)
        {
            g = l1;
            Object obj = f();
            if (obj != null)
            {
                ((SQLiteDatabase) (obj)).delete("gtm_hits", "HIT_TIME < ?", new String[] {
                    Long.toString(h.a() - 0x9a7ec800L)
                });
                obj = d;
                ContentValues contentvalues;
                int j;
                if (d() != 0)
                {
                    flag = false;
                }
                ((z) (obj)).a(flag);
            }
        }
        j = (d() - i) + 1;
        if (j > 0)
        {
            obj = a(j);
            (new StringBuilder("Store full, deleting ")).append(((List) (obj)).size()).append(" hits to make room.");
            aj.d();
            a((String[])((List) (obj)).toArray(new String[0]));
        }
        obj = f();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        contentvalues = new ContentValues();
        contentvalues.put("hit_time", Long.valueOf(l));
        contentvalues.put("hit_url", s);
        contentvalues.put("hit_first_send_time", Integer.valueOf(0));
        ((SQLiteDatabase) (obj)).insert("gtm_hits", null, contentvalues);
        d.a(false);
        return;
        s;
        aj.a();
        return;
    }

}
