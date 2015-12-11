// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.helpshift.f.a;
import com.helpshift.f.b;
import com.helpshift.f.c;
import com.helpshift.i.d;
import com.helpshift.i.r;
import com.helpshift.v;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.helpshift.h:
//            d

public class e
{

    private static final com.helpshift.h.d a = new com.helpshift.h.d(v.a());
    private static SQLiteDatabase b;

    public static int a(a a1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a1);
        return a(((List) (arraylist)));
    }

    public static int a(c c1)
    {
        int i;
        synchronized (a)
        {
            b();
            i = b(c1);
            d();
        }
        return 0 + i;
        c1;
        d1;
        JVM INSTR monitorexit ;
        throw c1;
    }

    private static int a(String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = b;
        String as1[] = new String[1];
        as1[0] = "new_message_count";
        int i;
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            s = sqlitedatabase.query("issues", as1, s, as, null, null, null);
        } else
        {
            s = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "issues", as1, s, as, null, null, null);
        }
        if (s.moveToFirst())
        {
            i = s.getInt(s.getColumnIndex("new_message_count"));
        } else
        {
            i = 0;
        }
        s.close();
        return i;
    }

    public static int a(List list)
    {
        int i;
        i = 0;
        if (r.a(list))
        {
            return 0;
        }
        com.helpshift.h.d d1 = a;
        d1;
        JVM INSTR monitorenter ;
        b();
        b.beginTransaction();
        list = list.iterator();
_L7:
        if (!list.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        String as[];
        int j;
        obj = (a)list.next();
        j = c(((a) (obj)).i());
        as = new String[1];
        as[0] = ((a) (obj)).b();
        if (!com.helpshift.i.d.a(b, "issues", "issue_id=?", as)) goto _L4; else goto _L3
_L3:
        SQLiteDatabase sqlitedatabase1;
        if (((a) (obj)).h() != -1)
        {
            j += a("issue_id=?", as);
        }
        sqlitedatabase1 = b;
        obj = a(((a) (obj)), j);
        if (sqlitedatabase1 instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        sqlitedatabase1.update("issues", ((ContentValues) (obj)), "issue_id=?", as);
          goto _L7
_L6:
        SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase1, "issues", ((ContentValues) (obj)), "issue_id=?", as);
          goto _L7
        list;
        d1;
        JVM INSTR monitorexit ;
        throw list;
_L4:
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = b;
        obj = a(((a) (obj)), 0);
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.insert("issues", null, ((ContentValues) (obj)));
            break MISSING_BLOCK_LABEL_235;
        }
        SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "issues", null, ((ContentValues) (obj)));
        break MISSING_BLOCK_LABEL_235;
