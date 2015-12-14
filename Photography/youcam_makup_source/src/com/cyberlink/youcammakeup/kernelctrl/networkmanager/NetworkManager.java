// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.AndroidHttpClient;
import android.os.Environment;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.l.c;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ay;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.az;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ba;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.sku.g;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.pf.common.utility.m;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            c, m, e, u, 
//            n, DownloadingState, a, k, 
//            i, h, l, g, 
//            f, d, RevisionState, j, 
//            o, p, q, r, 
//            s, t

public class NetworkManager
{

    public static final SimpleDateFormat a;
    public static final String b = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/ymk/").toString();
    public static AtomicBoolean c = new AtomicBoolean(false);
    public static String d = "no connection";
    private static final String f = (new StringBuilder()).append(b).append("regid.txt").toString();
    private static final String g = (new StringBuilder()).append(b).append("BaiduID.txt").toString();
    private static final String h = (new StringBuilder()).append(b).append("livefps.config").toString();
    private static String i = "https://app.cyberlink.com";
    private static String j = "https://appadtest.cyberlink.com";
    private static String k = "https://feedback.cyberlink.com";
    private static String l = "http://www.perfectcorp.com";
    private static Map m;
    private static Boolean n = null;
    private static boolean o = true;
    private final ArrayList A = new ArrayList();
    private final ArrayList B = new ArrayList();
    private final ArrayList C = new ArrayList();
    private final ArrayList D = new ArrayList();
    private final ArrayList E = new ArrayList();
    private final ArrayList F = new ArrayList();
    private final ArrayList G = new ArrayList();
    private final ArrayList H = new ArrayList();
    private final ArrayList I = new ArrayList();
    private final HashMap J = new HashMap();
    private final NewBadgeState K = new NewBadgeState(this);
    private final com.cyberlink.youcammakeup.kernelctrl.networkmanager.d L = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.d() {

        final NetworkManager a;

        public void a(Exception exception)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.c(a);
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.c(a);
        }

        public void b(Object obj)
        {
            a((Exception)obj);
        }

        public void b(Void void1)
        {
        }

