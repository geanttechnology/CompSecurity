// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            RegisterDeviceClient, RegisterDeviceResponseHandler

class this._cls0
    implements Provider
{

    final RegisterDeviceClient this$0;

    public RegisterDeviceResponseHandler get()
    {
        return new RegisterDeviceResponseHandler(RegisterDeviceClient.access$000(RegisterDeviceClient.this));
    }

    public volatile Object get()
    {
        return get();
    }

    andler()
    {
        this$0 = RegisterDeviceClient.this;
        super();
    }
}
