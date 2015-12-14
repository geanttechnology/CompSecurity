// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;


// Referenced classes of package com.livemixtapes:
//            LMTService

static final class  extends Enum
{

    private static final Focused ENUM$VALUES[];
    public static final Focused Focused;
    public static final Focused NoFocusCanDuck;
    public static final Focused NoFocusNoDuck;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/livemixtapes/LMTService$AudioFocus, s);
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
        NoFocusNoDuck = new <init>("NoFocusNoDuck", 0);
        NoFocusCanDuck = new <init>("NoFocusCanDuck", 1);
        Focused = new <init>("Focused", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            NoFocusNoDuck, NoFocusCanDuck, Focused
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
