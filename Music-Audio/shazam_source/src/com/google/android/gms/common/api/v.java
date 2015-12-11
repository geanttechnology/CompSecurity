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
import android.support.v4.a.d;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.support.v4.app.o;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            c

public final class v extends Fragment
    implements android.content.DialogInterface.OnCancelListener, android.support.v4.app.o.a
{
    static final class a extends d
        implements c.b, c.c
    {

        public final com.google.android.gms.common.api.c a;
        boolean b;
        private ConnectionResult c;

        private void b(ConnectionResult connectionresult)
        {
            c = connectionresult;
            if (super.i && !super.j)
            {
                a(connectionresult);
            }
        }

        public final void a(int j)
        {
        }

        public final void a(Bundle bundle)
        {
            b = false;
            b(ConnectionResult.a);
        }

        public final void a(ConnectionResult connectionresult)
        {
            b = true;
            b(connectionresult);
        }

        public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
        {
            super.a(s, filedescriptor, printwriter, as);
            a.a(s, printwriter);
        }

        protected final void d()
        {
            super.d();
            a.a(this);
            a.a(this);
            if (c != null)
            {
                a(c);
            }
            if (!a.d() && !a.e() && !b)
            {
                a.b();
            }
        }

        protected final void f()
        {
            a.c();
        }

        protected final void g()
        {
            c = null;
            b = false;
            a.b(this);
            a.b(this);
            a.c();
        }

        public a(Context context, com.google.android.gms.common.api.c c1)
        {
            super(context);
            a = c1;
        }
    }

    private static final class b
    {

        public final com.google.android.gms.common.api.c a;
        public final c.c b;

        private b(com.google.android.gms.common.api.c c1, c.c c2)
        {
            a = c1;
            b = c2;
        }

        b(com.google.android.gms.common.api.c c1, c.c c2, byte byte0)
        {
            this(c1, c2);
        }
    }

    private final class c
        implements Runnable
    {

        final v a;
        private final int b;
        private final ConnectionResult c;

        public final void run()
        {
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
                    v.a(a);
                }
                return;
            }
            if (GooglePlayServicesUtil.isUserRecoverableError(c.c))
            {
                GooglePlayServicesUtil.showErrorDialogFragment(c.c, a.getActivity(), a, 2, a);
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


    final SparseArray a = new SparseArray();
    private boolean b;
    private int c;
    private ConnectionResult d;
    private final Handler e = new Handler(Looper.getMainLooper());

    public v()
    {
        c = -1;
    }

    public static v a(i j)
    {
label0:
        {
            w.b("Must be called from main thread of process");
            k k1 = j.getSupportFragmentManager();
            v v1;
            try
            {
                v1 = (v)k1.a("GmsSupportLoaderLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (i j)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", j);
            }
            if (v1 != null)
            {
                j = v1;
                if (!v1.isRemoving())
                {
                    break label0;
                }
            }
            j = new v();
            k1.a().a(j, "GmsSupportLoaderLifecycleFragment").a();
            k1.b();
        }
        return j;
    }

    private void a()
    {
        int j = 0;
        b = false;
        c = -1;
        d = null;
        o o1 = getLoaderManager();
        for (; j < a.size(); j++)
        {
            int l = a.keyAt(j);
            a a1 = b(l);
            if (a1 != null && a1.b)
            {
                o1.a(l);
                o1.a(l, this);
            }
        }

    }

    private void a(int j, ConnectionResult connectionresult)
    {
        Object obj = (b)a.get(j);
        if (obj != null)
        {
            a.remove(j);
            getLoaderManager().a(j);
            obj = ((b) (obj)).b;
            if (obj != null)
            {
                ((c.c) (obj)).a(connectionresult);
            }
        }
        a();
    }

    static void a(v v1)
    {
        v1.a();
    }

    static void a(v v1, int j, ConnectionResult connectionresult)
    {
        v1.a(j, connectionresult);
    }

    public final d a(int j)
    {
        return new a(getActivity(), ((b)a.get(j)).a);
    }

    public final void a(d d1, Object obj)
    {
        obj = (ConnectionResult)obj;
        if (!((ConnectionResult) (obj)).b())
        {
            int j = d1.f;
            if (!b)
            {
                b = true;
                c = j;
                d = ((ConnectionResult) (obj));
                e.post(new c(j, ((ConnectionResult) (obj))));
            }
        }
    }

    final a b(int j)
    {
        a a1;
        try
        {
            a1 = (a)getLoaderManager().b(j);
        }
        catch (ClassCastException classcastexception)
        {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", classcastexception);
        }
        return a1;
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
            a(c, d);
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

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        int j = 0;
        while (j < a.size()) 
        {
            int l = a.keyAt(j);
            activity = b(l);
            if (activity != null && ((b)a.valueAt(j)).a != ((a) (activity)).a)
            {
                getLoaderManager().b(l, this);
            } else
            {
                getLoaderManager().a(l, this);
            }
            j++;
        }
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        a(c, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle)
    {
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
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", b);
        if (c >= 0)
        {
            bundle.putInt("failed_client_id", c);
            bundle.putInt("failed_status", d.c);
            bundle.putParcelable("failed_resolution", d.d);
        }
    }

    public final void onStart()
    {
        super.onStart();
        if (!b)
        {
            for (int j = 0; j < a.size(); j++)
            {
                getLoaderManager().a(a.keyAt(j), this);
            }

        }
    }
}
