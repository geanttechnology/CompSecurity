// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.vn;
import android.text.TextUtils;
import com.google.android.gms.common.internal.x;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.Closeable;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, k, r, ad, 
//            c, g, t, l, 
//            aj

class v extends p
    implements Closeable
{
    class a extends SQLiteOpenHelper
    {

        final v a;

        private void a(SQLiteDatabase sqlitedatabase)
        {
label0:
            {
                boolean flag1 = true;
                Set set = b(sqlitedatabase, "hits2");
                String as[] = new String[4];
                as[0] = "hit_id";
                as[1] = "hit_string";
                as[2] = "hit_time";
                as[3] = "hit_url";
                int j1 = as.length;
                for (int i1 = 0; i1 < j1; i1++)
                {
                    String s = as[i1];
                    if (!set.remove(s))
                    {
                        throw new SQLiteException((new StringBuilder()).append("Database hits2 is missing required column: ").append(s).toString());
                    }
                }

                boolean flag;
                if (!set.remove("hit_app_id"))
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                if (!set.isEmpty())
                {
                    throw new SQLiteException("Database hits2 has extra columns");
                }
                if (flag)
                {
                    if (sqlitedatabase instanceof SQLiteDatabase)
                    {
                        break label0;
                    }
                    sqlitedatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
                }
                return;
            }
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
        }

        private boolean a(SQLiteDatabase sqlitedatabase, String s)
        {
            SQLiteDatabase sqlitedatabase1 = null;
            String as[] = new String[1];
            as[0] = "name";
            String as1[] = new String[1];
            as1[0] = s;
            if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
            sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", as, "name=?", as1, null, null, null);
_L4:
            sqlitedatabase1 = sqlitedatabase;
            boolean flag = sqlitedatabase.moveToFirst();
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return flag;
_L2:
            sqlitedatabase = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "SQLITE_MASTER", as, "name=?", as1, null, null, null);
            if (true) goto _L4; else goto _L3
_L3:
            SQLiteException sqliteexception;
            sqliteexception;
            sqlitedatabase = null;
_L8:
            sqlitedatabase1 = sqlitedatabase;
            a.c("Error querying for table", s, sqliteexception);
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return false;
            sqlitedatabase;
            s = sqlitedatabase1;
_L6:
            if (s != null)
            {
                s.close();
            }
            throw sqlitedatabase;
            sqlitedatabase;
            s = sqlitedatabase1;
            if (true) goto _L6; else goto _L5
_L5:
            sqliteexception;
            if (true) goto _L8; else goto _L7
_L7:
        }

        private Set b(SQLiteDatabase sqlitedatabase, String s)
        {
            HashSet hashset;
            hashset = new HashSet();
            s = (new StringBuilder()).append("SELECT * FROM ").append(s).append(" LIMIT 0").toString();
            int i1;
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase = sqlitedatabase.rawQuery(s, null);
            } else
            {
                sqlitedatabase = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, s, null);
            }
            s = sqlitedatabase.getColumnNames();
            i1 = 0;
