// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.dao.DaoBusinessSummary;
import com.groupon.db.models.Business;
import com.groupon.db.models.BusinessSummary;
import com.groupon.manager.UniversalInfo;
import com.groupon.models.Place;
import com.groupon.models.division.Division;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.GeoPoint;
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

public class PoGBusinessSearchSyncManagerProcess extends AbstractSyncManagerProcess
{
    private static class BusinessContainer
    {

        public List businesses;

        private BusinessContainer()
        {
        }
    }


    private CurrentDivisionManager currentDivisionManager;
    private DaoBusinessSummary daoBusinessSummary;
    private GeoPoint geoPoint;
    private LocationService locationService;
    LoggingUtils loggingUtils;

    public PoGBusinessSearchSyncManagerProcess(Context context, String s)
    {
        super(context, s);
        geoPoint = getGeoPoint();
    }

    protected GeoPoint getGeoPoint()
    {
        android.location.Location location = locationService.getLocation();
        if (location != null)
        {
            return new GeoPoint(location);
        } else
        {
            return currentDivisionManager.getCurrentDivision().geoPoint;
        }
    }

    public Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        String s;
        ArrayList arraylist;
        if (universalinfo != null)
        {
            s = (String)universalinfo.getValue("query");
        } else
        {
            s = "";
        }
        if (universalinfo != null)
        {
            universalinfo = (Place)universalinfo.getValue("place");
        } else
        {
            universalinfo = null;
        }
        arraylist = new ArrayList();
        if (geoPoint != null)
        {
            arraylist.add("lat");
            double d;
            if (universalinfo != null)
            {
                d = ((Place) (universalinfo)).lat;
            } else
            {
                d = geoPoint.getLatitudeDegrees();
            }
            arraylist.add(Double.valueOf(d));
            arraylist.add("lng");
            if (universalinfo != null)
            {
                d = ((Place) (universalinfo)).lng;
            } else
            {
                d = geoPoint.getLongitudeDegrees();
            }
            arraylist.add(Double.valueOf(d));
        }
        if (s != null)
        {
            arraylist.add("query");
            arraylist.add(s);
        }
        arraylist.add("limit");
        arraylist.add(Integer.valueOf(20));
        return arraylist.toArray();
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/businesses/search";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoBusinessSummary.getLastUpdated(dbChannel);
    }

    protected void logQuerySearch(String s, List list)
    {
        Object obj = new ArrayList();
        for (list = list.iterator(); list.hasNext(); ((List) (obj)).add(((Business)list.next()).remoteId)) { }
        list = Strings.join(",", ((java.util.Collection) (obj)));
        obj = new CouponGenericMetadata();
        obj.channelId = Channel.GLOBAL_SEARCH.toString().toLowerCase();
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
        inputstream = (BusinessContainer)obj;
        if (inputstream == null || ((BusinessContainer) (inputstream)).businesses == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Not loaded");
            }
        } else
        {
            daoBusinessSummary.deleteByChannelId(dbChannel);
            BusinessSummary businesssummary;
            for (obj = ((BusinessContainer) (inputstream)).businesses.iterator(); ((Iterator) (obj)).hasNext(); daoBusinessSummary.save(businesssummary))
            {
                businesssummary = new BusinessSummary((Business)((Iterator) (obj)).next(), dbChannel);
            }

            if (universalinfo != null)
            {
                logQuerySearch((String)universalinfo.getValue("query"), ((BusinessContainer) (inputstream)).businesses);
            }
        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/manager/sync_process/PoGBusinessSearchSyncManagerProcess$BusinessContainer);
    }
}
