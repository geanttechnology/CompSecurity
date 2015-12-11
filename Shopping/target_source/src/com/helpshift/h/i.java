// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.ab;
import com.helpshift.x;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.h:
//            h, b, c, a

public class i
    implements h
{

    private SQLiteDatabase a;
    private final b b = com.helpshift.h.b.a();
    private a c;

    public i()
    {
        c = new c();
    }

    private static ContentValues a(JSONObject jsonobject)
        throws JSONException
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("title", jsonobject.getString("title"));
        contentvalues.put("publish_id", jsonobject.getString("publish_id"));
        contentvalues.put("section_id", jsonobject.getString("id"));
        return contentvalues;
    }

    private static ab a(Cursor cursor)
    {
        return new ab(cursor.getLong(0), cursor.getString(1), cursor.getString(3), cursor.getString(2));
    }

    public ab a(String s)
    {
        if (s == null || s.equals(""))
        {
            return new ab();
        }
        b b1 = b;
        b1;
        JVM INSTR monitorenter ;
        Object obj;
        String as[];
        d();
        obj = a;
        as = new String[1];
        as[0] = s;
        if (obj instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        s = ((SQLiteDatabase) (obj)).query("sections", null, "publish_id = ?", as, null, null, null);
_L3:
        s.moveToFirst();
        if (s.isAfterLast())
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj = a(((Cursor) (s)));
_L4:
        s.close();
        e();
        b1;
        JVM INSTR monitorexit ;
        return ((ab) (obj));
        s;
        b1;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = SQLiteInstrumentation.query((SQLiteDatabase)obj, "sections", null, "publish_id = ?", as, null, null, null);
          goto _L3
        obj = null;
          goto _L4
    }

    public List a()
    {
        ArrayList arraylist = new ArrayList();
        b b1 = b;
        b1;
        JVM INSTR monitorenter ;
        Object obj;
        d();
        obj = a;
        if (obj instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = ((SQLiteDatabase) (obj)).query("sections", null, null, null, null, null, null);
_L1:
        ((Cursor) (obj)).moveToFirst();
        for (; !((Cursor) (obj)).isAfterLast(); ((Cursor) (obj)).moveToNext())
        {
            arraylist.add(a(((Cursor) (obj))));
        }

        break MISSING_BLOCK_LABEL_105;
        obj;
        b1;
        JVM INSTR monitorexit ;
        throw obj;
        obj = SQLiteInstrumentation.query((SQLiteDatabase)obj, "sections", null, null, null, null, null, null);
          goto _L1
        ((Cursor) (obj)).close();
        e();
        b1;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public void a(JSONArray jsonarray)
    {
        b b1 = b;
        b1;
        JVM INSTR monitorenter ;
        c();
        a.beginTransaction();
        int j = 0;
_L6:
        if (j >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        ContentValues contentvalues;
        obj = jsonarray.getJSONObject(j);
        obj1 = a;
        contentvalues = a(((JSONObject) (obj)));
        if (obj1 instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        ((SQLiteDatabase) (obj1)).insert("sections", null, contentvalues);
_L3:
        obj1 = ((JSONObject) (obj)).optJSONArray("faqs");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        try
        {
            obj = ((JSONObject) (obj)).getString("publish_id");
            com.helpshift.h.c.a(a, ((String) (obj)), ((JSONArray) (obj1)));
            break MISSING_BLOCK_LABEL_174;
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray) { }
        finally { }
        break MISSING_BLOCK_LABEL_119;
        SQLiteInstrumentation.insert((SQLiteDatabase)obj1, "sections", null, contentvalues);
          goto _L3
        x.b("HelpShiftDebug", "JSONException", jsonarray);
        a.endTransaction();
_L4:
        e();
        b1;
        JVM INSTR monitorexit ;
        return;
_L2:
        a.setTransactionSuccessful();
        a.endTransaction();
          goto _L4
        jsonarray;
        b1;
        JVM INSTR monitorexit ;
        throw jsonarray;
        a.endTransaction();
        throw jsonarray;
        j++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void b()
    {
        synchronized (b)
        {
            c();
            b.a(a);
            b.onCreate(a);
            e();
        }
        return;
        exception;
        b1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        a = b.getWritableDatabase();
    }

    public void d()
    {
        a = b.getReadableDatabase();
    }

    public void e()
    {
        b.close();
    }
}
