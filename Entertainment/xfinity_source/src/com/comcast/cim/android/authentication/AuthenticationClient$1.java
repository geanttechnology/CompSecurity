// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.comcast.cim.android.authentication:
//            AuthenticationClient, AuthResponseHandler

class this._cls0
    implements Provider
{

    final AuthenticationClient this$0;

    public AuthResponseHandler get()
    {
        return new AuthResponseHandler(AuthenticationClient.access$000(AuthenticationClient.this));
    }

    public volatile Object get()
    {
        return get();
    }

    ()
    {
        this$0 = AuthenticationClient.this;
        super();
    }
}
