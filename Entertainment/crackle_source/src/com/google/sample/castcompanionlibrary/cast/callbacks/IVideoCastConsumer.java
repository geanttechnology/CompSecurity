// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.callbacks;

import com.google.android.gms.cast.ApplicationMetadata;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.callbacks:
//            IBaseCastConsumer

public interface IVideoCastConsumer
    extends IBaseCastConsumer
{

    public abstract void onApplicationConnected(ApplicationMetadata applicationmetadata, String s, boolean flag);

    public abstract boolean onApplicationConnectionFailed(int i);

    public abstract void onApplicationDisconnected(int i);

    public abstract void onApplicationStatusChanged(String s);

    public abstract void onApplicationStopFailed(int i);

    public abstract void onDataMessageReceived(String s);

    public abstract void onDataMessageSendFailed(int i);

    public abstract void onRemoteMediaPlayerMetadataUpdated();

    public abstract void onRemoteMediaPlayerStatusUpdated();

    public abstract void onRemovedNamespace();

    public abstract void onVolumeChanged(double d, boolean flag);
}
