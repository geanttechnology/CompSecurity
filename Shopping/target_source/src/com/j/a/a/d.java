// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a;

import android.os.Handler;
import android.util.Pair;
import com.j.a.a.a.l;
import com.j.a.d.e;
import com.j.a.e.a;
import com.j.a.g.b;
import com.j.a.g.h;
import com.j.a.g.m;
import com.j.a.g.w;
import com.j.a.j;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a:
//            a, b, g, f

public class d
{

    private static Map c = new HashMap();
    private static Map d = new HashMap();
    private static Map e = new HashMap();
    public ArrayList a;
    private boolean b;
    private com.j.a.a.b f;
    private Handler g;
    private Runnable h;
    private SimpleDateFormat i;
    private ArrayList j;
    private Date k;

    public d()
    {
        b = false;
        f = null;
        g = new Handler();
        h = new com.j.a.a.a(this);
        i = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.US);
        j = new ArrayList();
        k = null;
        f = new com.j.a.a.b();
    }

    static ArrayList a(d d1)
    {
        return d1.j;
    }

    static ArrayList a(d d1, ArrayList arraylist)
    {
        d1.j = arraylist;
        return arraylist;
    }

    public static void a(int i1)
    {
        if (d.containsKey(Integer.valueOf(i1)))
        {
            Long long1 = Long.valueOf(System.currentTimeMillis() - ((Long)((Pair)d.get(Integer.valueOf(i1))).second).longValue());
            d.remove(Integer.valueOf(i1));
            w.a((new StringBuilder()).append("Time on fragment: ").append(String.format("%d min, %d sec", new Object[] {
                Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(long1.longValue())), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(long1.longValue()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(long1.longValue())))
            })).toString());
            com.j.a.d.e.e().n().a("viewTimeOnPage", long1, null);
            return;
        } else
        {
            w.a("Problem: Id not in fragment map, cant track time");
            return;
        }
    }

    static void a(d d1, j j1)
    {
        d1.b(j1);
    }

    private void a(JSONObject jsonobject)
    {
label0:
        {
            if (jsonobject != null)
            {
                String s;
                if (!(jsonobject instanceof JSONObject))
                {
                    s = jsonobject.toString();
                } else
                {
                    s = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
                }
                if (m.a(s))
                {
                    break label0;
                }
            }
            return;
        }
        j.add(jsonobject);
        com.j.a.g.h.a().a(j);
        b(((j) (null)));
    }

    private JSONObject b(String s, Object obj, JSONObject jsonobject)
        throws JSONException
    {
        if (s == null)
        {
            return null;
        }
        e e1 = com.j.a.d.e.e();
        com.j.a.c.e e2 = e1.k();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("type", s);
        int i1;
        if (jsonobject != null && jsonobject.has("TLTime"))
        {
            jsonobject1.put("date", i.format(new Date(Long.valueOf(jsonobject.optString("TLTime")).longValue())));
            jsonobject1.put("data", jsonobject);
        } else
        if (jsonobject != null && s.equals("tlError"))
        {
            jsonobject1.put("data", jsonobject);
            jsonobject1.put("date", i.format(new Date()));
        } else
        {
            jsonobject1.put("date", i.format(new Date()));
        }
        if (obj != null)
        {
            jsonobject1.put("val", obj);
        }
        if (e2 != null && e2.b() != null)
        {
            jsonobject1.put("sid", e2.b());
        }
        if (e1.g())
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        jsonobject1.put("prod", i1);
        return jsonobject1;
    }

    private void b(j j1)
    {
        if (j1 != null)
        {
            j1.a();
        }
        if (k == null && j.size() > 0)
        {
            k = new Date();
            double d1;
            if (com.j.a.d.e.e().g())
            {
                d1 = m.a(20D) + 5D;
            } else
            {
                d1 = 60D + m.a(5D);
            }
            g.postDelayed(h, Math.round(d1) * 1000L);
        }
    }

    public static void b(String s)
    {
        if (c.containsKey(s))
        {
            Long long1 = Long.valueOf(System.currentTimeMillis() - ((Long)c.get(s)).longValue());
            c.remove(s);
            w.a((new StringBuilder()).append("Time on activity: ").append(String.format("%d min, %d sec", new Object[] {
                Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(long1.longValue())), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(long1.longValue()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(long1.longValue())))
            })).toString());
            com.j.a.d.e.e().n().a("viewTimeOnPage", long1, null);
            return;
        } else
        {
            w.a("Problem: Activity not in activity map, cant track time");
            return;
        }
    }

    public static Map c()
    {
        return d;
    }

    private Boolean d(String s)
    {
label0:
        {
            if (a == null)
            {
                break label0;
            }
            Iterator iterator = a.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((String)iterator.next()).equals(s));
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public com.j.a.a.b a()
    {
        return f;
    }

    public void a(j j1)
    {
        String s;
        Object obj;
        e e1;
        ArrayList arraylist;
        Object obj1;
        Object obj2;
        if (!com.j.a.d.e.e().j())
        {
            return;
        }
        k = null;
        e1 = com.j.a.d.e.e();
        obj1 = e1.k();
        Iterator iterator;
        Object obj3;
        if (obj1 != null)
        {
            s = ((com.j.a.c.e) (obj1)).b();
        } else
        {
            s = null;
        }
        arraylist = j;
        arraylist;
        JVM INSTR monitorenter ;
        if (j.size() < 100) goto _L2; else goto _L1
_L1:
        obj = j.subList(0, 99);
_L4:
        obj = new ArrayList(((java.util.Collection) (obj)));
        if (((ArrayList) (obj)).size() <= 0 || obj1 == null || s == null)
        {
            break MISSING_BLOCK_LABEL_539;
        }
        obj1 = new JSONArray();
        iterator = ((ArrayList) (obj)).iterator();
_L3:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_379;
        }
        obj2 = (JSONObject)iterator.next();
        if (!((JSONObject) (obj2)).has("sid"))
        {
            ((JSONObject) (obj2)).put("sid", s);
        }
        if (!((JSONObject) (obj2)).has("prod"))
        {
            if (!com.j.a.d.e.e().g())
            {
                break MISSING_BLOCK_LABEL_366;
            }
            ((JSONObject) (obj2)).put("prod", 0);
        }
_L5:
        if (((JSONObject) (obj2)).get("type").equals("tlError") && ((JSONObject) (obj2)).has("data"))
        {
            obj3 = ((JSONObject) (obj2)).optJSONObject("data");
            if (((JSONObject) (obj3)).has("taplyticsMessage"))
            {
                obj3 = ((JSONObject) (obj3)).optString("taplyticsMessage");
                if (e.containsKey(obj3))
                {
                    ((JSONObject) (obj2)).put("val", ((Pair)e.get(obj3)).second);
                    e.put(obj3, new Pair(Boolean.valueOf(false), ((Pair)e.get(obj3)).second));
                }
            }
        }
        ((JSONArray) (obj1)).put(obj2);
          goto _L3
        obj2;
        w.b("Adding JSONObject to eventQueue", ((Exception) (obj2)));
          goto _L3
        j1;
        arraylist;
        JVM INSTR monitorexit ;
        try
        {
            throw j1;
        }
        // Misplaced declaration of an exception variable
        catch (j j1)
        {
            w.b("Something has gone wrong flushing.", j1);
        }
        return;
_L2:
        obj = j;
          goto _L4
        ((JSONObject) (obj2)).put("prod", 1);
          goto _L5
        JSONObject jsonobject = new JSONObject();
        if (e1.f() != null)
        {
            jsonobject.put("t", e1.f());
        }
        jsonobject.put("sid", s);
        jsonobject.put("e", obj1);
        e1.l().b(jsonobject, new g(this, j1, ((ArrayList) (obj))));
        if (j.size() < 100) goto _L7; else goto _L6
_L6:
        j.removeAll(((java.util.Collection) (obj)));
_L8:
        com.j.a.g.h.a().a(j);
        if (j.size() > 20)
        {
            b(j1);
        }
_L9:
        arraylist;
        JVM INSTR monitorexit ;
        return;
_L7:
        j.clear();
          goto _L8
        Exception exception;
        exception;
        w.b("Flushing Events Queue", exception);
        com.j.a.g.h.a().a(j);
        b(j1);
          goto _L9
        b(j1);
          goto _L9
    }

    public void a(String s)
    {
        a(s, null, null);
    }

    public void a(String s, Exception exception)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = true;
        if (com.j.a.d.e.e().j() && !m.a(b.b) && !m.a(b.l)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        int i1;
        try
        {
            obj = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.c("Broke tracking error.", exception);
            return;
        }
        i1 = ((flag1) ? 1 : 0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        i1 = ((flag1) ? 1 : 0);
        if (s.equals(""))
        {
            break MISSING_BLOCK_LABEL_174;
        }
        i1 = ((flag) ? 1 : 0);
        if (e.containsKey(s))
        {
            i1 = ((Integer)((Pair)e.get(s)).second).intValue() + 1;
            if (((Boolean)((Pair)e.get(s)).first).booleanValue())
            {
                e.put(s, new Pair(Boolean.valueOf(true), Integer.valueOf(i1)));
                return;
            }
        }
        ((JSONObject) (obj)).put("taplyticsMessage", s);
        if (exception == null) goto _L4; else goto _L3
_L3:
        if (exception.getMessage() == null || exception.getMessage().equals("")) goto _L4; else goto _L5
_L5:
        ((JSONObject) (obj)).put("message", exception.getMessage());
        StringWriter stringwriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringwriter));
        ((JSONObject) (obj)).put("stacktrace", stringwriter.toString());
