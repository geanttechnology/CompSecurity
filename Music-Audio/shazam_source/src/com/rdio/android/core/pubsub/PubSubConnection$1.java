// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.pubsub;

import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.util.Logging;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.pubsub:
//            PubSubConnection

class this._cls0
    implements com.rdio.android.core.ponseListener
{

    final PubSubConnection this$0;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (!rdioapiresponse.isSuccess())
        {
            PubSubConnection.access$000(PubSubConnection.this).log(6, "PubSubConnection", (new StringBuilder("pubsubInfo server response was not successful: ")).append(rdioapiresponse.getErrorMessage()).toString());
            return;
        }
        rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
        try
        {
            PubSubConnection.access$102(PubSubConnection.this, rdioapiresponse.getString("token"));
            PubSubConnection.access$202(PubSubConnection.this, rdioapiresponse.getString("topic"));
            PubSubConnection.access$302(PubSubConnection.this, rdioapiresponse.getJSONArray("servers"));
            PubSubConnection.access$402(PubSubConnection.this, 0);
            PubSubConnection.access$500(PubSubConnection.this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiResponse rdioapiresponse)
        {
            PubSubConnection.access$000(PubSubConnection.this).log(6, "PubSubConnection", "Failed to get pub sub info");
        }
        PubSubConnection.access$000(PubSubConnection.this).logException(rdioapiresponse, true);
        PubSubConnection.access$302(PubSubConnection.this, new JSONArray());
        PubSubConnection.access$600(PubSubConnection.this);
    }

    stener()
    {
        this$0 = PubSubConnection.this;
        super();
    }
}