        public void c(Object obj)
        {
            b((Void)obj);
        }

            
            {
                a = NetworkManager.this;
                super();
            }
    };
    private final com.cyberlink.youcammakeup.kernelctrl.networkmanager.d M = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.d() {

        final NetworkManager a;

        public void a(Exception exception)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.b(a);
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.b(a);
        }

        public void b(Object obj)
        {
            a((Exception)obj);
        }

        public void b(Void void1)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.b(a);
        }

        public void c(Object obj)
        {
            b((Void)obj);
        }

            
            {
                a = NetworkManager.this;
                super();
            }
    };
    private a N;
    private com.cyberlink.youcammakeup.baidupush.a O;
    private az P;
    private String Q;
    private ay R;
    private RevisionState S;
    private Status T;
    private Status U;
    private List V;
    private ConcurrentHashMap W;
    private final ExecutorService X = Executors.newFixedThreadPool(1);
    private final com.cyberlink.youcammakeup.kernelctrl.networkmanager.d Y = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.d() {

        final NetworkManager a;

        public void a(Exception exception)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a);
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a);
        }

        public void b(Object obj)
        {
            a((Exception)obj);
        }

        public void b(Void void1)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a);
        }

        public void c(Object obj)
        {
            b((Void)obj);
        }

            
            {
                a = NetworkManager.this;
                super();
            }
    };
    private Status Z;
    private ArrayList aa;
    Deque e;
    private final ExecutorService p = Executors.newFixedThreadPool(1);
    private final ExecutorService q = Executors.newFixedThreadPool(1);
    private final ExecutorService r = Executors.newFixedThreadPool(1);
    private final AndroidHttpClient s = AndroidHttpClient.newInstance("Android UserAgent");
    private final Deque t = new LinkedBlockingDeque();
    private final Deque u = new LinkedBlockingDeque();
    private final Random v = new Random((new Date()).getTime());
    private final ArrayList w = new ArrayList();
    private final ArrayList x = new ArrayList();
    private final ArrayList y = new ArrayList();
    private final ArrayList z = new ArrayList();

    public NetworkManager(Context context)
    {
        N = null;
        O = null;
        V = new ArrayList();
        aa = new ArrayList();
        T = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.a;
        U = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.a;
        W = new ConcurrentHashMap();
        e = new LinkedBlockingDeque();
        Z = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.a;
        if (Globals.e)
        {
            if (!Globals.d)
            {
                N = new a(context, this, new com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b(context) {

                    final Context a;
                    final NetworkManager b;
                    private int c;

                    public void a(bn bn1)
                    {
                        if (!com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(b, bn1))
                        {
                            return;
                        }
                        if (c <= 0)
                        {
                            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(b, com.cyberlink.youcammakeup.kernelctrl.z.b(a));
                            return;
                        }
                        c = c - 1;
                        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.e(b).addFirst(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.d(b));
                        try
                        {
                            Thread.sleep(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.f(b));
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (bn bn1)
                        {
                            return;
                        }
                    }

                    public volatile void a(Object obj)
                    {
                        a((String)obj);
                    }

                    public void a(String s1)
                    {
                        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(b, s1);
                        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(b, null);
                    }

                    public void a(Void void1)
                    {
                    }

                    public void b(Object obj)
                    {
                        a((bn)obj);
                    }

                    public void c(Object obj)
                    {
                        a((Void)obj);
                    }

            
            {
                b = NetworkManager.this;
                a = context;
                super();
                c = 3;
            }
                });
            } else
            {
                O = new com.cyberlink.youcammakeup.baidupush.a(context, this, new com.cyberlink.youcammakeup.baidupush.b() {

                    final NetworkManager a;

                    public volatile void a(Object obj)
                    {
                        a((Void)obj);
                    }

                    public void a(Void void1)
                    {
                        com.pf.common.utility.m.b("NetworkManager", "mBaiduRegisterTask::complete");
                    }

                    public volatile void b(Object obj)
                    {
                        b((Void)obj);
                    }

                    public void b(Void void1)
                    {
                        com.pf.common.utility.m.b("NetworkManager", "mBaiduRegisterTask::error");
                    }

                    public volatile void c(Object obj)
                    {
                        c((Void)obj);
                    }

                    public void c(Void void1)
                    {
                        com.pf.common.utility.m.b("NetworkManager", "mBaiduRegisterTask::cancel");
                    }

            
            {
                a = NetworkManager.this;
                super();
            }
                });
            }
        }
        N();
        P = new az(context, this, new ba() {

            final NetworkManager a;
            private int b;

            public void a(ay ay1)
            {
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a, ay1);
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a, new RevisionState(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.g(a)));
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.h(a);
                NetworkManager.i(a).a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.g(a));
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a, null);
                com.cyberlink.youcammakeup.kernelctrl.z.e(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.g(a).o());
            }

            public void a(bn bn1)
            {
label0:
                {
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a, null);
                    if (!com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a, bn1))
                    {
                        return;
                    }
                    if (b <= 0)
                    {
                        if (com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.j(a).size() <= 0)
                        {
                            break label0;
                        }
                        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a((String)com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.j(a).remove(0));
                        b = 3;
                    }
                    b = b - 1;
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.e(a).addFirst(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.l(a));
                    try
                    {
                        Thread.sleep(com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.f(a));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (bn bn1)
                    {
                        return;
                    }
                }
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.h(a);
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.k(a);
            }

            public volatile void a(Object obj)
            {
                a((ay)obj);
            }

            public void a(Void void1)
            {
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.h(a);
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = NetworkManager.this;
                super();
                b = 3;
            }
        });
        if (com.cyberlink.youcammakeup.kernelctrl.z.e());
        Q();
    }

    public static String A()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getDownloadItems").toString();
    }

    public static String B()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getPromotionPages").toString();
    }

    public static String C()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getMakeupItemByGuids").toString();
    }

    public static String D()
    {
        return (new StringBuilder()).append(k).append("/prog/support/app/feedback.jsp").toString();
    }

    public static String E()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getPostMapping").toString();
    }

    public static String F()
    {
        return TimeZone.getDefault().getID();
    }

    public static boolean L()
    {
        Object obj = Globals.d().getSystemService("connectivity");
        if (obj instanceof ConnectivityManager)
        {
            obj = ((ConnectivityManager)obj).getActiveNetworkInfo();
            if (obj != null && ((NetworkInfo) (obj)).isConnected())
            {
                return true;
            }
        }
        return false;
    }

    private void N()
    {
        O();
    }

    private void O()
    {
        com.cyberlink.youcammakeup.Globals.STORE_NAME store_name = Globals.d().c();
        if (Locale.getDefault().equals(Locale.CHINA))
        {
            store_name = com.cyberlink.youcammakeup.Globals.STORE_NAME.b;
        }
        for (Iterator iterator = m.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((List)entry.getValue()).contains(store_name))
            {
                i = (String)entry.getKey();
            } else
            {
                V.add(entry.getKey());
            }
        }

    }

    private int P()
    {
        return v.nextInt(1000) + 1000;
    }

    private void Q()
    {
        if (N != null)
        {
            a(N);
        }
        if (O != null)
        {
            a(O);
        }
        a(P);
    }

    private void R()
    {
        this;
        JVM INSTR monitorenter ;
        if (u.size() > 0) goto _L2; else goto _L1
_L1:
        U = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.a;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        ax ax1;
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a a1;
        ax1 = (ax)u.remove();
        if (!(ax1 instanceof com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        a1 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a)ax1;
        synchronized (H)
        {
            H.remove(Long.valueOf(a1.c().l()));
            I.add(Long.valueOf(a1.c().l()));
        }
        (new com.cyberlink.youcammakeup.kernelctrl.networkmanager.c(ax1, M)).executeOnExecutor(r, new Void[0]);
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void S()
    {
        this;
        JVM INSTR monitorenter ;
        if (t.size() > 0) goto _L2; else goto _L1
_L1:
        T = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.a;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        obj = (ax)t.remove();
        if (R == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        (new com.cyberlink.youcammakeup.kernelctrl.networkmanager.c(((ax) (obj)), L)).executeOnExecutor(p, new Void[0]);
          goto _L3
        obj;
        throw obj;
label0:
        {
            if (!(obj instanceof com.cyberlink.youcammakeup.baidupush.a) && !(obj instanceof a) && !(obj instanceof az))
            {
                break label0;
            }
            (new com.cyberlink.youcammakeup.kernelctrl.networkmanager.c(((ax) (obj)), L)).executeOnExecutor(p, new Void[0]);
        }
          goto _L3
        (new com.cyberlink.youcammakeup.kernelctrl.networkmanager.c(P, new com.cyberlink.youcammakeup.kernelctrl.networkmanager.d(((ax) (obj))) {

            final ax a;
            final NetworkManager b;

            public void a(Exception exception)
            {
                if (a instanceof com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a)
                {
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a a1 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a)a;
                    synchronized (NetworkManager.n(b))
                    {
                        NetworkManager.n(b).remove(Long.valueOf(a1.c().l()));
                    }
                }
                a.a(new bn(null, exception));
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.m(b).b(exception);
                return;
                exception;
                arraylist;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile void a(Object obj1)
            {
                a((Void)obj1);
            }

            public void a(Void void1)
            {
                if (com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.g(b) != null)
                {
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.e(b).addFirst(a);
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.m(b).a(void1);
                    return;
                } else
                {
                    void1 = new Exception("NetworkManager can't initialize.");
                    a.a(new bn(null, void1));
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.m(b).b(void1);
                    return;
                }
            }

            public void b(Object obj1)
            {
                a((Exception)obj1);
            }

            public void b(Void void1)
            {
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.m(b).c(void1);
            }

            public void c(Object obj1)
            {
                b((Void)obj1);
            }

            
            {
                b = NetworkManager.this;
                a = ax1;
                super();
            }
        })).executeOnExecutor(p, new Void[0]);
          goto _L3
    }

    private void T()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = aa.iterator(); iterator.hasNext(); ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.m)iterator.next()).a(S)) { }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        throw exception;
        aa.clear();
        this;
        JVM INSTR monitorexit ;
    }

    private void U()
    {
        this;
        JVM INSTR monitorenter ;
        if (e.size() > 0) goto _L2; else goto _L1
_L1:
        Z = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.a;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        (new com.cyberlink.youcammakeup.kernelctrl.networkmanager.c(((com.cyberlink.youcammakeup.kernelctrl.networkmanager.e)e.remove()).b, Y)).executeOnExecutor(X, new Void[0]);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static RevisionState a(NetworkManager networkmanager, RevisionState revisionstate)
    {
        networkmanager.S = revisionstate;
        return revisionstate;
    }

    static a a(NetworkManager networkmanager, a a1)
    {
        networkmanager.N = a1;
        return a1;
    }

    static ay a(NetworkManager networkmanager, ay ay1)
    {
        networkmanager.R = ay1;
        return ay1;
    }

    static az a(NetworkManager networkmanager, az az1)
    {
        networkmanager.P = az1;
        return az1;
    }

    static String a(NetworkManager networkmanager, String s1)
    {
        networkmanager.Q = s1;
        return s1;
    }

    public static String a(Exception exception)
    {
        String s2 = Globals.d().getResources().getString(0x7f070533);
        String s1;
        if (!L())
        {
            s1 = Globals.d().getResources().getString(0x7f070533);
        } else
        {
            s1 = s2;
            if (exception != null)
            {
                s1 = s2;
                if (exception instanceof UnknownHostException)
                {
                    return Globals.d().getResources().getString(0x7f070534);
                }
            }
        }
        return s1;
    }

    static String a(String s1)
    {
        i = s1;
        return s1;
    }

    static void a(NetworkManager networkmanager)
    {
        networkmanager.U();
    }

    private void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        synchronized (H)
        {
            u.add(a1);
            H.add(Long.valueOf(a1.c().l()));
        }
        a1 = U;
        obj = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.b;
        if (a1 != obj)
        {
            break MISSING_BLOCK_LABEL_69;
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        U = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.b;
        R();
          goto _L1
    }

    private void a(e e1, ax ax1, TaskPriority taskpriority)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        e1 = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.e(this, e1, ax1);
        flag = e.contains(e1);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (taskpriority != com.cyberlink.youcammakeup.kernelctrl.networkmanager.TaskPriority.b)
        {
            break; /* Loop/switch isn't completed */
        }
        e.addFirst(e1);
_L4:
        if (Z == com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.a)
        {
            Z = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.b;
            U();
        }
        if (true) goto _L1; else goto _L3
        e1;
        throw e1;
_L3:
        e.add(e1);
          goto _L4
    }

    public static void a(ay ay1)
    {
        boolean flag = e();
        String s1;
        if (flag)
        {
            s1 = ay1.b();
        } else
        {
            s1 = ay1.c();
        }
        i = s1;
        if (flag)
        {
            s1 = ay1.f();
        } else
        {
            s1 = ay1.e();
        }
        j = s1;
        if (flag)
        {
            s1 = ay1.l();
        } else
        {
            s1 = ay1.k();
        }
        k = s1;
        if (flag)
        {
            ay1 = ay1.n();
        } else
        {
            ay1 = ay1.m();
        }
        l = ay1;
    }

    private void a(String s1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a a1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.j j1)
    {
        synchronized (W)
        {
            a(((ax) (a1)));
            W.put(s1, a1);
        }
        return;
        s1;
        j1;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public static void a(List list)
    {
        list.add(new BasicNameValuePair("platform", "Android"));
        list.add(new BasicNameValuePair("product", "YouCam Makeup"));
        list.add(new BasicNameValuePair("version", "1.0"));
        list.add(new BasicNameValuePair("versiontype", "for Android"));
    }

    public static boolean a()
    {
        return false;
    }

    public static boolean a(Activity activity)
    {
        int i1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (i1 != 0)
        {
            if (GooglePlayServicesUtil.isUserRecoverableError(i1))
            {
                if (o)
                {
                    GooglePlayServicesUtil.getErrorDialog(i1, activity, 9000).show();
                }
                o = false;
                return false;
            } else
            {
                com.pf.common.utility.m.e("NetworkManager", "This device is not supported.");
                return false;
            }
        } else
        {
            return true;
        }
    }

    static boolean a(NetworkManager networkmanager, bn bn1)
    {
        return networkmanager.a(bn1);
    }

    private boolean a(bn bn1)
    {
        return bn1 == null || bn1.a() == null || bn1.a().getMessage() == null || !bn1.a().getMessage().equals(d);
    }

    public static String b()
    {
        return Globals.d().getFilesDir().getAbsolutePath();
    }

    static void b(NetworkManager networkmanager)
    {
        networkmanager.R();
    }

    private void b(String s1)
    {
        ConcurrentHashMap concurrenthashmap = W;
        concurrenthashmap;
        JVM INSTR monitorenter ;
        k k1 = (k)W.get(s1);
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        W.remove(s1);
        k1.d();
        concurrenthashmap;
        JVM INSTR monitorexit ;
        return;
        s1;
        concurrenthashmap;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public static void b(List list)
    {
        list.add(new BasicNameValuePair("platform", "Android"));
        list.add(new BasicNameValuePair("product", "YouCam Makeup"));
        list.add(new BasicNameValuePair("version", "1.0"));
        list.add(new BasicNameValuePair("versiontype", "for Android"));
        list.add(new BasicNameValuePair("lang", com.cyberlink.youcammakeup.kernelctrl.networkmanager.u.c()));
    }

    public static String c()
    {
        return Globals.d().getCacheDir().getAbsolutePath();
    }

    static void c(NetworkManager networkmanager)
    {
        networkmanager.S();
    }

    static a d(NetworkManager networkmanager)
    {
        return networkmanager.N;
    }

    public static String d()
    {
        return i;
    }

    static Deque e(NetworkManager networkmanager)
    {
        return networkmanager.t;
    }

    public static boolean e()
    {
        boolean flag;
        if (Boolean.parseBoolean(Globals.d().getApplicationContext().getString(0x7f070739)))
        {
            flag = true;
        } else
        {
            boolean flag1 = TestConfigHelper.h().d();
            flag = false;
            if (flag1)
            {
                boolean flag2 = TestConfigHelper.h().i();
                flag = flag2;
                if (flag2)
                {
                    return flag2;
                }
            }
        }
        return flag;
    }

    static int f(NetworkManager networkmanager)
    {
        return networkmanager.P();
    }

    public static boolean f()
    {
        if (n != null)
        {
            return n.booleanValue();
        } else
        {
            boolean flag = (new File(h)).exists();
            if (!flag);
            Boolean boolean1 = Boolean.valueOf(flag);
            n = boolean1;
            return boolean1.booleanValue();
        }
    }

    static ay g(NetworkManager networkmanager)
    {
        return networkmanager.R;
    }

    public static String g()
    {
        return (new StringBuilder()).append(i).append("/service/V2/init").toString();
    }

    public static String h()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getNotices").toString();
    }

    static void h(NetworkManager networkmanager)
    {
        networkmanager.T();
    }

    static NewBadgeState i(NetworkManager networkmanager)
    {
        return networkmanager.K;
    }

    public static String i()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getTemplates").toString();
    }

    public static String j()
    {
        return (new StringBuilder()).append(i).append("/service/markdownloaded").toString();
    }

    static List j(NetworkManager networkmanager)
    {
        return networkmanager.V;
    }

    public static String k()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getStatus").toString();
    }

    static void k(NetworkManager networkmanager)
    {
        networkmanager.N();
    }

    static az l(NetworkManager networkmanager)
    {
        return networkmanager.P;
    }

    public static String l()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getFilmCategoryList").toString();
    }

    static com.cyberlink.youcammakeup.kernelctrl.networkmanager.d m(NetworkManager networkmanager)
    {
        return networkmanager.L;
    }

    public static String m()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getFilmList").toString();
    }

    public static String n()
    {
        return (new StringBuilder()).append(i).append("/service/V2/filmViewCount").toString();
    }

    static ArrayList n(NetworkManager networkmanager)
    {
        return networkmanager.H;
    }

    public static String o()
    {
        return (new StringBuilder()).append(i).append("/service/V2/makeupItemDownloadCount").toString();
    }

    public static String p()
    {
        return (new StringBuilder()).append(i).append("/service/ad/LOREAL").toString();
    }

    public static String q()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getPromotionList").toString();
    }

    public static String r()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getPromotionBannerList").toString();
    }

    public static String s()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getSkus").toString();
    }

    public static String t()
    {
        return (new StringBuilder()).append(j).append("/service/V1/getADUnitList").toString();
    }

    public static String u()
    {
        return (new StringBuilder()).append(j).append("/service/V1/getADUnitContent").toString();
    }

    public static String v()
    {
        return (new StringBuilder()).append(i).append("/service/V2/makeupItem/getTree").toString();
    }

    public static String w()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getCategory").toString();
    }

    public static String x()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getMakeupItemByIds").toString();
    }

    public static String y()
    {
        return (new StringBuilder()).append(i).append("/service/V2/makeupItem/getPromotion").toString();
    }

    public static String z()
    {
        return (new StringBuilder()).append(i).append("/service/V2/getSkuByGuids").toString();
    }

    public AndroidHttpClient G()
    {
        return s;
    }

    public Long H()
    {
        if (R == null)
        {
            return null;
        } else
        {
            return Long.valueOf(R.a());
        }
    }

    public String I()
    {
        return Q;
    }

    public void J()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = A.iterator(); iterator.hasNext(); ((n)iterator.next()).l()) { }
        break MISSING_BLOCK_LABEL_41;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public NewBadgeState K()
    {
        return K;
    }

    public void M()
    {
        this;
        JVM INSTR monitorenter ;
        if (c.get())
        {
            com.pf.common.utility.m.b("NetworkManager", "triggerInitTask() NeedUpdateBaiduInfo!");
            String s1 = com.cyberlink.youcammakeup.kernelctrl.z.c();
            a(com.cyberlink.youcammakeup.kernelctrl.z.d(), s1, Globals.d().getApplicationContext());
            a(new az(Globals.d().getApplicationContext(), this, new ba() {

                final NetworkManager a;

                public void a(ay ay1)
                {
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.a(a, ay1);
                }

                public void a(bn bn1)
                {
                }

                public volatile void a(Object obj)
                {
                    a((ay)obj);
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                a = NetworkManager.this;
                super();
            }
            }));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public DownloadingState a(long l1)
    {
label0:
        {
            DownloadingState downloadingstate;
            synchronized (H)
            {
                if (!H.contains(Long.valueOf(l1)))
                {
                    break label0;
                }
                downloadingstate = new DownloadingState(com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState.State.a);
            }
            return downloadingstate;
        }
        Object obj;
        if (!I.contains(Long.valueOf(l1)))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        obj = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)J.get(Long.valueOf(l1));
        obj = new DownloadingState(com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState.State.b, ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a) (obj)));
        arraylist;
        JVM INSTR monitorexit ;
        return ((DownloadingState) (obj));
        obj = new DownloadingState(com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadingState.State.c);
        arraylist;
        JVM INSTR monitorexit ;
        return ((DownloadingState) (obj));
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.k k1)
    {
        File file = new File(k1.c().getPath());
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(c());
        stringbuilder.append(Globals.c);
        stringbuilder.append(k1.b());
        stringbuilder.append(Globals.c);
        stringbuilder.append("thumbnail");
        stringbuilder.append(Globals.c);
        stringbuilder.append(k1.a());
        stringbuilder.append(Globals.c);
        stringbuilder.append(file.getName());
        return stringbuilder.toString();
    }

    public void a(long l1, long l2, MakeupItemMetadata makeupitemmetadata, com.cyberlink.youcammakeup.kernelctrl.networkmanager.j j1)
    {
        makeupitemmetadata = new d(this, l2, makeupitemmetadata, j1);
        a((new StringBuilder()).append(l1).append(com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadType.b.name()).toString(), ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a) (makeupitemmetadata)), j1);
    }

    public void a(long l1, c c1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.j j1)
    {
        c1 = new j(this, c1, j1);
        a((new StringBuilder()).append(l1).append(com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadType.a.name()).toString(), ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a) (c1)), j1);
    }

    public void a(long l1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        J.put(Long.valueOf(l1), a1);
        for (Iterator iterator = x.iterator(); iterator.hasNext(); ((i)iterator.next()).a(l1, a1)) { }
        break MISSING_BLOCK_LABEL_59;
        a1;
        throw a1;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(long l1, bn bn1)
    {
        this;
        JVM INSTR monitorenter ;
        synchronized (H)
        {
            I.remove(Long.valueOf(l1));
            J.remove(Long.valueOf(l1));
        }
        for (obj = y.iterator(); ((Iterator) (obj)).hasNext(); ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.h)((Iterator) (obj)).next()).a(l1, bn1)) { }
        break MISSING_BLOCK_LABEL_88;
        bn1;
        throw bn1;
        bn1;
        obj;
        JVM INSTR monitorexit ;
        throw bn1;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(long l1, g g1, TaskPriority taskpriority, b b1, h h1, com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.DownloadType downloadtype)
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.a(g1);
        if (!(new File(s1)).exists()) goto _L2; else goto _L1
