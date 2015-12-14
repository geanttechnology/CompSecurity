// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;


public final class  extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/GetPromotionTask$PromotionCategoryType, s);
    }

    public static [] values()
    {
        return ([])d.clone();
    }

    public String a()
    {
        return (new StringBuilder()).append("GetPromotionTask").append(name()).toString();
    }

    static 
    {
        a = new <init>("Default", 0);
        b = new <init>("Costume_Looks", 1);
        c = new <init>("Natural_Looks", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
