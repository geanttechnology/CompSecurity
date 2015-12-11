// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.u;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            k, m, b

private static class c
    implements c
{

    private final WeakReference a;
    private final b b;
    private final int c;

    public void a(ConnectionResult connectionresult)
    {
        k k1;
        boolean flag = false;
        k1 = (k)a.get();
        if (k1 == null)
        {
            return;
        }
        if (Looper.myLooper() == k.b(k1).b())
        {
            flag = true;
        }
        u.a(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        k.a(k1).lock();
        boolean flag1 = k.a(k1, 0);
        if (!flag1)
        {
            k.a(k1).unlock();
            return;
        }
        if (!connectionresult.b())
        {
            k.a(k1, connectionresult, b, c);
        }
        if (k.f(k1))
        {
            k.g(k1);
        }
        k.a(k1).unlock();
        return;
        connectionresult;
        k.a(k1).unlock();
        throw connectionresult;
    }

    public void b(ConnectionResult connectionresult)
    {
        k k1;
        boolean flag = true;
        k1 = (k)a.get();
        if (k1 == null)
        {
            return;
        }
        if (Looper.myLooper() != k.b(k1).b())
        {
            flag = false;
        }
        u.a(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
        k.a(k1).lock();
        flag = k.a(k1, 1);
        if (!flag)
        {
            k.a(k1).unlock();
            return;
        }
        if (!connectionresult.b())
        {
            k.a(k1, connectionresult, b, c);
        }
        if (k.f(k1))
        {
            k.h(k1);
        }
        k.a(k1).unlock();
        return;
        connectionresult;
        k.a(k1).unlock();
        throw connectionresult;
    }

    public onResult(k k1, b b1, int i)
    {
        a = new WeakReference(k1);
        b = b1;
        c = i;
    }
}
