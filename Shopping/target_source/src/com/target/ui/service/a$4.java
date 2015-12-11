// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.n;

// Referenced classes of package com.target.ui.service:
//            a

class l.h extends h
{

    final a this$0;
    final h val$callback;

    public String a()
    {
        return val$callback.a();
    }

    public void a(x x1)
    {
        val$callback.a(x1);
        n.a(x1).e();
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        com.target.ui.service.a.a(a.this, null);
        val$callback.a(void1);
        com.target.ui.service.a.a(a.this);
        com.target.ui.service.a.b(a.this);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    l.h()
    {
        this$0 = final_a1;
        val$callback = h.this;
        super();
    }
}
