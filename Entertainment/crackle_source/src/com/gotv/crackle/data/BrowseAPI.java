// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.model.BrowseEntry;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, Localization

public class BrowseAPI extends DataRequest
{

    private static final int ERROR_CODE_BASE = 100;
    public static final String TAG = "BrowseAPI";
    private String mGenre;
    private List mItems;
    private String mUrl;

    public BrowseAPI(DataRequest.DataRequestListener datarequestlistener, final String category, final String filter, final String genre, final String sort)
    {
        mItems = new ArrayList();
        mState = DataRequest.RequestState.IDLE;
        mDataRequestListener = datarequestlistener;
        mGenre = genre;
        (new Thread() {

            final BrowseAPI this$0;
            final String val$category;
            final String val$filter;
            final String val$genre;
            final String val$sort;

            public void run()
            {
                mUrl = String.format("http://%s/browse/%s/%s/%s/%s/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), category, filter, genre, sort, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
                });
                mState = DataRequest.RequestState.RUNNING;
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                Object obj;
                obj = CrackleHMAC.encodeURL(mUrl);
                HashMap hashmap = new HashMap();
                hashmap.put("Authorization", obj);
                obj = NetworkUtil.getJSONFromUrlOrCache(mUrl, hashmap).getJSONArray("Entries");
                int i = 0;
_L2:
                if (i >= ((JSONArray) (obj)).length())
                {
                    break; /* Loop/switch isn't completed */
                }
                BrowseEntry browseentry = new BrowseEntry(((JSONArray) (obj)).getJSONObject(i));
                mItems.add(browseentry);
                i++;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess("BrowseAPI");
                    return;
                }
                catch (JSONException jsonexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("BrowseAPI", DataRequest.getParseErrorString(100));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("BrowseAPI", DataRequest.getNetworkErrorString(100));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed("BrowseAPI", DataRequest.getURIExceptionString(100));
                return;
            }

            
            {
                this$0 = BrowseAPI.this;
                category = s;
                filter = s1;
                genre = s2;
                sort = s3;
                super();
            }
        }).start();
    }

    public String getGenre()
    {
        return mGenre;
    }

    public List getItems()
    {
        return mItems;
    }



/*
    static String access$002(BrowseAPI browseapi, String s)
    {
        browseapi.mUrl = s;
        return s;
    }

*/

}
