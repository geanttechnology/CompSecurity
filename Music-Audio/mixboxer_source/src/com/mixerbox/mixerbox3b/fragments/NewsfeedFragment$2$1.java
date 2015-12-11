// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import android.content.res.Resources;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.VectorAdapter;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            NewsfeedFragment

class seHandler extends MixerBoxAsyncHttpResponseHandler
{

    final croll this$1;

    public void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        lvNewsfeed.onRefreshComplete();
    }

    public void onSuccess(String s)
    {
        int i = 0;
        super.onSuccess(s);
        if (getActivity() == null || s == null)
        {
            return;
        }
        Object obj;
        if (((MainPage)getActivity()).arrayNewsfeed != null)
        {
            ((MainPage)getActivity()).arrayNewsfeed.clear();
        } else
        {
            ((MainPage)getActivity()).arrayNewsfeed = new ArrayList();
        }
        obj = ((MainPage)getActivity()).DB.getLastPushed();
        if (obj != null)
        {
            try
            {
                obj = new JSONObject((new StringBuilder()).append("{margin: true,type: \"general\",views: {header: {mainText: \"").append(getResources().getString(0x7f080112)).append("\"},main: {mainLink: {type: \"playlist\",ref: \"").append(((PlaylistItem) (obj)).getPlaylistId()).append("\",title: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",owner: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",size: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",thumbnailHQ: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",ownerId: \"\"},mainText: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",subText: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",sideText: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: {style: \"square\",url: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\"}},footer: {bgColor: true,links: [{type: \"button\",title: \"").append(getResources().getString(0x7f0800e7)).append("\",action: \"subscribe\",switch: {type: \"button\",title: \"").append(getResources().getString(0x7f0800e8)).append("\",action: \"unsubscribe\"}},{type: \"dummy\"},{type: \"dummy\"}]}}}").toString());
                MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, ((JSONObject) (obj)), getActivity(), 0, 0);
            }
            catch (Exception exception)
            {
                exception.toString();
            }
        }
        s = (new JSONObject(s)).getJSONObject("newsPage").getJSONArray("items");
_L1:
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_452;
        }
        obj = s.getJSONObject(i);
        MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, ((JSONObject) (obj)), getActivity(), i, s.length() - i - 1);
        i++;
          goto _L1
        s;
        s.printStackTrace();
        adapter.notifyDataSetChanged();
        lvNewsfeed.onRefreshComplete();
        canScroll = true;
        return;
    }

    w(Context context)
    {
        this$1 = this._cls1.this;
        super(context);
    }
}
