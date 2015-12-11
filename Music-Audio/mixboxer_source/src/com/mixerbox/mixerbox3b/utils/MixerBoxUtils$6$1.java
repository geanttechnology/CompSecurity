// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.MainPage;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.utils:
//            MixerBoxUtils

class <init> extends AsyncHttpResponseHandler
{

    final l.ctx this$0;
    final int val$i2;
    final String val$p;

    public void onFailure(Throwable throwable, String s)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append("FAILURE ").append(throwable.toString()).append(" / ").append(s).toString());
        ((MainPage)ctx).myPlaylists.add(val$p);
        if (val$i2 <= 2)
        {
            MixerBoxUtils.reloadMyPlaylist(ctx, false);
        }
    }

    public void onSuccess(String s)
    {
        ((MainPage)ctx).myPlaylists.add(val$p);
        if (val$i2 <= 2)
        {
            MixerBoxUtils.reloadMyPlaylist(ctx, false);
        }
    }

    ()
    {
        this$0 = final_;
        val$p = s;
        val$i2 = I.this;
        super();
    }
}
