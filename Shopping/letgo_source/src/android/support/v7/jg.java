// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
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

// Referenced classes of package android.support.v7:
//            kc, kb, jv, cn, 
//            jk, p, jh, jj

public class jg
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
                if (kb.a(((a) (obj = (a)obj)).a, a) && kb.a(((a) (obj)).b, b))
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
            this(accesstoken.b(), com.facebook.k.i());
        }

        a(String s1, String s2)
        {
            String s3 = s1;
            if (kb.a(s1))
            {
                s3 = null;
            }
            a = s3;
            b = s2;
        }
    }

    static class b
        implements Serializable
    {

        private static final HashSet c = new HashSet();
        private JSONObject a;
        private boolean b;
        private String d;

        private void a(String s1)
            throws com.facebook.h
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
            synchronized (c)
            {
                flag = c.contains(s1);
            }
            if (!flag)
            {
                if (!s1.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"))
                {
                    break MISSING_BLOCK_LABEL_117;
                }
                synchronized (c)
                {
                    c.add(s1);
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

        public boolean a()
        {
            return b;
        }

        public JSONObject b()
        {
            return a;
        }

        public String toString()
        {
            return String.format("\"%s\", implicit: %b, json: %s", new Object[] {
                a.optString("_eventName"), Boolean.valueOf(b), a.toString()
            });
        }


        public b(String s1, String s2, Double double1, Bundle bundle, boolean flag)
        {
            a(s2);
            d = s2;
            b = flag;
            a = new JSONObject();
            a.put("_eventName", s2);
            a.put("_logTime", System.currentTimeMillis() / 1000L);
            a.put("_ui", s1);
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
            jv.a(s.e, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] {
                s1.toString()
            });
            a = null;
_L7:
            return;
_L4:
            a.put(s2, double1.toString());
              goto _L5
            s1;
            jv.a(s.e, "AppEvents", "Invalid app event name or parameter:", new Object[] {
                s1.toString()
            });
            a = null;
            return;
_L2:
            if (b) goto _L7; else goto _L6
_L6:
            jv.a(s.e, "AppEvents", "Created app event '%s'", new Object[] {
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
            return (c)Enum.valueOf(android/support/v7/jg$c, s1);
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
            return (d)Enum.valueOf(android/support/v7/jg$d, s1);
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
            return (e)Enum.valueOf(android/support/v7/jg$e, s1);
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
                g.a(jg.g());
            }

        };

        private static jh a(Context context, a a1)
        {
            b(context);
            jh jh1 = (jh)d.get(a1);
            context = jh1;
            if (jh1 == null)
            {
                context = new jh();
                d.put(a1, context);
            }
            return context;
        }

        private static void a()
        {
            if (!b)
            {
                b = true;
                jg.i().schedule(e, 30L, TimeUnit.SECONDS);
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
            jv.a(s.e, "AppEvents", "App session info saved");
            kb.a(objectoutputstream);
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            objectoutputstream = null;
_L4:
            context = objectoutputstream;
            Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
            kb.a(objectoutputstream);
              goto _L1
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
            Exception exception;
            exception;
            context = null;
_L3:
            kb.a(context);
            throw exception;
            exception;
            if (true) goto _L3; else goto _L2
_L2:
            exception1;
              goto _L4
        }

        static void a(Context context, a a1, jg jg1, long l1)
        {
            synchronized (a)
            {
                a(context, a1).a(jg1, l1);
                a();
            }
            return;
            context;
            obj;
            JVM INSTR monitorexit ;
            throw context;
        }

        static void a(Context context, a a1, jg jg1, long l1, String s1)
        {
            synchronized (a)
            {
                a(context, a1).a(jg1, l1, s1);
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
            jv.a(s.e, "AppEvents", "App session info loaded");
            kb.a(((java.io.Closeable) (obj)));
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
            kb.a(((java.io.Closeable) (obj)));
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
            Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception.toString()).toString());
            kb.a(((java.io.Closeable) (obj)));
            context.deleteFile("AppEventsLogger.persistedsessioninfo");
            if (d == null)
            {
                d = new HashMap();
            }
            c = true;
            b = false;
              goto _L1
_L2:
            kb.a(((java.io.Closeable) (obj1)));
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
            kb.a(objectoutputstream1);
            return;
            Exception exception1;
            exception1;
            objectoutputstream1 = null;
_L4:
            objectoutputstream = objectoutputstream1;
            Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
            kb.a(objectoutputstream1);
            return;
            Exception exception;
            exception;
            objectoutputstream = null;
_L2:
            kb.a(objectoutputstream);
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
            kb.a(((java.io.Closeable) (obj)));
            return;
            obj;
            obj = obj1;
_L6:
            kb.a(((java.io.Closeable) (obj)));
            return;
            Exception exception1;
            exception1;
            obj = null;
_L4:
            obj1 = obj;
            Log.d(jg.h(), (new StringBuilder()).append("Got unexpected exception: ").append(exception1.toString()).toString());
            kb.a(((java.io.Closeable) (obj)));
            return;
            Exception exception;
            exception;
            obj1 = null;
_L2:
            kb.a(((java.io.Closeable) (obj1)));
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
        private jk d;
        private String e;
        private String f;
        private final int g = 1000;

        private void a(GraphRequest graphrequest, int i1, JSONArray jsonarray, boolean flag)
        {
            JSONObject jsonobject = jj.a(jj.a.b, d, f, flag, jg.g());
            Object obj = jsonobject;
            if (c <= 0)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            jsonobject.put("num_skipped_events", i1);
            obj = jsonobject;
_L2:
            graphrequest.a(((JSONObject) (obj)));
            Bundle bundle = graphrequest.e();
            obj = bundle;
            if (bundle == null)
            {
                obj = new Bundle();
            }
            jsonarray = jsonarray.toString();
            if (jsonarray != null)
            {
                ((Bundle) (obj)).putByteArray("custom_events_file", a(((String) (jsonarray))));
                graphrequest.a(jsonarray);
            }
            graphrequest.a(((Bundle) (obj)));
            return;
            JSONException jsonexception;
            jsonexception;
            jsonexception = new JSONObject();
            if (true) goto _L2; else goto _L1
_L1:
        }

        private byte[] a(String s1)
        {
            try
            {
                s1 = s1.getBytes("UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                kb.a("Encoding exception: ", s1);
                return null;
            }
            return s1;
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
            if (b1.a()) goto _L3; else goto _L2
_L2:
            jsonarray.put(b1.b());
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

        public i(jk jk1, String s1, String s2)
        {
            a = new ArrayList();
            b = new ArrayList();
            d = jk1;
            e = s1;
            f = s2;
        }
    }


    private static final String a = android/support/v7/jg.getCanonicalName();
    private static Map d = new ConcurrentHashMap();
    private static ScheduledThreadPoolExecutor e;
    private static c f;
    private static boolean g;
    private static Context h;
    private static Object i = new Object();
    private static String j;
    private static String k;
    private static boolean l;
    private final String b;
    private final a c;

    private jg(Context context, String s1, AccessToken accesstoken)
    {
        kc.a(context, "context");
        b = kb.c(context);
        AccessToken accesstoken1 = accesstoken;
        if (accesstoken == null)
        {
            accesstoken1 = AccessToken.a();
        }
        if (accesstoken1 != null && (s1 == null || s1.equals(accesstoken1.h())))
        {
            c = new a(accesstoken1);
        } else
        {
            accesstoken = s1;
            if (s1 == null)
            {
                accesstoken = kb.a(context);
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
        j();
        return;
        context;
        s1;
        JVM INSTR monitorexit ;
        throw context;
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
        boolean flag = com.facebook.k.b(h);
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
            jv.a(s.e, a, "Flushing %d events due to %s.", new Object[] {
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

    private static GraphRequest a(a a1, i i1, boolean flag, f f1)
    {
        Object obj = a1.b();
        kb.b b1 = kb.a(((String) (obj)), false);
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

                public void a(p p1)
                {
                    jg.a(a, b, p1, c, d);
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

    private void a(long l1)
    {
        g.a(h, c, this, l1);
    }

    private void a(long l1, String s1)
    {
        g.a(h, c, this, l1, s1);
    }

    private static void a(Activity activity)
    {
        Object obj = activity.getCallingActivity();
        if (obj != null)
        {
            obj = ((ComponentName) (obj)).getPackageName();
            if (((String) (obj)).equals(activity.getPackageName()))
            {
                c();
                return;
            }
            k = ((String) (obj));
        }
        activity = activity.getIntent();
        if (activity == null || activity.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))
        {
            c();
            return;
        }
        obj = cn.a(activity);
        if (obj == null)
        {
            c();
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

    public static void a(Context context)
    {
        b(context, kb.a(context));
    }

    private static void a(Context context, b b1, a a1)
    {
        com.facebook.k.d().execute(new Runnable(context, a1, b1) {

            final Context a;
            final a b;
            final b c;

            public void run()
            {
                jg.a(a, b).a(c);
                jg.f();
            }

            
            {
                a = context;
                b = a1;
                c = b1;
                super();
            }
        });
    }

    public static void a(Context context, String s1)
    {
        if (context == null || s1 == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        long l1;
        if (context instanceof Activity)
        {
            a((Activity)context);
        } else
        {
            c();
            Log.d(android/support/v7/jg.getName(), "To set source application the context of activateApp must be an instance of Activity");
        }
        com.facebook.k.a(context, s1);
        context = new jg(context, s1, null);
        l1 = System.currentTimeMillis();
        s1 = b();
        e.execute(new Runnable(context, l1, s1) {

            final jg a;
            final long b;
            final String c;

            public void run()
            {
                jg.a(a, b, c);
            }

            
            {
                a = jg1;
                b = l1;
                c = s1;
                super();
            }
        });
    }

    static void a(a a1, GraphRequest graphrequest, p p1, i i1, f f1)
    {
        b(a1, graphrequest, p1, i1, f1);
    }

    static void a(d d1)
    {
        c(d1);
    }

    static void a(jg jg1, long l1)
    {
        jg1.a(l1);
    }

    static void a(jg jg1, long l1, String s1)
    {
        jg1.a(l1, s1);
    }

    private void a(String s1, Double double1, Bundle bundle, boolean flag)
    {
        s1 = new b(b, s1, double1, bundle, flag);
        a(h, ((b) (s1)), c);
    }

    private static i b(Context context, a a1)
    {
        jk jk1;
        i i1 = (i)d.get(a1);
        jk1 = null;
        if (i1 == null)
        {
            jk1 = jk.a(context);
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
        j1 = new i(jk1, context.getPackageName(), c(context));
        d.put(a1, j1);
        obj;
        JVM INSTR monitorexit ;
        return j1;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static jg b(Context context)
    {
        return new jg(context, null, null);
    }

    static String b()
    {
        String s1 = "Unclassified";
        if (l)
        {
            s1 = "Applink";
        }
        String s2 = s1;
        if (k != null)
        {
            s2 = (new StringBuilder()).append(s1).append("(").append(k).append(")").toString();
        }
        return s2;
    }

    public static void b(Context context, String s1)
    {
        if (context == null || s1 == null)
        {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        } else
        {
            c();
            context = new jg(context, s1, null);
            long l1 = System.currentTimeMillis();
            e.execute(new Runnable(context, l1) {

                final jg a;
                final long b;

                public void run()
                {
                    jg.a(a, b);
                }

            
            {
                a = jg1;
                b = l1;
                super();
            }
            });
            return;
        }
    }

    private static void b(a a1, GraphRequest graphrequest, p p1, i i1, f f1)
    {
        j j1 = p1.a();
        Object obj = e.a;
        String s1;
        boolean flag;
        if (j1 != null)
        {
            if (j1.b() == -1)
            {
                p1 = e.c;
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
            obj = (String)graphrequest.h();
            try
            {
                obj = (new JSONArray(((String) (obj)))).toString(2);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = "<Can't encode events for debug logging>";
            }
            jv.a(s.e, a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[] {
                graphrequest.a().toString(), s1, obj
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
        if (p1 == e.c)
        {
            h.a(h, a1, i1);
        }
        if (p1 != e.a && f1.b != e.c)
        {
            f1.b = p1;
        }
    }

    private static void b(d d1)
    {
        com.facebook.k.d().execute(new Runnable(d1) {

            final d a;

            public void run()
            {
                jg.a(a);
            }

            
            {
                a = d1;
                super();
            }
        });
    }

    public static jg c(Context context, String s1)
    {
        return new jg(context, s1, null);
    }

    public static String c(Context context)
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

    static void c()
    {
        k = null;
        l = false;
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
        m();
        obj = null;
        try
        {
            d1 = a(d1, hashset);
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            kb.a(a, "Caught unexpected exception while flushing: ", d1);
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
            p.a(h).a(((Intent) (obj)));
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

    static Object d()
    {
        return i;
    }

    static Map e()
    {
        return d;
    }

    static void f()
    {
        k();
    }

    static Context g()
    {
        return h;
    }

    static String h()
    {
        return a;
    }

    static ScheduledThreadPoolExecutor i()
    {
        return e;
    }

    private static void j()
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
                if (jg.a() != c.b)
                {
                    jg.a(d.b);
                }
            }

        };
        e.scheduleAtFixedRate(((Runnable) (obj)), 0L, 15L, TimeUnit.SECONDS);
        obj = new Runnable() {

            public void run()
            {
                Object obj2 = new HashSet();
                Object obj1 = jg.d();
                obj1;
                JVM INSTR monitorenter ;
                for (Iterator iterator1 = jg.e().keySet().iterator(); iterator1.hasNext(); ((Set) (obj2)).add(((a)iterator1.next()).b())) { }
                break MISSING_BLOCK_LABEL_64;
                obj2;
                obj1;
                JVM INSTR monitorexit ;
                throw obj2;
                obj1;
                JVM INSTR monitorexit ;
                for (Iterator iterator = ((Set) (obj2)).iterator(); iterator.hasNext(); kb.a((String)iterator.next(), true)) { }
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

    private static void k()
    {
        synchronized (i)
        {
            if (a() != c.b && l() > 100)
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

    private static int l()
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

    private static int m()
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

    public void a(String s1, double d1, Bundle bundle)
    {
        a(s1, Double.valueOf(d1), bundle, false);
    }

    public void a(String s1, Bundle bundle)
    {
        a(s1, ((Double) (null)), bundle, false);
    }

    public void a(String s1, Double double1, Bundle bundle)
    {
        a(s1, double1, bundle, true);
    }

    static 
    {
        f = c.a;
    }
}
