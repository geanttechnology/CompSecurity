// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.support.v4.util.LongSparseArray;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.utility.h;
import com.cyberlink.you.utility.r;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.friends:
//            o, n, r, Friend, 
//            m, p, q, UserInfo

public class l
{

    public static final String a = com.cyberlink.you.g.n();
    public static String b = "search";
    public static String c = "searchPeople";
    public static String d;
    public static long e = 0L;
    static LongSparseArray f = new LongSparseArray();
    private static Map g = null;
    private static Object h = new Object();
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static String l;
    private static List p = new ArrayList();
    private Activity m;
    private String n;
    private ExecutorService o;

    public l()
    {
        this(2);
    }

    public l(int i1)
    {
        m = null;
        n = "";
        o = Executors.newFixedThreadPool(i1, new ThreadFactory() {

            final l a;

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("FriendsClient (").append(l.a(a)).append(")").toString());
            }

            
            {
                a = l.this;
                super();
            }
        });
    }

    public l(Activity activity)
    {
        this(2);
        m = activity;
    }

    static Pair a(String s1, List list)
    {
        return b(s1, list);
    }

    static String a(l l1)
    {
        return l1.n;
    }

    public static String a(String s1, String s2)
    {
        Log.d("FriendsClient", (new StringBuilder()).append("findUrlByTableAndField: ").append(s1).append("-").append(s2).toString());
        if (s1 != null && s2 != null) goto _L2; else goto _L1
_L1:
        String s3;
        Log.e("FriendsClient", "findUrlByTableAndField: table or field is null");
        s3 = null;
_L4:
        return s3;
_L2:
        Object obj;
        if (g == null || !g.containsKey(s1))
        {
            break MISSING_BLOCK_LABEL_152;
        }
        obj = (Map)g.get(s1);
        if (obj == null || !((Map) (obj)).containsKey(s2))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)((Map) (obj)).get(s2);