_L2:
            if (i1 >= s.length)
            {
                break; /* Loop/switch isn't completed */
            }
            hashset.add(s[i1]);
            i1++;
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase.close();
            return hashset;
            s;
            sqlitedatabase.close();
            throw s;
        }

        private void b(SQLiteDatabase sqlitedatabase)
        {
            int i1 = 0;
            sqlitedatabase = b(sqlitedatabase, "properties");
            String as[] = new String[6];
            as[0] = "app_uid";
            as[1] = "cid";
            as[2] = "tid";
            as[3] = "params";
            as[4] = "adid";
            as[5] = "hits_count";
            for (int j1 = as.length; i1 < j1; i1++)
            {
                String s = as[i1];
                if (!sqlitedatabase.remove(s))
                {
                    throw new SQLiteException((new StringBuilder()).append("Database properties is missing required column: ").append(s).toString());
                }
            }

            if (!sqlitedatabase.isEmpty())
            {
                throw new SQLiteException("Database properties table has extra columns");
            } else
            {
                return;
            }
        }

        public SQLiteDatabase getWritableDatabase()
        {
            if (!v.a(a).a(0x36ee80L))
            {
                throw new SQLiteException("Database open failed");
            }
            SQLiteDatabase sqlitedatabase;
            try
            {
                sqlitedatabase = super.getWritableDatabase();
            }
            catch (SQLiteException sqliteexception)
            {
                v.a(a).a();
                a.f("Opening the database failed, dropping the table and recreating it");
                Object obj = v.b(a);
                a.o().getDatabasePath(((String) (obj))).delete();
                try
                {
                    obj = super.getWritableDatabase();
                    v.a(a).b();
                }
                catch (SQLiteException sqliteexception1)
                {
                    a.e("Failed to open freshly created database", sqliteexception1);
                    throw sqliteexception1;
                }
                return ((SQLiteDatabase) (obj));
            }
            return sqlitedatabase;
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            aj.a(sqlitedatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                break MISSING_BLOCK_LABEL_36;
            }
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                obj = sqlitedatabase.rawQuery("PRAGMA journal_mode=memory", null);
            } else
            {
                obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "PRAGMA journal_mode=memory", null);
            }
            ((Cursor) (obj)).moveToFirst();
            ((Cursor) (obj)).close();
            if (!a(sqlitedatabase, "hits2"))
            {
                obj = v.j();
                if (!(sqlitedatabase instanceof SQLiteDatabase))
                {
                    sqlitedatabase.execSQL(((String) (obj)));
                } else
                {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, ((String) (obj)));
                }
            } else
            {
                a(sqlitedatabase);
            }
            if (!a(sqlitedatabase, "properties"))
            {
                if (!(sqlitedatabase instanceof SQLiteDatabase))
                {
                    sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
                    return;
                } else
                {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
                    return;
                }
            } else
            {
                b(sqlitedatabase);
                return;
            }
            sqlitedatabase;
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i1, int j1)
        {
        }

        a(Context context, String s)
        {
            a = v.this;
            super(context, s, null, 1);
        }
    }


    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] {
        "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"
    });
    private static final String b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[] {
        "hit_time", "hits2"
    });
    private final a c;
    private final k d = new k(n());
    private final k e = new k(n());

    v(r r1)
    {
        super(r1);
        String s = G();
        c = new a(r1.b(), s);
    }

    private void F()
    {
        int i1 = q().y();
        long l1 = e();
        if (l1 > (long)(i1 - 1))
        {
            List list = a((l1 - (long)i1) + 1L);
            d("Store full, deleting hits to make room, count", Integer.valueOf(list.size()));
            a(list);
        }
    }

    private String G()
    {
        if (!q().a())
        {
            return q().A();
        }
        if (q().b())
        {
            return q().A();
        } else
        {
            return q().B();
        }
    }

    private long a(String s, String as[])
    {
        String as1[];
        String as2[];
        Object obj;
        Object obj1;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = i();
        obj1 = null;
        obj = null;
        as2 = obj;
        as1 = obj1;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        as2 = obj;
        as1 = obj1;
        as = sqlitedatabase.rawQuery(s, as);
_L4:
        as2 = as;
        as1 = as;
        if (!as.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        as2 = as;
        as1 = as;
        long l1 = as.getLong(0);
        if (as != null)
        {
            as.close();
        }
        return l1;
_L2:
        as2 = obj;
        as1 = obj1;
        as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, s, as);
        if (true) goto _L4; else goto _L3
_L3:
        as2 = as;
        as1 = as;
        try
        {
            throw new SQLiteException("Database returned empty set");
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as1 = as2;
        }
        finally
        {
            if (as1 == null) goto _L0; else goto _L0
        }
        d("Database error", s, as);
        as1 = as2;
        throw as;
        as1.close();
        throw s;
    }

    private long a(String s, String as[], long l1)
    {
        String as1[];
        String as2[];
        Object obj;
        Object obj1;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = i();
        obj1 = null;
        obj = null;
        as2 = obj;
        as1 = obj1;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        as2 = obj;
        as1 = obj1;
        as = sqlitedatabase.rawQuery(s, as);
_L9:
        as2 = as;
        as1 = as;
        if (!as.moveToFirst()) goto _L4; else goto _L3
_L3:
        as2 = as;
        as1 = as;
        l1 = as.getLong(0);
        long l2;
        l2 = l1;
        if (as != null)
        {
            as.close();
            l2 = l1;
        }
_L7:
        return l2;
_L2:
        as2 = obj;
        as1 = obj1;
        try
        {
            as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, s, as);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            as1 = as2;
        }
        finally
        {
            if (as1 != null)
            {
                as1.close();
            }
            throw s;
        }
          goto _L5
_L4:
        l2 = l1;
        if (as == null) goto _L7; else goto _L6
_L6:
        as.close();
        return l1;
