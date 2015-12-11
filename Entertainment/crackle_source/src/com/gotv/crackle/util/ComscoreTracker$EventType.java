// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;


// Referenced classes of package com.gotv.crackle.util:
//            ComscoreTracker

private static final class  extends Enum
{

    private static final End $VALUES[];
    public static final End Buffer;
    public static final End End;
    public static final End Pause;
    public static final End Play;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/gotv/crackle/util/ComscoreTracker$EventType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Buffer = new <init>("Buffer", 0);
        Play = new <init>("Play", 1);
        Pause = new <init>("Pause", 2);
        End = new <init>("End", 3);
        $VALUES = (new .VALUES[] {
            Buffer, Play, Pause, End
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
