// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            JNILibrary, TPControlChannelStateMachine, XcpMsgStrategy, TPLog

public final class TPOobManager
{

    private long oobDict[];
    private int oobIndex;
    private long oobLastAck;

    protected TPOobManager()
    {
        oobLastAck = 0L;
        oobDict = new long[40];
        oobIndex = 0;
    }

    void sendAggregatedOutOfBandAck(long al[], int i)
        throws IOException
    {
        if (i <= 0)
        {
            return;
        } else
        {
            TPControlChannelStateMachine.writeMessage(ByteBuffer.wrap(JNILibrary.encodeMessage(al, i)));
            return;
        }
    }

    protected void sendOutOfBandAck(int i, long l, long l1, long l2)
    {
        long l3 = (new Date()).getTime();
        if (TPControlChannelStateMachine.getInstance().isReady()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        long al[];
        oobDict[oobIndex * 4 + 0] = l;
        oobDict[oobIndex * 4 + 1] = l2;
        oobDict[oobIndex * 4 + 2] = i;
        oobDict[oobIndex * 4 + 3] = l1;
        oobIndex = oobIndex + 1;
        if (oobIndex < 10 && oobLastAck != 0L && l3 - oobLastAck < (long)(TPControlChannelStateMachine.getInstance().acc_strategy.oob_ack - 5))
        {
            break MISSING_BLOCK_LABEL_201;
        }
        oobLastAck = l3;
        al = oobDict;
        i = oobIndex;
        oobDict = new long[40];
        oobIndex = 0;
        this;
        JVM INSTR monitorexit ;
        sendAggregatedOutOfBandAck(al, i);
        return;
        Object obj;
        obj;
        if (!TPLog.LOG10.isLoggable("TPOobManager")) goto _L1; else goto _L3
_L3:
        TPLog.LOG10.d("TPOobManager", ((IOException) (obj)).getLocalizedMessage());
        return;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
