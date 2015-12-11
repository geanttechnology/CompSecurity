// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.x;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            c

public class u extends Fragment
    implements android.content.DialogInterface.OnCancelListener, TraceFieldInterface
{
    private class a
        implements c.c
    {

        public final int a;
        public final c b;
        public final c.c c;
        final u d;

        public void a()
        {
            b.b(this);
            b.c();
        }

        public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
        {
            printwriter.append(s).append("GoogleApiClient #").print(a);
            printwriter.println(":");
            b.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            u.d(d).post(d. new b(a, connectionresult));
        }

        public a(int j, c c1, c.c c2)
        {
            d = u.this;
            super();
            a = j;
            b = c1;
            c = c2;
            c1.a(this);
        }
    }

    private class b
        implements Runnable
    {

        final u a;
        private final int b;
        private final ConnectionResult c;

        public void run()
        {
            if (!u.a(a) || u.b(a))
            {
                return;
            }
            u.a(a, true);
            u.a(a, b);
            u.a(a, c);
            if (c.a())
            {
                try
                {
                    int j = a.j().f().c().indexOf(a);
                    c.a(a.j(), (j + 1 << 16) + 1);
                    return;
                }
                catch (android.content.IntentSender.SendIntentException sendintentexception)
                {
                    u.c(a);
                }
                return;
            }
            if (GooglePlayServicesUtil.isUserRecoverableError(c.c()))
            {
                GooglePlayServicesUtil.showErrorDialogFragment(c.c(), a.j(), a, 2, a);
                return;
            } else
            {
                u.a(a, b, c);
                return;
            }
        }

        public b(int j, ConnectionResult connectionresult)
        {
            a = u.this;
            super();
            b = j;
            c = connectionresult;
        }
    }


    private boolean a;
    private boolean b;
    private int c;
    private ConnectionResult d;
    private final Handler e = new Handler(Looper.getMainLooper());
    private final SparseArray f = new SparseArray();

    public u()
    {
        c = -1;
    }

    static int a(u u1, int j)
    {
        u1.c = j;
        return j;
    }

    static ConnectionResult a(u u1, ConnectionResult connectionresult)
    {
        u1.d = connectionresult;
        return connectionresult;
    }

    public static u a(g g1)
    {
label0:
        {
            x.b("Must be called from main thread of process");
            g1 = g1.f();
            u u1;
            try
            {
                u1 = (u)g1.a("GmsSupportLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (g g1)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", g1);
            }
            if (u1 != null)
            {
                g1 = u1;
                if (!u1.o())
                {
                    break label0;
                }
            }
            g1 = null;
        }
        return g1;
    }

    private void a()
    {
        b = false;
        c = -1;
        d = null;
        for (int j = 0; j < f.size(); j++)
        {
            ((a)f.valueAt(j)).b.b();
        }

    }

    private void a(int j, ConnectionResult connectionresult)
    {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (a)f.get(j);
        if (obj != null)
        {
            b(j);
            obj = ((a) (obj)).c;
            if (obj != null)
            {
                ((c.c) (obj)).onConnectionFailed(connectionresult);
            }
        }
        a();
    }

    static void a(u u1, int j, ConnectionResult connectionresult)
    {
        u1.a(j, connectionresult);
    }

    static boolean a(u u1)
    {
        return u1.a;
    }

    static boolean a(u u1, boolean flag)
    {
        u1.b = flag;
        return flag;
    }

    public static u b(g g1)
    {
        u u1 = a(g1);
        i j = g1.f();
        g1 = u1;
        if (u1 == null)
        {
            g1 = new u();
            j.a().a(g1, "GmsSupportLifecycleFragment").b();
            j.b();
        }
        return g1;
    }

    static boolean b(u u1)
    {
        return u1.b;
    }

    static void c(u u1)
    {
        u1.a();
    }

    static Handler d(u u1)
    {
        return u1.e;
    }

    public void a(int j, int k, Intent intent)
    {
        boolean flag = true;
        j;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 55
    //                   2 39;
           goto _L1 _L2 _L3
_L1:
        j = 0;
_L5:
        if (j != 0)
        {
            a();
            return;
        } else
        {
            a(c, d);
            return;
        }
_L3:
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(j()) != 0) goto _L1; else goto _L4
_L4:
        j = ((flag) ? 1 : 0);
          goto _L5
_L2:
        if (k != -1) goto _L1; else goto _L6
_L6:
        j = ((flag) ? 1 : 0);
          goto _L5
    }

    public void a(int j, c c1, c.c c2)
    {
        x.a(c1, "GoogleApiClient instance cannot be null");
        boolean flag;
        if (f.indexOfKey(j) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.a(flag, (new StringBuilder()).append("Already managing a GoogleApiClient with id ").append(j).toString());
        c2 = new a(j, c1, c2);
        f.put(j, c2);
        if (a && !b)
        {
            c1.b();
        }
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        if (bundle != null)
        {
            b = bundle.getBoolean("resolving_error", false);
            c = bundle.getInt("failed_client_id", -1);
            if (c >= 0)
            {
                d = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.a(s, filedescriptor, printwriter, as);
        for (int j = 0; j < f.size(); j++)
        {
            ((a)f.valueAt(j)).a(s, filedescriptor, printwriter, as);
        }

    }

    public void b(int j)
    {
        a a1 = (a)f.get(j);
        f.remove(j);
        if (a1 != null)
        {
            a1.a();
        }
    }

    public void e()
    {
        super.e();
        a = true;
        if (!b)
        {
            for (int j = 0; j < f.size(); j++)
            {
                ((a)f.valueAt(j)).b.b();
            }

        }
    }

    public void e(Bundle bundle)
    {
        super.e(bundle);
        bundle.putBoolean("resolving_error", b);
        if (c >= 0)
        {
            bundle.putInt("failed_client_id", c);
            bundle.putInt("failed_status", d.c());
            bundle.putParcelable("failed_resolution", d.d());
        }
    }

    public void f()
    {
        super.f();
        a = false;
        for (int j = 0; j < f.size(); j++)
        {
            ((a)f.valueAt(j)).b.c();
        }

    }

    public void onCancel(DialogInterface dialoginterface)
    {
        a(c, new ConnectionResult(13, null));
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
