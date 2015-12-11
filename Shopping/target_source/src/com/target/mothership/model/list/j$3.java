// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.cache.list.b;
import com.target.mothership.model.list.interfaces.a.a;
import java.sql.SQLException;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            j, i

class val.handler
    implements Callable
{

    final j this$0;
    final b val$handler;

    public Void a()
        throws Exception
    {
        java.util.List list = com.target.mothership.model.list.j.a(j.this).a(new com.target.mothership.model.list.interfaces.MostRecent.a[] {
            com.target.mothership.model.list.interfaces.MostRecent.a.SEARCH
        });
        if (val$handler != null)
        {
            val$handler.onResponse(list);
        }
_L2:
        return null;
        SQLException sqlexception;
        sqlexception;
        if (val$handler != null)
        {
            a a1 = new a(sqlexception);
            val$handler.onError(a1);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    rfaces.a.a()
    {
        this$0 = final_j1;
        val$handler = b.this;
        super();
    }
}
