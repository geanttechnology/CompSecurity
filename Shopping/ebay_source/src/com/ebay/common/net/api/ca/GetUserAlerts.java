// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.ca;

import com.ebay.common.model.ClientAlertsSession;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.model.mdns.PlatformNotificationsEvent;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetUserAlerts
{
    private static class GetUserAlertsRequest extends EbayRequest
    {

        private final ClientAlertsSession session;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return null;
        }

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL(EbaySettings.getClientAlertGetAlerts(session.id, session.data));
            }
            catch (MalformedURLException malformedurlexception)
            {
                return null;
            }
            return url;
        }

        public GetUserAlertsResponse getResponse()
        {
            return new GetUserAlertsResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public GetUserAlertsRequest(ClientAlertsSession clientalertssession)
        {
            session = clientalertssession;
        }
    }

    private static class GetUserAlertsResponse extends EbayResponse
    {

        com.ebay.common.model.mdns.PlatformNotificationsEvent.ClientAlertsData caData;

        private PlatformNotificationsEvent getBucksExpiringEvent(JSONObject jsonobject, String s)
            throws JSONException
        {
            PlatformNotificationsEvent platformnotificationsevent = new PlatformNotificationsEvent();
            platformnotificationsevent.eventType = s;
            platformnotificationsevent.title = jsonobject.getString("Title");
            return platformnotificationsevent;
        }

        private PlatformNotificationsEvent getCommonItemEvent(JSONObject jsonobject, String s)
            throws JSONException
        {
            PlatformNotificationsEvent platformnotificationsevent = new PlatformNotificationsEvent();
            setCommonItemEventValues(jsonobject, platformnotificationsevent, s);
            platformnotificationsevent.title = jsonobject.getString("Title");
            return platformnotificationsevent;
        }

        private PlatformNotificationsEvent getCouponEvent(JSONObject jsonobject, String s)
            throws JSONException
        {
            PlatformNotificationsEvent platformnotificationsevent = new PlatformNotificationsEvent();
            setCommonItemEventValues(jsonobject, platformnotificationsevent, s);
            platformnotificationsevent.title = jsonobject.getString("Title");
            platformnotificationsevent.code = jsonobject.getString("Code");
            return platformnotificationsevent;
        }

        private PlatformNotificationsEvent getItemEventNoTitle(JSONObject jsonobject, String s)
            throws JSONException
        {
            PlatformNotificationsEvent platformnotificationsevent = new PlatformNotificationsEvent();
            setCommonItemEventValues(jsonobject, platformnotificationsevent, s);
            return platformnotificationsevent;
        }

        private PlatformNotificationsEvent getMessageEvent(JSONObject jsonobject, String s)
            throws JSONException
        {
            PlatformNotificationsEvent platformnotificationsevent = new PlatformNotificationsEvent();
            setCommonItemEventValues(jsonobject, platformnotificationsevent, s);
            platformnotificationsevent.itemId = jsonobject.getString("MessageID");
            platformnotificationsevent.title = "";
            return platformnotificationsevent;
        }

        private com.ebay.common.model.mdns.PlatformNotificationsEvent.OutbidEvent getOutbidEvent(JSONObject jsonobject, String s)
            throws JSONException
        {
            com.ebay.common.model.mdns.PlatformNotificationsEvent.OutbidEvent outbidevent = new com.ebay.common.model.mdns.PlatformNotificationsEvent.OutbidEvent();
            setCommonItemEventValues(jsonobject, outbidevent, s);
            outbidevent.title = jsonobject.getString("Title");
            outbidevent.highBidderUserId = jsonobject.getString("HighBidderUserID");
            outbidevent.highBidderEiasToken = jsonobject.getString("HighBidderEIASToken");
            outbidevent.sellerUserId = jsonobject.getString("SellerUserID");
            jsonobject = jsonobject.getJSONObject("MinimumToBid");
            outbidevent.minimumToBid = new CurrencyAmount(jsonobject.getString("Value"), jsonobject.getString("CurrencyID"));
            return outbidevent;
        }

        private com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemAddedToWatchListEvent getWatchListEvent(JSONObject jsonobject, String s)
            throws JSONException
        {
            com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemAddedToWatchListEvent itemaddedtowatchlistevent = new com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemAddedToWatchListEvent();
            setCommonItemEventValues(jsonobject, itemaddedtowatchlistevent, s);
            itemaddedtowatchlistevent.quantity = jsonobject.getInt("Quantity");
            return itemaddedtowatchlistevent;
        }

        private void setCommonItemEventValues(JSONObject jsonobject, PlatformNotificationsEvent platformnotificationsevent, String s)
            throws JSONException
        {
            platformnotificationsevent.eventType = s;
            platformnotificationsevent.itemId = jsonobject.getString("ItemID");
            try
            {
                platformnotificationsevent.timestamp = EbayDateFormat.parse(jsonobject.getString("Timestamp")).getTime();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                platformnotificationsevent.timestamp = jsonobject.getLong("Timestamp");
            }
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            inputstream = StreamUtil.jsonObjectFromStream(inputstream);
            if (inputstream.getString("Ack").equals("Success"))
            {
                break MISSING_BLOCK_LABEL_137;
            }
            inputstream = inputstream.getJSONArray("Errors");
            if (inputstream == null)
            {
                break MISSING_BLOCK_LABEL_131;
            }
            ResultStatus resultstatus;
            List list;
            EbayResponseError ebayresponseerror;
            JSONObject jsonobject1;
            int i;
            try
            {
                resultstatus = new ResultStatus();
                list = resultstatus.initializeMessages();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                GetUserAlerts.logger.logAsError("Exception parsing JSON", inputstream);
                return;
            }
            i = 0;
            if (i >= inputstream.length())
            {
                break; /* Loop/switch isn't completed */
            }
            ebayresponseerror = new EbayResponseError();
            jsonobject1 = inputstream.getJSONObject(i);
            ebayresponseerror.shortMessage = jsonobject1.getString("ShortMessage");
            ebayresponseerror.longMessage = jsonobject1.getString("LongMessage");
            ebayresponseerror.code = jsonobject1.getString("ErrorCode");
            list.add(ebayresponseerror);
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_46;
_L1:
            setResultStatus(resultstatus);
            ackCode = -1;
            return;
            ackCode = 1;
            caData.sessionData = inputstream.getString("SessionData");
            if (inputstream.has("ClientAlerts")) goto _L4; else goto _L3
_L3:
            if (GetUserAlerts.logger.isLoggable)
            {
                GetUserAlerts.logger.log("Call was success but no alerts");
                return;
            }
              goto _L5
_L4:
            JSONArray jsonarray;
            int k;
            jsonarray = inputstream.getJSONObject("ClientAlerts").getJSONArray("ClientAlertEvent");
            k = jsonarray.length();
            int j = 0;
_L24:
            if (j >= k) goto _L5; else goto _L6
_L6:
            JSONObject jsonobject;
            jsonobject = jsonarray.getJSONObject(j);
            if (GetUserAlerts.logger.isLoggable)
            {
                GetUserAlerts.logger.log((new StringBuilder()).append("Parsing event object=").append(jsonobject.toString()).toString());
            }
            inputstream = jsonobject.getString("EventType");
            if (GetUserAlerts.logger.isLoggable)
            {
                GetUserAlerts.logger.log((new StringBuilder()).append("EventType=").append(inputstream).toString());
            }
            if (!inputstream.equals(com.ebay.common.model.mdns.NotificationPreference.AlertType.OutBid.name())) goto _L8; else goto _L7
_L7:
            jsonobject = jsonobject.getJSONObject("Outbid");
_L12:
            if (jsonobject != null) goto _L10; else goto _L9
_L9:
            if (GetUserAlerts.logger.isLoggable)
            {
                GetUserAlerts.logger.log((new StringBuilder()).append("NULL json object, alert type: ").append(inputstream).toString());
            }
              goto _L11
_L8:
            jsonobject = jsonobject.getJSONObject(inputstream);
              goto _L12
_L10:
            if (GetUserAlerts.logger.isLoggable)
            {
                GetUserAlerts.logger.log((new StringBuilder()).append("json object=").append(jsonobject.toString()).toString());
            }
            Object obj = null;
            String s;
            int l;
            l = NotificationPreference.clientAlertNameToId(inputstream);
            s = NotificationPreference.idToName(l);
            inputstream = obj;
            l;
            JVM INSTR tableswitch 0 20: default 692
        //                       0 605
        //                       1 627
        //                       2 540
        //                       3 616
        //                       4 616
        //                       5 616
        //                       6 627
        //                       7 627
        //                       8 638
        //                       9 638
        //                       10 627
        //                       11 540
        //                       12 649
        //                       13 540
        //                       14 540
        //                       15 594
        //                       16 540
        //                       17 540
        //                       18 660
        //                       19 540
        //                       20 671;
               goto _L13 _L14 _L15 _L16 _L17 _L17 _L17 _L15 _L15 _L18 _L18 _L15 _L16 _L19 _L16 _L16 _L20 _L16 _L16 _L21 _L16 _L22
_L16:
            if (inputstream == null) goto _L11; else goto _L23
_L23:
            caData.events.add(inputstream);
            if (GetUserAlerts.logger.isLoggable)
            {
                GetUserAlerts.logger.log((new StringBuilder()).append("Adding event=").append(inputstream).toString());
            }
              goto _L11
_L20:
            inputstream = getWatchListEvent(jsonobject, s);
              goto _L16
_L14:
            inputstream = getOutbidEvent(jsonobject, s);
              goto _L16
_L17:
            inputstream = getItemEventNoTitle(jsonobject, s);
              goto _L16
_L15:
            inputstream = getCommonItemEvent(jsonobject, s);
              goto _L16
_L18:
            inputstream = getItemEventNoTitle(jsonobject, s);
              goto _L16
_L19:
            inputstream = getMessageEvent(jsonobject, s);
              goto _L16
_L21:
            inputstream = getCouponEvent(jsonobject, s);
              goto _L16
_L22:
            inputstream = getBucksExpiringEvent(jsonobject, s);
              goto _L16
_L5:
            return;
_L11:
            j++;
              goto _L24
_L13:
            inputstream = obj;
              goto _L16
        }

        private GetUserAlertsResponse()
        {
            caData = new com.ebay.common.model.mdns.PlatformNotificationsEvent.ClientAlertsData();
        }

    }


    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("GetUserAlerts", 3, "Log get user alerts");

    public GetUserAlerts()
    {
    }

    public static ArrayList getUserAlerts(EbayContext ebaycontext, ClientAlertsSession clientalertssession)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        GetUserAlertsRequest getuseralertsrequest = new GetUserAlertsRequest(clientalertssession);
        if (logger.isLoggable)
        {
            logger.log("Making GetUserAlertsRequest");
        }
        ebaycontext = (GetUserAlertsResponse)EbayRequestHelper.sendRequest(ebaycontext, getuseralertsrequest);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Got response ackCode=").append(((GetUserAlertsResponse) (ebaycontext)).ackCode).toString());
            if (((GetUserAlertsResponse) (ebaycontext)).ackCode == 1)
            {
                logger.log((new StringBuilder()).append("Ack Success, session data=").append(((GetUserAlertsResponse) (ebaycontext)).caData.sessionData).toString());
            }
        }
        clientalertssession.data = ((GetUserAlertsResponse) (ebaycontext)).caData.sessionData;
        return ((GetUserAlertsResponse) (ebaycontext)).caData.events;
    }


}
