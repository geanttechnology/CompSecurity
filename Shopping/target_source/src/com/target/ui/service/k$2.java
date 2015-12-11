// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.target.mothership.model.h;
import com.target.mothership.services.x;
import java.util.List;

// Referenced classes of package com.target.ui.service:
//            k

class l.h extends h
{

    final k this$0;
    final ices.x val$listener;

    public void a(x x1)
    {
        val$listener.a(RELEVANT_STORE_ERROR, x1);
    }

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        if (list.isEmpty())
        {
            val$listener.a(NO_RELEVANT_STORES, null);
            return;
        } else
        {
            val$listener.onResult(list);
            return;
        }
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    ices.x()
    {
        this$0 = final_k1;
        val$listener = val.listener.this;
        super();
    }
}
