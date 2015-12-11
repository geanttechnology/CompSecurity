// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.SongItem;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils, MixerBoxSharedPreferences

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final String val$pid;
    final String val$pname;
    final boolean val$shouldToast;
    final SongItem val$song;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        if (val$shouldToast)
        {
            MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080049), 1);
        }
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        if (val$pname.length() > 0)
        {
            MixerBoxSharedPreferences.putDefaultAddedPlaylist(val$ctx, val$pid, val$pname);
        }
        if (val$shouldToast)
        {
            MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080077), 1);
            s = new HashMap();
            s.put("f", val$song.getSongYtId());
            s.put("playlist", val$pid);
            s.put("t", "yt");
            FlurryAgent.logEvent("action:music_add", s);
            MixerBoxUtils.reloadMyPlaylist(val$ctx, false);
        }
    }

    ferences(SongItem songitem)
    {
        val$pname = s;
        val$ctx = context1;
        val$pid = s1;
        val$shouldToast = flag;
        val$song = songitem;
        super(final_context);
    }
}
