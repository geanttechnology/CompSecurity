// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import com.j256.ormlite.dao.Dao;
import com.target.a.a.b;
import com.target.mothership.model.guest.interfaces.Guest;
import java.sql.SQLException;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.cache.guest:
//            c, a, b

class val.handler
    implements Callable
{

    final c this$0;
    final Guest val$guest;
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
            dao.delete(dao.queryForEq("mGuestId", val$guest.getGuestId()));
            val$handler.onResponse(null);
        }
        catch (SQLException sqlexception)
        {
            b.a(c.access$000(), (new StringBuilder()).append("Error while trying to delete from database: ").append(sqlexception.getMessage()).toString());
            val$handler.onResponse(null);
            return null;
        }
        return null;
    }

    rfaces.Guest()
    {
        this$0 = final_c1;
        val$guest = guest1;
        val$handler = com.target.mothership.cache.guest.b.this;
        super();
    }
}
