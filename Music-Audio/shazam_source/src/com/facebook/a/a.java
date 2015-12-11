// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.a.e;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.b.c;
import com.facebook.b.o;
import com.facebook.b.t;
import com.facebook.b.u;
import com.facebook.j;
import com.facebook.k;
import com.facebook.p;
import com.facebook.s;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
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
    private static final class a
        implements Serializable
    {

        final String a;
        final String b;

        public final boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                if (t.a(((a) (obj = (a)obj)).a, a) && t.a(((a) (obj)).b, b))
                {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode()
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
            this(accesstoken.d, com.facebook.k.j());
        }

        a(String s1, String s2)
        {
            String s3 = s1;
            if (t.a(s1))
            {
                s3 = null;
            }
            a = s3;
            b = s2;
        }
    }

    static final class b
        implements Serializable
    {

        private static final HashSet d = new HashSet();
        JSONObject a;
        boolean b;
        String c;

        private static void a(String s1)
        {
            if (s1 == null || s1.length() == 0 || s1.length() > 40)
            {
                String s2 = s1;
                if (s1 == null)
                {
                    s2 = "<None Provided>";
                }
                throw new com.facebook.h(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] {
                    s2, Integer.valueOf(40)
                }));
            }
            boolean flag;
            synchronized (d)
            {
                flag = d.contains(s1);
            }
            if (!flag)
            {
                if (!s1.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"))
                {
                    break MISSING_BLOCK_LABEL_117;
                }
                synchronized (d)
                {
                    d.add(s1);
                }
            }
            return;
            s1;
            hashset;
            JVM INSTR monitorexit ;
            throw s1;
            s1;
            hashset;
            JVM INSTR monitorexit ;
            throw s1;
            throw new com.facebook.h(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] {
                s1
            }));
        }

        static boolean a(b b1)
        {
            return b1.b;
        }

        public final String toString()
        {
            return String.format("\"%s\", implicit: %b, json: %s", new Object[] {
                a.optString("_eventName"), Boolean.valueOf(b), a.toString()
            });
        }


        public b(String s1, String s2, Double double1, Bundle bundle, boolean flag)
        {
            a(s2);
            c = s2;
            b = flag;
            a = new JSONObject();
            a.put("_eventName", s2);
            a.put("_logTime", System.currentTimeMillis() / 1000L);
            a.put("_ui", s1);
            if (double1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            a.put("_valueToSum", double1.doubleValue());
            if (b)
            {
                a.put("_implicitlyLogged", "1");
            }
            if (bundle == null) goto _L2; else goto _L1
_L1:
            s1 = bundle.keySet().iterator();
_L5:
            if (!s1.hasNext()) goto _L2; else goto _L3
_L3:
            s2 = (String)s1.next();
            a(s2);
            double1 = ((Double) (bundle.get(s2)));
            if (!(double1 instanceof String) && !(double1 instanceof Number))
            {
                throw new com.facebook.h(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] {
                    double1, s2
                }));
            }
              goto _L4
            s1;
            o.a(s.e, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] {
                s1.toString()
            });
            a = null;
_L7:
            return;
_L4:
            a.put(s2, double1.toString());
              goto _L5
            s1;
            o.a(s.e, "AppEvents", "Invalid app event name or parameter:", new Object[] {
                s1.toString()
            });
            a = null;
            return;
_L2:
            if (b) goto _L7; else goto _L6
