// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.callbacks;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.callbacks:
//            BaseCastConsumerImpl, IDataCastConsumer

public class DataCastConsumerImpl extends BaseCastConsumerImpl
    implements IDataCastConsumer
{

    public DataCastConsumerImpl()
    {
    }

    public void onApplicationConnected(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
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

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
    }

    public void onMessageSendFailed(Status status)
    {
    }

    public void onRemoved(CastDevice castdevice, String s)
    {
    }

    public void onVolumeChanged(double d, boolean flag)
    {
    }
}
