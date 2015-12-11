// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final String val$n;
    final String val$pid;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080049), 1);
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080084), 1);
        s = new HashMap();
        s.put("id", val$pid);
        FlurryAgent.logEvent("action:playlist_change_title", s);
        if (((Fragment)((MainPage)val$ctx).stack.lastElement()).getClass().getSimpleName().equals("SongFragment"))
        {
            ((SongFragment)((MainPage)val$ctx).stack.lastElement()).currentPlaylist.getPlaylistId().equals(val$pid);
            ((SongFragment)((MainPage)val$ctx).stack.lastElement()).currentPlaylist.renamePlaylist(val$n);
        }
        MixerBoxUtils.reloadMyPlaylist(val$ctx, false);
    }

    tpResponseHandler(String s1)
    {
        val$ctx = context1;
        val$pid = s;
        val$n = s1;
        super(final_context);
    }
}
