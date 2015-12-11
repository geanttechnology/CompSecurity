// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.model.GenreItem;
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

public class GenreList extends DataRequest
{

    private static final int ERROR_CODE_BASE = 900;
    private static final String ITEMS = "Items";
    public static final String TAG = "GenreList";
    private List mItems;
    private String mUrl;

    public GenreList(DataRequest.DataRequestListener datarequestlistener, final String category)
    {
        mItems = new ArrayList();
        mDataRequestListener = datarequestlistener;
        mState = DataRequest.RequestState.IDLE;
        (new Thread() {

            final GenreList this$0;
            final String val$category;

            public void run()
            {
                mUrl = String.format("http://%s/genres/%s/primary/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), category, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
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
                GenreItem genreitem = new GenreItem(((JSONArray) (obj)).getJSONObject(i));
                mItems.add(genreitem);
                i++;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess("GenreList");
                    return;
                }
                catch (JSONException jsonexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("GenreList", DataRequest.getParseErrorString(900));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("GenreList", DataRequest.getNetworkErrorString(900));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed("GenreList", DataRequest.getURIExceptionString(900));
                return;
            }

            
            {
                this$0 = GenreList.this;
                category = s;
                super();
            }
        }).start();
    }

    public List getItems()
    {
        return mItems;
    }



/*
    static String access$002(GenreList genrelist, String s)
    {
        genrelist.mUrl = s;
        return s;
    }

*/

}