_L6:
            o.a(s.e, "AppEvents", "Created app event '%s'", new Object[] {
                a.toString()
            });
            return;
              goto _L5
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        private static final c c[];

        public static c valueOf(String s1)
        {
            return (c)Enum.valueOf(com/facebook/a/a$c, s1);
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

        private c(String s1, int i1)
        {
            super(s1, i1);
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

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/facebook/a/a$d, s1);
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

        private d(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    private static final class e extends Enum
    {

        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        private static final e e[];

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(com/facebook/a/a$e, s1);
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

        private e(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    private static final class f
    {

        public int a;
        public e b;

        private f()
        {
            a = 0;
            b = e.a;
        }

        f(byte byte0)
        {
            this();
        }
    }

    static final class g
    {

        private static final Object a = new Object();
        private static boolean b = false;
        private static boolean c = false;
        private static Map d;
        private static final Runnable e = new Runnable() {

            public final void run()
            {
                g.a(com.facebook.a.a.e());
            }

        };

        private static com.facebook.a.b a(Context context, a a1)
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
            o.a(s.e, "AppEvents", "App session info loaded");
            t.a(((java.io.Closeable) (obj)));
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
            obj = (com.facebook.a.b)d.get(a1);
            context = ((Context) (obj));
            if (obj == null)
            {
                context = new com.facebook.a.b();
                d.put(a1, context);
            }
            return context;
            obj;
            obj = obj1;
_L4:
            t.a(((java.io.Closeable) (obj)));
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
            com.facebook.a.a.f();
            obj1 = obj;
            (new StringBuilder("Got unexpected exception: ")).append(exception.toString());
            t.a(((java.io.Closeable) (obj)));
            context.deleteFile("AppEventsLogger.persistedsessioninfo");
            if (d == null)
            {
                d = new HashMap();
            }
            c = true;
            b = false;
              goto _L1
_L2:
            t.a(((java.io.Closeable) (obj1)));
            context.deleteFile("AppEventsLogger.persistedsessioninfo");
            if (d == null)
            {
                d = new HashMap();
            }
            c = true;
            b = false;
            throw a1;
            a1;
              goto _L2
            exception;
              goto _L3
            obj1;
              goto _L4
            a1;
            obj1 = null;
              goto _L2
        }

        private static void a()
        {
            if (!b)
            {
                b = true;
                com.facebook.a.a.g().schedule(e, 30L, TimeUnit.SECONDS);
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
            o.a(s.e, "AppEvents", "App session info saved");
            t.a(objectoutputstream);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            objectoutputstream = null;
_L4:
            context = objectoutputstream;
            com.facebook.a.a.f();
            context = objectoutputstream;
            (new StringBuilder("Got unexpected exception: ")).append(exception1.toString());
            t.a(objectoutputstream);
              goto _L1
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
            Exception exception;
            exception;
            context = null;
_L3:
            t.a(context);
            throw exception;
            exception;
            if (true) goto _L3; else goto _L2
_L2:
            exception1;
              goto _L4
        }

        static void a(Context context, a a1, long l1)
        {
            long l2 = 0L;
            Object obj = a;
            obj;
            JVM INSTR monitorenter ;
            context = a(context, a1);
            if (((com.facebook.a.b) (context)).c) goto _L2; else goto _L1
_L1:
            o.a(s.e, com.facebook.a.b.a, "Suspend for inactive app");
_L3:
            a();
            return;
_L2:
            long l3 = l1 - ((com.facebook.a.b) (context)).e;
            if (l3 >= 0L)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            o.a(s.e, com.facebook.a.b.a, "Clock skew detected");
_L4:
            context.g = l2 + ((com.facebook.a.b) (context)).g;
            context.f = l1;
            context.c = false;
              goto _L3
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
            l2 = l3;
              goto _L4
        }

        static void a(Context context, a a1, com.facebook.a.a a2, long l1, String s1)
        {
            Object obj = a;
            obj;
            JVM INSTR monitorenter ;
            context = a(context, a1);
            boolean flag;
            long l2;
            long l3;
            if (!((com.facebook.a.b) (context)).b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            context.b = true;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            if (l1 - ((com.facebook.a.b) (context)).d <= 0x493e0L)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            a1 = new Bundle();
            a1.putString("fb_mobile_launch_source", s1);
            a2.a("fb_mobile_activate_app", a1);
            context.d = l1;
            if (!((com.facebook.a.b) (context)).c) goto _L2; else goto _L1
_L1:
            o.a(s.e, com.facebook.a.b.a, "Resume for active app");
_L7:
            a();
            obj;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (((com.facebook.a.b) (context)).f != -1L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag) goto _L4; else goto _L3
_L3:
            l2 = l1 - ((com.facebook.a.b) (context)).f;
_L8:
            l3 = l2;
            if (l2 >= 0L)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            o.a(s.e, com.facebook.a.b.a, "Clock skew detected");
            l3 = 0L;
            if (l3 <= 60000L) goto _L6; else goto _L5
_L5:
            a1 = new Bundle();
            a1.putInt("fb_mobile_app_interruptions", ((com.facebook.a.b) (context)).h);
            a1.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", new Object[] {
                Integer.valueOf(com.facebook.a.b.a(l3))
            }));
            a1.putString("fb_mobile_launch_source", ((com.facebook.a.b) (context)).i);
            a2.a("fb_mobile_deactivate_app", Double.valueOf(((com.facebook.a.b) (context)).g / 1000L), a1, false);
            context.a();
_L10:
            if (((com.facebook.a.b) (context)).h == 0)
            {
                context.i = s1;
            }
            context.e = l1;
            context.c = true;
              goto _L7
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
_L4:
            l2 = 0L;
              goto _L8
_L6:
            if (l3 <= 1000L) goto _L10; else goto _L9
_L9:
            context.h = ((com.facebook.a.b) (context)).h + 1;
              goto _L10
        }

    }

    static final class h
    {

        private static Object b = new Object();
        HashMap a;
        private Context c;

        public static h a(Context context)
        {
            Object obj1 = b;
            obj1;
            JVM INSTR monitorenter ;
            h h1 = new h(context);
            Object obj = null;
            context = new ObjectInputStream(new BufferedInputStream(h1.c.openFileInput("AppEventsLogger.persistedevents")));
            obj = context;
            HashMap hashmap = (HashMap)context.readObject();
            obj = context;
            h1.c.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            obj = context;
            h1.a = hashmap;
            t.a(context);
_L1:
            obj1;
            JVM INSTR monitorexit ;
            return h1;
_L4:
            t.a(context);
              goto _L1
            context;
            obj1;
            JVM INSTR monitorexit ;
            throw context;
            Exception exception;
            exception;
            context = null;
_L3:
            obj = context;
            com.facebook.a.a.f();
            obj = context;
            (new StringBuilder("Got unexpected exception: ")).append(exception.toString());
            t.a(context);
              goto _L1
_L2:
            t.a(((java.io.Closeable) (obj)));
            throw context;
            context;
              goto _L2
            exception;
              goto _L3
            obj;
              goto _L4
            context;
            context = ((Context) (obj));
              goto _L4
            context;
            obj = null;
              goto _L2
        }

        public static void a(Context context, a a1, i i1)
        {
            HashMap hashmap = new HashMap();
            hashmap.put(a1, i1);
            a(context, ((Map) (hashmap)));
        }

        private static void a(Context context, Map map)
        {
            Object obj = b;
            obj;
            JVM INSTR monitorenter ;
            h h1;
            h1 = a(context);
            context = map.entrySet().iterator();
            do
            {
                if (!context.hasNext())
                {
                    break;
                }
                Object obj1 = (java.util.Map.Entry)context.next();
                map = ((i)((java.util.Map.Entry) (obj1)).getValue()).b();
                if (map.size() != 0)
                {
                    obj1 = (a)((java.util.Map.Entry) (obj1)).getKey();
                    if (!h1.a.containsKey(obj1))
                    {
                        h1.a.put(obj1, new ArrayList());
                    }
                    ((List)h1.a.get(obj1)).addAll(map);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_134;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
            map = new ObjectOutputStream(new BufferedOutputStream(h1.c.openFileOutput("AppEventsLogger.persistedevents", 0)));
            context = map;
            map.writeObject(h1.a);
            t.a(map);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            map = null;
_L3:
            context = map;
            com.facebook.a.a.f();
            context = map;
            (new StringBuilder("Got unexpected exception: ")).append(exception.toString());
            t.a(map);
              goto _L1
_L2:
            t.a(context);
            throw map;
            map;
              goto _L2
            exception;
              goto _L3
            map;
            context = null;
              goto _L2
        }


        private h(Context context)
        {
            a = new HashMap();
            c = context;
        }
    }

    static final class i
    {

        private List a;
        private List b;
        private int c;
        private com.facebook.b.c d;
        private String e;
        private String f;
        private final int g = 1000;

        private static byte[] a(String s1)
        {
            try
            {
                s1 = s1.getBytes("UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                t.a(s1);
                return null;
            }
            return s1;
        }

        public final int a()
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

        public final int a(GraphRequest graphrequest, boolean flag, boolean flag1)
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            JSONArray jsonarray;
            int i1;
            i1 = c;
            b.addAll(a);
            a.clear();
            jsonarray = new JSONArray();
            obj = b.iterator();
_L3:
            Object obj1;
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_104;
            }
            obj1 = (b)((Iterator) (obj)).next();
            if (flag) goto _L2; else goto _L1
_L1:
            if (((b) (obj1)).b) goto _L3; else goto _L2
_L2:
            jsonarray.put(((b) (obj1)).a);
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
            obj1 = com.facebook.b.b.a(com.facebook.b.b.a.b, d, f, flag1, com.facebook.a.a.e());
            obj = obj1;
            if (c <= 0)
            {
                break MISSING_BLOCK_LABEL_163;
            }
            ((JSONObject) (obj1)).put("num_skipped_events", i1);
            obj = obj1;
_L5:
            graphrequest.c = ((JSONObject) (obj));
            Object obj2 = graphrequest.d;
            obj = obj2;
            if (obj2 == null)
            {
                obj = new Bundle();
            }
            obj2 = jsonarray.toString();
            if (obj2 != null)
            {
                ((Bundle) (obj)).putByteArray("custom_events_file", a(((String) (obj2))));
                graphrequest.f = obj2;
            }
            graphrequest.d = ((Bundle) (obj));
            return jsonarray.length();
            JSONException jsonexception;
            jsonexception;
            jsonexception = new JSONObject();
            if (true) goto _L5; else goto _L4
_L4:
        }

        public final void a(b b1)
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

        public final void a(List list)
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

        public final void a(boolean flag)
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

        public final List b()
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

        public i(com.facebook.b.c c1, String s1, String s2)
        {
            a = new ArrayList();
            b = new ArrayList();
            d = c1;
            e = s1;
            f = s2;
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

    private com.facebook.a.a(Context context, String s1)
    {
        u.a(context, "context");
        b = t.c(context);
        AccessToken accesstoken = AccessToken.a();
        if (accesstoken != null && (s1 == null || s1.equals(accesstoken.g)))
        {
            c = new a(accesstoken);
        } else
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = t.a(context);
            }
            c = new a(null, s2);
        }
        synchronized (i)
        {
            if (h == null)
            {
                h = context.getApplicationContext();
            }
        }
        synchronized (i)
        {
            if (e == null)
            {
                break MISSING_BLOCK_LABEL_121;
            }
        }
        return;
        context;
        s1;
        JVM INSTR monitorexit ;
        throw context;
        e = new ScheduledThreadPoolExecutor(1);
        context;
        JVM INSTR monitorexit ;
        context = new Runnable() {

            public final void run()
            {
                if (com.facebook.a.a.a() != c.b)
                {
                    com.facebook.a.a.a(d.b);
                }
            }

        };
        e.scheduleAtFixedRate(context, 0L, 15L, TimeUnit.SECONDS);
        context = new Runnable() {

            public final void run()
            {
                Object obj1 = new HashSet();
                Object obj = com.facebook.a.a.b();
                obj;
                JVM INSTR monitorenter ;
                for (Iterator iterator1 = com.facebook.a.a.c().keySet().iterator(); iterator1.hasNext(); ((Set) (obj1)).add(((a)iterator1.next()).b)) { }
                break MISSING_BLOCK_LABEL_64;
                obj1;
                obj;
                JVM INSTR monitorexit ;
                throw obj1;
                obj;
                JVM INSTR monitorexit ;
                for (Iterator iterator = ((Set) (obj1)).iterator(); iterator.hasNext(); t.a((String)iterator.next(), true)) { }
                return;
            }

        };
        e.scheduleAtFixedRate(context, 0L, 0x15180L, TimeUnit.SECONDS);
        return;
        s1;
        context;
        JVM INSTR monitorexit ;
        throw s1;
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
        f f1 = new f((byte)0);
        boolean flag = com.facebook.k.b(h);
        ArrayList arraylist = new ArrayList();
        Iterator iterator = set.iterator();
        do
        {
            if (iterator.hasNext())
            {
                a a1 = (a)iterator.next();
                i i1 = a(a1);
                if (i1 != null)
                {
                    set = a1.b;
                    com.facebook.b.t.b b1 = t.a(set, false);
                    GraphRequest graphrequest = GraphRequest.a(String.format("%s/activities", new Object[] {
                        set
                    }), null);
                    Bundle bundle = graphrequest.d;
                    set = bundle;
                    if (bundle == null)
                    {
                        set = new Bundle();
                    }
                    set.putString("access_token", a1.a);
                    graphrequest.d = set;
                    if (b1 == null)
                    {
                        set = null;
                    } else
                    {
                        int j1 = i1.a(graphrequest, b1.a, flag);
                        if (j1 == 0)
                        {
                            set = null;
                        } else
                        {
                            f1.a = j1 + f1.a;
                            graphrequest.a(new com.facebook.GraphRequest.b(a1, graphrequest, i1, f1) {

                                final a a;
                                final GraphRequest b;
                                final i c;
                                final f d;

                                public final void a(p p1)
                                {
                                    com.facebook.a.a.a(a, b, p1, c, d);
                                }

            
            {
                a = a1;
                b = graphrequest;
                c = i1;
                d = f1;
                super();
            }
                            });
                            set = graphrequest;
                        }
                    }
                    if (set != null)
                    {
                        arraylist.add(set);
                    }
                }
            } else
            {
                if (arraylist.size() > 0)
                {
                    o.a(s.e, a, "Flushing %d events due to %s.", new Object[] {
                        Integer.valueOf(f1.a), d1.toString()
                    });
                    for (d1 = arraylist.iterator(); d1.hasNext(); ((GraphRequest)d1.next()).a()) { }
                    return f1;
                }
                return null;
            }
        } while (true);
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

    public static com.facebook.a.a a(Context context, String s1)
    {
        return new com.facebook.a.a(context, s1);
    }

    public static void a(Context context)
    {
        Object obj;
        com.facebook.k.a(context);
        obj = t.a(context);
        if (context == null || obj == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        if (!(context instanceof Activity)) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        obj1 = (Activity)context;
        obj2 = ((Activity) (obj1)).getCallingActivity();
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        obj2 = ((ComponentName) (obj2)).getPackageName();
        if (!((String) (obj2)).equals(((Activity) (obj1)).getPackageName())) goto _L6; else goto _L5
_L5:
        j();
_L8:
        com.facebook.k.a(context, ((String) (obj)));
        obj1 = new com.facebook.a.a(context, ((String) (obj)));
        long l1 = System.currentTimeMillis();
        context = "Unclassified";
        if (l)
        {
            context = "Applink";
        }
        obj = context;
        if (k != null)
        {
            obj = (new StringBuilder()).append(context).append("(").append(k).append(")").toString();
        }
        e.execute(new Runnable(((com.facebook.a.a) (obj1)), l1, ((String) (obj))) {

            final com.facebook.a.a a;
            final long b;
            final String c;

            public final void run()
            {
                com.facebook.a.a.a(a, b, c);
            }

            
            {
                a = a1;
                b = l1;
                c = s1;
                super();
            }
        });
        return;
_L6:
        k = ((String) (obj2));
_L4:
        obj1 = ((Activity) (obj1)).getIntent();
        if (obj1 == null || ((Intent) (obj1)).getBooleanExtra("_fbSourceApplicationHasBeenSet", false))
        {
            j();
        } else
        {
            Bundle bundle = ((Intent) (obj1)).getBundleExtra("al_applink_data");
            if (bundle == null)
            {
                j();
            } else
            {
                l = true;
                bundle = bundle.getBundle("referer_app_link");
                if (bundle == null)
                {
                    k = null;
                } else
                {
                    k = bundle.getString("package");
                    ((Intent) (obj1)).putExtra("_fbSourceApplicationHasBeenSet", true);
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        j();
        com/facebook/a/a.getName();
        if (true) goto _L8; else goto _L7
_L7:
    }

    static void a(a a1, GraphRequest graphrequest, p p1, i i1, f f1)
    {
        j j1 = p1.b;
        Object obj = e.a;
        String s1;
        boolean flag;
        if (j1 != null)
        {
            if (j1.c == -1)
            {
                p1 = com.facebook.a.e.c;
                s1 = "Failed: No Connectivity";
            } else
            {
                s1 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[] {
                    p1.toString(), j1.toString()
                });
                p1 = e.b;
            }
        } else
        {
            s1 = "Success";
            p1 = ((p) (obj));
        }
        if (com.facebook.k.a(s.e))
        {
            obj = (String)graphrequest.f;
            try
            {
                obj = (new JSONArray(((String) (obj)))).toString(2);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = "<Can't encode events for debug logging>";
            }
            o.a(s.e, a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[] {
                graphrequest.c.toString(), s1, obj
            });
        }
        if (j1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i1.a(flag);
        if (p1 == com.facebook.a.e.c)
        {
            h.a(h, a1, i1);
        }
        if (p1 != e.a && f1.b != com.facebook.a.e.c)
        {
            f1.b = p1;
        }
    }

    static void a(d d1)
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
        i();
        obj = null;
        try
        {
            d1 = a(d1, ((Set) (hashset)));
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            t.c(a);
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
            android.support.v4.a.e.a(h).a(((Intent) (obj)));
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

    static void a(com.facebook.a.a a1, long l1)
    {
        g.a(h, a1.c, l1);
    }

    static void a(com.facebook.a.a a1, long l1, String s1)
    {
        g.a(h, a1.c, a1, l1, s1);
    }

    private static i b(Context context, a a1)
    {
        com.facebook.b.c c1;
        i i1 = (i)d.get(a1);
        c1 = null;
        if (i1 == null)
        {
            c1 = com.facebook.b.c.a(context);
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
        j1 = new i(c1, context.getPackageName(), d(context));
        d.put(a1, j1);
        obj;
        JVM INSTR monitorexit ;
        return j1;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static Object b()
    {
        return i;
    }

    public static void b(Context context)
    {
        String s1 = t.a(context);
        if (context == null || s1 == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        } else
        {
            j();
            context = new com.facebook.a.a(context, s1);
            long l1 = System.currentTimeMillis();
            e.execute(new Runnable(context, l1) {

                final com.facebook.a.a a;
                final long b;

                public final void run()
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

    public static com.facebook.a.a c(Context context)
    {
        return new com.facebook.a.a(context, null);
    }

    static Map c()
    {
        return d;
    }

    public static String d(Context context)
    {
        if (j != null) goto _L2; else goto _L1
_L1:
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        String s1;
        if (j != null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        s1 = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
        j = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        j = (new StringBuilder("XZ")).append(UUID.randomUUID().toString()).toString();
        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", j).apply();
        obj;
        JVM INSTR monitorexit ;
_L2:
        return j;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void d()
    {
        synchronized (i)
        {
            if (a() != c.b && h() > 100)
            {
                d d1 = com.facebook.a.d.e;
                com.facebook.k.e().execute(new Runnable(d1) {

                    final d a;

                    public final void run()
                    {
                        com.facebook.a.a.a(a);
                    }

            
            {
                a = d1;
                super();
            }
                });
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static Context e()
    {
        return h;
    }

    static String f()
    {
        return a;
    }

    static ScheduledThreadPoolExecutor g()
    {
        return e;
    }

    private static int h()
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

    private static int i()
    {
        h h1 = h.a(h);
        Iterator iterator = h1.a.keySet().iterator();
        Object obj;
        int j1;
        for (j1 = 0; iterator.hasNext(); j1 = ((List) (obj)).size() + j1)
        {
            obj = (a)iterator.next();
            i i1 = b(h, ((a) (obj)));
            obj = (List)h1.a.get(obj);
            i1.a(((List) (obj)));
        }

        return j1;
    }

    private static void j()
    {
        k = null;
        l = false;
    }

    public final void a(String s1, Bundle bundle)
    {
        a(s1, null, bundle, false);
    }

    final void a(String s1, Double double1, Bundle bundle, boolean flag)
    {
label0:
        {
            s1 = new b(b, s1, double1, bundle, flag);
            double1 = h;
            bundle = c;
            com.facebook.k.e().execute(new Runnable(double1, bundle, s1) {

                final Context a;
                final a b;
                final b c;

                public final void run()
                {
                    com.facebook.a.a.a(a, b).a(c);
                    com.facebook.a.a.d();
                }

            
            {
                a = context;
                b = a1;
                c = b1;
                super();
            }
            });
            if (!b.a(s1) && !m)
            {
                if (((b) (s1)).c != "fb_mobile_activate_app")
                {
                    break label0;
                }
                m = true;
            }
            return;
        }
        o.a(s.e, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
    }

    public final void b(String s1, Bundle bundle)
    {
        a(s1, null, bundle, true);
    }

    static 
    {
        f = c.a;
    }
}
