// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.Logger;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            Event

class InstallAttributionEvent extends Event
{

    private static final String PLAY_STORE_REFERRER = "google_play_referrer";
    private static final String TYPE = "install_attribution";
    private final String referrer;

    public InstallAttributionEvent(String s)
    {
        referrer = s;
    }

    protected JSONObject getEventData()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.putOpt("google_play_referrer", referrer);
        }
        catch (JSONException jsonexception)
        {
            Logger.error("InstallAttributionEvent - Error constructing JSON data.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public String getType()
    {
        return "install_attribution";
    }
}
