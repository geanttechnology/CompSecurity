// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.adapters.SongAdapter;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final String val$pid;
    final SongItem val$song;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080049), 1);
    }

    public final void onSuccess(String s)
    {
        boolean flag1;
        flag1 = true;
        super.onSuccess(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        s = new JSONObject(s);
        boolean flag = flag1;
        if (s.isNull("mChangePlaylist"))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        flag = flag1;
        if (!s.getJSONObject("mChangePlaylist").isNull("status"))
        {
            flag = s.getJSONObject("mChangePlaylist").getBoolean("status");
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        int i;
        if (!((Fragment)((MainPage)val$ctx).stack.lastElement()).getClass().getSimpleName().equals("SongFragment") || !((SongFragment)((MainPage)val$ctx).stack.lastElement()).currentPlaylist.getPlaylistId().equals(val$pid))
        {
            break MISSING_BLOCK_LABEL_212;
        }
        i = ((SongFragment)((MainPage)val$ctx).stack.lastElement()).adapter.array.indexOf(val$song);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        ((SongFragment)((MainPage)val$ctx).stack.lastElement()).adapter.array.remove(i);
        ((SongFragment)((MainPage)val$ctx).stack.lastElement()).adapter.notifyDataSetChanged();
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080078), 1);
        s = new HashMap();
        s.put("f", val$song.getSongYtId());
        s.put("id", val$song.getSongId());
        s.put("playlist", val$pid);
        s.put("t", "yt");
        FlurryAgent.logEvent("action:music_del", s);
_L2:
        MixerBoxUtils.reloadMyPlaylist(val$ctx, false);
        return;
_L4:
        try
        {
            MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080049), 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    tpResponseHandler(SongItem songitem)
    {
        val$ctx = context1;
        val$pid = s;
        val$song = songitem;
        super(final_context);
    }
}
