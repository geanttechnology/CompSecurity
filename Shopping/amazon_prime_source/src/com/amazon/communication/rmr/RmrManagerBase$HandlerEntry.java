// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rmr;

import amazon.communication.Message;
import amazon.communication.connection.Connection;
import amazon.communication.rmr.RmrRequest;
import amazon.communication.rmr.RmrResponseCleanedUpException;
import amazon.communication.rmr.RmrResponseHandler;
import com.amazon.dp.logger.DPLogger;
import com.dp.utils.FailFast;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.communication.rmr:
//            RmrManagerBase

private static class mSequenceOfEndOfResponses
{

    private Connection mConnection;
    private int mCountReceived;
    private final RmrResponseHandler mHandler;
    private final AtomicBoolean mOnErrorInvoked = new AtomicBoolean(false);
    private final AtomicBoolean mOnFinishInvoked = new AtomicBoolean(false);
    private final RmrRequest mRequest;
    private int mSequenceOfEndOfResponses;

    public boolean areAllResponsesReceived()
    {
        return mCountReceived == mSequenceOfEndOfResponses;
    }

    public void onError(RmrResponseCleanedUpException rmrresponsecleanedupexception)
    {
        if (!mOnFinishInvoked.get())
        {
            if (mOnErrorInvoked.compareAndSet(false, true))
            {
                mHandler.onError(mRequest, rmrresponsecleanedupexception);
                return;
            } else
            {
                RmrManagerBase.access$000().error("HandlerEntry.onError", "should not call onError multiple times", new Object[] {
                    "mRequest", mRequest
                });
                return;
            }
        } else
        {
            RmrManagerBase.access$000().error("HandlerEntry.onError", "should not call onError after onFinish", new Object[] {
                "mRequest", mRequest
            });
            return;
        }
    }

    public void onFinish()
    {
        if (!mOnErrorInvoked.get())
        {
            if (mOnFinishInvoked.compareAndSet(false, true))
            {
                mHandler.onFinish(mRequest);
                return;
            } else
            {
                RmrManagerBase.access$000().error("HandlerEntry.onFinish", "should not call onFinish multiple times", new Object[] {
                    "mRequest", mRequest
                });
                return;
            }
        } else
        {
            RmrManagerBase.access$000().error("HandlerEntry.onFinish", "don't invoke onFinish after onError", new Object[] {
                "mRequest", mRequest
            });
            return;
        }
    }

    public void onResponse(Message message)
    {
        if (!mOnFinishInvoked.get() && !mOnErrorInvoked.get())
        {
            mHandler.onResponse(mRequest, message);
            mCountReceived = mCountReceived + 1;
            return;
        } else
        {
            RmrManagerBase.access$000().error("HandlerEntry.onResponse", "don't invoke onResponse after onFinish/onError", new Object[] {
                "mRequest", mRequest, "mOnFinishInvoked", Boolean.valueOf(mOnFinishInvoked.get()), "mOnErrorInvoked", Boolean.valueOf(mOnErrorInvoked.get())
            });
            return;
        }
    }

    public void releaseConnection()
    {
        mConnection.release();
        mConnection = null;
    }

    public void setSequenceOfEndOfResponse(int i)
    {
        boolean flag;
        if (mSequenceOfEndOfResponses > -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FailFast.expectFalse(flag, new Object[] {
            "Last response should not have been received"
        });
        mSequenceOfEndOfResponses = i;
    }

    public (RmrResponseHandler rmrresponsehandler, RmrRequest rmrrequest, Connection connection)
    {
        mHandler = rmrresponsehandler;
        mRequest = rmrrequest;
        mConnection = connection;
        mCountReceived = 0;
        mSequenceOfEndOfResponses = -1;
    }
}
