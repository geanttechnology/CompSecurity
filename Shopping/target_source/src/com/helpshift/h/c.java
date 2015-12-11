// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.helpshift.a.a;
import com.helpshift.g;
import com.helpshift.i.j;
import com.helpshift.x;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.h:
//            a, b

public class c
    implements com.helpshift.h.a
{

    private SQLiteDatabase a;
    private final b b = com.helpshift.h.b.a();

    public c()
    {
    }

    private static ContentValues a(String s, JSONObject jsonobject)
        throws JSONException
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("question_id", jsonobject.getString("id"));
        contentvalues.put("publish_id", jsonobject.getString("publish_id"));
        contentvalues.put("section_id", s);
        contentvalues.put("title", jsonobject.getString("title"));
        contentvalues.put("body", jsonobject.getString("body"));
        contentvalues.put("helpful", Integer.valueOf(0));
        contentvalues.put("rtl", Boolean.valueOf(jsonobject.getString("is_rtl").equals("true")));
        if (jsonobject.has("stags"))
        {
            s = jsonobject.optJSONArray("stags");
            if (!(s instanceof JSONArray))
            {
                s = s.toString();
            } else
            {
                s = JSONArrayInstrumentation.toString((JSONArray)s);
            }
        } else
        {
            s = new JSONArray();
            if (!(s instanceof JSONArray))
            {
                s = s.toString();
            } else
            {
                s = JSONArrayInstrumentation.toString((JSONArray)s);
            }
        }
        contentvalues.put("tags", s);
        return contentvalues;
    }

    private static g a(Cursor cursor)
    {
        boolean flag = true;
        long l = cursor.getLong(0);
        String s = cursor.getString(1);
        String s1 = cursor.getString(2);
        String s2 = cursor.getString(3);
        String s3 = cursor.getString(4);
        String s4 = cursor.getString(5);
        int i = cursor.getInt(6);
        if (cursor.getInt(7) != 1)
        {
            flag = false;
        }
        return new g(l, s, s1, s2, s3, s4, i, Boolean.valueOf(flag), j.a(cursor.getString(8)));
    }

    public static void a(SQLiteDatabase sqlitedatabase, String s, JSONArray jsonarray)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < jsonarray.length())
                {
                    ContentValues contentvalues = a(s, jsonarray.getJSONObject(i));
                    if (!(sqlitedatabase instanceof SQLiteDatabase))
                    {
                        sqlitedatabase.insert("faqs", null, contentvalues);
                        break label0;
                    }
                    try
                    {
                        SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "faqs", null, contentvalues);
                        break label0;
                    }
                    // Misplaced declaration of an exception variable
                    catch (SQLiteDatabase sqlitedatabase)
                    {
                        x.b("HelpShiftDebug", "JSONException", sqlitedatabase);
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    private static g b(Cursor cursor)
    {
        return new g(0L, cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), "", 0, Boolean.valueOf(false), new ArrayList());
    }

    private void b(g g1)
    {
        ContentValues contentvalues = d(g1);
        g1 = b;
        g1;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        a();
        sqlitedatabase = a;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        sqlitedatabase.insert("faqs", null, contentvalues);
_L2:
        c();
        return;
        SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "faqs", null, contentvalues);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        g1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void c(g g1)
    {
        ContentValues contentvalues = d(g1);
        b b1 = b;
        b1;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        String as[];
        a();
        sqlitedatabase = a;
        as = new String[1];
        as[0] = g1.a();
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        sqlitedatabase.update("faqs", contentvalues, "question_id = ?", as);
_L2:
        c();
        return;
        SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "faqs", contentvalues, "question_id = ?", as);
        if (true) goto _L2; else goto _L1
