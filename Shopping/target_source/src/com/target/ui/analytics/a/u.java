// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.model.h;
import com.target.mothership.services.r;
import com.target.mothership.services.x;

// Referenced classes of package com.target.ui.analytics.a:
//            n

public class u extends h
{

    private final h mReceiver;

    public u(h h1)
    {
        mReceiver = h1;
    }

    public String a()
    {
        return mReceiver.a();
    }

    public void a(x x1)
    {
        mReceiver.a(x1);
        n.a(x1).e();
    }

    public void a(Object obj)
    {
        mReceiver.a(obj);
    }

    public r b()
    {
        return mReceiver.b();
    }

    public void b(Object obj)
    {
        a((x)obj);
    }
}
