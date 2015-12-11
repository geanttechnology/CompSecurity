// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.libraries.youtube.player.notification.ExternalPlaybackControllerV14;

public final class cuh
    implements android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
{

    private ExternalPlaybackControllerV14 a;

    public cuh(ExternalPlaybackControllerV14 externalplaybackcontrollerv14)
    {
        a = externalplaybackcontrollerv14;
        super();
    }

    public final void onPlaybackPositionUpdate(long l)
    {
        a.b.a(l);
    }
}
