// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.fragments.PlaylistsFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final String val$pid;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080049), 1);
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        s = new HashMap();
        s.put("id", val$pid);
        s.put("sub", "0");
        FlurryAgent.logEvent("action:subscribe", s);
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f0800e9), 1);
        int i = 0;
        do
        {
label0:
            {
                if (i < ((MainPage)val$ctx).arrayMySubsPlaylists.size())
                {
                    if (!((PlaylistItem)((MainPage)val$ctx).arrayMySubsPlaylists.get(i)).getPlaylistId().equals(val$pid))
                    {
                        break label0;
                    }
                    ((MainPage)val$ctx).arrayMySubsPlaylists.remove(i);
                    ((MainPage)val$ctx).mySubscriptions.remove(val$pid);
                    ((MainPage)val$ctx).fragmentPlaylists.loadContent();
                }
                return;
            }
            i++;
        } while (true);
    }

    ment(Context context1)
    {
        val$pid = s;
        val$ctx = context1;
        super(final_context);
    }
}
