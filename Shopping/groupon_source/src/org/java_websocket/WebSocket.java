// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket;

import java.net.InetSocketAddress;
import org.java_websocket.framing.Framedata;

public interface WebSocket
{
    public static final class READYSTATE extends Enum
    {

        private static final READYSTATE $VALUES[];
        public static final READYSTATE CLOSED;
        public static final READYSTATE CLOSING;
        public static final READYSTATE CONNECTING;
        public static final READYSTATE NOT_YET_CONNECTED;
        public static final READYSTATE OPEN;

        public static READYSTATE valueOf(String s)
        {
            return (READYSTATE)Enum.valueOf(org/java_websocket/WebSocket$READYSTATE, s);
        }

        public static READYSTATE[] values()
        {
            return (READYSTATE[])$VALUES.clone();
        }

        static 
        {
            NOT_YET_CONNECTED = new READYSTATE("NOT_YET_CONNECTED", 0);
            CONNECTING = new READYSTATE("CONNECTING", 1);
            OPEN = new READYSTATE("OPEN", 2);
            CLOSING = new READYSTATE("CLOSING", 3);
            CLOSED = new READYSTATE("CLOSED", 4);
            $VALUES = (new READYSTATE[] {
                NOT_YET_CONNECTED, CONNECTING, OPEN, CLOSING, CLOSED
            });
        }

        private READYSTATE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Role extends Enum
    {

        private static final Role $VALUES[];
        public static final Role CLIENT;
        public static final Role SERVER;

        public static Role valueOf(String s)
        {
            return (Role)Enum.valueOf(org/java_websocket/WebSocket$Role, s);
        }

        public static Role[] values()
        {
            return (Role[])$VALUES.clone();
        }

        static 
        {
            CLIENT = new Role("CLIENT", 0);
            SERVER = new Role("SERVER", 1);
            $VALUES = (new Role[] {
                CLIENT, SERVER
            });
        }

        private Role(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract InetSocketAddress getLocalSocketAddress();

    public abstract void sendFrame(Framedata framedata);
}
