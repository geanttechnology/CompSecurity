// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library;


// Referenced classes of package com.flow.android.engine.library:
//            FlowStateEngineInterface

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN NO_NETWORK;
    public static final UNKNOWN SERVER_ERROR;
    public static final UNKNOWN UNAUTHORIZED_ACCESS;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_NETWORK = new <init>("NO_NETWORK", 0);
        UNAUTHORIZED_ACCESS = new <init>("UNAUTHORIZED_ACCESS", 1);
        SERVER_ERROR = new <init>("SERVER_ERROR", 2);
        UNKNOWN = new <init>("UNKNOWN", 3);
        $VALUES = (new .VALUES[] {
            NO_NETWORK, UNAUTHORIZED_ACCESS, SERVER_ERROR, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
