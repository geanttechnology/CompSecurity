// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoPagination;
import com.groupon.db.dao.DaoTip;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.Tip;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            BusinessTipsSyncManager, SyncManagerUtils

class val.offset
    implements Callable
{

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
        psResponse psresponse = (psResponse)BusinessTipsSyncManager.access$000(BusinessTipsSyncManager.this).readValue(val$m, com/groupon/manager/BusinessTipsSyncManager$TipsResponse);
        SyncManagerUtils.deleteRecordsForChannel(BusinessTipsSyncManager.access$100(BusinessTipsSyncManager.this), BusinessTipsSyncManager.access$200(BusinessTipsSyncManager.this));
        if (val$offset == 0)
        {
            BusinessTipsSyncManager.access$300(BusinessTipsSyncManager.this).clearByBusinessChannelId(BusinessTipsSyncManager.access$200(BusinessTipsSyncManager.this));
        } else
        {
            Iterator iterator = psresponse.tips.iterator();
            while (iterator.hasNext()) 
            {
                Tip tip = (Tip)iterator.next();
                BusinessTipsSyncManager.access$300(BusinessTipsSyncManager.this).clearByTipIdAndBusinessTipId(tip.remoteId, BusinessTipsSyncManager.access$200(BusinessTipsSyncManager.this));
            }
        }
        if (psresponse.pagination != null)
        {
            psresponse.pagination.setChannel(BusinessTipsSyncManager.access$200(BusinessTipsSyncManager.this));
            psresponse.pagination.setCurrentOffset(val$offset);
            psresponse.pagination.setNextOffset(val$offset + psresponse.tips.size());
            Object obj = psresponse.pagination;
            boolean flag;
            if (val$offset + psresponse.tips.size() < psresponse.pagination.getCount() || psresponse.tips.size() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Pagination) (obj)).setHasMorePages(flag);
            BusinessTipsSyncManager.access$100(BusinessTipsSyncManager.this).create(psresponse.pagination);
        }
        for (obj = psresponse.tips.iterator(); ((Iterator) (obj)).hasNext();)
        {
            ((Tip)((Iterator) (obj)).next()).businessChannelId = BusinessTipsSyncManager.access$200(BusinessTipsSyncManager.this);
        }

        BusinessTipsSyncManager.access$300(BusinessTipsSyncManager.this).saveList(psresponse.tips);
        return null;
    }

    psResponse()
    {
        this$0 = final_businesstipssyncmanager;
        val$m = inputstream;
        val$offset = I.this;
        super();
    }
}
