// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.facebook;

import android.app.Activity;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.smule.android.c.aa;
import com.smule.android.f.r;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.smule.android.facebook:
//            a

class b
    implements com.facebook.hRequest.Callback
{

    final String a;
    final Activity b;
    final a c;

    public void onCompleted(GraphResponse graphresponse)
    {
        if (graphresponse == null)
        {
            aa.b(com.smule.android.facebook.a.j(), "Facebook response is null, possible crash incoming");
        }
        FacebookRequestError facebookrequesterror = graphresponse.getError();
        if (facebookrequesterror != null)
        {
            aa.b(com.smule.android.facebook.a.j(), (new StringBuilder()).append("Failed to publish action ").append(facebookrequesterror.getErrorMessage()).toString());
        } else
        {
            graphresponse = graphresponse.getJSONObject();
            try
            {
                graphresponse = graphresponse.getString("id");
                aa.a(com.smule.android.facebook.a.j(), (new StringBuilder()).append("publishAction - post id: ").append(graphresponse).toString());
            }
            // Misplaced declaration of an exception variable
            catch (GraphResponse graphresponse)
            {
                aa.c(com.smule.android.facebook.a.j(), (new StringBuilder()).append("JSON error ").append(graphresponse.getMessage()).toString());
            }
            if (a != null)
            {
                r.a(b, a);
                return;
            }
        }
    }

    or(a a1, String s, Activity activity)
    {
        c = a1;
        a = s;
        b = activity;
        super();
    }
}
