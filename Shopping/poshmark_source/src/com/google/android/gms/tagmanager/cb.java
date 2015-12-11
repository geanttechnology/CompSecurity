// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.google.android.gms.tagmanager:
//            at, db, bh, au, 
//            ab, cy, ap, ak

class cb
    implements at
{
    class a
        implements db.a
    {

        final cb VO;

        public void a(ap ap1)
        {
            cb.a(VO, ap1.ci());
        }

        public void b(ap ap1)
        {
            cb.a(VO, ap1.ci());
            bh.v((new StringBuilder()).append("Permanent failure dispatching hitId: ").append(ap1.ci()).toString());
        }

        public void c(ap ap1)
        {
            long l = ap1.je();
            if (l == 0L)
            {
                cb.a(VO, ap1.ci(), cb.a(VO).currentTimeMillis());
            } else
            if (l + 0xdbba00L < cb.a(VO).currentTimeMillis())
            {
                cb.a(VO, ap1.ci());
                bh.v((new StringBuilder()).append("Giving up on failed hitId: ").append(ap1.ci()).toString());
                return;
            }
        }

        a()
        {
            VO = cb.this;
            super();
        }
    }

    class b extends SQLiteOpenHelper
    {

        final cb VO;
        private boolean ui;
        private long uj;

        private void a(SQLiteDatabase sqlitedatabase)
        {
            Object obj;
            String as[];
            int i;
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase = sqlitedatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            } else
            {
                sqlitedatabase = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT * FROM gtm_hits WHERE 0", null);
            }
            obj = new HashSet();
            as = sqlitedatabase.getColumnNames();
            i = 0;
_L2:
            if (i >= as.length)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Set) (obj)).add(as[i]);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            sqlitedatabase.close();
            if (!((Set) (obj)).remove("hit_id") || !((Set) (obj)).remove("hit_url") || !((Set) (obj)).remove("hit_time") || !((Set) (obj)).remove("hit_first_send_time"))
            {
                throw new SQLiteException("Database column missing");
            }
            break MISSING_BLOCK_LABEL_143;
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
            bh.w((new StringBuilder()).append("Error querying for table ").append(s1).toString());
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
            if (ui && uj + 0x36ee80L > cb.a(VO).currentTimeMillis())
            {
                throw new SQLiteException("Database creation failed");
            }
            sqlitedatabase = null;
            ui = true;
            uj = cb.a(VO).currentTimeMillis();
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
            cb.c(VO).getDatabasePath(cb.b(VO)).delete();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            ak.B(sqlitedatabase.getPath());
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
            if (!a("gtm_hits", sqlitedatabase))
            {
                obj = cb.jt();
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

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
        }

        b(Context context, String s1)
        {
            VO = cb.this;
            super(context, s1, null, 1);
            uj = 0L;
        }
    }


    private static final String ua = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] {
        "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"
    });
    private fl Ty;
    private final b VL;
    private volatile ab VM;
    private final au VN;
    private final Context mContext;
    private final String ud;
    private long uf;
    private final int ug;

    cb(au au1, Context context)
    {
        this(au1, context, "gtm_urls.db", 2000);
    }

    cb(au au1, Context context, String s1, int i)
    {
        mContext = context.getApplicationContext();
        ud = s1;
        VN = au1;
        Ty = fn.eI();
        VL = new b(mContext, ud);
        VM = new db(new DefaultHttpClient(), mContext, new a());
        uf = 0L;
        ug = i;
    }

    private SQLiteDatabase G(String s1)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = VL.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            bh.w(s1);
            return null;
        }
        return sqlitedatabase;
    }

    static fl a(cb cb1)
    {
        return cb1.Ty;
    }

    static void a(cb cb1, long l)
    {
        cb1.u(l);
    }

    static void a(cb cb1, long l, long l1)
    {
        cb1.c(l, l1);
    }

    static String b(cb cb1)
    {
        return cb1.ud;
    }

    static Context c(cb cb1)
    {
        return cb1.mContext;
    }

    private void c(long l, long l1)
    {
        Object obj;
        ContentValues contentvalues;
        String as[];
        obj = G("Error opening database for getNumStoredHits.");
        if (obj == null)
        {
            return;
        }
        contentvalues = new ContentValues();
        contentvalues.put("hit_first_send_time", Long.valueOf(l1));
        try
        {
            as = new String[1];
            as[0] = String.valueOf(l);
            if (!(obj instanceof SQLiteDatabase))
            {
                ((SQLiteDatabase) (obj)).update("gtm_hits", contentvalues, "hit_id=?", as);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bh.w((new StringBuilder()).append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ").append(l).toString());
            u(l);
            return;
        }
        SQLiteInstrumentation.update((SQLiteDatabase)obj, "gtm_hits", contentvalues, "hit_id=?", as);
        return;
    }

    private void co()
    {
        int i = (cq() - ug) + 1;
        if (i > 0)
        {
            List list = s(i);
            bh.v((new StringBuilder()).append("Store full, deleting ").append(list.size()).append(" hits to make room.").toString());
            a((String[])list.toArray(new String[0]));
        }
    }

    private void f(long l, String s1)
    {
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = G("Error opening database for putHit");
        if (sqlitedatabase == null)
        {
            return;
        }
        contentvalues = new ContentValues();
        contentvalues.put("hit_time", Long.valueOf(l));
        contentvalues.put("hit_url", s1);
        contentvalues.put("hit_first_send_time", Integer.valueOf(0));
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        sqlitedatabase.insert("gtm_hits", null, contentvalues);
_L1:
        VN.p(false);
        return;
        try
        {
            SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "gtm_hits", null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            bh.w("Error storing hit");
            return;
        }
          goto _L1
    }

    static String jt()
    {
        return ua;
    }

    private void u(long l)
    {
        a(new String[] {
            String.valueOf(l)
        });
    }

    void a(String as[])
    {
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase;
        return;
_L2:
        if ((sqlitedatabase = G("Error opening database for deleteHits.")) == null) goto _L1; else goto _L3
_L3:
        String s1 = String.format("HIT_ID in (%s)", new Object[] {
            TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        sqlitedatabase.delete("gtm_hits", s1, as);
_L4:
        as = VN;
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
            as.p(flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            bh.w("Error deleting hits");
        }
        return;
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "gtm_hits", s1, as);
          goto _L4
    }

    public void bp()
    {
        bh.v("GTM Dispatch running...");
        if (VM.bA())
        {
            List list = t(40);
            if (list.isEmpty())
            {
                bh.v("...nothing to dispatch");
                VN.p(true);
                return;
            }
            VM.e(list);
            if (js() > 0)
            {
                cy.kh().bp();
                return;
            }
        }
    }

    int cp()
    {
        boolean flag = true;
        long l = Ty.currentTimeMillis();
        if (l > uf + 0x5265c00L)
        {
            uf = l;
            Object obj = G("Error opening database for deleteStaleHits.");
            if (obj != null)
            {
                long l1 = Ty.currentTimeMillis();
                String as[] = new String[1];
                as[0] = Long.toString(l1 - 0x9a7ec800L);
                int i;
                if (!(obj instanceof SQLiteDatabase))
                {
                    i = ((SQLiteDatabase) (obj)).delete("gtm_hits", "HIT_TIME < ?", as);
                } else
                {
                    i = SQLiteInstrumentation.delete((SQLiteDatabase)obj, "gtm_hits", "HIT_TIME < ?", as);
                }
                obj = VN;
                if (cq() != 0)
                {
                    flag = false;
                }
                ((au) (obj)).p(flag);
                return i;
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
        obj = sqlitedatabase.rawQuery("SELECT COUNT(*) from gtm_hits", null);
_L3:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_156;
        }
        obj1 = obj;
        long l = ((Cursor) (obj)).getLong(0);
        int i = (int)l;
_L8:
        int j;
        j = i;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            j = i;
        }
_L4:
        return j;
_L2:
        obj1 = obj;
        obj = SQLiteInstrumentation.rawQuery((SQLiteDatabase)sqlitedatabase, "SELECT COUNT(*) from gtm_hits", null);
          goto _L3
        obj;
        obj = null;
_L7:
        bh.w("Error getting numStoredHits");
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
        i = 0;
          goto _L8
    }

    public void e(long l, String s1)
    {
        cp();
        co();
        f(l, s1);
    }

    int js()
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = G("Error opening database for getNumStoredHits.");
        if (obj == null)
        {
            return 0;
        }
        String as[] = new String[2];
        as[0] = "hit_id";
        as[1] = "hit_first_send_time";
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("gtm_hits", as, "hit_first_send_time=0", null, null, null, null);
_L3:
        int j = ((Cursor) (obj)).getCount();
        int i;
        i = j;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            i = j;
        }
_L4:
        return i;
_L2:
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "gtm_hits", as, "hit_first_send_time=0", null, null, null, null);
          goto _L3
        obj;
        obj = null;
_L7:
        bh.w("Error getting num untried hits");
        SQLiteException sqliteexception;
        Exception exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            i = 0;
        } else
        {
            i = 0;
        }
          goto _L4
        obj;
