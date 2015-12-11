// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.fragments.SongFragment;

final class tpResponseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final Context val$ctx;
    final SongFragment val$f;
    final boolean val$hasToGoBack;
    final int val$playIndex;
    final int val$type;

    public final void onSuccess(String s)
    {
        super.onSuccess(s);
        (new dSongTask(val$ctx, val$hasToGoBack, val$type, val$playIndex, val$f)).execute(new String[] {
            s
        });
    }

    dSongTask(SongFragment songfragment)
    {
        val$ctx = context1;
        val$hasToGoBack = flag;
        val$type = i;
        val$playIndex = j;
        val$f = songfragment;
        super(final_context);
    }
}
