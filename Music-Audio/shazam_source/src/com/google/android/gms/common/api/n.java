// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            p, o, m, a

public final class n
    implements p
{

    private final o a;

    public n(o o1)
    {
        a = o1;
    }

    public final k.a a(k.a a1)
    {
        a.f.add(a1);
        return a1;
    }

    public final void a()
    {
        for (Iterator iterator = a.m.values().iterator(); iterator.hasNext(); ((a.b)iterator.next()).d()) { }
        a.o = Collections.emptySet();
    }

    public final void a(int i)
    {
    }

    public final void a(Bundle bundle)
    {
    }

    public final void a(ConnectionResult connectionresult, a a1, int i)
    {
    }

    public final k.a b(k.a a1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void b()
    {
        for (Iterator iterator = a.f.iterator(); iterator.hasNext(); ((o.e)iterator.next()).b()) { }
        a.f.clear();
        a.n.clear();
        a.f();
    }

    public final void c()
    {
        o o1;
        o1 = a;
        o1.a.lock();
        o1.s = new m(o1, o1.p, o1.q, o1.k, o1.r, o1.a, o1.d);
        o1.s.a();
        o1.b.signalAll();
        o1.a.unlock();
        return;
        Exception exception;
        exception;
        o1.a.unlock();
        throw exception;
    }

    public final String d()
    {
        return "DISCONNECTED";
    }
}
