// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.apls;

import android.text.TextUtils;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.AsBeacon;
import com.ebay.nautilus.kernel.net.AsMark;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.apls:
//            AplsClientInfo, AplsReportInfo, AplsFormatHelper, AplsService, 
//            AplsErrorReport, AplsLogMessageResponse

public final class AplsLogMessageRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String OPERATION_NAME = "logMessage";
    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    public static final String SERVICE_NAME = "ApplicationLoggingService";
    private final List beacons;
    private final AplsClientInfo clientInfo;
    private final List errors;
    private final AplsReportInfo reportInfo;
    private final List services;

    public AplsLogMessageRequest(AplsClientInfo aplsclientinfo, AplsReportInfo aplsreportinfo, ArrayList arraylist, List list)
    {
        this(aplsclientinfo, aplsreportinfo, ((List) (arraylist)), list, null);
    }

    private AplsLogMessageRequest(AplsClientInfo aplsclientinfo, AplsReportInfo aplsreportinfo, List list, List list1, List list2)
    {
        super("ApplicationLoggingService", true, "logMessage");
        setGzipCompress(true);
        clientInfo = aplsclientinfo;
        reportInfo = aplsreportinfo;
        services = list;
        beacons = list1;
        errors = list2;
        soaContentType = "application/xml";
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
    }

    public AplsLogMessageRequest(AplsClientInfo aplsclientinfo, ArrayList arraylist)
    {
        this(aplsclientinfo, null, null, null, ((List) (arraylist)));
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        boolean flag;
        flag = DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.B.appSpeed);
        xmlserializer.setPrefix("ns2", "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "logMessageRequest");
        if (clientInfo != null)
        {
            xmlserializer.startTag(null, "clientInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "appBuildIdentifier", clientInfo.appBuildIdentifier);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "appVersion", clientInfo.appVersion);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "carrier", clientInfo.carrier);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "clientType", clientInfo.clientType);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "config", clientInfo.config);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "countryCode", clientInfo.countryCode);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "environment", clientInfo.environment);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "localeIdentifier", clientInfo.localeIdentifier);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "network", clientInfo.network);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "networkSubType", clientInfo.networkSubType);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "osName", clientInfo.osName);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "osVersion", clientInfo.osVersion);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "platform", clientInfo.platform);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "userLanguage", clientInfo.userLanguage);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "deviceGUID", clientInfo.deviceGuid);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "globalID", clientInfo.globalId);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "sessionGUID", clientInfo.sessionGuid);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "userID", clientInfo.userId);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "siteID", Integer.toString(clientInfo.siteId));
            XmlSerializerHelper.writeSimple(xmlserializer, null, "mrollp", clientInfo.mrollp);
            xmlserializer.endTag(null, "clientInfo");
        }
        if (reportInfo != null)
        {
            xmlserializer.startTag(null, "reportInfo");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "name", reportInfo.name);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "level", reportInfo.level);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "ssnStart", reportInfo.sessionStart);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "ssnEnd", reportInfo.sessionEnd);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "packageStart", reportInfo.packageStart);
            XmlSerializerHelper.writeSimple(xmlserializer, null, "packageEnd", reportInfo.packageEnd);
            xmlserializer.endTag(null, "reportInfo");
        }
        if (flag && beacons != null && !beacons.isEmpty())
        {
            for (Iterator iterator = beacons.iterator(); iterator.hasNext(); xmlserializer.endTag(null, "beacon"))
            {
                AsBeacon asbeacon = (AsBeacon)iterator.next();
                long l = 0L;
                if (reportInfo != null)
                {
                    l = asbeacon.epochTimestamp - reportInfo.epochSessionStart;
                }
                xmlserializer.startTag(null, "beacon");
                XmlSerializerHelper.writeSimple(xmlserializer, null, "beaconID", String.valueOf(asbeacon.id));
                XmlSerializerHelper.writeSimple(xmlserializer, null, "activity", asbeacon.activityName);
                if (!TextUtils.isEmpty(asbeacon.tags))
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, null, "flagsCsv", asbeacon.tags);
                }
                XmlSerializerHelper.writeSimple(xmlserializer, null, "freeRAM", String.valueOf(asbeacon.freeRam));
                if (!TextUtils.isEmpty(asbeacon.userCountry))
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, null, "userSelectedCountry", asbeacon.userCountry);
                }
                for (Iterator iterator3 = asbeacon.getMarks().iterator(); iterator3.hasNext(); xmlserializer.endTag(null, "mark"))
                {
                    AsMark asmark = (AsMark)iterator3.next();
                    xmlserializer.startTag(null, "mark");
                    xmlserializer.attribute(null, "name", asmark.name.toString());
                    xmlserializer.attribute(null, "start", String.valueOf(AplsFormatHelper.perfIntervalFormat((asmark.timestamp - asbeacon.timestamp) + l)));
                }

            }

        }
        if (services == null || services.isEmpty()) goto _L2; else goto _L1
_L1:
        Iterator iterator1 = services.iterator();
