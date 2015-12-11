// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import android.content.Context;
import android.location.Location;
import android.support.v4.view.bi;
import android.support.v4.view.cs;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.gson.GsonManager;
import com.offerup.android.utils.as;
import com.offerup.android.utils.ba;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
import java.util.HashMap;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

// Referenced classes of package com.offerup.android.network:
//            o, e, PaymentService, SystemService, 
//            s, UserService, r

public class b
{

    private static HashMap a;
    private static HashMap b;
    private final View c;
    private ViewParent d;
    private boolean e;
    private int f[];

    public b(View view)
    {
        c = view;
    }

    public static HashMap a(Context context)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        j j1;
        String s1;
        hashmap = new HashMap(2);
        j1 = j.a();
        s1 = com.offerup.android.utils.b.a(context);
        if (!StringUtils.isNotEmpty(s1)) goto _L2; else goto _L1
_L1:
        hashmap.put("X-OU-D-TOKEN", s1);
_L3:
        hashmap.put("User-Agent", as.b());
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return hashmap;
_L2:
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (StringUtils.isNotEmpty(context))
        {
            hashmap.put("X-OU-D-TOKEN", context);
            j1.m(context);
        }
          goto _L3
        context;
        g.c("HeaderHelper", (new StringBuilder("X-OU-D-TOKEN error")).append(Log.getStackTraceString(context)).toString());
          goto _L3
        context;
        throw context;
    }

    public static void a()
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        a = null;
        b = null;
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(long l, boolean flag, Location location, String s1)
    {
        PaymentService paymentservice = o.k(o.a(Executors.newSingleThreadExecutor()));
        if (location != null)
        {
            try
            {
                paymentservice.postMyPaymentLocation(l, flag, location.getLongitude(), location.getLatitude(), location.getAccuracy(), s1, new e((byte)0));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Location location)
            {
                g.a("PaymentServiceWrapper", location);
            }
            break MISSING_BLOCK_LABEL_78;
        }
        paymentservice.postMyPaymentLocation(l, flag, 0.0D, 0.0D, -1F, s1, new e((byte)0));
        return;
    }

    public static void a(Context context, String s1, Callback callback)
    {
        String s2 = com.offerup.android.utils.b.a(context);
        String s3 = UAirship.shared().getPushManager().getChannelId();
        String s4 = j.a().u();
        java.util.concurrent.ExecutorService executorservice = Executors.newSingleThreadExecutor();
        OkClient okclient = new OkClient();
        retrofit.RestAdapter.LogLevel loglevel = retrofit.RestAdapter.LogLevel.NONE;
        ((SystemService)(new retrofit.RestAdapter.Builder()).setExecutors(executorservice, new MainThreadExecutor()).setClient(okclient).setEndpoint("https://s3.amazonaws.com/").setRequestInterceptor(d(context)).setConverter(new GsonConverter(GsonManager.getGson())).setLogLevel(loglevel).build().create(com/offerup/android/network/SystemService)).getStatusJson(s1, s2, s3, s4, callback);
    }

    public static void a(Object obj, Context context)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        o.e(o.a(Executors.newSingleThreadExecutor())).validateUser(ba.b(), j.a().l(), new s(context, obj));
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public static void a(String s1, String s2, Callback callback)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        o.e(o.a(Executors.newSingleThreadExecutor())).loginWithEmail(s1, s2, callback);
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public static void a(String s1, Callback callback)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        o.e(o.a(Executors.newSingleThreadExecutor())).loginWithFb(s1, callback);
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public static void a(Callback callback)
    {
        o.k(o.a(Executors.newSingleThreadExecutor())).getPaymentMethods(callback);
    }

    public static HashMap b(Context context)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        if (a == null) goto _L2; else goto _L1
_L1:
        context = a;
_L5:
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return context;
_L2:
        j j1;
        String s1;
        a = new HashMap(3);
        j1 = j.a();
        s1 = j1.l();
        if (StringUtils.isNotEmpty(s1))
        {
            a.put("X-OU-AUTH-TOKEN", s1);
        }
        s1 = com.offerup.android.utils.b.a(context);
        if (!StringUtils.isNotEmpty(s1)) goto _L4; else goto _L3
_L3:
        a.put("X-OU-D-TOKEN", s1);
_L6:
        a.put("User-Agent", as.b());
        context = a;
          goto _L5
_L4:
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (StringUtils.isNotEmpty(context))
        {
            a.put("X-OU-D-TOKEN", context);
            j1.m(context);
        }
          goto _L6
        context;
        g.c("HeaderHelper", (new StringBuilder("X-OU-D-TOKEN error")).append(Log.getStackTraceString(context)).toString());
          goto _L6
        context;
        throw context;
    }

    public static void b(String s1, Callback callback)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        o.e(o.a(Executors.newSingleThreadExecutor())).postVerifyData(ba.b(), s1, callback);
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public static void b(Callback callback)
    {
        o.k(o.c(Executors.newSingleThreadExecutor())).getToken(callback);
    }

    public static HashMap c(Context context)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        if (b == null) goto _L2; else goto _L1
_L1:
        context = b;
