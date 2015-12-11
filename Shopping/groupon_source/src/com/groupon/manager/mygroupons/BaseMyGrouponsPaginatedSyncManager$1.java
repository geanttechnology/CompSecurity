// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.mygroupons;

import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.Pagination;
import com.groupon.manager.SyncManagerUtils;
import com.groupon.models.groupons.GrouponsResponse;
import com.groupon.util.MutableInteger;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.codehaus.jackson.map.ObjectMapper;

// Referenced classes of package com.groupon.manager.mygroupons:
//            BaseMyGrouponsPaginatedSyncManager

class val.grouponsCount
    implements Callable
{

    final BaseMyGrouponsPaginatedSyncManager this$0;
    final MutableInteger val$grouponsCount;
    final InputStream val$inputStream;
    final ObjectMapper val$mapper;
    final int val$offset;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        SyncManagerUtils.deleteRecordsForChannel(paginationDao, grouponCategory);
        if (val$offset == 0)
        {
            grouponItemDao.deleteRecordsForCategory(grouponCategory);
            grouponItemSummaryDao.deleteRecordsForCategory(grouponCategory);
        }
        Pagination pagination = ((GrouponsResponse)val$mapper.readValue(val$inputStream, com/groupon/models/groupons/GrouponsResponse)).pagination;
        if (pagination != null)
        {
            pagination.setChannel(grouponCategory);
            pagination.setCurrentOffset(val$offset);
            pagination.setNextOffset(val$offset + val$grouponsCount.get());
            boolean flag;
            if (val$grouponsCount.get() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            pagination.setHasMorePages(flag);
            paginationDao.create(pagination);
        }
        return null;
    }

    I()
    {
        this$0 = final_basemygrouponspaginatedsyncmanager;
        val$offset = i;
        val$mapper = objectmapper;
        val$inputStream = inputstream;
        val$grouponsCount = MutableInteger.this;
        super();
    }
}
