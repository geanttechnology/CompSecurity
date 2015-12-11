// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.ca;

import com.ebay.common.model.ClientAlertsSession;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class CaLogin
{
    private static class CaLoginRequest extends EbayRequest
    {

        private final String caAuthToken;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return null;
        }

        public URL getRequestUrl()
        {
            Object obj = EbaySettings.getClientAlertLogin(caAuthToken);
            try
            {
                obj = new URL(((String) (obj)));
            }
            catch (MalformedURLException malformedurlexception)
            {
                return null;
            }
            return ((URL) (obj));
        }

        public CaLoginResponse getResponse()
        {
            return new CaLoginResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected CaLoginRequest(String s)
        {
            caAuthToken = s;
            setServiceName("ClientAlerts");
            setOperationName("login");
        }
    }

    private static class CaLoginResponse extends EbayResponse
    {

        public ClientAlertsSession session;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            inputstream = StreamUtil.jsonObjectFromStream(inputstream);
            if (inputstream.getString("Ack").equals("Success"))
            {
                session.id = inputstream.getString("SessionID");
                session.data = inputstream.getString("SessionData");
                ackCode = 1;
                inputstream = EbayDateFormat.parse(inputstream.getString("Timestamp"));
                session.timestamp = inputstream.getTime();
                return;
            }
            try
            {
                if (CaLogin.logger.isLoggable)
                {
                    CaLogin.logger.log((new StringBuilder()).append("Ack=").append(inputstream.getString("Ack")).toString());
                }
                ackCode = -1;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                CaLogin.logger.logAsError("Exception parsing JSON", inputstream);
                ackCode = -1;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                CaLogin.logger.logAsError("Exception parsing timestamp", inputstream);
            }
            return;
        }

        private CaLoginResponse()
        {
            session = new ClientAlertsSession();
        }

    }


    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CaLogin", 3, "Log client alerts login");

    public CaLogin()
    {
    }

    public static ClientAlertsSession login(EbayContext ebaycontext, String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        CaLoginRequest caloginrequest = new CaLoginRequest(s);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Making request using caAuthToken=").append(s).toString());
        }
        ebaycontext = (CaLoginResponse)EbayRequestHelper.sendRequest(ebaycontext, caloginrequest);
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Got response session=").append(((CaLoginResponse) (ebaycontext)).session.toString()).toString());
        }
        return ((CaLoginResponse) (ebaycontext)).session;
    }


}