_L5:
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return context;
_L2:
        j j1;
        String s1;
        b = new HashMap(3);
        j1 = j.a();
        s1 = j1.l();
        if (StringUtils.isNotEmpty(s1))
        {
            b.put("X-OU-AUTH-TOKEN", s1);
        }
        s1 = com.offerup.android.utils.b.a(context);
        if (!StringUtils.isNotEmpty(s1)) goto _L4; else goto _L3
_L3:
        b.put("X-OU-D-TOKEN", s1);
_L6:
        b.put("X-OU-D-INFO", as.b());
        context = b;
          goto _L5
_L4:
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (StringUtils.isNotEmpty(context))
        {
            b.put("X-OU-D-TOKEN", context);
            j1.m(context);
        }
          goto _L6
        context;
        g.c("HeaderHelper", (new StringBuilder("X-OU-D-TOKEN error")).append(Log.getStackTraceString(context)).toString());
          goto _L6
        context;
        throw context;
    }

    public static void c(Callback callback)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        String s1;
        UserService userservice;
        s1 = ba.b();
        userservice = o.e(o.a(Executors.newSingleThreadExecutor()));
        if (!StringUtils.isNotEmpty(s1)) goto _L2; else goto _L1
_L1:
        userservice.getProfile(s1, callback);
_L4:
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return;
_L2:
        userservice.getProfile(callback);
        if (true) goto _L4; else goto _L3
_L3:
        callback;
        throw callback;
    }

    public static RequestInterceptor d(Context context)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        context = new r(context);
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static void d(Callback callback)
    {
        com/offerup/android/network/b;
        JVM INSTR monitorenter ;
        o.e(o.a(Executors.newSingleThreadExecutor())).getMyListedItems(callback);
        com/offerup/android/network/b;
        JVM INSTR monitorexit ;
        return;
        callback;
        throw callback;
    }

    public void a(boolean flag)
    {
        if (e)
        {
            bi.A(c);
        }
        e = flag;
    }

    public boolean a(float f1, float f2)
    {
        if (b() && d != null)
        {
            return cs.a(d, c, f1, f2);
        } else
        {
            return false;
        }
    }

    public boolean a(float f1, float f2, boolean flag)
    {
        if (b() && d != null)
        {
            return cs.a(d, c, f1, f2, flag);
        } else
        {
            return false;
        }
    }

    public boolean a(int i)
    {
        if (c())
        {
            return true;
        }
        if (b())
        {
            ViewParent viewparent = c.getParent();
            View view = c;
            for (; viewparent != null; viewparent = viewparent.getParent())
            {
                if (cs.a(viewparent, view, c, i))
                {
                    d = viewparent;
                    cs.b(viewparent, view, c, i);
                    return true;
                }
                if (viewparent instanceof View)
                {
                    view = (View)viewparent;
                }
            }

        }
        return false;
    }

    public boolean a(int i, int k, int l, int i1, int ai[])
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (b())
        {
            flag = flag1;
            if (d != null)
            {
                if (i != 0 || k != 0 || l != 0 || i1 != 0)
                {
                    int j1;
                    int k1;
                    if (ai != null)
                    {
                        c.getLocationInWindow(ai);
                        k1 = ai[0];
                        j1 = ai[1];
                    } else
                    {
                        j1 = 0;
                        k1 = 0;
                    }
                    cs.a(d, c, i, k, l, i1);
                    if (ai != null)
                    {
                        c.getLocationInWindow(ai);
                        ai[0] = ai[0] - k1;
                        ai[1] = ai[1] - j1;
                    }
                    flag = true;
                } else
                {
                    flag = flag1;
                    if (ai != null)
                    {
                        ai[0] = 0;
                        ai[1] = 0;
                        return false;
                    }
                }
            }
        }
        return flag;
    }

    public boolean a(int i, int k, int ai[], int ai1[])
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!b()) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (d == null) goto _L2; else goto _L3
_L3:
        if (i == 0 && k == 0) goto _L5; else goto _L4
_L4:
        int ai2[];
        int l;
        int i1;
        if (ai1 != null)
        {
            c.getLocationInWindow(ai1);
            i1 = ai1[0];
            l = ai1[1];
        } else
        {
            l = 0;
            i1 = 0;
        }
        ai2 = ai;
        if (ai == null)
        {
            if (f == null)
            {
                f = new int[2];
            }
            ai2 = f;
        }
        ai2[0] = 0;
        ai2[1] = 0;
        cs.a(d, c, i, k, ai2);
        if (ai1 != null)
        {
            c.getLocationInWindow(ai1);
            ai1[0] = ai1[0] - i1;
            ai1[1] = ai1[1] - l;
        }
        if (ai2[0] != 0) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (ai2[1] == 0) goto _L2; else goto _L7
_L7:
        flag = true;
_L2:
        return flag;
_L5:
        flag = flag1;
        if (ai1 != null)
        {
            ai1[0] = 0;
            ai1[1] = 0;
            return false;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public boolean b()
    {
        return e;
    }

    public boolean c()
    {
        return d != null;
    }

    public void d()
    {
        if (d != null)
        {
            cs.a(d, c);
            d = null;
        }
    }
}
