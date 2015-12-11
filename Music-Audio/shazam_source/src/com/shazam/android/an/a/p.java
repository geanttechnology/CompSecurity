// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import android.app.Activity;
import android.content.Intent;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.rdio.RdioCredentials;

// Referenced classes of package com.shazam.android.an.a:
//            f, q, r, o

public final class p
    implements f, q
{

    private final o b;
    private final RdioConnectionState c;
    private r d;

    public p(o o1, RdioConnectionState rdioconnectionstate)
    {
        d = r.b;
        b = o1;
        c = rdioconnectionstate;
    }

    public final void a()
    {
        c.d();
    }

    public final void a(Activity activity)
    {
        activity.startActivityForResult(b.a(), 1234);
    }

    public final void a(r r1)
    {
        d = r1;
    }

    public final void a(RdioCredentials rdiocredentials)
    {
        c.a(rdiocredentials);
        d.c();
    }

    public final void a(boolean flag)
    {
        b.a(c.b(), flag, this);
    }

    public final boolean a(int i, int j, Intent intent)
    {
        if (i == 1234)
        {
            b.a(j, intent);
            return true;
        } else
        {
            return false;
        }
    }

    public final void b()
    {
        d = r.b;
    }

    public final void c()
    {
        d.d();
    }

    public final void d()
    {
        a();
    }

    public final void e()
    {
        d.e();
    }
}
