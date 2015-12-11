// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.io.AudioStream;
import com.rdio.android.audioplayer.io.AudioStreamCallbacks;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            UriMediaSource

class this._cls0
    implements AudioStreamCallbacks
{

    final UriMediaSource this$0;

    public void onError(AudioStream audiostream, AudioError audioerror)
    {
        UriMediaSource.access$400(UriMediaSource.this, audioerror);
    }

    public void onProgress(AudioStream audiostream)
    {
        UriMediaSource.access$100(UriMediaSource.this).lock();
        UriMediaSource.access$200(UriMediaSource.this).signal();
        UriMediaSource.access$100(UriMediaSource.this).unlock();
        UriMediaSource.access$300(UriMediaSource.this);
        return;
        audiostream;
        UriMediaSource.access$100(UriMediaSource.this).unlock();
        throw audiostream;
    }

    public void onReady(AudioStream audiostream)
    {
        UriMediaSource.access$000(UriMediaSource.this);
    }

    ()
    {
        this$0 = UriMediaSource.this;
        super();
    }
}
