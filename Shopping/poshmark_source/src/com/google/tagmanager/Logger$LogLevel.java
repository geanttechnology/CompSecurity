// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Logger

public static final class  extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE DEBUG;
    public static final NONE ERROR;
    public static final NONE INFO;
    public static final NONE NONE;
    public static final NONE VERBOSE;
    public static final NONE WARNING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/Logger$LogLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VERBOSE = new <init>("VERBOSE", 0);
        DEBUG = new <init>("DEBUG", 1);
        INFO = new <init>("INFO", 2);
        WARNING = new <init>("WARNING", 3);
        ERROR = new <init>("ERROR", 4);
        NONE = new <init>("NONE", 5);
        $VALUES = (new .VALUES[] {
            VERBOSE, DEBUG, INFO, WARNING, ERROR, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
