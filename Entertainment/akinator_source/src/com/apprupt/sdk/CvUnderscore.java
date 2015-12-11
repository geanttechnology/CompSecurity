// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            CvAppInfo, CvGeoLocation, Connectivity, Logger, 
//            CvCrypto

public class CvUnderscore
{

    private final JSONObject data = new JSONObject();

    private CvUnderscore()
    {
    }

    static CvUnderscore create()
    {
        return createEmpty().addBaseTracking();
    }

    static CvUnderscore createEmpty()
    {
        return new CvUnderscore();
    }

    CvUnderscore addBaseTracking()
    {
        addUid();
        CvAppInfo cvappinfo = CvAppInfo.getInstance();
        put("deviceInfo", cvappinfo.getDeviceInfo());
        put("bundleId", cvappinfo.getAppId());
        put("screen", cvappinfo.getScreenInfo());
        put("optOut", Boolean.valueOf(cvappinfo.optedOut()));
        put("geo", CvGeoLocation.getCurrent());
        put("bssid", cvappinfo.getBSSID());
        put("locale", cvappinfo.getLocaleId());
        put("language", cvappinfo.getLanguageCode());
        put("country", cvappinfo.getCountryCode());
        put("connectionType", cvappinfo.connectivity().connectionType());
        put("carrier", cvappinfo.getCarrier());
        return this;
    }

    CvUnderscore addUid()
    {
        put("uid", CvAppInfo.getInstance().getUid());
        return this;
    }

    CvUnderscore extend(Map map)
    {
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); put(s, map.get(s)))
        {
            s = (String)iterator.next();
        }

        return this;
    }

    CvUnderscore extend(JSONObject jsonobject)
    {
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            try
            {
                put(s, jsonobject.get(s));
            }
            catch (JSONException jsonexception)
            {
                Logger.get().e(jsonexception, new Object[] {
                    "Invalid JSON key", s
                });
            }
        }

        return this;
    }

    public JSONObject getJSON()
    {
        return data;
    }

    CvUnderscore put(String s, Object obj)
    {
        try
        {
            data.put(s, obj);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.get().e(s, new Object[] {
                "Invalid value passed to JSON"
            });
            return this;
        }
        return this;
    }

    public String toString()
    {
        return CvCrypto.encode(data.toString().getBytes());
    }
}
