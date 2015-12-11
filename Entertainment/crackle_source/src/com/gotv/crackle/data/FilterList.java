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
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, Localization

public class FilterList extends DataRequest
{

    private static final int ERROR_CODE_BASE = 800;
    private static final String FILTERS = "Filters";
    public static final String TAG = "FilterList";
    private String mItems[];
    private String mUrl;

    public FilterList(DataRequest.DataRequestListener datarequestlistener, final String category)
    {
        mDataRequestListener = datarequestlistener;
        (new Thread() {

            final FilterList this$0;
            final String val$category;

            public void run()
            {
                String s;
                HashMap hashmap;
                try
                {
                    mUrl = String.format("http://%s/browse/%s/filters?format=%s", new Object[] {
                        Application.getInstance().getLocalization().getLoacalizedBaseURL(), category, "json"
                    });
                    if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                    {
                        return;
                    }
                }
                catch (JSONException jsonexception)
                {
                    mDataRequestListener.onDataFailed("FilterList", DataRequest.getParseErrorString(800));
                    return;
                }
                catch (IOException ioexception)
                {
                    mDataRequestListener.onDataFailed("FilterList", DataRequest.getNetworkErrorString(800));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mDataRequestListener.onDataFailed("FilterList", DataRequest.getURIExceptionString(800));
                    return;
                }
                s = CrackleHMAC.encodeURL(mUrl);
                hashmap = new HashMap();
                hashmap.put("Authorization", s);
                s = NetworkUtil.getJSONFromUrlOrCache(mUrl, hashmap).getString("Filters");
                if (s == null)
                {
                    break MISSING_BLOCK_LABEL_121;
                }
                mItems = s.split(",");
                mDataRequestListener.onDataSuccess("FilterList");
                return;
            }

            
            {
                this$0 = FilterList.this;
                category = s;
                super();
            }
        }).start();
    }

    public String[] getItems()
    {
        return mItems;
    }



/*
    static String access$002(FilterList filterlist, String s)
    {
        filterlist.mUrl = s;
        return s;
    }

*/


/*
    static String[] access$102(FilterList filterlist, String as[])
    {
        filterlist.mItems = as;
        return as;
    }

*/
}
