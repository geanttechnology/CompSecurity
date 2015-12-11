// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.model.CrackleItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            SearchResults, Localization, DataRequest

class val.query extends Thread
{

    final SearchResults this$0;
    final String val$query;

    public void run()
    {
        String s = URLEncoder.encode(val$query.trim(), "UTF-8").replace("+", "%20");
        SearchResults.access$002(SearchResults.this, String.format("http://%s/search/media/%s/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), s, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
        }));
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == estState.FAILED)
        {
            return;
        }
        Object obj;
        mState = estState.RUNNING;
        obj = CrackleHMAC.encodeURL(SearchResults.access$000(SearchResults.this));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj);
        obj = NetworkUtil.getJSONFromUrlOrCache(SearchResults.access$000(SearchResults.this), hashmap).getJSONArray("Items");
        int i = 0;
_L2:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        CrackleItem crackleitem = new CrackleItem(((JSONArray) (obj)).getJSONObject(i));
        SearchResults.access$100(SearchResults.this).add(crackleitem);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            mState = estState.COMPLETE;
            mDataRequestListener.onDataSuccess("SearchResults");
            return;
        }
        catch (JSONException jsonexception)
        {
            mState = estState.FAILED;
            mDataRequestListener.onDataFailed("SearchResults", DataRequest.getParseErrorString(200));
            return;
        }
        catch (IOException ioexception)
        {
            mState = estState.FAILED;
            mDataRequestListener.onDataFailed("SearchResults", DataRequest.getNetworkErrorString(200));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mState = estState.FAILED;
        }
        mDataRequestListener.onDataFailed("SearchResults", DataRequest.getURIExceptionString(200));
        return;
    }

    RequestListener()
    {
        this$0 = final_searchresults;
        val$query = String.this;
        super();
    }
}
