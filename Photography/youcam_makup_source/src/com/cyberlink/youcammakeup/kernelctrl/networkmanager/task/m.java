// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import android.util.Log;
import com.cyberlink.youcammakeup.utility.f;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class m extends b
{

    private Map d;

    public m(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            Log.d("GetBCPostMappingToLookResponse", "GetBCPostMappingToLookResponse failed!");
            return;
        } else
        {
            f.a("BC_HOW_TO_POST_MAPPING_TO_LOOK", b);
            f.a("BC_HOW_TO_POST_MAPPING_TO_LOOK");
            return;
        }
    }

    private void b()
    {
        JSONArray jsonarray = f.b("BC_HOW_TO_POST_MAPPING_TO_LOOK").getJSONArray("result");
        int i = 0;
_L2:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        d.put(((JSONObject)jsonarray.get(i)).optString("lookGuid"), Long.valueOf(((JSONObject)jsonarray.get(i)).optLong("postId")));
        i++;
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
_L1:
    }

    public Map a()
    {
        d = new HashMap();
        if (!f.a("BC_HOW_TO_POST_MAPPING_TO_LOOK", TimeUnit.DAYS.toMillis(1L)))
        {
            b();
        }
        return d;
    }
}
