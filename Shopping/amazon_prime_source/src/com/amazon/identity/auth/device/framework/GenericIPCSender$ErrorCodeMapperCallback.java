// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            GenericIPCSender

private final class <init>
    implements Callback
{

    String mFirstCallbackMethod;
    final Callback mInnerCallback;
    final GenericIPCSender this$0;

    private boolean claimCallback(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (mFirstCallbackMethod == null) goto _L2; else goto _L1
_L1:
        MAPLog.w(GenericIPCSender.access$100(), (new StringBuilder("Duplicate callback detected: ")).append(s).append(" called after ").append(mFirstCallbackMethod).toString());
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        mFirstCallbackMethod = s;
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void onError(Bundle bundle)
    {
        while (!claimCallback("onError") || mInnerCallback == null) 
        {
            return;
        }
        mInnerCallback.onError(GenericIPCSender.access$000(GenericIPCSender.this, bundle));
    }

    public void onSuccess(Bundle bundle)
    {
        while (!claimCallback("onSuccess") || mInnerCallback == null) 
        {
            return;
        }
        mInnerCallback.onSuccess(bundle);
    }

    private (Callback callback)
    {
        this$0 = GenericIPCSender.this;
        super();
        mInnerCallback = callback;
    }

    mInnerCallback(Callback callback, byte byte0)
    {
        this(callback);
    }
}
