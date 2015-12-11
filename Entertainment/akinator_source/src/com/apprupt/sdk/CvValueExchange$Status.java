// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvValueExchange

static final class  extends Enum
{

    private static final EXCEEDED $VALUES[];
    public static final EXCEEDED DISABLED;
    public static final EXCEEDED EXCEEDED;
    public static final EXCEEDED READY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/apprupt/sdk/CvValueExchange$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DISABLED = new <init>("DISABLED", 0);
        READY = new <init>("READY", 1);
        EXCEEDED = new <init>("EXCEEDED", 2);
        $VALUES = (new .VALUES[] {
            DISABLED, READY, EXCEEDED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
