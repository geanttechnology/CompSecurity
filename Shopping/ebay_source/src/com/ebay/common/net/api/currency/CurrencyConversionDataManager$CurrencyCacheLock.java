// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import android.os.SystemClock;
import com.ebay.nautilus.kernel.util.CacheLock;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionDataManager

protected static final class LoadState.NEVER extends CacheLock
{
    protected static final class LoadState extends Enum
    {

        private static final LoadState $VALUES[];
        public static final LoadState DONE;
        public static final LoadState NEVER;
        public static final LoadState PENDING;

        public static LoadState valueOf(String s)
        {
            return (LoadState)Enum.valueOf(com/ebay/common/net/api/currency/CurrencyConversionDataManager$CurrencyCacheLock$LoadState, s);
        }

        public static LoadState[] values()
        {
            return (LoadState[])$VALUES.clone();
        }

        static 
        {
            NEVER = new LoadState("NEVER", 0);
            PENDING = new LoadState("PENDING", 1);
            DONE = new LoadState("DONE", 2);
            $VALUES = (new LoadState[] {
                NEVER, PENDING, DONE
            });
        }

        private LoadState(String s, int i)
        {
            super(s, i);
        }
    }


    private volatile long _lastLoadTime;
    public volatile LoadState loadState;
    public volatile LoadState loadTask;

    protected void setLoadTime()
    {
        _lastLoadTime = SystemClock.uptimeMillis();
    }

    protected long throttleTime()
    {
        long l = Math.min(CurrencyConversionDataManager.access$000(), (_lastLoadTime + CurrencyConversionDataManager.access$000()) - SystemClock.uptimeMillis());
        if (l > 0L && CurrencyConversionDataManager.logger._lastLoadTime)
        {
            CurrencyConversionDataManager.logger._lastLoadTime((new StringBuilder()).append("Throttle start of worker thread: ").append(l).toString());
        }
        return l;
    }

    protected LoadState()
    {
        loadState = LoadState.NEVER;
    }
}
