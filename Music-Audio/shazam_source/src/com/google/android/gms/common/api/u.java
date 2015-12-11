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
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            c

public final class u extends Fragment
    implements android.content.DialogInterface.OnCancelListener
{
    private final class a
        implements c.c
    {

        public final int a;
        public final c b;
        public final c.c c;
        final u d;

        public final void a(ConnectionResult connectionresult)
        {
            u.e(d).post(d. new b(a, connectionresult));
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

    private final class b
        implements Runnable
    {

        final u a;
        private final int b;
        private final ConnectionResult c;

        public final void run()
        {
            if (!u.a(a) || u.b(a))
            {
                return;
            }
            u.c(a);
            u.a(a, b);
            u.a(a, c);
            if (c.a())
            {
                try
                {
                    int j = a.getActivity().getSupportFragmentManager().f().indexOf(a);
                    c.a(a.getActivity(), (j + 1 << 16) + 1);
                    return;
                }
                catch (android.content.IntentSender.SendIntentException sendintentexception)
                {
                    u.d(a);
                }
                return;
            }
            if (GooglePlayServicesUtil.isUserRecoverableError(c.c))
            {
                GooglePlayServicesUtil.showErrorDialogFragment(c.c, a.getActivity(), a, 2, a);
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


    boolean a;
    boolean b;
    final SparseArray c = new SparseArray();
    private int d;
    private ConnectionResult e;
    private final Handler f = new Handler(Looper.getMainLooper());

    public u()
    {
        d = -1;
    }

    static int a(u u1, int j)
    {
        u1.d = j;
        return j;
    }

    static ConnectionResult a(u u1, ConnectionResult connectionresult)
    {
        u1.e = connectionresult;
        return connectionresult;
    }

    public static u a(i j)
    {
label0:
        {
            w.b("Must be called from main thread of process");
            j = j.getSupportFragmentManager();
            u u1;
            try
            {
                u1 = (u)j.a("GmsSupportLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (i j)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", j);
            }
            if (u1 != null)
            {
                j = u1;
                if (!u1.isRemoving())
                {
                    break label0;
                }
            }
            j = null;
        }
        return j;
    }

    private void a()
    {
        b = false;
        d = -1;
        e = null;
        for (int j = 0; j < c.size(); j++)
        {
            ((a)c.valueAt(j)).b.b();
        }

    }

    private void a(int j, ConnectionResult connectionresult)
    {
        Object obj = (a)c.get(j);
        if (obj != null)
        {
            a a1 = (a)c.get(j);
            c.remove(j);
            if (a1 != null)
            {
                a1.b.b(a1);
                a1.b.c();
            }
            obj = ((a) (obj)).c;
            if (obj != null)
            {
                ((c.c) (obj)).a(connectionresult);
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

    public static u b(i j)
    {
        u u1 = a(j);
        k k1 = j.getSupportFragmentManager();
        j = u1;
        if (u1 == null)
        {
            j = new u();
            k1.a().a(j, "GmsSupportLifecycleFragment").b();
            k1.b();
        }
        return j;
    }

    static boolean b(u u1)
    {
        return u1.b;
    }

    static boolean c(u u1)
    {
        u1.b = true;
        return true;
    }

    static void d(u u1)
    {
        u1.a();
    }

    static Handler e(u u1)
    {
        return u1.f;
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.dump(s, filedescriptor, printwriter, as);
        for (int j = 0; j < c.size(); j++)
        {
            filedescriptor = (a)c.valueAt(j);
            printwriter.append(s).append("GoogleApiClient #").print(((a) (filedescriptor)).a);
            printwriter.println(":");
            ((a) (filedescriptor)).b.a((new StringBuilder()).append(s).append("  ").toString(), printwriter);
        }

    }

    public final void onActivityResult(int j, int l, Intent intent)
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
            a(d, e);
            return;
        }
_L3:
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) goto _L1; else goto _L4
_L4:
        j = ((flag) ? 1 : 0);
          goto _L5
_L2:
        if (l != -1) goto _L1; else goto _L6
_L6:
        j = ((flag) ? 1 : 0);
          goto _L5
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        a(d, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            b = bundle.getBoolean("resolving_error", false);
            d = bundle.getInt("failed_client_id", -1);
            if (d >= 0)
            {
                e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", b);
        if (d >= 0)
        {
            bundle.putInt("failed_client_id", d);
            bundle.putInt("failed_status", e.c);
            bundle.putParcelable("failed_resolution", e.d);
        }
    }

    public final void onStart()
    {
        super.onStart();
        a = true;
        if (!b)
        {
            for (int j = 0; j < c.size(); j++)
            {
                ((a)c.valueAt(j)).b.b();
            }

        }
    }

    public final void onStop()
    {
        super.onStop();
        a = false;
        for (int j = 0; j < c.size(); j++)
        {
            ((a)c.valueAt(j)).b.c();
        }

    }
}
