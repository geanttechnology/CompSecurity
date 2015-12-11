// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.mothership.cache.h;
import com.target.mothership.model.guest.b;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.GuestBase;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.cache.list:
//            e, CacheListSummary

class erfaces.Guest
    implements Callable
{

    final e this$0;
    final Dao val$dao;
    final Guest val$newGuest;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        long l = val$dao.queryBuilder().where().eq("mGuestId", val$newGuest.getGuestId()).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf();
        Iterator iterator = val$dao.queryBuilder().orderBy("mListPosition", true).where().eq("mIsDefaultList", Boolean.valueOf(false)).and().eq("mGuestId", b.a().getGuestId()).and().eq("mIsDeleting", Boolean.valueOf(false)).query().iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            CacheListSummary cachelistsummary = (CacheListSummary)iterator.next();
            cachelistsummary.setGuestId(val$newGuest.getGuestId());
            int j = cachelistsummary.getKey();
            cachelistsummary.setListPosition((long)i + l);
            h.update(val$dao, cachelistsummary, Integer.valueOf(j));
        }

        return null;
    }

    erfaces.Guest()
    {
        this$0 = final_e1;
        val$dao = dao1;
        val$newGuest = Guest.this;
        super();
    }
}
