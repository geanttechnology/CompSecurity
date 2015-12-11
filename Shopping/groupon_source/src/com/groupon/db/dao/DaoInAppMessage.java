// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.InAppMessage;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoInAppMessage extends GrouponBaseDao
{

    public DaoInAppMessage(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clearAll()
        throws SQLException
    {
        delete(deleteBuilder().prepare());
    }

    public List getAll()
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        Date date = new Date();
        where.and(where.le("startAt", date), where.ge("endAt", date), new Where[] {
            where.ne("title", "")
        });
        querybuilder.setWhere(where);
        querybuilder.orderBy("timestamp", false).orderBy("_id", true);
        return query(querybuilder.prepare());
    }

    public void replace(final InAppMessage inAppMessage)
    {
        InAppMessage inappmessage;
        try
        {
            inappmessage = (InAppMessage)queryForFirst(queryBuilder().where().eq("remoteId", inAppMessage.remoteId).prepare());
        }
        // Misplaced declaration of an exception variable
        catch (final InAppMessage inAppMessage)
        {
            throw new RuntimeException(inAppMessage);
        }
        if (inappmessage == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (inappmessage.viewed)
        {
            inAppMessage.viewed = true;
        }
        inAppMessage.timestamp = inappmessage.timestamp;
        callBatchTasks(new Callable() {

            final DaoInAppMessage this$0;
            final InAppMessage val$inAppMessage;

            public Object call()
                throws Exception
            {
                DeleteBuilder deletebuilder = deleteBuilder();
                deletebuilder.setWhere(deletebuilder.where().eq("remoteId", inAppMessage.remoteId));
                delete(deletebuilder.prepare());
                create(inAppMessage);
                return null;
            }

            
            {
                this$0 = DaoInAppMessage.this;
                inAppMessage = inappmessage;
                super();
            }
        });
    }

    public void saveList(List list)
        throws SQLException
    {
        for (list = list.iterator(); list.hasNext(); create((InAppMessage)list.next())) { }
    }
}
