// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import android.util.Log;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

class this._cls0
    implements Runnable
{

    final RdioAudioPlayer this$0;

    public void run()
    {
        if (prepare())
        {
            onPrepared();
            return;
        } else
        {
            Log.e("RdioAudioPlayer", "Player failed to prepare.");
            return;
        }
    }

    ()
    {
        this$0 = RdioAudioPlayer.this;
        super();
    }
}