_L5:
        s3 = ((String) (obj));
        if (obj == null)
        {
            return b(s1, s2);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Log.e("FriendsClient", (new StringBuilder()).append("findUrlByTableAndField: unknown field ").append(s2).toString());
_L6:
        obj = null;
          goto _L5
        Log.d("FriendsClient", "findUrlByTableAndField: Need to load command url first.");
          goto _L6
    }

    private List a(long l1, String s1)
    {
        ArrayList arraylist;
        int i1;
        arraylist = new ArrayList();
        s1 = com.cyberlink.you.utility.h.b(s1);
        if (s1 == null)
        {
            return arraylist;
        }
        i1 = 0;
_L2:
        if (i1 >= s1.length())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        Friend friend = com.cyberlink.you.utility.h.a(s1.getJSONObject(i1));
        if (friend != null)
        {
            try
            {
                arraylist.add(friend);
            }
            catch (JSONException jsonexception)
            {
                Log.e("FriendsClient", Log.getStackTraceString(jsonexception));
            }
        }
        break MISSING_BLOCK_LABEL_84;
        return arraylist;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void a(String s1, q q1, boolean flag)
    {
        Object obj = h;
        obj;
        JVM INSTR monitorenter ;
        if (q1 == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        p.add(q1);
        if (!i)
        {
            (new Thread(s1, flag) {

                final String a;
                final boolean b;

                public void run()
                {
                    boolean flag1;
                    Thread.currentThread().setName("loadCommandUrl");
                    flag1 = l.a(com.cyberlink.you.g.a().e(com.cyberlink.you.g.a()), a, b);
                    Object obj1 = l.k();
                    obj1;
                    JVM INSTR monitorenter ;
                    if (!flag1)
                    {
                        break MISSING_BLOCK_LABEL_87;
                    }
                    Log.d("FriendsClient", "init success.");
                    for (Iterator iterator = l.l().iterator(); iterator.hasNext(); ((q)iterator.next()).a()) { }
                    break MISSING_BLOCK_LABEL_130;
                    Exception exception;
                    exception;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw exception;
                    Log.d("FriendsClient", "init fail.");
                    for (Iterator iterator1 = l.l().iterator(); iterator1.hasNext(); ((q)iterator1.next()).b()) { }
                    l.l().clear();
                    l.a(false);
                    obj1;
                    JVM INSTR monitorexit ;
                }

            
            {
                a = s1;
                b = flag;
                super();
            }
            }).start();
        }
        i = true;
        obj;
        JVM INSTR monitorexit ;
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    private static void a(JSONObject jsonobject, String s1, Map map)
    {
        String s2;
        s2 = s1;
        if (!s1.equals(""))
        {
            s2 = (new StringBuilder()).append(s1).append(".").toString();
        }
        s1 = jsonobject.keys();
_L2:
        Object obj;
        if (!s1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)s1.next();
        if (jsonobject.get(((String) (obj))) instanceof JSONObject)
        {
            a((JSONObject)jsonobject.get(((String) (obj))), (new StringBuilder()).append(s2).append(((String) (obj))).toString(), map);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            map.put((new StringBuilder()).append(s2).append(((String) (obj))).toString(), jsonobject.getString(((String) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("FriendsClient", Log.getStackTraceString(((Throwable) (obj))));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static boolean a()
    {
        return j;
    }

    static boolean a(String s1, String s2, boolean flag)
    {
        return b(s1, s2, flag);
    }

    static boolean a(boolean flag)
    {
        i = flag;
        return flag;
    }

    static Activity b(l l1)
    {
        return l1.m;
    }

    private static Pair b(String s1, List list)
    {
        return c(s1, list);
    }

    public static String b(String s1, String s2)
    {
        if (b.equals(s1) && c.equals(s2))
        {
            return d;
        } else
        {
            return null;
        }
    }

    private static boolean b(String s1, String s2, boolean flag)
    {
        flag = true;
        e = com.cyberlink.you.utility.r.b("PreviousDelayTime", Long.valueOf(0L), com.cyberlink.you.g.I()).longValue();
        if (k)
        {
            flag = false;
        } else
        if (!j)
        {
            flag = o();
            boolean flag1;
            if (flag)
            {
                (new Thread() {

                    public void run()
                    {
                        Thread.currentThread().setName("initServerDelayTimeByServerAPI");
                        l.m();
                    }

                }).start();
                flag1 = true;
            } else
            {
                flag = e(s1, s2);
                flag1 = false;
            }
            if (s2 != null && flag1)
            {
                (new Thread(s1, s2) {

                    final String a;
                    final String b;

                    public void run()
                    {
                        Thread.currentThread().setName("loadCommandUrlFromServer");
                        com.cyberlink.you.friends.l.d(a, b);
                    }

            
            {
                a = s1;
                b = s2;
                super();
            }
                }).start();
                return true;
            } else
            {
                return flag;
            }
        }
        return flag;
    }

    public static long c()
    {
        return (new Date()).getTime() + e;
    }

    private static Pair c(String s1, List list)
    {
        Object obj;
        obj = null;
        MediaType mediatype = MediaType.parse("application/x-www-form-urlencoded");
        list = URLEncodedUtils.format(list, "UTF-8");
        list = (new com.squareup.okhttp.Request.Builder()).url(s1).post(RequestBody.create(mediatype, list)).header("User-Agent", c(null)).build();
        long l1;
        l1 = System.currentTimeMillis();
        s();
        Log.d("FriendsClient", "[doOkHttpPost] MyOkHttpClient.exec() called ...");
        list = com.cyberlink.you.friends.o.a().newCall(list).execute();
        Log.d("FriendsClient", (new StringBuilder()).append("[doOkHttpPost] MyOkHttpClient.exec() response code = ").append(list.code()).toString());
        t();
        long l2 = System.currentTimeMillis();
        Log.d("FriendsClient", (new StringBuilder()).append("[doOkHttpPost] MyOkHttpClient.exec() = ").append(s1).append(" ").append(l2 - l1).append(" ms").toString());
_L5:
        if (list == null) goto _L2; else goto _L1
_L1:
        String s2 = String.valueOf(list.code());
        if (!s2.equals("200")) goto _L4; else goto _L3
_L3:
        s1 = list.body().string();
        list = s2;
_L6:
        return Pair.create(list, s1);
        s1;
        list = null;
_L9:
        s1.printStackTrace();
        Log.d("FriendsClient", "[doOkHttpPost] MyOkHttpClient.exec() SocketTimeoutException !! ");
          goto _L5
        s1;
        list = null;
_L8:
        s1.printStackTrace();
        Log.d("FriendsClient", "[doOkHttpPost] MyOkHttpClient.exec() IOException !! ");
          goto _L5
        s1;
        list = null;
_L7:
        s1.printStackTrace();
        Log.d("FriendsClient", "[doOkHttpPost] MyOkHttpClient.exec() SecurityException !! ");
          goto _L5
        s1;
        s1.printStackTrace();
        Log.e("FriendsClient", "[doOkHttpPost] httpResponse.body().string() exception.");
        s1 = obj;
        list = s2;
          goto _L6
_L4:
        s1 = obj;
        list = s2;
        if (s2.equals("502"))
        {
            n();
            s1 = obj;
            list = s2;
        }
          goto _L6
_L2:
        Log.e("FriendsClient", "[doOkHttpPost] httpResponse is null.");
        list = null;
        s1 = obj;
          goto _L6
        s1;
          goto _L7
        s1;
          goto _L8
        s1;
          goto _L9
    }

    private static String c(String s1)
    {
        Object obj = com.cyberlink.you.g.I();
        String s2 = ((Context) (obj)).getPackageName();
        StringBuilder stringbuilder;
        try
        {
            obj = ((Context) (obj)).getPackageManager().getPackageInfo(s2, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new RuntimeException(s1);
        }
        stringbuilder = new StringBuilder();
        stringbuilder.append(s2);
        stringbuilder.append("/");
        stringbuilder.append(((String) (obj)));
        stringbuilder.append(" (");
        stringbuilder.append("U; Android ");
        stringbuilder.append(android.os.Build.VERSION.RELEASE);
        stringbuilder.append("; ");
        stringbuilder.append(Locale.getDefault());
        stringbuilder.append("; ");
        stringbuilder.append(Build.PRODUCT);
        stringbuilder.append(")");
        if (s1 != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(s1);
        }
        return stringbuilder.toString();
    }

    public static void d()
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[resetCommand] is ui thread start");
        }
        synchronized (h)
        {
            if (Looper.getMainLooper().getThread() == Thread.currentThread())
            {
                Log.d("LockTesting", "[resetCommand] is ui thread end");
            }
            i = false;
            j = false;
            com.cyberlink.you.friends.n.a(null);
            com.cyberlink.you.friends.o.a(null);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean d(String s1)
    {
        String s2;
        if (s1 == null || s1.isEmpty())
        {
            Log.d("FriendsClient", "[parseCommandUrl] parse fail. JSONstr = null or empty");
            return false;
        }
        JSONObject jsonobject;
        Iterator iterator;
        JSONObject jsonobject1;
        HashMap hashmap;
        try
        {
            jsonobject = new JSONObject(s1);
        }
        catch (JSONException jsonexception)
        {
            Log.d("FriendsClient", (new StringBuilder()).append("[parseCommandUrl] parse fail. JSONstr = ").append(s1.substring(1, Math.min(50, s1.length()))).toString());
            return false;
        }
        g = new HashMap();
        iterator = jsonobject.keys();
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = (String)iterator.next();
        jsonobject1 = jsonobject.getJSONObject(s2);
        hashmap = new HashMap();
        a(jsonobject1, "", hashmap);
        g.put(s2, hashmap);
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception1;
        jsonexception1;
        Log.d("FriendsClient", (new StringBuilder()).append("[parseCommandUrl] table ").append(s2).append(" parse fail. JSONstr=").append(s1).toString());
        if (true) goto _L2; else goto _L1
_L1:
        return true;
    }

    static boolean d(String s1, String s2)
    {
        return e(s1, s2);
    }

    private static void e(String s1)
    {
        if (s1 == null)
        {
            return;
        } else
        {
            e = Long.parseLong(s1) * 1000L - System.currentTimeMillis();
            com.cyberlink.you.utility.r.a("PreviousDelayTime", Long.valueOf(e), com.cyberlink.you.g.I());
            return;
        }
    }

    public static boolean e()
    {
        String s1 = com.cyberlink.you.g.a().e();
        String s2 = com.cyberlink.you.g.a().f();
        String s3 = com.cyberlink.you.g.a().e(com.cyberlink.you.g.a());
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
        {
            return false;
        } else
        {
            return e(s3, s1);
        }
    }

    private static boolean e(String s1, String s2)
    {
        boolean flag1;
        if (k)
        {
            flag1 = false;
        } else
        {
            s2 = b(a, f(s1, s2));
            s1 = (String)((Pair) (s2)).first;
            s2 = (String)((Pair) (s2)).second;
            boolean flag;
            if (s1 != null)
            {
                if (s1.equals("200"))
                {
                    flag = d(s2);
                    j = flag;
                    com.cyberlink.you.utility.r.a("CommandUrl", s2, com.cyberlink.you.g.I());
                } else
                if (s1.equals("409"))
                {
                    l = s2;
                    k = true;
                    Log.d("FriendsClient", (new StringBuilder()).append("[loadCommandUrl] statusCode = ").append(s1).toString());
                    flag = false;
                } else
                {
                    Log.d("FriendsClient", (new StringBuilder()).append("load command url statuscode =").append(s1).toString());
                    flag = false;
                }
            } else
            {
                Log.d("FriendsClient", (new StringBuilder()).append("load command url statuscode =").append(s1).toString());
                flag = false;
            }
            flag1 = flag;
            if (flag)
            {
                p();
                return flag;
            }
        }
        return flag1;
    }

    public static String f()
    {
        String s2 = a("chat", "xmpp.whenToConnect");
        String s1 = s2;
        if (s2 == null)
        {
            s1 = "afterOpenningMessages";
        }
        return s1;
    }

    private static List f(String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        String s3;
        try
        {
            arraylist.add(new BasicNameValuePair("ap", com.cyberlink.you.g.O()));
            arraylist.add(new BasicNameValuePair("version", com.cyberlink.you.g.o()));
            arraylist.add(new BasicNameValuePair("versionType", "for Android"));
            arraylist.add(new BasicNameValuePair("buildNumber", com.cyberlink.you.g.p()));
            arraylist.add(new BasicNameValuePair("locale", Locale.getDefault().toString()));
            arraylist.add(new BasicNameValuePair("uuid", com.cyberlink.you.utility.r.a(com.cyberlink.you.g.I())));
            if (Build.MODEL != null)
            {
                arraylist.add(new BasicNameValuePair("model", Build.MODEL));
            }
            if (Build.MANUFACTURER != null)
            {
                arraylist.add(new BasicNameValuePair("vender", Build.MANUFACTURER));
            }
            arraylist.add(new BasicNameValuePair("userAgent", com.cyberlink.you.g.a().k()));
            arraylist.add(new BasicNameValuePair("apiVersion", "1.0"));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return arraylist;
        }
        s3 = s1;
        if (s1 == null)
        {
            s3 = "";
        }
        arraylist.add(new BasicNameValuePair("apnsType", "gcm"));
        arraylist.add(new BasicNameValuePair("apnsToken", s3));
        arraylist.add(new BasicNameValuePair("token", s2));
        return arraylist;
    }

    public static void g()
    {
        q();
    }

    public static boolean j()
    {
        return false;
    }

    static Object k()
    {
        return h;
    }

    static List l()
    {
        return p;
    }

    static void m()
    {
        q();
    }

    private static void n()
    {
        Log.e("FriendsClient", "server response 502");
        com.cyberlink.you.utility.r.a("CommandUrl", "", com.cyberlink.you.g.I().getApplicationContext());
        d();
    }

    private static boolean o()
    {
        String s1 = com.cyberlink.you.utility.r.b("CommandUrl", "", com.cyberlink.you.g.I());
        Log.d("FriendsClient", (new StringBuilder()).append("[loadCommandUrlFromPreference] result=").append(s1).toString());
        boolean flag = d(s1);
        j = flag;
        return flag;
    }

    private static void p()
    {
        e(a("info", "timestamp"));
    }

    private static void q()
    {
        Object obj = com.cyberlink.you.g.a().e();
        if (obj == null || ((String) (obj)).isEmpty())
        {
            Log.d("FriendsClient", (new StringBuilder()).append("[initServerDelayTimeByServerAPI]").append(" Fail by cltoken is empty").toString());
            return;
        }
        Object obj1 = new ArrayList();
        ((List) (obj1)).add(new BasicNameValuePair("token", ((String) (obj))));
        obj = (new l()).a("misc", "dateInfo", ((List) (obj1)));
        obj1 = (String)((Pair) (obj)).first;
        if (obj1 == null || !((String) (obj1)).equals("200"))
        {
            Log.d("FriendsClient", (new StringBuilder()).append("[initServerDelayTimeByServerAPI]").append(" Fail by statuscode = ").append(((String) (obj1))).toString());
            return;
        }
        obj = (String)((Pair) (obj)).second;
        try
        {
            e((new JSONObject(((String) (obj)))).getString("timestamp"));
            return;
        }
        catch (JSONException jsonexception)
        {
            Log.d("FriendsClient", (new StringBuilder()).append("[initServerDelayTimeByServerAPI]").append(" Parse error. JSONstr=").append(((String) (obj))).toString());
        }
    }

    private static String r()
    {
        StringWriter stringwriter = new StringWriter();
        (new Throwable()).printStackTrace(new PrintWriter(stringwriter));
        return stringwriter.toString();
    }

    private static void s()
    {
        String s1 = Thread.currentThread().getName();
        if (s1.equals("main"))
        {
            Log.e("FriendsClient", (new StringBuilder()).append("Call from ").append(s1).append(":\n\t").append(r()).toString());
            return;
        }
        if (s1.startsWith("Thread-"))
        {
            Log.d("FriendsClient", (new StringBuilder()).append("Call from ").append(s1).append(":\n\t").append(r()).toString());
            return;
        } else
        {
            Log.i("FriendsClient", (new StringBuilder()).append("Call from ").append(s1).append(" (").append(Thread.currentThread().getThreadGroup().getName()).append(")").toString());
            return;
        }
    }

    private static void t()
    {
    }

    public Pair a(String s1, String s2, List list)
    {
        return a(s1, s2, list, false);
    }

    public Pair a(String s1, String s2, List list, boolean flag)
    {
        if (s1 == null || s2 == null)
        {
            return Pair.create(null, null);
        }
        if (!j)
        {
            String s3 = com.cyberlink.you.g.a().e();
            if (!b(com.cyberlink.you.g.a().e(com.cyberlink.you.g.a()), s3, true))
            {
                com.cyberlink.you.friends.r.a(m, s1, s2, null, null, false);
                return Pair.create(null, null);
            }
        }
        String s4 = a(s1, s2);
        if (s4 == null)
        {
            Log.d("FriendsClient", (new StringBuilder()).append("table=").append(s1).append(" field=").append(s2).append(" command does not exists.").toString());
            return Pair.create(null, null);
        }
        Object obj = b(s4, list);
        s4 = (String)((Pair) (obj)).first;
        obj = (String)((Pair) (obj)).second;
        if (flag)
        {
            com.cyberlink.you.friends.r.a(m, s1, s2, s4, ((String) (obj)), flag);
        } else
        {
            com.cyberlink.you.friends.r.a(m, s1, s2, list, s4, ((String) (obj)));
        }
        return Pair.create(s4, obj);
    }

    public Friend a(String s1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Long.valueOf(s1));
        s1 = a(((List) (arraylist)));
        if (s1.isEmpty())
        {
            return null;
        } else
        {
            return (Friend)s1.get(0);
        }
    }

    public String a(Context context)
    {
        context = com.cyberlink.you.g.a().e();
        String s1 = com.cyberlink.you.g.a().e(com.cyberlink.you.g.a());
        return (String)b(a, f(s1, context)).first;
    }

    public List a(long l1, boolean flag)
    {
        Object obj = null;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
        arraylist.add(new BasicNameValuePair("groupId", String.valueOf(l1)));
        arraylist.add(new BasicNameValuePair("pageIndex", String.valueOf(1)));
        arraylist.add(new BasicNameValuePair("pageSize", String.valueOf(200)));
        Pair pair = a("group", "listGroupMembers", ((List) (arraylist)));
        if (pair != null && pair.first != null && ((String)pair.first).equals("200"))
        {
            List list = a(l1, (String)pair.second);
            int i1 = com.cyberlink.you.utility.d.a((String)pair.second);
            int i2 = com.cyberlink.you.utility.d.b((String)pair.second);
            int k1 = com.cyberlink.you.utility.d.a(i1, 200);
            obj = list;
            if (i1 != -1)
            {
                obj = list;
                if (i2 != -1)
                {
                    obj = list;
                    if (i1 != i2)
                    {
                        int j1 = 2;
                        do
                        {
                            obj = list;
                            if (j1 > k1)
                            {
                                break;
                            }
                            obj = new ArrayList();
                            ((List) (obj)).add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
                            ((List) (obj)).add(new BasicNameValuePair("groupId", String.valueOf(l1)));
                            ((List) (obj)).add(new BasicNameValuePair("pageIndex", String.valueOf(j1)));
                            ((List) (obj)).add(new BasicNameValuePair("pageSize", String.valueOf(200)));
                            obj = a("group", "listGroupMembers", ((List) (obj)));
                            if (obj != null && ((Pair) (obj)).first != null && ((String)((Pair) (obj)).first).equals("200"))
                            {
                                list.addAll(a(l1, (String)((Pair) (obj)).second));
                            }
                            j1++;
                        } while (true);
                    }
                }
            }
        } else
        {
            Log.d("FriendsClient", (new StringBuilder()).append("[queryGroupMemberFromServer] fail : result = ").append(pair).toString());
        }
        if (flag && obj != null)
        {
            Friend friend;
            for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); com.cyberlink.you.e.l().c(Long.valueOf(l1), Long.valueOf(friend.a)))
            {
                friend = (Friend)iterator.next();
            }

        }
        return ((List) (obj));
    }

    public List a(String s1, int i1, int j1)
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(new BasicNameValuePair("keyword", s1));
        ((List) (obj)).add(new BasicNameValuePair("offset", String.valueOf(i1)));
        ((List) (obj)).add(new BasicNameValuePair("limit", String.valueOf(j1)));
        s1 = a(b, c, ((List) (obj)));
        obj = (String)((Pair) (s1)).first;
        if (obj == null || !((String) (obj)).equals("200"))
        {
            Log.d("FriendsClient", (new StringBuilder()).append("statusCode = ").append(((String) (obj))).toString());
            return null;
        } else
        {
            return com.cyberlink.you.utility.h.c(com.cyberlink.you.utility.h.b((String)((Pair) (s1)).second));
        }
    }

    public List a(List list)
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
        if (list != null && !list.isEmpty())
        {
            for (list = list.iterator(); list.hasNext(); ((List) (obj)).add(new BasicNameValuePair("userId", String.valueOf((Long)list.next())))) { }
        }
        list = a("user", "userInfo", ((List) (obj)));
        obj = (String)((Pair) (list)).first;
        if (obj == null || !((String) (obj)).equals("200"))
        {
            Log.d("FriendsClient", (new StringBuilder()).append("statusCode = ").append(((String) (obj))).toString());
            return null;
        } else
        {
            return com.cyberlink.you.utility.h.b(com.cyberlink.you.utility.h.b((String)((Pair) (list)).second));
        }
    }

    public transient List a(String as[])
    {
        Object obj = new l();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
        int k1 = as.length;
        for (int i1 = 0; i1 < k1; i1++)
        {
            arraylist.add(new BasicNameValuePair("jid", as[i1]));
        }

        obj = ((l) (obj)).a("group", "groupInfo", ((List) (arraylist)));
        as = (String)((Pair) (obj)).first;
        if (as == null || !as.equals("200"))
        {
            Log.d("FriendsClient", (new StringBuilder()).append("statusCode = ").append(as).toString());
            return null;
        }
        as = new ArrayList();
        obj = com.cyberlink.you.utility.h.b((String)((Pair) (obj)).second);
        if (obj != null)
        {
            int j1 = 0;
            while (j1 < ((JSONArray) (obj)).length()) 
            {
                try
                {
                    as.add(com.cyberlink.you.utility.h.c(((JSONArray) (obj)).getJSONObject(j1)));
                }
                catch (JSONException jsonexception) { }
                j1++;
            }
        }
        return as;
    }

    public boolean a(String s1, String s2, List list, p p1)
    {
        if (s1 != null && s2 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!j)
        {
            Thread thread = new Thread(new Runnable(s1, s2, list) {

                final String a;
                final String b;
                final List c;
                final l d;

                public void run()
                {
                    String s3 = com.cyberlink.you.g.a().e();
                    if (!l.a(com.cyberlink.you.g.a().e(com.cyberlink.you.g.a()), s3, false))
                    {
                        com.cyberlink.you.friends.r.a(l.b(d), a, b, c, null, null);
                    }
                }

            
            {
                d = l.this;
                a = s1;
                b = s2;
                c = list;
                super();
            }
            });
            thread.start();
            try
            {
                thread.join();
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        if (!j)
        {
            continue; /* Loop/switch isn't completed */
        }
        list = new m(this, s1, s2, list, p1);
        n = (new StringBuilder()).append(s1).append("-").append(s2).toString();
        o.execute(list);
_L4:
        return true;
        s1;
        if (s1.getMessage() != null)
        {
            Log.e("FriendsClient", s1.getMessage());
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (p1 == null) goto _L1; else goto _L5
_L5:
        p1.a(s1, s2, null, null);
        return false;
    }

    public Pair b(String s1, String s2, List list)
    {
        return a(s1, s2, list, false);
    }

    public Group b(String s1)
    {
        Object obj;
        obj = new l();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
        arraylist.add(new BasicNameValuePair("groupId", s1));
        s1 = ((l) (obj)).a("group", "groupInfo", arraylist);
        obj = (String)((Pair) (s1)).first;
        if (obj != null && ((String) (obj)).equals("200")) goto _L2; else goto _L1
_L1:
        Log.d("FriendsClient", (new StringBuilder()).append("statusCode = ").append(((String) (obj))).toString());
        obj = null;
_L4:
        return ((Group) (obj));
_L2:
        JSONArray jsonarray;
        int i1;
        jsonarray = com.cyberlink.you.utility.h.b((String)((Pair) (s1)).second);
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        s1 = null;
        i1 = 0;
_L5:
        obj = s1;
        if (i1 >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        obj = com.cyberlink.you.utility.h.c(jsonarray.getJSONObject(i1));
        s1 = ((String) (obj));
_L6:
        i1++;
          goto _L5
        JSONException jsonexception;
        jsonexception;
          goto _L6
        return null;
          goto _L5
    }

    public void b()
    {
        if (o != null)
        {
            o.shutdown();
        }
        m = null;
    }

    public boolean c(String s1, String s2)
    {
        if (g == null)
        {
            return false;
        }
        Map map = (Map)g.get("chat");
        if (map == null)
        {
            return false;
        } else
        {
            map.put("xmpp.server", s1);
            map.put("xmpp.port", s2);
            return true;
        }
    }

    public UserInfo h()
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(new BasicNameValuePair("token", com.cyberlink.you.g.a().e()));
        obj = a("user", "userInfo", ((List) (obj)));
        String s1 = (String)((Pair) (obj)).first;
        if (s1 == null || !s1.equals("200"))
        {
            Log.d("FriendsClient", (new StringBuilder()).append("statusCode = ").append(s1).toString());
            return null;
        }
        obj = com.cyberlink.you.utility.h.b((String)((Pair) (obj)).second);
        try
        {
            obj = com.cyberlink.you.utility.h.b(((JSONArray) (obj)).getJSONObject(0));
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return ((UserInfo) (obj));
    }

    public long i()
    {
        return e;
    }

}
