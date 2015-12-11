// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            RegistrationListClient, RegistrationListResponseHandler

class this._cls0
    implements Provider
{

    final RegistrationListClient this$0;

    public RegistrationListResponseHandler get()
    {
        return new RegistrationListResponseHandler(RegistrationListClient.access$000(RegistrationListClient.this));
    }

    public volatile Object get()
    {
        return get();
    }

    andler()
    {
        this$0 = RegistrationListClient.this;
        super();
    }
}