_L9:
        obj = b("tlError", null, ((JSONObject) (obj)));
_L10:
        if (obj == null) goto _L1; else goto _L6
_L6:
        if (s == null) goto _L8; else goto _L7
_L7:
        e.put(s, new Pair(Boolean.valueOf(true), Integer.valueOf(i1)));
        a(((JSONObject) (obj)));
        return;
        Exception exception1;
        exception1;
        w.c("Broke tracking error.", exception1);
          goto _L9
_L4:
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        boolean flag2;
        if (exception.getMessage() == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        flag2 = exception.getMessage().equals("");
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        obj = b("tlError", null, ((JSONObject) (obj)));
          goto _L10
        obj;
        w.c("Broke tracking error.", ((Exception) (obj)));
        break MISSING_BLOCK_LABEL_366;
_L8:
        a(((JSONObject) (obj)));
        return;
        obj = null;
          goto _L10
    }

    public void a(String s, Object obj, JSONObject jsonobject)
    {
        while (!com.j.a.d.e.e().j() || m.a(b.b) || s == null) 
        {
            return;
        }
        w.a((new StringBuilder()).append("Log TL Event: ").append(s).append(", value: ").append(obj).toString());
        try
        {
            jsonobject = b(s, obj, jsonobject);
            if (s.equals("viewAppeared") || s.equals("viewDisappeared"))
            {
                jsonobject.put("val", i.format(new Date()));
                jsonobject.put("vKey", obj);
            }
            a(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("Tracking TLEvent", s);
        }
    }

    public void a(String s, String s1)
    {
        while (!com.j.a.d.e.e().j() || m.a(b.b) || s == null) 
        {
            return;
        }
        w.a((new StringBuilder()).append("Track Code Experiment Shown, expID: ").append(s).append(", varID: ").append(s1).toString());
        JSONObject jsonobject;
        try
        {
            jsonobject = b("codeExperiment", null, null);
            jsonobject.put("exp_id", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("Tracking Code Experiment Shown", s);
            return;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        jsonobject.put("var_id", s1);
        a(jsonobject);
        return;
    }

    public void a(String s, String s1, Object obj, JSONObject jsonobject)
    {
        while (!com.j.a.d.e.e().j() || m.a(b.b) || m.a(b.d) || s1 == null) 
        {
            return;
        }
        StringBuilder stringbuilder = (new StringBuilder()).append("Log event: ").append(s1).append(", value: ").append(obj).append(". From source: ").append(s).append(". Metadata: ");
        String s2;
        if (jsonobject == null)
        {
            s2 = "none";
        } else
        if (!(jsonobject instanceof JSONObject))
        {
            s2 = jsonobject.toString();
        } else
        {
            s2 = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        w.a(stringbuilder.append(s2).toString());
        try
        {
            s = b(s, obj, jsonobject);
            s.put("gn", s1);
            a(((JSONObject) (s)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("Track Revenue", s);
        }
    }

    public void a(String s, String s1, String s2, Exception exception)
    {
        while (!com.j.a.d.e.e().j() || m.a(b.b) || m.a(b.w) || s == null) 
        {
            return;
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            w.a((new StringBuilder()).append("Log request error: ").append(s).append(", value: ").append(s1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("Track Event", s);
            return;
        }
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (exception.getMessage() == null || exception.getMessage().equals(""))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        jsonobject.put("message", exception.getMessage());
        s = new StringWriter();
        exception.printStackTrace(new PrintWriter(s));
        jsonobject.put("stacktrace", s.toString());
_L1:
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        jsonobject.put("logText", s2);
        s = b("tlRequestFailed", Integer.valueOf(0), jsonobject);
        s.put("gn", s1);
        a(((JSONObject) (s)));
        return;
        s;
        w.c("Broke tracking request error.", s);
          goto _L1
    }

    public void a(String s, JSONObject jsonobject)
    {
        while (!com.j.a.d.e.e().j() || m.a(b.s) || s == null || jsonobject == null) 
        {
            return;
        }
        try
        {
            s = b(s, null, null);
            if (jsonobject.has("key"))
            {
                s.put("eKey", jsonobject.optString("key"));
            }
            if (jsonobject.has("vKey"))
            {
                s.put("vKey", com.j.a.d.e.e().p().getClass().getSimpleName());
            }
            a(((JSONObject) (s)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            w.b("Track View Event", s);
        }
    }

    public Map b()
    {
        return c;
    }

    public void b(String s, String s1)
    {
        a(s, s1, null, ((JSONObject) (null)));
    }

    public void c(String s)
        throws JSONException
    {
        if (!com.j.a.d.e.e().j() || m.a(b.b))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (m.a(b.q))
        {
            return;
        }
        w.a("Push notification opened");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        JSONObject jsonobject;
        if (!com.j.a.d.e.e().j())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        jsonobject = b("pushOpened", null, null);
        if (jsonobject != null)
        {
            try
            {
                jsonobject.put("gn", s);
                a(jsonobject);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
    }

    public void d()
    {
        if (com.j.a.d.e.e().j() && !m.a(b.d))
        {
            Object obj = com.j.a.d.e.e().k();
            if (obj != null)
            {
                obj = ((com.j.a.c.e) (obj)).d();
            } else
            {
                obj = null;
            }
            if (obj != null && !b)
            {
                if (!d("Mixpanel").booleanValue() && ((JSONObject) (obj)).has("mpSource") && ((JSONObject) (obj)).optBoolean("mpSource", true) && !m.a(b.f))
                {
                    l.b().f();
                }
                if (!d("GA").booleanValue() && ((JSONObject) (obj)).has("mpSource") && ((JSONObject) (obj)).optBoolean("gaSource", false) && !m.a(b.e))
                {
                    l.b().g();
                    w.a("Enabling GA");
                } else
                {
                    w.a("GA not enabled.");
                }
                if (!d("Flurry").booleanValue() && ((JSONObject) (obj)).has("flSource") && ((JSONObject) (obj)).optBoolean("flSource", true) && !m.a(b.g))
                {
                    l.b().h();
                }
                l.b().k();
                b = true;
                return;
            }
        }
    }

    public void e()
    {
        if (!com.j.a.d.e.e().j() || m.a(b.b))
        {
            return;
        } else
        {
            com.j.a.g.h.a().a(new f(this));
            f.a();
            return;
        }
    }

}
