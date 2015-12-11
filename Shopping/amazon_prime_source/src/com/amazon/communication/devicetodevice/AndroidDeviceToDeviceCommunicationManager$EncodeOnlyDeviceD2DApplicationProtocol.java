// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.devicetodevice;

import amazon.communication.Message;
import amazon.communication.identity.EndpointIdentity;
import com.dp.framework.StreamCodec;

// Referenced classes of package com.amazon.communication.devicetodevice:
//            D2DApplicationProtocol, AndroidDeviceToDeviceCommunicationManager

private class this._cls0 extends D2DApplicationProtocol
{

    final AndroidDeviceToDeviceCommunicationManager this$0;

    public void decode(Message message, EndpointIdentity endpointidentity)
    {
        throw new UnsupportedOperationException("This class can only encode!");
    }

    public (StreamCodec streamcodec)
    {
        this$0 = AndroidDeviceToDeviceCommunicationManager.this;
        super(streamcodec);
    }
}
