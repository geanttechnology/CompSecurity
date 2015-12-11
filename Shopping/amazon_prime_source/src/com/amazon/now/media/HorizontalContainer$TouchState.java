// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;


// Referenced classes of package com.amazon.now.media:
//            HorizontalContainer

static final class stateValue extends Enum
{

    private static final SCROLL $VALUES[];
    public static final SCROLL NO_MOVE;
    public static final SCROLL SCROLL;
    int stateValue;

    public static stateValue valueOf(String s)
    {
        return (stateValue)Enum.valueOf(com/amazon/now/media/HorizontalContainer$TouchState, s);
    }

    public static stateValue[] values()
    {
        return (stateValue[])$VALUES.clone();
    }

    static 
    {
        NO_MOVE = new <init>("NO_MOVE", 0, 0);
        SCROLL = new <init>("SCROLL", 1, 1);
        $VALUES = (new .VALUES[] {
            NO_MOVE, SCROLL
        });
    }

    private _cls9(String s, int i, int j)
    {
        super(s, i);
        stateValue = j;
    }
}
