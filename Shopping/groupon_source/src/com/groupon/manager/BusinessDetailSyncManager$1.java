// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoSpecial;
import com.groupon.db.dao.DaoTip;
import com.groupon.db.models.Business;
import com.groupon.db.models.Special;
import com.groupon.db.models.Tip;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            BusinessDetailSyncManager

class val.m
    implements Callable
{

    final BusinessDetailSyncManager this$0;
    final InputStream val$m;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        sinessResponse sinessresponse = (sinessResponse)BusinessDetailSyncManager.access$000(BusinessDetailSyncManager.this).readValue(val$m, com/groupon/manager/BusinessDetailSyncManager$BusinessResponse);
        if (sinessresponse.business == null)
        {
            return null;
        }
        sinessresponse.business.afterJsonDeserializationPostProcessor(BusinessDetailSyncManager.access$100(BusinessDetailSyncManager.this));
        Special special;
        for (Iterator iterator = sinessresponse.business.getSpecials().iterator(); iterator.hasNext(); BusinessDetailSyncManager.access$200(BusinessDetailSyncManager.this).clear(special.remoteId))
        {
            special = (Special)iterator.next();
        }

        Tip tip;
        for (Iterator iterator1 = sinessresponse.business.getTips().iterator(); iterator1.hasNext(); BusinessDetailSyncManager.access$300(BusinessDetailSyncManager.this).clearByTipIdAndBusinessTipId(tip.remoteId, sinessresponse.business.remoteId))
        {
            tip = (Tip)iterator1.next();
        }

        BusinessDetailSyncManager.access$400(BusinessDetailSyncManager.this).clearByChannelId(sinessresponse.business.remoteId);
        sinessresponse.business.channel = sinessresponse.business.remoteId;
        BusinessDetailSyncManager.access$400(BusinessDetailSyncManager.this).save(sinessresponse.business);
        return null;
    }

    sinessResponse()
    {
        this$0 = final_businessdetailsyncmanager;
        val$m = InputStream.this;
        super();
    }
}
