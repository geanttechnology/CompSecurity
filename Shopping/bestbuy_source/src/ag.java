// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag
{

    private static final HashSet a;
    private final am b;
    private long c;
    private final az d;
    private final a e;
    private final b._cls1 f;

    ag(am am1, a a1, az az1, b._cls1 _pcls1)
    {
        b = am1;
        e = a1;
        c = -1L;
        d = az1;
        f = _pcls1;
    }

    private String a(Throwable throwable)
    {
        long l = System.currentTimeMillis();
        if (c + 60000L > l)
        {
            return "Unknown";
        } else
        {
            c = l;
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            return stringwriter.toString();
        }
    }

    private JSONObject a(String s)
    {
        JSONObject jsonobject = az.a();
        b.a(jsonobject);
        jsonobject.put("type", s);
        return jsonobject;
    }

    private void a(JSONObject jsonobject, StackTraceElement astacktraceelement[])
    {
        JSONArray jsonarray = az.b();
        int j = astacktraceelement.length;
        for (int i = 0; i < j; i++)
        {
            StackTraceElement stacktraceelement = astacktraceelement[i];
            jsonarray.put(az.a().put("c", stacktraceelement.getClassName()).put("m", stacktraceelement.getMethodName()).put("f", stacktraceelement.getFileName()).put("l", stacktraceelement.getLineNumber()));
        }

        jsonobject.put("stackTraceElements", jsonarray);
    }

    private JSONObject b(String s)
    {
        JSONObject jsonobject = a(s);
        b.b(jsonobject);
        Object obj = e.b();
        if (obj != null && ((Map) (obj)).size() > 0)
        {
            JSONObject jsonobject1 = az.a();
            java.util.Map.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); jsonobject1.put((String)entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

            jsonobject.put("userdata", jsonobject1);
        }
        if (a.contains(s))
        {
            jsonobject.put("ec", f.f());
        }
        return jsonobject;
    }

    final JSONObject a(long l, long l1, StackTraceElement astacktraceelement[])
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = b("crash-report");
            JSONObject jsonobject1 = az.a().put("st", l).put("et", l1);
            JSONObject jsonobject2 = az.a();
            a(jsonobject2, astacktraceelement);
            jsonobject1.put("mainStackTrace", jsonobject2);
            jsonobject.put("androidNotRespondingReport", jsonobject1);
        }
        // Misplaced declaration of an exception variable
        catch (StackTraceElement astacktraceelement[])
        {
            p.a("Exception creating anr message", astacktraceelement);
            return null;
        }
        return jsonobject;
    }

    final JSONObject a(bj bj1)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = b("ui");
            jsonobject.put("st", bj1.c);
            jsonobject.put("activity", bj1.a);
            jsonobject.put("event", bj1.b);
        }
        // Misplaced declaration of an exception variable
        catch (bj bj1)
        {
            p.a("Exception creating UI message", bj1);
            return null;
        }
        return jsonobject;
    }

    final JSONObject a(String s, Throwable throwable, int i)
    {
        JSONObject jsonobject;
        StringBuilder stringbuilder;
        try
        {
            jsonobject = a("log-event");
            stringbuilder = new StringBuilder();
            stringbuilder.append(s);
            stringbuilder.append("\n");
            stringbuilder.append(a(throwable));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        stringbuilder.append("\n");
        stringbuilder.append("Dropped ");
        stringbuilder.append(i);
        stringbuilder.append(" previous log messages.");
        jsonobject.put("droppedMessages", i);
        jsonobject.put("text", stringbuilder);
        return jsonobject;
    }

    final JSONObject a(URL url, long l, long l1, int i, String s, 
            t t1)
    {
        JSONObject jsonobject;
        u u1;
        JSONObject jsonobject1;
        try
        {
            jsonobject = b("network-request");
            jsonobject.put("url", url.toString());
            jsonobject.put("st", l);
            jsonobject.put("et", l1);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            p.a("Exception creating network request message", url);
            return null;
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        jsonobject.put("hrc", i);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        jsonobject.put("hsl", s);
        if (t1 == null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        bc.a(t1.toString());
        jsonobject.put("crg", t1.a);
        if (t1.b != null)
        {
            jsonobject.put("sst", t1.b);
        }
        url = new JSONArray();
        for (s = t1.c.iterator(); s.hasNext(); url.put(jsonobject1))
        {
            u1 = (u)s.next();
            jsonobject1 = new JSONObject();
            jsonobject1.put("btId", u1.a);
            jsonobject1.put("time", u1.c);
            jsonobject1.put("estimatedTime", u1.b);
        }

        jsonobject.put("bts", url);
        jsonobject.put("see", t1.d);
        return jsonobject;
    }

    final JSONObject a(URL url, Exception exception)
    {
        return a(url, exception, -1L, -1L);
    }

    final JSONObject a(URL url, Exception exception, long l, long l1)
    {
        String s = "unknown";
        if (exception != null)
        {
            String s1 = exception.toString();
            s = s1;
            if (s1.length() > 1000)
            {
                s = s1.substring(0, 1000);
            }
        }
        return a(url, s, a(((Throwable) (exception))), l, l1);
    }

    final JSONObject a(URL url, String s, String s1, long l, long l1)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = b("network-request");
            jsonobject.put("url", url.toString());
            jsonobject.put("ne", s);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            p.a("Exception creating network request message", url);
            return null;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        jsonobject.put("stackTrace", s1);
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        jsonobject.put("st", l);
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        jsonobject.put("et", l1);
        return jsonobject;
    }

    static 
    {
        HashSet hashset = new HashSet();
        a = hashset;
        hashset.add("network-request");
        a.add("ui");
        a.add("method-call");
        a.add("crash-report");
    }
}
