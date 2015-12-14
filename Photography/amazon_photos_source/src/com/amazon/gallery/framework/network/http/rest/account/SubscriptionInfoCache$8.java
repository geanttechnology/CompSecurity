// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            SubscriptionInfoCache

class val.timeout
    implements Callable
{

    final SubscriptionInfoCache this$0;
    final long val$timeout;

    public omotion call()
    {
        if (BuildFlavors.isDebug() && SubscriptionInfoCache.access$600(SubscriptionInfoCache.this).getBoolean("FORCE_DEBUG_PROMOTION", false))
        {
            SubscriptionInfoCache.access$600(SubscriptionInfoCache.this).edit().putBoolean("FORCE_DEBUG_PROMOTION", false).apply();
            return SubscriptionInfoCache.access$700();
        }
        if (SubscriptionInfoCache.access$800(SubscriptionInfoCache.this) && SubscriptionInfoCache.access$900(SubscriptionInfoCache.this) != null)
        {
            return SubscriptionInfoCache.access$1000(SubscriptionInfoCache.this, val$timeout);
        } else
        {
            return null;
        }
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    omotion()
    {
        this$0 = final_subscriptioninfocache;
        val$timeout = J.this;
        super();
    }
}
