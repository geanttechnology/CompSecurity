// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.content.res.Resources;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.gotv.crackle.data:
//            MediaDetailsRequest, Localization, DataRequest

class val.id extends Thread
{

    final MediaDetailsRequest this$0;
    final String val$id;

    public void run()
    {
        MediaDetailsRequest.access$002(MediaDetailsRequest.this, String.format("http://%s/details/media/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$id, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
        }));
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == te.FAILED)
        {
            return;
        }
        JSONException jsonexception;
        mState = te.RUNNING;
        Object obj = CrackleHMAC.encodeURL(MediaDetailsRequest.access$000(MediaDetailsRequest.this));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj);
        obj = NetworkUtil.getJSONFromUrlOrCache(MediaDetailsRequest.access$000(MediaDetailsRequest.this), hashmap);
        MediaDetailsRequest.access$102(MediaDetailsRequest.this, new MediaDetailsItem(((org.json.JSONObject) (obj))));
        if (MediaDetailsRequest.access$100(MediaDetailsRequest.this).getID().equalsIgnoreCase("0"))
        {
            throw new JSONException(Application.getInstance().getResources().getString(0x7f0b00ec));
        }
        try
        {
            mState = te.COMPLETE;
            mDataRequestListener.onDataSuccess("MediaDetails");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            mState = te.FAILED;
            mDataRequestListener.onDataFailed("MediaDetails", DataRequest.getParseErrorString(1300));
            return;
        }
        catch (IOException ioexception)
        {
            mState = te.FAILED;
            mDataRequestListener.onDataFailed("MediaDetails", DataRequest.getNetworkErrorString(1300));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mState = te.FAILED;
        }
        mDataRequestListener.onDataFailed("MediaDetails", DataRequest.getURIExceptionString(1300));
        return;
    }

    tListener()
    {
        this$0 = final_mediadetailsrequest;
        val$id = String.this;
        super();
    }
}
