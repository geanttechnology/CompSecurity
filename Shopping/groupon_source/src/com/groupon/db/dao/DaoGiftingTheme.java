// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.GiftingTheme;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Date;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoGiftingTheme extends GrouponBaseDao
{

    public static final String CATEGORY_UUID_FIELD_NAME = "categoryUuid";
    public static final String THEME_ID_FIELD_NAME = "id";

    public DaoGiftingTheme(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
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

    public void deleteByThemeId(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("id", s);
        deletebuilder.delete();
    }

    public long getLastUpdatedByChannelId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s);
        s = (GiftingTheme)queryForFirst(querybuilder.prepare());
        if (s != null)
        {
            return ((GiftingTheme) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public long getLastUpdatedByThemeId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("id", s);
        s = (GiftingTheme)queryForFirst(querybuilder.prepare());
        if (s != null)
        {
            return ((GiftingTheme) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void save(GiftingTheme giftingtheme)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", giftingtheme.remoteId).and().eq("categoryUuid", giftingtheme.categoryUuid);
        deletebuilder.delete();
        create(giftingtheme);
    }
}