_L10:
        if (!iterator1.hasNext()) goto _L2; else goto _L3
_L3:
        Object obj;
        obj = (AplsService)iterator1.next();
        xmlserializer.startTag(null, "service");
        xmlserializer.attribute(null, "name", ((AplsService) (obj)).name);
        obj = ((AplsService) (obj)).getOperations().iterator();
_L9:
        if (!((Iterator) (obj)).hasNext()) goto _L5; else goto _L4
_L4:
        Object obj1;
        obj1 = (AplsService.Operation)((Iterator) (obj)).next();
        xmlserializer.startTag(null, "operation");
        xmlserializer.attribute(null, "name", ((AplsService.Operation) (obj1)).name);
        obj1 = ((AplsService.Operation) (obj1)).calls.iterator();
_L7:
        AplsService.Operation.Call call;
        if (!((Iterator) (obj1)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        call = (AplsService.Operation.Call)((Iterator) (obj1)).next();
        xmlserializer.startTag(null, "call");
        XmlSerializerHelper.writeSimple(xmlserializer, null, "start", call.getStart());
        XmlSerializerHelper.writeSimple(xmlserializer, null, "perf", call.getPerf());
        if (flag && call.beaconId != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, null, "beaconID", String.valueOf(call.beaconId));
        }
        if (call.bytesSent != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, null, "bytesSent", call.bytesSent);
        }
        if (call.bytesRcvd != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, null, "bytesRcvd", call.bytesRcvd);
        }
        if (call.parseDuration != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, null, "parseTime", String.valueOf(AplsFormatHelper.perfIntervalFormat(call.parseDuration.longValue())));
        }
        if (call.rlogId == null)
        {
            break MISSING_BLOCK_LABEL_1069;
        }
        XmlSerializerHelper.writeSimple(xmlserializer, null, "rlogID", call.rlogId);
_L8:
        xmlserializer.endTag(null, "call");
        if (true) goto _L7; else goto _L6
_L6:
        IllegalArgumentException illegalargumentexception;
        continue; /* Loop/switch isn't completed */
        illegalargumentexception;
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder();
        i = 0;
_L11:
        int j;
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append(',');
        }
        String s = call.rlogId;
        j = i + 1;
        stringbuilder.append(Integer.toHexString(s.charAt(i)));
        if (j < call.rlogId.length())
        {
            break MISSING_BLOCK_LABEL_1550;
        }
        stringbuilder.insert(0, "encoding failed, raw value=(");
        stringbuilder.append(')');
        XmlSerializerHelper.writeSimple(xmlserializer, null, "rlogID", stringbuilder.toString());
          goto _L8
        xmlserializer.endTag(null, "operation");
          goto _L9
_L5:
        xmlserializer.endTag(null, "service");
          goto _L10
_L2:
        if (errors != null && !errors.isEmpty())
        {
            for (Iterator iterator2 = errors.iterator(); iterator2.hasNext(); xmlserializer.endTag(null, "errorReport"))
            {
                AplsErrorReport aplserrorreport = (AplsErrorReport)iterator2.next();
                xmlserializer.startTag(null, "errorReport");
                XmlSerializerHelper.writeSimple(xmlserializer, null, "clientData", aplserrorreport.getClientData());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "countryCode", aplserrorreport.getCountryCode());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "elapsedTime", aplserrorreport.getElapsedTime());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "errorCode", aplserrorreport.getErrorCode());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "errorDomain", aplserrorreport.getErrorDomain());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "level", aplserrorreport.getLevel());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "longErrorMessage", aplserrorreport.getLongErrorMessage());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "name", aplserrorreport.getName());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "poolName", aplserrorreport.getPoolName());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "recentImpressions", aplserrorreport.getRecentImpressions());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "recentSearches", aplserrorreport.getRecentSearches());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "requestStartTime", aplserrorreport.getRequestStartTime());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "serverAddress", aplserrorreport.getServerAddress());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "serverName", aplserrorreport.getServerName());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "serviceName", aplserrorreport.getServiceName());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "url", aplserrorreport.getUrl());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "backtrace", aplserrorreport.getBackTrace());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "globalID", aplserrorreport.getGlobalId());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "lastViewedItemID", aplserrorreport.getLastViewedItemId());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "rlogID", aplserrorreport.getRlogId());
                XmlSerializerHelper.writeSimple(xmlserializer, null, "serviceOperation", aplserrorreport.getServiceOperationName());
            }

        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "logMessageRequest");
        return;
        i = j;
          goto _L11
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public URL getRequestUrl()
    {
        if (errors == null)
        {
            return ApiSettings.getUrl(ApiSettings.apls2TrafficUrl);
        } else
        {
            return ApiSettings.getUrl(ApiSettings.apls2ErrorUrl);
        }
    }

    public AplsLogMessageResponse getResponse()
    {
        return new AplsLogMessageResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public boolean isErrorReportable()
    {
        return false;
    }

    public boolean isTrafficReportable()
    {
        return false;
    }
}
