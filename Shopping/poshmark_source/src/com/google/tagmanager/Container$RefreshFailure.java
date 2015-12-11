// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Container

public static final class  extends Enum
{

    private static final UNKNOWN_ERROR $VALUES[];
    public static final UNKNOWN_ERROR IO_ERROR;
    public static final UNKNOWN_ERROR NETWORK_ERROR;
    public static final UNKNOWN_ERROR NO_NETWORK;
    public static final UNKNOWN_ERROR NO_SAVED_CONTAINER;
    public static final UNKNOWN_ERROR SERVER_ERROR;
    public static final UNKNOWN_ERROR UNKNOWN_ERROR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/Container$RefreshFailure, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_SAVED_CONTAINER = new <init>("NO_SAVED_CONTAINER", 0);
        IO_ERROR = new <init>("IO_ERROR", 1);
        NO_NETWORK = new <init>("NO_NETWORK", 2);
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 3);
        SERVER_ERROR = new <init>("SERVER_ERROR", 4);
        UNKNOWN_ERROR = new <init>("UNKNOWN_ERROR", 5);
        $VALUES = (new .VALUES[] {
            NO_SAVED_CONTAINER, IO_ERROR, NO_NETWORK, NETWORK_ERROR, SERVER_ERROR, UNKNOWN_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
