// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.res.Resources;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
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
        MixerBoxUtils.toastMsg(val$ctx, val$ctx.getResources().getString(0x7f080082), 1);
        s = new HashMap();
        s.put("id", val$pid);
        FlurryAgent.logEvent("action:playlist_delete", s);
        MixerBoxUtils.reloadMyPlaylist(val$ctx, true);
    }

    tpResponseHandler(String s)
    {
        val$ctx = context1;
        val$pid = s;
        super(final_context);
    }
}
