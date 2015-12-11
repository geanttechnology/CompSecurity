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
import com.google.android.gms.common.internal.x;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.signin.internal:
//            f, AuthAccountResult, e, CheckServerAuthResult

public class i extends l
    implements d
{
    private static class a extends d.a
    {

        private final e a;
        private final ExecutorService b;

        private com.google.android.gms.common.api.c.d a()
            throws RemoteException
        {
            return a.d();
        }

        static com.google.android.gms.common.api.c.d a(a a1)
            throws RemoteException
        {
            return a1.a();
        }

        public void a(String s, String s1, f f1)
            throws RemoteException
        {
            b.submit(new Runnable(this, s, s1, f1) {

                final String a;
                final String b;
                final f c;
                final a d;

                public void run()
                {
                    try
                    {
                        boolean flag = a.a(d).a(a, b);
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

        public void a(String s, List list, f f1)
            throws RemoteException
        {
            b.submit(new Runnable(this, list, s, f1) {

                final List a;
                final String b;
                final f c;
                final a d;

                public void run()
                {
                    try
                    {
                        Object obj = a.a(d);
                        Set set = Collections.unmodifiableSet(new HashSet(a));
                        obj = ((com.google.android.gms.common.api.c.d) (obj)).a(b, set);
                        obj = new CheckServerAuthResult(((com.google.android.gms.common.api.c.d.a) (obj)).a(), ((com.google.android.gms.common.api.c.d.a) (obj)).b());
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
    private final h b;
    private final e c;
    private Integer d;
    private final ExecutorService e;

    public i(Context context, Looper looper, boolean flag, h h1, e e1, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1, 
            ExecutorService executorservice)
    {
        super(context, looper, 44, h1, b1, c1);
        a = flag;
        b = h1;
        c = h1.i();
        d = h1.j();
        e = executorservice;
    }

    public static Bundle a(e e1, Integer integer, ExecutorService executorservice)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", e1.a());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", e1.b());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", e1.c());
        if (e1.d() != null)
        {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper((new a(e1, executorservice)).asBinder()));
        }
        if (integer != null)
        {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", integer.intValue());
        }
        return bundle;
    }

    protected f a(IBinder ibinder)
    {
        return f.a.a(ibinder);
    }

    public void a()
    {
        try
        {
            ((f)zzoA()).a(d.intValue());
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void a(q q, Set set, com.google.android.gms.signin.internal.e e1)
    {
        x.a(e1, "Expecting a valid ISignInCallbacks");
        try
        {
            ((f)zzoA()).a(new AuthAccountRequest(q, set), e1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (q q)
        {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
        }
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

    public void a(q q, boolean flag)
    {
        try
        {
            ((f)zzoA()).a(q, d.intValue(), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (q q)
        {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void a(u u1)
    {
        x.a(u1, "Expecting a valid IResolveAccountCallbacks");
        try
        {
            android.accounts.Account account = b.c();
            ((f)zzoA()).a(new ResolveAccountRequest(account, d.intValue()), u1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
        }
        try
        {
            u1.a(new ResolveAccountResponse(8));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (u u1)
        {
            Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
        }
    }

    public void b()
    {
        zza(new com.google.android.gms.common.internal.l.f(this));
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return a(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.signin.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected Bundle zzli()
    {
        Bundle bundle = a(c, b.j(), e);
        String s = b.g();
        if (!getContext().getPackageName().equals(s))
        {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", b.g());
        }
        return bundle;
    }

    public boolean zzlm()
    {
        return a;
    }
}
