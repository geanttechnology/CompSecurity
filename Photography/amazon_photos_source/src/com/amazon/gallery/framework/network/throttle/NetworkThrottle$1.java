// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.throttle;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.NoNetworkException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.amazon.gallery.framework.network.throttle:
//            NetworkThrottle

class this._cls0
    implements Runnable
{

    final NetworkThrottle this$0;

    public void run()
    {
        long l;
        l = ((Long)NetworkExecutor.getInstance().execute(NetworkThrottle.access$100(NetworkThrottle.this).getNetworkThrottleOperation(NetworkThrottle.access$000(NetworkThrottle.this)))).longValue();
        l = NetworkThrottle.access$200(NetworkThrottle.this, l);
        NetworkThrottle.access$502(NetworkThrottle.this, SystemClock.uptimeMillis());
        GLogger.v(NetworkThrottle.access$300(), "Network delay last fetched %d", new Object[] {
            Long.valueOf(NetworkThrottle.access$500(NetworkThrottle.this))
        });
_L1:
        NetworkThrottle.access$400(NetworkThrottle.this).edit().putLong("persisted_delay_key", l).apply();
        GLogger.d(NetworkThrottle.access$300(), "Network delay updated, new delay is now %dms", new Object[] {
            Long.valueOf(l)
        });
        NetworkThrottle.access$600().set(l);
        return;
        Object obj;
        obj;
        GLogger.i(NetworkThrottle.access$300(), "Unable to retrieve network throttle due to no network connection. Using default value.", new Object[0]);
        l = NetworkThrottle.access$400(NetworkThrottle.this).getLong("persisted_delay_key", 10L);
        NetworkThrottle.access$502(NetworkThrottle.this, SystemClock.uptimeMillis());
        GLogger.v(NetworkThrottle.access$300(), "Network delay last fetched %d", new Object[] {
            Long.valueOf(NetworkThrottle.access$500(NetworkThrottle.this))
        });
          goto _L1
        obj;
        GLogger.wx(NetworkThrottle.access$300(), "An unexpected error occurred retrieving updated network throttle, using default value", ((Throwable) (obj)));
        l = NetworkThrottle.access$400(NetworkThrottle.this).getLong("persisted_delay_key", 10L);
        NetworkThrottle.access$502(NetworkThrottle.this, SystemClock.uptimeMillis());
        GLogger.v(NetworkThrottle.access$300(), "Network delay last fetched %d", new Object[] {
            Long.valueOf(NetworkThrottle.access$500(NetworkThrottle.this))
        });
          goto _L1
        obj;
        NetworkThrottle.access$502(NetworkThrottle.this, SystemClock.uptimeMillis());
        GLogger.v(NetworkThrottle.access$300(), "Network delay last fetched %d", new Object[] {
            Long.valueOf(NetworkThrottle.access$500(NetworkThrottle.this))
        });
        throw obj;
    }

    n()
    {
        this$0 = NetworkThrottle.this;
        super();
    }
}
