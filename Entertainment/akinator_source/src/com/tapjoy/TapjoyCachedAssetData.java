// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy:
//            TapjoyLog, TapjoyUtil

public class TapjoyCachedAssetData
    implements Serializable
{

    private long a;
    private long b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;
    private String h;

    public TapjoyCachedAssetData(String s, String s1, long l)
    {
        this(s, s1, l, System.currentTimeMillis() / 1000L);
    }

    public TapjoyCachedAssetData(String s, String s1, long l, long l1)
    {
        setAssetURL(s);
        setLocalFilePath(s1);
        b = l;
        a = l1;
        f = l1 + l;
    }

    public static TapjoyCachedAssetData fromJSONObject(JSONObject jsonobject)
    {
        Object obj;
        obj = jsonobject.getString("assetURL");
        String s = jsonobject.getString("localFilePath");
        long l = jsonobject.getLong("timestamp");
        obj = new TapjoyCachedAssetData(((String) (obj)), s, jsonobject.getLong("timeToLive"), l);
        ((TapjoyCachedAssetData) (obj)).setOfferID(jsonobject.optString("offerID"));
        return ((TapjoyCachedAssetData) (obj));
        jsonobject;
        jsonobject = null;
_L2:
        TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
        return jsonobject;
        jsonobject;
        jsonobject = ((JSONObject) (obj));
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static TapjoyCachedAssetData fromRawJSONString(String s)
    {
        try
        {
            s = fromJSONObject(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- error reading json string");
            return null;
        }
        return s;
    }

    public String getAssetURL()
    {
        return c;
    }

    public String getLocalFilePath()
    {
        return d;
    }

    public String getLocalURL()
    {
        return e;
    }

    public String getMimeType()
    {
        return g;
    }

    public String getOfferId()
    {
        return h;
    }

    public long getTimeOfDeathInSeconds()
    {
        return f;
    }

    public long getTimeToLiveInSeconds()
    {
        return b;
    }

    public long getTimestampInSeconds()
    {
        return a;
    }

    public void resetTimeToLive(long l)
    {
        b = l;
        f = System.currentTimeMillis() / 1000L + l;
    }

    public void setAssetURL(String s)
    {
        c = s;
        g = TapjoyUtil.determineMimeType(s);
    }

    public void setLocalFilePath(String s)
    {
        d = s;
        e = (new StringBuilder("file://")).append(s).toString();
    }

    public void setOfferID(String s)
    {
        h = s;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("timestamp", getTimestampInSeconds());
            jsonobject.put("timeToLive", getTimeToLiveInSeconds());
            jsonobject.put("assetURL", getAssetURL());
            jsonobject.put("localFilePath", getLocalFilePath());
            jsonobject.put("offerID", getOfferId());
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public String toRawJSONString()
    {
        return toJSON().toString();
    }
}
