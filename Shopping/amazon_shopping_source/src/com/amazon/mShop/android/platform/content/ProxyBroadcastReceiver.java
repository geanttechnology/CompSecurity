// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.android.platform.dex.ExceptionUtil;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;

// Referenced classes of package com.amazon.mShop.android.platform.content:
//            BroadcastReceiverDelgateBase

public class ProxyBroadcastReceiver extends BroadcastReceiver
{

    private BroadcastReceiverDelgateBase mDelegate;

    public ProxyBroadcastReceiver()
    {
    }

    public BroadcastReceiverDelgateBase getDelegate()
    {
        this;
        JVM INSTR monitorenter ;
        BroadcastReceiverDelgateBase broadcastreceiverdelgatebase = mDelegate;
        if (broadcastreceiverdelgatebase != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        mDelegate = (BroadcastReceiverDelgateBase)SecondDexEntry.getInstance().createBroadcastReceiveDelegate(this);
_L1:
        broadcastreceiverdelgatebase = mDelegate;
        this;
        JVM INSTR monitorexit ;
        return broadcastreceiverdelgatebase;
        Object obj;
        obj;
        ExceptionUtil.reportExceptions(getClass().getSimpleName(), ((Exception) (obj)));
          goto _L1
        obj;
        throw obj;
    }

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            getDelegate().onReceive_impl(context, intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
