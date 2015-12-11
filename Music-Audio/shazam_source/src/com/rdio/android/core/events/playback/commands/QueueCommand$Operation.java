// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback.commands;


// Referenced classes of package com.rdio.android.core.events.playback.commands:
//            QueueCommand

public static final class  extends Enum
{

    private static final Move $VALUES[];
    public static final Move Add;
    public static final Move Move;
    public static final Move Remove;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/events/playback/commands/QueueCommand$Operation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Add = new <init>("Add", 0);
        Remove = new <init>("Remove", 1);
        Move = new <init>("Move", 2);
        $VALUES = (new .VALUES[] {
            Add, Remove, Move
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
