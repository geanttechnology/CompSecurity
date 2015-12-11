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
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.signin.internal:
//            f, AuthAccountResult, e, CheckServerAuthResult

public final class i extends l
    implements d
{
    private static final class a extends d.a
    {

        private final e a;
        private final ExecutorService b;

        static com.google.android.gms.common.api.c.d a(a a1)
        {
            return a1.a.e;
        }

        public final void a(String s, String s1, f f1)
        {
            b.submit(new Runnable(this, s, s1, f1) {

                final String a;
                final String b;
                final f c;
                final a d;

                public final void run()
                {
                    try
                    {
                        boolean flag = a.a(d).b();
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
                a = s;
                b = s1;
                c = f1;
                super();
            }
            });
        }

        public final void a(String s, List list, f f1)
        {
            b.submit(new Runnable(this, list, s, f1) {

                final List a;
                final String b;
                final f c;
                final a d;

                public final void run()
                {
                    try
                    {
                        Object obj = a.a(d);
                        Collections.unmodifiableSet(new HashSet(a));
                        obj = ((com.google.android.gms.common.api.c.d) (obj)).a();
                        obj = new CheckServerAuthResult(((com.google.android.gms.common.api.c.d.a) (obj)).a, ((com.google.android.gms.common.api.c.d.a) (obj)).b);
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
                b = s;
                c = f1;
                super();
            }
            });
        }

        public a(e e1, ExecutorService executorservice)
        {
            a = e1;
            b = executorservice;
        }
    }


    private final boolean a;
    private final h g;
    private final e h;
    private Integer i;
    private final ExecutorService j;

    public i(Context context, Looper looper, boolean flag, h h1, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1, ExecutorService executorservice)
    {
        super(context, looper, 44, h1, b1, c1);
        a = flag;
        g = h1;
        h = h1.g;
        i = h1.h;
        j = executorservice;
    }

    protected final IInterface a(IBinder ibinder)
    {
        return com.google.android.gms.signin.internal.f.a.a(ibinder);
    }

    protected final String a()
    {
        return "com.google.android.gms.signin.service.START";
    }

    public final void a(q q, Set set, com.google.android.gms.signin.internal.e e1)
    {
        w.a(e1, "Expecting a valid ISignInCallbacks");
        try
        {
            ((f)m()).a(new AuthAccountRequest(q, set), e1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (q q) { }
        try
        {
            e1.a(new ConnectionResult(8, null), new AuthAccountResult());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (q q)
        {
            Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
        }
    }

    public final void a(q q, boolean flag)
    {
        try
        {
            ((f)m()).a(q, i.intValue(), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (q q)
        {
            return;
        }
    }

    public final void a(u u1)
    {
        w.a(u1, "Expecting a valid IResolveAccountCallbacks");
        try
        {
            android.accounts.Account account = g.a();
            ((f)m()).a(new ResolveAccountRequest(account, i.intValue()), u1);
            return;
        }
        catch (RemoteException remoteexception) { }
        try
        {
            u1.a(new ResolveAccountResponse());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (u u1)
        {
            Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
        }
    }

    protected final String b()
    {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final void c()
    {
        try
        {
            ((f)m()).a(i.intValue());
            return;
        }
        catch (RemoteException remoteexception)
        {
            return;
        }
    }

    public final boolean f()
    {
        return a;
    }

    protected final Bundle k()
    {
        Object obj = h;
        Integer integer = g.h;
        ExecutorService executorservice = j;
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", ((e) (obj)).b);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", ((e) (obj)).c);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", ((e) (obj)).d);
        if (((e) (obj)).e != null)
        {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper((new a(((e) (obj)), executorservice)).asBinder()));
        }
        if (integer != null)
        {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", integer.intValue());
        }
        obj = g.e;
        if (!super.b.getPackageName().equals(obj))
        {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", g.e);
        }
        return bundle;
    }

    public final void p()
    {
        a(new com.google.android.gms.common.internal.l.f(this));
    }
}
