// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.n;
import com.target.ui.util.a.a;
import com.target.ui.util.q;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.service:
//            a

class l.h extends h
{

    final com.target.ui.service.a this$0;

    public String a()
    {
        return com.target.ui.service.a.e();
    }

    public void a(e e1)
    {
        if (e1.b())
        {
            com.target.ui.service.a.a(com.target.ui.service.a.this, (Guest)e1.c());
            for (Iterator iterator = com.target.ui.service.a.c(com.target.ui.service.a.this).b(com.target.ui.service.a.this).iterator(); iterator.hasNext(); ((d)iterator.next()).a(e1.c())) { }
            com.target.ui.service.a.b(com.target.ui.service.a.this, (Guest)e1.c());
            return;
        } else
        {
            com.target.ui.service.a.d(com.target.ui.service.a.this);
            return;
        }
    }

    public void a(x x1)
    {
        q.a(com.target.ui.service.a.e(), (new StringBuilder()).append("error while trying to get the current guest from mothership library.  ").append(x1.getMessage()).toString());
        com.target.ui.service.a.d(com.target.ui.service.a.this);
        n.a(x1).e();
    }

    public volatile void a(Object obj)
    {
        a((e)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    ices.x()
    {
        this$0 = com.target.ui.service.a.this;
        super();
    }
}
