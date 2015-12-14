// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input;


public final class TouchResponse extends Enum
{

    private static final TouchResponse $VALUES[];
    public static final TouchResponse ACCEPT;
    public static final TouchResponse REJECT;
    public static final TouchResponse UNDEFINED;

    private TouchResponse(String s, int i)
    {
        super(s, i);
    }

    public static TouchResponse valueOf(String s)
    {
        return (TouchResponse)Enum.valueOf(com/socialin/android/brushlib/input/TouchResponse, s);
    }

    public static TouchResponse[] values()
    {
        return (TouchResponse[])$VALUES.clone();
    }

    static 
    {
        ACCEPT = new TouchResponse("ACCEPT", 0);
        REJECT = new TouchResponse("REJECT", 1);
        UNDEFINED = new TouchResponse("UNDEFINED", 2);
        $VALUES = (new TouchResponse[] {
            ACCEPT, REJECT, UNDEFINED
        });
    }
}
