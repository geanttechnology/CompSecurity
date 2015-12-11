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
import android.support.v4.app.f;
import android.support.v4.app.h;
import android.support.v4.app.l;
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

public class zzm extends Fragment
    implements android.content.DialogInterface.OnCancelListener, TraceFieldInterface
{
    private class a
        implements d.d
    {

        public final int a;
        public final d b;
        public final d.d c;
        final zzm d;

        public void a()
        {
            b.b(this);
            b.d();
        }

        public void a(ConnectionResult connectionresult)
        {
            zzm.d(d).post(d. new b(a, connectionresult));
        }

        public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
        {
            printwriter.append(s).append("GoogleApiClient #").print(a);
            printwriter.println(":");
            b.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }

        public a(int i, d d1, d.d d2)
        {
            d = zzm.this;
            super();
            a = i;
            b = d1;
            c = d2;
            d1.a(this);
        }
    }

    private class b
        implements Runnable
    {

        final zzm a;
        private final int b;
        private final ConnectionResult c;

        public void run()
        {
            if (!zzm.a(a) || zzm.b(a))
            {
                return;
            }
            zzm.a(a, true);
            zzm.a(a, b);
            zzm.a(a, c);
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
                    zzm.c(a);
                }
                return;
            }
            if (com.google.android.gms.common.e.b(c.c()))
            {
                com.google.android.gms.common.e.a(c.c(), a.getActivity(), a, 2, a);
                return;
            } else
            {
                zzm.a(a, b, c);
                return;
            }
        }

        public b(int i, ConnectionResult connectionresult)
        {
            a = zzm.this;
            super();
            b = i;
            c = connectionresult;
        }
    }


    private boolean a;
    private boolean b;
    private int c;
    private ConnectionResult d;
    private final Handler e = new Handler(Looper.getMainLooper());
    private final SparseArray f = new SparseArray();

    public zzm()
    {
        c = -1;
    }

    static int a(zzm zzm1, int i)
    {
        zzm1.c = i;
        return i;
    }

    static ConnectionResult a(zzm zzm1, ConnectionResult connectionresult)
    {
        zzm1.d = connectionresult;
        return connectionresult;
    }

    public static zzm a(f f1)
    {
label0:
        {
            u.b("Must be called from main thread of process");
            h h1 = f1.f();
            zzm zzm1;
            try
            {
                zzm1 = (zzm)h1.a("GmsSupportLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (f f1)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", f1);
            }
            if (zzm1 != null)
            {
                f1 = zzm1;
                if (!zzm1.isRemoving())
                {
                    break label0;
                }
            }
            f1 = new zzm();
            h1.a().a(f1, "GmsSupportLifecycleFragment").a();
            h1.b();
        }
        return f1;
    }

    private void a()
    {
        b = false;
        c = -1;
        d = null;
        for (int i = 0; i < f.size(); i++)
        {
            ((a)f.valueAt(i)).b.c();
        }

    }

    private void a(int i, ConnectionResult connectionresult)
    {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (a)f.get(i);
        if (obj != null)
        {
            a(i);
            obj = ((a) (obj)).c;
            if (obj != null)
            {
                ((d.d) (obj)).a(connectionresult);
            }
        }
        a();
    }

    static void a(zzm zzm1, int i, ConnectionResult connectionresult)
    {
        zzm1.a(i, connectionresult);
    }

    static boolean a(zzm zzm1)
    {
        return zzm1.a;
    }

    static boolean a(zzm zzm1, boolean flag)
    {
        zzm1.b = flag;
        return flag;
    }

    static boolean b(zzm zzm1)
    {
        return zzm1.b;
    }

    static void c(zzm zzm1)
    {
        zzm1.a();
    }

    static Handler d(zzm zzm1)
    {
        return zzm1.e;
    }

    public void a(int i)
    {
        a a1 = (a)f.get(i);
        f.remove(i);
        if (a1 != null)
        {
            a1.a();
        }
    }

    public void a(int i, d d1, d.d d2)
    {
        u.a(d1, "GoogleApiClient instance cannot be null");
        boolean flag;
        if (f.indexOfKey(i) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.a(flag, (new StringBuilder()).append("Already managing a GoogleApiClient with id ").append(i).toString());
        d2 = new a(i, d1, d2);
        f.put(i, d2);
        if (a && !b)
        {
            d1.c();
        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.dump(s, filedescriptor, printwriter, as);
        for (int i = 0; i < f.size(); i++)
        {
            ((a)f.valueAt(i)).a(s, filedescriptor, printwriter, as);
        }

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
            a(c, d);
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

    public void onCancel(DialogInterface dialoginterface)
    {
        a(c, new ConnectionResult(13, null));
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("zzm");
        TraceMachine.enterMethod(_nr_trace, "zzm#onCreate", null);
_L1:
        super.onCreate(bundle);
        if (bundle != null)
        {
            b = bundle.getBoolean("resolving_error", false);
            c = bundle.getInt("failed_client_id", -1);
            if (c >= 0)
            {
                d = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "zzm#onCreate", null);
          goto _L1
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", b);
        if (c >= 0)
        {
            bundle.putInt("failed_client_id", c);
            bundle.putInt("failed_status", d.c());
            bundle.putParcelable("failed_resolution", d.d());
        }
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        a = true;
        if (!b)
        {
            for (int i = 0; i < f.size(); i++)
            {
                ((a)f.valueAt(i)).b.c();
            }

        }
    }

    public void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        a = false;
        for (int i = 0; i < f.size(); i++)
        {
            ((a)f.valueAt(i)).b.d();
        }

    }
}
