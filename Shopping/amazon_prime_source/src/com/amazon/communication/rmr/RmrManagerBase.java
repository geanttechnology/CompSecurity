// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rmr;

import amazon.communication.BufferedMessageHandler;
import amazon.communication.CommunicationBaseException;
import amazon.communication.CommunicationManager;
import amazon.communication.ConnectionAcquisitionFailedException;
import amazon.communication.Message;
import amazon.communication.MessageHandler;
import amazon.communication.MissingCredentialsException;
import amazon.communication.RegistrationFailedException;
import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.ConnectionPolicyException;
import amazon.communication.connection.IllegalConnectionStateException;
import amazon.communication.connection.Policy;
import amazon.communication.connection.TransmissionFailedException;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.rmr.RmrInitializationFailedException;
import amazon.communication.rmr.RmrRequest;
import amazon.communication.rmr.RmrResponseCanceledException;
import amazon.communication.rmr.RmrResponseCleanedUpException;
import amazon.communication.rmr.RmrResponseException;
import amazon.communication.rmr.RmrResponseHandler;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.dp.logger.DPLogger;
import com.dp.utils.FailFast;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.communication.rmr:
//            RmrMessageRouter, RmrProtocolHandler

public abstract class RmrManagerBase
    implements RmrMessageRouter
{
    private static class HandlerEntry
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
                    RmrManagerBase.log.error("HandlerEntry.onError", "should not call onError multiple times", new Object[] {
                        "mRequest", mRequest
                    });
                    return;
                }
            } else
            {
                RmrManagerBase.log.error("HandlerEntry.onError", "should not call onError after onFinish", new Object[] {
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
                    RmrManagerBase.log.error("HandlerEntry.onFinish", "should not call onFinish multiple times", new Object[] {
                        "mRequest", mRequest
                    });
                    return;
                }
            } else
            {
                RmrManagerBase.log.error("HandlerEntry.onFinish", "don't invoke onFinish after onError", new Object[] {
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
                RmrManagerBase.log.error("HandlerEntry.onResponse", "don't invoke onResponse after onFinish/onError", new Object[] {
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

        public HandlerEntry(RmrResponseHandler rmrresponsehandler, RmrRequest rmrrequest, Connection connection)
        {
            mHandler = rmrresponsehandler;
            mRequest = rmrrequest;
            mConnection = connection;
            mCountReceived = 0;
            mSequenceOfEndOfResponses = -1;
        }
    }

    private class RmrMessageHandler
        implements MessageHandler
    {

        final RmrManagerBase this$0;

        public void onMessage(EndpointIdentity endpointidentity, Message message)
        {
            try
            {
                mRmrProtocolHandler.decodeMessage(endpointidentity, message);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (EndpointIdentity endpointidentity)
            {
                RmrManagerBase.log.warn("RmrMessageHandler.onMessage", "error occurred handling RMR message", new Object[] {
                    endpointidentity
                });
            }
        }

        public void onMessageFragment(EndpointIdentity endpointidentity, int i, Message message, boolean flag)
        {
            throw new UnsupportedOperationException("No fragmentation support in RMR yet");
        }

        private RmrMessageHandler()
        {
            this$0 = RmrManagerBase.this;
            super();
        }

    }

    private class RmrRequestImpl
        implements RmrRequest
    {

        private final EndpointIdentity mEndpoint;
        private final RmrResponseHandler mHandler;
        private final Message mMessage;
        private final MetricEvent mMetricEvent;
        private int mRequestId;
        private final AtomicBoolean mStarted = new AtomicBoolean(false);
        final RmrManagerBase this$0;

        public void cancelRequest()
        {
            cancelRequest(((RmrResponseException) (new RmrResponseCanceledException())));
        }

        public void cancelRequest(RmrResponseException rmrresponseexception)
        {
            if (mShutdownCalled.get())
            {
                RmrManagerBase.log.info("RmrRequestImpl.cancelRequest", "cleanUp is called, give up cancelling request", new Object[] {
                    "mRequestId", Integer.valueOf(mRequestId)
                });
                return;
            }
            mCleanUpSemaphore.acquireUninterruptibly();
            if (mStarted.get())
            {
                break MISSING_BLOCK_LABEL_103;
            }
            RmrManagerBase.log.error("RmrRequestImpl.cancelRequest", "request has not been started", new Object[] {
                "mRequestId", Integer.valueOf(mRequestId)
            });
            mCleanUpSemaphore.release();
            return;
            cancelRequestInternal(mRequestId, this, mHandler, rmrresponseexception);
            mCleanUpSemaphore.release();
            return;
            rmrresponseexception;
            mCleanUpSemaphore.release();
            throw rmrresponseexception;
        }

        public void startRequest()
            throws ConnectionAcquisitionFailedException, MissingCredentialsException, TransmissionFailedException, IllegalConnectionStateException
        {
            if (mShutdownCalled.get())
            {
                RmrManagerBase.log.info("RmrRequestImpl.startRequest", "cleanUp is called, give up starting request", new Object[] {
                    "mRequestId", Integer.valueOf(mRequestId)
                });
                return;
            }
            mCleanUpSemaphore.acquireUninterruptibly();
            if (!mStarted.getAndSet(true))
            {
                break MISSING_BLOCK_LABEL_104;
            }
            RmrManagerBase.log.error("RmrRequestImpl.startRequest", "request has already been started", new Object[] {
                "mRequestId", Integer.valueOf(mRequestId)
            });
            mCleanUpSemaphore.release();
            return;
            mRequestId = mNextRequestId.getAndIncrement();
            startRequestInternal(mRequestId, this, mEndpoint, mMessage, mHandler, mMetricEvent);
            mCleanUpSemaphore.release();
            return;
            Exception exception;
            exception;
            mCleanUpSemaphore.release();
            throw exception;
        }

        public String toString()
        {
            return (new StringBuilder()).append("RmrRequestImpl [message=").append(mMessage).append(", handler=").append(mHandler).append(", endpoint=").append(EndpointIdentity.logSafe(mEndpoint)).append(", started=").append(mStarted).append(", requestId=").append(mRequestId).append("]").toString();
        }

        public RmrRequestImpl(EndpointIdentity endpointidentity, Message message, RmrResponseHandler rmrresponsehandler, MetricEvent metricevent)
        {
            this$0 = RmrManagerBase.this;
            super();
            mEndpoint = endpointidentity;
            mMessage = message;
            mHandler = rmrresponsehandler;
            mMetricEvent = metricevent;
        }
    }


    private static final DPLogger log = new DPLogger("TComm.RmrManagerBase");
    private final int mChannel;
    private final Semaphore mCleanUpSemaphore = new Semaphore(20);
    private CommunicationManager mCommunicationManager;
    private final Map mHandlers = new ConcurrentHashMap();
    private final AtomicInteger mNextRequestId = new AtomicInteger();
    private final Policy mPolicy = getPolicy();
    private final BufferedMessageHandler mRmrMessageHandler = new BufferedMessageHandler(new RmrMessageHandler());
    private final RmrProtocolHandler mRmrProtocolHandler = getRmrProtocolHandler();
    private final AtomicBoolean mShutdownCalled = new AtomicBoolean();

    public RmrManagerBase(int i, CommunicationManager communicationmanager)
        throws RmrInitializationFailedException
    {
        mCommunicationManager = communicationmanager;
        mChannel = i;
        try
        {
            registerMessageHandler();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CommunicationManager communicationmanager)
        {
            throw new RmrInitializationFailedException("Failed to register message handler", communicationmanager);
        }
    }

    private void cancelRequestInternal(int i, RmrRequest rmrrequest, RmrResponseHandler rmrresponsehandler, RmrResponseException rmrresponseexception)
    {
        HandlerEntry handlerentry = (HandlerEntry)mHandlers.remove(Integer.valueOf(i));
        if (handlerentry != null)
        {
            handlerentry.releaseConnection();
            rmrresponsehandler.onError(rmrrequest, rmrresponseexception);
        }
    }

    private void startRequestInternal(int i, RmrRequest rmrrequest, EndpointIdentity endpointidentity, Message message, RmrResponseHandler rmrresponsehandler, MetricEvent metricevent)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException, TransmissionFailedException, IllegalConnectionStateException
    {
        HandlerEntry handlerentry;
        Message message1;
        message1 = mRmrProtocolHandler.encodeRequest(message, i, 0);
        handlerentry = null;
        message = handlerentry;
        metricevent.startTimer("TimeAcquireConnectedConnection");
        endpointidentity = mCommunicationManager.acquireConnectedConnection(endpointidentity, mPolicy, null, 60000);
        message = endpointidentity;
        metricevent.stopTimer("TimeAcquireConnectedConnection");
        message = endpointidentity;
        handlerentry = new HandlerEntry(rmrresponsehandler, rmrrequest, endpointidentity);
        message = endpointidentity;
        mHandlers.put(Integer.valueOf(i), handlerentry);
        message = endpointidentity;
        endpointidentity.sendMessage(message1, mChannel, metricevent);
        message = endpointidentity;
        rmrresponsehandler.onStart(rmrrequest);
        if (true)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        mHandlers.remove(Integer.valueOf(i));
        if (endpointidentity == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        endpointidentity.release();
        return;
        rmrrequest;
        message = handlerentry;
        metricevent.stopTimer("TimeAcquireConnectedConnection");
        message = handlerentry;
        throw rmrrequest;
        rmrrequest;
        if (true)
        {
            mHandlers.remove(Integer.valueOf(i));
            if (message != null)
            {
                try
                {
                    message.release();
                }
                // Misplaced declaration of an exception variable
                catch (EndpointIdentity endpointidentity)
                {
                    log.warn("startRequestInternal", "failed to release connection", new Object[] {
                        endpointidentity
                    });
                }
            }
        }
        throw rmrrequest;
        rmrrequest;
        log.warn("startRequestInternal", "failed to release connection", new Object[] {
            rmrrequest
        });
        return;
    }

    public void cleanUp()
    {
        shutdown();
    }

    public RmrRequest createRmrRequest(EndpointIdentity endpointidentity, Message message, RmrResponseHandler rmrresponsehandler, MetricEvent metricevent)
    {
        if (mShutdownCalled.get())
        {
            throw new IllegalStateException("RmrManagerBase should not be used after cleanUp has been called");
        }
        mCleanUpSemaphore.acquireUninterruptibly();
        endpointidentity = new RmrRequestImpl(endpointidentity, message, rmrresponsehandler, metricevent);
        mCleanUpSemaphore.release();
        return endpointidentity;
        endpointidentity;
        mCleanUpSemaphore.release();
        throw endpointidentity;
    }

    protected abstract ConnectionPolicy getConnectionPolicy()
        throws ConnectionPolicyException;

    protected abstract Policy getPolicy();

    protected abstract RmrProtocolHandler getRmrProtocolHandler();

    protected void registerMessageHandler()
        throws RegistrationFailedException
    {
        mCommunicationManager.registerMessageHandler(mChannel, mRmrMessageHandler);
    }

    public void routeRmrMessage(EndpointIdentity endpointidentity, String s, int i, Message message, int j)
        throws CommunicationBaseException
    {
        Object obj;
        if (s.equals("RQS") || s.equals("NRQ"))
        {
            log.warn("routeRmrMessage", "RMR Request is not supported and not expected here - something is wrong", new Object[0]);
            obj = null;
        } else
        if (s.equals("RPY") || s.equals("NRP") || s.equals("LST") || s.equals("NLS"))
        {
            obj = (HandlerEntry)mHandlers.get(Integer.valueOf(i));
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            log.info("routeRmrMessage", "no entry in handler map for rmr response, perhaps request has timed out", new Object[] {
                "endpoint", EndpointIdentity.logSafe(endpointidentity), "requestId", Integer.valueOf(i)
            });
            return;
        }
        obj;
        JVM INSTR monitorenter ;
        if (!s.equals("LST") && !s.equals("NLS")) goto _L2; else goto _L1
_L1:
        ((HandlerEntry) (obj)).setSequenceOfEndOfResponse(j);
_L6:
        if (!((HandlerEntry) (obj)).areAllResponsesReceived()) goto _L4; else goto _L3
_L3:
        ((HandlerEntry) (obj)).onFinish();
        s = (HandlerEntry)mHandlers.remove(Integer.valueOf(i));
        if (s == null) goto _L4; else goto _L5
_L5:
        endpointidentity = ((EndpointIdentity) (obj));
        s.releaseConnection();
_L4:
        endpointidentity = ((EndpointIdentity) (obj));
        obj;
        JVM INSTR monitorexit ;
        return;
_L7:
        endpointidentity = ((EndpointIdentity) (obj));
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        ((HandlerEntry) (obj)).onResponse(message);
          goto _L6
        s;
          goto _L7
        s;
        obj = endpointidentity;
          goto _L7
    }

    protected void setCommunicationManager(CommunicationManager communicationmanager)
    {
        mCommunicationManager = communicationmanager;
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mShutdownCalled.getAndSet(true);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!mCleanUpSemaphore.tryAcquire(20, 5000L, TimeUnit.MILLISECONDS))
        {
            log.warn("cleanUp", "timed out waiting for outstanding requests, proceeding", new Object[0]);
        }
_L4:
        mCommunicationManager.deregisterMessageHandler(mChannel);
_L5:
        Iterator iterator = mHandlers.entrySet().iterator();
_L3:
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_204;
        }
        obj1 = (java.util.Map.Entry)iterator.next();
        obj1 = (HandlerEntry)((java.util.Map.Entry) (obj1)).getValue();
        ((HandlerEntry) (obj1)).releaseConnection();
        ((HandlerEntry) (obj1)).onError(new RmrResponseCleanedUpException());
          goto _L3
        Exception exception;
        exception;
        log.warn("cleanUp", "a handler's onError threw an exception while cleaning up", new Object[] {
            exception
        });
          goto _L3
        Object obj;
        obj;
        throw obj;
        obj;
        log.warn("cleanup", "interrupted waiting for outstanding requests, proceeding", new Object[] {
            obj
        });
          goto _L4
        obj;
        log.warn("cleanUp", "error occurred during cleanup", new Object[] {
            obj
        });
          goto _L5
        mHandlers.clear();
          goto _L1
    }








}
