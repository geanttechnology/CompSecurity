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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, Localization

public class ItemsListRequest extends DataRequest
{
    public static final class ItemsListType extends Enum
    {

        private static final ItemsListType $VALUES[];
        public static final ItemsListType Featured;
        public static final ItemsListType Popular;
        public static final ItemsListType Recent;

        public static ItemsListType valueOf(String s)
        {
            return (ItemsListType)Enum.valueOf(com/gotv/crackle/data/ItemsListRequest$ItemsListType, s);
        }

        public static ItemsListType[] values()
        {
            return (ItemsListType[])$VALUES.clone();
        }

        static 
        {
            Featured = new ItemsListType("Featured", 0);
            Recent = new ItemsListType("Recent", 1);
            Popular = new ItemsListType("Popular", 2);
            $VALUES = (new ItemsListType[] {
                Featured, Recent, Popular
            });
        }

        private ItemsListType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int ERROR_CODE_BASE = 1000;
    public static final String TAG_FEATURED = "ItemsListRequest-Featured";
    public static final String TAG_POPULAR = "ItemsListRequest-Popular";
    public static final String TAG_RECENT = "ItemsListRequest-Recent";
    private String TAG;
    private CrackleItem mCurrentItem;
    private List mItems;
    private ItemsListType mListType;
    private String mUrl;

    public ItemsListRequest()
    {
        mItems = new ArrayList();
    }

    public ItemsListRequest(DataRequest.DataRequestListener datarequestlistener, ItemsListType itemslisttype, String s)
    {
        mItems = new ArrayList();
        start(datarequestlistener, itemslisttype, s, 50);
    }

    public List getItems()
    {
        return mItems;
    }

    public void start(DataRequest.DataRequestListener datarequestlistener, ItemsListType itemslisttype, final String category, final int count)
    {
        mState = DataRequest.RequestState.IDLE;
        mListType = itemslisttype;
        mDataRequestListener = datarequestlistener;
        (new Thread() {

            final ItemsListRequest this$0;
            final String val$category;
            final int val$count;

            public void run()
            {
                if (mListType != ItemsListType.Featured) goto _L2; else goto _L1
_L1:
                TAG = "ItemsListRequest-Featured";
                mUrl = String.format("http://%s/featured/%s/%s/%s/%d?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), category, "all", Application.getInstance().getLocalization().getCurrentCountryCode(), Integer.valueOf(count), "json"
                });
_L4:
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                break; /* Loop/switch isn't completed */
_L2:
                if (mListType == ItemsListType.Popular)
                {
                    TAG = "ItemsListRequest-Popular";
                    mUrl = String.format("http://%s/popular/%s/%s/%s/%d?format=%s", new Object[] {
                        Application.getInstance().getLocalization().getLoacalizedBaseURL(), category, "all", Application.getInstance().getLocalization().getCurrentCountryCode(), Integer.valueOf(50), "json"
                    });
                } else
                if (mListType == ItemsListType.Recent)
                {
                    TAG = "ItemsListRequest-Recent";
                    mUrl = String.format("http://%s/recent/%s/%s/%s/%d?format=%s", new Object[] {
                        Application.getInstance().getLocalization().getLoacalizedBaseURL(), category, "all", Application.getInstance().getLocalization().getCurrentCountryCode(), Integer.valueOf(50), "json"
                    });
                }
                if (true) goto _L4; else goto _L3
_L3:
                mState = DataRequest.RequestState.RUNNING;
                Object obj;
                obj = CrackleHMAC.encodeURL(mUrl);
                HashMap hashmap = new HashMap();
                hashmap.put("Authorization", obj);
                obj = NetworkUtil.getJSONFromUrlOrCache(mUrl, hashmap).getJSONArray("Items");
                int i = 0;
_L6:
                if (i >= ((JSONArray) (obj)).length())
                {
                    break; /* Loop/switch isn't completed */
                }
                JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(i);
                mCurrentItem = new CrackleItem(jsonobject);
                mItems.add(mCurrentItem);
                i++;
                if (true) goto _L6; else goto _L5
_L5:
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess(TAG);
                    return;
                }
                catch (JSONException jsonexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed(TAG, DataRequest.getParseErrorString(1000));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed(TAG, DataRequest.getNetworkErrorString(1000));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed(TAG, DataRequest.getURIExceptionString(1000));
                return;
            }

            
            {
                this$0 = ItemsListRequest.this;
                category = s;
                count = i;
                super();
            }
        }).start();
    }




/*
    static String access$102(ItemsListRequest itemslistrequest, String s)
    {
        itemslistrequest.TAG = s;
        return s;
    }

*/



/*
    static String access$202(ItemsListRequest itemslistrequest, String s)
    {
        itemslistrequest.mUrl = s;
        return s;
    }

*/



/*
    static CrackleItem access$302(ItemsListRequest itemslistrequest, CrackleItem crackleitem)
    {
        itemslistrequest.mCurrentItem = crackleitem;
        return crackleitem;
    }

*/

}
