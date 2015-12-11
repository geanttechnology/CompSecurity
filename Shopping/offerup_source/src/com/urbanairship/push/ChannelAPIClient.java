// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestFactory;
import com.urbanairship.json.JsonValue;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.urbanairship.push:
//            ChannelResponse, ChannelRegistrationPayload

class ChannelAPIClient
{

    static final String CHANNEL_CREATION_PATH = "api/channels/";
    protected URL creationURL;
    private final RequestFactory requestFactory;

    ChannelAPIClient()
    {
        this(new RequestFactory());
    }

    ChannelAPIClient(RequestFactory requestfactory)
    {
        requestFactory = requestfactory;
        requestfactory = (new StringBuilder()).append(UAirship.shared().getAirshipConfigOptions().hostURL).append("api/channels/").toString();
        try
        {
            creationURL = new URL(requestfactory);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RequestFactory requestfactory)
        {
            creationURL = null;
        }
        Logger.error("ChannelAPIClient - Invalid hostURL    ", requestfactory);
    }

    private ChannelResponse requestWithPayload(URL url, String s, String s1)
    {
        String s2 = UAirship.shared().getAirshipConfigOptions().getAppKey();
        String s3 = UAirship.shared().getAirshipConfigOptions().getAppSecret();
        url = requestFactory.createRequest(s, url).setCredentials(s2, s3).setRequestBody(s1, "application/json").setHeader("Accept", "application/vnd.urbanairship+json; version=3;").execute();
        if (url == null)
        {
            Logger.debug("ChannelAPIClient - Failed to receive channel response.");
            return null;
        } else
        {
            Logger.verbose((new StringBuilder("ChannelAPIClient - Received channel response: ")).append(url).toString());
            return new ChannelResponse(url);
        }
    }

    ChannelResponse createChannelWithPayload(ChannelRegistrationPayload channelregistrationpayload)
    {
        channelregistrationpayload = channelregistrationpayload.toJsonValue().toString();
        Logger.verbose((new StringBuilder("ChannelAPIClient - Creating channel with payload: ")).append(channelregistrationpayload).toString());
        return requestWithPayload(creationURL, "POST", channelregistrationpayload);
    }

    ChannelResponse updateChannelWithPayload(URL url, ChannelRegistrationPayload channelregistrationpayload)
    {
        channelregistrationpayload = channelregistrationpayload.toJsonValue().toString();
        Logger.verbose((new StringBuilder("ChannelAPIClient - Updating channel with payload: ")).append(channelregistrationpayload).toString());
        return requestWithPayload(url, "PUT", channelregistrationpayload);
    }
}
