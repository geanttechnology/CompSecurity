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
    final boolean val$hasToClear;
    final boolean val$hasToShowMyPlaylist;

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        try
        {
            MixerBoxUtils.access$100(val$ctx, s, val$hasToShowMyPlaylist, val$hasToClear);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    ttpResponseHandler(boolean flag1)
    {
        val$ctx = context1;
        val$hasToShowMyPlaylist = flag;
        val$hasToClear = flag1;
        super(final_context);
    }
}
