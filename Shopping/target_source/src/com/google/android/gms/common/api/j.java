// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.m;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            n, m, Status, b

public class j
    implements n
{

    private final com.google.android.gms.common.api.m a;

    public j(com.google.android.gms.common.api.m m1)
    {
        a = m1;
    }

    private void a(m.e e)
        throws DeadObjectException
    {
        a.a(e);
        b.b b1 = a.a(e.e());
        if (!b1.b() && a.f.containsKey(e.e()))
        {
            e.c(new Status(17));
            return;
        } else
        {
            e.a(b1);
            return;
        }
    }

    public i.a a(i.a a1)
    {
        return b(a1);
    }

    public void a()
    {
        while (!a.b.isEmpty()) 
        {
            try
            {
                a((m.e)a.b.remove());
            }
            catch (DeadObjectException deadobjectexception)
            {
                Log.w("GoogleApiClientConnected", "Service died while flushing queue", deadobjectexception);
            }
        }
    }

    public void a(int i)
    {
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a.g();
            a.f.clear();
        } else
        {
            Iterator iterator = a.k.iterator();
            while (iterator.hasNext()) 
            {
                ((m.e)iterator.next()).a(new Status(8, "The connection to Google Play services was lost"));
            }
        }
        a.a(null);
        if (!flag)
        {
            a.a.a(i);
        }
        a.a.a();
    }

    public void a(Bundle bundle)
    {
    }

    public void a(ConnectionResult connectionresult, b b1, int i)
    {
    }

    public i.a b(i.a a1)
    {
        try
        {
            a(a1);
        }
        catch (DeadObjectException deadobjectexception)
        {
            a(1);
            return a1;
        }
        return a1;
    }

    public void b()
    {
    }

    public void b(int i)
    {
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            a(i);
            a.c();
            return;

        case 1: // '\001'
            a.l();
            a(i);
            return;
        }
    }

    public String c()
    {
        return "CONNECTED";
    }
}
