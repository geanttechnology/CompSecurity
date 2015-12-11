// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;

public class LoaderManagerUtils
{

    public LoaderManagerUtils()
    {
    }

    public static void deleteRecordsForChannel(Dao dao, String s)
        throws SQLException
    {
        dao = dao.deleteBuilder();
        Where where = dao.where();
        where.eq("channel", s);
        dao.setWhere(where);
        dao.delete();
    }
}
