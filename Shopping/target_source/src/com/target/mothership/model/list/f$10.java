// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.target.mothership.cache.list.CacheListItem;
import com.target.mothership.cache.list.c;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.a.a;
import java.sql.SQLException;
import java.util.ArrayList;
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
    final List val$items;

    public Void a()
        throws Exception
    {
        Object obj;
        Dao dao;
        Iterator iterator;
        obj = new ArrayList();
        dao = (new c()).getDao();
        iterator = val$items.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        CacheListItem cachelistitem = (CacheListItem)dao.queryForId(Integer.valueOf(((ListItem)iterator.next()).getKey()));
        if (cachelistitem == null) goto _L4; else goto _L3
_L3:
        cachelistitem.setDeleting(true);
        dao.update(cachelistitem);
        ((List) (obj)).add(cachelistitem);
          goto _L4
_L6:
        return null;
_L2:
        try
        {
            f.f(f.this);
            f.d(f.this);
            val$handler.onResponse(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = new a(((SQLException) (obj)));
            val$handler.onError(obj);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    faces.a.a()
    {
        this$0 = final_f1;
        val$items = list;
        val$handler = com.target.mothership.cache.list.a.this;
        super();
    }
}
