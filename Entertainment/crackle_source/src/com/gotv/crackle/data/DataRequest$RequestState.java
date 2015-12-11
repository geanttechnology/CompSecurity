// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;


// Referenced classes of package com.gotv.crackle.data:
//            DataRequest

public static final class  extends Enum
{

    private static final FAILED $VALUES[];
    public static final FAILED COMPLETE;
    public static final FAILED FAILED;
    public static final FAILED IDLE;
    public static final FAILED RUNNING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/gotv/crackle/data/DataRequest$RequestState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        RUNNING = new <init>("RUNNING", 1);
        COMPLETE = new <init>("COMPLETE", 2);
        FAILED = new <init>("FAILED", 3);
        $VALUES = (new .VALUES[] {
            IDLE, RUNNING, COMPLETE, FAILED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
