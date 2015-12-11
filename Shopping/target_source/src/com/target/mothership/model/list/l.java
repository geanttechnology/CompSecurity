// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.target.mothership.cache.h;
import com.target.mothership.cache.list.CacheListSummary;
import com.target.mothership.cache.list.f;
import com.target.mothership.model.d;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.list.interfaces.a.a;
import java.sql.SQLException;
import java.util.List;

class l
{

    public static d a(d d)
    {
        return new d(d) {

            final d val$callback;

            public void a(a a1)
            {
                callback.b(a1);
            }

            public void a(Object obj)
            {
                callback.a(obj);
            }

            public void b(Object obj)
            {
                a((a)obj);
            }

            
            {
                callback = d1;
                super();
            }
        };
    }

    static List a(String s)
        throws SQLException
    {
        return (new f()).getDao().queryBuilder().orderBy("mListPosition", true).where().eq("mGuestId", s).and().eq("mIsDeleting", Boolean.valueOf(false)).query();
    }

    static void a(ListSummary listsummary, int i, Dao dao)
        throws SQLException
    {
        listsummary = (CacheListSummary)listsummary;
        listsummary.setListPosition(i);
        h.update(dao, listsummary, Integer.valueOf(listsummary.getKey()));
    }

    static long b(String s)
        throws SQLException
    {
        return (new f()).getDao().queryBuilder().orderBy("mListPosition", true).where().eq("mGuestId", s).and().eq("mIsDeleting", Boolean.valueOf(false)).countOf();
    }
}
