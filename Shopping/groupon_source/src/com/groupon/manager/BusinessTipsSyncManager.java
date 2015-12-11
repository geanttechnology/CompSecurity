// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.dao.DaoTip;
import com.groupon.db.events.BusinessTipsUpdateEvent;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.Tip;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.util.ExecutorManager;
import com.groupon.util.IOUtils;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.manager:
//            GrouponPaginatedSyncManager, SyncManagerUtils

public class BusinessTipsSyncManager extends GrouponPaginatedSyncManager
{
    protected static class TipsResponse
    {

        public Pagination pagination;
        public Collection tips;

        protected TipsResponse()
        {
        }
    }


    private String businessId;
    private Bus globalBus;
    private ObjectMapperWrapper mapper;
    private DaoPagination paginationDao;
    private DaoTip tipDao;
    private String tipsBusinessChannelId;

    public BusinessTipsSyncManager(Context context)
    {
        super(context);
    }

    public BusinessTipsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
    }

    public BusinessTipsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        super(context, pausablethreadpoolexecutor, executormanager);
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((Void)obj, i, j);
    }

    protected void doSync(final Void m, final int offset, int i)
        throws Exception
    {
        Ln.d((new StringBuilder()).append("Start doSync for Tips ").append(tipsBusinessChannelId).toString(), new Object[0]);
        m = (InputStream)getSyncHttp(offset, i).call();
        tipDao.callBatchTasks(new Callable() {

            final BusinessTipsSyncManager this$0;
            final InputStream val$m;
            final int val$offset;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                TipsResponse tipsresponse = (TipsResponse)mapper.readValue(m, com/groupon/manager/BusinessTipsSyncManager$TipsResponse);
                SyncManagerUtils.deleteRecordsForChannel(paginationDao, tipsBusinessChannelId);
                if (offset == 0)
                {
                    tipDao.clearByBusinessChannelId(tipsBusinessChannelId);
                } else
                {
                    Iterator iterator = tipsresponse.tips.iterator();
                    while (iterator.hasNext()) 
                    {
                        Tip tip = (Tip)iterator.next();
                        tipDao.clearByTipIdAndBusinessTipId(tip.remoteId, tipsBusinessChannelId);
                    }
                }
                if (tipsresponse.pagination != null)
                {
                    tipsresponse.pagination.setChannel(tipsBusinessChannelId);
                    tipsresponse.pagination.setCurrentOffset(offset);
                    tipsresponse.pagination.setNextOffset(offset + tipsresponse.tips.size());
                    Object obj = tipsresponse.pagination;
                    boolean flag;
                    if (offset + tipsresponse.tips.size() < tipsresponse.pagination.getCount() || tipsresponse.tips.size() == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((Pagination) (obj)).setHasMorePages(flag);
                    paginationDao.create(tipsresponse.pagination);
                }
                for (obj = tipsresponse.tips.iterator(); ((Iterator) (obj)).hasNext();)
                {
                    ((Tip)((Iterator) (obj)).next()).businessChannelId = tipsBusinessChannelId;
                }

                tipDao.saveList(tipsresponse.tips);
                return null;
            }

            
            {
                this$0 = BusinessTipsSyncManager.this;
                m = inputstream;
                offset = i;
                super();
            }
        });
        globalBus.post(new BusinessTipsUpdateEvent(tipsBusinessChannelId));
        Ln.d((new StringBuilder()).append("End doSync for channel ").append(tipsBusinessChannelId).toString(), new Object[0]);
        IOUtils.close(m);
        return;
        Exception exception;
        exception;
        IOUtils.close(m);
        throw exception;
    }

    protected int getNextOffset()
        throws Exception
    {
        Pagination pagination = (Pagination)paginationDao.queryForFirstEq("channel", tipsBusinessChannelId);
        if (pagination != null)
        {
            return pagination.getNextOffset();
        } else
        {
            return 0;
        }
    }

    protected SyncHttp getSyncHttp(int i, int j)
        throws Exception
    {
        return new SyncHttp(context, java/io/InputStream, getUrl(i, j));
    }

    protected String getUrl(int i, int j)
    {
        return String.format("https:/businesses/%s/tips?offset=%s&limit=%s", new Object[] {
            businessId, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    protected long lastUpdated()
        throws Exception
    {
        return 0L;
    }

    public void setBusinessId(String s)
    {
        businessId = s;
    }

    public void setTipsBusinessChannelId(String s)
    {
        tipsBusinessChannelId = s;
    }




}
