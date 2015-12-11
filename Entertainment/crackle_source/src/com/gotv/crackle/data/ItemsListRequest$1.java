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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            ItemsListRequest, Localization, DataRequest

class val.count extends Thread
{

    final ItemsListRequest this$0;
    final String val$category;
    final int val$count;

    public void run()
    {
        if (ItemsListRequest.access$000(ItemsListRequest.this) != emsListType.Featured) goto _L2; else goto _L1
_L1:
        ItemsListRequest.access$102(ItemsListRequest.this, "ItemsListRequest-Featured");
        ItemsListRequest.access$202(ItemsListRequest.this, String.format("http://%s/featured/%s/%s/%s/%d?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$category, "all", Application.getInstance().getLocalization().getCurrentCountryCode(), Integer.valueOf(val$count), "json"
        }));
_L4:
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == State.FAILED)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (ItemsListRequest.access$000(ItemsListRequest.this) == emsListType.Popular)
        {
            ItemsListRequest.access$102(ItemsListRequest.this, "ItemsListRequest-Popular");
            ItemsListRequest.access$202(ItemsListRequest.this, String.format("http://%s/popular/%s/%s/%s/%d?format=%s", new Object[] {
                Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$category, "all", Application.getInstance().getLocalization().getCurrentCountryCode(), Integer.valueOf(50), "json"
            }));
        } else
        if (ItemsListRequest.access$000(ItemsListRequest.this) == emsListType.Recent)
        {
            ItemsListRequest.access$102(ItemsListRequest.this, "ItemsListRequest-Recent");
            ItemsListRequest.access$202(ItemsListRequest.this, String.format("http://%s/recent/%s/%s/%s/%d?format=%s", new Object[] {
                Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$category, "all", Application.getInstance().getLocalization().getCurrentCountryCode(), Integer.valueOf(50), "json"
            }));
        }
        if (true) goto _L4; else goto _L3
_L3:
        mState = State.RUNNING;
        Object obj;
        obj = CrackleHMAC.encodeURL(ItemsListRequest.access$200(ItemsListRequest.this));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj);
        obj = NetworkUtil.getJSONFromUrlOrCache(ItemsListRequest.access$200(ItemsListRequest.this), hashmap).getJSONArray("Items");
        int i = 0;
_L6:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        ItemsListRequest.access$302(ItemsListRequest.this, new CrackleItem(jsonobject));
        ItemsListRequest.access$400(ItemsListRequest.this).add(ItemsListRequest.access$300(ItemsListRequest.this));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        try
        {
            mState = State.COMPLETE;
            mDataRequestListener.onDataSuccess(ItemsListRequest.access$100(ItemsListRequest.this));
            return;
        }
        catch (JSONException jsonexception)
        {
            mState = State.FAILED;
            mDataRequestListener.onDataFailed(ItemsListRequest.access$100(ItemsListRequest.this), DataRequest.getParseErrorString(1000));
            return;
        }
        catch (IOException ioexception)
        {
            mState = State.FAILED;
            mDataRequestListener.onDataFailed(ItemsListRequest.access$100(ItemsListRequest.this), DataRequest.getNetworkErrorString(1000));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mState = State.FAILED;
        }
        mDataRequestListener.onDataFailed(ItemsListRequest.access$100(ItemsListRequest.this), DataRequest.getURIExceptionString(1000));
        return;
    }

    uestListener()
    {
        this$0 = final_itemslistrequest;
        val$category = s;
        val$count = I.this;
        super();
    }
}