_L5:
        d("Database error", s, as);
        as1 = as2;
        throw as;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static k a(v v1)
    {
        return v1.e;
    }

    private static String a(Map map)
    {
        x.a(map);
        Object obj = new android.net.Uri.Builder();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); ((android.net.Uri.Builder) (obj)).appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        obj = ((android.net.Uri.Builder) (obj)).build().getEncodedQuery();
        map = ((Map) (obj));
        if (obj == null)
        {
            map = "";
        }
        return map;
    }

    private String b(c c1)
    {
        if (c1.f())
        {
            return q().o();
        } else
        {
            return q().p();
        }
    }

    static String b(v v1)
    {
        return v1.G();
    }

    private static String c(c c1)
    {
        x.a(c1);
        Object obj = new android.net.Uri.Builder();
        c1 = c1.b().entrySet().iterator();
        do
        {
            if (!c1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)c1.next();
            String s = (String)entry.getKey();
            if (!"ht".equals(s) && !"qt".equals(s) && !"AppUID".equals(s))
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter(s, (String)entry.getValue());
            }
        } while (true);
        obj = ((android.net.Uri.Builder) (obj)).build().getEncodedQuery();
        c1 = ((c) (obj));
        if (obj == null)
        {
            c1 = "";
        }
        return c1;
    }

    static String j()
    {
        return a;
    }

    public long a(long l1, String s, String s1)
    {
        x.a(s);
        x.a(s1);
        D();
        m();
        return a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[] {
            String.valueOf(l1), s, s1
        }, 0L);
    }

    public List a(long l1)
    {
        Object obj;
        Object obj1;
        ArrayList arraylist;
        obj1 = null;
        m();
        D();
        if (l1 <= 0L)
        {
            return Collections.emptyList();
        }
        obj = i();
        arraylist = new ArrayList();
        String as[] = new String[1];
        as[0] = "hit_id";
        String s;
        String s1;
        s = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        s1 = Long.toString(l1);
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("hits2", as, null, null, null, null, s, s1);
_L5:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        arraylist.add(Long.valueOf(((Cursor) (obj)).getLong(0)));
        obj1 = obj;
        boolean flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L3; else goto _L4
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L6:
        return arraylist;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "hits2", as, null, null, null, null, s, s1);
          goto _L5
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L9:
        obj1 = obj;
        d("Error selecting hit ids", sqliteexception);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
          goto _L6
        Exception exception;
        exception;
