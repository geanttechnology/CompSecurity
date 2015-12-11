// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.mothership.cache.list.a;
import com.target.mothership.cache.list.f;
import com.target.mothership.model.guest.interfaces.GuestBase;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            b

class val.handler
    implements Callable
{

    final b this$0;
    final boolean val$allListsForSync;
    final a val$handler;

    public Void a()
        throws Exception
    {
        try
        {
            Object obj = b.this.a().getGuestId();
            obj = (new f()).getDao().queryBuilder().orderBy("mListPosition", true).where().eq("mGuestId", obj);
            if (!val$allListsForSync)
            {
                ((Where) (obj)).and().eq("mIsDeleting", Boolean.valueOf(false));
            }
            obj = new ArrayList(((Where) (obj)).query());
            val$handler.onResponse(obj);
        }
        catch (SQLException sqlexception)
        {
            com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
            val$handler.onError(a1);
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
        this$0 = final_b1;
        val$allListsForSync = flag;
        val$handler = a.this;
        super();
    }
}
