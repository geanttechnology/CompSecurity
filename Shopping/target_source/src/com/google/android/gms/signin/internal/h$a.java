// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.b.dx;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.signin.internal:
//            h, f, CheckServerAuthResult

private static class b extends b
{

    private final dx a;
    private final ExecutorService b;

    private com.google.android.gms.common.api..h.a a()
        throws RemoteException
    {
        return a.d();
    }

    static com.google.android.gms.common.api..h.a a(a a1)
        throws RemoteException
    {
        return a1.a();
    }

    public void a(String s, String s1, f f)
        throws RemoteException
    {
        b.submit(new Runnable(s, s1, f) {

            final String a;
            final String b;
            final f c;
            final h.a d;

            public void run()
            {
                try
                {
                    boolean flag = h.a.a(d).a(a, b);
                    c.a(flag);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", remoteexception);
                }
            }

            
            {
                d = h.a.this;
                a = s;
                b = s1;
                c = f1;
                super();
            }
        });
    }

    public void a(String s, List list, f f)
        throws RemoteException
    {
        b.submit(new Runnable(list, s, f) {

            final List a;
            final String b;
            final f c;
            final h.a d;

            public void run()
            {
                try
                {
                    Object obj = h.a.a(d);
                    java.util.Set set = Collections.unmodifiableSet(new HashSet(a));
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
                d = h.a.this;
                a = list;
                b = s;
                c = f1;
                super();
            }
        });
    }

    public _cls2.c(dx dx1, ExecutorService executorservice)
    {
        a = dx1;
        b = executorservice;
    }
}
