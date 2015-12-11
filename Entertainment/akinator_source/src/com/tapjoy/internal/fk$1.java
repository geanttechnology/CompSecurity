// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.TimingLogger;
import com.threatmetrix.TrustDefenderMobile.NativeGatherer;
import java.util.concurrent.CountDownLatch;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.tapjoy.internal:
//            en, fk, em, fn, 
//            ff

final class nit> extends en
{

    final Context a;
    final boolean b;
    final fk c;

    public final void run()
    {
        fk.f();
        fk.a(c).a(a, b, 0);
        if (fk.b(c) != null)
        {
            fk.b(c).addSplit("init - initJSExecutor");
        }
        Object obj = fk.a(c).a();
        if (fk.b(c) != null)
        {
            fk.b(c).addSplit("getUserAgent");
        }
        if (c.b == null)
        {
            c.b = AndroidHttpClient.newInstance(((String) (obj)), fk.c(c));
            obj = c.b.getParams();
            HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), fk.d(c));
            HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), fk.d(c));
            fn.a(a, c.b, fk.d(c));
            HttpConnectionParams.setTcpNoDelay(((org.apache.http.params.HttpParams) (obj)), true);
            HttpConnectionParams.setStaleCheckingEnabled(((org.apache.http.params.HttpParams) (obj)), false);
        }
        if (fk.b(c) != null)
        {
            fk.b(c).addSplit("create AndroidHttpClient");
        }
        NativeGatherer.a.a();
        ff.b(null);
        if (fk.e(c) != null)
        {
            fk.e(c).countDown();
        }
        return;
        Exception exception;
        exception;
        if (fk.e(c) != null)
        {
            fk.e(c).countDown();
        }
        throw exception;
    }

    tDownLatch(fk fk1, fk fk2, Context context, boolean flag)
    {
        c = fk1;
        a = context;
        b = flag;
        super(fk2);
    }
}
