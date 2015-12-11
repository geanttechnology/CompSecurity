// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.callbacks;

import com.google.android.gms.cast.ApplicationMetadata;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.callbacks:
//            BaseCastConsumerImpl, IVideoCastConsumer

public class VideoCastConsumerImpl extends BaseCastConsumerImpl
    implements IVideoCastConsumer
{

    public VideoCastConsumerImpl()
    {
    }

    public void onApplicationConnected(ApplicationMetadata applicationmetadata, String s, boolean flag)
    {
    }

    public boolean onApplicationConnectionFailed(int i)
    {
        return true;
    }

    public void onApplicationDisconnected(int i)
    {
    }

    public void onApplicationStatusChanged(String s)
    {
    }

    public void onApplicationStopFailed(int i)
    {
    }

    public void onDataMessageReceived(String s)
    {
    }

    public void onDataMessageSendFailed(int i)
    {
    }

    public void onRemoteMediaPlayerMetadataUpdated()
    {
    }

    public void onRemoteMediaPlayerStatusUpdated()
    {
    }

    public void onRemovedNamespace()
    {
    }

    public void onVolumeChanged(double d, boolean flag)
    {
    }
}
