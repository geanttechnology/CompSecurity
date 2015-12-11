// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

// Referenced classes of package com.google.android.gms.common.api:
//            n, m, b

public class l
    implements n
{

    private final m a;

    public l(m m1)
    {
        a = m1;
    }

    public i.a a(i.a a1)
    {
        a.b.add(a1);
        return a1;
    }

    public void a()
    {
        a.h();
    }

    public void a(int i)
    {
        if (i == -1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            for (Iterator iterator = a.b.iterator(); iterator.hasNext(); ((m.e)iterator.next()).c()) { }
            a.b.clear();
            a.g();
            a.f.clear();
        }
    }

    public void a(Bundle bundle)
    {
    }

    public void a(ConnectionResult connectionresult, b b1, int i)
    {
    }

    public i.a b(i.a a1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void b()
    {
        a.i();
    }

    public void b(int i)
    {
    }

    public String c()
    {
        return "DISCONNECTED";
    }
}
