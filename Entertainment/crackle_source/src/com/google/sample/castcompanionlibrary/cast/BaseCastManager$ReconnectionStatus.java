// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;


// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

public static final class  extends Enum
{

    private static final INACTIVE $VALUES[];
    public static final INACTIVE FINALIZE;
    public static final INACTIVE INACTIVE;
    public static final INACTIVE IN_PROGRESS;
    public static final INACTIVE STARTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/sample/castcompanionlibrary/cast/BaseCastManager$ReconnectionStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STARTED = new <init>("STARTED", 0);
        IN_PROGRESS = new <init>("IN_PROGRESS", 1);
        FINALIZE = new <init>("FINALIZE", 2);
        INACTIVE = new <init>("INACTIVE", 3);
        $VALUES = (new .VALUES[] {
            STARTED, IN_PROGRESS, FINALIZE, INACTIVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
