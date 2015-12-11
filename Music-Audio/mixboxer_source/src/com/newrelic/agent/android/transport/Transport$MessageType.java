// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.transport;


// Referenced classes of package com.newrelic.agent.android.transport:
//            Transport

public static final class  extends Enum
{

    private static final DATA $VALUES[];
    public static final DATA CONNECT;
    public static final DATA DATA;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/transport/Transport$MessageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CONNECT = new <init>("CONNECT", 0);
        DATA = new <init>("DATA", 1);
        $VALUES = (new .VALUES[] {
            CONNECT, DATA
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
