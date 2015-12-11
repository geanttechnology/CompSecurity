// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;


// Referenced classes of package com.pointinside.model:
//            Venue

private static final class  extends Enum
{

    private static final PREV $VALUES[];
    public static final PREV NEXT;
    public static final PREV PREV;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/model/Venue$ZoneIterator$Move, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NEXT = new <init>("NEXT", 0);
        PREV = new <init>("PREV", 1);
        $VALUES = (new .VALUES[] {
            NEXT, PREV
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
