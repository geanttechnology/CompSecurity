// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.model.d;
import com.target.mothership.model.list.interfaces.a.a;
import java.util.List;

// Referenced classes of package com.target.mothership.model.list:
//            f

class val.callback extends d
{

    final f this$0;
    final d val$callback;

    public void a(a a1)
    {
        val$callback.b(a1);
    }

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        if (!list.isEmpty())
        {
            val$callback.a(list.get(0));
            return;
        } else
        {
            val$callback.a(null);
            return;
        }
    }

    public void b(Object obj)
    {
        a((a)obj);
    }

    faces.a.a()
    {
        this$0 = final_f1;
        val$callback = d.this;
        super();
    }
}
