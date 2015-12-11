// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.GiftingCategory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoGiftingCategory extends GrouponBaseDao
{

    public DaoGiftingCategory(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void deleteByChannelId(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("channel", s);
        deletebuilder.delete();
    }

    public void save(GiftingCategory giftingcategory)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", giftingcategory.remoteId).and().eq("channel", giftingcategory.channel);
        deletebuilder.delete();
        create(giftingcategory);
    }
}
