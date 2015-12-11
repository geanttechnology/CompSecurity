// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl;


// Referenced classes of package com.flow.android.engine.library.impl:
//            FlowServerCallback

private static final class  extends Enum
{

    private static final FLOW_ENGINE_SHUTDOWN $VALUES[];
    public static final FLOW_ENGINE_SHUTDOWN FLOW_ENGINE_SHUTDOWN;
    public static final FLOW_ENGINE_SHUTDOWN FLOW_SERVER_IDLE;
    public static final FLOW_ENGINE_SHUTDOWN FLOW_SERVER_RESPONSE_RECEIVED;
    public static final FLOW_ENGINE_SHUTDOWN FLOW_SERVER_WAITING_RESPONSE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flow/android/engine/library/impl/FlowServerCallback$FlowServerState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FLOW_SERVER_IDLE = new <init>("FLOW_SERVER_IDLE", 0);
        FLOW_SERVER_WAITING_RESPONSE = new <init>("FLOW_SERVER_WAITING_RESPONSE", 1);
        FLOW_SERVER_RESPONSE_RECEIVED = new <init>("FLOW_SERVER_RESPONSE_RECEIVED", 2);
        FLOW_ENGINE_SHUTDOWN = new <init>("FLOW_ENGINE_SHUTDOWN", 3);
        $VALUES = (new .VALUES[] {
            FLOW_SERVER_IDLE, FLOW_SERVER_WAITING_RESPONSE, FLOW_SERVER_RESPONSE_RECEIVED, FLOW_ENGINE_SHUTDOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
