// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity

class this._cls0
    implements com.facebook.k
{

    final GameOverActivity this$0;

    public void onCompleted(GraphResponse graphresponse)
    {
        Object obj = graphresponse.getError();
        if (obj == null) goto _L2; else goto _L1
_L1:
        AkLog.e("GameOverActivity", ((FacebookRequestError) (obj)).toString());
_L4:
        return;
_L2:
        boolean flag;
        boolean flag1;
        graphresponse = graphresponse.getJSONObject();
        flag1 = false;
        flag = false;
        Object obj1 = TraductionFactory.sharedInstance().getTraductionFromToken("DEFIE_TES_AMIS_MESSAGE");
        obj = "";
        String s;
        JSONArray jsonarray;
        int j;
        j = AkPlayerBelongingsFactory.sharedInstance().getXp();
        s = ((String) (obj1)).replace("[NB_XP]", (new StringBuilder()).append(String.valueOf(j)).append(TraductionFactory.sharedInstance().getTraductionFromToken("POINT_EXPERIENCE")).toString());
        jsonarray = graphresponse.getJSONArray("data");
        graphresponse = s;
        if (jsonarray.length() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        int i = 0;
_L5:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_363;
        }
        obj1 = jsonarray.optJSONObject(i);
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        int k = Integer.parseInt(((JSONObject) (obj1)).getString("score"));
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        obj1 = ((JSONObject) (obj1)).getJSONObject("user");
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        String s1 = ((JSONObject) (obj1)).getString("id");
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        String s2 = ((JSONObject) (obj1)).getString("name");
        boolean flag2;
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        flag2 = flag;
        obj1 = obj;
        if (AccessToken.getCurrentAccessToken().getUserId().equals(s1))
        {
            break MISSING_BLOCK_LABEL_420;
        }
        if (j <= k)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        if (AkSessionFactory.sharedInstance().isFacebookRequestAlreadySend(s1))
        {
            break MISSING_BLOCK_LABEL_294;
        }
        flag2 = true;
        flag = true;
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        obj1 = (new StringBuilder()).append(((String) (obj))).append(s2).append(", ").toString();
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj1));
        GameOverActivity.access$000(GameOverActivity.this).add(s1);
        break MISSING_BLOCK_LABEL_420;
        flag2 = flag;
        obj1 = obj;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        flag2 = flag;
        obj1 = obj;
        if (!AkSessionFactory.sharedInstance().isFacebookRequestAlreadySend(s1))
        {
            break MISSING_BLOCK_LABEL_420;
        }
        flag1 = flag;
        graphresponse = ((GraphResponse) (obj));
        AkSessionFactory.sharedInstance().removeFacebookIdForRequest(s1);
        flag2 = flag;
        obj1 = obj;
        break MISSING_BLOCK_LABEL_420;
        obj;
        flag2 = flag1;
        obj1 = graphresponse;
        break MISSING_BLOCK_LABEL_420;
        flag1 = flag;
        graphresponse = s;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        graphresponse = s.replace("[USER_NAME]", ((String) (obj)).substring(0, ((String) (obj)).length() - 2));
        flag1 = flag;
        if (!flag1) goto _L4; else goto _L3
_L3:
        try
        {
            GameOverActivity.access$1700(GameOverActivity.this, graphresponse);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GraphResponse graphresponse)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GraphResponse graphresponse)
        {
            graphresponse.printStackTrace();
        }
        return;
        i++;
        flag = flag2;
        obj = obj1;
          goto _L5
    }

    tory()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}
