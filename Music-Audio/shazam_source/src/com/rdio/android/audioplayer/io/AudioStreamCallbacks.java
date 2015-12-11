// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.io;

import com.rdio.android.audioplayer.interfaces.AudioError;

// Referenced classes of package com.rdio.android.audioplayer.io:
//            AudioStream

public interface AudioStreamCallbacks
{

    public abstract void onError(AudioStream audiostream, AudioError audioerror);

    public abstract void onProgress(AudioStream audiostream);

    public abstract void onReady(AudioStream audiostream);
}
