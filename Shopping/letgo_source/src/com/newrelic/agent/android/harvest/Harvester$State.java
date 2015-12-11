// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;


// Referenced classes of package com.newrelic.agent.android.harvest:
//            Harvester

protected static final class  extends Enum
{

    private static final DISABLED $VALUES[];
    public static final DISABLED CONNECTED;
    public static final DISABLED DISABLED;
    public static final DISABLED DISCONNECTED;
    public static final DISABLED UNINITIALIZED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/harvest/Harvester$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNINITIALIZED = new <init>("UNINITIALIZED", 0);
        DISCONNECTED = new <init>("DISCONNECTED", 1);
        CONNECTED = new <init>("CONNECTED", 2);
        DISABLED = new <init>("DISABLED", 3);
        $VALUES = (new .VALUES[] {
            UNINITIALIZED, DISCONNECTED, CONNECTED, DISABLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
