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
//            FilterList, Localization, DataRequest

class val.category extends Thread
{

    final FilterList this$0;
    final String val$category;

    public void run()
    {
        String s;
        HashMap hashmap;
        try
        {
            FilterList.access$002(FilterList.this, String.format("http://%s/browse/%s/filters?format=%s", new Object[] {
                Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$category, "json"
            }));
            if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == equestState.FAILED)
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
        s = CrackleHMAC.encodeURL(FilterList.access$000(FilterList.this));
        hashmap = new HashMap();
        hashmap.put("Authorization", s);
        s = NetworkUtil.getJSONFromUrlOrCache(FilterList.access$000(FilterList.this), hashmap).getString("Filters");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        FilterList.access$102(FilterList.this, s.split(","));
        mDataRequestListener.onDataSuccess("FilterList");
        return;
    }

    ataRequestListener()
    {
        this$0 = final_filterlist;
        val$category = String.this;
        super();
    }
}
