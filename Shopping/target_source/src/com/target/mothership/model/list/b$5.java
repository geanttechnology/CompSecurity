// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.mothership.cache.list.CacheListDetail;
import com.target.mothership.cache.list.CacheListSummary;
import com.target.mothership.cache.list.c;
import com.target.mothership.cache.list.f;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.list.interfaces.a.a;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            b

class val.handler
    implements Callable
{

    final b this$0;
    final com.target.mothership.cache.list.a val$handler;
    final boolean val$ignoreDeletingFlag;

    public Void a()
        throws Exception
    {
        SQLException sqlexception;
        Object obj;
        obj = (new f()).getDao();
        Dao dao = (new c()).getDao();
        obj = ((Dao) (obj)).queryBuilder().orderBy("mListPosition", true).where().eq("mGuestId", b.b(b.this).getGuestId());
        if (!val$ignoreDeletingFlag)
        {
            ((Where) (obj)).and().eq("mIsDeleting", Boolean.valueOf(false));
        }
        Object obj1 = ((Where) (obj)).query();
        obj = new ArrayList();
        CacheListDetail cachelistdetail;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(cachelistdetail))
        {
            Object obj2 = (CacheListSummary)((Iterator) (obj1)).next();
            cachelistdetail = new CacheListDetail(((CacheListSummary) (obj2)));
            obj2 = dao.queryBuilder().orderBy("mItemPosition", true).where().eq("mListKey", Integer.valueOf(((CacheListSummary) (obj2)).getKey()));
            if (!val$ignoreDeletingFlag)
            {
                ((Where) (obj2)).and().eq("mIsDeleting", Boolean.valueOf(false));
            }
            cachelistdetail.getListItems().addAll(((Where) (obj2)).query());
        }

          goto _L1
_L3:
        return null;
_L1:
        try
        {
            val$handler.onResponse(obj);
        }
        // Misplaced declaration of an exception variable
        catch (SQLException sqlexception)
        {
            val$handler.onError(new a(sqlexception));
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    rfaces.a.a()
    {
        this$0 = final_b1;
        val$ignoreDeletingFlag = flag;
        val$handler = com.target.mothership.cache.list.a.this;
        super();
    }
}
