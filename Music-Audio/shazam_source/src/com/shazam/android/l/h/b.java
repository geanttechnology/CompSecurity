// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.h;

import com.rdio.android.core.RdioApiResponse;
import com.shazam.b.a.a;
import com.shazam.model.rdio.RdioUser;
import com.shazam.model.streaming.SubscriptionType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
    implements a
{

    public b()
    {
    }

    private static RdioUser a(RdioApiResponse rdioapiresponse)
    {
        com.shazam.model.rdio.RdioUser.Builder builder;
        JSONObject jsonobject;
        builder = com.shazam.model.rdio.RdioUser.Builder.a();
        jsonobject = (JSONObject)rdioapiresponse.getResult();
        if (!jsonobject.optBoolean("isTrial")) goto _L2; else goto _L1
_L1:
        rdioapiresponse = SubscriptionType.TRIAL;
_L5:
        builder.subscriptionType = rdioapiresponse;
        rdioapiresponse = jsonobject.optJSONObject("futureTimelineInfo");
        if (rdioapiresponse == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        rdioapiresponse = rdioapiresponse.optJSONArray("eligibleTrials");
        int i;
        if (rdioapiresponse == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        i = 0;
_L6:
        if (i >= rdioapiresponse.length())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        if (!"MOBILE_48_HOUR_TRIAL".equals(((JSONObject)rdioapiresponse.get(i)).optString("trialType"))) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L7:
        try
        {
            builder.is48hTrialAvailable = flag;
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiResponse rdioapiresponse) { }
        return new RdioUser(builder, null);
_L2:
label0:
        {
            if (!jsonobject.optBoolean("isUnlimited"))
            {
                break label0;
            }
            rdioapiresponse = SubscriptionType.UNLIMITED;
        }
          goto _L5
        rdioapiresponse = SubscriptionType.FREE;
          goto _L5
_L4:
        i++;
          goto _L6
        flag = false;
          goto _L7
    }

    public final volatile Object a(Object obj)
    {
        return a((RdioApiResponse)obj);
    }
}
