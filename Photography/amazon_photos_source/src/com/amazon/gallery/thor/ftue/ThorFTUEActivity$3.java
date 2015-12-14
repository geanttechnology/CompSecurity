// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.os.AsyncTask;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.account.SubscriptionInfoCache;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            ThorFTUEActivity

class this._cls0
    implements Runnable
{

    final ThorFTUEActivity this$0;

    public void run()
    {
        boolean flag1;
label0:
        {
            flag1 = true;
            synchronized (ThorFTUEActivity.this)
            {
                if (ThorFTUEActivity.access$600(ThorFTUEActivity.this) == null)
                {
                    break label0;
                }
            }
            return;
        }
        ThorFTUEActivity thorftueactivity1;
        ThorFTUEActivity thorftueactivity2;
        if (ThorFTUEActivity.access$700(ThorFTUEActivity.this).getConnectionStatus() == com.amazon.gallery.framework.network.connectivity..ConnectionStatus.NONE)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        thorftueactivity1 = ThorFTUEActivity.this;
        thorftueactivity2 = ThorFTUEActivity.this;
        boolean flag;
        if (ThorFTUEActivity.access$800(ThorFTUEActivity.this) == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ThorFTUEActivity.access$900(ThorFTUEActivity.this).getPromotionCheckOccurredInThisSession())
        {
            flag1 = false;
        }
        ThorFTUEActivity.access$602(thorftueactivity1, new adingAsyncRunner(thorftueactivity2, flag, flag1));
        ThorFTUEActivity.access$600(ThorFTUEActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        thorftueactivity;
        JVM INSTR monitorexit ;
        return;
        exception;
        thorftueactivity;
        JVM INSTR monitorexit ;
        throw exception;
    }

    adingAsyncRunner()
    {
        this$0 = ThorFTUEActivity.this;
        super();
    }
}
