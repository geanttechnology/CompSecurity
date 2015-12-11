// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponPlace;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class CouponNearbyMerchantSyncManagerProcess extends AbstractSyncManagerProcess
{
    protected static class CouponPlacesContainer
    {

        public List places;

        protected CouponPlacesContainer()
        {
        }
    }


    protected static final int FIVE_THOUSAND_METERS = 5000;
    protected DaoCouponMerchant daoCouponMerchant;
    protected double latitude;
    protected double longitude;

    public CouponNearbyMerchantSyncManagerProcess(Context context, String s, double d, double d1)
    {
        super(context, s);
        latitude = d;
        longitude = d1;
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        universalinfo = new ArrayList();
        universalinfo.addAll(Arrays.asList(new Serializable[] {
            "limit", Integer.valueOf(6), "lat", Double.valueOf(latitude), "lng", Double.valueOf(longitude), "radius", Integer.valueOf(5000), "view", "android"
        }));
        return universalinfo.toArray();
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/freebies/places";
    }

    public boolean isThrowingErrorOnException()
    {
        return false;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoCouponMerchant.getLastUpdated(dbChannel);
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (CouponPlacesContainer)obj;
        if (inputstream == null || ((CouponPlacesContainer) (inputstream)).places == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Places not loaded");
            }
        } else
        {
            daoCouponMerchant.deleteForChannel(dbChannel);
            for (inputstream = ((CouponPlacesContainer) (inputstream)).places.iterator(); inputstream.hasNext(); daoCouponMerchant.saveCouponMerchant(((CouponMerchant) (obj))))
            {
                obj = ((CouponPlace)inputstream.next()).getMerchant();
                obj.channel = dbChannel;
            }

        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/manager/sync_process/CouponNearbyMerchantSyncManagerProcess$CouponPlacesContainer);
    }
}
