// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.model.SlideShowItem;
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

public class SlideShowList extends DataRequest
{

    private static final int ERROR_CODE_BASE = 1500;
    public static final String TAG = "SlideShowList";
    private List mItems;
    private String mUrl;

    public SlideShowList(DataRequest.DataRequestListener datarequestlistener, final String channelName)
    {
        mItems = new ArrayList();
        mState = DataRequest.RequestState.IDLE;
        mDataRequestListener = datarequestlistener;
        (new Thread() {

            final SlideShowList this$0;
            final String val$channelName;

            public void run()
            {
                mUrl = String.format("http://%s/slideshow/%s/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), channelName, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
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
                obj = NetworkUtil.getJSONFromUrl(mUrl, hashmap).getJSONArray("slideList");
                if (((JSONArray) (obj)).length() <= 0) goto _L2; else goto _L1
_L1:
                int i = 0;
_L3:
                if (i >= ((JSONArray) (obj)).length())
                {
                    break; /* Loop/switch isn't completed */
                }
                SlideShowItem slideshowitem = new SlideShowItem(((JSONArray) (obj)).getJSONObject(i));
                mItems.add(slideshowitem);
                i++;
                if (true) goto _L3; else goto _L2
_L2:
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess("SlideShowList");
                    return;
                }
                catch (JSONException jsonexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("SlideShowList", DataRequest.getParseErrorString(1500));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("SlideShowList", DataRequest.getNetworkErrorString(1500));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed("SlideShowList", DataRequest.getURIExceptionString(1500));
                return;
            }

            
            {
                this$0 = SlideShowList.this;
                channelName = s;
                super();
            }
        }).start();
    }

    public List getItems()
    {
        return mItems;
    }



/*
    static String access$002(SlideShowList slideshowlist, String s)
    {
        slideshowlist.mUrl = s;
        return s;
    }

*/

}
