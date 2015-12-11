// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.activities:
//            ic, TruYouInitActivity

final class id
    implements com.facebook.GraphRequest.GraphJSONObjectCallback
{

    private ic a;

    id(ic ic1)
    {
        a = ic1;
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
        g.a(this, (new StringBuilder("Logging user out due to invalid FB Session, error message [")).append(jsonobject).append("]").toString());
        TruYouInitActivity.c(a.a);
        TruYouInitActivity.a(a.a, false);
        return;
        jsonobject;
        g.a(this, jsonobject);
        return;
    }
}
