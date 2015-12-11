// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSIBase

public static final class  extends Enum
{

    private static final HIGH $VALUES[];
    public static final HIGH HIGH;
    public static final HIGH IDLE;
    public static final HIGH LOW;
    public static final HIGH MEDIUM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/DMSIBase$DMS_PROFILES, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        LOW = new <init>("LOW", 1);
        MEDIUM = new <init>("MEDIUM", 2);
        HIGH = new <init>("HIGH", 3);
        $VALUES = (new .VALUES[] {
            IDLE, LOW, MEDIUM, HIGH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
