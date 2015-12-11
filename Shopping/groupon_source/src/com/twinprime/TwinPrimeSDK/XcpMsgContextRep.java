// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.util.Hashtable;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsg, XcpMsgStrategy, TPLog, XcpMsgUtils, 
//            TPControlChannelStateMachine

class XcpMsgContextRep extends XcpMsg
{
    private static class FactoryWorker
        implements XcpMsgUtils.XcpMsgCreator
    {

        public XcpMsg createXcpMsgFromMap(Hashtable hashtable)
        {
            return new XcpMsgContextRep(hashtable);
        }

        private FactoryWorker()
        {
        }

    }


    static final Long CONTEXT_REP_STRATEGY = Long.valueOf(0L);
    XcpMsgStrategy strategy;

    XcpMsgContextRep()
    {
    }

    XcpMsgContextRep(Hashtable hashtable)
    {
        try
        {
            strategy = new XcpMsgStrategy((Hashtable)hashtable.get(CONTEXT_REP_STRATEGY));
        }
        catch (Exception exception)
        {
            strategy = new XcpMsgStrategy();
        }
        if (TPLog.LOG13.isLoggable("XCP"))
        {
            Log.d("XCP", (new StringBuilder()).append("Ctx map: ").append(hashtable).toString());
        }
    }

    static void addToUtils()
    {
        XcpMsgUtils.addXcpType(8, new FactoryWorker());
    }

    void process()
    {
        TPControlChannelStateMachine.getInstance().processContextRep(this);
    }

    public String toDebugString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("XcpMsgContextRep:\n\tstrategy [\n").append(strategy.toString()).append("\n\t]").toString());
        return stringbuffer.toString();
    }

    public String toString()
    {
        if (TPLog.LOG13.isLoggable("XCP"))
        {
            return toDebugString();
        } else
        {
            return super.toString();
        }
    }

}
