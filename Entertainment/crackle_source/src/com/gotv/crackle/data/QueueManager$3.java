// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            QueueManager, Localization, DataRequest

class this._cls0 extends Thread
{

    final QueueManager this$0;

    public void run()
    {
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == uestState.FAILED)
        {
            return;
        }
        try
        {
            String s = CrackleHMAC.encodeURL(QueueManager.access$000(QueueManager.this));
            HashMap hashmap = new HashMap();
            hashmap.put("Authorization", s);
            Log.v("QueueManager", (new StringBuilder()).append("URL = ").append(QueueManager.access$000(QueueManager.this)).toString());
            Log.v("QueueManager", NetworkUtil.getJSONFromUrl(QueueManager.access$000(QueueManager.this), hashmap).toString(5));
            mDataRequestListener.onDataSuccess("GENERAL_QUEUE");
            return;
        }
        catch (JSONException jsonexception)
        {
            mDataRequestListener.onDataFailed("GENERAL_QUEUE", DataRequest.getParseErrorString(1400));
            return;
        }
        catch (IOException ioexception)
        {
            mDataRequestListener.onDataFailed("GENERAL_QUEUE", DataRequest.getNetworkErrorString(1400));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mDataRequestListener.onDataFailed("GENERAL_QUEUE", DataRequest.getURIExceptionString(1400));
        }
        return;
    }

    aRequestListener()
    {
        this$0 = QueueManager.this;
        super();
    }
}
