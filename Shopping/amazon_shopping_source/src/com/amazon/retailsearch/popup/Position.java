// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.popup;


public final class Position extends Enum
{

    private static final Position $VALUES[];
    public static final Position BELOW_CENTER;
    public static final Position BELOW_LEFT;

    private Position(String s, int i)
    {
        super(s, i);
    }

    public static Position valueOf(String s)
    {
        return (Position)Enum.valueOf(com/amazon/retailsearch/popup/Position, s);
    }

    public static Position[] values()
    {
        return (Position[])$VALUES.clone();
    }

    static 
    {
        BELOW_LEFT = new Position("BELOW_LEFT", 0);
        BELOW_CENTER = new Position("BELOW_CENTER", 1);
        $VALUES = (new Position[] {
            BELOW_LEFT, BELOW_CENTER
        });
    }
}
