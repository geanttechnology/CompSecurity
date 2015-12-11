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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            ChannelFolderList, Localization, DataRequest

class val.id extends Thread
{

    final ChannelFolderList this$0;
    final String val$id;

    public void run()
    {
        ChannelFolderList.access$002(ChannelFolderList.this, String.format("http://%s/channel/%s/folders/%s?format=%s", new Object[] {
            Application.getInstance().getLocalization().getLoacalizedBaseURL(), val$id, Application.getInstance().getLocalization().getCurrentCountryCode(), "json"
        }));
        if (Application.getInstance().getLocalization().getCurrentCountryRequestState() == tate.FAILED)
        {
            return;
        }
        Object obj;
        mState = tate.RUNNING;
        obj = CrackleHMAC.encodeURL(ChannelFolderList.access$000(ChannelFolderList.this));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj);
        obj = NetworkUtil.getJSONFromUrlOrCache(ChannelFolderList.access$000(ChannelFolderList.this), hashmap).getJSONArray("FolderList");
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
        ChannelFolderList.access$100(ChannelFolderList.this).add(folderitem);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            mState = tate.COMPLETE;
            mDataRequestListener.onDataSuccess("ChannelFolderList");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            mState = tate.FAILED;
            mDataRequestListener.onDataFailed("ChannelFolderList", DataRequest.getParseErrorString(300));
            return;
        }
        catch (IOException ioexception)
        {
            mState = tate.FAILED;
            mDataRequestListener.onDataFailed("ChannelFolderList", DataRequest.getNetworkErrorString(300));
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            mState = tate.FAILED;
        }
        mDataRequestListener.onDataFailed("ChannelFolderList", DataRequest.getURIExceptionString(300));
        return;
    }

    estListener()
    {
        this$0 = final_channelfolderlist;
        val$id = String.this;
        super();
    }
}
