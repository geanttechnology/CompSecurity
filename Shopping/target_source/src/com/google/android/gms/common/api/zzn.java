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
import android.support.v4.a.g;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.support.v4.app.h;
import android.support.v4.app.l;
import android.support.v4.app.n;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.u;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            d

public class zzn extends Fragment
    implements android.content.DialogInterface.OnCancelListener, android.support.v4.app.n.a, TraceFieldInterface
{
    static class a extends g
        implements d.b, d.d
    {

        public final d i;
        private boolean j;
        private ConnectionResult k;

        private void b(ConnectionResult connectionresult)
        {
            k = connectionresult;
            if (b() && !c())
            {
                a(connectionresult);
            }
        }

        public void a(int i1)
        {
        }

        public void a(Bundle bundle)
        {
            j = false;
            b(ConnectionResult.a);
        }

        public void a(ConnectionResult connectionresult)
        {
            j = true;
            b(connectionresult);
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
            if (!i.e() && !i.f() && !j)
            {
                i.c();
            }
        }

        protected void g()
        {
            i.d();
        }

        protected void k()
        {
            k = null;
            j = false;
            i.b(this);
            i.b(this);
            i.d();
        }

        public boolean l()
        {
            return j;
        }

        public a(Context context, d d1)
        {
            super(context);
            i = d1;
        }
    }

    private static class b
    {

        public final d a;
        public final d.d b;

        private b(d d1, d.d d2)
        {
            a = d1;
            b = d2;
        }

    }

    private class c
        implements Runnable
    {

        final zzn a;
        private final int b;
        private final ConnectionResult c;

        public void run()
        {
            if (c.a())
            {
                try
                {
                    int i = a.getActivity().f().f().indexOf(a);
                    c.a(a.getActivity(), (i + 1 << 16) + 1);
                    return;
                }
                catch (android.content.IntentSender.SendIntentException sendintentexception)
                {
                    zzn.a(a);
                }
                return;
            }
            if (com.google.android.gms.common.e.b(c.c()))
            {
                com.google.android.gms.common.e.a(c.c(), a.getActivity(), a, 2, a);
                return;
            } else
            {
                zzn.a(a, b, c);
                return;
            }
        }

        public c(int i, ConnectionResult connectionresult)
        {
            a = zzn.this;
            super();
            b = i;
            c = connectionresult;
        }
    }


    private boolean a;
    private int b;
    private ConnectionResult c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final SparseArray e = new SparseArray();

    public zzn()
    {
        b = -1;
    }

    public static zzn a(f f1)
    {
label0:
        {
            u.b("Must be called from main thread of process");
            h h1 = f1.f();
            zzn zzn1;
            try
            {
                zzn1 = (zzn)h1.a("GmsSupportLoaderLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (f f1)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", f1);
            }
            if (zzn1 != null)
            {
                f1 = zzn1;
                if (!zzn1.isRemoving())
                {
                    break label0;
                }
            }
            f1 = new zzn();
            h1.a().a(f1, "GmsSupportLoaderLifecycleFragment").a();
            h1.b();
        }
        return f1;
    }

    private void a()
    {
        int i = 0;
        a = false;
        b = -1;
        c = null;
        n n1 = getLoaderManager();
        for (; i < e.size(); i++)
        {
            int j = e.keyAt(i);
            a a1 = c(j);
            if (a1 != null && a1.l())
            {
                n1.a(j);
                n1.a(j, null, this);
            }
        }

    }

    private void a(int i, ConnectionResult connectionresult)
    {
        if (!a)
        {
            a = true;
            b = i;
            c = connectionresult;
            d.post(new c(i, connectionresult));
        }
    }

    static void a(zzn zzn1)
    {
        zzn1.a();
    }

    static void a(zzn zzn1, int i, ConnectionResult connectionresult)
    {
        zzn1.b(i, connectionresult);
    }

    private void b(int i, ConnectionResult connectionresult)
    {
        Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (b)e.get(i);
        if (obj != null)
        {
            b(i);
            obj = ((b) (obj)).b;
            if (obj != null)
            {
                ((d.d) (obj)).a(connectionresult);
            }
        }
        a();
    }

    public g a(int i, Bundle bundle)
    {
        return new a(getActivity(), ((b)e.get(i)).a);
    }

    public d a(int i)
    {
        if (getActivity() != null)
        {
            a a1 = c(i);
            if (a1 != null)
            {
                return a1.i;
            }
        }
        return null;
    }

    public void a(int i, d d1, d.d d2)
    {
        u.a(d1, "GoogleApiClient instance cannot be null");
        boolean flag;
        if (e.indexOfKey(i) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.a(flag, (new StringBuilder()).append("Already managing a GoogleApiClient with id ").append(i).toString());
        d1 = new b(d1, d2);
        e.put(i, d1);
        if (getActivity() != null)
        {
            n.a(false);
            getLoaderManager().a(i, null, this);
        }
    }

    public void a(g g1)
    {
    }

    public void a(g g1, ConnectionResult connectionresult)
    {
        if (!connectionresult.b())
        {
            a(g1.a(), connectionresult);
        }
    }

    public void a(g g1, Object obj)
    {
        a(g1, (ConnectionResult)obj);
    }

    public void b(int i)
    {
        e.remove(i);
        getLoaderManager().a(i);
    }

    a c(int i)
    {
        a a1;
        try
        {
            a1 = (a)getLoaderManager().b(i);
        }
        catch (ClassCastException classcastexception)
        {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", classcastexception);
        }
        return a1;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 55
    //                   2 39;
           goto _L1 _L2 _L3
_L1:
        i = 0;
_L5:
        if (i != 0)
        {
            a();
            return;
        } else
        {
            b(b, c);
            return;
        }
_L3:
        if (com.google.android.gms.common.e.a(getActivity()) != 0) goto _L1; else goto _L4
_L4:
        i = ((flag) ? 1 : 0);
          goto _L5
_L2:
        if (j != -1) goto _L1; else goto _L6
_L6:
        i = ((flag) ? 1 : 0);
          goto _L5
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        int i = 0;
        while (i < e.size()) 
        {
            int j = e.keyAt(i);
            activity = c(j);
            if (activity != null && ((b)e.valueAt(i)).a != ((a) (activity)).i)
            {
                getLoaderManager().b(j, null, this);
            } else
            {
                getLoaderManager().a(j, null, this);
            }
            i++;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        b(b, new ConnectionResult(13, null));
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("zzn");
        TraceMachine.enterMethod(_nr_trace, "zzn#onCreate", null);
_L1:
        super.onCreate(bundle);
        if (bundle != null)
        {
            a = bundle.getBoolean("resolving_error", false);
            b = bundle.getInt("failed_client_id", -1);
            if (b >= 0)
            {
                c = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "zzn#onCreate", null);
          goto _L1
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", a);
        if (b >= 0)
        {
            bundle.putInt("failed_client_id", b);
            bundle.putInt("failed_status", c.c());
            bundle.putParcelable("failed_resolution", c.d());
        }
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        if (!a)
        {
            for (int i = 0; i < e.size(); i++)
            {
                getLoaderManager().a(e.keyAt(i), null, this);
            }

        }
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
