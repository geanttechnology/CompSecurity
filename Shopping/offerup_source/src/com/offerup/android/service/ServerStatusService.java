// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.e.a;
import android.util.Log;
import com.b.a.a.g;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.offerup.android.network.b;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.service:
//            h

public class ServerStatusService extends IntentService
{

    public ServerStatusService()
    {
        super("ServerStatusService");
    }

    protected void onHandleIntent(Intent intent)
    {
        intent = null;
        JSONObject jsonobject;
        try
        {
            if (!a.b(getApplicationContext()))
            {
                break MISSING_BLOCK_LABEL_57;
            }
            jsonobject = GraphRequest.newCustomAudienceThirdPartyIdRequest(AccessToken.getCurrentAccessToken(), getApplicationContext(), null).executeAndWait().getJSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            g.c(com/offerup/android/service/ServerStatusService.getSimpleName(), Log.getStackTraceString(intent));
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        intent = jsonobject.optString("custom_audience_third_party_id");
        b.a(getApplicationContext(), intent, new h(this));
    }
}
