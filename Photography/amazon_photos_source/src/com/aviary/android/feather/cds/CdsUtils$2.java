// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.util.Log;
import com.aviary.android.feather.cds.billing.util.IabResult;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

static final class val.lock
    implements com.aviary.android.feather.cds.billing.util.nIabSetupFinishedListener
{

    final Object val$lock;

    public void onIabSetupFinished(IabResult iabresult)
    {
        Log.d("CdsUtils", (new StringBuilder()).append("IAPInstance::onIabSetupFinished: ").append(iabresult).toString());
        synchronized (val$lock)
        {
            val$lock.notify();
        }
        return;
        exception;
        iabresult;
        JVM INSTR monitorexit ;
        throw exception;
    }

    l.IabResult(Object obj)
    {
        val$lock = obj;
        super();
    }
}
