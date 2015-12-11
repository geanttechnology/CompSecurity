// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.content.res.Resources;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.ChannelItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, Localization

public class ChannelDetails extends DataRequest
{

    private static final int ERROR_CODE_BASE = 200;
    public static final String TAG = "ChannelDetails";
    private ChannelItem mItem;
    private String mUrl;

    public ChannelDetails(DataRequest.DataRequestListener datarequestlistener, final String id)
    {
        mState = DataRequest.RequestState.IDLE;
        mDataRequestListener = datarequestlistener;
        (new Thread() {

            final ChannelDetails this$0;
            final String val$id;

            public void run()
            {
                mUrl = String.format("http://%s/details/channel/%s/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), id, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
                });
                if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == DataRequest.RequestState.FAILED)
                {
                    return;
                }
                JSONException jsonexception;
                mState = DataRequest.RequestState.RUNNING;
                Object obj = CrackleHMAC.encodeURL(mUrl);
                HashMap hashmap = new HashMap();
                hashmap.put("Authorization", obj);
                obj = NetworkUtil.getJSONFromUrlOrCache(mUrl, hashmap);
                mItem = new ChannelItem(((org.json.JSONObject) (obj)));
                if (mItem.getID().equalsIgnoreCase("0"))
                {
                    throw new JSONException(Application.getInstance().getResources().getString(0x7f0b00ec));
                }
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess("ChannelDetails");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (JSONException jsonexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("ChannelDetails", DataRequest.getParseErrorString(200));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("ChannelDetails", DataRequest.getNetworkErrorString(200));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed("ChannelDetails", DataRequest.getURIExceptionString(200));
                return;
            }

            
            {
                this$0 = ChannelDetails.this;
                id = s;
                super();
            }
        }).start();
    }

    public ChannelItem getItem()
    {
        return mItem;
    }



/*
    static String access$002(ChannelDetails channeldetails, String s)
    {
        channeldetails.mUrl = s;
        return s;
    }

*/



/*
    static ChannelItem access$102(ChannelDetails channeldetails, ChannelItem channelitem)
    {
        channeldetails.mItem = channelitem;
        return channelitem;
    }

*/
}
