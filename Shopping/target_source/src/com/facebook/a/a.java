// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.a;

import a.c;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.h;
import com.facebook.i;
import com.facebook.internal.b;
import com.facebook.internal.j;
import com.facebook.internal.o;
import com.facebook.internal.p;
import com.facebook.n;
import com.facebook.q;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.a:
//            b

public class com.facebook.a.a
{
    private static class a
        implements Serializable
    {

        private final String a;
        private final String b;

        String a()
        {
            return a;
        }

        String b()
        {
            return b;
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                if (o.a(((a) (obj = (a)obj)).a, a) && o.a(((a) (obj)).b, b))
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            int j1 = 0;
            int i1;
            if (a == null)
            {
                i1 = 0;
            } else
            {
                i1 = a.hashCode();
            }
            if (b != null)
            {
                j1 = b.hashCode();
            }
            return i1 ^ j1;
        }

        a(AccessToken accesstoken)
        {
            this(accesstoken.b(), com.facebook.i.i());
        }

        a(String s, String s1)
        {
            String s2 = s;
            if (o.a(s))
            {
                s2 = null;
            }
            a = s2;
            b = s1;
        }
    }

    static class b
        implements Serializable
    {

        private static final HashSet c = new HashSet();
        private JSONObject a;
        private boolean b;
        private String d;

        private void a(String s)
            throws com.facebook.f
        {
            if (s == null || s.length() == 0 || s.length() > 40)
            {
                String s1 = s;
                if (s == null)
                {
                    s1 = "<None Provided>";
                }
                throw new com.facebook.f(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] {
                    s1, Integer.valueOf(40)
                }));
            }
            boolean flag;
            synchronized (c)
            {
                flag = c.contains(s);
            }
            if (!flag)
            {
                if (!s.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"))
                {
                    break MISSING_BLOCK_LABEL_117;
                }
                synchronized (c)
                {
                    c.add(s);
                }
            }
            return;
            s;
            hashset;
            JVM INSTR monitorexit ;
            throw s;
            s;
            hashset;
            JVM INSTR monitorexit ;
            throw s;
            throw new com.facebook.f(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] {
                s
            }));
        }

        static boolean a(b b1)
        {
            return b1.b;
        }

        public String a()
        {
            return d;
        }

        public boolean b()
        {
            return b;
        }

        public JSONObject c()
        {
            return a;
        }

        public String toString()
        {
            String s = a.optString("_eventName");
            boolean flag = b;
            Object obj = a;
            if (!(obj instanceof JSONObject))
            {
                obj = ((JSONObject) (obj)).toString();
            } else
            {
                obj = JSONObjectInstrumentation.toString((JSONObject)obj);
            }
            return String.format("\"%s\", implicit: %b, json: %s", new Object[] {
                s, Boolean.valueOf(flag), obj
            });
        }


        public b(String s, String s1, Double double1, Bundle bundle, boolean flag)
        {
            a(s1);
            d = s1;
            b = flag;
            a = new JSONObject();
            a.put("_eventName", s1);
            a.put("_logTime", System.currentTimeMillis() / 1000L);
            a.put("_ui", s);
            if (double1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            a.put("_valueToSum", double1.doubleValue());
            if (b)
            {
                a.put("_implicitlyLogged", "1");
            }
            if (bundle == null) goto _L2; else goto _L1
_L1:
            s = bundle.keySet().iterator();
_L10:
            if (!s.hasNext()) goto _L2; else goto _L3
_L3:
            s1 = (String)s.next();
            a(s1);
            double1 = ((Double) (bundle.get(s1)));
            if (!(double1 instanceof String) && !(double1 instanceof Number))
            {
                throw new com.facebook.f(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] {
                    double1, s1
                }));
            }
              goto _L4
_L5:
            return;
_L4:
            try
            {
                a.put(s1, double1.toString());
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.facebook.internal.j.a(q.e, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] {
                    s.toString()
                });
                a = null;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.facebook.internal.j.a(q.e, "AppEvents", "Invalid app event name or parameter:", new Object[] {
                    s.toString()
                });
                a = null;
                return;
            }
            if (true) goto _L5; else goto _L2
