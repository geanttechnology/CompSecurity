// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.DiscoverTabItem;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.g;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import com.perfectcorp.utility.x;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser, n, i, a, 
//            l, m

public class NetworkManager
{

    static NetworkManager a = null;
    static ExecutorService b;
    static ExecutorService c = Executors.newSingleThreadExecutor();
    static Key.Init.Response.Misc f;
    private static int g;
    private static long h;
    private static ArrayList i = new ArrayList();
    boolean d;
    Key.Init.Response e;

    protected NetworkManager()
    {
        d = false;
    }

    static j a(ExecutorService executorservice)
    {
        return (new j() {

            protected NetworkManager a(Void void1)
            {
                if (NetworkManager.a == null)
                {
                    NetworkManager.a = new NetworkManager();
                }
                NetworkManager networkmanager = NetworkManager.a;
                networkmanager;
                JVM INSTR monitorenter ;
                String s;
                if (NetworkManager.a.d)
                {
                    break MISSING_BLOCK_LABEL_61;
                }
                s = AccountManager.a();
                void1 = s;
                if (!AccountManager.a(s))
                {
                    void1 = Locale.getDefault().toString();
                }
                Key.Init.a();
                NetworkManager.a(NetworkManager.a, void1);
                networkmanager;
                JVM INSTR monitorexit ;
                return NetworkManager.a;
                void1;
                networkmanager;
                JVM INSTR monitorexit ;
                throw void1;
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

        }).a(executorservice, null);
    }

    public static ArrayList a()
    {
        return i;
    }

    static void a(NetworkManager networkmanager, String s)
    {
        c(networkmanager, s);
    }

    public static void a(String s)
    {
        b().a(new j(s) {

            final String a;

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            protected Void a(NetworkManager networkmanager)
            {
                NetworkManager.a(networkmanager, a);
                return null;
            }

            
            {
                a = s;
                super();
            }
        });
    }

    public static void a(ArrayList arraylist)
    {
        (new j(arraylist) {

            final ArrayList a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                if (a != null)
                {
                    void1 = new DiscoverTabItem();
                    void1.tabList = a;
                    Globals.D().edit().putString("BeautyOptoinList", void1.toString()).commit();
                    t.f.a();
                }
                return null;
            }

            
            {
                a = arraylist;
                super();
            }
        }).d(null);
    }

    static j b()
    {
        return a(b);
    }

    static void b(NetworkManager networkmanager, String s)
    {
        networkmanager.c(s);
    }

    private static void b(String s)
    {
        if (Globals.d != null && s != null)
        {
            String s1 = Globals.d.getResources().getString(m.bc_dialog_title_notification);
            if (s.equals("suggest_update_app"))
            {
                s = Globals.d.getResources().getString(m.bc_actioncode_suggest_update_app);
                String s2 = Globals.d.getResources().getString(m.bc_actioncode_skip);
                String s5 = Globals.d.getResources().getString(m.bc_actioncode_update);
                DialogUtils.a(Globals.d, s1, s, s2, new Runnable() {

                    public void run()
                    {
                    }

                }, s5, new Runnable() {

                    public void run()
                    {
                        if (Globals.d != null)
                        {
                            com.perfectcorp.utility.g.a(Globals.d, Globals.n().getPackageName(), "BeautyCircle", "suggest_update_app");
                        }
                    }

                });
                return;
            }
            if (s.equals("force_update_app"))
            {
                s = Globals.d.getResources().getString(m.bc_actioncode_force_update_app);
                String s3 = Globals.d.getResources().getString(m.bc_actioncode_update);
                DialogUtils.a(Globals.d, s1, s, s3, new Runnable() {

                    public void run()
                    {
                        if (Globals.d != null)
                        {
                            com.perfectcorp.utility.g.a(Globals.d, Globals.n().getPackageName(), "BeautyCircle", "force_update_app");
                        }
                    }

                }, null, null, false, null);
                return;
            }
            if (s.equals("force_logout_account") && (Globals.d instanceof MainActivity) && AccountManager.d() != null)
            {
                s = (MainActivity)Globals.d;
                s.k();
                NetworkUser.a(AccountManager.b()).a(new j() {

                    protected volatile Object a(Object obj)
                    {
                        return a((Void)obj);
                    }

                    protected Void a(Void void1)
                    {
                        try
                        {
                            AccountManager.a(true, true, Globals.c()).d();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1)
                        {
                            void1.printStackTrace();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1)
                        {
                            void1.printStackTrace();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1)
                        {
                            void1.printStackTrace();
                        }
                        return null;
                    }

                }).a(new com.perfectcorp.utility.m(s) {

                    final MainActivity a;

                    protected void a()
                    {
                        a.l();
                        Globals.b((new StringBuilder()).append(Globals.d.getResources().getString(m.bc_user_log_out_fail)).append(" (CANCELLED)").toString());
                        a(((Void) (null)));
                    }

                    protected void a(int k)
                    {
                        a.l();
                        Globals.b((new StringBuilder()).append(Globals.d.getResources().getString(m.bc_user_log_out_fail)).append(" (Code : '").append(k).append("')").toString());
                        a(((Void) (null)));
                    }

                    protected void a(Void void1)
                    {
                        a.l();
                    }

                    protected void b(Object obj)
                    {
                        a((Void)obj);
                    }

            
            {
                a = mainactivity;
                super();
            }
                });
                s = Globals.d.getResources().getString(m.bc_actioncode_force_logout_account);
                String s4 = Globals.d.getResources().getString(m.bc_actioncode_ok);
                DialogUtils.a(Globals.d, s1, s, s4, new Runnable() {

                    public void run()
                    {
                    }

                }, null, null);
                return;
            }
        }
    }

