// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import com.facebook.GraphResponse;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.facebook.util.FacebookUtils;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class a
    implements com.facebook.llPostActivity._cls1
{

    private FacebookWallPostActivity a;

    public final void onCompleted(GraphResponse graphresponse)
    {
        if (!FacebookWallPostActivity.a(a).isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        FacebookUtils.dismissDialog(FacebookWallPostActivity.a(a));
        DialogUtils.dismissDialog(FacebookWallPostActivity.a(a), FacebookWallPostActivity.b(a));
        if (graphresponse == null) goto _L1; else goto _L3
_L3:
        Object obj;
        obj = graphresponse.getJSONObject();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        obj = ((JSONObject) (obj)).optString("id");
_L4:
        graphresponse = graphresponse.getError();
        if (graphresponse != null)
        {
            FacebookUtils.evaluateFacebookErrorResponse(FacebookWallPostActivity.a(a), graphresponse);
            return;
        } else
        {
            FacebookWallPostActivity.a(a, null, ((String) (obj)));
            return;
        }
        obj;
        ((Exception) (obj)).printStackTrace();
        obj = null;
          goto _L4
    }

    (FacebookWallPostActivity facebookwallpostactivity)
    {
        a = facebookwallpostactivity;
        super();
    }
}