_L6:
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
        if (true) goto _L6; else goto _L5
_L5:
        sqliteexception;
          goto _L7
    }

    List s(int i)
    {
        Object obj;
        Object obj1;
        ArrayList arraylist;
        obj1 = null;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            bh.w("Invalid maxHits specified. Skipping");
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
        s2 = Integer.toString(i);
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        obj = ((SQLiteDatabase) (obj)).query("gtm_hits", as, null, null, null, null, s1, s2);
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
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "gtm_hits", as, null, null, null, null, s1, s2);
          goto _L5
        SQLiteException sqliteexception;
        sqliteexception;
        obj = null;
_L9:
        obj1 = obj;
        bh.w((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(sqliteexception.getMessage()).toString());
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

    public List t(int i)
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
        obj2 = new String[3];
        obj2[0] = "hit_id";
        obj2[1] = "hit_time";
        obj2[2] = "hit_first_send_time";
        Object obj3;
        String s1;
        obj3 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        s1 = Integer.toString(i);
        if (obj4 instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        obj2 = ((SQLiteDatabase) (obj4)).query("gtm_hits", ((String []) (obj2)), null, null, null, null, ((String) (obj3)), s1);
        obj = obj2;
_L11:
        obj3 = new ArrayList();
        boolean flag;
        if (((Cursor) (obj)).moveToFirst())
        {
            do
            {
                ((List) (obj3)).add(new ap(((Cursor) (obj)).getLong(0), ((Cursor) (obj)).getLong(1), ((Cursor) (obj)).getLong(2)));
                flag = ((Cursor) (obj)).moveToNext();
            } while (flag);
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        obj1 = obj;
        obj2 = new String[2];
        obj2[0] = "hit_id";
        obj2[1] = "hit_url";
        obj1 = obj;
        s1 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        obj1 = obj;
        String s2 = Integer.toString(i);
        obj1 = obj;
        if (obj4 instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        obj2 = ((SQLiteDatabase) (obj4)).query("gtm_hits", ((String []) (obj2)), null, null, null, null, s1, s2);
        obj = obj2;
_L14:
        if (!((Cursor) (obj)).moveToFirst()) goto _L8; else goto _L7
_L7:
        i = 0;
_L24:
        if (((SQLiteCursor)obj).getWindow().getNumRows() <= 0) goto _L10; else goto _L9
_L9:
        ((ap)((List) (obj3)).get(i)).F(((Cursor) (obj)).getString(1));
_L15:
        boolean flag1 = ((Cursor) (obj)).moveToNext();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_705;
        }
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj3));
_L4:
        obj2 = SQLiteInstrumentation.query((SQLiteDatabase)obj4, "gtm_hits", ((String []) (obj2)), null, null, null, null, ((String) (obj3)), s1);
        obj = obj2;
          goto _L11
        obj2;
        obj3 = null;
        obj = obj1;
        obj1 = obj3;
_L23:
        bh.w((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(((SQLiteException) (obj2)).getMessage()).toString());
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
        obj2 = SQLiteInstrumentation.query((SQLiteDatabase)obj4, "gtm_hits", ((String []) (obj2)), null, null, null, null, s1, s2);
        obj = obj2;
          goto _L14
_L10:
        bh.w(String.format("HitString for hitId %d too large.  Hit will be deleted.", new Object[] {
            Long.valueOf(((ap)((List) (obj3)).get(i)).ci())
        }));
          goto _L15
        obj2;
_L21:
        obj1 = obj;
        bh.w((new StringBuilder()).append("Error in peekHits fetching hit url: ").append(((SQLiteException) (obj2)).getMessage()).toString());
        obj1 = obj;
        obj2 = new ArrayList();
        i = 0;
        obj1 = obj;
        obj3 = ((List) (obj3)).iterator();
_L17:
        obj1 = obj;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_606;
        }
        obj1 = obj;
        obj4 = (ap)((Iterator) (obj3)).next();
        obj1 = obj;
        flag1 = TextUtils.isEmpty(((ap) (obj4)).jf());
        int j;
        j = i;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_622;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_619;
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((List) (obj2));
        j = 1;
        obj1 = obj;
        ((List) (obj2)).add(obj4);
        i = j;
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
        i++;
          goto _L24
    }

}
