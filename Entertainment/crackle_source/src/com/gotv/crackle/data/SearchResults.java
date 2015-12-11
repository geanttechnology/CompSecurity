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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, Localization

public class SearchResults extends DataRequest
{

    private static final int ERROR_CODE_BASE = 200;
    public static final String TAG = "SearchResults";
    private List mItems;
    private String mUrl;

    public SearchResults(DataRequest.DataRequestListener datarequestlistener, final String query)
    {
        mItems = new ArrayList();
        mState = DataRequest.RequestState.IDLE;
        mDataRequestListener = datarequestlistener;
        (new Thread() {

            final SearchResults this$0;
            final String val$query;

            public void run()
            {
                String s = URLEncoder.encode(query.trim(), "UTF-8").replace("+", "%20");
                mUrl = String.format("http://%s/search/media/%s/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), s, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
                });
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                Object obj;
                mState = DataRequest.RequestState.RUNNING;
                obj = CrackleHMAC.encodeURL(mUrl);
                HashMap hashmap = new HashMap();
                hashmap.put("Authorization", obj);
                obj = NetworkUtil.getJSONFromUrlOrCache(mUrl, hashmap).getJSONArray("Items");
                int i = 0;
_L2:
                if (i >= ((JSONArray) (obj)).length())
                {
                    break; /* Loop/switch isn't completed */
                }
                CrackleItem crackleitem = new CrackleItem(((JSONArray) (obj)).getJSONObject(i));
                mItems.add(crackleitem);
                i++;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess("SearchResults");
                    return;
                }
                catch (JSONException jsonexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("SearchResults", DataRequest.getParseErrorString(200));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("SearchResults", DataRequest.getNetworkErrorString(200));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed("SearchResults", DataRequest.getURIExceptionString(200));
                return;
            }

            
            {
                this$0 = SearchResults.this;
                query = s;
                super();
            }
        }).start();
    }

    public List getItems()
    {
        return mItems;
    }



/*
    static String access$002(SearchResults searchresults, String s)
    {
        searchresults.mUrl = s;
        return s;
    }

*/

}
