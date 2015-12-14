// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            SubscriptionInfoCache

class val.postFetch extends AsyncTask
{

    final SubscriptionInfoCache this$0;
    final Runnable val$postFetch;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            SubscriptionInfoCache.access$400(SubscriptionInfoCache.this);
            SubscriptionInfoCache.access$500(SubscriptionInfoCache.this);
            if (val$postFetch != null)
            {
                val$postFetch.run();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.i(SubscriptionInfoCache.access$000(), "User not registered while fetching subscription info", new Object[0]);
        }
        return null;
    }

    ()
    {
        this$0 = final_subscriptioninfocache;
        val$postFetch = Runnable.this;
        super();
    }
}