_L1:
        g1;
        b1;
        JVM INSTR monitorexit ;
        throw g1;
    }

    private static ContentValues d(g g1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("question_id", g1.a());
        contentvalues.put("publish_id", g1.b());
        contentvalues.put("section_id", g1.c());
        contentvalues.put("title", g1.e());
        contentvalues.put("body", g1.f());
        contentvalues.put("helpful", Integer.valueOf(g1.g()));
        contentvalues.put("rtl", g1.i());
        contentvalues.put("tags", String.valueOf(new JSONArray(g1.h())));
        return contentvalues;
    }

    public int a(String s, Boolean boolean1)
    {
        ContentValues contentvalues;
        SQLiteDatabase sqlitedatabase;
        String as[];
        int i;
        i = 1;
        if (TextUtils.isEmpty(s))
        {
            return 0;
        }
        contentvalues = new ContentValues();
        if (!boolean1.booleanValue())
        {
            i = -1;
        }
        contentvalues.put("helpful", Integer.valueOf(i));
        boolean1 = b;
        boolean1;
        JVM INSTR monitorenter ;
        a();
        sqlitedatabase = a;
        as = new String[1];
        as[0] = s;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        i = sqlitedatabase.update("faqs", contentvalues, "question_id = ?", as);
_L1:
        c();
        boolean1;
        JVM INSTR monitorexit ;
        return i;
        s;
        boolean1;
        JVM INSTR monitorexit ;
        throw s;
        i = SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "faqs", contentvalues, "question_id = ?", as);
          goto _L1
    }

    public g a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return new g();
        }
        b b1 = b;
        b1;
        JVM INSTR monitorenter ;
        Object obj;
        String as[];
        b();
        obj = a;
        as = new String[1];
        as[0] = s;
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        s = ((SQLiteDatabase) (obj)).query("faqs", null, "publish_id = ?", as, null, null, null);
_L3:
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        obj = a(((Cursor) (s)));
_L4:
        s.close();
        c();
        b1;
        JVM INSTR monitorexit ;
        return ((g) (obj));
        s;
        b1;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = SQLiteInstrumentation.query((SQLiteDatabase)obj, "faqs", null, "publish_id = ?", as, null, null, null);
          goto _L3
        obj = null;
          goto _L4
    }

    public void a()
    {
        a = b.getWritableDatabase();
    }

    public void a(g g1)
    {
        if (a(g1.b()) == null)
        {
            b(g1);
            return;
        } else
        {
            c(g1);
            return;
        }
    }

    public List b(String s)
    {
        ArrayList arraylist;
        if (TextUtils.isEmpty(s))
        {
            return new ArrayList();
        }
        arraylist = new ArrayList();
        b b1 = b;
        b1;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        String as[];
        b();
        sqlitedatabase = a;
        as = new String[1];
        as[0] = s;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        s = sqlitedatabase.query("faqs", null, "section_id = ?", as, null, null, null);
_L1:
        if (s.moveToFirst())
        {
            for (; !s.isAfterLast(); s.moveToNext())
            {
                arraylist.add(a(s));
            }

        }
        break MISSING_BLOCK_LABEL_143;
        s;
        b1;
        JVM INSTR monitorexit ;
        throw s;
        s = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "faqs", null, "section_id = ?", as, null, null, null);
          goto _L1
        s.close();
        c();
        b1;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public void b()
    {
        a = b.getReadableDatabase();
    }

    public List c(String s)
    {
        ArrayList arraylist;
        if (TextUtils.isEmpty(s))
        {
            return new ArrayList();
        }
        arraylist = new ArrayList();
        b b1 = b;
        b1;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        String as[];
        String as1[];
        b();
        sqlitedatabase = a;
        as = a.a;
        as1 = new String[1];
        as1[0] = s;
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s = sqlitedatabase.query("faqs", as, "section_id = ?", as1, null, null, null);
_L1:
        if (s.moveToFirst())
        {
            for (; !s.isAfterLast(); s.moveToNext())
            {
                arraylist.add(b(s));
            }

        }
        break MISSING_BLOCK_LABEL_150;
        s;
        b1;
        JVM INSTR monitorexit ;
        throw s;
        s = SQLiteInstrumentation.query((SQLiteDatabase)sqlitedatabase, "faqs", as, "section_id = ?", as1, null, null, null);
          goto _L1
        s.close();
        c();
        b1;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public void c()
    {
        b.close();
    }
}
