// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.sdk;


// Referenced classes of package com.inmobi.sdk:
//            InMobiSdk

public static final class  extends Enum
{

    private static final DEBUG $VALUES[];
    public static final DEBUG DEBUG;
    public static final DEBUG ERROR;
    public static final DEBUG NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/sdk/InMobiSdk$LogLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        ERROR = new <init>("ERROR", 1);
        DEBUG = new <init>("DEBUG", 2);
        $VALUES = (new .VALUES[] {
            NONE, ERROR, DEBUG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