_L1:
        h1.a(s1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a(((e) (g1)), ((ax) (new f(this, g1, b1, h1, downloadtype))), taskpriority);
        if (true) goto _L4; else goto _L3
_L3:
        g1;
        throw g1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.f f1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!z.contains(f1))
        {
            z.add(f1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.g g1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!w.contains(g1))
        {
            w.add(g1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        g1;
        throw g1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.h h1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!y.contains(h1))
        {
            y.add(h1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        h1;
        throw h1;
    }

    public void a(i i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!x.contains(i1))
        {
            x.add(i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        i1;
        throw i1;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.k k1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.l l1)
    {
        a(c(), k1, l1);
    }

    public void a(n n1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!A.contains(n1))
        {
            A.add(n1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        n1;
        throw n1;
    }

    public void a(o o1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!E.contains(o1))
        {
            E.add(o1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        o1;
        throw o1;
    }

    public void a(p p1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!D.contains(p1))
        {
            D.add(p1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        p1;
        throw p1;
    }

    public void a(q q1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!G.contains(q1))
        {
            G.add(q1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        q1;
        throw q1;
    }

    public void a(r r1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!F.contains(r1))
        {
            F.add(r1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        r1;
        throw r1;
    }

    public void a(s s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!C.contains(s1))
        {
            C.add(s1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void a(t t1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!B.contains(t1))
        {
            B.add(t1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        t1;
        throw t1;
    }

    public void a(ax ax1)
    {
        this;
        JVM INSTR monitorenter ;
        a(ax1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.TaskPriority.a);
        this;
        JVM INSTR monitorexit ;
        return;
        ax1;
        throw ax1;
    }

    public void a(ax ax1, TaskPriority taskpriority)
    {
        this;
        JVM INSTR monitorenter ;
        if (!(ax1 instanceof com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a)) goto _L2; else goto _L1
_L1:
        a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a)ax1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (taskpriority != com.cyberlink.youcammakeup.kernelctrl.networkmanager.TaskPriority.b)
        {
            break; /* Loop/switch isn't completed */
        }
        t.addFirst(ax1);
_L5:
        if (T != com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.b)
        {
            T = com.cyberlink.youcammakeup.kernelctrl.networkmanager.Status.b;
            S();
        }
        if (true) goto _L4; else goto _L3
        ax1;
        throw ax1;
_L3:
        t.add(ax1);
          goto _L5
    }

    public void a(g g1, b b1, h h1, com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.DownloadType downloadtype)
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.a(g1);
        if (!(new File(s1)).exists()) goto _L2; else goto _L1
_L1:
        h1.a(s1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        g1 = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.e(this, g1, new f(this, g1, b1, h1, downloadtype));
        if (e.contains(g1))
        {
            e.remove(g1);
            e.addFirst(g1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        g1;
        throw g1;
    }

    public void a(String s1, Context context)
    {
        if (e()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        File file;
        obj = new File(f);
        ((File) (obj)).delete();
        file = ((File) (obj)).getParentFile();
        if (!file.exists() && !file.mkdirs())
        {
            continue; /* Loop/switch isn't completed */
        }
        file = null;
        ((File) (obj)).createNewFile();
        obj = new BufferedWriter(new FileWriter(((File) (obj))));
        ((BufferedWriter) (obj)).write(s1);
        s1 = com.cyberlink.youcammakeup.kernelctrl.z.b(context);
        ((BufferedWriter) (obj)).write(Globals.b);
        ((BufferedWriter) (obj)).write(Globals.b);
        ((BufferedWriter) (obj)).write(s1);
        if (obj != null)
        {
            try
            {
                ((BufferedWriter) (obj)).flush();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            try
            {
                ((BufferedWriter) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        s1;
        obj = null;
_L7:
        if (obj != null)
        {
            try
            {
                ((BufferedWriter) (obj)).flush();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            try
            {
                ((BufferedWriter) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        s1;
        context = file;
_L5:
        if (context != null)
        {
            try
            {
                context.flush();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw s1;
        s1;
        context = ((Context) (obj));
        if (true) goto _L5; else goto _L4
_L4:
        s1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(String s1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.k k1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.l l1)
    {
        Object obj = new File(k1.c().getPath());
        Object obj1 = new StringBuilder();
        ((StringBuilder) (obj1)).append(s1);
        ((StringBuilder) (obj1)).append(Globals.c);
        ((StringBuilder) (obj1)).append(k1.b());
        ((StringBuilder) (obj1)).append(Globals.c);
        ((StringBuilder) (obj1)).append("thumbnail");
        if (k1.d() == null)
        {
            ((StringBuilder) (obj1)).append(Globals.c);
            ((StringBuilder) (obj1)).append(k1.a());
        } else
        {
            ((StringBuilder) (obj1)).append(Globals.c);
            ((StringBuilder) (obj1)).append(k1.d());
        }
        s1 = ((File) (obj)).getPath();
        ((StringBuilder) (obj1)).append(Globals.c);
        ((StringBuilder) (obj1)).append((new StringBuilder()).append(String.valueOf(s1.hashCode())).append("_").append(((File) (obj)).getName()).toString());
        s1 = ((StringBuilder) (obj1)).toString();
        obj = (new StringBuilder()).append(s1).append(".tmp").toString();
        obj1 = new File(s1);
        if (((File) (obj1)).exists())
        {
            l1.a(((File) (obj1)).toString());
            return;
        }
        obj = new File(((String) (obj)));
        obj1 = ((File) (obj)).getParentFile();
        ((File) (obj1)).mkdirs();
        bb.a(((File) (obj1)));
        try
        {
            ((File) (obj)).createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            l1.b(new bn(null, s1));
            return;
        }
        (new com.cyberlink.youcammakeup.kernelctrl.networkmanager.c(new k(this, k1.c(), ((File) (obj)), new l(s1, l1) {

            final String a;
            final com.cyberlink.youcammakeup.kernelctrl.networkmanager.l b;
            final NetworkManager c;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
            {
                b.d(a1);
            }

            public void a(bn bn1)
            {
                b.b(bn1);
            }

            public void a(File file)
            {
                File file1 = new File(a);
                file.renameTo(file1);
                b.a(file1.toString());
            }

            public volatile void a(Object obj2)
            {
                a((File)obj2);
            }

            public void a(Void void1)
            {
                b.c(void1);
            }

            public void b(Object obj2)
            {
                a((bn)obj2);
            }

            public void c(Object obj2)
            {
                a((Void)obj2);
            }

            public void d(Object obj2)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj2);
            }

            
            {
                c = NetworkManager.this;
                a = s1;
                b = l1;
                super();
            }
        }), new com.cyberlink.youcammakeup.kernelctrl.networkmanager.d() {

            final NetworkManager a;

            public void a(Exception exception)
            {
            }

            public volatile void a(Object obj2)
            {
                a((Void)obj2);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj2)
            {
                a((Exception)obj2);
            }

            public void b(Void void1)
            {
            }

            public void c(Object obj2)
            {
                b((Void)obj2);
            }

            
            {
                a = NetworkManager.this;
                super();
            }
        })).executeOnExecutor(q, new Void[0]);
    }

    public void a(String s1, String s2, Context context)
    {
        if (e()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        File file;
        obj = new File(g);
        ((File) (obj)).delete();
        file = ((File) (obj)).getParentFile();
        if (!file.exists() && !file.mkdirs())
        {
            continue; /* Loop/switch isn't completed */
        }
        file = null;
        ((File) (obj)).createNewFile();
        obj = new BufferedWriter(new FileWriter(((File) (obj))));
        ((BufferedWriter) (obj)).write((new StringBuilder()).append("userID=").append(s1).append(", channelID=").append(s2).toString());
        s1 = com.cyberlink.youcammakeup.kernelctrl.z.b(context);
        ((BufferedWriter) (obj)).write(Globals.b);
        ((BufferedWriter) (obj)).write(Globals.b);
        ((BufferedWriter) (obj)).write(s1);
        if (obj != null)
        {
            try
            {
                ((BufferedWriter) (obj)).flush();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            try
            {
                ((BufferedWriter) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        s1;
        obj = null;
_L7:
        if (obj != null)
        {
            try
            {
                ((BufferedWriter) (obj)).flush();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            try
            {
                ((BufferedWriter) (obj)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        s1;
        s2 = file;
_L5:
        if (s2 != null)
        {
            try
            {
                s2.flush();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s2) { }
        }
        throw s1;
        s1;
        s2 = ((String) (obj));
        if (true) goto _L5; else goto _L4
_L4:
        s1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void b(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        synchronized (H)
        {
            I.remove(Long.valueOf(l1));
            J.remove(Long.valueOf(l1));
        }
        for (obj = w.iterator(); ((Iterator) (obj)).hasNext(); ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.g)((Iterator) (obj)).next()).c(l1)) { }
        break MISSING_BLOCK_LABEL_82;
        obj;
        throw obj;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.f f1)
    {
        this;
        JVM INSTR monitorenter ;
        if (z.contains(f1))
        {
            z.remove(f1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.g g1)
    {
        this;
        JVM INSTR monitorenter ;
        if (w.contains(g1))
        {
            w.remove(g1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        g1;
        throw g1;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.h h1)
    {
        this;
        JVM INSTR monitorenter ;
        if (y.contains(h1))
        {
            y.remove(h1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        h1;
        throw h1;
    }

    public void b(i i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (x.contains(i1))
        {
            x.remove(i1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        i1;
        throw i1;
    }

    public void b(n n1)
    {
        this;
        JVM INSTR monitorenter ;
        if (A.contains(n1))
        {
            A.remove(n1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        n1;
        throw n1;
    }

    public void b(o o1)
    {
        this;
        JVM INSTR monitorenter ;
        if (E.contains(o1))
        {
            E.remove(o1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        o1;
        throw o1;
    }

    public void b(p p1)
    {
        this;
        JVM INSTR monitorenter ;
        if (D.contains(p1))
        {
            D.remove(p1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        p1;
        throw p1;
    }

    public void b(q q1)
    {
        this;
        JVM INSTR monitorenter ;
        if (G.contains(q1))
        {
            G.remove(q1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        q1;
        throw q1;
    }

    public void b(r r1)
    {
        this;
        JVM INSTR monitorenter ;
        if (F.contains(r1))
        {
            F.remove(r1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        r1;
        throw r1;
    }

    public void b(s s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (C.contains(s1))
        {
            C.remove(s1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void b(t t1)
    {
        this;
        JVM INSTR monitorenter ;
        if (B.contains(t1))
        {
            B.remove(t1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        t1;
        throw t1;
    }

    public void c(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        synchronized (H)
        {
            I.remove(Long.valueOf(l1));
            J.remove(Long.valueOf(l1));
        }
        for (obj = z.iterator(); ((Iterator) (obj)).hasNext(); ((com.cyberlink.youcammakeup.kernelctrl.networkmanager.f)((Iterator) (obj)).next()).b(l1)) { }
        break MISSING_BLOCK_LABEL_82;
        obj;
        throw obj;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void d(long l1)
    {
        b((new StringBuilder()).append(l1).append(com.cyberlink.youcammakeup.kernelctrl.networkmanager.DownloadType.b.name()).toString());
    }

    static 
    {
        a = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        m = new HashMap();
        m.put("http://app.cyberlink.com", Arrays.asList(new com.cyberlink.youcammakeup.Globals.STORE_NAME[] {
            com.cyberlink.youcammakeup.Globals.STORE_NAME.a
        }));
        m.put("http://app.perfectcorp.cn", Arrays.asList(new com.cyberlink.youcammakeup.Globals.STORE_NAME[] {
            com.cyberlink.youcammakeup.Globals.STORE_NAME.b
        }));
    }

    private class Status extends Enum
    {

        public static final Status a;
        public static final Status b;
        private static final Status c[];

        public static Status valueOf(String s1)
        {
            return (Status)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/NetworkManager$Status, s1);
        }

        public static Status[] values()
        {
            return (Status[])c.clone();
        }

        static 
        {
            a = new Status("READY", 0);
            b = new Status("BUSY", 1);
            c = (new Status[] {
                a, b
            });
        }

        private Status(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class TaskPriority extends Enum
    {

        public static final TaskPriority a;
        public static final TaskPriority b;
        private static final TaskPriority c[];

        public static TaskPriority valueOf(String s1)
        {
            return (TaskPriority)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/NetworkManager$TaskPriority, s1);
        }

        public static TaskPriority[] values()
        {
            return (TaskPriority[])c.clone();
        }

        static 
        {
            a = new TaskPriority("LOWEST_TASK_PRIORITY", 0);
            b = new TaskPriority("HIGHEST_TASK_PRIORITY", 1);
            c = (new TaskPriority[] {
                a, b
            });
        }

        private TaskPriority(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class DownloadType extends Enum
    {

        public static final DownloadType a;
        public static final DownloadType b;
        private static final DownloadType c[];

        public static DownloadType valueOf(String s1)
        {
            return (DownloadType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/NetworkManager$DownloadType, s1);
        }

        public static DownloadType[] values()
        {
            return (DownloadType[])c.clone();
        }

        static 
        {
            a = new DownloadType("Template", 0);
            b = new DownloadType("MakeUp", 1);
            c = (new DownloadType[] {
                a, b
            });
        }

        private DownloadType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
