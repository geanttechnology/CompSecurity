// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.transport;

import java.io.InterruptedIOException;

// Referenced classes of package com.newrelic.agent.android.transport:
//            DisableAgentException, DisconnectAgentException, FlushTransactionDataException, TransportException

public interface Transport
{
    public static final class MessageType extends Enum
    {

        private static final MessageType $VALUES[];
        public static final MessageType CONNECT;
        public static final MessageType DATA;

        public static MessageType valueOf(String s)
        {
            return (MessageType)Enum.valueOf(com/newrelic/agent/android/transport/Transport$MessageType, s);
        }

        public static MessageType[] values()
        {
            return (MessageType[])$VALUES.clone();
        }

        static 
        {
            CONNECT = new MessageType("CONNECT", 0);
            DATA = new MessageType("DATA", 1);
            $VALUES = (new MessageType[] {
                CONNECT, DATA
            });
        }

        private MessageType(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract String send(MessageType messagetype, String s, long l)
        throws InterruptedIOException, DisableAgentException, DisconnectAgentException, FlushTransactionDataException, TransportException;
}
