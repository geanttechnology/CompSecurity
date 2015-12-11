// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.cache.list.b;
import com.target.mothership.model.list.interfaces.a.a;
import java.sql.SQLException;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            j, CacheListMostRecent, i

class val.handler
    implements Callable
{

    final j this$0;
    final b val$handler;
    final String val$search;

    public Void a()
        throws Exception
    {
        try
        {
            CacheListMostRecent cachelistmostrecent = new CacheListMostRecent(val$search, com.target.mothership.model.list.interfaces.MostRecent.a.SEARCH);
            com.target.mothership.model.list.j.a(j.this).b(cachelistmostrecent);
            if (val$handler != null)
            {
                val$handler.onResponse(null);
            }
        }
        catch (SQLException sqlexception)
        {
            a a1 = new a(sqlexception);
            if (val$handler != null)
            {
                val$handler.onError(a1);
                return null;
            }
        }
        return null;
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    rfaces.a.a()
    {
        this$0 = final_j1;
        val$search = s;
        val$handler = b.this;
        super();
    }
}
