// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
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
    final com.target.mothership.cache.guest.b val$handler;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Object obj;
        Object obj1;
        try
        {
            obj1 = new a();
            obj = ((a) (obj1)).getDao();
            obj1 = ((a) (obj1)).getAccountDetailsDao();
            obj = (CacheGuest)((Dao) (obj)).queryBuilder().queryForFirst();
        }
        catch (SQLException sqlexception)
        {
            com.target.mothership.services.x x = k.toNetworkError(sqlexception);
            b.a(c.access$000(), (new StringBuilder()).append("Error reading the database: ").append(sqlexception.getMessage()).toString());
            val$handler.onError(x);
            return null;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        val$handler.onResponse(null);
        return null;
        ((Dao) (obj1)).refresh(((CacheGuest) (obj)).getCacheAccountDetails());
        val$handler.onResponse(obj);
        return null;
    }

    eGuest()
    {
        this$0 = final_c1;
        val$handler = com.target.mothership.cache.guest.b.this;
        super();
    }
}
