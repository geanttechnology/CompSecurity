// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthorizationClient, VideoAuthorizationResponseHandler

class this._cls0
    implements Provider
{

    final VideoAuthorizationClient this$0;

    public VideoAuthorizationResponseHandler get()
    {
        return new VideoAuthorizationResponseHandler(VideoAuthorizationClient.access$000(VideoAuthorizationClient.this));
    }

    public volatile Object get()
    {
        return get();
    }

    andler()
    {
        this$0 = VideoAuthorizationClient.this;
        super();
    }
}
