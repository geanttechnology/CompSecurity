// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import android.content.res.Resources;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.FolderItem;
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

public class ChannelFolderList extends DataRequest
{

    private static final int ERROR_CODE_BASE = 300;
    public static final String TAG = "ChannelFolderList";
    private List mItems;
    private String mUrl;

    public ChannelFolderList(DataRequest.DataRequestListener datarequestlistener, final String id)
    {
        mItems = new ArrayList();
        mState = DataRequest.RequestState.IDLE;
        mDataRequestListener = datarequestlistener;
        (new Thread() {

            final ChannelFolderList this$0;
            final String val$id;

            public void run()
            {
                mUrl = String.format("http://%s/channel/%s/folders/%s?format=%s", new Object[] {
                    Application.getInstance().getLocalization().getLoacalizedBaseURL(), id, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
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
                obj = NetworkUtil.getJSONFromUrlOrCache(mUrl, hashmap).getJSONArray("FolderList");
                if (((JSONArray) (obj)).length() == 0)
                {
                    throw new JSONException(Application.getInstance().getResources().getString(0x7f0b00ec));
                }
                int i = 0;
_L2:
                if (i >= ((JSONArray) (obj)).length())
                {
                    break; /* Loop/switch isn't completed */
                }
                FolderItem folderitem = new FolderItem(((JSONArray) (obj)).getJSONObject(i));
                mItems.add(folderitem);
                i++;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    mState = DataRequest.RequestState.COMPLETE;
                    mDataRequestListener.onDataSuccess("ChannelFolderList");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("ChannelFolderList", DataRequest.getParseErrorString(300));
                    return;
                }
                catch (IOException ioexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                    mDataRequestListener.onDataFailed("ChannelFolderList", DataRequest.getNetworkErrorString(300));
                    return;
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    mState = DataRequest.RequestState.FAILED;
                }
                mDataRequestListener.onDataFailed("ChannelFolderList", DataRequest.getURIExceptionString(300));
                return;
            }

            
            {
                this$0 = ChannelFolderList.this;
                id = s;
                super();
            }
        }).start();
    }

    public List getItems()
    {
        return mItems;
    }



/*
    static String access$002(ChannelFolderList channelfolderlist, String s)
    {
        channelfolderlist.mUrl = s;
        return s;
    }

*/

}
