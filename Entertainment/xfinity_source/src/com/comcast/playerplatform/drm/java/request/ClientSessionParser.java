// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import android.util.Base64;
import com.adobe.ave.drm.DRMLicense;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientSessionParser
{

    private String deviceId;
    private String notOnOrAfter;
    private boolean parsed;
    private Map properties;
    private String token;

    public ClientSessionParser(DRMLicense drmlicense)
    {
        parsed = false;
        parse(drmlicense);
    }

    private void parse(DRMLicense drmlicense)
    {
        try
        {
            token = Base64.encodeToString((new String((byte[])drmlicense.getCustomProperties().get("client:authnToken"))).getBytes(), 2);
            notOnOrAfter = new String((byte[])drmlicense.getCustomProperties().get("client:authnTokenNotOnOrAfter"));
            if (drmlicense.getCustomProperties().containsKey("client:authnTokenClaims"))
            {
                parsePropertiesJson(new JSONObject(new String((byte[])drmlicense.getCustomProperties().get("client:authnTokenClaims"))));
            }
            if (drmlicense.getCustomProperties().containsKey("client:providerDeviceId"))
            {
                deviceId = new String((byte[])drmlicense.getCustomProperties().get("client:providerDeviceId"));
            }
            parsed = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DRMLicense drmlicense)
        {
            parsed = false;
        }
    }

    private void parsePropertiesJson(JSONObject jsonobject)
        throws JSONException
    {
        properties = new Hashtable();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); properties.put(s, jsonobject.get(s).toString()))
        {
            s = iterator.next().toString();
        }

    }

    public String getDeviceId()
    {
        if (properties != null && properties.containsKey("device:xcal:id"))
        {
            return (String)properties.get("device:xcal:id");
        } else
        {
            return deviceId;
        }
    }

    public Boolean getInHome()
    {
        if (properties != null && properties.containsKey("device:xcal:locationInHome"))
        {
            return Boolean.valueOf((String)properties.get("device:xcal:locationInHome"));
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public String getNotOnOrAfter()
    {
        return notOnOrAfter;
    }

    public Map getProperties()
    {
        return properties;
    }

    public String getToken()
    {
        return token;
    }

    public boolean isParsed()
    {
        return parsed;
    }
}
