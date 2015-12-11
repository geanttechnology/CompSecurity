// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.target.mothership.cache.list.CacheListItem;
import com.target.mothership.cache.list.c;
import com.target.mothership.model.list.interfaces.a.a;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            f

class eListItem
    implements Callable
{

    final f this$0;
    final com.target.mothership.cache.list.a val$handler;
    final int val$position;
    final CacheListItem val$saveItem;

    public Void a()
        throws Exception
    {
        if (com.target.mothership.model.list.f.a(f.this) != 100L)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        a a1 = new a(com.target.mothership.model.list.interfaces.a.ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED);
        val$handler.onError(a1);
        return null;
        Dao dao;
        long l;
        dao = (new c()).getDao();
        if (val$position != -1)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        l = f.b(f.this);
_L2:
        Object obj;
        int i;
        if (val$position == -1)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = com.target.mothership.model.list.f.c(f.this);
        i = val$position;
_L1:
        if (i >= ((List) (obj)).size())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        CacheListItem cachelistitem = (CacheListItem)((List) (obj)).get(i);
        com.target.mothership.model.list.f.a(f.this, cachelistitem, i + 1, dao);
        i++;
          goto _L1
        List list;
        try
        {
            l = val$position;
        }
        catch (SQLException sqlexception)
        {
            a a2 = new a(sqlexception);
            val$handler.onError(a2);
            return null;
        }
          goto _L2
        val$saveItem.setItemPosition(l);
        dao.create(val$saveItem);
        obj = new ArrayList();
        ((List) (obj)).add(val$saveItem);
        f.d(f.this);
        if (val$position == -1)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        list = com.target.mothership.model.list.f.c(f.this);
        for (int j = val$position; j < list.size(); j++)
        {
            CacheListItem cachelistitem1 = (CacheListItem)list.get(j);
            if (cachelistitem1.getItemPosition() != (long)j)
            {
                com.target.mothership.model.list.f.a(f.this, cachelistitem1, j, dao);
            }
            break MISSING_BLOCK_LABEL_289;
        }

        val$handler.onResponse(obj);
        return null;
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    eListItem()
    {
        this$0 = final_f1;
        val$handler = a1;
        val$position = i;
        val$saveItem = CacheListItem.this;
        super();
    }
}
