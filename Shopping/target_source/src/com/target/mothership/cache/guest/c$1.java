// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;
import com.target.a.a.b;
import com.target.mothership.cache.k;
import java.sql.SQLException;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.cache.guest:
//            c, a, CacheGuest, b

class val.handler
    implements Callable
{

    final c this$0;
    final CacheGuest val$cacheGuest;
    final com.target.mothership.cache.guest.b val$handler;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        try
        {
            Dao dao = (new a()).getDao();
            TableUtils.clearTable(dao.getConnectionSource(), com/target/mothership/cache/guest/CacheGuest);
            dao.create(val$cacheGuest);
            val$handler.onResponse(val$cacheGuest);
        }
        catch (SQLException sqlexception)
        {
            com.target.mothership.services.x x = k.toNetworkError(sqlexception);
            b.a(c.access$000(), (new StringBuilder()).append("Error writing the database: ").append(sqlexception.getMessage()).toString());
            val$handler.onError(x);
        }
        return null;
    }

    eGuest()
    {
        this$0 = final_c1;
        val$cacheGuest = cacheguest;
        val$handler = com.target.mothership.cache.guest.b.this;
        super();
    }
}
