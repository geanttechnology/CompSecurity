// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.entitlement;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.model.entitlement:
//            VideoEntitlementCache, EntitlementResponseHandler

class this._cls0
    implements Provider
{

    final VideoEntitlementCache this$0;

    public EntitlementResponseHandler get()
    {
        return new EntitlementResponseHandler(VideoEntitlementCache.access$000(VideoEntitlementCache.this));
    }

    public volatile Object get()
    {
        return get();
    }

    er()
    {
        this$0 = VideoEntitlementCache.this;
        super();
    }
}
