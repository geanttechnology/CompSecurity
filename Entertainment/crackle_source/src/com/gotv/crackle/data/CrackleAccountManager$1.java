// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.gotv.crackle.data:
//            CrackleAccountManager, Localization

class val.userID extends Thread
{

    final CrackleAccountManager this$0;
    final String val$mediaID;
    final int val$timeInSeconds;
    final String val$userID;

    public void run()
    {
        try
        {
            String s = String.format("http://%s/pauseresume/media/%s/set/%s/member/%s/%s?format=json", new Object[] {
                Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$mediaID, (new StringBuilder()).append(val$timeInSeconds).append("").toString(), val$userID, Application.getInstance().getLocalization().getCurrentCountryCode()
            });
            String s1 = CrackleHMAC.encodeURL(s);
            HashMap hashmap = new HashMap();
            hashmap.put("Authorization", s1);
            NetworkUtil.getJSONFromUrl(s, hashmap);
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
        }
    }

    ()
    {
        this$0 = final_crackleaccountmanager;
        val$mediaID = s;
        val$timeInSeconds = i;
        val$userID = String.this;
        super();
    }
}
