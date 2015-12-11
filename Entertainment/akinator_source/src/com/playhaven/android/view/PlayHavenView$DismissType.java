// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.view;


// Referenced classes of package com.playhaven.android.view:
//            PlayHavenView

public static final class  extends Enum
{

    private static final OptIn $VALUES[];
    public static final OptIn AppClose;
    public static final OptIn BackButton;
    public static final OptIn Emergency;
    public static final OptIn Launch;
    public static final OptIn NoThanks;
    public static final OptIn OptIn;
    public static final OptIn Purchase;
    public static final OptIn Reward;
    public static final OptIn SelfClose;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/playhaven/android/view/PlayHavenView$DismissType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Emergency = new <init>("Emergency", 0);
        NoThanks = new <init>("NoThanks", 1);
        Launch = new <init>("Launch", 2);
        SelfClose = new <init>("SelfClose", 3);
        AppClose = new <init>("AppClose", 4);
        BackButton = new <init>("BackButton", 5);
        Reward = new <init>("Reward", 6);
        Purchase = new <init>("Purchase", 7);
        OptIn = new <init>("OptIn", 8);
        $VALUES = (new .VALUES[] {
            Emergency, NoThanks, Launch, SelfClose, AppClose, BackButton, Reward, Purchase, OptIn
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