_L2:
        b.setTransactionSuccessful();
        b.endTransaction();
        d();
        d1;
        JVM INSTR monitorexit ;
        return i;
        i++;
          goto _L7
    }

    private static ContentValues a(a a1, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("profile_id", a1.a());
        contentvalues.put("issue_id", a1.b());
        contentvalues.put("body", a1.c());
        contentvalues.put("title", a1.d());
        contentvalues.put("created_at", a1.e());
        contentvalues.put("updated_at", a1.f());
        contentvalues.put("status", Integer.valueOf(a1.g()));
        contentvalues.put("new_message_count", Integer.valueOf(i));
        if (a1.j())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("show_agent_name", Integer.valueOf(i));
        return contentvalues;
    }

    private static a a(Cursor cursor)
    {
        boolean flag = true;
        String s = cursor.getString(cursor.getColumnIndex("profile_id"));
        String s1 = cursor.getString(cursor.getColumnIndex("issue_id"));
        String s2 = cursor.getString(cursor.getColumnIndex("body"));
        String s3 = cursor.getString(cursor.getColumnIndex("title"));
        String s4 = cursor.getString(cursor.getColumnIndex("created_at"));
        String s5 = cursor.getString(cursor.getColumnIndex("updated_at"));
        int i = cursor.getInt(cursor.getColumnIndex("status"));
        int j = cursor.getInt(cursor.getColumnIndex("new_message_count"));
        if (cursor.getInt(cursor.getColumnIndex("show_agent_name")) != 1)
        {
            flag = false;
        }
        return (new b(s, s1, s2, s3, s4, s5, i, flag)).a(j).a();
    }

    public static a a(String s)
    {
        com.helpshift.h.d d1 = a;
        d1;
        JVM INSTR monitorenter ;
        Object obj;
        String as[];
        c();
        obj = b;
        as = new String[1];
        as[0] = s;
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        s = ((SQLiteDatabase) (obj)).query("issues", null, "issue_id=?", as, null, null, null);
_L3:
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = a(((Cursor) (s)));
_L4:
        s.close();
        d();
        d1;
        JVM INSTR monitorexit ;
        if (obj != null)
        {
            ((a) (obj)).i();
        }
        return ((a) (obj));
_L2:
        s = SQLiteInstrumentation.query((SQLiteDatabase)obj, "issues", null, "issue_id=?", as, null, null, null);
          goto _L3
        s;
        d1;
        JVM INSTR monitorexit ;
        throw s;
        obj = null;
          goto _L4
    }

    public static void a()
    {
        synchronized (a)
        {
            c();
            d();
        }
        return;
        exception;
        d1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static int b(c c1)
    {
        String as[] = new String[1];
        as[0] = c1.b();
        if (com.helpshift.i.d.a(b, "messages", "message_id=?", as))
        {
            SQLiteDatabase sqlitedatabase1 = b;
            c1 = c(c1);
            if (!(sqlitedatabase1 instanceof SQLiteDatabase))
            {
                sqlitedatabase1.update("messages", c1, "message_id=?", as);
            } else
            {
                SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase1, "messages", c1, "message_id=?", as);
            }
        } else
        {
            SQLiteDatabase sqlitedatabase = b;
            ContentValues contentvalues = c(c1);
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.insert("messages", null, contentvalues);
            } else
            {
                SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "messages", null, contentvalues);
            }
            if (c1.d().equals("admin"))
            {
                return 1;
            }
        }
        return 0;
    }

    public static int b(List list)
    {
        if (r.a(list))
        {
            return 0;
        }
        int i;
        synchronized (a)
        {
            b();
            b.beginTransaction();
            i = c(list);
            b.setTransactionSuccessful();
            b.endTransaction();
            d();
        }
        return i;
        list;
        d1;
        JVM INSTR monitorexit ;
        throw list;
    }

    private static c b(Cursor cursor)
    {
        boolean flag1 = true;
        String s = cursor.getString(cursor.getColumnIndex("issue_id"));
        String s1 = cursor.getString(cursor.getColumnIndex("message_id"));
        String s2 = cursor.getString(cursor.getColumnIndex("body"));
        String s3 = cursor.getString(cursor.getColumnIndex("origin"));
        String s4 = cursor.getString(cursor.getColumnIndex("type"));
        String s5 = cursor.getString(cursor.getColumnIndex("created_at"));
        String s6 = cursor.getString(cursor.getColumnIndex("author"));
        String s7 = cursor.getString(cursor.getColumnIndex("meta"));
        String s8 = cursor.getString(cursor.getColumnIndex("screenshot"));
        int i = cursor.getInt(cursor.getColumnIndex("message_seen"));
        int j = cursor.getInt(cursor.getColumnIndex("invisible"));
        int k = cursor.getInt(cursor.getColumnIndex("in_progress"));
        cursor = (new com.helpshift.f.d(s, s1, s2, s3, s4, s5, s6, s7)).a(s8);
        boolean flag;
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor = cursor.a(flag);
        if (j == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cursor = cursor.b(flag);
        if (k == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return cursor.c(flag).a();
    }

    public static List b(String s)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (TextUtils.isEmpty(s))
        {
            return arraylist;
        }
        com.helpshift.h.d d1 = a;
        d1;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        String as[];
        c();
        sqlitedatabase = b;
        as = new String[1];
        as[0] = s;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = sqlitedatabase.query("issues", null, "profile_id=?", as, null, null, null);
_L1:
        if (s.moveToFirst())
        {
            for (; !s.isAfterLast(); s.moveToNext())
            {
                arraylist.add(a(s));
            }

        }
        break MISSING_BLOCK_LABEL_130;
        s;
        d1;
        JVM INSTR monitorexit ;
        throw s;
        s = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "issues", null, "profile_id=?", as, null, null, null);
          goto _L1
        s.close();
        d();
        d1;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    private static List b(String s, String as[])
    {
        ArrayList arraylist = new ArrayList();
        com.helpshift.h.d d1 = a;
        d1;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        c();
        sqlitedatabase = b;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s = sqlitedatabase.query("messages", null, s, as, null, null, null);
_L1:
        if (s.moveToFirst())
        {
            for (; !s.isAfterLast(); s.moveToNext())
            {
                arraylist.add(b(((Cursor) (s))));
            }

        }
        break MISSING_BLOCK_LABEL_108;
        s;
        d1;
        JVM INSTR monitorexit ;
        throw s;
        s = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "messages", null, s, as, null, null, null);
          goto _L1
        s.close();
        d();
        d1;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    private static void b()
    {
        b = a.getWritableDatabase();
    }

    private static int c(List list)
    {
        list = list.iterator();
        int i;
        for (i = 0; list.hasNext(); i = b((c)list.next()) + i) { }
        return i;
    }

    private static ContentValues c(c c1)
    {
        boolean flag = true;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("issue_id", c1.a());
        contentvalues.put("message_id", c1.b());
        contentvalues.put("body", c1.c());
        contentvalues.put("origin", c1.d());
        contentvalues.put("type", c1.e());
        contentvalues.put("created_at", c1.f());
        contentvalues.put("author", c1.g());
        contentvalues.put("meta", c1.h());
        contentvalues.put("screenshot", c1.i());
        int i;
        if (c1.j())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("message_seen", Integer.valueOf(i));
        if (c1.k())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("invisible", Integer.valueOf(i));
        if (c1.l())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        contentvalues.put("in_progress", Integer.valueOf(i));
        return contentvalues;
    }

    public static List c(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return new ArrayList();
        } else
        {
            return b("issue_id=?", new String[] {
                s
            });
        }
    }

    private static void c()
    {
        b = a.getReadableDatabase();
    }

    public static List d(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return new ArrayList();
        } else
        {
            return b("issue_id=? AND message_seen=? AND origin=?", new String[] {
                s, Integer.toString(0), "admin"
            });
        }
    }

    private static void d()
    {
        b.close();
    }

    public static c e(String s)
    {
        com.helpshift.h.d d1 = a;
        d1;
        JVM INSTR monitorenter ;
        Object obj;
        String as[];
        c();
        obj = b;
        as = new String[1];
        as[0] = s;
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        s = ((SQLiteDatabase) (obj)).query("messages", null, "message_id=?", as, null, null, null);
_L3:
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        obj = b(s);
_L4:
        s.close();
        d();
        d1;
        JVM INSTR monitorexit ;
        return ((c) (obj));
_L2:
        s = SQLiteInstrumentation.query((SQLiteDatabase)obj, "messages", null, "message_id=?", as, null, null, null);
          goto _L3
        s;
        d1;
        JVM INSTR monitorexit ;
        throw s;
        obj = null;
          goto _L4
    }

    public static void f(String s)
    {
        com.helpshift.h.d d1 = a;
        d1;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        String as[];
        b();
        sqlitedatabase = b;
        as = new String[1];
        as[0] = s;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        sqlitedatabase.delete("messages", "message_id=?", as);
_L2:
        d();
        d1;
        JVM INSTR monitorexit ;
        return;
        SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "messages", "message_id=?", as);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        d1;
        JVM INSTR monitorexit ;
        throw s;
    }

}
