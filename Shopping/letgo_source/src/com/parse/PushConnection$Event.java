// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            PushConnection

private static final class  extends Enum
{

    private static final READ_ERROR $VALUES[];
    public static final READ_ERROR CONNECTIVITY_CHANGED;
    public static final READ_ERROR KEEP_ALIVE_ERROR;
    public static final READ_ERROR READ_ERROR;
    public static final READ_ERROR START;
    public static final READ_ERROR STOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/parse/PushConnection$Event, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        START = new <init>("START", 0);
        STOP = new <init>("STOP", 1);
        CONNECTIVITY_CHANGED = new <init>("CONNECTIVITY_CHANGED", 2);
        KEEP_ALIVE_ERROR = new <init>("KEEP_ALIVE_ERROR", 3);
        READ_ERROR = new <init>("READ_ERROR", 4);
        $VALUES = (new .VALUES[] {
            START, STOP, CONNECTIVITY_CHANGED, KEEP_ALIVE_ERROR, READ_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
