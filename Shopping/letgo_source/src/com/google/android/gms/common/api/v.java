// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.support.v4.app.o;
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

public class v extends Fragment
    implements android.content.DialogInterface.OnCancelListener, android.support.v4.app.o.a, TraceFieldInterface
{
    static class a extends android.support.v7.o
        implements c.b, c.c
    {

        public final com.google.android.gms.common.api.c i;
        private boolean j;
        private ConnectionResult k;

        private void a(ConnectionResult connectionresult)
        {
            k = connectionresult;
            if (b() && !c())
            {
                a(connectionresult);
            }
        }

        public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
        {
            super.a(s, filedescriptor, printwriter, as);
            i.a(s, filedescriptor, printwriter, as);
        }

        protected void e()
        {
            super.e();
            i.a(this);
            i.a(this);
            if (k != null)
            {
                a(k);
            }
            if (!i.d() && !i.e() && !j)
            {
                i.b();
            }
        }

        protected void g()
        {
            i.c();
        }

        protected void k()
        {
            k = null;
            j = false;
            i.b(this);
            i.b(this);
            i.c();
        }

        public boolean l()
        {
            return j;
        }

        public void onConnected(Bundle bundle)
        {
            j = false;
            a(ConnectionResult.a);
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            j = true;
            a(connectionresult);
        }

        public void onConnectionSuspended(int i1)
        {
        }

        public a(Context context, com.google.android.gms.common.api.c c1)
        {
            super(context);
            i = c1;
        }
    }

    private static class b
    {

        public final com.google.android.gms.common.api.c a;
        public final c.c b;

        private b(com.google.android.gms.common.api.c c1, c.c c2)
        {
            a = c1;
            b = c2;
        }

    }

    private class c
        implements Runnable
    {

        final v a;
        private final int b;
        private final ConnectionResult c;

        public void run()
        {
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
                    v.a(a);
                }
                return;
            }
            if (GooglePlayServicesUtil.isUserRecoverableError(c.c()))
            {
                GooglePlayServicesUtil.showErrorDialogFragment(c.c(), a.j(), a, 2, a);
                return;
            } else
            {
                v.a(a, b, c);
                return;
            }
        }

        public c(int j, ConnectionResult connectionresult)
        {
            a = v.this;
            super();
            b = j;
            c = connectionresult;
        }
    }


    private boolean a;
    private int b;
    private ConnectionResult c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final SparseArray e = new SparseArray();

    public v()
    {
        b = -1;
    }

    public static v a(g g1)
    {
label0:
        {
            x.b("Must be called from main thread of process");
            i j = g1.f();
            v v1;
            try
            {
                v1 = (v)j.a("GmsSupportLoaderLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (g g1)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", g1);
            }
            if (v1 != null)
            {
                g1 = v1;
                if (!v1.o())
                {
                    break label0;
                }
            }
            g1 = new v();
            j.a().a(g1, "GmsSupportLoaderLifecycleFragment").a();
            j.b();
        }
        return g1;
    }

    private void a()
    {
        int j = 0;
        a = false;
        b = -1;
        c = null;
        o o1 = s();
        for (; j < e.size(); j++)
        {
            int k = e.keyAt(j);
            a a1 = d(k);
            if (a1 != null && a1.l())
            {
                o1.a(k);
                o1.a(k, null, this);
            }
        }

    }

    private void a(int j, ConnectionResult connectionresult)
    {
        if (!a)
        {
            a = true;
            b = j;
            c = connectionresult;
            d.post(new c(j, connectionresult));
        }
    }

    static void a(v v1)
    {
        v1.a();
    }

    static void a(v v1, int j, ConnectionResult connectionresult)
    {
        v1.b(j, connectionresult);
    }

    private void b(int j, ConnectionResult connectionresult)
    {
        Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (b)e.get(j);
        if (obj != null)
        {
            c(j);
            obj = ((b) (obj)).b;
            if (obj != null)
            {
                ((c.c) (obj)).onConnectionFailed(connectionresult);
            }
        }
        a();
    }

    public android.support.v7.o a(int j, Bundle bundle)
    {
        return new a(j(), ((b)e.get(j)).a);
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
            b(b, c);
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

    public void a(int j, com.google.android.gms.common.api.c c1, c.c c2)
    {
        x.a(c1, "GoogleApiClient instance cannot be null");
        boolean flag;
        if (e.indexOfKey(j) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.a(flag, (new StringBuilder()).append("Already managing a GoogleApiClient with id ").append(j).toString());
        c1 = new b(c1, c2);
        e.put(j, c1);
        if (j() != null)
        {
            o.a(false);
            s().a(j, null, this);
        }
    }

    public void a(Activity activity)
    {
        super.a(activity);
        int j = 0;
        while (j < e.size()) 
        {
            int k = e.keyAt(j);
            activity = d(k);
            if (activity != null && ((b)e.valueAt(j)).a != ((a) (activity)).i)
            {
                s().b(k, null, this);
            } else
            {
                s().a(k, null, this);
            }
            j++;
        }
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        if (bundle != null)
        {
            a = bundle.getBoolean("resolving_error", false);
            b = bundle.getInt("failed_client_id", -1);
            if (b >= 0)
            {
                c = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void a(android.support.v7.o o1)
    {
    }

    public void a(android.support.v7.o o1, ConnectionResult connectionresult)
    {
        if (!connectionresult.b())
        {
            a(o1.a(), connectionresult);
        }
    }

    public void a(android.support.v7.o o1, Object obj)
    {
        a(o1, (ConnectionResult)obj);
    }

    public com.google.android.gms.common.api.c b(int j)
    {
        if (j() != null)
        {
            a a1 = d(j);
            if (a1 != null)
            {
                return a1.i;
            }
        }
        return null;
    }

    public void c(int j)
    {
        e.remove(j);
        s().a(j);
    }

    a d(int j)
    {
        a a1;
        try
        {
            a1 = (a)s().b(j);
        }
        catch (ClassCastException classcastexception)
        {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", classcastexception);
        }
        return a1;
    }

    public void e()
    {
        super.e();
        if (!a)
        {
            for (int j = 0; j < e.size(); j++)
            {
                s().a(e.keyAt(j), null, this);
            }

        }
    }

    public void e(Bundle bundle)
    {
        super.e(bundle);
        bundle.putBoolean("resolving_error", a);
        if (b >= 0)
        {
            bundle.putInt("failed_client_id", b);
            bundle.putInt("failed_status", c.c());
            bundle.putParcelable("failed_resolution", c.d());
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        b(b, new ConnectionResult(13, null));
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
