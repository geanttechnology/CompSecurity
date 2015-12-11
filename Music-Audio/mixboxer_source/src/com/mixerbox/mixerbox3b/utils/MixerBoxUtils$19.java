// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.SongItem;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final String val$name;
    final SongItem val$song;

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        FlurryAgent.logEvent("action:playlist_create");
        String s1 = "";
        try
        {
            s = (new JSONObject(s)).getString("mChangePlaylist");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = s1;
        }
        MixerBoxUtils.addSong(val$ctx, s, val$song, true, val$name);
    }

    tpResponseHandler(String s)
    {
        val$ctx = context1;
        val$song = songitem;
        val$name = s;
        super(final_context);
    }
}
