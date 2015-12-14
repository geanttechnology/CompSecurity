// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.billing.util;

import com.aviary.android.feather.common.utils.SDKUtils;

// Referenced classes of package com.aviary.android.feather.cds.billing.util:
//            IabHelper

class this._cls0
    implements Runnable
{

    final IabHelper this$0;

    public void run()
    {
        synchronized (IabHelper.access$000(IabHelper.this))
        {
            if (mContext != null)
            {
                String as[] = SDKUtils.getKeys(mContext);
                mSignatureBase64 = as[2];
            }
            logDebug("releasing mSignatureLock");
            IabHelper.access$000(IabHelper.this).notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = IabHelper.this;
        super();
    }
}
