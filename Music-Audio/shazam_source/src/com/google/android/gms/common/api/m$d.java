// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            m, o, a

private static final class c
    implements c
{

    private final WeakReference a;
    private final a b;
    private final int c;

    public final void a(ConnectionResult connectionresult)
    {
        m m1;
        boolean flag = false;
        m1 = (m)a.get();
        if (m1 == null)
        {
            return;
        }
        if (Looper.myLooper() == m1.a.e)
        {
            flag = true;
        }
        w.a(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        m1.b.lock();
        boolean flag1 = m1.b(0);
        if (!flag1)
        {
            m1.b.unlock();
            return;
        }
        if (!connectionresult.b())
        {
            m1.b(connectionresult, b, c);
        }
        if (m1.e())
        {
            m1.f();
        }
        m1.b.unlock();
        return;
        connectionresult;
        m1.b.unlock();
        throw connectionresult;
    }

    public final void b(ConnectionResult connectionresult)
    {
        m m1;
        boolean flag = true;
        m1 = (m)a.get();
        if (m1 == null)
        {
            return;
        }
        if (Looper.myLooper() != m1.a.e)
        {
            flag = false;
        }
        w.a(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
        m1.b.lock();
        flag = m1.b(1);
        if (!flag)
        {
            m1.b.unlock();
            return;
        }
        if (!connectionresult.b())
        {
            m1.b(connectionresult, b, c);
        }
        if (m1.e())
        {
            m1.g();
        }
        m1.b.unlock();
        return;
        connectionresult;
        m1.b.unlock();
        throw connectionresult;
    }

    public onResult(m m1, a a1, int i)
    {
        a = new WeakReference(m1);
        b = a1;
        c = i;
    }
}
