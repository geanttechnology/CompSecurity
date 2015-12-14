// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.cyberlink.you.chat.ab;
import com.cyberlink.you.chat.af;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.utility.ULogUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.cyberlink.you:
//            c, b, g

public class a
{

    private static boolean k = true;
    public BroadcastReceiver a;
    public BroadcastReceiver b;
    public BroadcastReceiver c;
    public BroadcastReceiver d;
    public BroadcastReceiver e;
    private boolean f;
    private boolean g;
    private ConnectivityManager h;
    private WifiManager i;
    private TelephonyManager j;
    private boolean l;
    private String m;
    private String n;
    private Object o;
    private List p;
    private boolean q;
    private boolean r;
    private String s;
    private boolean t;
    private List u;

    public a()
    {
        f = false;
        g = false;
        l = false;
        m = "";
        n = "";
        o = new Object();
        p = new ArrayList();
        q = false;
        r = false;
        s = "com.sonymobile.SUPER_STAMINA";
        t = false;
        a = new BroadcastReceiver() {

            final a a;

            public void onReceive(Context context, Intent intent)
            {
                if (intent.getExtras() != null)
                {
                    context = a;
                    boolean flag;
                    if (!intent.getBooleanExtra("noConnectivity", false))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    a.b(context, flag);
                    flag = intent.getBooleanExtra("ForceReconnect", false);
                    Log.i("ConnectionManager", (new StringBuilder()).append("Connectivity: ").append(a.b(a)).toString());
                    if (!a.c(a))
                    {
                        Log.v("ConnectionManager", "!isHeld() do nothing");
                    } else
                    if (a.d(a) != null)
                    {
                        NetworkInfo networkinfo = a.d(a).getActiveNetworkInfo();
                        intent = "";
                        context = "";
                        if (networkinfo != null)
                        {
                            intent = networkinfo.getTypeName();
                            if (intent.equals("WIFI"))
                            {
                                context = a.e(a).getConnectionInfo().getSSID();
                            } else
                            {
                                context = networkinfo.getSubtypeName();
                            }
                        }
                        if (a.b(a))
                        {
                            Log.i("ConnectionManager", (new StringBuilder()).append("Type: ").append(intent).toString());
                            Log.i("ConnectionManager", (new StringBuilder()).append("SubType: ").append(context).toString());
                        }
                        ULogUtility.a((new StringBuilder()).append("Connectivity: ").append(a.b(a)).toString(), "XMPP Connection");
                        if (a.h())
                        {
                            a.a(false);
                            a.c(a, a.b(a));
                            a.a(a, intent);
                            a.b(a, context);
                            return;
                        }
                        if (Boolean.valueOf(flag).booleanValue() || a.b(a) != a.f(a) || !intent.equals(a.g(a)) || !context.equals(a.h(a)))
                        {
                            Log.d("ConnectionManager", "Need Reconnect/Disconnect");
                            ULogUtility.a("Need Reconnect/Disconnect", "XMPP Connection");
                            (new Thread(this) {

                                final _cls2 a;

                                public void run()
                                {
                                    com.cyberlink.you.chat.n.a().e();
                                    if (a.b(a.a))
                                    {
                                        com.cyberlink.you.friends.l.d();
                                        a.d(a.a, false);
                                    }
                                }

            
            {
                a = _pcls2;
                super();
            }
                            }).start();
                        } else
                        {
                            Log.i("ConnectionManager", "Don't Need Reconnect");
                        }
                        a.c(a, a.b(a));
                        a.a(a, intent);
                        a.b(a, context);
                        return;
                    }
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        b = new BroadcastReceiver() {

            final a a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                if (context != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if (!context.equals("android.intent.action.SCREEN_OFF"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (!a.i(a))
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (!a.j(a)) goto _L1; else goto _L3
_L3:
                Log.w("ConnectionManager", "Screen Off: Stamina Enabled, disconnect");
                n.b = false;
                com.cyberlink.you.chat.n.a().e();
                return;
                if (!Build.MANUFACTURER.toUpperCase(Locale.US).contains("SONY")) goto _L1; else goto _L4
_L4:
                a.c(a, false);
                a.a(a, "");
                a.b(a, "");
                return;
                if (!context.equals("android.intent.action.SCREEN_ON") || !a.i(a) || !a.j(a)) goto _L1; else goto _L5
_L5:
                Log.w("ConnectionManager", "Screen On: Stamina Enabled, reconnect");
                a.e();
                return;
            }

            
            {
                a = a.this;
                super();
            }
        };
        c = new BroadcastReceiver() {

            final a a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                break MISSING_BLOCK_LABEL_5;
                if (context != null && context.equals(a.k(a)))
                {
                    a.e(a, true);
                    context = intent.getExtras();
                    if (context != null)
                    {
                        boolean flag = context.getBoolean("state");
                        a.f(a, Boolean.valueOf(flag).booleanValue());
                        return;
                    }
                }
                return;
            }

            
            {
                a = a.this;
                super();
            }
        };
        d = new BroadcastReceiver() {

            final a a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                break MISSING_BLOCK_LABEL_5;
                if (context != null && context.equals("android.net.wifi.supplicant.STATE_CHANGE"))
                {
                    intent = (SupplicantState)intent.getParcelableExtra("newState");
                    if (intent != null)
                    {
                        context = intent.toString();
                        if (intent == SupplicantState.COMPLETED && a.e(a) != null)
                        {
                            Object obj = a.e(a).getConnectionInfo();
                            if (obj != null)
                            {
                                intent = ((WifiInfo) (obj)).getSSID();
                                obj = ((WifiInfo) (obj)).getBSSID();
                                if (intent != null && obj != null)
                                {
                                    context = (new StringBuilder()).append(context).append(" ").append(intent).append(" ").append(((String) (obj)).toUpperCase(Locale.US)).toString();
                                }
                            }
                        }
                        ULogUtility.a(context, "WiFi");
                        return;
                    }
                }
                return;
            }

            
            {
                a = a.this;
                super();
            }
        };
        e = new BroadcastReceiver() {

            final a a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                if (context != null)
                {
                    Log.w("ConnectionManager", context);
                    ULogUtility.a(context, "Time");
                    if (context.equals("android.intent.action.DATE_CHANGED") || context.equals("android.intent.action.TIME_SET") || context.equals("android.intent.action.TIMEZONE_CHANGED"))
                    {
                        (new Thread(new Runnable(this) {

                            final _cls6 a;

                            public void run()
                            {
                                com.cyberlink.you.friends.l.g();
                            }

            
            {
                a = _pcls6;
                super();
            }
                        })).start();
                        return;
                    }
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        u = new ArrayList();
    }

    public static a a()
    {
        return com.cyberlink.you.c.a();
    }

    static String a(a a1, String s1)
    {
        a1.m = s1;
        return s1;
    }

    static void a(a a1)
    {
        a1.j();
    }

    static boolean a(a a1, boolean flag)
    {
        a1.g = flag;
        return flag;
    }

    static boolean a(boolean flag)
    {
        k = flag;
        return flag;
    }

    static String b(a a1, String s1)
    {
        a1.n = s1;
        return s1;
    }

    private void b(boolean flag)
    {
        if (g)
        {
            return;
        } else
        {
            ULogUtility.a("re-authorize", "XMPP Connection");
            g = true;
            (new Thread() {

                final a a;

                public void run()
                {
                    Thread.currentThread().setName("reconnect");
_L7:
                    if (!a.c()) goto _L2; else goto _L1
_L1:
                    if (!com.cyberlink.you.friends.l.a() || !com.cyberlink.you.chat.n.a().d()) goto _L4; else goto _L3
_L3:
                    ULogUtility.a("reconnect successful", "XMPP Connection");
                    Log.i("ConnectionManager", "reconnect successful. break.");
                    a.a(a);
_L6:
                    a.a(a, false);
                    return;
_L4:
                    com.cyberlink.you.chat.n.a().a(true);
                    if (!com.cyberlink.you.chat.n.a().h()) goto _L2; else goto _L5
_L5:
                    Log.i("ConnectionManager", "XMPP is authorized, break");
                    ULogUtility.a("XMPP is authorized", "XMPP Connection");
                    a.a(a);
                      goto _L6
_L2:
                    sleep(5000L);
                      goto _L7
                    InterruptedException interruptedexception;
                    interruptedexception;
                      goto _L6
                }

            
            {
                a = a.this;
                super();
            }
            }).start();
            return;
        }
    }

    static boolean b(a a1)
    {
        return a1.f;
    }

    static boolean b(a a1, boolean flag)
    {
        a1.f = flag;
        return flag;
    }

    static boolean c(a a1)
    {
        return a1.i();
    }

    static boolean c(a a1, boolean flag)
    {
        a1.l = flag;
        return flag;
    }

    static ConnectivityManager d(a a1)
    {
        return a1.h;
    }

    static void d(a a1, boolean flag)
    {
        a1.b(flag);
    }

    static WifiManager e(a a1)
    {
        return a1.i;
    }

    static boolean e(a a1, boolean flag)
    {
        a1.q = flag;
        return flag;
    }

    static boolean f(a a1)
    {
        return a1.l;
    }

    static boolean f(a a1, boolean flag)
    {
        a1.r = flag;
        return flag;
    }

    static String g(a a1)
    {
        return a1.m;
    }

    static String h(a a1)
    {
        return a1.n;
    }

    static boolean h()
    {
        return k;
    }

    private boolean i()
    {
        Object obj = o;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (!p.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean i(a a1)
    {
        return a1.q;
    }

    private void j()
    {
        List list = u;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = u.iterator();
_L1:
        b b1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        b1 = (b)iterator.next();
        b1.a();
          goto _L1
        Exception exception1;
        exception1;
        exception1.printStackTrace();
          goto _L1
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    static boolean j(a a1)
    {
        return a1.r;
    }

    static String k(a a1)
    {
        return a1.s;
    }

    public void a(String s1)
    {
        if (s1 == null || s1.isEmpty())
        {
            return;
        }
        synchronized (o)
        {
            if (!p.contains(s1))
            {
                p.add(s1);
            }
            Log.d("ConnectionManager", (new StringBuilder()).append("Acquire Connection ").append(p.toString()).toString());
            t = true;
            e();
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void b()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        com.cyberlink.you.g.I().registerReceiver(a, intentfilter);
        h = (ConnectivityManager)com.cyberlink.you.g.I().getSystemService("connectivity");
        i = (WifiManager)com.cyberlink.you.g.I().getSystemService("wifi");
        j = (TelephonyManager)com.cyberlink.you.g.I().getSystemService("phone");
        intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        com.cyberlink.you.g.I().registerReceiver(b, intentfilter);
        intentfilter = new IntentFilter();
        intentfilter.addAction(s);
        com.cyberlink.you.g.I().registerReceiver(c, intentfilter);
        intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        com.cyberlink.you.g.a();
        com.cyberlink.you.g.I().registerReceiver(d, intentfilter);
        intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.TIME_SET");
        intentfilter.addAction("android.intent.action.DATE_CHANGED");
        intentfilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        com.cyberlink.you.g.a();
        com.cyberlink.you.g.I().registerReceiver(e, intentfilter);
        f = c();
        com.cyberlink.you.chat.n.a();
    }

    public void b(String s1)
    {
        if (s1 == null || s1.isEmpty())
        {
            return;
        }
        Object obj = o;
        obj;
        JVM INSTR monitorenter ;
        if (!p.contains(s1))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        p.remove(s1);
_L1:
        Log.d("ConnectionManager", (new StringBuilder()).append("Release Connection ").append(p.toString()).toString());
        if (p.isEmpty())
        {
            t = false;
            af.a().c();
            n.b = false;
            com.cyberlink.you.chat.n.a().e();
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
        Log.d("ConnectionManager", (new StringBuilder()).append(s1).append(" not acquired").toString());
          goto _L1
    }

    public boolean c()
    {
        while (h == null || h.getActiveNetworkInfo() == null) 
        {
            return false;
        }
        return true;
    }

    public String d()
    {
        Object obj = h.getActiveNetworkInfo();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((String) (obj));
_L2:
        String s2;
        s2 = ((NetworkInfo) (obj)).getTypeName();
        if (s2 == null || s2.isEmpty())
        {
            return null;
        }
        if (!s2.toUpperCase(Locale.US).equals("WIFI"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s2;
        if (i != null)
        {
            WifiInfo wifiinfo = i.getConnectionInfo();
            obj = s2;
            if (wifiinfo != null)
            {
                String s4 = wifiinfo.getSSID();
                obj = s2;
                if (s4 != null)
                {
                    obj = s2;
                    if (!s4.isEmpty())
                    {
                        return (new StringBuilder()).append(s2).append(" ").append(s4).append(" ").append(wifiinfo.getLinkSpeed()).append("Mbps").toString();
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = ((NetworkInfo) (obj)).getSubtypeName();
        String s1 = s2;
        if (obj != null)
        {
            s1 = s2;
            if (!((String) (obj)).isEmpty())
            {
                s1 = (new StringBuilder()).append(s2).append(" ").append(((String) (obj))).toString();
            }
        }
        obj = s1;
        if (j != null)
        {
            String s3 = j.getNetworkOperatorName();
            obj = s1;
            if (s3 != null)
            {
                obj = s1;
                if (!s3.isEmpty())
                {
                    return (new StringBuilder()).append(s1).append(" ").append(s3).toString();
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void e()
    {
        n.b = true;
        b(true);
        ab.a().d();
        af.a();
    }

    public void f()
    {
        synchronized (o)
        {
            p.clear();
            Log.d("ConnectionManager", "Force Release Connection");
            if (p.isEmpty())
            {
                n.b = false;
                com.cyberlink.you.chat.n.a().f();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean g()
    {
        return t;
    }

}
