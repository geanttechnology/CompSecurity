// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.b.dw;
import com.google.android.gms.b.dx;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.u;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.signin.internal:
//            f, AuthAccountResult, e, CheckServerAuthResult

public class h extends l
    implements dw
{
    private static class a extends d.a
    {

        private final dx a;
        private final ExecutorService b;

        private com.google.android.gms.common.api.d.e a()
            throws RemoteException
        {
            return a.d();
        }

        static com.google.android.gms.common.api.d.e a(a a1)
            throws RemoteException
        {
            return a1.a();
        }

        public void a(String s1, String s2, f f1)
            throws RemoteException
        {
            b.submit(new Runnable(this, s1, s2, f1) {

                final String a;
                final String b;
                final f c;
                final a d;

                public void run()
                {
                    try
                    {
                        boolean flag = com.google.android.gms.signin.internal.a.a(d).a(a, b);
                        c.a(flag);
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", remoteexception);
                    }
                }

            
            {
                d = a1;
                a = s1;
                b = s2;
                c = f1;
                super();
            }
            });
        }

        public void a(String s1, List list, f f1)
            throws RemoteException
        {
            b.submit(new Runnable(this, list, s1, f1) {

                final List a;
                final String b;
                final f c;
                final a d;

                public void run()
                {
                    try
                    {
                        Object obj = com.google.android.gms.signin.internal.a.a(d);
                        Set set = Collections.unmodifiableSet(new HashSet(a));
                        obj = ((com.google.android.gms.common.api.d.e) (obj)).a(b, set);
                        obj = new CheckServerAuthResult(((com.google.android.gms.common.api.d.e.a) (obj)).a(), ((com.google.android.gms.common.api.d.e.a) (obj)).b());
                        c.a(((CheckServerAuthResult) (obj)));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", remoteexception);
                    }
                }

            
            {
                d = a1;
                a = list;
                b = s1;
                c = f1;
                super();
            }
            });
        }

        public a(dx dx1, ExecutorService executorservice)
        {
            a = dx1;
            b = executorservice;
        }
    }


    private final boolean d;
    private final com.google.android.gms.common.internal.h e;
    private final dx f;
    private Integer g;
    private final ExecutorService h;

    public h(Context context, Looper looper, boolean flag, com.google.android.gms.common.internal.h h1, dx dx1, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1, 
            ExecutorService executorservice)
    {
        super(context, looper, 44, b1, d1, h1);
        d = flag;
        e = h1;
        f = dx1;
        g = h1.j();
        h = executorservice;
    }

    public static Bundle a(dx dx1, Integer integer, ExecutorService executorservice)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", dx1.a());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", dx1.b());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", dx1.c());
        if (dx1.d() != null)
        {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper((new a(dx1, executorservice)).asBinder()));
        }
        if (integer != null)
        {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", integer.intValue());
        }
        return bundle;
    }

    protected IInterface a(IBinder ibinder)
    {
        return b(ibinder);
    }

    public void a(com.google.android.gms.common.internal.a a1, Set set, e e1)
    {
        u.a(e1, "Expecting a valid ISignInCallbacks");
        try
        {
            ((f)m()).a(new AuthAccountRequest(a1, set), e1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.internal.a a1)
        {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
        }
        try
        {
            e1.a(new ConnectionResult(8, null), new AuthAccountResult());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.internal.a a1)
        {
            Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
        }
    }

    public void a(com.google.android.gms.common.internal.a a1, boolean flag)
    {
        try
        {
            ((f)m()).a(a1, g.intValue(), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.internal.a a1)
        {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void a(s s1)
    {
        u.a(s1, "Expecting a valid IResolveAccountCallbacks");
        try
        {
            android.accounts.Account account = e.c();
            ((f)m()).a(new ResolveAccountRequest(account, g.intValue()), s1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
        }
        try
        {
            s1.a(new ResolveAccountResponse(8));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (s s1)
        {
            Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
        }
    }

    protected f b(IBinder ibinder)
    {
        return com.google.android.gms.signin.internal.f.a.a(ibinder);
    }

    public boolean c()
    {
        return d;
    }

    protected String d()
    {
        return "com.google.android.gms.signin.service.START";
    }

    public void d_()
    {
        try
        {
            ((f)m()).a(g.intValue());
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    protected String e()
    {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public void g()
    {
        a(new com.google.android.gms.common.internal.l.f(this));
    }

    protected Bundle k()
    {
        Bundle bundle = a(f, e.j(), h);
        String s1 = e.g();
        if (!i().getPackageName().equals(s1))
        {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", e.g());
        }
        return bundle;
    }
}
