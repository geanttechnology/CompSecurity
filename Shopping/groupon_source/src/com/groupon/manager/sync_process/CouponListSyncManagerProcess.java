// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.db.dao.DaoCouponSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.CouponDetail;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponSummary;
import com.groupon.db.models.Pagination;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class CouponListSyncManagerProcess extends AbstractSyncManagerProcess
{
    private static class CouponListContainer
    {

        public List coupons;
        public List merchants;

        private CouponListContainer()
        {
        }
    }


    protected DaoCouponSummary daoCouponSummary;
    protected DaoPagination daoPagination;

    public CouponListSyncManagerProcess(Context context, String s)
    {
        super(context, s);
        this.context = context;
    }

    public Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        return (new Object[] {
            "view", "android"
        });
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/freebies/coupons/carousel";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoCouponSummary.getLastUpdated(dbChannel);
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        try
        {
            obj = (CouponListContainer)obj;
            daoCouponSummary.deleteByChannelId(dbChannel);
            inputstream = new HashMap();
            CouponMerchant couponmerchant;
            for (universalinfo = ((CouponListContainer) (obj)).merchants.iterator(); universalinfo.hasNext(); inputstream.put(couponmerchant.getRemoteId(), couponmerchant))
            {
                couponmerchant = (CouponMerchant)universalinfo.next();
                couponmerchant.channel = dbChannel;
            }

        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            if (inputstream instanceof SQLException)
            {
                throw inputstream;
            }
            break MISSING_BLOCK_LABEL_194;
        }
        for (obj = ((CouponListContainer) (obj)).coupons.iterator(); ((Iterator) (obj)).hasNext(); daoCouponSummary.save(new CouponSummary(universalinfo, dbChannel)))
        {
            universalinfo = (CouponDetail)((Iterator) (obj)).next();
            universalinfo.couponMerchant = (CouponMerchant)inputstream.get(((CouponDetail) (universalinfo)).merchantUuid);
            universalinfo.afterJsonDeserializationPostProcessor();
        }

        inputstream = new Pagination();
        inputstream.setChannel(dbChannel);
        inputstream.setHasMorePages(false);
        inputstream.setCurrentOffset(0);
        daoPagination.create(inputstream);
_L1:
        return;
        if (isThrowingErrorOnException())
        {
            throw new SQLException(inputstream);
        }
          goto _L1
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/manager/sync_process/CouponListSyncManagerProcess$CouponListContainer);
    }
}
