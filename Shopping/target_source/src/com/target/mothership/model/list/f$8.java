// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.target.mothership.cache.h;
import com.target.mothership.cache.list.CacheListDetail;
import com.target.mothership.cache.list.CacheListSummary;
import com.target.mothership.cache.list.f;
import com.target.mothership.common.c.b;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.list.interfaces.a;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.model.list:
//            f

class val.handler
    implements Callable
{

    final com.target.mothership.model.list.f this$0;
    final com.target.mothership.cache.list.a val$handler;
    final String val$newDescription;
    final String val$newLocation;
    final String val$newOrganization;
    final String val$newTitle;

    public Void a()
        throws Exception
    {
        try
        {
            Object obj = (new f()).getDao();
            CacheListSummary cachelistsummary = (CacheListSummary)((Dao) (obj)).queryForId(Integer.valueOf(com.target.mothership.model.list.f.this.a().getKey()));
            cachelistsummary.setDescription(val$newDescription);
            cachelistsummary.setLocation(val$newLocation);
            cachelistsummary.setTitle(val$newTitle);
            cachelistsummary.setOrganization(val$newOrganization);
            cachelistsummary.setChannel(b.MOBILE);
            cachelistsummary.setLastModifiedUserId(com.target.mothership.model.list.f.this.b().getGuestId());
            cachelistsummary.setItemCount(cachelistsummary.getItemCount());
            cachelistsummary.setLastModifiedDate(null);
            h.update(((Dao) (obj)), cachelistsummary, Integer.valueOf(cachelistsummary.getKey()));
            obj = new CacheListDetail(cachelistsummary);
            ((CacheListDetail) (obj)).setListItems(new ArrayList(f.c(com.target.mothership.model.list.f.this)));
            val$handler.onResponse(obj);
        }
        catch (SQLException sqlexception)
        {
            com.target.mothership.model.list.interfaces.a.a a1 = new com.target.mothership.model.list.interfaces.a.a(sqlexception);
            val$handler.onError(a1);
            return null;
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
        this$0 = final_f1;
        val$newDescription = s;
        val$newLocation = s1;
        val$newTitle = s2;
        val$newOrganization = s3;
        val$handler = com.target.mothership.cache.list.a.this;
        super();
    }
}
