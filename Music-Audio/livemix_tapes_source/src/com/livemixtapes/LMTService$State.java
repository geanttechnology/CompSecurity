// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;


// Referenced classes of package com.livemixtapes:
//            LMTService

static final class  extends Enum
{

    private static final Paused ENUM$VALUES[];
    public static final Paused Paused;
    public static final Paused Playing;
    public static final Paused Preparing;
    public static final Paused Retrieving;
    public static final Paused Stopped;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/livemixtapes/LMTService$State, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        Retrieving = new <init>("Retrieving", 0);
        Stopped = new <init>("Stopped", 1);
        Preparing = new <init>("Preparing", 2);
        Playing = new <init>("Playing", 3);
        Paused = new <init>("Paused", 4);
        ENUM$VALUES = (new ENUM.VALUES[] {
            Retrieving, Stopped, Preparing, Playing, Paused
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
