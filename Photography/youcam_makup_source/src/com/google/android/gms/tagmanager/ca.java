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
import android.text.TextUtils;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.google.android.gms.tagmanager:
//            at, da, bh, au, 
//            ap, ab, cx

class ca
    implements at
{

    private static final String wP = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] {
        "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"
    });
    private ij aef;
    private final b agq;
    private volatile ab agr;
    private final au ags;
    private final Context mContext;
    private final String wS;
    private long wU;
    private final int wV;

    ca(au au1, Context context)
    {
        this(au1, context, "gtm_urls.db", 2000);
    }

    ca(au au1, Context context, String s, int i)
    {
        mContext = context.getApplicationContext();
        wS = s;
        ags = au1;
        aef = il.gb();
        agq = new b(mContext, wS);
        agr = new da(new DefaultHttpClient(), mContext, new a());
        wU = 0L;
        wV = i;
    }

    private SQLiteDatabase S(String s)
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = agq.getWritableDatabase();
        }
        catch (SQLiteException sqliteexception)
        {
            bh.D(s);
            return null;
        }
        return sqlitedatabase;
    }

    static ij a(ca ca1)
    {
        return ca1.aef;
    }

    static void a(ca ca1, long l)
    {
        ca1.y(l);
    }

    static void a(ca ca1, long l, long l1)
    {
        ca1.c(l, l1);
    }

    static String b(ca ca1)
    {
        return ca1.wS;
    }

    static Context c(ca ca1)
    {
        return ca1.mContext;
    }

    private void c(long l, long l1)
    {
        SQLiteDatabase sqlitedatabase = S("Error opening database for getNumStoredHits.");
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
            bh.D((new StringBuilder()).append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ").append(l).toString());
        }
        y(l);
    }

    private void dr()
    {
        int i = (dt() - wV) + 1;
        if (i > 0)
        {
            List list = A(i);
            bh.C((new StringBuilder()).append("Store full, deleting ").append(list.size()).append(" hits to make room.").toString());
            a((String[])list.toArray(new String[0]));
        }
    }

    private void g(long l, String s)
    {
        SQLiteDatabase sqlitedatabase = S("Error opening database for putHit");
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
            ags.s(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            bh.D("Error storing hit");
        }
    }

    static String mc()
    {
        return wP;
    }

    private void y(long l)
    {
        a(new String[] {
            String.valueOf(l)
        });
    }

    List A(int i)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (i <= 0)
        {
            bh.D("Invalid maxHits specified. Skipping");
            return arraylist;
        }
        obj = S("Error opening database for peekHitIds.");
        if (obj == null)
        {
            return arraylist;
        }
        Object obj1;
        obj1 = String.format("%s ASC", new Object[] {
            "hit_id"
        });
        String s = Integer.toString(i);
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
        bh.D((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(sqliteexception.getMessage()).toString());
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

    public List B(int i)
    {
        Object obj1;
        Object obj4;
        obj1 = new ArrayList();
        obj4 = S("Error opening database for peekHits");
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
        String s = Integer.toString(i);
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
                ((List) (obj3)).add(new ap(((Cursor) (obj)).getLong(0), ((Cursor) (obj)).getLong(1), ((Cursor) (obj)).getLong(2)));
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
        String s1 = Integer.toString(i);
        obj1 = obj;
        obj2 = ((SQLiteDatabase) (obj4)).query("gtm_hits", new String[] {
            "hit_id", "hit_url"
        }, null, null, null, null, ((String) (obj2)), s1);
        if (!((Cursor) (obj2)).moveToFirst()) goto _L4; else goto _L3
_L3:
        i = 0;
_L18:
        if (((SQLiteCursor)obj2).getWindow().getNumRows() <= 0) goto _L6; else goto _L5
_L5:
        ((ap)((List) (obj3)).get(i)).R(((Cursor) (obj2)).getString(1));
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
        bh.D((new StringBuilder()).append("Error in peekHits fetching hitIds: ").append(((SQLiteException) (obj2)).getMessage()).toString());
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
        bh.D(String.format("HitString for hitId %d too large.  Hit will be deleted.", new Object[] {
            Long.valueOf(((ap)((List) (obj3)).get(i)).dl())
        }));
          goto _L9
        obj1;
        obj = obj2;
        obj2 = obj1;
_L15:
        obj1 = obj;
        bh.D((new StringBuilder()).append("Error in peekHits fetching hit url: ").append(((SQLiteException) (obj2)).getMessage()).toString());
        obj1 = obj;
        obj2 = new ArrayList();
        i = 0;
        obj1 = obj;
        obj3 = ((List) (obj3)).iterator();
_L11:
        obj1 = obj;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_521;
        }
        obj1 = obj;
        obj4 = (ap)((Iterator) (obj3)).next();
        obj1 = obj;
        flag1 = TextUtils.isEmpty(((ap) (obj4)).lO());
        int j;
        j = i;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_537;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_534;
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
        i++;
          goto _L18
    }

    void a(String as[])
    {
        boolean flag = true;
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase;
        return;
_L2:
        if ((sqlitedatabase = S("Error opening database for deleteHits.")) == null) goto _L1; else goto _L3
_L3:
        String s = String.format("HIT_ID in (%s)", new Object[] {
            TextUtils.join(",", Collections.nCopies(as.length, "?"))
        });
        sqlitedatabase.delete("gtm_hits", s, as);
        as = ags;
        if (dt() != 0)
        {
            flag = false;
        }
        as.s(flag);
        return;
        as;
        bh.D("Error deleting hits");
        return;
    }

    public void cq()
    {
        bh.C("GTM Dispatch running...");
        if (agr.cC())
        {
            List list = B(40);
            if (list.isEmpty())
            {
                bh.C("...nothing to dispatch");
                ags.s(true);
                return;
            }
            agr.g(list);
            if (mb() > 0)
            {
                cx.mQ().cq();
                return;
            }
        }
    }

    int ds()
    {
        boolean flag = true;
        long l = aef.currentTimeMillis();
        if (l > wU + 0x5265c00L)
        {
            wU = l;
            Object obj = S("Error opening database for deleteStaleHits.");
            if (obj != null)
            {
                int i = ((SQLiteDatabase) (obj)).delete("gtm_hits", "HIT_TIME < ?", new String[] {
                    Long.toString(aef.currentTimeMillis() - 0x9a7ec800L)
                });
                obj = ags;
                if (dt() != 0)
                {
                    flag = false;
                }
                ((au) (obj)).s(flag);
                return i;
            }
        }
        return 0;
    }

    int dt()
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
        obj1 = S("Error opening database for getNumStoredHits.");
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return j;
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
        bh.D("Error getting numStoredHits");
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

    public void f(long l, String s)
    {
        ds();
        dr();
        g(l, s);
    }

    int mb()
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = S("Error opening database for getNumStoredHits.");
        if (obj == null)
        {
            return 0;
        }
        obj = ((SQLiteDatabase) (obj)).query("gtm_hits", new String[] {
            "hit_id", "hit_first_send_time"
        }, "hit_first_send_time=0", null, null, null, null);
        int j = ((Cursor) (obj)).getCount();
        int i;
        i = j;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            i = j;
        }
_L1:
        return i;
        obj;
        obj = null;
_L4:
        bh.D("Error getting num untried hits");
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


    /* member class not found */
    class b {}


    private class a
        implements da.a
    {

        final ca agt;

        public void a(ap ap1)
        {
            ca.a(agt, ap1.dl());
        }

        public void b(ap ap1)
        {
            ca.a(agt, ap1.dl());
            bh.C((new StringBuilder()).append("Permanent failure dispatching hitId: ").append(ap1.dl()).toString());
        }

        public void c(ap ap1)
        {
            long l = ap1.lN();
            if (l == 0L)
            {
                ca.a(agt, ap1.dl(), ca.a(agt).currentTimeMillis());
            } else
            if (l + 0xdbba00L < ca.a(agt).currentTimeMillis())
            {
                ca.a(agt, ap1.dl());
                bh.C((new StringBuilder()).append("Giving up on failed hitId: ").append(ap1.dl()).toString());
                return;
            }
        }

        a()
        {
            agt = ca.this;
            super();
        }
    }

}
