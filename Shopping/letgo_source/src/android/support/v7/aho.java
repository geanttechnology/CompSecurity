// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.support.v7:
//            ahk, ahr, ahp, ahn, 
//            ahq, ahm, ahl

public class aho
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(android/support/v7/aho$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("USER", 0);
            b = new a("INSTALL", 1);
            c = new a("PURCHASE", 2);
            d = new a("VISIT", 3);
            e = new a("VIRAL", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int l)
        {
            super(s, l);
        }
    }


    protected static String a = "https://api.nanigans.com";
    private static aho b = new aho();
    private volatile String c;
    private volatile String d;
    private volatile Integer e;
    private volatile WeakReference f;
    private volatile ScheduledExecutorService g;
    private volatile ExecutorService h;
    private List i;
    private final Pattern j = Pattern.compile(".*?(?:^|&|\\?)nan_pid=(\\d+)($|&.*)");
    private final SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd");

    private aho()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = new CopyOnWriteArrayList();
    }

    public static aho a()
    {
        return b;
    }

    static Integer a(aho aho1)
    {
        return aho1.e;
    }

    static List b(aho aho1)
    {
        return aho1.i;
    }

    protected static boolean b(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    static WeakReference c(aho aho1)
    {
        return aho1.f;
    }

    static String d(aho aho1)
    {
        return aho1.c;
    }

    static String e(aho aho1)
    {
        return aho1.d;
    }

    public void a(Context context, String s, Integer integer)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        c = s;
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        e = integer;
        if (context != null) goto _L2; else goto _L1
_L1:
        ahk.a().a("NULL Context passed to initialize!", null);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (context instanceof Activity)
        {
            ahk.a().b("Context passed to initialize is not Application context!", null);
        }
        f = new WeakReference(context);
        if (h == null)
        {
            h = Executors.newCachedThreadPool();
        }
        if (g == null)
        {
            ahr.a().a(context);
            g = Executors.newSingleThreadScheduledExecutor();
            g.scheduleWithFixedDelay(new Runnable() {

                final aho a;

                public void run()
                {
                    Object obj13;
                    Context context1;
                    int l;
                    obj13 = null;
                    l = 0;
                    context1 = a.d();
                    if (context1 != null) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    Object obj = null;
_L9:
                    Object obj1;
                    Exception exception;
                    ahm ahm1;
                    try
                    {
                        ahm1 = ahn.a(context1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ahk.a().a("Error processing events from DB", ((Throwable) (obj)));
                        return;
                    }
                    if (ahm1 == null) goto _L1; else goto _L3
_L3:
                    if (aho.a(a) == null || aho.a(a).intValue() != 1)
                    {
                        break MISSING_BLOCK_LABEL_159;
                    }
                    ahk.a().b("Not actually sending events from sample appId: 1", null);
                    obj = aho.b(a).iterator();
_L4:
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break MISSING_BLOCK_LABEL_141;
                    }
                    obj1 = (ahq)((Iterator) (obj)).next();
                    ((ahq) (obj1)).a(ahm1.a());
                      goto _L4
                    exception;
                    Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on success", exception);
                      goto _L4
                    ahn.a(context1, Arrays.asList(new ahm[] {
                        ahm1
                    }));
                    return;
                    if (!a.f()) goto _L6; else goto _L5
_L5:
                    boolean flag = ahr.a().a(ahm1);
                    if (!flag) goto _L7; else goto _L6
_L6:
                    ahn.a(context1, Arrays.asList(new ahm[] {
                        ahm1
                    }));
_L16:
                    exception = aho.b(a).iterator();
_L10:
                    if (!exception.hasNext()) goto _L9; else goto _L8
_L8:
                    Object obj2 = (ahq)exception.next();
                    ((ahq) (obj2)).b(ahm1.a());
                      goto _L10
                    Exception exception1;
                    exception1;
                    Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on success", exception1);
                      goto _L10
                    exception;
                    ahk.a().a("Error determining is tracking is disabled", exception);
_L7:
                    exception = (HttpURLConnection)(new URL(ahm1.a())).openConnection();
                    int i1;
                    int j1;
                    int k1;
                    i1 = l;
                    j1 = l;
                    k1 = l;
                    exception.setUseCaches(false);
                    i1 = l;
                    j1 = l;
                    k1 = l;
                    exception.setConnectTimeout(30000);
                    i1 = l;
                    j1 = l;
                    k1 = l;
                    exception.setReadTimeout(30000);
                    i1 = l;
                    j1 = l;
                    k1 = l;
                    exception.setRequestProperty("Connection", "Keep-Alive");
                    i1 = l;
                    j1 = l;
                    k1 = l;
                    exception.connect();
                    i1 = l;
                    j1 = l;
                    k1 = l;
                    l = exception.getResponseCode();
                    i1 = l;
                    j1 = l;
                    k1 = l;
                    exception1 = exception.getInputStream();
                    Object obj3 = new ByteArrayOutputStream();
                    Object obj4;
                    Object obj5;
                    Object obj9;
                    Object obj10;
                    Object obj11;
                    Object obj12;
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    byte abyte0[] = new byte[1024];
_L12:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    if (exception1.read(abyte0) == -1)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    ((ByteArrayOutputStream) (obj3)).write(abyte0);
                    if (true) goto _L12; else goto _L11
                    obj5;
                    obj4 = obj11;
                    obj = obj3;
                    obj3 = exception1;
                    exception1 = ((Exception) (obj5));
_L43:
                    ahk.a().b((new StringBuilder()).append("UnknownHostException sending: ").append(ahm1.a()).toString(), exception1);
                    exception1 = aho.b(a).iterator();
_L15:
                    if (!exception1.hasNext()) goto _L14; else goto _L13
_L13:
                    obj5 = (ahq)exception1.next();
                    ((ahq) (obj5)).a(ahm1.a(), l, ((String) (obj4)));
                      goto _L15
                    obj5;
                    Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on error", ((Throwable) (obj5)));
                      goto _L15
                    obj4;
                    exception1 = ((Exception) (obj3));
                    obj3 = exception;
                    exception = ((Exception) (obj));
                    obj = obj4;
_L22:
                    if (obj3 == null)
                    {
                        break MISSING_BLOCK_LABEL_649;
                    }
                    ((HttpURLConnection) (obj3)).disconnect();
                    if (exception1 == null)
                    {
                        break MISSING_BLOCK_LABEL_657;
                    }
                    exception1.close();
                    if (exception == null)
                    {
                        break MISSING_BLOCK_LABEL_665;
                    }
                    exception.close();
                    throw obj;
                    exception;
                    ahk.a().a((new StringBuilder()).append("Error deleting: ").append(ahm1.a()).toString(), exception);
                      goto _L16
_L11:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    obj = ((ByteArrayOutputStream) (obj3)).toString("UTF-8");
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    if (!ahk.a().a) goto _L18; else goto _L17
_L17:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    Log.i(android/support/v7/aho.getSimpleName(), (new StringBuilder()).append("TRACK EVENT REQUEST ").append(ahm1.a()).append(",RESPONSE: ").append(((String) (obj))).toString());
                      goto _L18
_L47:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    throw new RuntimeException((new StringBuilder()).append("Non-200 response: ").append(l).toString());
                    obj4;
                    obj = obj3;
                    obj3 = obj4;
_L42:
                    obj9 = exception;
                    obj5 = obj;
                    obj4 = exception1;
                    ahk.a().b((new StringBuilder()).append("Socket/Connect timeout sending: ").append(ahm1.a()).toString(), ((Throwable) (obj3)));
                    obj9 = exception;
                    obj5 = obj;
                    obj4 = exception1;
                    obj3 = aho.b(a).iterator();
_L21:
                    obj9 = exception;
                    obj5 = obj;
                    obj4 = exception1;
                    if (!((Iterator) (obj3)).hasNext()) goto _L20; else goto _L19
_L19:
                    obj9 = exception;
                    obj5 = obj;
                    obj4 = exception1;
                    obj11 = (ahq)((Iterator) (obj3)).next();
                    obj9 = exception;
                    obj5 = obj;
                    obj4 = exception1;
                    ((ahq) (obj11)).a(ahm1.a(), l, ((String) (obj10)));
                      goto _L21
                    obj11;
                    obj9 = exception;
                    obj5 = obj;
                    obj4 = exception1;
                    Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on error", ((Throwable) (obj11)));
                      goto _L21
                    obj;
                    obj3 = obj9;
                    exception = ((Exception) (obj5));
                    exception1 = ((Exception) (obj4));
                      goto _L22
_L45:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    ahn.a(context1, Arrays.asList(new ahm[] {
                        ahm1
                    }));
_L31:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    Iterator iterator = aho.b(a).iterator();
_L25:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    if (!iterator.hasNext()) goto _L24; else goto _L23
_L23:
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    ahq ahq1 = (ahq)iterator.next();
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    ahq1.a(ahm1.a());
                      goto _L25
                    Exception exception3;
                    exception3;
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj5 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on success", exception3);
                      goto _L25
                    Object obj6;
                    obj6;
                    obj = obj12;
                    obj4 = exception;
                    exception = ((Exception) (obj3));
                    obj3 = obj4;
                    obj4 = obj6;
_L41:
                    ahk.a().b((new StringBuilder()).append("Error sending: ").append(ahm1.a()).append(" ").append(obj4.getClass()).append(",").append(((Throwable) (obj4)).getMessage()).toString(), ((Throwable) (obj4)));
                    i1 = ahm1.b;
                    if (i1 < 3) goto _L27; else goto _L26
_L26:
                    ahk.a().b((new StringBuilder()).append(ahm1).append(" failed after 3 attempts so deleting").toString(), null);
                    ahn.a(context1, Arrays.asList(new ahm[] {
                        ahm1
                    }));
_L37:
                    obj4 = aho.b(a).iterator();
_L30:
                    if (!((Iterator) (obj4)).hasNext()) goto _L29; else goto _L28
_L28:
                    obj6 = (ahq)((Iterator) (obj4)).next();
                    ((ahq) (obj6)).a(ahm1.a(), l, ((String) (obj)));
                      goto _L30
                    obj6;
                    Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on error", ((Throwable) (obj6)));
                      goto _L30
                    obj;
                      goto _L22
                    Exception exception2;
                    exception2;
                    obj11 = obj;
                    obj10 = obj;
                    obj9 = exception;
                    obj6 = obj3;
                    obj4 = exception1;
                    obj12 = obj;
                    ahk.a().a((new StringBuilder()).append("Error deleting: ").append(ahm1.a()).toString(), exception2);
                      goto _L31
_L24:
                    if (exception == null)
                    {
                        break MISSING_BLOCK_LABEL_1519;
                    }
                    exception.disconnect();
                    if (exception1 == null) goto _L33; else goto _L32
_L32:
                    exception1.close();
_L33:
                    if (obj3 == null) goto _L9; else goto _L34
_L34:
                    ((ByteArrayOutputStream) (obj3)).close();
                      goto _L9
_L14:
                    if (exception == null)
                    {
                        break MISSING_BLOCK_LABEL_1548;
                    }
                    exception.disconnect();
                    if (obj3 == null)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    ((InputStream) (obj3)).close();
                    if (obj == null) goto _L1; else goto _L35
_L35:
                    ((ByteArrayOutputStream) (obj)).close();
                    return;
_L20:
                    if (exception == null)
                    {
                        break MISSING_BLOCK_LABEL_1575;
                    }
                    exception.disconnect();
                    if (exception1 == null)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    exception1.close();
                    if (obj == null) goto _L1; else goto _L36
_L36:
                    ((ByteArrayOutputStream) (obj)).close();
                    return;
                    obj4;
                    ahk.a().a((new StringBuilder()).append("Error deleting: ").append(ahm1.a()).toString(), ((Throwable) (obj4)));
                      goto _L37
_L27:
                    ahn.b(context1, Arrays.asList(new ahm[] {
                        ahm1
                    }));
                      goto _L37
                    obj4;
                    ahk.a().b("Error incrementing attempt count", ((Throwable) (obj4)));
                      goto _L37
_L29:
                    if (obj3 == null)
                    {
                        break MISSING_BLOCK_LABEL_1675;
                    }
                    ((HttpURLConnection) (obj3)).disconnect();
                    if (exception1 == null) goto _L39; else goto _L38
_L38:
                    exception1.close();
_L39:
                    if (exception == null) goto _L9; else goto _L40
_L40:
                    exception.close();
                      goto _L9
                    obj;
                    exception = null;
                    exception1 = null;
                    obj3 = null;
                      goto _L22
                    obj;
                    obj4 = null;
                    exception1 = null;
                    obj3 = exception;
                    exception = ((Exception) (obj4));
                      goto _L22
                    obj;
                    obj4 = null;
                    obj3 = exception;
                    exception = ((Exception) (obj4));
                      goto _L22
                    obj4;
                    exception = null;
                    exception1 = null;
                    obj3 = null;
                      goto _L41
                    obj4;
                    Object obj7 = null;
                    exception1 = null;
                    l = i1;
                    obj3 = exception;
                    exception = obj7;
                      goto _L41
                    obj4;
                    Object obj8 = null;
                    obj3 = exception;
                    exception = obj8;
                      goto _L41
                    obj3;
                    obj4 = null;
                    exception1 = null;
                    exception = null;
                    obj10 = obj;
                    obj = obj4;
                      goto _L42
                    obj3;
                    obj4 = null;
                    exception1 = null;
                    obj10 = obj;
                    l = j1;
                    obj = obj4;
                      goto _L42
                    obj3;
                    obj4 = null;
                    obj10 = obj;
                    obj = obj4;
                      goto _L42
                    exception1;
                    exception = null;
                    obj4 = obj;
                    obj3 = null;
                    obj = exception;
                    exception = ((Exception) (obj3));
                    obj3 = obj13;
                      goto _L43
                    exception1;
                    l = k1;
                    obj4 = obj;
                    obj = null;
                    obj3 = obj13;
                      goto _L43
                    obj8;
                    obj4 = obj;
                    obj = null;
                    obj3 = exception1;
                    exception1 = obj8;
                      goto _L43
_L18:
                    l;
                    JVM INSTR tableswitch 200 200: default 1912
                //                               200 1047;
                       goto _L44 _L45
_L44:
                    if (true) goto _L47; else goto _L46
_L46:
                      goto _L9
                }

            
            {
                a = aho.this;
                super();
            }
            }, 1L, 1L, TimeUnit.SECONDS);
        }
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public transient void a(a a1, String s, ahp aahp[])
    {
        if (h == null)
        {
            ahk.a().a("TRACK_THREAD_POOL is null, did you call onApplicationCreate?", null);
            return;
        }
        try
        {
            h.submit(new Runnable(a1, aahp, s) {

                final a a;
                final ahp b[];
                final String c;
                final aho d;

                public void run()
                {
                    Object obj1;
                    if (aho.c(d) == null)
                    {
                        break MISSING_BLOCK_LABEL_51;
                    }
                    obj1 = (Context)aho.c(d).get();
                    if (obj1 == null)
                    {
                        break MISSING_BLOCK_LABEL_51;
                    }
                    if (!aho.b(aho.d(d)) || aho.a(d) != null)
                    {
                        break MISSING_BLOCK_LABEL_61;
                    }
                    ahk.a().a("Need to call initialize via onApplicationCreate prior to tracking events", null);
                    return;
                    if (a == null)
                    {
                        ahk.a().a("type required", null);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_89;
                    ahl.a a2;
                    a2;
                    ahk.a().b("Tracking disabled within Google Play", null);
                    return;
                    Object obj2;
                    Object obj3;
                    String s1;
                    String s2;
                    obj2 = ahl.a(((Context) (obj1)));
                    obj3 = ahl.b(((Context) (obj1)));
                    s1 = ahl.c(((Context) (obj1)));
                    s2 = ahl.e(((Context) (obj1)));
                    Object obj;
                    Throwable throwable1;
                    LinkedList linkedlist;
                    String s3;
                    ahp aahp1[];
                    ahp ahp1;
                    int l;
                    int i1;
                    boolean flag;
                    boolean flag1;
                    boolean flag2;
                    boolean flag3;
                    boolean flag4;
                    try
                    {
                        obj = Calendar.getInstance().getTimeZone().getDisplayName(false, 0);
                    }
                    catch (Exception exception)
                    {
                        exception = null;
                    }
                    s3 = ahl.d(((Context) (obj1)));
                    linkedlist = new LinkedList();
                    flag3 = false;
                    flag = false;
                    flag2 = false;
                    flag1 = false;
                    if (b == null) goto _L2; else goto _L1
_L1:
                    aahp1 = b;
                    i1 = aahp1.length;
                    l = 0;
_L20:
                    flag2 = flag1;
                    flag3 = flag;
                    if (l >= i1) goto _L2; else goto _L3
_L3:
                    ahp1 = aahp1[l];
                    flag3 = flag1;
                    flag4 = flag;
                    if (ahp1 == null) goto _L5; else goto _L4
_L4:
                    flag3 = flag1;
                    flag4 = flag;
                    if (ahp1.a == null) goto _L5; else goto _L6
_L6:
                    if (ahp1.b != null) goto _L8; else goto _L7
_L7:
                    flag3 = flag1;
                    flag4 = flag;
                      goto _L5
_L8:
                    linkedlist.add(ahp1);
                    flag2 = flag;
                    if (flag)
                    {
                        break MISSING_BLOCK_LABEL_273;
                    }
                    flag2 = ahp1.a.equals("unique");
                    flag3 = flag1;
                    flag4 = flag2;
                    if (flag1) goto _L5; else goto _L9
_L9:
                    flag3 = ahp1.a.equals("e_ts");
                    flag4 = flag2;
                      goto _L5
_L2:
                    if (flag3)
                    {
                        break MISSING_BLOCK_LABEL_347;
                    }
                    linkedlist.add(new ahp("unique", new Object[] {
                        UUID.randomUUID().toString().replaceAll("-", "")
                    }));
                    if (obj2 == null)
                    {
                        break MISSING_BLOCK_LABEL_376;
                    }
                    linkedlist.add(new ahp("nan_aid", new Object[] {
                        obj2
                    }));
                    if (obj3 == null)
                    {
                        break MISSING_BLOCK_LABEL_407;
                    }
                    linkedlist.add(new ahp("nan_did", new Object[] {
                        obj3
                    }));
                    if (s1 == null)
                    {
                        break MISSING_BLOCK_LABEL_438;
                    }
                    linkedlist.add(new ahp("nan_advert", new Object[] {
                        s1
                    }));
                    if (s3 == null)
                    {
                        break MISSING_BLOCK_LABEL_469;
                    }
                    linkedlist.add(new ahp("fb_attr_id", new Object[] {
                        s3
                    }));
                    linkedlist.add(new ahp("nan_hash", new Object[] {
                        s2
                    }));
                    if (obj == null)
                    {
                        break MISSING_BLOCK_LABEL_524;
                    }
                    linkedlist.add(new ahp("nan_tz", new Object[] {
                        obj
                    }));
                    linkedlist.add(new ahp("nan_os", new Object[] {
                        Integer.toString(android.os.Build.VERSION.SDK_INT)
                    }));
                    linkedlist.add(new ahp("nan_dt", new Object[] {
                        "and"
                    }));
                    linkedlist.add(new ahp("type", new Object[] {
                        a.name().toLowerCase()
                    }));
                    linkedlist.add(new ahp("fb_app_id", new Object[] {
                        aho.d(d)
                    }));
                    if (aho.e(d) != null)
                    {
                        linkedlist.add(new ahp("user_id", new Object[] {
                            aho.e(d)
                        }));
                    }
                    if (aho.a(d) != null)
                    {
                        linkedlist.add(new ahp("app_id", new Object[] {
                            aho.a(d)
                        }));
                    }
                    linkedlist.add(new ahp("name", new Object[] {
                        c
                    }));
                    linkedlist.add(new ahp("avers", new Object[] {
                        Double.toString(2.1000000000000001D)
                    }));
                    if (flag2)
                    {
                        break MISSING_BLOCK_LABEL_824;
                    }
                    linkedlist.add(new ahp("e_ts", new Object[] {
                        Long.toString(System.currentTimeMillis() / 1000L)
                    }));
                    if (ahk.a().a)
                    {
                        linkedlist.add(new ahp("test", new Object[] {
                            "1"
                        }));
                    }
                    obj = new StringBuilder((new StringBuilder()).append(aho.a).append("/mobile.php?").toString());
                    l = 1;
                    obj2 = linkedlist.iterator();
_L13:
                    if (!((Iterator) (obj2)).hasNext()) goto _L11; else goto _L10
_L10:
                    obj3 = (ahp)((Iterator) (obj2)).next();
                    if (obj3 == null) goto _L13; else goto _L12
_L12:
                    if (((ahp) (obj3)).a == null || ((ahp) (obj3)).b == null || ((ahp) (obj3)).b.length == 0) goto _L13; else goto _L14
_L14:
                    if (l == 0)
                    {
                        break MISSING_BLOCK_LABEL_1005;
                    }
                    l = 0;
_L15:
                    if (((ahp) (obj3)).b.length != 1)
                    {
                        break MISSING_BLOCK_LABEL_1344;
                    }
                    ((StringBuilder) (obj)).append(((ahp) (obj3)).a).append("=").append(URLEncoder.encode(((ahp) (obj3)).b[0].toString(), "UTF-8"));
                      goto _L13
                    ((StringBuilder) (obj)).append("&");
                      goto _L15
_L17:
                    if (i1 >= ((ahp) (obj3)).b.length) goto _L13; else goto _L16
_L16:
                    if (i1 == 0)
                    {
                        break MISSING_BLOCK_LABEL_1040;
                    }
                    ((StringBuilder) (obj)).append("&");
                    ((StringBuilder) (obj)).append(((ahp) (obj3)).a).append("[").append(i1).append("]=").append(URLEncoder.encode(((ahp) (obj3)).b[i1].toString(), "UTF-8"));
                    i1++;
                      goto _L17
_L11:
                    obj = new ahm(a, c, ((StringBuilder) (obj)).toString());
                    android.content.SharedPreferences.Editor editor = ((Context) (obj1)).getSharedPreferences("nanTrackingPrefs", 0).edit();
                    editor.putLong("last_event", System.currentTimeMillis());
                    editor.commit();
_L19:
                    if (!ahr.a().a(((ahm) (obj))))
                    {
                        ahn.a(((Context) (obj1)), ((ahm) (obj)));
                        return;
                    }
                    break MISSING_BLOCK_LABEL_1317;
                    throwable1;
                    obj = (new StringBuilder()).append("Error registering event! type: ").append(a).append(", name:").append(c).toString();
                    obj1 = obj;
                    if (b != null)
                    {
                        l = 0;
                        do
                        {
                            obj1 = obj;
                            if (l >= b.length)
                            {
                                break;
                            }
                            obj1 = (new StringBuilder()).append(((String) (obj)));
                            if (l == 0)
                            {
                                obj = "";
                            } else
                            {
                                obj = ",";
                            }
                            obj = ((StringBuilder) (obj1)).append(((String) (obj))).append(b[l]).toString();
                            l++;
                        } while (true);
                    }
                    break; /* Loop/switch isn't completed */
                    throwable1;
                    if (ahk.a().a)
                    {
                        Log.e(android/support/v7/aho.getSimpleName(), "Error storing last track event time", throwable1);
                    }
                    if (true) goto _L19; else goto _L18
_L18:
                    ahk.a().a(((String) (obj1)), throwable1);
                    return;
_L5:
                    l++;
                    flag1 = flag3;
                    flag = flag4;
                      goto _L20
                    i1 = 0;
                      goto _L17
                }

            
            {
                d = aho.this;
                a = a1;
                b = aahp;
                c = s;
                super();
            }
            });
            return;
        }
        catch (Throwable throwable)
        {
            ahk.a().a((new StringBuilder()).append("Error adding event to thread pool, type: ").append(a1).append(", name: ").append(s).append(", params: ").append(Arrays.toString(aahp)).toString(), throwable);
        }
        return;
    }

    public void a(String s)
    {
        d = s;
    }

    public transient void a(String s, ahp aahp[])
    {
        a a1;
        boolean flag;
        boolean flag1;
        flag = true;
        a1 = null;
        flag1 = false;
        if (b(s)) goto _L2; else goto _L1
_L1:
        Object obj = j.matcher(s.trim());
        if (!((Matcher) (obj)).matches()) goto _L2; else goto _L3
_L3:
        Long long1 = Long.valueOf(Long.parseLong(((Matcher) (obj)).group(1)));
_L16:
        obj = d();
        if (obj == null) goto _L5; else goto _L4
_L4:
        SharedPreferences sharedpreferences;
        sharedpreferences = ((Context) (obj)).getSharedPreferences("nanTrackingPrefs", 0);
        obj = Long.valueOf(sharedpreferences.getLong("last_event", -1L));
        if (((Long) (obj)).longValue() == -1L)
        {
            ahp aahp1[];
            if (sharedpreferences.getString("nan_hash", null) == null)
            {
                flag = false;
            }
            break MISSING_BLOCK_LABEL_388;
        }
          goto _L6
_L15:
        if (obj != null || flag) goto _L8; else goto _L7
_L7:
        a1 = a.b;
        obj = "main";
_L14:
        if (a1 == null) goto _L10; else goto _L9
_L8:
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        a1 = a.d;
        obj = "click";
        continue; /* Loop/switch isn't completed */
        if (obj == null) goto _L12; else goto _L11
_L11:
        if (k.format(new Date()).equals(k.format(new Date(((Long) (obj)).longValue())))) goto _L12; else goto _L13
_L13:
        a1 = a.d;
        obj = "dau";
        continue; /* Loop/switch isn't completed */
_L9:
        if (long1 == null)
        {
            try
            {
                a(a1, ((String) (obj)), (ahp[])aahp);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ahp aahp[])
            {
                ahk.a().a((new StringBuilder()).append("Error on app lauch, deep link: ").append(s).toString(), aahp);
            }
            return;
        }
        if (aahp == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        if (aahp.length != 0)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        a(a1, ((String) (obj)), new ahp[] {
            new ahp("nan_pid", new Object[] {
                long1
            })
        });
        return;
        aahp1 = new ahp[aahp.length + 1];
        System.arraycopy(aahp, 0, aahp1, 0, aahp.length);
        aahp1[aahp1.length - 1] = new ahp("nan_pid", new Object[] {
            long1
        });
        a(a1, ((String) (obj)), (ahp[])aahp1);
        return;
_L10:
        ahk.a().b("Track launch suppressed due to missing nan_pid or last event within 24 hours", null);
        return;
_L12:
        obj = null;
        if (true) goto _L14; else goto _L6
_L6:
        flag = flag1;
          goto _L15
_L5:
        obj = null;
        flag = flag1;
          goto _L15
_L2:
        long1 = null;
          goto _L16
        obj = null;
          goto _L15
    }

    public transient void a(ahp aahp[])
    {
        a((String)null, new ahp[0]);
    }

    protected String b()
    {
        return c;
    }

    protected Integer c()
    {
        return e;
    }

    protected Context d()
    {
        if (f == null)
        {
            return null;
        } else
        {
            return (Context)f.get();
        }
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        ahr.a().b();
        if (ahk.a().a)
        {
            Log.i(android/support/v7/aho.getSimpleName(), "Shutting down");
        }
        if (g != null)
        {
            g.shutdownNow();
            g = null;
        }
        if (h != null)
        {
            h.shutdownNow();
            h = null;
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        if (ahk.a().a)
        {
            Log.w(android/support/v7/aho.getSimpleName(), "Error shutting down", ((Throwable) (obj)));
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public boolean f()
    {
        Object obj = d();
        if (obj != null) goto _L2; else goto _L1
_L1:
        ahk.a().a("Called tracking enabled before initialize?!", null);
_L4:
        return true;
_L2:
        boolean flag = ((Context) (obj)).getSharedPreferences("nanTrackingPrefs", 0).getBoolean("do_not_track", false);
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
        Exception exception1;
        exception1;
        ahk.a().a("Error determining if tracking enabled", exception1);
        boolean flag1;
        try
        {
            obj = ((Context) (obj)).getContentResolver().query(Uri.parse("content://com.nanigans.tracking.provider"), new String[] {
                "do_not_track"
            }, null, null, null);
        }
        catch (Exception exception)
        {
            ahk.a().a("Error determining if tracking enabled", exception);
            return true;
        }
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((Cursor) (obj)).moveToFirst())
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = "true".equals(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("value")));
        if (flag1)
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
