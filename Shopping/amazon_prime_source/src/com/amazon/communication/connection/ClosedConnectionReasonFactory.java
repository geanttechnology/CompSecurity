// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.connection;

import com.dp.utils.FailFast;

public class ClosedConnectionReasonFactory
{

    public ClosedConnectionReasonFactory()
    {
    }

    public static String getReasonForStatusCode(int i)
    {
        i;
        JVM INSTR tableswitch 4001 4010: default 56
    //                   4001 71
    //                   4002 77
    //                   4003 89
    //                   4004 83
    //                   4005 95
    //                   4006 101
    //                   4007 83
    //                   4008 107
    //                   4009 119
    //                   4010 113;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L5 _L8 _L9 _L10
_L9:
        break MISSING_BLOCK_LABEL_119;
_L1:
        String s = "Unkown reason.";
_L11:
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        FailFast.expectTrue(flag);
        return s;
_L2:
        s = "Connection closed for authentication failure. Please make sure you have registered an valid accout.";
          goto _L11
_L3:
        s = "Connection is closed on device side.";
          goto _L11
_L5:
        s = "IO Problem in the connection.";
          goto _L11
_L4:
        s = "Extra data is read on the websocket connection.";
          goto _L11
_L6:
        s = "Websocket frame header incorrect.";
          goto _L11
_L7:
        s = "Websocket PingPong handle failure";
          goto _L11
_L8:
        s = "Server side closed this connection for communication error.";
          goto _L11
_L10:
        s = "Server side closed this connection. No error happened.";
          goto _L11
        s = "Server side closed this connection because it detects a new connection to this device.";
          goto _L11
    }
}
