// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;

public final class TransactionState
{
    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State COMPLETE;
        public static final State READY;
        public static final State SENT;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/newrelic/agent/android/instrumentation/TransactionState$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            READY = new State("READY", 0);
            SENT = new State("SENT", 1);
            COMPLETE = new State("COMPLETE", 2);
            $VALUES = (new State[] {
                READY, SENT, COMPLETE
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private static final AgentLog log = AgentLogManager.getAgentLog();
    private String appData;
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private String contentType;
    private long endTime;
    private int errorCode;
    private long startTime;
    private State state;
    private int statusCode;
    private TransactionData transactionData;
    private String url;

    public TransactionState()
    {
        startTime = System.currentTimeMillis();
        carrier = "Other";
        state = State.READY;
    }

    private TransactionData toTransactionData()
    {
        if (!isComplete())
        {
            log.warning("toTransactionData() called on incomplete TransactionState");
        }
        if (url == null)
        {
            log.error("Attempted to convert a TransactionState instance with no URL into a TransactionData");
            return null;
        }
        if (transactionData == null)
        {
            transactionData = new TransactionData(url, carrier, (float)(endTime - startTime) / 1000F, statusCode, errorCode, bytesSent, bytesReceived, appData);
        }
        return transactionData;
    }

    public TransactionData end()
    {
        if (!isComplete())
        {
            state = State.COMPLETE;
            endTime = System.currentTimeMillis();
        }
        return toTransactionData();
    }

    public long getBytesReceived()
    {
        return bytesReceived;
    }

    public String getContentType()
    {
        return contentType;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isComplete()
    {
        return state.ordinal() >= State.COMPLETE.ordinal();
    }

    public boolean isSent()
    {
        return state.ordinal() >= State.SENT.ordinal();
    }

    public void setAppData(String s)
    {
        if (!isComplete())
        {
            appData = s;
            return;
        } else
        {
            log.warning((new StringBuilder()).append("setAppData(...) called on TransactionState in ").append(state.toString()).append(" state").toString());
            return;
        }
    }

    public void setBytesReceived(long l)
    {
        if (!isComplete())
        {
            bytesReceived = l;
            return;
        } else
        {
            log.warning((new StringBuilder()).append("setBytesReceived(...) called on TransactionState in ").append(state.toString()).append(" state").toString());
            return;
        }
    }

    public void setBytesSent(long l)
    {
        if (!isComplete())
        {
            bytesSent = l;
            state = State.SENT;
            return;
        } else
        {
            log.warning((new StringBuilder()).append("setBytesSent(...) called on TransactionState in ").append(state.toString()).append(" state").toString());
            return;
        }
    }

    public void setCarrier(String s)
    {
        if (!isSent())
        {
            carrier = s;
            return;
        } else
        {
            log.warning((new StringBuilder()).append("setCarrier(...) called on TransactionState in ").append(state.toString()).append(" state").toString());
            return;
        }
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setErrorCode(int i)
    {
        if (!isComplete())
        {
            errorCode = i;
            return;
        }
        if (transactionData != null)
        {
            transactionData.setErrorCode(i);
        }
        log.warning((new StringBuilder()).append("setErrorCode(...) called on TransactionState in ").append(state.toString()).append(" state").toString());
    }

    public void setStatusCode(int i)
    {
        if (!isComplete())
        {
            statusCode = i;
            return;
        } else
        {
            log.warning((new StringBuilder()).append("setStatusCode(...) called on TransactionState in ").append(state.toString()).append(" state").toString());
            return;
        }
    }

    public void setUrl(String s)
    {
        if (!isSent())
        {
            url = s;
            return;
        } else
        {
            log.warning((new StringBuilder()).append("setUrl(...) called on TransactionState in ").append(state.toString()).append(" state").toString());
            return;
        }
    }

}
