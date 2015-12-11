// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


// Referenced classes of package com.amazon.identity.auth.device.framework:
//            PendingIntentWrapper

public static final class  extends Enum
{

    private static final Activity $VALUES[];
    public static final Activity Activity;
    public static final Activity Broadcast;
    public static final Activity Service;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/framework/PendingIntentWrapper$PendingIntentType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Broadcast = new <init>("Broadcast", 0);
        Service = new <init>("Service", 1);
        Activity = new <init>("Activity", 2);
        $VALUES = (new .VALUES[] {
            Broadcast, Service, Activity
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
