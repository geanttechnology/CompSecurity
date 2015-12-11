// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import com.flurry.android.FlurryAgent;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final String val$name;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080049), 1);
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080081), 1);
        FlurryAgent.logEvent("action:playlist_create");
        Object obj = "";
        SongFragment songfragment;
        try
        {
            s = (new JSONObject(s)).getString("mChangePlaylist");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = ((String) (obj));
        }
        ((MainPage)val$ctx).arraySong.clear();
        obj = new PlaylistItem(s, val$name, "", "", "0", "0", "", 1, false);
        ((MainPage)val$ctx).arrayMyPlaylists.add(obj);
        ((MainPage)val$ctx).myPlaylists.add(s);
        songfragment = ((MainPage)val$ctx).setSong(s);
        songfragment.currentPlaylist = ((PlaylistItem) (obj));
        MixerBoxUtils.loadSong(val$ctx, s, false, 1, -1, songfragment);
        MixerBoxUtils.reloadMyPlaylist(val$ctx, false);
        if (((MainPage)val$ctx).fragmentPlaylists.lv != null)
        {
            ((MainPage)val$ctx).fragmentPlaylists.lv.onRefreshComplete();
        }
    }

    hListView(String s)
    {
        val$ctx = context1;
        val$name = s;
        super(final_context);
    }
}
