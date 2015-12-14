// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCds

public static final class  extends Enum
{

    private static final LAUNCH $VALUES[];
    public static final LAUNCH LAUNCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$MessageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LAUNCH = new <init>("LAUNCH", 0);
        $VALUES = (new .VALUES[] {
            LAUNCH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
