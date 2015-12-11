// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.m;

import com.target.mothership.model.a.c.a.a;
import com.target.mothership.model.d;
import java.util.List;

// Referenced classes of package com.target.ui.helper.m:
//            a

class .d extends d
{

    final com.target.ui.helper.m.a this$0;
    final .a.c.a.a val$listener;

    public void a(a a1)
    {
        val$listener.d();
    }

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        val$listener.a(list);
    }

    public void b(Object obj)
    {
        a((a)obj);
    }

    .a.c.a.a()
    {
        this$0 = final_a1;
        val$listener = val.listener.this;
        super();
    }
}
