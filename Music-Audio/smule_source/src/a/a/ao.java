// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            cv, de, cu, bb, 
//            bf, bi, bh, bj, 
//            bk, bl, bu, bv, 
//            bo, bp, bn, cf, 
//            bg, bq, br, bt, 
//            bs, bw, bx, by, 
//            bz, ca, cb, cc, 
//            cd, ce, ew, au, 
//            ai, en, ay

public final class ao
    implements cv
{

    public long a;
    public JSONArray b;
    public String c;
    public String d;
    public JSONArray e;
    public String f;
    public JSONObject g;
    private JSONObject h;
    private JSONArray i;
    private JSONArray j;
    private String k;
    private JSONArray l;
    private String m;
    private int n;
    private boolean o;
    private String p;

    public ao(Throwable throwable, long l1)
    {
        int i1 = 0;
        super();
        d = "";
        n = -1;
        o = false;
        o = throwable instanceof de;
        p = cu.a.a();
        f = "uhe";
        bb bb1 = new bb();
        bb1.a(new bf()).a(new bi()).a(new bh()).a(new bj()).a(new bk()).a(new bl()).a(new bu()).a(new bv()).a(new bo()).a(new bp()).a(new bn()).a(new cf()).a(new bg()).a(new bq()).a(new br()).a(new bt()).a(new bs()).a(new bw()).a(new bx()).a(new by()).a(new bz()).a(new ca()).a(new cb()).a(new cc()).a(new cd()).a(new ce());
        g = bb1.a();
        h = new JSONObject();
        a = l1;
        c = a(throwable);
        if (throwable.getMessage() != null)
        {
            d = throwable.getMessage();
        }
        if (!o)
        {
            n = c(throwable);
        }
        k = "android";
        m = ew.a.a();
        l = new JSONArray();
        throwable = b(throwable);
        for (int j1 = throwable.length; i1 < j1; i1++)
        {
            Object obj = throwable[i1];
            l.put(obj);
        }

    }

    private String a(Throwable throwable)
    {
        Throwable throwable1 = throwable;
        if (o)
        {
            return ((de)throwable).a();
        }
        do
        {
            String s = throwable1.getClass().getName();
            throwable = throwable1.getCause();
            if (throwable != null && throwable != throwable1)
            {
                throwable1 = throwable;
            } else
            {
                return s;
            }
        } while (true);
    }

    private static String[] b(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        do
        {
            throwable.printStackTrace(printwriter);
            Throwable throwable1 = throwable.getCause();
            if (throwable1 == null || throwable1 == throwable)
            {
                return stringwriter.toString().split("\n");
            }
            throwable = throwable1;
        } while (true);
    }

    private static int c(Throwable throwable)
    {
        StackTraceElement astacktraceelement[];
        int i1;
        astacktraceelement = throwable.getStackTrace();
        i1 = 0;
_L6:
        if (i1 >= astacktraceelement.length) goto _L2; else goto _L1
_L1:
        throwable = astacktraceelement[i1];
        Class class1 = Class.forName(throwable.getClassName());
        throwable = ClassLoader.getSystemClassLoader();
_L5:
        if (throwable == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (class1.getClassLoader() != throwable) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L7:
        if (!flag)
        {
            return i1 + 1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        throwable = throwable.getParent();
          goto _L5
        throwable;
        i1++;
          goto _L6
_L2:
        return -1;
        flag = false;
          goto _L7
    }

    public final JSONObject a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("app_state", g);
        hashmap.put("breadcrumbs", h);
        hashmap.put("current_thread_id", Long.valueOf(a));
        if (i != null)
        {
            hashmap.put("endpoints", i);
        }
        if (b != null)
        {
            hashmap.put("systemBreadcrumbs", b);
        }
        if (j != null && j.length() > 0)
        {
            hashmap.put("transactions", j);
        }
        hashmap.put("exception_name", c);
        hashmap.put("exception_reason", d);
        hashmap.put("platform", k);
        if (e != null)
        {
            hashmap.put("threads", e);
        }
        hashmap.put("ts", m);
        String s1 = f;
        String s = s1;
        if (a != 1L)
        {
            s = (new StringBuilder()).append(s1).append("-bg").toString();
        }
        hashmap.put("type", s);
        hashmap.put("unsymbolized_stacktrace", l);
        if (!o)
        {
            hashmap.put("suspect_line_index", Integer.valueOf(n));
        }
        return new JSONObject(hashmap);
    }

    public final void a(ay ay)
    {
        i = (new au(ay)).a;
    }

    public final void a(OutputStream outputstream)
    {
        outputstream.write(a().toString().getBytes());
    }

    public final void a(String s, ay ay)
    {
        ay = (new au(ay)).a;
        try
        {
            h.put(s, ay);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public final void a(List list)
    {
        j = new JSONArray();
        for (list = list.iterator(); list.hasNext();)
        {
            ai ai1 = (ai)list.next();
            try
            {
                j.put(ai1.e());
            }
            catch (JSONException jsonexception)
            {
                en.a(jsonexception);
            }
        }

    }

    public final String f()
    {
        return p;
    }
}
