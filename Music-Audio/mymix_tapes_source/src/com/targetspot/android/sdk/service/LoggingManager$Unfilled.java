// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.targetspot.android.sdk.service:
//            LoggingManager

class url extends url
{

    final LoggingManager this$0;
    public String url;

    void fromJSON(JSONObject jsonobject)
        throws JSONException
    {
        url = jsonobject.getString("url");
        attempts = jsonobject.getInt("count");
    }

    JSONObject toJSON()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("type", "unfilled");
        jsonobject.put("url", url);
        jsonobject.put("count", attempts);
        return jsonobject;
    }

    ()
    {
        this$0 = LoggingManager.this;
        super(LoggingManager.this, 0);
    }

    init>(String s, int i)
    {
        this$0 = LoggingManager.this;
        super(LoggingManager.this, i);
        url = s;
    }
}
