// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer;

import android.os.Handler;
import android.util.Log;
import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.sources.MediaSource;
import com.rdio.android.audioplayer.sources.MediaSourceCallbacks;
import java.io.IOException;

// Referenced classes of package com.rdio.android.audioplayer:
//            RdioAudioPlayer

private class <init>
    implements MediaSourceCallbacks
{

    private boolean isRemovalPosted;
    final RdioAudioPlayer this$0;

    public void onError(MediaSource mediasource, AudioError audioerror)
    {
    }

    public void onProgress(MediaSource mediasource)
    {
        while (isRemovalPosted || mediasource == null || mediasource != getCurrentSource() || RdioAudioPlayer.access$200(RdioAudioPlayer.this) != com.rdio.android.audioplayer.interfaces.sted || mediasource.getBytesBuffered() <= 12000L) 
        {
            return;
        }
        isRemovalPosted = true;
        RdioAudioPlayer.access$2100(RdioAudioPlayer.this).post(RdioAudioPlayer.access$2000(RdioAudioPlayer.this));
        try
        {
            RdioAudioPlayer.access$2200(RdioAudioPlayer.this);
        }
        // Misplaced declaration of an exception variable
        catch (MediaSource mediasource)
        {
            Log.e("RdioAudioPlayer", "postStartDataSourceListener:Caught Exception when starting", mediasource);
        }
        onInfo(RdioAudioPlayer.access$2300(RdioAudioPlayer.this));
    }

    public void onReady(MediaSource mediasource)
    {
    }

    public void reset()
    {
        isRemovalPosted = false;
    }

    public void shouldGetAd(MediaSource mediasource)
    {
    }

    private ()
    {
        this$0 = RdioAudioPlayer.this;
        super();
        isRemovalPosted = false;
    }

    isRemovalPosted(isRemovalPosted isremovalposted)
    {
        this();
    }
}
