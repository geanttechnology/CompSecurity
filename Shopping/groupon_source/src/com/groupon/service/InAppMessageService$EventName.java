// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;


// Referenced classes of package com.groupon.service:
//            InAppMessageService

public static final class  extends Enum
{

    private static final DISMISSED $VALUES[];
    public static final DISMISSED CLICKED;
    public static final DISMISSED DISMISSED;
    public static final DISMISSED VIEWED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/service/InAppMessageService$EventName, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }

    static 
    {
        VIEWED = new <init>("VIEWED", 0);
        CLICKED = new <init>("CLICKED", 1);
        DISMISSED = new <init>("DISMISSED", 2);
        $VALUES = (new .VALUES[] {
            VIEWED, CLICKED, DISMISSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
