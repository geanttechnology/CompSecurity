// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            BlockingTokenAccessor

public class mErrorType
    implements Callback
{

    private notifyResultDelivered mErrorType;
    private boolean mResultDelivered;
    private Bundle mResults;
    final BlockingTokenAccessor this$0;

    private void notifyResultDelivered()
    {
        this;
        JVM INSTR monitorenter ;
        mResultDelivered = true;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getResult()
        throws mResultDelivered, InterruptedException
    {
_L2:
        if (mResultDelivered)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        this;
        JVM INSTR monitorenter ;
        wait(10000L);
        this;
        JVM INSTR monitorexit ;
        if (mResultDelivered) goto _L2; else goto _L1
_L1:
        throw new mResultDelivered(BlockingTokenAccessor.this);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        String s = mResults.getString("value_key");
        switch (or.app.authentication.BlockingTokenAccessor.ErrorType[mErrorType.mErrorType()])
        {
        default:
            if (s == null || s.isEmpty())
            {
                throw new mErrorType(BlockingTokenAccessor.this, mResults);
            } else
            {
                return s;
            }

        case 1: // '\001'
            break;
        }
        if (BlockingTokenAccessor.access$000(BlockingTokenAccessor.this, mResults))
        {
            throw new mResults(BlockingTokenAccessor.this);
        } else
        {
            throw new this._cls0(BlockingTokenAccessor.this, mResults);
        }
    }

    public void onError(Bundle bundle)
    {
        mErrorType = mErrorType;
        mResults = bundle;
        notifyResultDelivered();
    }

    public void onSuccess(Bundle bundle)
    {
        mResults = bundle;
        notifyResultDelivered();
    }

    public ()
    {
        this$0 = BlockingTokenAccessor.this;
        super();
        mErrorType = mErrorType;
    }
}
