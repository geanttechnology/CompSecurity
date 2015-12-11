// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.o;

import com.target.mothership.model.h;
import com.target.mothership.services.x;
import java.util.List;

// Referenced classes of package com.target.ui.helper.o:
//            b

class .h extends h
{

    final b this$0;
    final ces.x val$listener;
    final String val$query;

    public String a()
    {
        return com.target.ui.helper.o.b.a(b.this);
    }

    public void a(x x1)
    {
        val$listener.a(x1, val$query);
    }

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        val$listener.a(list, val$query);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    ces.x()
    {
        this$0 = final_b1;
        val$listener = x1;
        val$query = String.this;
        super();
    }
}
