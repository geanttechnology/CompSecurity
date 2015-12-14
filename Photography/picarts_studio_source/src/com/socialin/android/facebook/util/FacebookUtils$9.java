// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.socialin.android.d;
import com.socialin.android.facebook.p;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class b
    implements p
{

    final List a;
    final p b;

    public final void a()
    {
        GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new com.facebook.GraphRequest.GraphJSONArrayCallback() {

            private FacebookUtils._cls9 a;

            public final void onCompleted(JSONArray jsonarray, GraphResponse graphresponse)
            {
                int i;
                if (graphresponse.getError() != null || jsonarray == null)
                {
                    return;
                }
                i = 0;
_L2:
                if (i >= jsonarray.length())
                {
                    break; /* Loop/switch isn't completed */
                }
                graphresponse = jsonarray.getJSONObject(i);
                a.a.add(graphresponse.getString("id"));
                i++;
                if (true) goto _L2; else goto _L1
                jsonarray;
                d.b(FacebookUtils.access$700(), "getFacebookFriends", jsonarray);
_L1:
                a.b.a();
                return;
            }

            
            {
                a = FacebookUtils._cls9.this;
                super();
            }
        }).executeAsync();
    }

    _cls1.a(List list, p p1)
    {
        a = list;
        b = p1;
        super();
    }
}
