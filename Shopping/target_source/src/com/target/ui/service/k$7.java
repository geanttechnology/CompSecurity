// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.target.mothership.model.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.ui.service:
//            k

class l.h extends h
{

    final k this$0;
    final h val$callback;

    public void a(e e1)
    {
        val$callback.a(Boolean.valueOf(e1.b()));
    }

    public void a(x x1)
    {
        val$callback.a(x1);
    }

    public volatile void a(Object obj)
    {
        a((e)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    l.h()
    {
        this$0 = final_k1;
        val$callback = h.this;
        super();
    }
}
