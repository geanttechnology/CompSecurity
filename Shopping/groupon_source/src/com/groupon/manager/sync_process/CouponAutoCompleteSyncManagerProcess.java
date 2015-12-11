// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.models.CouponMerchant;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.UniversalInfo;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class CouponAutoCompleteSyncManagerProcess extends AbstractSyncManagerProcess
{
    public static class MerchantsContainer
    {

        public List merchants;

        public MerchantsContainer()
        {
            merchants = new ArrayList();
        }
    }


    protected static final int FREEBIES_SEARCH_LOAD_LIMIT = 4;
    DaoCouponMerchant daoCouponMerchant;
    LoggingUtils loggingUtils;

    public CouponAutoCompleteSyncManagerProcess(Context context, String s)
    {
        super(context, s);
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        return (new Object[] {
            "query", universalinfo.getValue("query"), "limit", Integer.valueOf(4), "view", "android"
        });
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/freebies/merchants";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return 0L;
    }

    protected void logQuerySearch(String s, List list)
    {
        Object obj = new ArrayList();
        for (list = list.iterator(); list.hasNext(); ((List) (obj)).add(((CouponMerchant)list.next()).name)) { }
        list = Strings.join(",", ((java.util.Collection) (obj)));
        obj = new CouponGenericMetadata();
        obj.channelId = Channel.COUPONS.toString();
        LoggingUtils loggingutils = loggingUtils;
        if (list.length() > 500)
        {
            list = list.substring(0, 500);
        }
        loggingutils.logTextSearch("", s, list, s.length(), ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (MerchantsContainer)obj;
        if (inputstream == null || ((MerchantsContainer) (inputstream)).merchants == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Not loaded");
            }
        } else
        {
            daoCouponMerchant.deleteForChannel(dbChannel);
            CouponMerchant couponmerchant;
            for (obj = ((MerchantsContainer) (inputstream)).merchants.iterator(); ((Iterator) (obj)).hasNext(); daoCouponMerchant.create(couponmerchant))
            {
                couponmerchant = (CouponMerchant)((Iterator) (obj)).next();
                couponmerchant.channel = dbChannel;
            }

            logQuerySearch((String)universalinfo.getValue("query"), ((MerchantsContainer) (inputstream)).merchants);
        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/manager/sync_process/CouponAutoCompleteSyncManagerProcess$MerchantsContainer);
    }

    public InputStream triggerSync(UniversalInfo universalinfo)
        throws Exception
    {
        try
        {
            universalinfo = (InputStream)(new SyncHttp(context, java/io/InputStream, getSyncUrl(universalinfo), getSyncQueryParams(universalinfo))).call();
        }
        // Misplaced declaration of an exception variable
        catch (UniversalInfo universalinfo)
        {
            throw universalinfo;
        }
        return universalinfo;
    }
}
