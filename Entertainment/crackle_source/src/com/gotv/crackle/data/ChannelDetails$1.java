// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.content.res.Resources;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.ChannelItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.gotv.crackle.data:
//            ChannelDetails, Localization, DataRequest

class val.id extends Thread
{

    final ChannelDetails this$0;
    final String val$id;

    public void run()
    {
        ChannelDetails.access$002(ChannelDetails.this, String.format("http://%s/details/channel/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$id, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
        }));
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == stState.FAILED)
        {
            return;
        }
        JSONException jsonexception;
        mState = stState.RUNNING;
        Object obj = CrackleHMAC.encodeURL(ChannelDetails.access$000(ChannelDetails.this));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj);
        obj = NetworkUtil.getJSONFromUrlOrCache(ChannelDetails.access$000(ChannelDetails.this), hashmap);
        ChannelDetails.access$102(ChannelDetails.this, new ChannelItem(((org.json.JSONObject) (obj))));
        if (ChannelDetails.access$100(ChannelDetails.this).getID().equalsIgnoreCase("0"))
        {
            throw new JSONException(Application.getInstance().getResources().getString(0x7f0b00ec));
        }
        try
        {
            mState = stState.COMPLETE;
            mDataRequestListener.onDataSuccess("ChannelDetails");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            mState = stState.FAILED;
            mDataRequestListener.onDataFailed("ChannelDetails", DataRequest.getParseErrorString(200));
            return;
        }
        catch (IOException ioexception)
        {
            mState = stState.FAILED;
            mDataRequestListener.onDataFailed("ChannelDetails", DataRequest.getNetworkErrorString(200));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mState = stState.FAILED;
        }
        mDataRequestListener.onDataFailed("ChannelDetails", DataRequest.getURIExceptionString(200));
        return;
    }

    equestListener()
    {
        this$0 = final_channeldetails;
        val$id = String.this;
        super();
    }
}
