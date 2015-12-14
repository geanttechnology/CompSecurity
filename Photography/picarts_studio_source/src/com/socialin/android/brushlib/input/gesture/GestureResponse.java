// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;


public final class GestureResponse extends Enum
{

    private static final GestureResponse $VALUES[];
    public static final GestureResponse ACCEPT;
    public static final GestureResponse REJECT;

    private GestureResponse(String s, int i)
    {
        super(s, i);
    }

    public static GestureResponse valueOf(String s)
    {
        return (GestureResponse)Enum.valueOf(com/socialin/android/brushlib/input/gesture/GestureResponse, s);
    }

    public static GestureResponse[] values()
    {
        return (GestureResponse[])$VALUES.clone();
    }

    static 
    {
        ACCEPT = new GestureResponse("ACCEPT", 0);
        REJECT = new GestureResponse("REJECT", 1);
        $VALUES = (new GestureResponse[] {
            ACCEPT, REJECT
        });
    }
}
