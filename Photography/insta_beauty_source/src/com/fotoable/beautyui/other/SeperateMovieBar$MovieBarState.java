// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;


public final class  extends Enum
{

    private static final STATE_PREPARE_DELETE $VALUES[];
    public static final STATE_PREPARE_DELETE STATE_CAPTURING;
    public static final STATE_PREPARE_DELETE STATE_PREPARE_DELETE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/other/SeperateMovieBar$MovieBarState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STATE_CAPTURING = new <init>("STATE_CAPTURING", 0);
        STATE_PREPARE_DELETE = new <init>("STATE_PREPARE_DELETE", 1);
        $VALUES = (new .VALUES[] {
            STATE_CAPTURING, STATE_PREPARE_DELETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
