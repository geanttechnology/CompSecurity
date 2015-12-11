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
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class TagGroupsAPIClient
{

    private static final String ADD_KEY = "add";
    private static final String AMAZON_CHANNEL_KEY = "amazon_channel";
    private static final String ANDROID_CHANNEL_KEY = "android_channel";
    private static final String AUDIENCE_KEY = "audience";
    private static final String CHANNEL_TAGS_PATH = "api/channels/tags/";
    private static final String NAMED_USER_ID_KEY = "named_user_id";
    private static final String NAMED_USER_TAGS_PATH = "api/named_users/tags/";
    private static final String REMOVE_KEY = "remove";
    private final String appKey;
    private final String appSecret;
    private final RequestFactory requestFactory;
    private final String urlString;

    TagGroupsAPIClient(AirshipConfigOptions airshipconfigoptions)
    {
        this(airshipconfigoptions, new RequestFactory());
    }

    public TagGroupsAPIClient(AirshipConfigOptions airshipconfigoptions, RequestFactory requestfactory)
    {
        requestFactory = requestfactory;
        urlString = airshipconfigoptions.hostURL;
        appKey = airshipconfigoptions.getAppKey();
        appSecret = airshipconfigoptions.getAppSecret();
    }

    private Response request(URL url, String s, String s1, Map map, Map map1)
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        hashmap1.put(s, s1);
        hashmap.put("audience", hashmap1);
        if (!map.isEmpty())
        {
            hashmap.put("add", map);
        }
        if (!map1.isEmpty())
        {
            hashmap.put("remove", map1);
        }
        try
        {
            s = JsonValue.wrap(hashmap).toString();
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Logger.error("Failed to create channel tag groups payload as json.", url);
            return null;
        }
        Logger.info((new StringBuilder("Updating tag groups with payload: ")).append(s).toString());
        url = requestFactory.createRequest("POST", url).setCredentials(appKey, appSecret).setRequestBody(s, "application/json").setHeader("Accept", "application/vnd.urbanairship+json; version=3;").execute();
        if (url == null)
        {
            Logger.error("Failed to receive a response for tag groups.");
            return url;
        } else
        {
            Logger.debug((new StringBuilder("Received a response for tag groups: ")).append(url).toString());
            return url;
        }
    }

    String getChannelType()
    {
        switch (UAirship.shared().getPlatformType())
        {
        default:
            return null;

        case 2: // '\002'
            return "android_channel";

        case 1: // '\001'
            return "amazon_channel";
        }
    }

    URL getTagURL(String s)
    {
        try
        {
            s = new URL((new StringBuilder()).append(urlString).append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error("Invalid tag URL.", s);
            return null;
        }
        return s;
    }

    Response updateChannelTags(String s, Map map, Map map1)
    {
        URL url = getTagURL("api/channels/tags/");
        if (url == null)
        {
            Logger.error("The channel tags URL cannot be null.");
            return null;
        }
        if (map.isEmpty() && map1.isEmpty())
        {
            Logger.error("Both addTags and removeTags cannot be empty.");
            return null;
        } else
        {
            return request(url, getChannelType(), s, map, map1);
        }
    }

    Response updateNamedUserTags(String s, Map map, Map map1)
    {
        URL url = getTagURL("api/named_users/tags/");
        if (url == null)
        {
            Logger.error("The named user tags URL cannot be null.");
            return null;
        }
        if (map.isEmpty() && map1.isEmpty())
        {
            Logger.error("Both addTags and removeTags cannot be empty.");
            return null;
        } else
        {
            return request(url, "named_user_id", s, map, map1);
        }
    }
}
