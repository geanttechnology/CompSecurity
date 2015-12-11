// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import com.b.a.a.g;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.offerup.android.utils.ba;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.service:
//            d, ApplicationStartupService

final class e
    implements com.facebook.GraphRequest.GraphJSONObjectCallback
{

    private d a;

    e(d d1)
    {
        a = d1;
        super();
    }

    public final void onCompleted(JSONObject jsonobject, GraphResponse graphresponse)
    {
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        String s = "";
        jsonobject = s;
        if (graphresponse != null)
        {
            jsonobject = s;
            if (graphresponse.getError() != null)
            {
                jsonobject = graphresponse.getError().getErrorMessage();
            }
        }
        g.a(ApplicationStartupService.c(a.a), (new StringBuilder("Logging user out due to invalid FB Session, error message [")).append(jsonobject).append("]").toString());
        ba.a(a.a.getApplicationContext());
        return;
        jsonobject;
        g.a(ApplicationStartupService.c(a.a), jsonobject);
        return;
    }
}
