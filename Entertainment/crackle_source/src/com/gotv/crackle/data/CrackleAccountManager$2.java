// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.PlayProgressItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            CrackleAccountManager, Localization

class val.userID extends Thread
{

    final CrackleAccountManager this$0;
    final String val$userID;

    public void run()
    {
        Object obj;
        obj = String.format("http://%s/pauseresume/list/member/%s/%s?format=json", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$userID, Application.getInstance().getLocalization().getCurrentCountryCode()
        });
        String s = CrackleHMAC.encodeURL(((String) (obj)));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", s);
        obj = NetworkUtil.getJSONFromUrl(((String) (obj)), hashmap).getJSONArray("Progress");
        int i = 0;
_L2:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        PlayProgressItem playprogressitem = new PlayProgressItem(((JSONArray) (obj)).getJSONObject(i));
        int j = Integer.parseInt(playprogressitem.getPosition());
        SharedPrefsManager.updatePlayProgressForItem(playprogressitem.getID(), Integer.valueOf(j * 1000), Long.valueOf(playprogressitem.getTimeStamp()));
        i++;
        if (true) goto _L2; else goto _L1
        Object obj1;
        obj1;
        ((JSONException) (obj1)).printStackTrace();
_L1:
        return;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        return;
        obj1;
        ((URISyntaxException) (obj1)).printStackTrace();
        return;
    }

    ()
    {
        this$0 = final_crackleaccountmanager;
        val$userID = String.this;
        super();
    }
}
