// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import org.json.JSONException;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

final class ttpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final boolean val$hasToShowMyPlaylist;

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        try
        {
            MixerBoxUtils.access$000(val$ctx, s, val$hasToShowMyPlaylist);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    ttpResponseHandler(boolean flag)
    {
        val$ctx = context1;
        val$hasToShowMyPlaylist = flag;
        super(final_context);
    }
}
