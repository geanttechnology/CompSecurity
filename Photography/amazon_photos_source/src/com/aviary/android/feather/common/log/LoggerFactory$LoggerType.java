// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.log;


// Referenced classes of package com.aviary.android.feather.common.log:
//            LoggerFactory

public static final class  extends Enum
{

    private static final ConsoleLoggerType $VALUES[];
    public static final ConsoleLoggerType ConsoleLoggerType;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/common/log/LoggerFactory$LoggerType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ConsoleLoggerType = new <init>("ConsoleLoggerType", 0);
        $VALUES = (new .VALUES[] {
            ConsoleLoggerType
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