_L2:
            if (b) goto _L5; else goto _L6
_L6:
            s1 = q.e;
            s = a;
            if (s instanceof JSONObject)
            {
                break MISSING_BLOCK_LABEL_310;
            }
            s = s.toString();
_L8:
            com.facebook.internal.j.a(s1, "AppEvents", "Created app event '%s'", new Object[] {
                s
            });
            return;
            s = JSONObjectInstrumentation.toString((JSONObject)s);
            if (true) goto _L8; else goto _L7
_L7:
            if (true) goto _L10; else goto _L9
_L9:
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        private static final c c[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/facebook/a/a$c, s);
        }

        public static c[] values()
        {
            return (c[])c.clone();
        }

        static 
        {
            a = new c("AUTO", 0);
            b = new c("EXPLICIT_ONLY", 1);
            c = (new c[] {
                a, b
            });
        }

        private c(String s, int i1)
        {
            super(s, i1);
        }
    }

    private static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        public static final d e;
        public static final d f;
        private static final d g[];

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(com/facebook/a/a$d, s);
        }

        public static d[] values()
        {
            return (d[])g.clone();
        }

        static 
        {
            a = new d("EXPLICIT", 0);
            b = new d("TIMER", 1);
            c = new d("SESSION_CHANGE", 2);
            d = new d("PERSISTED_EVENTS", 3);
            e = new d("EVENT_THRESHOLD", 4);
            f = new d("EAGER_FLUSHING_EVENT", 5);
            g = (new d[] {
                a, b, c, d, e, f
            });
        }

        private d(String s, int i1)
        {
            super(s, i1);
        }
    }

    private static final class e extends Enum
    {

        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        private static final e e[];

        public static e valueOf(String s)
        {
            return (e)Enum.valueOf(com/facebook/a/a$e, s);
        }

        public static e[] values()
        {
            return (e[])e.clone();
        }

        static 
        {
            a = new e("SUCCESS", 0);
            b = new e("SERVER_ERROR", 1);
            c = new e("NO_CONNECTIVITY", 2);
            d = new e("UNKNOWN_ERROR", 3);
            e = (new e[] {
                a, b, c, d
            });
        }

        private e(String s, int i1)
        {
            super(s, i1);
        }
    }

    private static class f
    {

        public int a;
        public e b;

        private f()
        {
            a = 0;
            b = e.a;
        }

    }

    static class g
    {

        private static final Object a = new Object();
        private static boolean b = false;
        private static boolean c = false;
        private static Map d;
        private static final Runnable e = new Runnable() {

            public void run()
            {
                g.a(com.facebook.a.a.h());
            }

        };

        private static com.facebook.a.b a(Context context, a a1)
        {
            b(context);
            com.facebook.a.b b1 = (com.facebook.a.b)d.get(a1);
            context = b1;
            if (b1 == null)
            {
                context = new com.facebook.a.b();
                d.put(a1, context);
            }
            return context;
        }

        private static void a()
        {
            if (!b)
            {
                b = true;
                com.facebook.a.a.j().schedule(e, 30L, TimeUnit.SECONDS);
            }
        }

        static void a(Context context)
        {
            Object obj = a;
            obj;
            JVM INSTR monitorenter ;
            boolean flag = b;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedsessioninfo", 0)));
            context = objectoutputstream;
            objectoutputstream.writeObject(d);
            context = objectoutputstream;
            b = false;
            context = objectoutputstream;
            com.facebook.internal.j.a(q.e, "AppEvents", "App session info saved");
            o.a(objectoutputstream);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            objectoutputstream = null;
_L4:
            context = objectoutputstream;
            Log.d(com.facebook.a.a.i(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
            o.a(objectoutputstream);
              goto _L1
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
            Exception exception;
            exception;
            context = null;
_L3:
            o.a(context);
            throw exception;
            exception;
            if (true) goto _L3; else goto _L2
_L2:
            exception1;
              goto _L4
        }

        static void a(Context context, a a1, com.facebook.a.a a2, long l1)
        {
            synchronized (a)
            {
                a(context, a1).a(a2, l1);
                a();
            }
            return;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        static void a(Context context, a a1, com.facebook.a.a a2, long l1, String s)
        {
            synchronized (a)
            {
                a(context, a1).a(a2, l1, s);
                a();
            }
            return;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        private static void b(Context context)
        {
            Object obj1 = null;
            Object obj2 = a;
            obj2;
            JVM INSTR monitorenter ;
            boolean flag = c;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            Object obj = new ObjectInputStream(context.openFileInput("AppEventsLogger.persistedsessioninfo"));
            obj1 = obj;
            d = (HashMap)((ObjectInputStream) (obj)).readObject();
            obj1 = obj;
            com.facebook.internal.j.a(q.e, "AppEvents", "App session info loaded");
            o.a(((java.io.Closeable) (obj)));
            context.deleteFile("AppEventsLogger.persistedsessioninfo");
            if (d == null)
            {
                d = new HashMap();
            }
            c = true;
            b = false;
_L1:
            obj2;
            JVM INSTR monitorexit ;
            return;
_L4:
            o.a(((java.io.Closeable) (obj)));
            context.deleteFile("AppEventsLogger.persistedsessioninfo");
            if (d == null)
            {
                d = new HashMap();
            }
            c = true;
            b = false;
              goto _L1
            context;
            obj2;
            JVM INSTR monitorexit ;
            throw context;
            Exception exception;
            exception;
            obj = null;
_L3:
            obj1 = obj;
            Log.d(com.facebook.a.a.i(), (new StringBuilder()).append("Got unexpected exception: ").append(exception.toString()).toString());
            o.a(((java.io.Closeable) (obj)));
            context.deleteFile("AppEventsLogger.persistedsessioninfo");
            if (d == null)
            {
                d = new HashMap();
            }
            c = true;
            b = false;
              goto _L1
_L2:
            o.a(((java.io.Closeable) (obj1)));
            context.deleteFile("AppEventsLogger.persistedsessioninfo");
            if (d == null)
            {
                d = new HashMap();
            }
            c = true;
            b = false;
            throw obj;
            obj;
              goto _L2
            exception;
              goto _L3
            obj1;
              goto _L4
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            filenotfoundexception = ((FileNotFoundException) (obj1));
              goto _L4
            filenotfoundexception;
            obj1 = null;
              goto _L2
        }

    }

    static class h
    {

        private static Object a = new Object();
        private Context b;
        private HashMap c;

        public static h a(Context context)
        {
            synchronized (a)
            {
                context = new h(context);
                context.c();
            }
            return context;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        public static void a(Context context, a a1, i i1)
        {
            HashMap hashmap = new HashMap();
            hashmap.put(a1, i1);
            a(context, ((Map) (hashmap)));
        }

        public static void a(Context context, Map map)
        {
            Object obj = a;
            obj;
            JVM INSTR monitorenter ;
            context = a(context);
            map = map.entrySet().iterator();
            do
            {
                if (!map.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                List list = ((i)entry.getValue()).b();
                if (list.size() != 0)
                {
                    context.a((a)entry.getKey(), list);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_89;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
            context.b();
            obj;
            JVM INSTR monitorexit ;
        }

        private void b()
        {
            ObjectOutputStream objectoutputstream1 = new ObjectOutputStream(new BufferedOutputStream(b.openFileOutput("AppEventsLogger.persistedevents", 0)));
            ObjectOutputStream objectoutputstream = objectoutputstream1;
            objectoutputstream1.writeObject(c);
            o.a(objectoutputstream1);
            return;
            Exception exception1;
            exception1;
            objectoutputstream1 = null;
_L4:
            objectoutputstream = objectoutputstream1;
            Log.d(com.facebook.a.a.i(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
            o.a(objectoutputstream1);
            return;
            Exception exception;
            exception;
            objectoutputstream = null;
_L2:
            o.a(objectoutputstream);
            throw exception;
            exception;
            if (true) goto _L2; else goto _L1
_L1:
            exception1;
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void c()
        {
            Object obj1 = null;
            Object obj = new ObjectInputStream(new BufferedInputStream(b.openFileInput("AppEventsLogger.persistedevents")));
            obj1 = obj;
            HashMap hashmap = (HashMap)((ObjectInputStream) (obj)).readObject();
            obj1 = obj;
            b.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            obj1 = obj;
            c = hashmap;
            o.a(((java.io.Closeable) (obj)));
            return;
            obj;
            obj = obj1;
_L6:
            o.a(((java.io.Closeable) (obj)));
            return;
            Exception exception1;
            exception1;
            obj = null;
_L4:
            obj1 = obj;
            Log.d(com.facebook.a.a.i(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
            o.a(((java.io.Closeable) (obj)));
            return;
            Exception exception;
            exception;
            obj1 = null;
_L2:
            o.a(((java.io.Closeable) (obj1)));
            throw exception;
            exception;
            if (true) goto _L2; else goto _L1
_L1:
            exception1;
            if (true) goto _L4; else goto _L3
_L3:
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            if (true) goto _L6; else goto _L5
_L5:
        }

        public List a(a a1)
        {
            return (List)c.get(a1);
        }

        public Set a()
        {
            return c.keySet();
        }

        public void a(a a1, List list)
        {
            if (!c.containsKey(a1))
            {
                c.put(a1, new ArrayList());
            }
            ((List)c.get(a1)).addAll(list);
        }


        private h(Context context)
        {
            c = new HashMap();
            b = context;
        }
    }

    static class i
    {

        private List a;
        private List b;
        private int c;
        private com.facebook.internal.b d;
        private String e;
        private String f;
        private final int g = 1000;

        private void a(GraphRequest graphrequest, int i1, JSONArray jsonarray, boolean flag)
        {
            JSONObject jsonobject = com.facebook.internal.a.a(com.facebook.internal.a.b, d, f, flag, com.facebook.a.a.h());
            Object obj = jsonobject;
            if (c <= 0)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            jsonobject.put("num_skipped_events", i1);
            obj = jsonobject;
_L1:
            graphrequest.a(((JSONObject) (obj)));
            Bundle bundle = graphrequest.e();
            obj = bundle;
            if (bundle == null)
            {
                obj = new Bundle();
            }
            JSONException jsonexception;
            if (!(jsonarray instanceof JSONArray))
            {
                jsonarray = jsonarray.toString();
            } else
            {
                jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
            }
            if (jsonarray != null)
            {
                ((Bundle) (obj)).putByteArray("custom_events_file", a(((String) (jsonarray))));
                graphrequest.a(jsonarray);
            }
            graphrequest.a(((Bundle) (obj)));
            return;
            jsonexception;
            jsonexception = new JSONObject();
              goto _L1
        }

        private byte[] a(String s)
        {
            try
            {
                s = s.getBytes("UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                o.a("Encoding exception: ", s);
                return null;
            }
            return s;
        }

        public int a()
        {
            this;
            JVM INSTR monitorenter ;
            int i1 = a.size();
            this;
            JVM INSTR monitorexit ;
            return i1;
            Exception exception;
            exception;
            throw exception;
        }

        public int a(GraphRequest graphrequest, boolean flag, boolean flag1)
        {
            this;
            JVM INSTR monitorenter ;
            JSONArray jsonarray;
            Iterator iterator;
            int i1;
            i1 = c;
            b.addAll(a);
            a.clear();
            jsonarray = new JSONArray();
            iterator = b.iterator();
_L3:
            b b1;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_104;
            }
            b1 = (b)iterator.next();
            if (flag) goto _L2; else goto _L1
_L1:
            if (b1.b()) goto _L3; else goto _L2
_L2:
            jsonarray.put(b1.c());
              goto _L3
            graphrequest;
            this;
            JVM INSTR monitorexit ;
            throw graphrequest;
            if (jsonarray.length() != 0)
            {
                break MISSING_BLOCK_LABEL_116;
            }
            this;
            JVM INSTR monitorexit ;
            return 0;
            this;
            JVM INSTR monitorexit ;
            a(graphrequest, i1, jsonarray, flag1);
            return jsonarray.length();
        }

        public void a(b b1)
        {
            this;
            JVM INSTR monitorenter ;
            if (a.size() + b.size() < 1000) goto _L2; else goto _L1
_L1:
            c = c + 1;
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            a.add(b1);
            if (true) goto _L4; else goto _L3
_L3:
            b1;
            throw b1;
        }

        public void a(List list)
        {
            this;
            JVM INSTR monitorenter ;
            a.addAll(list);
            this;
            JVM INSTR monitorexit ;
            return;
            list;
            throw list;
        }

        public void a(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_20;
            }
            a.addAll(b);
            b.clear();
            c = 0;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public List b()
        {
            this;
            JVM INSTR monitorenter ;
            List list;
            list = a;
            a = new ArrayList();
            this;
            JVM INSTR monitorexit ;
            return list;
            Exception exception;
            exception;
            throw exception;
        }

        public i(com.facebook.internal.b b1, String s, String s1)
        {
            a = new ArrayList();
            b = new ArrayList();
            d = b1;
            e = s;
            f = s1;
        }
    }


    private static final String a = com/facebook/a/a.getCanonicalName();
    private static Map d = new ConcurrentHashMap();
    private static ScheduledThreadPoolExecutor e;
    private static c f;
    private static boolean g;
    private static Context h;
    private static Object i = new Object();
    private static String j;
    private static String k;
    private static boolean l;
    private static boolean m;
    private final String b;
    private final a c;

    private com.facebook.a.a(Context context, String s, AccessToken accesstoken)
    {
        p.a(context, "context");
        b = o.c(context);
        AccessToken accesstoken1 = accesstoken;
        if (accesstoken == null)
        {
            accesstoken1 = AccessToken.a();
        }
        if (accesstoken1 != null && (s == null || s.equals(accesstoken1.h())))
        {
            c = new a(accesstoken1);
        } else
        {
            accesstoken = s;
            if (s == null)
            {
                accesstoken = o.a(context);
            }
            c = new a(null, accesstoken);
        }
        synchronized (i)
        {
            if (h == null)
            {
                h = context.getApplicationContext();
            }
        }
        k();
        return;
        context;
        s;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static GraphRequest a(a a1, i i1, boolean flag, f f1)
    {
        Object obj = a1.b();
        com.facebook.internal.o.b b1 = o.a(((String) (obj)), false);
        GraphRequest graphrequest = GraphRequest.a(null, String.format("%s/activities", new Object[] {
            obj
        }), null, null);
        Bundle bundle = graphrequest.e();
        obj = bundle;
        if (bundle == null)
        {
            obj = new Bundle();
        }
        ((Bundle) (obj)).putString("access_token", a1.a());
        graphrequest.a(((Bundle) (obj)));
        if (b1 == null)
        {
            return null;
        }
        int j1 = i1.a(graphrequest, b1.a(), flag);
        if (j1 == 0)
        {
            return null;
        } else
        {
            f1.a = j1 + f1.a;
            graphrequest.a(new com.facebook.GraphRequest.b(a1, graphrequest, i1, f1) {

                final a a;
                final GraphRequest b;
                final i c;
                final f d;

                public void a(n n1)
                {
                    com.facebook.a.a.a(a, b, n1, c, d);
                }

            
            {
                a = a1;
                b = graphrequest;
                c = i1;
                d = f1;
                super();
            }
            });
            return graphrequest;
        }
    }

    public static c a()
    {
        c c1;
        synchronized (i)
        {
            c1 = f;
        }
        return c1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static f a(d d1, Set set)
    {
        f f1 = new f();
        boolean flag = com.facebook.i.b(h);
        ArrayList arraylist = new ArrayList();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            Object obj = (a)set.next();
            i i1 = a(((a) (obj)));
            if (i1 != null)
            {
                obj = a(((a) (obj)), i1, flag, f1);
                if (obj != null)
                {
                    arraylist.add(obj);
                }
            }
        } while (true);
        if (arraylist.size() > 0)
        {
            com.facebook.internal.j.a(q.e, a, "Flushing %d events due to %s.", new Object[] {
                Integer.valueOf(f1.a), d1.toString()
            });
            for (d1 = arraylist.iterator(); d1.hasNext(); ((GraphRequest)d1.next()).i()) { }
            return f1;
        } else
        {
            return null;
        }
    }

    static i a(Context context, a a1)
    {
        return b(context, a1);
    }

    private static i a(a a1)
    {
        synchronized (i)
        {
            a1 = (i)d.get(a1);
        }
        return a1;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public static com.facebook.a.a a(Context context)
    {
        return new com.facebook.a.a(context, null, null);
    }

    private void a(long l1)
    {
        g.a(h, c, this, l1);
    }

    private void a(long l1, String s)
    {
        g.a(h, c, this, l1, s);
    }

    private static void a(Activity activity)
    {
        Object obj = activity.getCallingActivity();
        if (obj != null)
        {
            obj = ((ComponentName) (obj)).getPackageName();
            if (((String) (obj)).equals(activity.getPackageName()))
            {
                d();
                return;
            }
            k = ((String) (obj));
        }
        activity = activity.getIntent();
        if (activity == null || activity.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))
        {
            d();
            return;
        }
        obj = a.c.a(activity);
        if (obj == null)
        {
            d();
            return;
        }
        l = true;
        obj = ((Bundle) (obj)).getBundle("referer_app_link");
        if (obj == null)
        {
            k = null;
            return;
        } else
        {
            k = ((Bundle) (obj)).getString("package");
            activity.putExtra("_fbSourceApplicationHasBeenSet", true);
            return;
        }
    }

    private static void a(Context context, b b1, a a1)
    {
label0:
        {
            com.facebook.i.d().execute(new Runnable(context, a1, b1) {

                final Context a;
                final a b;
                final b c;

                public void run()
                {
                    com.facebook.a.a.a(a, b).a(c);
                    com.facebook.a.a.g();
                }

            
            {
                a = context;
                b = a1;
                c = b1;
                super();
            }
            });
            if (!b.a(b1) && !m)
            {
                if (b1.a() != "fb_mobile_activate_app")
                {
                    break label0;
                }
                m = true;
            }
            return;
        }
        com.facebook.internal.j.a(q.e, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
    }

    public static void a(Context context, String s)
    {
        if (context == null || s == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        long l1;
        if (context instanceof Activity)
        {
            a((Activity)context);
        } else
        {
            d();
            Log.d(com/facebook/a/a.getName(), "To set source application the context of activateApp must be an instance of Activity");
        }
        com.facebook.i.a(context, s);
        context = new com.facebook.a.a(context, s, null);
        l1 = System.currentTimeMillis();
        s = c();
        e.execute(new Runnable(context, l1, s) {

            final com.facebook.a.a a;
            final long b;
            final String c;

            public void run()
            {
                com.facebook.a.a.a(a, b, c);
            }

            
            {
                a = a1;
                b = l1;
                c = s;
                super();
            }
        });
    }

    static void a(a a1, GraphRequest graphrequest, n n1, i i1, f f1)
    {
        b(a1, graphrequest, n1, i1, f1);
    }

    static void a(d d1)
    {
        c(d1);
    }

    static void a(com.facebook.a.a a1, long l1)
    {
        a1.a(l1);
    }

    static void a(com.facebook.a.a a1, long l1, String s)
    {
        a1.a(l1, s);
    }

    private static void a(String s)
    {
        com.facebook.internal.j.a(q.f, "AppEvents", s);
    }

    private void a(String s, Double double1, Bundle bundle, boolean flag)
    {
        s = new b(b, s, double1, bundle, flag);
        a(h, ((b) (s)), c);
    }

    private static i b(Context context, a a1)
    {
        com.facebook.internal.b b1;
        i i1 = (i)d.get(a1);
        b1 = null;
        if (i1 == null)
        {
            b1 = com.facebook.internal.b.a(context);
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        i k1 = (i)d.get(a1);
        i j1;
        j1 = k1;
        if (k1 != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        j1 = new i(b1, context.getPackageName(), b(context));
        d.put(a1, j1);
        obj;
        JVM INSTR monitorexit ;
        return j1;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static String b(Context context)
    {
        if (j == null)
        {
            synchronized (i)
            {
                if (j == null)
                {
                    j = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (j == null)
                    {
                        j = (new StringBuilder()).append("XZ").append(UUID.randomUUID().toString()).toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", j).apply();
                    }
                }
            }
        }
        return j;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void b()
    {
        if (a() != com.facebook.a.c.b)
        {
            b(d.f);
        }
    }

    public static void b(Context context, String s)
    {
        if (context == null || s == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        } else
        {
            d();
            context = new com.facebook.a.a(context, s, null);
            long l1 = System.currentTimeMillis();
            e.execute(new Runnable(context, l1) {

                final com.facebook.a.a a;
                final long b;

                public void run()
                {
                    com.facebook.a.a.a(a, b);
                }

            
            {
                a = a1;
                b = l1;
                super();
            }
            });
            return;
        }
    }

    private static void b(a a1, GraphRequest graphrequest, n n1, i i1, f f1)
    {
        com.facebook.h h1 = n1.a();
        Object obj = e.a;
        String s;
        q q1;
        String s1;
        boolean flag;
        if (h1 != null)
        {
            if (h1.b() == -1)
            {
                n1 = com.facebook.a.e.c;
                s = "Failed: No Connectivity";
            } else
            {
                s = String.format("Failed:\n  Response: %s\n  Error %s", new Object[] {
                    n1.toString(), h1.toString()
                });
                n1 = com.facebook.a.e.b;
            }
        } else
        {
            s = "Success";
            n1 = ((n) (obj));
        }
        if (!com.facebook.i.a(q.e)) goto _L2; else goto _L1
_L1:
        obj = (String)graphrequest.h();
        obj = JSONArrayInstrumentation.init(((String) (obj)));
        if (obj instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        obj = ((JSONArray) (obj)).toString(2);
_L3:
        q1 = q.e;
        s1 = a;
        graphrequest = graphrequest.a();
        if (!(graphrequest instanceof JSONObject))
        {
            graphrequest = graphrequest.toString();
        } else
        {
            graphrequest = JSONObjectInstrumentation.toString((JSONObject)graphrequest);
        }
        com.facebook.internal.j.a(q1, s1, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[] {
            graphrequest, s, obj
        });
_L2:
        if (h1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1.a(flag);
        if (n1 == com.facebook.a.e.c)
        {
            h.a(h, a1, i1);
        }
        if (n1 != e.a && f1.b != com.facebook.a.e.c)
        {
            f1.b = n1;
        }
        return;
        try
        {
            obj = JSONArrayInstrumentation.toString((JSONArray)obj, 2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = "<Can't encode events for debug logging>";
        }
          goto _L3
    }

    private static void b(d d1)
    {
        com.facebook.i.d().execute(new Runnable(d1) {

            final d a;

            public void run()
            {
                com.facebook.a.a.a(a);
            }

            
            {
                a = d1;
                super();
            }
        });
    }

    public static com.facebook.a.a c(Context context, String s)
    {
        return new com.facebook.a.a(context, s, null);
    }

    static String c()
    {
        String s = "Unclassified";
        if (l)
        {
            s = "Applink";
        }
        String s1 = s;
        if (k != null)
        {
            s1 = (new StringBuilder()).append(s).append("(").append(k).append(")").toString();
        }
        return s1;
    }

    private static void c(d d1)
    {
label0:
        {
            synchronized (i)
            {
                if (!g)
                {
                    break label0;
                }
            }
            return;
        }
        HashSet hashset;
        g = true;
        hashset = new HashSet(d.keySet());
        obj;
        JVM INSTR monitorexit ;
        n();
        obj = null;
        try
        {
            d1 = a(d1, hashset);
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            o.a(a, "Caught unexpected exception while flushing: ", d1);
            d1 = ((d) (obj));
        }
        synchronized (i)
        {
            g = false;
        }
        if (d1 != null)
        {
            obj = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
            ((Intent) (obj)).putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", ((f) (d1)).a);
            ((Intent) (obj)).putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", ((f) (d1)).b);
            android.support.v4.a.h.a(h).a(((Intent) (obj)));
            return;
        } else
        {
            return;
        }
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
    }

    static void d()
    {
        k = null;
        l = false;
    }

    static Object e()
    {
        return i;
    }

    static Map f()
    {
        return d;
    }

    static void g()
    {
        l();
    }

    static Context h()
    {
        return h;
    }

    static String i()
    {
        return a;
    }

    static ScheduledThreadPoolExecutor j()
    {
        return e;
    }

    private static void k()
    {
label0:
        {
            synchronized (i)
            {
                if (e == null)
                {
                    break label0;
                }
            }
            return;
        }
        e = new ScheduledThreadPoolExecutor(1);
        obj;
        JVM INSTR monitorexit ;
        obj = new Runnable() {

            public void run()
            {
                if (com.facebook.a.a.a() != com.facebook.a.c.b)
                {
                    com.facebook.a.a.a(com.facebook.a.d.b);
                }
            }

        };
        e.scheduleAtFixedRate(((Runnable) (obj)), 0L, 15L, TimeUnit.SECONDS);
        obj = new Runnable() {

            public void run()
            {
                Object obj2 = new HashSet();
                Object obj1 = com.facebook.a.a.e();
                obj1;
                JVM INSTR monitorenter ;
                for (Iterator iterator1 = com.facebook.a.a.f().keySet().iterator(); iterator1.hasNext(); ((Set) (obj2)).add(((a)iterator1.next()).b())) { }
                break MISSING_BLOCK_LABEL_64;
                obj2;
                obj1;
                JVM INSTR monitorexit ;
                throw obj2;
                obj1;
                JVM INSTR monitorexit ;
                for (Iterator iterator = ((Set) (obj2)).iterator(); iterator.hasNext(); o.a((String)iterator.next(), true)) { }
                return;
            }

        };
        e.scheduleAtFixedRate(((Runnable) (obj)), 0L, 0x15180L, TimeUnit.SECONDS);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void l()
    {
        synchronized (i)
        {
            if (a() != com.facebook.a.c.b && m() > 100)
            {
                b(d.e);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static int m()
    {
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = d.values().iterator();
        int i1 = 0;
        while (iterator.hasNext()) 
        {
            i1 = ((i)iterator.next()).a() + i1;
        }
        obj;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static int n()
    {
        h h1 = h.a(h);
        Iterator iterator = h1.a().iterator();
        Object obj;
        int j1;
        for (j1 = 0; iterator.hasNext(); j1 = ((List) (obj)).size() + j1)
        {
            obj = (a)iterator.next();
            i i1 = b(h, ((a) (obj)));
            obj = h1.a(((a) (obj)));
            i1.a(((List) (obj)));
        }

        return j1;
    }

    public void a(String s, double d1, Bundle bundle)
    {
        a(s, Double.valueOf(d1), bundle, false);
    }

    public void a(String s, Bundle bundle)
    {
        a(s, ((Double) (null)), bundle, false);
    }

    public void a(String s, Double double1, Bundle bundle)
    {
        a(s, double1, bundle, true);
    }

    public void a(BigDecimal bigdecimal, Currency currency)
    {
        a(bigdecimal, currency, ((Bundle) (null)));
    }

    public void a(BigDecimal bigdecimal, Currency currency, Bundle bundle)
    {
        if (bigdecimal == null)
        {
            a("purchaseAmount cannot be null");
            return;
        }
        if (currency == null)
        {
            a("currency cannot be null");
            return;
        }
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putString("fb_currency", currency.getCurrencyCode());
        a("fb_mobile_purchase", bigdecimal.doubleValue(), bundle1);
        b();
    }

    static 
    {
        f = c.a;
    }
}
