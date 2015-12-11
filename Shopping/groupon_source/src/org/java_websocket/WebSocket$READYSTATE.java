// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket;


// Referenced classes of package org.java_websocket:
//            WebSocket

public static final class  extends Enum
{

    private static final CLOSED $VALUES[];
    public static final CLOSED CLOSED;
    public static final CLOSED CLOSING;
    public static final CLOSED CONNECTING;
    public static final CLOSED NOT_YET_CONNECTED;
    public static final CLOSED OPEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/java_websocket/WebSocket$READYSTATE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_YET_CONNECTED = new <init>("NOT_YET_CONNECTED", 0);
        CONNECTING = new <init>("CONNECTING", 1);
        OPEN = new <init>("OPEN", 2);
        CLOSING = new <init>("CLOSING", 3);
        CLOSED = new <init>("CLOSED", 4);
        $VALUES = (new .VALUES[] {
            NOT_YET_CONNECTED, CONNECTING, OPEN, CLOSING, CLOSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
