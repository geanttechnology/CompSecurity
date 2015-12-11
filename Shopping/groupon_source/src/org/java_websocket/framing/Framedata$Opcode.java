// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.framing;


// Referenced classes of package org.java_websocket.framing:
//            Framedata

public static final class  extends Enum
{

    private static final CLOSING $VALUES[];
    public static final CLOSING BINARY;
    public static final CLOSING CLOSING;
    public static final CLOSING CONTINUOUS;
    public static final CLOSING PING;
    public static final CLOSING PONG;
    public static final CLOSING TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/java_websocket/framing/Framedata$Opcode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CONTINUOUS = new <init>("CONTINUOUS", 0);
        TEXT = new <init>("TEXT", 1);
        BINARY = new <init>("BINARY", 2);
        PING = new <init>("PING", 3);
        PONG = new <init>("PONG", 4);
        CLOSING = new <init>("CLOSING", 5);
        $VALUES = (new .VALUES[] {
            CONTINUOUS, TEXT, BINARY, PING, PONG, CLOSING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
