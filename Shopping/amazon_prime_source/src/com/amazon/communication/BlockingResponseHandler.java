// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.RequestFailedException;
import amazon.communication.ResponseHandler;
import amazon.communication.TimeoutException;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.communication.utils.HttpResponseWithDataPoints;
import com.amazon.dp.logger.DPLogger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public class BlockingResponseHandler
    implements ResponseHandler
{

    private static final DPLogger log = new DPLogger("TComm.BlockingResponseHandler");
    private List mDataPoints;
    private volatile RequestFailedException mException;
    private final Lock mLock = new ReentrantLock();
    private HttpResponse mResponse;
    private final Condition mResponseAvailable;
    private final int mTimeout;

    public BlockingResponseHandler(int i)
    {
        mResponseAvailable = mLock.newCondition();
        mTimeout = i;
        mException = null;
    }

    public void onError(HttpRequestBase httprequestbase, RequestFailedException requestfailedexception)
    {
        mLock.lock();
        mException = requestfailedexception;
        mResponseAvailable.signal();
        mLock.unlock();
        return;
        httprequestbase;
        mLock.unlock();
        throw httprequestbase;
    }

    public void onResponse(EndpointIdentity endpointidentity, HttpResponse httpresponse, int i, List list)
    {
        mLock.lock();
        mResponse = httpresponse;
        mDataPoints = list;
        if (mResponse != null)
        {
            mResponseAvailable.signal();
        }
        mLock.unlock();
        return;
        endpointidentity;
        mLock.unlock();
        throw endpointidentity;
    }

    public HttpResponseWithDataPoints waitForResponse()
        throws RequestFailedException, TimeoutException, InterruptedException
    {
        mLock.lock();
        if (mResponse != null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        log.verbose("waitForResponse", "request sent... waiting...", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId())
        });
        boolean flag = false;
        if (mResponseAvailable.await(mTimeout, TimeUnit.MILLISECONDS))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        flag = true;
        log.verbose("waitForResponse", "timed out waiting for condition", new Object[] {
            "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), "mTimeout", Integer.valueOf(mTimeout)
        });
        if (mException != null)
        {
            log.verbose("waitForResponse", "request failed", new Object[] {
                "currentThread.getId", Long.valueOf(Thread.currentThread().getId()), mException
            });
            throw mException;
        }
        break MISSING_BLOCK_LABEL_179;
        Exception exception;
        exception;
        mLock.unlock();
        throw exception;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        throw new TimeoutException((new StringBuilder()).append("Response timeout. ").append(mTimeout).append(" TimeLimit.").toString());
        HttpResponseWithDataPoints httpresponsewithdatapoints = new HttpResponseWithDataPoints(mResponse, mDataPoints);
        mLock.unlock();
        return httpresponsewithdatapoints;
    }

}
