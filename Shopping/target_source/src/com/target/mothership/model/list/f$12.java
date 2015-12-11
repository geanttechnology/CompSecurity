// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.mothership.cache.list.CacheListItem;
import com.target.mothership.cache.list.c;
import com.target.mothership.model.list.interfaces.a;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            f

class val.handler
    implements Callable
{

    final f this$0;
    final com.target.mothership.cache.list.a val$handler;

    public Void a()
        throws Exception
    {
        try
        {
            Dao dao = (new c()).getDao();
            CacheListItem cachelistitem;
            for (Iterator iterator = dao.queryBuilder().where().eq("mListKey", Integer.valueOf(f.this.a().getKey())).query().iterator(); iterator.hasNext(); dao.update(cachelistitem))
            {
                cachelistitem = (CacheListItem)iterator.next();
                cachelistitem.setDeleting(true);
            }

        }
        catch (SQLException sqlexception)
        {
            com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
            val$handler.onError(a1);
            return null;
        }
        f.d(f.this);
        val$handler.onResponse(null);
        return null;
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    faces.a.a()
    {
        this$0 = final_f1;
        val$handler = com.target.mothership.cache.list.a.this;
        super();
    }
}
