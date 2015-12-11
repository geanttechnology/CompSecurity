// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.content.res.Resources;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.NetworkUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest, Localization

public class MediaDetailsRequest extends DataRequest
{

    private static final int ERROR_CODE_BASE = 1300;
    public static final String TAG = "MediaDetails";
    private MediaDetailsItem mItem;
    private String mUrl;

    public MediaDetailsRequest(DataRequest.DataRequestListener datarequestlistener, final String id)
    {
        mState = DataRequest.RequestState.IDLE;
        mDataRequestListener = datarequestlistener;
        (new Thread() {

            final MediaDetailsRequest this$0;
            final String val$id;

            public void run()
            {
                mUrl = String.format("http://%s/details/media/%s/%s?format=%s", new Object[] {
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
                mItem = new MediaDetailsItem(((org.json.JSONObject) (obj)));
                if (mItem.getID().equalsIgnoreCase("0"))
                {
                    throw new JSONException(Application.getInstance().getResources().getString(0x7f0b00ec));
                }
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess("MediaDetails");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (JSONException jsonexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("MediaDetails", DataRequest.getParseErrorString(1300));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("MediaDetails", DataRequest.getNetworkErrorString(1300));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed("MediaDetails", DataRequest.getURIExceptionString(1300));
                return;
            }

            
            {
                this$0 = MediaDetailsRequest.this;
                id = s;
                super();
            }
        }).start();
    }

    public MediaDetailsItem getItem()
    {
        return mItem;
    }



/*
    static String access$002(MediaDetailsRequest mediadetailsrequest, String s)
    {
        mediadetailsrequest.mUrl = s;
        return s;
    }

*/



/*
    static MediaDetailsItem access$102(MediaDetailsRequest mediadetailsrequest, MediaDetailsItem mediadetailsitem)
    {
        mediadetailsrequest.mItem = mediadetailsitem;
        return mediadetailsitem;
    }

*/
}
