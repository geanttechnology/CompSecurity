// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import com.facebook.GraphResponse;
import com.socialin.android.util.aj;

// Referenced classes of package com.socialin.android.facebook.util:
//            a

final class a
    implements com.facebook.hRequest.Callback
{

    private a a;

    public final void onCompleted(GraphResponse graphresponse)
    {
label0:
        {
            org.json.JSONObject jsonobject;
            if (graphresponse != null)
            {
                jsonobject = graphresponse.getJSONObject();
            } else
            {
                jsonobject = null;
            }
            if (com.socialin.android.facebook.util.a.a(a) != null)
            {
                if (jsonobject != null && graphresponse.getError() == null)
                {
                    break label0;
                }
                com.socialin.android.facebook.util.a.a(a).b();
            }
            return;
        }
        com.socialin.android.facebook.util.a.a(a).a();
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
