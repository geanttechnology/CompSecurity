// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;


// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

public static final class  extends Enum
{

    private static final Gone $VALUES[];
    public static final Gone Display;
    public static final Gone Gone;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/supersonicads/sdk/controller/SupersonicWebView$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Display = new <init>("Display", 0);
        Gone = new <init>("Gone", 1);
        $VALUES = (new .VALUES[] {
            Display, Gone
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
