// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.auth;

import com.facebook.GraphResponse;
import org.json.JSONObject;

// Referenced classes of package com.bitstrips.imoji.auth:
//            FacebookService

class erCallback
    implements com.facebook.JSONObjectCallback
{

    final FacebookService this$0;
    final erCallback val$callback;

    public void onCompleted(JSONObject jsonobject, GraphResponse graphresponse)
    {
        if (jsonobject != null)
        {
            val$callback.success(jsonobject);
        } else
        if (graphresponse.getError() != null)
        {
            val$callback.error();
            return;
        }
    }

    erCallback()
    {
        this$0 = final_facebookservice;
        val$callback = erCallback.this;
        super();
    }
}