_L8:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        sqliteexception;
          goto _L9
    }

    Map a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return new HashMap(0);
        }
        Object obj;
        if (!s.startsWith("?"))
        {
            try
            {
                s = (new StringBuilder()).append("?").append(s).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                e("Error parsing hit parameters", s);
                return new HashMap(0);
            }
        }
        obj = URLEncodedUtils.parse(new URI(s), "UTF-8");
        s = new HashMap(((List) (obj)).size());
        NameValuePair namevaluepair;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.put(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj)).next();
        }

        return s;
    }

    protected void a()
    {
    }

    public void a(long l1, String s)
    {
        x.a(s);
        D();
        m();
        SQLiteDatabase sqlitedatabase = i();
        String as[] = new String[2];
        as[0] = String.valueOf(l1);
        as[1] = s;
        int i1;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            i1 = sqlitedatabase.delete("properties", "app_uid=? AND cid<>?", as);
        } else
        {
            i1 = SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "properties", "app_uid=? AND cid<>?", as);
        }
        if (i1 > 0)
        {
            a("Deleted property records", Integer.valueOf(i1));
        }
    }

    public void a(c c1)
    {
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        x.a(c1);
        m();
        D();
        String s = c(c1);
        if (s.length() > 8192)
        {
            p().a(c1, "Hit length exceeds the maximum allowed size");
            return;
        }
        F();
        sqlitedatabase = i();
        contentvalues = new ContentValues();
        contentvalues.put("hit_string", s);
        contentvalues.put("hit_time", Long.valueOf(c1.d()));
        contentvalues.put("hit_app_id", Integer.valueOf(c1.a()));
        contentvalues.put("hit_url", b(c1));
        long l1;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        l1 = sqlitedatabase.insert("hits2", null, contentvalues);
_L1:
        if (l1 == -1L)
        {
            try
            {
                f("Failed to insert a hit (got -1)");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (c c1)
            {
                e("Error storing a hit", c1);
            }
            return;
        }
        break MISSING_BLOCK_LABEL_168;
        l1 = SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "hits2", null, contentvalues);
          goto _L1
        b("Hit saved to database. db-id, hit", Long.valueOf(l1), c1);
        return;
    }

    public void a(t t1)
    {
        x.a(t1);
        D();
        m();
        SQLiteDatabase sqlitedatabase = i();
        String s = a(t1.f());
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("app_uid", Long.valueOf(t1.a()));
        contentvalues.put("cid", t1.b());
        contentvalues.put("tid", t1.c());
        int i1;
        long l1;
        if (t1.d())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        contentvalues.put("adid", Integer.valueOf(i1));
        contentvalues.put("hits_count", Long.valueOf(t1.e()));
        contentvalues.put("params", s);
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        l1 = sqlitedatabase.insertWithOnConflict("properties", null, contentvalues, 5);
_L1:
        if (l1 == -1L)
        {
            try
            {
                f("Failed to insert/update a property (got -1)");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (t t1)
            {
                e("Error storing a property", t1);
            }
        }
        break MISSING_BLOCK_LABEL_186;
        l1 = SQLiteInstrumentation.insertWithOnConflict((SQLiteDatabase)sqlitedatabase, "properties", null, contentvalues, 5);
          goto _L1
    }

    public void a(List list)
    {
        x.a(list);
        m();
        D();
        if (!list.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = new StringBuilder("hit_id");
        ((StringBuilder) (obj)).append(" in (");
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            Long long1 = (Long)list.get(i1);
            if (long1 == null || long1.longValue() == 0L)
            {
                throw new SQLiteException("Invalid hit id");
            }
            if (i1 > 0)
            {
                ((StringBuilder) (obj)).append(",");
            }
            ((StringBuilder) (obj)).append(long1);
        }

        ((StringBuilder) (obj)).append(")");
        obj = ((StringBuilder) (obj)).toString();
        SQLiteDatabase sqlitedatabase;
        int j1;
        sqlitedatabase = i();
        a("Deleting dispatched hits. count", Integer.valueOf(list.size()));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = sqlitedatabase.delete("hits2", ((String) (obj)), null);
_L4:
        if (j1 != list.size())
        {
            b("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(j1), obj);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        try
        {
            j1 = SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "hits2", ((String) (obj)), null);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            e("Error deleting hits", list);
            throw list;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public List b(long l1)
    {
        Cursor cursor;
        Object obj;
        Object obj1;
        String as[];
        String s;
        String s1;
        boolean flag = true;
        cursor = null;
        int i1;
        long l2;
        if (l1 < 0L)
        {
            flag = false;
        }
        x.b(flag);
        m();
        D();
        obj1 = i();
        obj = cursor;
        as = new String[5];
        as[0] = "hit_id";
        as[1] = "hit_time";
        as[2] = "hit_string";
        as[3] = "hit_url";
        as[4] = "hit_app_id";
        obj = cursor;
        s = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        obj = cursor;
        s1 = Long.toString(l1);
        obj = cursor;
        if (obj1 instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = cursor;
        cursor = ((SQLiteDatabase) (obj1)).query("hits2", as, null, null, null, null, s, s1);
_L6:
        obj = cursor;
        obj1 = new ArrayList();
        obj = cursor;
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        obj = cursor;
        l1 = cursor.getLong(0);
        obj = cursor;
        l2 = cursor.getLong(1);
        obj = cursor;
        as = cursor.getString(2);
        obj = cursor;
        s = cursor.getString(3);
        obj = cursor;
        i1 = cursor.getInt(4);
        obj = cursor;
        ((List) (obj1)).add(new c(this, a(as), l2, l.d(s), l1, i1));
        obj = cursor;
        flag = cursor.moveToNext();
        if (flag) goto _L3; else goto _L4
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
        return ((List) (obj1));
_L2:
        obj = cursor;
        cursor = SQLiteInstrumentation.query((SQLiteDatabase)obj1, "hits2", as, null, null, null, null, s, s1);
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        cursor = null;
_L10:
        e("Error loading hits from the database", obj);
        throw obj;
        Exception exception1;
        exception1;
        Exception exception;
        obj = cursor;
        exception = exception1;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        obj;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void b()
    {
        D();
        i().beginTransaction();
    }

    public void c()
    {
        D();
        i().setTransactionSuccessful();
    }

    public void c(long l1)
    {
        m();
        D();
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(Long.valueOf(l1));
        a("Deleting hit, id", Long.valueOf(l1));
        a(arraylist);
    }

    public void close()
    {
        try
        {
            c.close();
            return;
        }
        catch (SQLiteException sqliteexception)
        {
            e("Sql error closing database", sqliteexception);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            e("Error closing database", illegalstateexception);
        }
    }

    public List d(long l1)
    {
        Object obj;
        Object obj1;
        Object obj2;
        D();
        m();
        obj2 = i();
        obj = null;
        obj1 = obj;
        String s = new String[5];
        s[0] = "cid";
        s[1] = "tid";
        s[2] = "adid";
        s[3] = "hits_count";
        s[4] = "params";
        obj1 = obj;
        int i1 = q().z();
        obj1 = obj;
        String s1 = String.valueOf(i1);
        obj1 = obj;
        Map map = new String[1];
        obj1 = obj;
        map[0] = String.valueOf(l1);
        obj1 = obj;
        if (obj2 instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj = ((SQLiteDatabase) (obj2)).query("properties", s, "app_uid=?", map, null, null, null, s1);
_L13:
        obj1 = obj;
        obj2 = new ArrayList();
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        s = ((Cursor) (obj)).getString(0);
        obj1 = obj;
        s1 = ((Cursor) (obj)).getString(1);
        obj1 = obj;
        long l2;
        boolean flag;
        if (((Cursor) (obj)).getInt(2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = obj;
        l2 = ((Cursor) (obj)).getInt(3);
        obj1 = obj;
        map = g(((Cursor) (obj)).getString(4));
        obj1 = obj;
        if (TextUtils.isEmpty(s)) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        if (!TextUtils.isEmpty(s1)) goto _L7; else goto _L6
_L6:
        obj1 = obj;
        c("Read property with empty client id or tracker id", s, s1);
_L9:
        obj1 = obj;
        if (((Cursor) (obj)).moveToNext()) goto _L3; else goto _L4
_L4:
        obj1 = obj;
        if (((List) (obj2)).size() < i1)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        obj1 = obj;
        e("Sending hits to too many properties. Campaign report might be incorrect");
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj2));
_L2:
        obj1 = obj;
        Exception exception;
        try
        {
            obj = SQLiteInstrumentation.query((SQLiteDatabase)obj2, "properties", s, "app_uid=?", map, null, null, null, s1);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj = null;
        }
        finally { }
          goto _L8
_L7:
        obj1 = obj;
        ((List) (obj2)).add(new t(l1, s, s1, flag, l2, map));
          goto _L9
        obj1;
_L11:
        e("Error loading hits from the database", obj1);
        throw obj1;
        exception;
        obj1 = obj;
        obj = exception;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L8:
        if (true) goto _L11; else goto _L10
_L10:
        if (true) goto _L13; else goto _L12
_L12:
    }

    public void d()
    {
        D();
        i().endTransaction();
    }

    public long e()
    {
        m();
        D();
        return a("SELECT COUNT(*) FROM hits2", ((String []) (null)));
    }

    boolean f()
    {
        return e() == 0L;
    }

    public int g()
    {
        m();
        D();
        if (!d.a(0x5265c00L))
        {
            return 0;
        }
        d.a();
        b("Deleting stale hits (if any)");
        SQLiteDatabase sqlitedatabase = i();
        long l1 = n().a();
        String as[] = new String[1];
        as[0] = Long.toString(l1 - 0x9a7ec800L);
        int i1;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            i1 = sqlitedatabase.delete("hits2", "hit_time < ?", as);
        } else
        {
            i1 = SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "hits2", "hit_time < ?", as);
        }
        a("Deleted stale hits, count", Integer.valueOf(i1));
        return i1;
    }

    Map g(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return new HashMap(0);
        }
        try
        {
            Object obj = URLEncodedUtils.parse(new URI((new StringBuilder()).append("?").append(s).toString()), "UTF-8");
            s = new HashMap(((List) (obj)).size());
            NameValuePair namevaluepair;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.put(namevaluepair.getName(), namevaluepair.getValue()))
            {
                namevaluepair = (NameValuePair)((Iterator) (obj)).next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            e("Error parsing property parameters", s);
            return new HashMap(0);
        }
        return s;
    }

    public long h()
    {
        m();
        D();
        return a(b, ((String []) (null)), 0L);
    }

    SQLiteDatabase i()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = c.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            d("Error opening database", sqliteexception);
            throw sqliteexception;
        }
        return sqlitedatabase;
    }

}
