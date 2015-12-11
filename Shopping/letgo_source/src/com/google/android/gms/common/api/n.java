// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

// Referenced classes of package com.google.android.gms.common.api:
//            p, o, a

public class n
    implements p
{

    private final o a;

    public n(o o1)
    {
        a = o1;
    }

    public k.a a(k.a a1)
    {
        a.b.add(a1);
        return a1;
    }

    public void a()
    {
        a.g();
        a.f = Collections.emptySet();
    }

    public void a(int i)
    {
    }

    public void a(Bundle bundle)
    {
    }

    public void a(ConnectionResult connectionresult, a a1, int i)
    {
    }

    public k.a b(k.a a1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void b()
    {
        for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((o.e)iterator.next()).b()) { }
        a.b.clear();
        a.e.clear();
        a.f();
    }

    public void c()
    {
        a.h();
    }

    public String d()
    {
        return "DISCONNECTED";
    }
}
