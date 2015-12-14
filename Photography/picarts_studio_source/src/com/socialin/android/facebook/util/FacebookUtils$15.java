// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.socialin.android.d;
import com.socialin.android.facebook.l;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class c
    implements com.facebook.back
{

    private List a;
    private List b;
    private AccessToken c;

    public final void onCompleted(GraphResponse graphresponse)
    {
        int i;
        if (graphresponse.getError() != null)
        {
            return;
        }
        graphresponse = graphresponse.getJSONObject();
        JSONObject jsonobject;
        try
        {
            graphresponse = graphresponse.getJSONArray("data");
        }
        // Misplaced declaration of an exception variable
        catch (GraphResponse graphresponse)
        {
            d.a(FacebookUtils.access$700(), "getPermissions", graphresponse);
            return;
        }
        i = 0;
_L2:
        if (i >= graphresponse.length())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        jsonobject = graphresponse.getJSONObject(i);
        if ("granted".equals(jsonobject.getString("status")))
        {
            a.add(jsonobject.getString("permission"));
            break MISSING_BLOCK_LABEL_164;
        }
        if ("declined".equals(jsonobject.getString("status")))
        {
            b.add(jsonobject.getString("permission"));
        }
        break MISSING_BLOCK_LABEL_164;
        AccessToken.setCurrentAccessToken(new AccessToken(c.getToken(), FacebookSdk.getApplicationId(), FacebookUtils.access$300().a, a, b, AccessTokenSource.FACEBOOK_APPLICATION_WEB, c.getExpires(), null));
        FacebookUtils.setConnectionState(true);
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    _cls9(List list, List list1, AccessToken accesstoken)
    {
        a = list;
        b = list1;
        c = accesstoken;
        super();
    }
}
