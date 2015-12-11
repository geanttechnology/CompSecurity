// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.framing;

import java.nio.ByteBuffer;

public interface Framedata
{
    public static final class Opcode extends Enum
    {

        private static final Opcode $VALUES[];
        public static final Opcode BINARY;
        public static final Opcode CLOSING;
        public static final Opcode CONTINUOUS;
        public static final Opcode PING;
        public static final Opcode PONG;
        public static final Opcode TEXT;

        public static Opcode valueOf(String s)
        {
            return (Opcode)Enum.valueOf(org/java_websocket/framing/Framedata$Opcode, s);
        }

        public static Opcode[] values()
        {
            return (Opcode[])$VALUES.clone();
        }

        static 
        {
            CONTINUOUS = new Opcode("CONTINUOUS", 0);
            TEXT = new Opcode("TEXT", 1);
            BINARY = new Opcode("BINARY", 2);
            PING = new Opcode("PING", 3);
            PONG = new Opcode("PONG", 4);
            CLOSING = new Opcode("CLOSING", 5);
            $VALUES = (new Opcode[] {
                CONTINUOUS, TEXT, BINARY, PING, PONG, CLOSING
            });
        }

        private Opcode(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract Opcode getOpcode();

    public abstract ByteBuffer getPayloadData();

    public abstract boolean getTransfereMasked();

    public abstract boolean isFin();
}
