// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestFactory;
import com.urbanairship.http.Response;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

class NamedUserAPIClient
{

    static final String CHANNEL_KEY = "channel_id";
    static final String DEVICE_TYPE_KEY = "device_type";
    static final String NAMED_USER_ID_KEY = "named_user_id";
    static final String NAMED_USER_PATH = "api/named_users";
    private final RequestFactory requestFactory;
    protected final String urlString;

    NamedUserAPIClient()
    {
        this(new RequestFactory());
    }

    NamedUserAPIClient(RequestFactory requestfactory)
    {
        requestFactory = requestfactory;
        urlString = (new StringBuilder()).append(UAirship.shared().getAirshipConfigOptions().hostURL).append("api/named_users").toString();
    }

    private Response request(URL url, String s)
    {
        String s1 = UAirship.shared().getAirshipConfigOptions().getAppKey();
        String s2 = UAirship.shared().getAirshipConfigOptions().getAppSecret();
        url = requestFactory.createRequest("POST", url).setCredentials(s1, s2).setRequestBody(s, "application/json").setHeader("Accept", "application/vnd.urbanairship+json; version=3;").execute();
        if (url == null)
        {
            Logger.error("Failed to receive a response for named user.");
            return url;
        } else
        {
            Logger.debug((new StringBuilder("Received a response for named user: ")).append(url).toString());
            return url;
        }
    }

    Response associate(String s, String s1)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("channel_id", s1);
            jsonobject.put("device_type", getDeviceType());
            jsonobject.put("named_user_id", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error("Failed to create associate named user payload as json.", s);
        }
        s = (new StringBuilder()).append(urlString).append("/associate").toString();
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error("Invalid hostURL", s);
            return null;
        }
        return request(s, jsonobject.toString());
    }

    Response disassociate(String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("channel_id", s);
            jsonobject.put("device_type", getDeviceType());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error("Failed to create disassociate named user payload as json.", s);
        }
        s = (new StringBuilder()).append(urlString).append("/disassociate").toString();
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error("Invalid hostURL", s);
            return null;
        }
        return request(s, jsonobject.toString());
    }

    String getDeviceType()
    {
        switch (UAirship.shared().getPlatformType())
        {
        default:
            return null;

        case 2: // '\002'
            return "android";

        case 1: // '\001'
            return "amazon";
        }
    }
}
