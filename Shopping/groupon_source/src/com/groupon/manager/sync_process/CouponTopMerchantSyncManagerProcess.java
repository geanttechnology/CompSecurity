// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import android.content.res.Resources;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponMerchantListContainer;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class CouponTopMerchantSyncManagerProcess extends AbstractSyncManagerProcess
{

    protected final int PHONE_LIMIT = 6;
    protected final int TABLET_LIMIT = 9;
    protected DaoCouponMerchant daoCouponMerchant;
    protected boolean isThrowErrorOnException;
    protected int requestLimit;

    public CouponTopMerchantSyncManagerProcess(Context context, String s, boolean flag)
    {
        int i = 6;
        super(context, s);
        if (!context.getResources().getBoolean(0x7f090007))
        {
            i = 9;
        }
        requestLimit = i;
        isThrowErrorOnException = flag;
    }

    public Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        return (new Object[] {
            "limit", Integer.valueOf(requestLimit), "view", "android"
        });
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/freebies/merchants/top";
    }

    public boolean isThrowingErrorOnException()
    {
        return isThrowErrorOnException;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoCouponMerchant.getLastUpdated(dbChannel);
    }

    public void setRequestLimit(int i)
    {
        requestLimit = i;
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (CouponMerchantListContainer)obj;
        if (inputstream != null && ((CouponMerchantListContainer) (inputstream)).merchants != null)
        {
            daoCouponMerchant.deleteForChannel(dbChannel);
            inputstream = ((CouponMerchantListContainer) (inputstream)).merchants.iterator();
            while (inputstream.hasNext()) 
            {
                obj = (CouponMerchant)inputstream.next();
                obj.channel = dbChannel;
                daoCouponMerchant.create(obj);
            }
        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/db/models/CouponMerchantListContainer);
    }
}
