// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import com.amazon.clouddrive.extended.model.CloudDriveSubscription;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            SubscriptionInfoCache

class this._cls0
    implements yFetcher
{

    final SubscriptionInfoCache this$0;

    public String getKey(CloudDriveSubscription clouddrivesubscription)
    {
        return clouddrivesubscription.getPlanId();
    }

    public volatile String getKey(Object obj)
    {
        return getKey((CloudDriveSubscription)obj);
    }

    yFetcher()
    {
        this$0 = SubscriptionInfoCache.this;
        super();
    }
}
