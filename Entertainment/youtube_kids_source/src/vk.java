// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

public class vk
{

    final HttpClient a;
    final LinkedHashSet b = new LinkedHashSet(10);
    final ArrayList c = new ArrayList(10);
    String d;
    final vh e;
    final String f;

    public vk(Context context, HttpClient httpclient, String s)
    {
        b.a(context);
        a = (HttpClient)b.a(httpclient);
        f = (String)b.a(s);
        e = new vh(context);
    }

    public Collection a(String s)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        b(s);
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s.trim())) goto _L2; else goto _L1
_L1:
        s = new ArrayList(c);
_L5:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        String s1;
        b.clear();
        b.addAll(c);
        s1 = URLEncoder.encode(s, "UTF-8");
        s = Locale.getDefault().getLanguage();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        if (s.length() != 2)
        {
            break MISSING_BLOCK_LABEL_316;
        }
_L6:
        int j;
        s = String.format("https://suggestqueries.google.com/complete/search?hl=%s&ds=yt&client=%s&hjson=t&oe=UTF-8&q=%s", new Object[] {
            s, f, s1
        });
        s = a.execute(new HttpGet(s));
        j = s.getStatusLine().getStatusCode();
        if (j != 200)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        d = EntityUtils.toString(s.getEntity(), "UTF-8");
        s = d;
        s = (new JSONArray(s)).getJSONArray(1);
_L3:
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_301;
        }
        String s2 = s.getJSONArray(i).getString(0);
        b.add(new vj(s2));
        i++;
          goto _L3
        JSONException jsonexception;
        jsonexception;
        s = String.valueOf(d);
        if (s.length() == 0)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        s = "error fetching suggestions, response was ".concat(s);
_L4:
        throw new IOException(s, jsonexception);
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        s = new String("error fetching suggestions, response was ");
          goto _L4
        bmo.e((new StringBuilder(39)).append("unexpected suggest response ").append(j).toString());
        s = new LinkedHashSet(b);
          goto _L5
        s = "en";
          goto _L6
    }

    public void a(ContentValues contentvalues)
    {
        e.a.getWritableDatabase().insert("suggestions", "query", contentvalues);
    }

    void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        c.clear();
        vh vh1 = e;
        SQLiteDatabase sqlitedatabase = vh1.a.getReadableDatabase();
        s = (new StringBuilder(String.valueOf(s).length() + 2)).append("%").append(s).append("%").toString();
        s = sqlitedatabase.query("suggestions", vh1.b, "suggest_intent_query LIKE ?", new String[] {
            s
        }, null, null, "date DESC");
        int i;
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        i = s.getColumnIndex("suggest_intent_query");
        boolean flag;
        do
        {
            String s1 = s.getString(i);
            c.add(new vj(s1));
            flag = s.moveToNext();
        } while (flag);
        s.close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        s.close();
        throw exception;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }
}
