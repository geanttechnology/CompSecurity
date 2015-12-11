// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.PIException;
import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.analytics.GeneralAnalyticsData;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.net.EndpointType;
import com.pointinside.net.url.URLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.pointinside.net.requestor:
//            WebserviceRequestor

public class GeneralAnalyticsRequestor extends WebserviceRequestor
{
    static class GeneralAnalyticsURLBuilder extends URLBuilder
    {

        public void onPrepareURL()
        {
            addProximityDataIfAvailable();
        }

        public GeneralAnalyticsURLBuilder()
        {
            super(EndpointType.GENERAL, null);
        }
    }


    protected GeneralAnalyticsRequestor()
    {
        super(new GeneralAnalyticsURLBuilder(), null);
    }

    String getPOSTBody(GeneralAnalyticsData generalanalyticsdata)
    {
        return (new com.pointinside.internal.utils.IOUtils.AnalyticsPOSTData(new BaseAnalyticsData[] {
            generalanalyticsdata
        })).getJSONString();
    }

    public void sendAnalyticsInfo(GeneralAnalyticsData generalanalyticsdata)
        throws PIException
    {
        GeneralAnalyticsData generalanalyticsdata1;
        GeneralAnalyticsData generalanalyticsdata2;
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        generalanalyticsdata2 = obj;
        generalanalyticsdata1 = obj1;
        lastPostBody = getPOSTBody(generalanalyticsdata);
        generalanalyticsdata2 = obj;
        generalanalyticsdata1 = obj1;
        generalanalyticsdata = ((GeneralAnalyticsURLBuilder)URL).openConnection();
        generalanalyticsdata2 = generalanalyticsdata;
        generalanalyticsdata1 = generalanalyticsdata;
        IOUtils.executeHttpPostRequest(generalanalyticsdata, lastPostBody);
        if (generalanalyticsdata != null)
        {
            generalanalyticsdata.disconnect();
        }
        return;
        generalanalyticsdata;
        generalanalyticsdata1 = generalanalyticsdata2;
        throw new PIException(generalanalyticsdata);
        generalanalyticsdata;
        if (generalanalyticsdata1 != null)
        {
            generalanalyticsdata1.disconnect();
        }
        throw generalanalyticsdata;
    }
}
