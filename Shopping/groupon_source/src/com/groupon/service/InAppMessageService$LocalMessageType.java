// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;


// Referenced classes of package com.groupon.service:
//            InAppMessageService

public static final class  extends Enum
{

    private static final HEARTX_TOAST $VALUES[];
    public static final HEARTX_TOAST HEARTX_TOAST;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/service/InAppMessageService$LocalMessageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HEARTX_TOAST = new <init>("HEARTX_TOAST", 0);
        $VALUES = (new .VALUES[] {
            HEARTX_TOAST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
