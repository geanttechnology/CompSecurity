// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;


// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity

public static final class  extends Enum
{

    private static final CLOSE $VALUES[];
    public static final CLOSE ASK;
    public static final CLOSE CLOSE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/FeatherActivity$FinalAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ASK = new <init>("ASK", 0);
        CLOSE = new <init>("CLOSE", 1);
        $VALUES = (new .VALUES[] {
            ASK, CLOSE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
