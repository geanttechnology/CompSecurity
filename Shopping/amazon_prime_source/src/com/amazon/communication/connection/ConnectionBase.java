// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.connection;

import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionClosedDetails;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class ConnectionBase
    implements Connection
{

    protected int mConnectionState;
    protected Set mListeners;

    public ConnectionBase()
    {
        mListeners = Collections.synchronizedSet(new HashSet(1));
    }

    private void notifyStateClosed(int i, String s)
    {
        Set set = mListeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((amazon.communication.connection.Connection.ConnectionListener)iterator.next()).onClosed(this, new ConnectionClosedDetails(i, s))) { }
        break MISSING_BLOCK_LABEL_61;
        s;
        set;
        JVM INSTR monitorexit ;
        throw s;
        set;
        JVM INSTR monitorexit ;
    }

    private void notifyStateOpened()
    {
        Set set = mListeners;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((amazon.communication.connection.Connection.ConnectionListener)iterator.next()).onOpened(this)) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        set;
        JVM INSTR monitorexit ;
    }

    public void addConnectionListener(amazon.communication.connection.Connection.ConnectionListener connectionlistener)
    {
        if (connectionlistener == null)
        {
            throw new IllegalArgumentException("Connection listener cannot be null");
        } else
        {
            mListeners.add(connectionlistener);
            return;
        }
    }

    public int getConnectionState()
    {
        return mConnectionState;
    }

    public void release()
    {
        throw new UnsupportedOperationException();
    }

    public void removeConnectionListener(amazon.communication.connection.Connection.ConnectionListener connectionlistener)
    {
        if (connectionlistener == null)
        {
            throw new IllegalArgumentException("Connection listener cannot be null");
        }
        if (mListeners.contains(connectionlistener))
        {
            mListeners.remove(connectionlistener);
            return;
        } else
        {
            throw new IllegalArgumentException("Connection listener isn't registered to connection");
        }
    }

    public void setConnectionState(int i)
    {
        int j = mConnectionState;
        this;
        JVM INSTR monitorenter ;
        mConnectionState = i;
        this;
        JVM INSTR monitorexit ;
        Exception exception;
        if (j != 4 && i == 4)
        {
            notifyStateClosed(0, null);
        } else
        if (j != 2 && i == 2)
        {
            notifyStateOpened();
            return;
        }
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
