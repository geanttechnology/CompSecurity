// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import android.content.res.Resources;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            PlaylistsFragment

class eHandler extends MixerBoxAsyncHttpResponseHandler
{

    final ctivity this$1;

    public void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        lv.onRefreshComplete();
    }

    public void onSuccess(String s)
    {
        super.onSuccess(s);
        if (s == null || getActivity() == null)
        {
            return;
        }
        MixerBoxSharedPreferences.putAuthLoginResponse(getActivity(), s);
        Object obj;
        Object obj1;
        JSONArray jsonarray;
        obj = (new JSONObject(s)).getJSONObject("authLoginV2").getJSONObject("data");
        obj1 = new ArrayList();
        jsonarray = ((JSONObject) (obj)).getJSONArray("playlists");
        int i;
        if (android.os. >= 15)
        {
            s = "coverhq";
        } else
        {
            s = "cover";
        }
        ((MainPage)getActivity()).myPlaylists.clear();
        i = jsonarray.length() - 1;
_L10:
        if (i < 0) goto _L2; else goto _L1
_L1:
        if (!jsonarray.isNull(i)) goto _L4; else goto _L3
_L3:
        ((ArrayList) (obj1)).add(new PlaylistItem("", "", "", "", "", "", "", 0, false));
          goto _L5
_L4:
        JSONObject jsonobject1 = jsonarray.getJSONObject(i);
        ((ArrayList) (obj1)).add(MixerBoxUtils.getPlaylistItem(jsonobject1, s, 1));
        ((MainPage)getActivity()).myPlaylists.add(jsonobject1.getString("_id"));
          goto _L5
_L8:
        loadContent();
        lv.onRefreshComplete();
        return;
_L2:
        ((MainPage)getActivity()).arrayMyPlaylists = new ArrayList(((java.util.Collection) (obj1)));
        obj1 = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(((MainPage)getActivity()).DB.getLastHistory()).append("/mqdefault.jpg").toString();
        ((MainPage)getActivity()).arrayMyPlaylists.add(new PlaylistItem("PLAYLISTHISTORYID", ((MainPage)getActivity()).getResources().getString(0x7f080111), "", "", (new StringBuilder()).append("").append(((MainPage)getActivity()).DB.getSongCount("PLAYLISTHISTORYID")).toString(), "", ((String) (obj1)), 6, false));
        ((MainPage)getActivity()).mySubscriptions.clear();
        obj1 = new ArrayList();
        obj = ((JSONObject) (obj)).getJSONArray("subs_playlists");
        i = ((JSONArray) (obj)).length() - 1;
_L7:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        ((MainPage)getActivity()).mySubscriptions.add(jsonobject.getString("_id"));
        ((ArrayList) (obj1)).add(MixerBoxUtils.getPlaylistItem(jsonobject, s, 2));
        i--;
        if (true) goto _L7; else goto _L6
_L6:
        try
        {
            ((MainPage)getActivity()).arrayMySubsPlaylists = new ArrayList(((java.util.Collection) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        if (true) goto _L8; else goto _L5
_L5:
        i--;
        if (true) goto _L10; else goto _L9
_L9:
    }

    (Context context)
    {
        this$1 = this._cls1.this;
        super(context);
    }
}
