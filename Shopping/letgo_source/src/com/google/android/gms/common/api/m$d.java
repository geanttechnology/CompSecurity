// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            m, o, a

private static class c
    implements c
{

    private final WeakReference a;
    private final a b;
    private final int c;

    public void a(ConnectionResult connectionresult)
    {
        m m1;
        boolean flag = false;
        m1 = (m)a.get();
        if (m1 == null)
        {
            return;
        }
        if (Looper.myLooper() == m.d(m1).a())
        {
            flag = true;
        }
        x.a(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        m.c(m1).lock();
        boolean flag1 = m.a(m1, 0);
        if (!flag1)
        {
            m.c(m1).unlock();
            return;
        }
        if (!connectionresult.b())
        {
            m.a(m1, connectionresult, b, c);
        }
        if (m.k(m1))
        {
            m.l(m1);
        }
        m.c(m1).unlock();
        return;
        connectionresult;
        m.c(m1).unlock();
        throw connectionresult;
    }

    public void b(ConnectionResult connectionresult)
    {
        m m1;
        boolean flag = true;
        m1 = (m)a.get();
        if (m1 == null)
        {
            return;
        }
        if (Looper.myLooper() != m.d(m1).a())
        {
            flag = false;
        }
        x.a(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
        m.c(m1).lock();
        flag = m.a(m1, 1);
        if (!flag)
        {
            m.c(m1).unlock();
            return;
        }
        if (!connectionresult.b())
        {
            m.a(m1, connectionresult, b, c);
        }
        if (m.k(m1))
        {
            m.m(m1);
        }
        m.c(m1).unlock();
        return;
        connectionresult;
        m.c(m1).unlock();
        throw connectionresult;
    }

    public onResult(m m1, a a1, int i)
    {
        a = new WeakReference(m1);
        b = a1;
        c = i;
    }
}
