// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rlm;

import amazon.communication.rlm.AckHandler;
import android.os.RemoteException;
import com.amazon.dp.logger.DPLogger;

public class AckHandlerProxy extends IAckHandler.Stub
{

    private static final DPLogger log = new DPLogger("TComm.AckHandlerProxy");
    private final AckHandler mAckHandler;

    public AckHandlerProxy(AckHandler ackhandler)
    {
        mAckHandler = ackhandler;
    }

    public void onAck(int i)
        throws RemoteException
    {
        log.info("onAck", "Received an ACK", new Object[] {
            "messadeID", Integer.valueOf(i)
        });
        try
        {
            mAckHandler.onAck(i);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            log.warn("onAck", "Exception occurred", new Object[] {
                runtimeexception
            });
            throw runtimeexception;
        }
    }

    public void onNack(int i, int j, String s)
        throws RemoteException
    {
        log.info("onNack", "Received a NACK", new Object[] {
            "messadeId", Integer.valueOf(i), "errorCode", Integer.valueOf(j), "description", s
        });
        try
        {
            mAckHandler.onNack(i, j, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.warn("onNack", "Exception occurred", new Object[] {
                s
            });
        }
        throw s;
    }

    public void onPack(int i, int j, String s)
        throws RemoteException
    {
        log.info("onPack", "Received a PACK", new Object[] {
            "messadeId", Integer.valueOf(i), "packCode", Integer.valueOf(j), "description", s
        });
        try
        {
            mAckHandler.onPack(i, j, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.warn("onPack", "Exception occurred", new Object[] {
                s
            });
        }
        throw s;
    }

}
