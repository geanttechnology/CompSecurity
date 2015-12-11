// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.media;


// Referenced classes of package com.rdio.android.core.media:
//            SimpleUriAudioPlayer

public static interface 
{

    public abstract void onError();

    public abstract void onPlaybackComplete();

    public abstract void onPlayingChanged(boolean flag);

    public abstract void onPositionChanged();
}
