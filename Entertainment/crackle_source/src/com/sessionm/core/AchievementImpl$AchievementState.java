// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;


// Referenced classes of package com.sessionm.core:
//            AchievementImpl

public static final class  extends Enum
{

    public static final J G;
    public static final J H;
    public static final J I;
    public static final J J;
    private static final J K[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/core/AchievementImpl$AchievementState, s);
    }

    public static [] values()
    {
        return ([])K.clone();
    }

    static 
    {
        G = new <init>("UNEARNED", 0);
        H = new <init>("UNCLAIMED", 1);
        I = new <init>("PRESENTED", 2);
        J = new <init>("CLAIMED", 3);
        K = (new K[] {
            G, H, I, J
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
