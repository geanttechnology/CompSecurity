// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.d.a:
//            i, ah, ak, x, 
//            ai, r, l, al, 
//            k, h, n, f, 
//            c, a

final class aj
    implements android.view.View.OnClickListener
{

    private static volatile long A = 0L;
    static String a = "FlurryAgent";
    static String b = "";
    private static volatile String e = "market://";
    private static volatile String f = "market://details?id=";
    private static volatile String g = "https://market.android.com/details?id=";
    private static String h = "com.flurry.android.ACTION_CATALOG";
    private static int i = 5000;
    volatile boolean c;
    String d;
    private String j;
    private String k;
    private String l;
    private long m;
    private long n;
    private long o;
    private long p;
    private i q;
    private boolean r;
    private Map s;
    private Handler t;
    private boolean u;
    private transient Map v;
    private n w;
    private List x;
    private Map y;
    private c z;

    public aj()
    {
        r = true;
        s = new HashMap();
        v = new HashMap();
        x = new ArrayList();
        y = new HashMap();
        q = new i();
    }

    static c a(aj aj1)
    {
        return aj1.z;
    }

    private String a(ah ah1)
    {
        this;
        JVM INSTR monitorenter ;
        ak ak1 = ah1.c;
        ah1 = (new StringBuilder("?apik=")).append(l).append("&cid=").append(ak1.e).append("&adid=").append(ak1.a).append("&pid=").append(d).append("&iid=").append(m).append("&sid=").append(n).append("&lid=").append(ah1.b).append("&aso=").append(((x)ah1.e.get(ah1.e.size() - 1)).b).append("&hid=").append(ai.a(ah1.a)).append("&ac=").append(a(ak1.g));
        if (s != null && !s.isEmpty())
        {
            String s1;
            Object obj;
            for (Iterator iterator = s.entrySet().iterator(); iterator.hasNext(); ah1.append("&").append(s1).append("=").append(((String) (obj))))
            {
                obj = (java.util.Map.Entry)iterator.next();
                s1 = (new StringBuilder("c_")).append(ai.a((String)((java.util.Map.Entry) (obj)).getKey())).toString();
                obj = ai.a((String)((java.util.Map.Entry) (obj)).getValue());
            }

        }
        break MISSING_BLOCK_LABEL_287;
        ah1;
        throw ah1;
        ah1.append("&ats=").append(System.currentTimeMillis());
        ah1 = ah1.toString();
        this;
        JVM INSTR monitorexit ;
        return ah1;
    }

    static String a(aj aj1, String s1)
    {
        return aj1.a(s1);
    }

    private String a(String s1)
    {
        Object obj = s1;
        int i1;
        if (s1.startsWith(e))
        {
            break MISSING_BLOCK_LABEL_160;
        }
        obj = new HttpGet(s1);
        obj = (new DefaultHttpClient()).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        i1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        if (i1 != 200)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        s1 = EntityUtils.toString(((HttpResponse) (obj)).getEntity());
        obj = s1;
        if (!s1.startsWith(e))
        {
            return a(s1);
        }
        break MISSING_BLOCK_LABEL_160;
        b((new StringBuilder("Error when fetching application's android market ID, responseCode ")).append(i1).toString());
        return s1;
        s1;
        (new StringBuilder("Unknown host: ")).append(s1.getMessage());
        if (z != null)
        {
            b((new StringBuilder("Unknown host: ")).append(s1.getMessage()).toString());
        }
        return null;
        s1;
        obj = null;
        return ((String) (obj));
    }

    private static String a(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = 0;
        while (i1 < abyte0.length) 
        {
            int j1 = abyte0[i1] >> 4 & 0xf;
            if (j1 < 10)
            {
                stringbuilder.append((char)(j1 + 48));
            } else
            {
                stringbuilder.append((char)((j1 + 65) - 10));
            }
            j1 = abyte0[i1] & 0xf;
            if (j1 < 10)
            {
                stringbuilder.append((char)(j1 + 48));
            } else
            {
                stringbuilder.append((char)((j1 + 65) - 10));
            }
            i1++;
        }
        return stringbuilder.toString();
    }

    private void a(Context context, ah ah1, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        t.post(new r(this, s1, context, ah1));
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    static void a(aj aj1, Context context, String s1)
    {
        String s2;
        if (!s1.startsWith(f))
        {
            break MISSING_BLOCK_LABEL_49;
        }
        s2 = s1.substring(f.length());
        if (!aj1.r)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        context.startActivity((new Intent("android.intent.action.VIEW")).setData(Uri.parse(s1)));
        return;
        aj1 = (new StringBuilder()).append(g).append(s2).toString();
        context.startActivity((new Intent("android.intent.action.VIEW")).setData(Uri.parse(aj1)));
        return;
        aj1;
    }

    private static void a(Runnable runnable)
    {
        (new Handler()).post(runnable);
    }

    private ah b(ah ah1)
    {
        this;
        JVM INSTR monitorenter ;
        ah ah2 = ah1;
        if (!x.contains(ah1))
        {
            ah2 = new ah(ah1, f());
            x.add(ah2);
        }
        ah2.a(new x((byte)4, f()));
        this;
        JVM INSTR monitorexit ;
        return ah2;
        ah1;
        throw ah1;
    }

    static void b(aj aj1, String s1)
    {
        aj1.b(s1);
    }

    private void b(String s1)
    {
        a(new l(this, s1));
    }

    private boolean g()
    {
        boolean flag = c;
        return c;
    }

    final a a(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag) goto _L2; else goto _L1
_L1:
        a a1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return a1;
_L2:
        a1 = q.a(l1);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final List a(Context context, List list, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (g()) goto _L2; else goto _L1
_L1:
        context = Collections.emptyList();
_L13:
        this;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (!q.e || list == null) goto _L4; else goto _L3
_L3:
        if (list == null) goto _L6; else goto _L5
_L5:
        if (!list.isEmpty() && q.e) goto _L7; else goto _L6
_L6:
        Object obj = Collections.emptyList();
_L10:
        ArrayList arraylist;
        int k1;
        k1 = Math.min(list.size(), ((List) (obj)).size());
        arraylist = new ArrayList();
        int j1 = 0;
_L11:
        if (j1 >= k1) goto _L9; else goto _L8
_L8:
        Object obj1;
        obj1 = (String)list.get(j1);
        obj1 = q.b(((String) (obj1)));
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ah ah1 = new ah((String)list.get(j1), (byte)1, f());
        if (x.size() < 32767)
        {
            x.add(ah1);
            v.put(Long.valueOf(ah1.a()), ah1);
        }
        if (j1 < ((List) (obj)).size())
        {
            ah1.c = (ak)((List) (obj)).get(j1);
            ah1.a(new x((byte)2, f()));
            arraylist.add(new al(context, this, ah1, ((w) (obj1)), i1));
        }
        continue; /* Loop/switch isn't completed */
_L7:
        obj = q.a((String)list.get(0));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_346;
        }
        if (obj.length <= 0)
        {
            break MISSING_BLOCK_LABEL_346;
        }
        obj = new ArrayList(Arrays.asList(((Object []) (obj))));
        Collections.shuffle(((List) (obj)));
        obj = ((List) (obj)).subList(0, Math.min(((List) (obj)).size(), list.size()));
          goto _L10
        obj = Collections.emptyList();
          goto _L10
_L4:
        context = Collections.emptyList();
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
          goto _L11
_L9:
        context = arraylist;
        if (true) goto _L13; else goto _L12
_L12:
    }

    final void a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        q.b();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (z != null)
        {
            a(((Runnable) (new k(this, i1))));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
        n = l1;
        o = l2;
        p = 0L;
        x.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(Context context, h h1)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (c)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        j = h1.c;
        k = h1.d;
        l = h1.a;
        m = h1.b;
        t = h1.e;
        w = new n(t, i);
        context.getResources().getDisplayMetrics();
        y.clear();
        v.clear();
        obj = q;
        obj.a = context;
        obj.b = this;
        obj.c = h1;
        s.clear();
        h1 = context.getPackageManager();
        context = context.getPackageName();
        context = (new StringBuilder()).append(f).append(context).toString();
        obj = new Intent("android.intent.action.VIEW");
        ((Intent) (obj)).setData(Uri.parse(context));
        if (h1.queryIntentActivities(((Intent) (obj)), 0x10000).size() <= 0)
        {
            flag = false;
        }
        r = flag;
        c = true;
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    final void a(Map map, Map map1, Map map2, Map map3, Map map4, Map map5)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        q.a(map, map1, map2, map3, map4, map5);
        q.toString();
        if (true) goto _L1; else goto _L3
_L3:
        map;
        throw map;
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        q.c();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final long c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag) goto _L2; else goto _L1
_L1:
        long l1 = 0L;
_L4:
        this;
        JVM INSTR monitorexit ;
        return l1;
_L2:
        l1 = q.d;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final Set d()
    {
        this;
        JVM INSTR monitorenter ;
        if (g()) goto _L2; else goto _L1
_L1:
        Set set = Collections.emptySet();
_L4:
        this;
        JVM INSTR monitorexit ;
        return set;
_L2:
        set = q.a();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final List e()
    {
        this;
        JVM INSTR monitorenter ;
        List list = x;
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    final long f()
    {
        this;
        JVM INSTR monitorenter ;
        long l1;
        l1 = SystemClock.elapsedRealtime() - o;
        if (l1 <= p)
        {
            break MISSING_BLOCK_LABEL_34;
        }
_L1:
        p = l1;
        l1 = p;
        this;
        JVM INSTR monitorexit ;
        return l1;
        l1 = p + 1L;
        p = l1;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public final void onClick(View view)
    {
        this;
        JVM INSTR monitorenter ;
        ah ah1;
        String s1;
        al al1 = (al)view;
        ah1 = b(al1.a);
        al1.a = ah1;
        s1 = a(ah1);
        if (!u) goto _L2; else goto _L1
_L1:
        Context context;
        context = view.getContext();
        s1 = (new StringBuilder()).append(j).append(s1).toString();
        if (f.c == null) goto _L4; else goto _L3
_L3:
        view = f.c;
_L5:
        view = new Intent(view);
        view.addCategory("android.intent.category.DEFAULT");
        view.putExtra("u", s1);
        if (ah1 == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        view.putExtra("o", ah1.a());
        context.startActivity(view);
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        view = h;
          goto _L5
_L2:
        a(view.getContext(), ah1, (new StringBuilder()).append(k).append(s1).toString());
          goto _L6
        view;
        throw view;
          goto _L5
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[adLogs=").append(x).append("]");
        return stringbuilder.toString();
    }

    static 
    {
        new Random(System.currentTimeMillis());
    }
}