    static n c()
    {
        x x1 = u.i;
        x1.c = x1.c + 1L;
        x1 = u.i;
        x1.a = x1.a + 1L;
        return new n();
    }

    private static void c(NetworkManager networkmanager, String s)
    {
        networkmanager;
        JVM INSTR monitorenter ;
        boolean flag = e.a;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        HttpResponseCache.install(new File(Globals.n().getCacheDir(), "bc_http"), 0xa00000L);
_L1:
        u u1;
        u1 = new u(com.cyberlink.beautycircle.model.network.i.a(Globals.c()));
        u1.a("ap", Key.Init.a.a);
        u1.a("version", Key.Init.a.b);
        u1.a("versionType", Key.Init.a.c);
        u1.a("buildNumber", Key.Init.a.d);
        u1.a("locale", s);
        u1.a("uuid", Key.Init.a.e);
        u1.a("model", Key.Init.a.f);
        u1.a("vender", Key.Init.a.g);
        u1.a("resolution", Key.Init.a.h);
        u1.a("apiVersion", Key.Init.a.i);
        u1.a("apnsType", Key.Init.a.j);
        u1.a("apnsToken", AccountManager.j());
        u1.a("userId", AccountManager.c());
        u1.a("userAgent", Key.Init.a.k);
        d().d(u1).a(networkmanager. new j() {

            final NetworkManager a;

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            protected Void a(String s1)
            {
                NetworkManager.b(a, s1);
                com.cyberlink.you.u.a(a.e.search.searchPeople);
                return null;
            }

            
            {
                a = NetworkManager.this;
                super();
            }
        }).d();
_L2:
        networkmanager;
        JVM INSTR monitorexit ;
        return;
        IOException ioexception;
        ioexception;
        com.perfectcorp.utility.e.e(new Object[] {
            (new StringBuilder()).append("HTTP response cache installation failed:").append(ioexception).toString()
        });
          goto _L1
        s;
        networkmanager;
        JVM INSTR monitorexit ;
        throw s;
        s;
        com.perfectcorp.utility.e.c(new Object[] {
            "NetworkManager is not ready"
        });
          goto _L2
        s;
        s.printStackTrace();
          goto _L2
    }

    private void c(String s)
    {
        e = (Key.Init.Response)Model.a(com/cyberlink/beautycircle/model/network/Key$Init$Response, s);
        if (e != null)
        {
            d = true;
            b(e.actionCode);
            a(e.discoverTab);
            f = e.misc;
        }
    }

    static l d()
    {
        x x1 = u.i;
        x1.b = x1.b + 1L;
        x1 = u.i;
        x1.a = x1.a + 1L;
        return new l();
    }

    public static String e()
    {
        boolean flag = e.a;
        if (i == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        Object obj = com.perfectcorp.utility.e.a();
_L15:
        Object obj1 = new File(((String) (obj)), "connectionHistory.csv");
        if (!((File) (obj1)).exists()) goto _L6; else goto _L5
_L5:
        long l1;
        obj = Globals.D();
        l1 = System.currentTimeMillis() / 0x5265c00L;
        if (l1 != ((SharedPreferences) (obj)).getLong("UrlHistoryDate", 0L) / 0x5265c00L) goto _L8; else goto _L7
_L7:
        if (((File) (obj1)).length() >= 0x100000L) goto _L6; else goto _L9
_L9:
        flag = true;
_L12:
        obj = new FileWriter(((File) (obj1)), flag);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        ((FileWriter) (obj)).write("Code,Duration,URI@");
        ((FileWriter) (obj)).write(com.cyberlink.beautycircle.utility.i.c(new Date()));
        ((FileWriter) (obj)).write("\r\n");
        for (Iterator iterator = i.iterator(); iterator.hasNext(); ((FileWriter) (obj)).write("\r\n"))
        {
            com.cyberlink.beautycircle.model.network.m m1 = (com.cyberlink.beautycircle.model.network.m)iterator.next();
            ((FileWriter) (obj)).write(String.valueOf(m1.b));
            ((FileWriter) (obj)).write(",");
            ((FileWriter) (obj)).write(String.valueOf(m1.c));
            ((FileWriter) (obj)).write(",");
            ((FileWriter) (obj)).write(m1.a.toString());
        }

        break; /* Loop/switch isn't completed */
        obj1;
_L10:
        {
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            String s;
            try
            {
                ((FileWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.perfectcorp.utility.e.e(new Object[0]);
                return null;
            }
            s = null;
        }
        return s;
_L4:
        Exception exception1;
        try
        {
            obj = com.perfectcorp.utility.e.b();
            continue; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            exception = null;
        }
        finally
        {
            obj = null;
        }
        if (true) goto _L10; else goto _L2
_L8:
        ((SharedPreferences) (obj)).edit().putLong("UrlHistoryDate", l1).apply();
_L6:
        flag = false;
        if (true) goto _L12; else goto _L11
_L11:
        ((FileWriter) (obj)).flush();
        obj1 = ((File) (obj1)).getPath();
        s = ((String) (obj1));
        if (obj != null)
        {
            try
            {
                ((FileWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.perfectcorp.utility.e.e(new Object[0]);
                return ((String) (obj1));
            }
            return ((String) (obj1));
        } else
        {
            break MISSING_BLOCK_LABEL_224;
        }
_L13:
        if (obj != null)
        {
            try
            {
                ((FileWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.perfectcorp.utility.e.e(new Object[0]);
            }
        }
        throw exception1;
        exception1;
        if (true) goto _L13; else goto _L2
_L2:
        return null;
        if (true) goto _L15; else goto _L14
_L14:
    }

    static ArrayList f()
    {
        return i;
    }

    static 
    {
        g = 5;
        h = 5000L;
        b = new ThreadPoolExecutor(g, 100, h, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }
}
