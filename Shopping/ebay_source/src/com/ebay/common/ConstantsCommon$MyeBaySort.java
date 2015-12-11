// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;


// Referenced classes of package com.ebay.common:
//            ConstantsCommon

public static final class  extends Enum
{

    private static final EndTimeDescending $VALUES[];
    public static final EndTimeDescending EndTime;
    public static final EndTimeDescending EndTimeDescending;
    public static final EndTimeDescending None;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/ConstantsCommon$MyeBaySort, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        EndTime = new <init>("EndTime", 1);
        EndTimeDescending = new <init>("EndTimeDescending", 2);
        $VALUES = (new .VALUES[] {
            None, EndTime, EndTimeDescending
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
