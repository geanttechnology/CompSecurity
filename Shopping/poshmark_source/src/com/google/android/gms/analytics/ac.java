// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.internal.di;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.google.android.gms.analytics:
//            d, ah, aa, e, 
//            y, x, n, ab, 
//            GoogleAnalytics, i, p

class ac
    implements d
{
    class a extends SQLiteOpenHelper
    {

        final ac uh;
        private boolean ui;
        private long uj;

        private void a(SQLiteDatabase sqlitedatabase)
        {
            Cursor cursor;
            HashSet hashset;
            String as[];
            int j;
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                cursor = sqlitedatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            } else
            {
                cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM hits2 WHERE 0", null);
            }
            hashset = new HashSet();
            as = cursor.getColumnNames();
            j = 0;
_L2:
            if (j >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            hashset.add(as[j]);
            j++;
            if (true) goto _L2; else goto _L1
_L1:
            cursor.close();
            if (!hashset.remove("hit_id") || !hashset.remove("hit_url") || !hashset.remove("hit_string") || !hashset.remove("hit_time"))
            {
                throw new SQLiteException("Database column missing");
            }
            break MISSING_BLOCK_LABEL_146;
            sqlitedatabase;
            cursor.close();
            throw sqlitedatabase;
label0:
            {
                boolean flag;
                if (!hashset.remove("hit_app_id"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!hashset.isEmpty())
                {
                    throw new SQLiteException("Database has extra columns");
                }
                if (flag)
                {
                    if (sqlitedatabase instanceof SQLiteDatabase)
                    {
                        break label0;
                    }
                    sqlitedatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                }
                return;
            }
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "ALTER TABLE hits2 ADD COLUMN hit_app_id");
            return;
        }

        private boolean a(String s1, SQLiteDatabase sqlitedatabase)
        {
            Object obj = null;
            String as[] = new String[1];
            as[0] = "name";
            String as1[] = new String[1];
            as1[0] = s1;
            if (sqlitedatabase instanceof SQLiteDatabase)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            sqlitedatabase = sqlitedatabase.query("SQLITE_MASTER", as, "name=?", as1, null, null, null);
_L1:
            boolean flag = sqlitedatabase.moveToFirst();
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return flag;
            sqlitedatabase = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "SQLITE_MASTER", as, "name=?", as1, null, null, null);
              goto _L1
            sqlitedatabase;
            sqlitedatabase = null;
_L5:
            aa.w((new StringBuilder()).append("Error querying for table ").append(s1).toString());
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return false;
            s1;
            sqlitedatabase = obj;
_L3:
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            throw s1;
            s1;
            continue; /* Loop/switch isn't completed */
            s1;
            if (true) goto _L3; else goto _L2
_L2:
            SQLiteException sqliteexception;
            sqliteexception;
            if (true) goto _L5; else goto _L4
_L4:
        }

        public SQLiteDatabase getWritableDatabase()
        {
            SQLiteDatabase sqlitedatabase;
            if (ui && uj + 0x36ee80L > ac.a(uh).currentTimeMillis())
            {
                throw new SQLiteException("Database creation failed");
            }
            sqlitedatabase = null;
            ui = true;
            uj = ac.a(uh).currentTimeMillis();
            SQLiteDatabase sqlitedatabase1 = super.getWritableDatabase();
            sqlitedatabase = sqlitedatabase1;
_L2:
            SQLiteDatabase sqlitedatabase2 = sqlitedatabase;
            if (sqlitedatabase == null)
            {
                sqlitedatabase2 = super.getWritableDatabase();
            }
            ui = false;
            return sqlitedatabase2;
            SQLiteException sqliteexception;
            sqliteexception;
            ac.c(uh).getDatabasePath(ac.b(uh)).delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            p.B(sqlitedatabase.getPath());
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
            if (!a("hits2", sqlitedatabase))
            {
                obj = ac.cr();
                if (!(sqlitedatabase instanceof SQLiteDatabase))
                {
                    sqlitedatabase.execSQL(((String) (obj)));
                    return;
                } else
                {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, ((String) (obj)));
                    return;
                }
            } else
            {
                a(sqlitedatabase);
                return;
            }
            sqlitedatabase;
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
        {
        }

        a(Context context, String s1)
        {
            uh = ac.this;
            super(context, s1, null, 1);
            uj = 0L;
        }
    }


    private static final String ua = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] {
        "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"
    });
    private final Context mContext;
    private i rJ = new i() {

        final ac uh;

        public long currentTimeMillis()
        {
            return System.currentTimeMillis();
        }

            
            {
                uh = ac.this;
                super();
            }
    };
    private final e rr;
    private final a ub;
    private volatile n uc;
    private final String ud;
    private ab ue;
    private long uf;
    private final int ug;

    ac(e e1, Context context)
    {
        this(e1, context, "google_analytics_v4.db", 2000);
    }

    ac(e e1, Context context, String s1, int j)
    {
        mContext = context.getApplicationContext();
        ud = s1;
        rr = e1;
        ub = new a(mContext, ud);
        uc = new ah(new DefaultHttpClient(), mContext);
        uf = 0L;
        ug = j;
    }

    private SQLiteDatabase G(String s1)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = ub.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            aa.w(s1);
            return null;
        }
        return sqlitedatabase;
    }

    static i a(ac ac1)
    {
        return ac1.rJ;
    }

    private void a(Map map, long l, String s1)
    {
        SQLiteDatabase sqlitedatabase = G("Error opening database for putHit");
        if (sqlitedatabase == null)
        {
            return;
        }
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("hit_string", t(map));
        contentvalues.put("hit_time", Long.valueOf(l));
        long l1 = 0L;
        l = l1;
        if (map.containsKey("AppUID"))
        {
            try
            {
                l = Long.parseLong((String)map.get("AppUID"));
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                l = l1;
            }
        }
        contentvalues.put("hit_app_id", Long.valueOf(l));
        map = s1;
        if (s1 == null)
        {
            map = "http://www.google-analytics.com/collect";
        }
        if (map.length() == 0)
        {
            aa.w("Empty path: not sending hit");
            return;
        }
        contentvalues.put("hit_url", map);
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        sqlitedatabase.insert("hits2", null, contentvalues);
_L1:
        rr.p(false);
        return;
        try
        {
            SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "hits2", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aa.w("Error storing hit");
            return;
        }
          goto _L1
    }

    private void a(Map map, Collection collection)
    {
label0:
        {
            String s1 = "&_v".substring(1);
            if (collection == null)
            {
                break label0;
            }
            collection = collection.iterator();
            di di1;
            do
            {
                if (!collection.hasNext())
                {
                    break label0;
                }
                di1 = (di)collection.next();
            } while (!"appendVersion".equals(di1.getId()));
            map.put(s1, di1.getValue());
        }
    }

    static String b(ac ac1)
    {
        return ac1.ud;
    }

    static Context c(ac ac1)
    {
        return ac1.mContext;
    }

    private void co()
    {
        int j = (cq() - ug) + 1;
        if (j > 0)
        {
            List list = s(j);
            aa.v((new StringBuilder()).append("Store full, deleting ").append(list.size()).append(" hits to make room.").toString());
            a((String[])list.toArray(new String[0]));
        }
    }

    static String cr()
    {
        return ua;
    }

    static String t(Map map)
    {
        ArrayList arraylist = new ArrayList(map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add((new StringBuilder()).append(y.encode((String)entry.getKey())).append("=").append(y.encode((String)entry.getValue())).toString()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return TextUtils.join("&", arraylist);
    }

    public void a(Map map, long l, String s1, Collection collection)
    {
        cp();
        co();
        a(map, collection);
        a(map, l, s1);
    }

    void a(String as[])
    {
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        aa.w("Empty hitIds passed to deleteHits.");
_L4:
        return;
_L2:
        Object obj = G("Error opening database for deleteHits.");
        if (obj == null) goto _L4; else goto _L3
_L3:
        String s1 = String.format("HIT_ID in (%s)", new Object[] {
            TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        if (obj instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        ((SQLiteDatabase) (obj)).delete("hits2", s1, as);
_L5:
        obj = rr;
        boolean flag;
        if (cq() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            ((e) (obj)).p(flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aa.w((new StringBuilder()).append("Error deleting hits ").append(as).toString());
        }
        return;
        SQLiteInstrumentation.delete((SQLiteDatabase)obj, "hits2", s1, as);
          goto _L5
    }

    void b(Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            aa.w("Empty/Null collection passed to deleteHits.");
            return;
        }
        String as[] = new String[collection.size()];
        collection = collection.iterator();
        for (int j = 0; collection.hasNext(); j++)
        {
            as[j] = String.valueOf(((x)collection.next()).ci());
        }

        a(as);
    }

    public void bp()
    {
        boolean flag = true;
        aa.v("Dispatch running...");
        if (!uc.bA())
        {
            return;
        }
        List list = t(40);
        if (list.isEmpty())
        {
            aa.v("...nothing to dispatch");
            rr.p(true);
            return;
        }
        if (ue == null)
        {
            ue = new ab("_t=dispatch&_v=ma4.0.0", true);
        }
        int j;
        if (cq() > list.size())
        {
            flag = false;
        }
        j = uc.a(list, ue, flag);
        aa.v((new StringBuilder()).append("sent ").append(j).append(" of ").append(list.size()).append(" hits").toString());
        b(list.subList(0, Math.min(j, list.size())));
        if (j == list.size() && cq() > 0)
        {
            GoogleAnalytics.getInstance(mContext).dispatchLocalHits();
            return;
        } else
        {
            ue = null;
            return;
        }
    }

    public n bq()
    {
        return uc;
    }

    int cp()
    {
        boolean flag = true;
        long l = rJ.currentTimeMillis();
        if (l > uf + 0x5265c00L)
        {
            uf = l;
            Object obj = G("Error opening database for deleteStaleHits.");
            if (obj != null)
            {
                long l1 = rJ.currentTimeMillis();
                String as[] = new String[1];
                as[0] = Long.toString(l1 - 0x9a7ec800L);
                int j;
                if (!(obj instanceof SQLiteDatabase))
                {
                    j = ((SQLiteDatabase) (obj)).delete("hits2", "HIT_TIME < ?", as);
                } else
                {
                    j = SQLiteInstrumentation.delete((SQLiteDatabase)obj, "hits2", "HIT_TIME < ?", as);
                }
                obj = rr;
                if (cq() != 0)
                {
                    flag = false;
                }
                ((e) (obj)).p(flag);
                return j;
            }
        }
        return 0;
    }

    int cq()
    {
        Object obj;
        Object obj1;
        SQLiteDatabase sqlitedatabase;
        obj = null;
        sqlitedatabase = G("Error opening database for getNumStoredHits.");
        if (sqlitedatabase == null)
        {
            return 0;
        }
        obj1 = obj;
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj = sqlitedatabase.rawQuery("SELECT COUNT(*) from hits2", null);
_L3:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj1 = obj;
        long l = ((Cursor) (obj)).getLong(0);
        int j = (int)l;
_L8:
        int k;
        k = j;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            k = j;
        }
_L4:
        return k;
_L2:
        obj1 = obj;
        obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT COUNT(*) from hits2", null);
          goto _L3
        obj;
        obj = null;
_L7:
        aa.w("Error getting numStoredHits");
        SQLiteException sqliteexception;
        Exception exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            k = 0;
        } else
        {
            k = 0;
        }
          goto _L4
        exception;
        obj = obj1;
        obj1 = exception;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj1;
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        sqliteexception;
          goto _L7
        j = 0;
          goto _L8
    }

    public void i(long l)
    {
        Object obj = G("Error opening database for clearHits");
        if (obj != null)
        {
            boolean flag;
            if (l == 0L)
            {
                if (!(obj instanceof SQLiteDatabase))
                {
                    ((SQLiteDatabase) (obj)).delete("hits2", null, null);
                } else
                {
                    SQLiteInstrumentation.delete((SQLiteDatabase)obj, "hits2", null, null);
                }
            } else
            {
                String as[] = new String[1];
                as[0] = Long.valueOf(l).toString();
                if (!(obj instanceof SQLiteDatabase))
                {
                    ((SQLiteDatabase) (obj)).delete("hits2", "hit_app_id = ?", as);
                } else
                {
                    SQLiteInstrumentation.delete((SQLiteDatabase)obj, "hits2", "hit_app_id = ?", as);
                }
            }
            obj = rr;
            if (cq() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((e) (obj)).p(flag);
        }
    }

    List s(int j)
    {
        Object obj;
        Object obj1;
        ArrayList arraylist;
        obj1 = null;
        arraylist = new ArrayList();
        if (j <= 0)
        {
            aa.w("Invalid maxHits specified. Skipping");
            return arraylist;
        }
        obj = G("Error opening database for peekHitIds.");
        if (obj == null)
        {
            return arraylist;
        }
        String as[] = new String[1];
        as[0] = "hit_id";
        String s1;
        String s2;
        s1 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        s2 = Integer.toString(j);
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("hits2", as, null, null, null, null, s1, s2);
_L5:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        arraylist.add(String.valueOf(((Cursor) (obj)).getLong(0)));
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
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "hits2", as, null, null, null, null, s1, s2);
          goto _L5
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L9:
        obj1 = obj;
        aa.w((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(sqliteexception.getMessage()).toString());
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

    public List t(int j)
    {
        Object obj1;
        Object obj4;
        obj1 = new ArrayList();
        obj4 = G("Error opening database for peekHits");
        if (obj4 != null) goto _L2; else goto _L1
_L1:
        Object obj2 = obj1;
_L13:
        return ((List) (obj2));
_L2:
        Object obj = null;
        obj2 = new String[2];
        obj2[0] = "hit_id";
        obj2[1] = "hit_time";
        Object obj3;
        String s1;
        obj3 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        s1 = Integer.toString(j);
        if (obj4 instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        obj2 = ((SQLiteDatabase) (obj4)).query("hits2", ((String []) (obj2)), null, null, null, null, ((String) (obj3)), s1);
        obj = obj2;
_L11:
        obj3 = new ArrayList();
        boolean flag;
        if (((Cursor) (obj)).moveToFirst())
        {
            do
            {
                ((List) (obj3)).add(new x(null, ((Cursor) (obj)).getLong(0), ((Cursor) (obj)).getLong(1)));
                flag = ((Cursor) (obj)).moveToNext();
            } while (flag);
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj1 = obj;
        obj2 = new String[3];
        obj2[0] = "hit_id";
        obj2[1] = "hit_string";
        obj2[2] = "hit_url";
        obj1 = obj;
        s1 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        obj1 = obj;
        String s2 = Integer.toString(j);
        obj1 = obj;
        if (obj4 instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        obj2 = ((SQLiteDatabase) (obj4)).query("hits2", ((String []) (obj2)), null, null, null, null, s1, s2);
        obj = obj2;
_L14:
        if (!((Cursor) (obj)).moveToFirst()) goto _L8; else goto _L7
_L7:
        j = 0;
_L24:
        if (((SQLiteCursor)obj).getWindow().getNumRows() <= 0) goto _L10; else goto _L9
_L9:
        ((x)((List) (obj3)).get(j)).E(((Cursor) (obj)).getString(1));
        ((x)((List) (obj3)).get(j)).F(((Cursor) (obj)).getString(2));
_L15:
        boolean flag1 = ((Cursor) (obj)).moveToNext();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_720;
        }
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj3));
_L4:
        obj2 = SQLiteInstrumentation.query((SQLiteDatabase)obj4, "hits2", ((String []) (obj2)), null, null, null, null, ((String) (obj3)), s1);
        obj = obj2;
          goto _L11
        obj2;
        obj3 = null;
        obj = obj1;
        obj1 = obj3;
_L23:
        aa.w((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(((SQLiteException) (obj2)).getMessage()).toString());
        obj2 = obj;
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        ((Cursor) (obj1)).close();
        return ((List) (obj));
        obj2;
        obj1 = obj;
        obj = obj2;
_L22:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L6:
        obj1 = obj;
        obj2 = SQLiteInstrumentation.query((SQLiteDatabase)obj4, "hits2", ((String []) (obj2)), null, null, null, null, s1, s2);
        obj = obj2;
          goto _L14
_L10:
        aa.w(String.format("HitString for hitId %d too large.  Hit will be deleted.", new Object[] {
            Long.valueOf(((x)((List) (obj3)).get(j)).ci())
        }));
          goto _L15
        obj2;
_L21:
        obj1 = obj;
        aa.w((new StringBuilder()).append("Error in peekHits fetching hitString: ").append(((SQLiteException) (obj2)).getMessage()).toString());
        obj1 = obj;
        obj2 = new ArrayList();
        j = 0;
        obj1 = obj;
        obj3 = ((List) (obj3)).iterator();
_L17:
        obj1 = obj;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_621;
        }
        obj1 = obj;
        obj4 = (x)((Iterator) (obj3)).next();
        obj1 = obj;
        flag1 = TextUtils.isEmpty(((x) (obj4)).ch());
        int k;
        k = j;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_637;
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_634;
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
        if (true) goto _L17; else goto _L16
_L16:
        obj;
_L19:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        obj2;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L19; else goto _L18
_L18:
        obj2;
        if (true) goto _L21; else goto _L20
_L20:
        obj2;
        obj1 = obj;
        obj = obj2;
          goto _L22
        obj;
          goto _L22
        obj2;
        obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L23
        obj2;
        obj1 = obj;
        obj = obj3;
          goto _L23
        j++;
          goto _L24
    }

}
