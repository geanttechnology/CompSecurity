// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;


// Referenced classes of package com.penthera.virtuososdk.monitor:
//            BatteryMonitor

private static final class  extends Enum
{

    public static final LEVEL_CHANGED CONNECTED;
    public static final LEVEL_CHANGED DISCONNECTED;
    private static final LEVEL_CHANGED ENUM$VALUES[];
    public static final LEVEL_CHANGED LEVEL_CHANGED;
    public static final LEVEL_CHANGED NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/monitor/BatteryMonitor$Event, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        CONNECTED = new <init>("CONNECTED", 1);
        DISCONNECTED = new <init>("DISCONNECTED", 2);
        LEVEL_CHANGED = new <init>("LEVEL_CHANGED", 3);
        ENUM$VALUES = (new ENUM.VALUES[] {
            NONE, CONNECTED, DISCONNECTED, LEVEL_CHANGED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
