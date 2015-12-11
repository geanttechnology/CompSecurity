// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket;


// Referenced classes of package org.java_websocket:
//            WebSocket

public static final class  extends Enum
{

    private static final SERVER $VALUES[];
    public static final SERVER CLIENT;
    public static final SERVER SERVER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/java_websocket/WebSocket$Role, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CLIENT = new <init>("CLIENT", 0);
        SERVER = new <init>("SERVER", 1);
        $VALUES = (new .VALUES[] {
            CLIENT, SERVER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
