// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.model.SlideShowItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            SlideShowList, Localization, DataRequest

class val.channelName extends Thread
{

    final SlideShowList this$0;
    final String val$channelName;

    public void run()
    {
        SlideShowList.access$002(SlideShowList.this, String.format("http://%s/slideshow/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$channelName, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
        }));
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == estState.FAILED)
        {
            return;
        }
        Object obj;
        mState = estState.RUNNING;
        obj = CrackleHMAC.encodeURL(SlideShowList.access$000(SlideShowList.this));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj);
        obj = NetworkUtil.getJSONFromUrl(SlideShowList.access$000(SlideShowList.this), hashmap).getJSONArray("slideList");
        if (((JSONArray) (obj)).length() <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        SlideShowItem slideshowitem = new SlideShowItem(((JSONArray) (obj)).getJSONObject(i));
        SlideShowList.access$100(SlideShowList.this).add(slideshowitem);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        try
        {
            mState = estState.COMPLETE;
            mDataRequestListener.onDataSuccess("SlideShowList");
            return;
        }
        catch (JSONException jsonexception)
        {
            mState = estState.FAILED;
            mDataRequestListener.onDataFailed("SlideShowList", DataRequest.getParseErrorString(1500));
            return;
        }
        catch (IOException ioexception)
        {
            mState = estState.FAILED;
            mDataRequestListener.onDataFailed("SlideShowList", DataRequest.getNetworkErrorString(1500));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mState = estState.FAILED;
        }
        mDataRequestListener.onDataFailed("SlideShowList", DataRequest.getURIExceptionString(1500));
        return;
    }

    RequestListener()
    {
        this$0 = final_slideshowlist;
        val$channelName = String.this;
        super();
    }
}
