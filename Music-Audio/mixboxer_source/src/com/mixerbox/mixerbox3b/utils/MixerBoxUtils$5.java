// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class ttpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final int val$i1;
    final String val$pid;

    public final void onFailure(Throwable throwable, String s)
    {
        super.onFailure(throwable, s);
        if (val$i1 <= 1)
        {
            MixerBoxUtils.reloadMySubsPlaylist(val$ctx, false, true);
        }
    }

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        s = new HashMap();
        s.put("id", val$pid);
        s.put("sub", "1");
        FlurryAgent.logEvent("action:subscribe", s);
        if (val$i1 <= 1)
        {
            MixerBoxUtils.reloadMySubsPlaylist(val$ctx, false, true);
        }
    }

    ttpResponseHandler(Context context1)
    {
        val$pid = s;
        val$i1 = i;
        val$ctx = context1;
        super(final_context);
    }
}
