// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCds

public static final class  extends Enum
{

    private static final Large $VALUES[];
    public static final Large Large;
    public static final Large Medium;
    public static final Large Small;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$Size, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Small = new <init>("Small", 0);
        Medium = new <init>("Medium", 1);
        Large = new <init>("Large", 2);
        $VALUES = (new .VALUES[] {
            Small, Medium, Large
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
