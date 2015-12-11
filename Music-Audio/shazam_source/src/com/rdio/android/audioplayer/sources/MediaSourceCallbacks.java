// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import com.rdio.android.audioplayer.interfaces.AudioError;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            MediaSource

public interface MediaSourceCallbacks
{

    public abstract void onError(MediaSource mediasource, AudioError audioerror);

    public abstract void onProgress(MediaSource mediasource);

    public abstract void onReady(MediaSource mediasource);

    public abstract void shouldGetAd(MediaSource mediasource);
}
